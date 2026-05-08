package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PasswordDAOInt;
import com.rays.dto.PasswordDTO;

@Service
@Transactional
public class PasswordServiceImpl extends BaseServiceImpl<PasswordDTO, PasswordDAOInt> implements PasswordServiceInt {
 
}
