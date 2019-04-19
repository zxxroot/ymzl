package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.YoudunIdDetail;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface YoudunIdDetailMapper
  extends BaseMapper<YoudunIdDetail, Long>
{
  public abstract List<YoudunIdDetail> findByUserId(@Param("userId") Long paramLong);
}
