package com.rongdu.cashloan.core.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.core.domain.UserOtherInfo;

@RDBatisDao
public abstract interface UserOtherInfoMapper
  extends BaseMapper<UserOtherInfo, Long>
{}
