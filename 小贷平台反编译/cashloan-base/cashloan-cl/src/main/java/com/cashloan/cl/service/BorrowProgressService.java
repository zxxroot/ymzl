package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.BorrowProgress;
import com.cashloan.cl.model.ManageBorrowProgressModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.Borrow;
import java.util.List;
import java.util.Map;

public abstract interface BorrowProgressService
  extends BaseService<BorrowProgress, Long>
{
  public abstract Map<String, Object> result(Borrow paramBorrow);
  
  public abstract Page<ManageBorrowProgressModel> listModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract boolean save(BorrowProgress paramBorrowProgress);
  
  public abstract List<BorrowProgress> listSeletetiv(Map<String, Object> paramMap);
}
