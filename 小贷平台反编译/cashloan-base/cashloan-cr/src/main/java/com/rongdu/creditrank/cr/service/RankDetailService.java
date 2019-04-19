package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.RankDetail;
import java.util.Map;

public abstract interface RankDetailService
  extends BaseService<RankDetail, Long>
{
  public abstract int save(RankDetail paramRankDetail);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract Page<RankDetail> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}
