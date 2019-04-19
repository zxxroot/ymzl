package com.rongdu.cashloan.core.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.UserOtherInfo;
import java.util.Map;

public abstract interface UserOtherInfoService
  extends BaseService<UserOtherInfo, Long>
{
  public abstract UserOtherInfo getInfoByUserId(Long paramLong);
  
  public abstract boolean save(UserOtherInfo paramUserOtherInfo);
  
  public abstract boolean update(UserOtherInfo paramUserOtherInfo);
  
  public abstract boolean updateSelective(Map<String, Object> paramMap);
}
