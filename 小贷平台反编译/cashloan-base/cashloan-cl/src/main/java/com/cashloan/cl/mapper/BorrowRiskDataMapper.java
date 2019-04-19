package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.BorrowRiskData;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface BorrowRiskDataMapper
  extends BaseMapper<BorrowRiskData, Long>
{}
