package com.rongdu.cashloan.rc.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.SimpleVoicesCount;

public abstract interface SimpleVoicesCountService
  extends BaseService<SimpleVoicesCount, Long>
{
  public abstract int countOne(long paramLong);
  
  public abstract SimpleVoicesCount findByUserId(long paramLong);
}
