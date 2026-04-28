package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.dto.AuditDTO;
import com.rays.form.AuditForm;
import com.rays.service.AuditServiceInt;

@RestController
@RequestMapping(value = "Audit")
public class AuditCtl extends BaseCtl<AuditForm, AuditDTO, AuditServiceInt> {

	@Autowired
	AuditServiceInt auditService;
	
	@GetMapping(value = "preload")
	public ORSResponse preload() {
		
		ORSResponse res = new ORSResponse(true);

		UserContext uc = new UserContext();
		
		AuditDTO dto = new AuditDTO();
		List<AuditDTO> auditlist = auditService.search(dto, userContext);
		
		res.setSuccess(true);
		res.addResult("auditlist", auditlist);
		return res;
	}
	
}
