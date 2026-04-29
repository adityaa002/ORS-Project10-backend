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
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.FacultyForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.CourseServiceInt;
import com.rays.service.FacultyServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * Faculty Controller Class
 *
 * <p>
 * Handles REST API requests for Faculty module.
 * Provides preload data required for UI dropdowns such as
 * Course, Subject, and College.
 * Also inherits common CRUD operations from {@link BaseCtl}.
 * </p>
 *
 * <b>Endpoint:</b>
 * <ul>
 *   <li>/Faculty/preload - Load dropdown data (course, subject, college)</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Faculty")
public class FacultyCtl extends BaseCtl<FacultyForm, FacultyDTO, FacultyServiceInt> {

	/**
	 * Service for Course operations
	 */
	@Autowired
	private CourseServiceInt courseService;

	/**
	 * Service for Subject operations
	 */
	@Autowired
	private SubjectServiceInt subjectService;

	/**
	 * Service for College operations
	 */
	@Autowired
	private CollegeServiceInt collegeService;

	/**
	 * Preloads dropdown data for Faculty module.
	 *
	 * @return ORSResponse containing courseList, subjectList, and collegeList
	 */
	@GetMapping("preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		List<DropdownList> courseList = courseService.search(new CourseDTO(), userContext);
		List<DropdownList> subjectList = subjectService.search(new SubjectDTO(), userContext);
		List<DropdownList> collegeList = collegeService.search(new CollegeDTO(), userContext);

		res.addResult("courseList", courseList);
		res.addResult("subjectList", subjectList);
		res.addResult("collegeList", collegeList);

		return res;

	}
}