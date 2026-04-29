package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.form.CollegeForm;
import com.rays.service.CollegeServiceInt;

/**
 * Controller for handling college-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality and provides
 * additional endpoints for college management. Specifically, it supports
 * preloading college data for dropdowns or UI initialization.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "College")
public class CollegeCtl extends BaseCtl<CollegeForm, CollegeDTO, CollegeServiceInt> {

    @Autowired
    private CollegeServiceInt collegeServiceInt = null;

    /**
     * Preloads college data for UI dropdowns.
     * <p>
     * Retrieves college entries from the service layer and returns them
     * as part of the {@link ORSResponse}. This is typically used to
     * initialize dropdown lists or pre-populate UI components.
     * </p>
     *
     * @return ORSResponse containing college list
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        CollegeDTO dto = new CollegeDTO();
        List<DropdownList> collegeList = collegeServiceInt.search(dto, userContext);

        res.addResult("collegeList", collegeList);
        return res;
    }
}
