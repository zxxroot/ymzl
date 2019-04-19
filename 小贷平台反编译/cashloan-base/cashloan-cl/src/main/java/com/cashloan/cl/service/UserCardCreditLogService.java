package com.cashloan.cl.service;

import com.cashloan.cl.domain.UserCardCreditLog;
import com.rongdu.cashloan.core.common.service.BaseService;

public abstract interface UserCardCreditLogService
  extends BaseService<UserCardCreditLog, Long>
{
  public abstract boolean isCanCredit(Long paramLong);
}
