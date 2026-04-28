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
 
@RestController
@RequestMapping(value = "Resolution")
public class ResolutionCtl extends BaseCtl<ResolutionForm, ResolutionDTO, ResolutionServiceInt> {

	@Autowired
	public ResolutionServiceInt resolutionService;

	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		ResolutionDTO dto = new ResolutionDTO();
		List<ResolutionDTO> resolutionList = resolutionService.search(dto, userContext);
		res.addResult("resolutionList", resolutionList);
		return res;
	}
	
	

}
