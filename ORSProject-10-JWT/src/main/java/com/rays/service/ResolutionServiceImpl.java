package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ResolutionDAOInt;
import com.rays.dto.ResolutionDTO;


@Service
@Transactional
public class ResolutionServiceImpl extends BaseServiceImpl<ResolutionDTO, ResolutionDAOInt>
		implements ResolutionServiceInt {

}
