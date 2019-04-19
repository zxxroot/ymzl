package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.YoudunLoanDetail;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface YoudunLoanDetailMapper
  extends BaseMapper<YoudunLoanDetail, Long>
{
  public abstract List<YoudunLoanDetail> findByUserId(@Param("userId") Long paramLong);
}
