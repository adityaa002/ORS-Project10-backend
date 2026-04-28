package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SettingDAOInt;
import com.rays.dto.SettingDTO;

@Service
@Transactional
public class SettingServiceImpl extends BaseServiceImpl<SettingDTO, SettingDAOInt> implements SettingServiceInt {

}
