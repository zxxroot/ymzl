package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.SceneBusiness;
import com.rongdu.cashloan.rc.model.ManageSceneBusinessModel;
import com.rongdu.cashloan.rc.model.TppServiceInfoModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SceneBusinessMapper
  extends BaseMapper<SceneBusiness, Long>
{
  public abstract List<ManageSceneBusinessModel> list(Map<String, Object> paramMap);
  
  public abstract ManageSceneBusinessModel findDetail(Long paramLong);
  
  public abstract List<TppServiceInfoModel> findTppServiceInfo(String paramString);
}
