package com.rongdu.cashloan.rc.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.SimpleBorrowCount;

public abstract interface SimpleBorrowCountService
  extends BaseService<SimpleBorrowCount, Long>
{
  public abstract int countOne(long paramLong);
}
