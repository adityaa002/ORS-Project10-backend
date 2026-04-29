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
import com.rays.dto.TimeTableDTO;
import com.rays.form.TimeTableForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;
import com.rays.service.TimeTableServiceInt;

/**
 * Controller for handling timetable-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality for
 * {@link TimeTableDTO}. Provides an additional endpoint for preloading
 * subject and course data, typically used for dropdowns or initializing
 * UI components when creating or managing timetables.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "TimeTable")
public class TimeTableCtl extends BaseCtl<TimeTableForm, TimeTableDTO, TimeTableServiceInt> {

    @Autowired
    private SubjectServiceInt subjectServiceInt = null;

    @Autowired
    private CourseServiceInt courseServiceInt = null;

    /**
     * Preloads subject and course data for UI dropdowns.
     * <p>
     * Retrieves subject and course entries from the service layer and returns them
     * as part of the {@link ORSResponse}.
     * </p>
     *
     * @return ORSResponse containing subject and course lists
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        List<SubjectDTO> list = subjectServiceInt.search(new SubjectDTO(), userContext);
        List<CourseDTO> list1 = courseServiceInt.search(new CourseDTO(), userContext);

        res.addResult("subjectList", list);
        res.addResult("courseList", list1);

        return res;
    }
}
