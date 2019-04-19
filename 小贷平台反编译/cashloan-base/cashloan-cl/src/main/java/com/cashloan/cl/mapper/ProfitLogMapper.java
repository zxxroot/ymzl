package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.ProfitLog;
import com.cashloan.cl.model.ManageCashLogModel;
import com.cashloan.cl.model.ProfitLogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ProfitLogMapper
  extends BaseMapper<ProfitLog, Long>
{
  public abstract List<ProfitLogModel> listInfo(Map<String, Object> paramMap);
  
  public abstract List<ManageCashLogModel> findCashLog(Map<String, Object> paramMap);
  
  public abstract List<ManageCashLogModel> findSysCashLog(Map<String, Object> paramMap);
  
  public abstract int count(Map<String, Object> paramMap);
}
