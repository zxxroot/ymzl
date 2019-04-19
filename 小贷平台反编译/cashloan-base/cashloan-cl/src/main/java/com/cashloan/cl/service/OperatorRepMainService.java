package com.cashloan.cl.service;

import com.cashloan.cl.domain.OperatorRepMain;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;

public abstract interface OperatorRepMainService
  extends BaseService<OperatorRepMain, Long>
{
  public abstract List<OperatorRepMain> listSelective(Map<String, Object> paramMap);
}


/*OperatorRepMainService.class

 */