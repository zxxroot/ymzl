package com.cashloan.cl.service;

import com.cashloan.cl.domain.Sms;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface ClSmsService
  extends BaseService<Sms, Long>
{
  public abstract int smsBatch(String paramString);
  
  public abstract long findTimeDifference(String paramString1, String paramString2);
  
  public abstract int countDayTime(String paramString1, String paramString2);
  
  public abstract long sendSms(String paramString1, String paramString2);
  
  public abstract int verifySms(String paramString1, String paramString2, String paramString3);
  
  public abstract int findUser(String paramString);
  
  public abstract int loanInform(long paramLong1, long paramLong2);
  
  public abstract int repayInform(long paramLong1, long paramLong2);
  
  public abstract int overdue(long paramLong);
  
  public abstract int repayBefore(long paramLong1, long paramLong2);
  
  public abstract int registerSuccess(String paramString1, String paramString2);
  
  public abstract Map<String, Integer> sendBatchSms(List<String> paramList, String paramString);
}


/*ClSmsService.class

 */