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

/**
 * Controller for handling cache-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality and provides
 * additional endpoints for cache management. Specifically, it supports
 * preloading cache data for dropdowns or UI initialization.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/Cache")
public class CacheCtl extends BaseCtl<CacheForm, CacheDTO, CacheServiceInt> {

    @Autowired
    public CacheServiceInt cacheService;

    /**
     * Preloads cache data for UI dropdowns.
     * <p>
     * Retrieves cache entries from the service layer and returns them
     * as part of the {@link ORSResponse}. This is typically used to
     * initialize dropdown lists or pre-populate UI components.
     * </p>
     *
     * @return ORSResponse containing cache list
     */
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
