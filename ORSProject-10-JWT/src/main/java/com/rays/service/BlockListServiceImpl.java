package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BlockListDAOInt;
import com.rays.dto.BlockListDTO;

@Service
@Transactional
public class BlockListServiceImpl extends BaseServiceImpl<BlockListDTO, BlockListDAOInt>
		implements BlockListServiceInt {

}
