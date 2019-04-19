package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.OperatorVoicesContact;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface OperatorVoicesContactService
  extends BaseService<OperatorVoicesContact, Long>
{
  public abstract Page<OperatorVoicesContact> findShardPage(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<OperatorVoicesContact> listSelective(Map<String, Object> paramMap);
}
