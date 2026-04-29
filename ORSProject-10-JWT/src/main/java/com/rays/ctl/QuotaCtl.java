package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.QuotaDTO;
import com.rays.dto.RoleDTO;
import com.rays.form.QuotaForm;
import com.rays.service.QuotaServiceInt;

/**
 * Quota Controller Class
 *
 * <p>
 * Handles REST API requests for Quota module.
 * Provides preload endpoint and inherits common CRUD operations
 * from {@link BaseCtl}.
 * </p>
 *
 * <b>Endpoint:</b>
 * <ul>
 *   <li>/Quota/preload - Load quota data</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Quota")
public class QuotaCtl extends BaseCtl<QuotaForm, QuotaDTO, QuotaServiceInt> {

	/**
	 * Service layer for Quota operations
	 */
	public QuotaServiceInt quotaService;

	/**
	 * Preloads quota data using UserContext from ThreadLocal.
	 *
	 * @return ORSResponse containing list of QuotaDTO
	 */
	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		UserContext uc = UserContextHolder.getContext();

		QuotaDTO dto = new QuotaDTO();
		List<QuotaDTO> quotaList = quotaService.search(dto, uc);
		res.addResult("quotaList", quotaList);

		return res;

	}
}