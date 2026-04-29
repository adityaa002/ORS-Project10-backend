package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;

/**
 * Controller for handling role-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality for
 * {@link RoleDTO}. Provides an additional endpoint for preloading
 * role data, typically used for dropdowns or initializing UI components.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleForm, RoleDTO, RoleServiceInt> {

    @Autowired
    RoleServiceInt roleService = null;

    /**
     * Preloads role data for UI dropdowns.
     * <p>
     * Retrieves role entries from the service layer and returns them
     * as part of the {@link ORSResponse}.
     * </p>
     *
     * @return ORSResponse containing role list
     */
    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        UserContext uc = UserContextHolder.getContext();

        RoleDTO dto = new RoleDTO();
        List<RoleDTO> roleList = roleService.search(dto, userContext);

        res.addResult("roleList", roleList);
        return res;
    }
}
