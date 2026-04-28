package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.CacheDTO;
import com.rays.form.CacheForm;
import com.rays.service.CacheServiceInt;

@RestController
@RequestMapping(value = "/Cache")
public class CacheCtl extends BaseCtl<CacheForm, CacheDTO, CacheServiceInt> {

	@Autowired
	public CacheServiceInt cacheService;

	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		UserContext uc = UserContextHolder.getContext();

		CacheDTO dto = new CacheDTO();

		List<DropdownList> cacheList = cacheService.search(dto, uc);

		res.addResult("cacheList", cacheList);

		return res;

	}

}
