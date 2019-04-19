package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.CrResultDetail;
import com.rongdu.creditrank.cr.model.CrResultDetailModel;
import com.rongdu.creditrank.cr.model.CrResultFactorDetail;
import com.rongdu.creditrank.cr.model.CrResultItemDetail;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface CrResultDetailMapper
  extends BaseMapper<CrResultDetail, Long>
{
  public abstract List<CrResultDetail> listResultDetail(Map<String, Object> paramMap);
  
  public abstract List<CrResultDetail> countFactorScore(@Param("resultId") Long paramLong);
  
  public abstract List<CrResultDetail> countItemScore(@Param("resultId") Long paramLong);
  
  public abstract List<CrResultDetail> countCardScore(@Param("resultId") Long paramLong);
  
  public abstract void saveCountScore(List<CrResultDetail> paramList);
  
  public abstract List<CrResultDetailModel> findDetail(@Param("resultId") Long paramLong, @Param("level") String paramString);
  
  public abstract List<CrResultFactorDetail> findFactorDetail(@Param("resultId") Long paramLong, @Param("level") String paramString);
  
  public abstract List<CrResultItemDetail> findItemDetail(@Param("resultId") Long paramLong, @Param("level") String paramString);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\CrResultDetailMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */