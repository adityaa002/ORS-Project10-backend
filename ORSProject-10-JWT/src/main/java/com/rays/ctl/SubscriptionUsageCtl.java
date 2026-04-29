package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.SubscriptionUsageDTO;
import com.rays.form.SubscriptionUsageForm;
import com.rays.service.SubscriptionUsageServiceInt;

/**
 * Controller for handling subscription usage operations.
 * <p>
 * Extends {@link BaseCtl} to inherit common CRUD functionality for
 * {@link SubscriptionUsageDTO}. This controller provides endpoints
 * for managing subscription usage records in the system.
 * </p>
 *
 * <p>
 * Since it extends {@link BaseCtl}, all standard operations such as
 * add, update, delete, search, and preload are automatically available.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
@RestController
@RequestMapping(value = "SubscriptionUsage")
public class SubscriptionUsageCtl
        extends BaseCtl<SubscriptionUsageForm, SubscriptionUsageDTO, SubscriptionUsageServiceInt> {

}
