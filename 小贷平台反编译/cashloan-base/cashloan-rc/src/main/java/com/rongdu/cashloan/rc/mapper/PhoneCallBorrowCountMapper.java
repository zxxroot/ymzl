package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.PhoneCallBorrowCount;

@RDBatisDao
public abstract interface PhoneCallBorrowCountMapper
  extends BaseMapper<PhoneCallBorrowCount, Long>
{}
