package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CacheDAOInt;
import com.rays.dto.CacheDTO;

@Service
@Transactional
public class CacheServiceImpl extends BaseServiceImpl<CacheDTO, CacheDAOInt> implements CacheServiceInt{

}
