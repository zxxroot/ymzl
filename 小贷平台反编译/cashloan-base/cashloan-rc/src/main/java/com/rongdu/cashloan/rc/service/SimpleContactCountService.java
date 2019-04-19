package com.rongdu.cashloan.rc.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.SimpleContactCount;

public abstract interface SimpleContactCountService
  extends BaseService<SimpleContactCount, Long>
{
  public abstract int countOne(long paramLong);
}
