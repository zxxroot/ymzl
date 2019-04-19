package com.cashloan.cl.mapper;


import com.cashloan.cl.domain.ChannelContactProvider;
import com.cashloan.cl.domain.ChannelProvider;
import com.cashloan.cl.model.ChannelContactModel;
import com.cashloan.cl.model.KeyValue;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ChannelProviderMapper
  extends BaseMapper<ChannelProvider, Long>
{
  public abstract Page<ChannelContactModel> page(Map<String, Object> paramMap);
  
  public abstract List<KeyValue> listChannelProviderId();
  
  public abstract int selectProviderId(@Param("providerId") String paramString);
  
  public abstract int addContactProvider(List<ChannelContactProvider> paramList);
  
  public abstract void delContactProvider(@Param("id") Long paramLong);
  
  public abstract List<KeyValue> channelContactList(@Param("id") Long paramLong);
  
  public abstract int updateState(Map<String, Object> paramMap);
}
