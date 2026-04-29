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

/**
 * Audit Controller Class
 *
 * <p>
 * This controller handles all REST API requests related to Audit module.
 * It provides endpoint for preload and inherits common CRUD operations
 * from {@link BaseCtl}.
 * </p>
 *
 * <b>Endpoint:</b>
 * <ul>
 *   <li>/Audit/preload - Load audit data</li>
 * </ul>
 *
 * <b>Responsibilities:</b>
 * <ul>
 *   <li>Handle HTTP requests</li>
 *   <li>Delegate processing to service layer</li>
 *   <li>Return response using ORSResponse</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Audit")
public class AuditCtl extends BaseCtl<AuditForm, AuditDTO, AuditServiceInt> {

	/**
	 * Service layer for Audit operations
	 */
	@Autowired
	AuditServiceInt auditService;
	
	/**
	 * Preloads audit data.
	 *
	 * @return ORSResponse containing list of AuditDTO
	 */
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