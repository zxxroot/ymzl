package com.cashloan.cl.service;

import com.cashloan.cl.domain.BorrowRepayLog;
import com.cashloan.cl.model.BorrowRepayLogModel;
import com.cashloan.cl.model.ManageBRepayLogModel;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface BorrowRepayLogService
  extends BaseService<BorrowRepayLog, Long>
{
  public abstract int save(BorrowRepayLog paramBorrowRepayLog);
  
  public abstract Page<BorrowRepayLogModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Page<ManageBRepayLogModel> listModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract BorrowRepayLog findSelective(Map<String, Object> paramMap);
  
  public abstract boolean updateSelective(Map<String, Object> paramMap);
  
  public abstract boolean refundDeduction(Map<String, Object> paramMap);
  
  public abstract List listExport(Map<String, Object> paramMap);
}
