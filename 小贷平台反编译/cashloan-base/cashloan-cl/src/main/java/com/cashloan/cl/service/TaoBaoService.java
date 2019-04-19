package com.cashloan.cl.service;

import com.cashloan.cl.domain.TaoBao;
import com.cashloan.cl.model.zmxy.creditScore.WhiteKnightZhiMaResponse;
import com.rongdu.cashloan.core.common.service.BaseService;

public abstract interface TaoBaoService
  extends BaseService<TaoBao, Long>
{
  public abstract void wkzmrCallBack(WhiteKnightZhiMaResponse paramWhiteKnightZhiMaResponse);
}
