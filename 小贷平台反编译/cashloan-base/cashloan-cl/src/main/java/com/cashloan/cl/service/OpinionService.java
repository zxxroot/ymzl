package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.Opinion;
import com.cashloan.cl.model.OpinionModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface OpinionService
  extends BaseService<Opinion, Long>
{
  public abstract int save(long paramLong, String paramString);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract List<Opinion> getOpinion(Map<String, Object> paramMap);
  
  public abstract Page<OpinionModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}
