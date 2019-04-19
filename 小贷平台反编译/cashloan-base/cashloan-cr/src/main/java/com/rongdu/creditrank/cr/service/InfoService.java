package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.Info;
import com.rongdu.creditrank.cr.model.InfoModel;
import java.util.List;
import java.util.Map;

public abstract interface InfoService
  extends BaseService<Info, Long>
{
  public abstract Info findByTbNid(String paramString);
  
  public abstract int save(String paramString1, String paramString2, String paramString3);
  
  public abstract Page<InfoModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract List<Info> listSelective(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> findTable();
  
  public abstract List<Map<String, Object>> findColumnByName(Map<String, Object> paramMap);
  
  public abstract Info findByPrimary(long paramLong);
}
