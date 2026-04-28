package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.InquiryDAOInt;
import com.rays.dto.InquiryDTO;

@Service
 public class InquiryServiceImpl extends BaseServiceImpl<InquiryDTO, InquiryDAOInt> implements InquiryServiceInt {

}
