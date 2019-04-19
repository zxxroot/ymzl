package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.TppReqLog;
import com.rongdu.cashloan.rc.model.TppReqLogModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface TppReqLogMapper
  extends BaseMapper<TppReqLog, Long>
{
  public abstract int modifyTppReqLog(TppReqLog paramTppReqLog);
  
  public abstract List<TppReqLogModel> page(Map<String, Object> paramMap);
}
