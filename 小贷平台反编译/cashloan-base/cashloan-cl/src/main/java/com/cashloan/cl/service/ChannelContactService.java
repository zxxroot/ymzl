package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.ChannelContact;
import com.cashloan.cl.model.ChannelContactModel;
import com.cashloan.cl.model.KeyValue;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.system.domain.SysUser;
import java.util.List;
import java.util.Map;

public abstract interface ChannelContactService
  extends BaseService<ChannelContact, Long>
{
  public abstract Page<ChannelContactModel> listChannelContact(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract List<KeyValue> listChannelContactId();
  
  public abstract ChannelContact channelContactDetails(Long paramLong);
  
  public abstract boolean update(Map<String, Object> paramMap, Long paramLong, String paramString);
  
  public abstract int updateState(Map<String, Object> paramMap);
  
  public abstract List<KeyValue> channelContactList(Long paramLong);
  
  public abstract SysUser saveUsers(String paramString1, String paramString2, Long paramLong, String paramString3, String paramString4);
  
  public abstract boolean save(Map<String, Object> paramMap, SysUser paramSysUser, String paramString1, String paramString2, Long paramLong);
}


/*ChannelContactService.class

 */