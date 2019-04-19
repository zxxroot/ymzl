package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.UserAuth;
import com.cashloan.cl.model.UserAuthModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface UserAuthService
  extends BaseService<UserAuth, Long>
{
  public abstract UserAuth getUserAuth(Map<String, Object> paramMap);
  
  public abstract Integer updateByUserId(Map<String, Object> paramMap);
  
  public abstract Page<UserAuthModel> listUserAuth(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract UserAuth findSelective(long paramLong);
  
  public abstract Map<String, Object> getAuthState(Map<String, Object> paramMap);
  
  public abstract int updatePhoneState(Map<String, Object> paramMap);
}
