package com.rongdu.cashloan.core.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.User;
import com.rongdu.cashloan.core.model.CloanUserModel;
import java.util.List;
import java.util.Map;

public abstract interface CloanUserService
  extends BaseService<User, Long>
{
  public abstract Page<CloanUserModel> listUser(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List listUserExport(Map<String, Object> paramMap);
  
  public abstract CloanUserModel getModelById(Long paramLong);
  
  public abstract List<Map<String, Object>> findAllDic();
  
  public abstract boolean updateByUuid(Map<String, Object> paramMap);
  
  public abstract User findByPhone(String paramString);
  
  public abstract long todayCount();
  
  public abstract void modify(String paramString);
}
