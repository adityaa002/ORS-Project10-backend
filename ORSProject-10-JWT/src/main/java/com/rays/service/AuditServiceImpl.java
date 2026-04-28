package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AuditDAOInt;
import com.rays.dto.AuditDTO;

@Service
@Transactional
public class AuditServiceImpl extends BaseServiceImpl<AuditDTO, AuditDAOInt> implements AuditServiceInt {

}
