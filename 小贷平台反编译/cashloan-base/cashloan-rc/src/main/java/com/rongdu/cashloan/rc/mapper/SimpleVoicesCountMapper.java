package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.SimpleVoicesCount;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface SimpleVoicesCountMapper
  extends BaseMapper<SimpleVoicesCount, Long>
{
  public abstract int countOne(@Param("tableName") String paramString, @Param("userId") long paramLong);
  
  public abstract Double countTwo(@Param("tableName") String paramString1, @Param("phone") String paramString2, @Param("avgTime") String paramString3);
  
  public abstract SimpleVoicesCount findByUserId(@Param("userId") long paramLong);
}
