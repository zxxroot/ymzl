package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.Rank;
import com.rongdu.creditrank.cr.model.RankModel;
import java.util.List;
import java.util.Map;

public abstract interface RankService
  extends BaseService<Rank, Long>
{
  public abstract Page<Rank> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<Rank> findAll();
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract List<Rank> listSelective(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> save(List<Map<String, Object>> paramList, String paramString, long paramLong);
  
  public abstract Rank findSelective(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> deleteSelective(long paramLong);
  
  public abstract Page<RankModel> countList(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}
