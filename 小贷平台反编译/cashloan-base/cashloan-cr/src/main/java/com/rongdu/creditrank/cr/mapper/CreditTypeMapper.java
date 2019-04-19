package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.CreditType;
import com.rongdu.creditrank.cr.model.CreditRatingModel;
import com.rongdu.creditrank.cr.model.CreditTypeModel;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface CreditTypeMapper
  extends BaseMapper<CreditType, Long>
{
  public abstract CreditTypeModel findCreditTypeInfo(CreditType paramCreditType);
  
  public abstract List<Map<Long, String>> findUnUsedBorrowType();
  
  public abstract List<CreditRatingModel> findEditBorrowType(@Param("typeId") Long paramLong);
  
  public abstract CreditTypeModel findByBorrowTypeId(@Param("borrowTypeId") Long paramLong);
}
