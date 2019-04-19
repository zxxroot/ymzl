package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.OperatorTdTransactions;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface OperatorTdTransactionsMapper
  extends BaseMapper<OperatorTdTransactions, Long>
{
  public abstract void deleteByUserId(Long paramLong);
}
