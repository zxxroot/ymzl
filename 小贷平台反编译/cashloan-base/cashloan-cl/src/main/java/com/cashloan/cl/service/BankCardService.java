package com.cashloan.cl.service;

import com.cashloan.cl.domain.BankCard;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface BankCardService
  extends BaseService<BankCard, Long>
{
  public abstract boolean save(BankCard paramBankCard);
  
  public abstract BankCard getBankCardByUserId(Long paramLong);
  
  public abstract BankCard findSelective(Map<String, Object> paramMap);
  
  public abstract int cancelAuthSign(BankCard paramBankCard);
  
  public abstract boolean updateSelective(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> unBind(BankCard paramBankCard);
}


/*BankCardService.class

 */