package com.rongdu.cashloan.core.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.model.ManagerUserModel;
import com.rongdu.cashloan.core.model.UserWorkInfoModel;
import java.util.List;
import java.util.Map;

public abstract interface UserBaseInfoService
  extends BaseService<UserBaseInfo, Long>
{
  public abstract List<UserBaseInfo> listSelective(Map<String, Object> paramMap);
  
  public abstract UserBaseInfo findByUserId(Long paramLong);
  
  public abstract UserBaseInfo findSelective(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> getDictsCache(String paramString);
  
  public abstract ManagerUserModel getBaseModelByUserId(Long paramLong);
  
  public abstract int updateState(long paramLong, String paramString);
  
  public abstract boolean updateSelective(Map<String, Object> paramMap);
  
  public abstract UserWorkInfoModel getWorkInfo(Long paramLong);
  
  public abstract List<String> getUnRepayPhone();
}
