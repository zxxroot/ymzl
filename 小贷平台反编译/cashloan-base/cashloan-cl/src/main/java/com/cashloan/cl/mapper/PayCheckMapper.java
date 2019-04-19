package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.PayCheck;
import com.cashloan.cl.model.ManagePayCheckModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface PayCheckMapper
  extends BaseMapper<PayCheck, Long>
{
  public abstract List<ManagePayCheckModel> page(Map<String, Object> paramMap);
}
