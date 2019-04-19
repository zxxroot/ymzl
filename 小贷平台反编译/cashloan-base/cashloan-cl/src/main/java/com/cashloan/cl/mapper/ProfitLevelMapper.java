package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.ProfitLevel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;

@RDBatisDao
public abstract interface ProfitLevelMapper
  extends BaseMapper<ProfitLevel, Long>
{
  public abstract List<ProfitLevel> listAll();
}
