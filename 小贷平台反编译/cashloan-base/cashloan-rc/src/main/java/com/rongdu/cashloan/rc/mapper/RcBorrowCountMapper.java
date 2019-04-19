package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.Map;

@RDBatisDao
public abstract interface RcBorrowCountMapper
{
  public abstract Integer borrowCount(Long paramLong);
  
  public abstract int countUnFinished(Map<String, Object> paramMap);
  
  public abstract Integer borrowFailCount(Long paramLong);
  
  public abstract Integer dayFailCount(Long paramLong);
  
  public abstract Integer failCount(Long paramLong);
  
  public abstract Integer failCountRelative(Long paramLong);
}
