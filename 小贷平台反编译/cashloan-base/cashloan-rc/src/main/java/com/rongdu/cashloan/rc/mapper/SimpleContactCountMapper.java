package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.SimpleContactCount;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface SimpleContactCountMapper
  extends BaseMapper<SimpleContactCount, Long>
{
  public abstract int countOne(@Param("tableName") String paramString, @Param("userId") long paramLong);
}
