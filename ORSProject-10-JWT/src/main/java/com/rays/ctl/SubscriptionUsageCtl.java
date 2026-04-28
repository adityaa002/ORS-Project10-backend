package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.SubscriptionUsageDTO;
import com.rays.form.SubscriptionUsageForm;
import com.rays.service.SubscriptionUsageServiceInt;

@RestController
@RequestMapping(value = "SubscriptionUsage")
public class SubscriptionUsageCtl
		extends BaseCtl<SubscriptionUsageForm, SubscriptionUsageDTO, SubscriptionUsageServiceInt> {

}
