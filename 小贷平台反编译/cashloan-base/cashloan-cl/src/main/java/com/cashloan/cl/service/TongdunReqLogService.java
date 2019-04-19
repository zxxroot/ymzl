package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.TongdunReqLog;
import com.cashloan.cl.model.TongdunReqLogModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import java.util.List;
import java.util.Map;

public abstract interface TongdunReqLogService
  extends BaseService<TongdunReqLog, Long>
{
  public abstract int preloanApplyRequest(Long paramLong, Borrow paramBorrow, TppBusiness paramTppBusiness, String paramString);
  
  public abstract String preloanReportRequest(String paramString1, TppBusiness paramTppBusiness, String paramString2);
  
  public abstract Page<TongdunReqLogModel> pageListModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract TongdunReqLogModel getModelById(long paramLong);
  
  public abstract List<TongdunReqLogModel> listByMap(Map<String, Object> paramMap);
}
