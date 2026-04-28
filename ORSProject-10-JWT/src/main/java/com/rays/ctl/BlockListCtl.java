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

@RestController
@RequestMapping(value = "/BlockList")
public class BlockListCtl extends BaseCtl<BlockListForm, BlockListDTO, BlockListServiceInt> {

	@Autowired
	public BlockListServiceInt blockListService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		BlockListDTO dto = new BlockListDTO();
		List<BlockListDTO> blocklist = blockListService.search(dto, userContext);
		res.addResult("blockList", blocklist);
		return res;
	}
}
