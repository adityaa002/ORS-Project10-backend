package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.InquiryDTO;
import com.rays.form.InquiryForm;
import com.rays.service.InquiryServiceInt;
import com.rays.service.UserServiceInt;

/**
 * Inquiry Controller Class
 *
 * <p>
 * Handles REST API requests for Inquiry module.
 * Inherits common CRUD operations from {@link BaseCtl}.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 * @since 2026
 */
@RestController
@RequestMapping(value = "Inquiry")
public class InquiryCtl extends BaseCtl<InquiryForm, InquiryDTO, InquiryServiceInt> {

}