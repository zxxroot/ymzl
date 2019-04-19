package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.ProfitCashLog;
import com.cashloan.cl.model.ManageProfitAmountModel;
import com.cashloan.cl.model.ManageProfitLogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ProfitCashLogMapper
  extends BaseMapper<ProfitCashLog, Long>
{
  public abstract List<ManageProfitLogModel> findLog(Map<String, Object> paramMap);
  
  public abstract List<ManageProfitAmountModel> findAmount(Map<String, Object> paramMap);
  
  public abstract List<ManageProfitLogModel> findSysLog(Map<String, Object> paramMap);
  
  public abstract List<ManageProfitAmountModel> findSysAmount(Map<String, Object> paramMap);
}
