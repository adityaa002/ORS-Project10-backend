package com.rays.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.DecryptionDTO;
import com.rays.form.DecryptionForm;
import com.rays.service.DecryptionServiceInt;

/**
 * Decryption Controller Class
 *
 * <p>
 * Handles REST API requests for Decryption module.
 * Provides preload endpoint and inherits common CRUD operations
 * from {@link BaseCtl}.
 * </p>
 *
 * <b>Endpoint:</b>
 * <ul>
 *   <li>/Decryption/preload - Load decryption data</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Decryption")
public class DecryptionCtl extends BaseCtl<DecryptionForm, DecryptionDTO, DecryptionServiceInt> {

	/**
	 * Service layer for Decryption operations
	 */
	@Autowired
	public DecryptionServiceInt decryptionService;

	/**
	 * Preloads decryption data.
	 *
	 * @return ORSResponse containing list of DecryptionDTO
	 */
	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		DecryptionDTO dto = new DecryptionDTO();

		List<DecryptionDTO> decryptionList = decryptionService.search(dto, userContext);

		res.addResult("decryptionList", decryptionList);
		res.setSuccess(true);
		return res;

	}

}