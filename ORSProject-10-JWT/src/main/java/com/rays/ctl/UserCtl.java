package com.rays.ctl;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.form.ChangePasswordForm;
import com.rays.form.MyProfileForm;
import com.rays.form.UserForm;
import com.rays.service.AttachmentServiceInt;
import com.rays.service.RoleServiceInt;
import com.rays.service.UserServiceInt;

/**
 * User Controller Class
 *
 * <p>
 * Handles REST API requests for User module.
 * Provides operations like profile management, profile picture upload/download,
 * password change, and preload data.
 * Also inherits common CRUD operations from {@link BaseCtl}.
 * </p>
 *
 * <b>Endpoints:</b>
 * <ul>
 *   <li>/User/preload - Load role list</li>
 *   <li>/User/myProfile - Update user profile</li>
 *   <li>/User/profilePic/{userId} - Upload/Download profile picture</li>
 *   <li>/User/changePassword - Change user password</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

	/**
	 * Service for Role operations
	 */
	@Autowired
	RoleServiceInt roleService = null;

	/**
	 * Service for Attachment operations (profile picture)
	 */
	@Autowired
	AttachmentServiceInt attachmentService;

	/**
	 * Preloads role list for dropdown.
	 *
	 * @return ORSResponse containing list of roles
	 */
	@GetMapping("preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse();
		RoleDTO dto = new RoleDTO();
		List<DropdownList> list = roleService.search(dto, userContext);
		res.addResult("roleList", list);
		return res;

	}

	/**
	 * Updates logged-in user's profile.
	 *
	 * @param form          profile form
	 * @param bindingResult validation result
	 * @return ORSResponse with status message
	 */
	@PostMapping("myProfile")
	public ORSResponse myProfile(@RequestBody @Valid MyProfileForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.findById(userContext.getUserId(), userContext);
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setDob(form.getDob());
		dto.setPhone(form.getPhone());
		dto.setGender(form.getGender());

		baseService.update(dto, userContext);

		res.setSuccess(true);
		res.addMessage("Your Profile updated successfully..!!");

		return res;
	}

	/**
	 * Uploads profile picture for user.
	 *
	 * @param userId user ID
	 * @param file   uploaded file
	 * @param req    HttpServletRequest
	 * @return ORSResponse containing imageId
	 */
	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		AttachmentDTO attachmentDto = new AttachmentDTO(file);

		attachmentDto.setDescription("profile pic");
		attachmentDto.setUserId(userId);

		UserDTO userDto = baseService.findById(userId, userContext);

		if (userDto.getImageId() != null && userDto.getImageId() > 0) {
			attachmentDto.setId(userDto.getImageId());
		}

		Long imageId = attachmentService.save(attachmentDto, userContext);

		if (userDto.getImageId() == null) {
			userDto.setImageId(imageId);
			baseService.update(userDto, userContext);
		}

		ORSResponse res = new ORSResponse();
		res.addResult("imageId", imageId);

		return res;
	}

	/**
	 * Downloads profile picture for user.
	 *
	 * @param userId   user ID
	 * @param response HttpServletResponse
	 */
	@GetMapping("/profilePic/{userId}")
	public void downloadPic(@PathVariable Long userId, HttpServletResponse response) {

		try {

			UserDTO userDto = baseService.findById(userId, userContext);
			AttachmentDTO attachmentDTO = null;

			if (userDto != null) {
				attachmentDTO = attachmentService.findById(userDto.getImageId(), userContext);
			}

			if (attachmentDTO != null) {
				response.setContentType(attachmentDTO.getType());
				OutputStream out = response.getOutputStream();
				out.write(attachmentDTO.getDoc());
				out.close();
			} else {
				response.getWriter().write("ERROR: File not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Changes user password.
	 *
	 * @param form ChangePasswordForm
	 * @return ORSResponse with status message
	 */
	@PostMapping("changePassword")
	public ORSResponse changePassword(@RequestBody @Valid ChangePasswordForm form) {
		ORSResponse res = new ORSResponse(true);

		boolean flag = baseService.changePassword(
				form.getLoginId(),
				form.getOldPassword(),
				form.getNewPassword(),
				userContext
		);

		if (!flag) {
			res.setSuccess(false);
			res.addMessage("enter correct old password..!");
		} else {
			res.setSuccess(true);
			res.addMessage("Password changed successfully...!");
		}
		return res;

	}
}