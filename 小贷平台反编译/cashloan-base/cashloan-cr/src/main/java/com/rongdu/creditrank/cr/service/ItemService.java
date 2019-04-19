package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.CreditException;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.Item;
import com.rongdu.creditrank.cr.model.ItemModel;
import java.util.List;
import java.util.Map;

public abstract interface ItemService
  extends BaseService<Item, Long>
{
  public abstract Map<String, Object> save(String paramString, Long paramLong)
    throws CreditException;
  
  public abstract Page<ItemModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Item findByPrimary(long paramLong);
  
  public abstract List<ItemModel> listSelect(Map<String, Object> paramMap);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> deleteSelective(long paramLong)
    throws CreditException;
  
  public abstract Map<String, Object> list(long paramLong);
  
  public abstract int findSumScore(long paramLong);
}
