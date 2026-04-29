package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.StudentForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * Student Controller Class
 *
 * <p>
 * Handles REST API requests for Student module.
 * Provides preload endpoint for loading college data
 * and inherits common CRUD operations from {@link BaseCtl}.
 * </p>
 *
 * <b>Endpoint:</b>
 * <ul>
 *   <li>/Student/preload - Load college list for student form</li>
 * </ul>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Student")
public class StudentCtl extends BaseCtl<StudentForm, StudentDTO, StudentServiceInt> {

	/**
	 * Service for College operations
	 */
	@Autowired
	private CollegeServiceInt collegeService = null;

	/**
	 * Preloads college list for Student module.
	 *
	 * @return ORSResponse containing list of CollegeDTO
	 */
	@GetMapping("preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		List<CollegeDTO> list = collegeService.search(new CollegeDTO(), userContext);

		res.addResult("collegeList", list);
		return res;
	}
}