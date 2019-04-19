package com.cashloan.cl.service;

import com.cashloan.cl.domain.DhbUserBasic;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface DhbUserBasicService
  extends BaseService<DhbUserBasic, Long>
{
  public abstract DhbUserBasic findSelective(Map<String, Object> paramMap);
  
  public abstract List<DhbUserBasic> listSelective(Map<String, Object> paramMap);
}
