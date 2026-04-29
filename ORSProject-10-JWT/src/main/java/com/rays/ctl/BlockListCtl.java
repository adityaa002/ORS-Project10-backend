package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.BlockListDTO;
import com.rays.form.BlockListForm;
import com.rays.service.BlockListServiceInt;

/**
 * BlockList Controller Class
 *
 * <p>
 * This controller handles REST API requests related to BlockList module.
 * It provides endpoint for preload and inherits common CRUD operations
 * from {@link BaseCtl}.
 * </p>
 *
 * <b>Endpoint:</b>
 * <ul>
 *   <li>/BlockList/preload - Load block list data</li>
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
@RequestMapping(value = "/BlockList")
public class BlockListCtl extends BaseCtl<BlockListForm, BlockListDTO, BlockListServiceInt> {

	/**
	 * Service layer for BlockList operations
	 */
	@Autowired
	public BlockListServiceInt blockListService;

	/**
	 * Preloads block list data.
	 *
	 * @return ORSResponse containing list of BlockListDTO
	 */
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		BlockListDTO dto = new BlockListDTO();
		List<BlockListDTO> blocklist = blockListService.search(dto, userContext);
		res.addResult("blockList", blocklist);
		return res;
	}
}