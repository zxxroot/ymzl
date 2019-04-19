package com.cashloan.cl.service;

import com.cashloan.cl.domain.UserEquipmentInfo;
import com.rongdu.cashloan.core.common.service.BaseService;

public abstract interface UserEquipmentInfoService
  extends BaseService<UserEquipmentInfo, Long>
{
  public abstract int saveOrUpdate(UserEquipmentInfo paramUserEquipmentInfo);
  
  public abstract UserEquipmentInfo findSelective(long paramLong);
  
  public abstract void save(String paramString1, String paramString2);
}


/*UserEquipmentInfoService.class

 */