package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

@RDBatisDao
public abstract interface RcBorrowRepayCountMapper
{
  public abstract Integer countFailNinety(Long paramLong);
  
  public abstract Integer countFailThirty(Long paramLong);
  
  public abstract Integer countFailWithinThirty(Long paramLong);
  
  public abstract Integer countRelativeNinety(Long paramLong);
  
  public abstract Integer countRelativeThirty(Long paramLong);
  
  public abstract Integer countRelativeWithinThirty(Long paramLong);
}
