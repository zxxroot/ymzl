package com.rongdu.cashloan.system.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.system.domain.CheckAppVersion;
import java.util.Map;

public abstract interface CheckAppVersionService
  extends BaseService<CheckAppVersion, Long>
{
  public abstract CheckAppVersion checkAppVersion(String paramString);
  
  public abstract Page<CheckAppVersion> getPageList(int paramInt1, int paramInt2, Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\CheckAppVersionService.class

 */