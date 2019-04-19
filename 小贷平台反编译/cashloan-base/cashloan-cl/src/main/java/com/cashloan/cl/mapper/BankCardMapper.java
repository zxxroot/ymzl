package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.BankCard;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface BankCardMapper
  extends BaseMapper<BankCard, Long>
{}
