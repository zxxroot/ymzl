package com.cashloan.cl.service;
import com.cashloan.cl.domain.PayLog;
import com.cashloan.cl.model.ManagePayLogModel;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;
public abstract interface PayLogService
  extends BaseService<PayLog, Long>
{
  public abstract boolean save(PayLog paramPayLog);
  
  public abstract Page<ManagePayLogModel> page(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract ManagePayLogModel findDetail(Long paramLong);
  
  public abstract boolean auditPay(Long paramLong, String paramString);
  
  public abstract Map<String, Object> checkPayLogState(Long paramLong, String paramString);
  
  public abstract PayLog findByOrderNo(String paramString);
  
  public abstract boolean updateSelective(Map<String, Object> paramMap);
  
  public abstract PayLog findSelective(Map<String, Object> paramMap);
  
  public abstract List<PayLog> findCheckList(Map<String, Object> paramMap);
  
  public abstract boolean judge(long paramLong);
  
  public abstract List listPayLog(String paramString);
  
  public abstract PayLog findLatestOne(Map<String, Object> paramMap);
  
  public abstract int doRepaymentNum(long paramLong);
}


/*PayLogService.class

 */