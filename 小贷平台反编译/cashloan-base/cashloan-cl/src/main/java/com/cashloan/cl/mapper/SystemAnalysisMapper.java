package com.cashloan.cl.mapper;

import com.cashloan.cl.model.OverdueAnalisisModel;
import com.cashloan.cl.model.RepayAnalisisModel;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SystemAnalysisMapper
{
  public abstract List<RepayAnalisisModel> repayAnalisis(Map<String, Object> paramMap);
  
  public abstract List<OverdueAnalisisModel> overdueAnalisis(Map<String, Object> paramMap);
  
  public abstract String repayCount(Map<String, Object> paramMap);
  
  public abstract String overdueCount(Map<String, Object> paramMap);
  
  public abstract String repayAmt(Map<String, Object> paramMap);
  
  public abstract String penaltyRepayAmt(Map<String, Object> paramMap);
  
  public abstract List<String> mouthList();
}
