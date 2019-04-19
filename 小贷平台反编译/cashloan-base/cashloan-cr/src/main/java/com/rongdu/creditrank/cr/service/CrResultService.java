package com.rongdu.creditrank.cr.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.CrResult;
import java.util.List;
import java.util.Map;

public abstract interface CrResultService
  extends BaseService<CrResult, Long>
{
  public abstract Map<String, Object> findUserResult(Long paramLong);
  
  public abstract List<CrResult> findAllBorrowTypeResult(Long paramLong);
}
