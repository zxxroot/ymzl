package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.OperatorVoices;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public abstract interface OperatorVoicesService
  extends BaseService<OperatorVoices, Long>
{
  public abstract Page<OperatorVoices> findShardPage(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract void updateVoiceMessage(String paramString1, String paramString2, HashMap<String, Object> paramHashMap);
  
  public abstract Page<OperatorVoices> recordsDetail(Map<String, Object> paramMap, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    throws ParseException;
  
  public abstract Map<String, Object> recordsCount(long paramLong1, long paramLong2)
    throws ParseException;
}
