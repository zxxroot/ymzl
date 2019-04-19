package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.QianchengReqlog;
import com.cashloan.cl.model.QianchengReqlogModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface QianchengReqlogService
  extends BaseService<QianchengReqlog, Long>
{
  public abstract Page<QianchengReqlogModel> listQianchengReqlog(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract QianchengReqlog findByOrderNo(String paramString);
  
  public abstract QianchengReqlog findByBorrowId(Long paramLong);
  
  public abstract int update(QianchengReqlog paramQianchengReqlog);
}


/*QianchengReqlogService.class

 */