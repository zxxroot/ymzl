package com.rongdu.cashloan.manage.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.manage.domain.QuartzInfo;
import com.rongdu.cashloan.manage.model.QuartzInfoModel;
import java.util.List;
import java.util.Map;

public abstract interface QuartzInfoService
  extends BaseService<QuartzInfo, Long>
{
  public abstract boolean save(QuartzInfo paramQuartzInfo);
  
  public abstract boolean update(Map<String, Object> paramMap);
  
  public abstract List<QuartzInfo> list(Map<String, Object> paramMap);
  
  public abstract Page<QuartzInfoModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract QuartzInfo findByCode(String paramString);
  
  public abstract QuartzInfo findSelective(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\service\QuartzInfoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */