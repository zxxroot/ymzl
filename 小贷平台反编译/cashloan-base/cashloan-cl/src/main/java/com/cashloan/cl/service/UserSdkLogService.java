package com.cashloan.cl.service;

import com.cashloan.cl.domain.UserSdkLog;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface UserSdkLogService
  extends BaseService<UserSdkLog, Long>
{
  public abstract Map<String, Object> countDayTime(Map<String, Object> paramMap);
  
  public abstract int save(UserSdkLog paramUserSdkLog);
}
