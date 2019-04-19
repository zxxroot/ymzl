package com.cashloan.cl.mapper;


import com.cashloan.cl.domain.BorrowRepayLog;
import com.cashloan.cl.model.BorrowRepayLogModel;
import com.cashloan.cl.model.ManageBRepayLogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

;

@RDBatisDao
public abstract interface BorrowRepayLogMapper
  extends BaseMapper<BorrowRepayLog, Long>
{
  public abstract List<ManageBRepayLogModel> listModel(Map<String, Object> paramMap);
  
  public abstract List<BorrowRepayLogModel> listSelModel(Map<String, Object> paramMap);
  
  public abstract int refundDeduction(Map<String, Object> paramMap);
}
