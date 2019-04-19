package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.YoudunScoreDetail;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface YoudunScoreDetailMapper
  extends BaseMapper<YoudunScoreDetail, Long>
{
  public abstract List<YoudunScoreDetail> findByUserId(@Param("userId") Long paramLong);
}
