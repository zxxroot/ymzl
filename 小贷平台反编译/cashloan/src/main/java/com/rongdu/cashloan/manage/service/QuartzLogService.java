package com.rongdu.cashloan.manage.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.manage.domain.QuartzLog;
import com.rongdu.cashloan.manage.model.QuartzLogModel;
import java.util.Map;

public abstract interface QuartzLogService
  extends BaseService<QuartzLog, Long>
{
  public abstract int save(QuartzLog paramQuartzLog);
  
  public abstract Page<QuartzLogModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\service\QuartzLogService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */