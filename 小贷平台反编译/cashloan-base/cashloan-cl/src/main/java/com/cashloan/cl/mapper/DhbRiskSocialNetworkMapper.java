package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.DhbRiskSocialNetwork;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface DhbRiskSocialNetworkMapper
  extends BaseMapper<DhbRiskSocialNetwork, Long>
{
  public abstract void deleteByUserId(long paramLong);
}
