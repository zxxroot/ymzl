package com.rongdu.cashloan.rc.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.BorrowCount;

public abstract interface BorrowCountService
  extends BaseService<BorrowCount, Long>
{
  public abstract int save();
  
  public abstract int countBorrowRefusedTimes(Long paramLong);
}
