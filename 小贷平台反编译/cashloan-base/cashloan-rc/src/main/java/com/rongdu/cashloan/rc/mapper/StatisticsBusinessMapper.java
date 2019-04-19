package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.StatisticsBusiness;

@RDBatisDao
public abstract interface StatisticsBusinessMapper
  extends BaseMapper<StatisticsBusiness, Long>
{}
