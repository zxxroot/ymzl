package com.cashloan.cl.mapper;


import com.cashloan.cl.domain.ChannelApp;
import com.cashloan.cl.model.ChannelAppModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;

@RDBatisDao
public abstract interface ChannelAppMapper
  extends BaseMapper<ChannelApp, Long>
{
  public abstract List<ChannelAppModel> listChannelAppModel();
  
  public abstract List<ChannelApp> listSelective();
  
  public abstract ChannelApp findByPrimary(long paramLong);
  
  public abstract int save(ChannelApp paramChannelApp);
  
  public abstract int updateSelective(ChannelApp paramChannelApp);
}
