package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.SceneBusinessLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface SceneBusinessLogMapper
  extends BaseMapper<SceneBusinessLog, Long>
{
  public abstract int countUnFinishLog(SceneBusinessLog paramSceneBusinessLog);
  
  public abstract List<SceneBusinessLog> findSceneLogUnFinish(SceneBusinessLog paramSceneBusinessLog);
  
  public abstract SceneBusinessLog findLastExcute(@Param("userId") Long paramLong1, @Param("busId") Long paramLong2);
  
  public abstract void deleteByUserId(@Param("userId") Long paramLong);
  
  public abstract SceneBusinessLog findLastExcuteByPhone(@Param("phone") String paramString, @Param("busId") Long paramLong);
  
  public abstract void deleteByPhone(String paramString);
}
