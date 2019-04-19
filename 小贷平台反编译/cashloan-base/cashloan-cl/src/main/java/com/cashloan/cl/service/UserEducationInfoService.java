package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.UserEducationInfo;
import com.cashloan.cl.model.UserEducationInfoModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface UserEducationInfoService
  extends BaseService<UserEducationInfo, Long>
{
  public abstract int save(UserEducationInfo paramUserEducationInfo);
  
  public abstract int update(UserEducationInfo paramUserEducationInfo);
  
  public abstract Page<UserEducationInfoModel> list(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}


/*UserEducationInfoService.class

 */