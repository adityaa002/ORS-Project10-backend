package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.RuleDTO;
import com.rays.form.RuleForm;
import com.rays.service.RuleServiceInt;

@RestController
@RequestMapping(value = "/Rule")
public class RuleCtl extends BaseCtl<RuleForm, RuleDTO, RuleServiceInt> {

	@Autowired
	public RuleServiceInt ruleService;

	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		RuleDTO dto = new RuleDTO();

		List<RuleDTO> trigger = ruleService.search(dto, userContext);

		res.addResult("trigger", trigger);

		return res;

	}

}
