package com.cashloan.cl.mapper;


import com.cashloan.cl.domain.RcZhimaAntiFraud;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@RDBatisDao
public abstract interface RcZhimaAntiFraudMapper
  extends BaseMapper<RcZhimaAntiFraud, Long>
{
  public abstract List<RcZhimaAntiFraud> findByuserId(@Param("userId") Long paramLong);
}
