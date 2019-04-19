package com.cashloan.cl.service;


import com.cashloan.cl.domain.ChannelApp;
import com.cashloan.cl.model.ChannelAppModel;
import com.rongdu.cashloan.core.common.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface ChannelAppService
  extends BaseService<ChannelApp, Long>
{
  public abstract List<ChannelAppModel> listChannelAppModel();
  
  public abstract List<ChannelApp> listChannelApp();
  
  public abstract ChannelApp findByPrimary(long paramLong);
  
  public abstract int save(ChannelApp paramChannelApp);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
}


/*ChannelAppService.class

 */