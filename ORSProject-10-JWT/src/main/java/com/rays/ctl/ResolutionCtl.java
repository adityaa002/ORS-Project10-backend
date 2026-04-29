package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.ResolutionDTO;
import com.rays.form.ResolutionForm;
import com.rays.service.ResolutionServiceInt;

/**
 * Resolution Controller Class
 *
 * <p>
 * Handles REST API requests for Resolution module.
 * Provides preload endpoint and inherits common CRUD operations
 * from {@link BaseCtl}.
 * </p>
 *
 * <b>Endpoint:</b>
 * <ul>
 *   <li>/Resolution/preload - Load resolution data</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Resolution")
public class ResolutionCtl extends BaseCtl<ResolutionForm, ResolutionDTO, ResolutionServiceInt> {

	/**
	 * Service layer for Resolution operations
	 */
	@Autowired
	public ResolutionServiceInt resolutionService;

	/**
	 * Preloads resolution data.
	 *
	 * @return ORSResponse containing list of ResolutionDTO
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		ResolutionDTO dto = new ResolutionDTO();
		List<ResolutionDTO> resolutionList = resolutionService.search(dto, userContext);
		res.addResult("resolutionList", resolutionList);
		return res;
	}
}