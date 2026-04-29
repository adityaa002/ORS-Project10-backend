package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.PrescriptionDTO;
import com.rays.form.PrescriptionForm;
import com.rays.service.PrescriptionServiceInt;

/**
 * Controller for handling prescription-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality for
 * {@link PrescriptionDTO}. Provides an additional endpoint for
 * preloading prescription data, typically used for dropdowns or
 * initializing UI components.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "Prescription")
public class PrescriptionCtl extends BaseCtl<PrescriptionForm, PrescriptionDTO, PrescriptionServiceInt> {
    
    @Autowired
    public PrescriptionServiceInt prescriptionService;

    /**
     * Preloads prescription data for UI dropdowns.
     * <p>
     * Retrieves prescription entries from the service layer and returns them
     * as part of the {@link ORSResponse}.
     * </p>
     *
     * @return ORSResponse containing prescription list
     */
    @GetMapping(value = "preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        PrescriptionDTO dto = new PrescriptionDTO();
        List<PrescriptionDTO> prescripList = prescriptionService.search(dto, userContext);
        res.addResult("prescripList", prescripList);
        return res;
    }
}
