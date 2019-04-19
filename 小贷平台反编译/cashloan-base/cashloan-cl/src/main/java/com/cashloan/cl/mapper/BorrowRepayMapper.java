package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.BorrowRepay;
import com.cashloan.cl.model.BorrowRepayModel;
import com.cashloan.cl.model.ManageBRepayModel;
import com.cashloan.cl.model.ManageBorrowModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface BorrowRepayMapper
  extends BaseMapper<BorrowRepay, Long>
{
  public abstract int updateByBorrowId(Map<String, Object> paramMap);
  
  public abstract List<ManageBRepayModel> listModel(Map<String, Object> paramMap);
  
  public abstract ManageBRepayModel findRecordByUser(Map<String, Object> paramMap);
  
  public abstract int updateLate(BorrowRepay paramBorrowRepay);
  
  public abstract int updateParam(Map<String, Object> paramMap);
  
  public abstract List<ManageBorrowModel> listRepayModel(Map<String, Object> paramMap);
  
  public abstract List<ManageBorrowModel> listModelNotUrge(Map<String, Object> paramMap);
  
  public abstract List<BorrowRepayModel> listSelModel(Map<String, Object> paramMap);
  
  public abstract List<BorrowRepay> findUnRepay(Map<String, Object> paramMap);
  
  public abstract BorrowRepayModel findOverdue(long paramLong);
  
  public abstract double findRepayTotal();
  
  public abstract Map<String, String> totalBorrow(Map<String, Object> paramMap);
}
