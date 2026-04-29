package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.RuleDTO;
import com.rays.form.RuleForm;
import com.rays.service.RuleServiceInt;

/**
 * Controller for handling rule-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality for
 * {@link RuleDTO}. Provides an additional endpoint for preloading
 * rule data, typically used for dropdowns or initializing UI components.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/Rule")
public class RuleCtl extends BaseCtl<RuleForm, RuleDTO, RuleServiceInt> {

    @Autowired
    public RuleServiceInt ruleService;

    /**
     * Preloads rule data for UI dropdowns.
     * <p>
     * Retrieves rule entries from the service layer and returns them
     * as part of the {@link ORSResponse}.
     * </p>
     *
     * @return ORSResponse containing rule list
     */
    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        RuleDTO dto = new RuleDTO();
        List<RuleDTO> trigger = ruleService.search(dto, userContext);

        res.addResult("trigger", trigger);
        return res;
    }
}
