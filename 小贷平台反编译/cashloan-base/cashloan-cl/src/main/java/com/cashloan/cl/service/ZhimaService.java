package com.cashloan.cl.service;

import com.cashloan.cl.domain.Zhima;
import com.cashloan.cl.model.zmxy.creditScore.WhiteKnightZhiMaResponse;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.User;
import java.util.Map;

public abstract interface ZhimaService
  extends BaseService<Zhima, Long>
{
  public abstract Zhima getZhima(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> authCallBack(String paramString, User paramUser)
    throws Exception;
  
  public abstract int updateZhimaScore(Long paramLong);
  
  public abstract Zhima findByUserId(Long paramLong);
  
  public abstract void wkzmrCallBack(WhiteKnightZhiMaResponse paramWhiteKnightZhiMaResponse);
}


/*ZhimaService.class

 */