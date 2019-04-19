package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.ProfitCashLog;
import com.cashloan.cl.model.ManageProfitLogModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface ProfitCashLogService
  extends BaseService<ProfitCashLog, Long>
{
  public abstract Page<ProfitCashLog> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Page<ManageProfitLogModel> findLog(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract Page<ManageProfitLogModel> findLog(String paramString, int paramInt1, int paramInt2);
}
