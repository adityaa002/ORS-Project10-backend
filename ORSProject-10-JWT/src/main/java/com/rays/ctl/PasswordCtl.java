package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.PasswordDTO;
 import com.rays.form.PasswordForm;
import com.rays.service.PasswordServiceInt;


@RestController
@RequestMapping(value = "Password")
public class PasswordCtl extends BaseCtl<PasswordForm, PasswordDTO, PasswordServiceInt> {

	@Autowired
	public PasswordServiceInt passwordService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		UserContext uc = UserContextHolder.getContext();

		PasswordDTO dto = new PasswordDTO();
		List<PasswordDTO> passwordList = passwordService.search(dto, userContext);

		res.addResult("passwordList", passwordList);
		return res;
	}
}
