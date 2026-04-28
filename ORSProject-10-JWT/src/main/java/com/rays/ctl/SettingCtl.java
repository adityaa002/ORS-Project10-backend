package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.SettingDTO;
import com.rays.form.SettingForm;
import com.rays.service.SettingServiceInt;

@RestController
@RequestMapping(value = "Setting")
public class SettingCtl extends BaseCtl<SettingForm, SettingDTO, SettingServiceInt> {

	@Autowired
    SettingServiceInt settingService = null;

	@GetMapping("/preload")
	public ORSResponse save() {

		ORSResponse res = new ORSResponse(true);
		SettingDTO dto = new SettingDTO();

		List<SettingDTO> settingList = settingService.search(dto, userContext);

		res.addResult("settingList", settingList);

		return res;
		
	}

}
