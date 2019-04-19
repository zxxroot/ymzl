package com.cashloan.cl.service;

import com.cashloan.cl.domain.BorrowRiskData;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface BorrowRiskDataService
  extends BaseService<BorrowRiskData, Long>
{
  public abstract List<BorrowRiskData> listSelective(Map<String, Object> paramMap);
}
