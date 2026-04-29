package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.SubjectForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * Controller for handling subject-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality for
 * {@link SubjectDTO}. Provides an additional endpoint for preloading
 * course data, typically used for dropdowns or initializing UI components
 * when creating or managing subjects.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "Subject")
public class SubjectCtl extends BaseCtl<SubjectForm, SubjectDTO, SubjectServiceInt> {

    @Autowired
    private CourseServiceInt courseServiceInt = null;

    /**
     * Preloads course data for UI dropdowns.
     * <p>
     * Retrieves course entries from the service layer and returns them
     * as part of the {@link ORSResponse}.
     * </p>
     *
     * @return ORSResponse containing course list
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        List<CourseDTO> list = courseServiceInt.search(new CourseDTO(), userContext);
        res.addResult("courseList", list);

        return res;
    }
}
