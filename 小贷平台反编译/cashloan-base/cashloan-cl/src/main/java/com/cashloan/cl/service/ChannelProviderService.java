package com.cashloan.cl.service;

import com.cashloan.cl.domain.ChannelProvider;
import com.cashloan.cl.model.ChannelContactModel;
import com.cashloan.cl.model.KeyValue;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface ChannelProviderService
  extends BaseService<ChannelProvider, Long>
{
  public abstract Page<ChannelContactModel> listChannelProvider(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract List<KeyValue> listChannelProviderId();
  
  public abstract boolean save(Map<String, Object> paramMap, String paramString1, String paramString2, String paramString3);
  
  public abstract ChannelProvider channelProviderDetails(Long paramLong);
  
  public abstract List<KeyValue> channelContactList(Long paramLong);
  
  public abstract boolean update(Map<String, Object> paramMap, Long paramLong, String paramString);
  
  public abstract int updateState(Map<String, Object> paramMap);
}
