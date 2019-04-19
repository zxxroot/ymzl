package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.BorrowRepay;
import com.cashloan.cl.model.ManageBRepayModel;
import com.cashloan.cl.model.ManageBorrowModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.Borrow;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public abstract interface BorrowRepayService
  extends BaseService<BorrowRepay, Long>
{
  public abstract int save(BorrowRepay paramBorrowRepay);
  
  public abstract boolean genRepayPlan(Borrow paramBorrow);
  
  public abstract void authSignApply(Long paramLong);
  
  public abstract Page<ManageBRepayModel> listModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Map<String, Object> confirmRepay(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> autoRepay(String paramString, Long paramLong);
  
  public abstract List<BorrowRepay> listSelective(Map<String, Object> paramMap);
  
  public abstract int updateLate(BorrowRepay paramBorrowRepay);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract Page<ManageBorrowModel> listRepayModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Page<ManageBorrowModel> listModelNotUrge(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<BorrowRepay> findUnRepay(Map<String, Object> paramMap);
  
  public abstract BorrowRepay findSelective(Map<String, Object> paramMap);
  
  public abstract List<ManageBRepayModel> listAllModel(Map<String, Object> paramMap);
  
  public abstract List<List<String>> fileBatchRepay(MultipartFile paramMultipartFile, String paramString)
    throws Exception;
  
  public abstract void insertRepayData(Long paramLong);
  
  public abstract Map<String, Object> autoFuiouRepay(String paramString, Long paramLong);
  
  public abstract Map<String, Object> autoFuiouProtocolRepay(String paramString1, Long paramLong, String paramString2, boolean... paramVarArgs);
}
