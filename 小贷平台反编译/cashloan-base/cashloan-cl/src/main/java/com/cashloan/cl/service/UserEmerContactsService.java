package com.cashloan.cl.service;

import com.cashloan.cl.domain.UserEmerContacts;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface UserEmerContactsService
  extends BaseService<UserEmerContacts, Long>
{
  public abstract List<UserEmerContacts> getUserEmerContactsByUserId(Map<String, Object> paramMap);
  
  public abstract int updateUserContacts(Long paramLong);
  
  public abstract void updateVoiceMessage(String paramString, Map<String, Object> paramMap);
}
