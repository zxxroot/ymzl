package com.rongdu.cashloan.rc.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.SceneBusiness;
import com.rongdu.cashloan.rc.model.ManageSceneBusinessModel;
import java.util.Map;

public abstract interface SceneBusinessService
  extends BaseService<SceneBusiness, Long>
{
  public abstract Page<ManageSceneBusinessModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract boolean save(SceneBusiness paramSceneBusiness);
  
  public abstract boolean update(SceneBusiness paramSceneBusiness);
  
  public abstract boolean enable(Long paramLong);
  
  public abstract boolean disable(Long paramLong);
  
  public abstract boolean validExist(String paramString1, Long paramLong, String paramString2);
}
