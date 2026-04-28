package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.RuleDAOInt;
import com.rays.dto.RuleDTO;

@Service
@Transactional
public class RuleServiceImpl extends BaseServiceImpl<RuleDTO, RuleDAOInt> implements RuleServiceInt {

}
