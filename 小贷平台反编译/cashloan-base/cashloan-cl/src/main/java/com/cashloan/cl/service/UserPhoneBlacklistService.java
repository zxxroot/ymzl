package com.cashloan.cl.service;

import com.cashloan.cl.domain.UserPhoneBlacklist;
import com.rongdu.cashloan.core.common.service.BaseService;

public abstract interface UserPhoneBlacklistService
  extends BaseService<UserPhoneBlacklist, Long>
{
  public abstract UserPhoneBlacklist getByPhone(String paramString);
}


/*UserPhoneBlacklistService.class

 */