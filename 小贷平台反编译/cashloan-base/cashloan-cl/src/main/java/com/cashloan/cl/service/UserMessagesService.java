package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.UserMessages;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface UserMessagesService
  extends BaseService<UserMessages, Long>
{
  public abstract Page<UserMessages> listMessages(long paramLong, int paramInt1, int paramInt2);
  
  public abstract boolean deleteAndSave(List<Map<String, Object>> paramList, String paramString);
  
  public abstract Page<UserMessages> findShardPage(long paramLong, int paramInt1, int paramInt2);
}
