package com.rongdu.cashloan.rc.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.TppReqLog;
import java.util.Map;

public abstract interface TppReqLogService
  extends BaseService<TppReqLog, Long>
{
  public abstract int modifyTppReqLog(TppReqLog paramTppReqLog);
  
  public abstract TppReqLog findSelective(Map<String, Object> paramMap);
}
