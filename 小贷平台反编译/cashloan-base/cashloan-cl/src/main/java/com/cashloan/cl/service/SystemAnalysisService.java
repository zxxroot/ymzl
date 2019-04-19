package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.model.OverdueAnalisisModel;
import com.cashloan.cl.model.RepayAnalisisModel;
import java.util.List;
import java.util.Map;

public abstract interface SystemAnalysisService
{
  public abstract List<RepayAnalisisModel> monthRepayAnalisis(Map<String, Object> paramMap);
  
  public abstract List<RepayAnalisisModel> dayRepayAnalisis(Map<String, Object> paramMap);
  
  public abstract Page<OverdueAnalisisModel> overdueAnalisis(Map<String, Object> paramMap, Integer paramInteger1, Integer paramInteger2);
}
