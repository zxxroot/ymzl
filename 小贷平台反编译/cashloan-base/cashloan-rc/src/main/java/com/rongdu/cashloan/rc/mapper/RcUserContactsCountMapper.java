package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.Map;

@RDBatisDao
public abstract interface RcUserContactsCountMapper
{
  public abstract Integer count(Map<String, Object> paramMap);
  
  public abstract Integer countSucceed(Map<String, Object> paramMap);
  
  public abstract Integer countFail(Map<String, Object> paramMap);
  
  public abstract Integer countNinety(Map<String, Object> paramMap);
  
  public abstract Integer countThirty(Map<String, Object> paramMap);
  
  public abstract Integer countWithinThirty(Map<String, Object> paramMap);
}
