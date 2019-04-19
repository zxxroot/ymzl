package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.Card;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface CardMapper
  extends BaseMapper<Card, Long>
{
  public abstract Card findByCardName(String paramString);
  
  public abstract int updateState(Map<String, Object> paramMap);
  
  public abstract int updateType(Long paramLong);
  
  public abstract List<Card> findAll();
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\CardMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */