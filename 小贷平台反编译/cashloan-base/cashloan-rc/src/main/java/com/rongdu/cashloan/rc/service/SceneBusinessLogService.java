package com.rongdu.cashloan.rc.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.SceneBusinessLog;

public abstract interface SceneBusinessLogService
  extends BaseService<SceneBusinessLog, Long>
{
  public abstract boolean haveNeedExcuteService(SceneBusinessLog paramSceneBusinessLog);
  
  public abstract boolean needExcute(Long paramLong1, Long paramLong2, String paramString1, String paramString2);
  
  public abstract boolean needExcute(String paramString1, Long paramLong, String paramString2, String paramString3);
}
