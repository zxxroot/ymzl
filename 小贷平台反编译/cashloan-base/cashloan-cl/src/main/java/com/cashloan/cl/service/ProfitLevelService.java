package com.cashloan.cl.service;

import com.cashloan.cl.domain.ProfitLevel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;

public abstract interface ProfitLevelService
  extends BaseService<ProfitLevel, Long>
{
  public abstract List<ProfitLevel> find();
  
  public abstract int update(long paramLong, double paramDouble);
}


/*ProfitLevelService.class

 */