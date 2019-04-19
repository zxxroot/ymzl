package com.cashloan.cl.service;

import com.cashloan.cl.domain.QianChengBlacklistLog;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.TppBusiness;

public abstract interface QianChengBlacklistLogService
  extends BaseService<QianChengBlacklistLog, Long>
{
  public abstract int qianchengBlackRequest(Long paramLong, TppBusiness paramTppBusiness);
  
  public abstract void deleteByUserId(Long paramLong);
  
  public abstract boolean isBlack(Long paramLong);
}
