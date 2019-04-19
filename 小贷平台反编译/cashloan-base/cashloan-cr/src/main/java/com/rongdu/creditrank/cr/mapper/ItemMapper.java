package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.Item;
import com.rongdu.creditrank.cr.model.ItemModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ItemMapper
  extends BaseMapper<Item, Long>
{
  public abstract Item findByItmeName(String paramString);
  
  public abstract List<ItemModel> listSelect(Map<String, Object> paramMap);
  
  public abstract Item findByCardId(long paramLong);
  
  public abstract int deleteSelective(long paramLong);
  
  public abstract int findSumScore(long paramLong);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\ItemMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */