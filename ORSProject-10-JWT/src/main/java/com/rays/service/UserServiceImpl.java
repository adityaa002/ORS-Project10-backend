package com.rays.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;
import com.rays.exception.ApplicationException;
import com.rays.exception.DuplicateRecordException;
import com.rays.util.EmailBuilder;
import com.rays.util.EmailMessage;
import com.rays.util.EmailUtility;

import com.rays.exception.RecordNotFoundException;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDAOInt> implements UserServiceInt {

	@Transactional(readOnly = true)
	public UserDTO findByLoginId(String login, UserContext userContext) {
		return baseDao.findByUniqueKey("loginId", login, userContext);
	}

	@Transactional(readOnly = false)
	public UserDTO register(UserDTO dto, UserContext userContext) {
		Long id = add(dto, userContext);

		

		dto.setId(id);
		return dto;
	}

	public UserDTO authenticate(String loginId, String password) {
		UserDTO dto = findByLoginId(loginId, null);
		if (dto != null) {
			UserContext userContext = new UserContext(dto);
			if (password.equals(dto.getPassword())) {
				dto.setLastLogin(new Timestamp((new Date()).getTime()));
				dto.setUnsucessfullLoginAttempt(0);
				update(dto, userContext);
				return dto; // ← correct credentials → return dto
			} else {
				dto.setUnsucessfullLoginAttempt(1 + dto.getUnsucessfullLoginAttempt());
				update(dto, userContext);
				return null; // ← wrong password → return null
			}
		}
		return null; // ← user not found → return null
	}

	@Override
	public long register(UserDTO dto) {

		UserContext userContext = new UserContext(dto);

		long id = baseDao.add(dto, userContext);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLoginId());
		map.put("password", dto.getPassword());

		String message = EmailBuilder.getUserRegistrationMessage(map);

		EmailMessage msg = new EmailMessage();

		msg.setTo(dto.getLoginId());
		msg.setSubject("Registration is successful for Online Result System Project-10 RAYS Technologies");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);

		return id;
	}

	@Override
	public boolean changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext) {

		boolean flag = false;
		UserDTO dtoExist = null;

		dtoExist = findByLoginId(loginId, userContext);

		System.out.println("in method password" + dtoExist.getPassword() + "jjjjjjj" + oldPassword);

		if (dtoExist != null && dtoExist.getPassword().equals(oldPassword)) {

			dtoExist.setPassword(newPassword);

			try {

				baseDao.update(dtoExist, userContext);

			} catch (DuplicateRecordException e) {

				try {
					throw new ApplicationException("LoginId is already exist");
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			flag = true;
		} else {
			try {
				throw new RecordNotFoundException("Login not exist");
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("login", dtoExist.getLoginId());
		map.put("password", dtoExist.getPassword());
		map.put("firstName", dtoExist.getFirstName());
		map.put("lastName", dtoExist.getLastName());

		String message = EmailBuilder.getChangePasswordMessage(map);

		EmailMessage msg = new EmailMessage();

		msg.setTo(dtoExist.getLoginId());
		msg.setSubject("Password has been changed Successfully.");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);

		return flag;

	}

	@Override
	public UserDTO forgotPassword(String loginId) {

		UserDTO userData = findByLoginId(loginId, null);
		boolean flag = false;
		if (userData == null) {
			System.out.println("email id does not exist");
			try {
				throw new RecordNotFoundException("Email Id Does not matched.");
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", loginId);
		map.put("password", userData.getPassword());
		map.put("firstName", userData.getFirstName());
		map.put("lastName", userData.getLastName());
		String message = EmailBuilder.getForgetPasswordMessage(map);
		EmailMessage msg = new EmailMessage();
		msg.setTo(loginId);
		msg.setSubject("RAYS Online Result System Project-10 Password reset");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);
		EmailUtility.sendMail(msg);
		System.out.println(flag);
		flag = true;

		return userData;
	}
}
