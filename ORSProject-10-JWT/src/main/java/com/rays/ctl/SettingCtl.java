package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.SettingDTO;
import com.rays.form.SettingForm;
import com.rays.service.SettingServiceInt;

/**
 * Controller for handling application setting-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality for
 * {@link SettingDTO}. Provides an additional endpoint for preloading
 * settings, typically used for dropdowns or initializing UI components.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "Setting")
public class SettingCtl extends BaseCtl<SettingForm, SettingDTO, SettingServiceInt> {

    @Autowired
    SettingServiceInt settingService = null;

    /**
     * Preloads application settings for UI dropdowns.
     * <p>
     * Retrieves setting entries from the service layer and returns them
     * as part of the {@link ORSResponse}.
     * </p>
     *
     * @return ORSResponse containing setting list
     */
    @GetMapping("/preload")
    public ORSResponse save() {
        ORSResponse res = new ORSResponse(true);
        SettingDTO dto = new SettingDTO();

        List<SettingDTO> settingList = settingService.search(dto, userContext);
        res.addResult("settingList", settingList);

        return res;
    }
}
