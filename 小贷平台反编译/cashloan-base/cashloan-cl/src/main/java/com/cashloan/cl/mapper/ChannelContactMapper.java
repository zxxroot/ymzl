package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.ChannelContact;
import com.cashloan.cl.domain.ChannelContactProvider;
import com.cashloan.cl.model.ChannelContactModel;
import com.cashloan.cl.model.KeyValue;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ChannelContactMapper
  extends BaseMapper<ChannelContact, Long>
{
  public abstract Page<ChannelContactModel> page(Map<String, Object> paramMap);
  
  public abstract List<KeyValue> listChannelContactId();
  
  public abstract int selectContactId(String paramString);
  
  public abstract int updateState(Map<String, Object> paramMap);
  
  public abstract int addContactProvider(List<ChannelContactProvider> paramList);
  
  public abstract int delContactProvider(@Param("id") Long paramLong);
  
  public abstract List<KeyValue> channelContactList(Long paramLong);
}
