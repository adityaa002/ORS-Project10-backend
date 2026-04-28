package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.DecryptionDAOInt;
import com.rays.dto.DecryptionDTO;

@Service
@Transactional
public class DecryptionServiceImpl extends BaseServiceImpl<DecryptionDTO, DecryptionDAOInt>
		implements DecryptionServiceInt{

}
