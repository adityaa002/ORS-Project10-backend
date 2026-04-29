package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * Controller for handling marksheet-related operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality for
 * {@link MarksheetDTO}. Provides additional endpoints for preloading
 * student data, retrieving marksheet by roll number, and generating
 * merit lists.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "Marksheet")
public class MarksheetCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

    @Autowired
    private StudentServiceInt studentService = null;

    /**
     * Preloads student data for dropdowns.
     * <p>
     * Retrieves student list from the service layer and returns it
     * as part of the {@link ORSResponse}.
     * </p>
     *
     * @return ORSResponse containing student list
     */
    @GetMapping("preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);
        List<StudentDTO> studentList = studentService.search(new StudentDTO(), userContext);
        res.addResult("studentList", studentList);
        return res;
    }

    /**
     * Retrieves marksheet by roll number.
     *
     * @param rollNo roll number of the student
     * @return ORSResponse containing marksheet data or error message
     */
    @GetMapping("rollno/{rollNo}")
    public ORSResponse rollNo(@PathVariable String rollNo) {
        ORSResponse res = new ORSResponse(true);
        MarksheetDTO dto = baseService.findByRollNo(rollNo, userContext);
        if (dto != null) {
            res.addData(dto);
        } else {
            res.setSuccess(false);
            res.addMessage("Record not found");
        }
        return res;
    }

    /**
     * Retrieves merit list of students based on marksheet data.
     *
     * @return ORSResponse containing merit list
     */
    @GetMapping("meritlist")
    public ORSResponse getMeritList() {
        System.out.println("MarksheetMeritList API");
        List<MarksheetDTO> meritList = baseService.getMeritList(userContext);
        ORSResponse res = new ORSResponse(true);
        res.addResult("meritList", meritList);
        return res;
    }
}
