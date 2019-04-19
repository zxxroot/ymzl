package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.YoudunGraphDetail;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface YoudunGraphDetailMapper
  extends BaseMapper<YoudunGraphDetail, Long>
{
  public abstract List<YoudunGraphDetail> findByUserId(@Param("userId") Long paramLong);
}
