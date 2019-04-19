package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.RcZhimaIndustry;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface RcZhimaIndustryMapper
  extends BaseMapper<RcZhimaIndustry, Long>
{
  public abstract List<RcZhimaIndustry> findByuserId(@Param("userId") Long paramLong);
}
