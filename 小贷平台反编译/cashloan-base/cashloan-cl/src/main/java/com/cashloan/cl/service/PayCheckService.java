package com.cashloan.cl.service;

import com.cashloan.cl.domain.PayCheck;
import com.cashloan.cl.model.ManagePayCheckModel;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;

import java.util.List;
import java.util.Map;

public abstract interface PayCheckService
  extends BaseService<PayCheck, Long>
{
  public abstract boolean save(PayCheck paramPayCheck);
  
  public abstract Page<ManagePayCheckModel> page(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract PayCheck findSelective(Map<String, Object> paramMap);
  
  public abstract List listPayCheck(Map<String, Object> paramMap);
}
