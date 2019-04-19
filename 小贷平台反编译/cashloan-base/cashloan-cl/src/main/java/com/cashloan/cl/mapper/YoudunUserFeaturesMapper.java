package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.YoudunUserFeatures;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@RDBatisDao
public abstract interface YoudunUserFeaturesMapper
  extends BaseMapper<YoudunUserFeatures, Long>
{
  public abstract List<YoudunUserFeatures> findByUserId(@Param("userId") Long paramLong);
}
