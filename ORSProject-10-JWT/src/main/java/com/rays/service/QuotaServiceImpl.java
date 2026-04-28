package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.QuotaDAOInt;
import com.rays.dto.QuotaDTO;

@Service
public class QuotaServiceImpl extends BaseServiceImpl<QuotaDTO, QuotaDAOInt> implements QuotaServiceInt {

}
