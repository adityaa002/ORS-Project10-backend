package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CourseDTO;
import com.rays.form.CourseForm;
import com.rays.service.CourseServiceInt;

/**
 * Course Controller Class
 *
 * <p>
 * Handles REST API requests for Course module.
 * Inherits common CRUD operations from {@link BaseCtl}.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Course")
public class CourseCtl extends BaseCtl<CourseForm, CourseDTO, CourseServiceInt> {

}