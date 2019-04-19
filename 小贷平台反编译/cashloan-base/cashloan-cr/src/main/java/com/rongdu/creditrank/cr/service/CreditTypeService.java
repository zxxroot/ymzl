package com.rongdu.creditrank.cr.service;

import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.CreditType;
import com.rongdu.creditrank.cr.model.CreditRatingModel;
import com.rongdu.creditrank.cr.model.CreditTypeModel;
import java.util.List;
import java.util.Map;

public abstract interface CreditTypeService
  extends BaseService<CreditType, Long>
{
  public abstract List<CreditType> findCreditType(Map<String, Object> paramMap);
  
  public abstract List<CreditTypeModel> findAllCreditType();
  
  public abstract CreditTypeModel findCreditTypeInfo(CreditType paramCreditType);
  
  public abstract List<Map<Long, String>> findUnUsedBorrowType();
  
  public abstract List<CreditRatingModel> findEditBorrowType(Long paramLong);
}
