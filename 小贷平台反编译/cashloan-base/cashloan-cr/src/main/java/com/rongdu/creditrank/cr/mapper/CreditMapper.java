package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.Credit;
import com.rongdu.creditrank.cr.model.CreditModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface CreditMapper
  extends BaseMapper<Credit, Long>
{
  public abstract int updateAmount(Map<String, Object> paramMap);
  
  public abstract List<CreditModel> page(Map<String, Object> paramMap);
  
  public abstract Credit findByConsumerNo(String paramString);
  
  public abstract List<CreditModel> listAll(Map<String, Object> paramMap);
  
  public abstract List<CreditModel> creditList(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\CreditMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */