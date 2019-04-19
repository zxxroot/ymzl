package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.exception.CreditException;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.Card;
import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

public abstract interface CardService
  extends BaseService<Card, Long>
{
  public abstract Page<Card> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<Card> findAll();
  
  public abstract Map<String, Object> save(String paramString)
    throws CreditException;
  
  public abstract Card findByPrimary(long paramLong);
  
  public abstract Map<String, Object> updateState(long paramLong, String paramString)
    throws ServerException, CreditException;
  
  public abstract void updateSelective(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> update(long paramLong, String paramString);
}
