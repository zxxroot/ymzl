package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.CrResult;
import com.rongdu.creditrank.cr.model.CreditRatingModel;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface CrResultMapper
  extends BaseMapper<CrResult, Long>
{
  public abstract List<CreditRatingModel> queryCreditRating(@Param("borrowTypeId") Long paramLong, @Param("type") Integer paramInteger);
  
  public abstract CrResult findByConsumerNo(@Param("consumerNo") String paramString);
  
  public abstract Map<String, Object> findUserResult(Long paramLong);
  
  public abstract List<CrResult> findAllBorrowTypeResult(Long paramLong);
  
  public abstract CrResult findCreditTypeResult(@Param("consumerNo") String paramString, @Param("creditTypeId") Long paramLong);
  
  public abstract String findValidValue(@Param("statement") String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\CrResultMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */