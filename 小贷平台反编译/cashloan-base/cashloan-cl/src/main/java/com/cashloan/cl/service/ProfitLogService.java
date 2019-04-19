package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.ProfitLog;
import com.cashloan.cl.model.ManageCashLogModel;
import com.cashloan.cl.model.ProfitLogModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Date;
import java.util.Map;

public abstract interface ProfitLogService
  extends BaseService<ProfitLog, Long>
{
  public abstract Page<ProfitLogModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Page<ManageCashLogModel> findCashLog(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract Page<ManageCashLogModel> findCashLog(String paramString, int paramInt1, int paramInt2);
  
  public abstract int save(long paramLong, Date paramDate);
}


/*ProfitLogService.class

 */