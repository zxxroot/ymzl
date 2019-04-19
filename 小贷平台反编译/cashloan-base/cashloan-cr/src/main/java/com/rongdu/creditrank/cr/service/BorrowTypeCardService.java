package com.rongdu.creditrank.cr.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.creditrank.cr.domain.BorrowTypeCard;
import java.util.Map;

public abstract interface BorrowTypeCardService
  extends BaseService<BorrowTypeCard, Long>
{
  public abstract Page<BorrowTypeCard> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract int save(long paramLong1, String paramString1, long paramLong2, String paramString2);
  
  public abstract int update(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2);
}
