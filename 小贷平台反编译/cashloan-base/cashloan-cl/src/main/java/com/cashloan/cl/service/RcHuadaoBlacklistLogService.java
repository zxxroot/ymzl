package com.cashloan.cl.service;

import com.cashloan.cl.domain.RcHuadaoBlacklistLog;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import java.util.List;
import java.util.Map;

public abstract interface RcHuadaoBlacklistLogService
  extends BaseService<RcHuadaoBlacklistLog, Long>
{
  public abstract int queryHuadaoBlackList(Long paramLong, TppBusiness paramTppBusiness);
  
  public abstract int queryHuadaoBlackList(String paramString, TppBusiness paramTppBusiness);
  
  public abstract void deleteByUserId(Long paramLong);
  
  public abstract void deleteByPhone(String paramString);
  
  public abstract List<RcHuadaoBlacklistLog> listService(Map<String, Object> paramMap);
  
  public abstract boolean isBlack(Long paramLong);
}


/*RcHuadaoBlacklistLogService.class

 */