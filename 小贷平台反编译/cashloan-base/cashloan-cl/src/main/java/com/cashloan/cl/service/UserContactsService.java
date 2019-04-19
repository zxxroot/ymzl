package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.UserContacts;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface UserContactsService
  extends BaseService<UserContacts, Long>
{
  public abstract Page<UserContacts> listContacts(long paramLong, int paramInt1, int paramInt2);
  
  public abstract boolean deleteAndSave(List<Map<String, Object>> paramList, String paramString);
  
  public abstract List<UserContacts> listContacts(long paramLong, String paramString);
  
  public abstract List<UserContacts> listContacts(long paramLong);
  
  public abstract int update(UserContacts paramUserContacts);
  
  public abstract void deleteShardByUserId(Long paramLong);
}


/*UserContactsService.class

 */