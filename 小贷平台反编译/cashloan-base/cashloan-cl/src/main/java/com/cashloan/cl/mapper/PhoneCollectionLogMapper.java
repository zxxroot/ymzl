package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.PhoneCollectionLog;
import com.cashloan.cl.model.PhoneCollectionLogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface PhoneCollectionLogMapper
  extends BaseMapper<PhoneCollectionLog, Long>
{
  public abstract List<PhoneCollectionLogModel> listJoin(Map<String, Object> paramMap);
}
