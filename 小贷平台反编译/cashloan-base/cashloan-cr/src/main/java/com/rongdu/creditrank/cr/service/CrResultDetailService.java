package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.CrResultDetail;
import com.rongdu.creditrank.cr.model.CrResultDetailModel;
import java.util.List;
import java.util.Map;

public abstract interface CrResultDetailService
  extends BaseService<CrResultDetail, Long>
{
  public abstract Page<CrResultDetail> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<CrResultDetailModel> listDetailTree(Long paramLong);
  
  public abstract List<CrResultDetail> listInfo(Long paramLong);
}
