package com.rongdu.cashloan.rc.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import com.rongdu.cashloan.rc.model.ManageTppBusinessModel;
import com.rongdu.cashloan.rc.model.TppBusinessModel;
import java.util.List;
import java.util.Map;

public abstract interface TppBusinessService
  extends BaseService<TppBusiness, Long>
{
  public abstract List<TppBusinessModel> listAll();
  
  public abstract Page<ManageTppBusinessModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<TppBusiness> listSelective(Map<String, Object> paramMap);
  
  public abstract boolean save(TppBusiness paramTppBusiness);
  
  public abstract boolean update(TppBusiness paramTppBusiness);
  
  public abstract boolean enable(Long paramLong);
  
  public abstract boolean disable(Long paramLong);
  
  public abstract boolean tppBusinessExist(TppBusiness paramTppBusiness);
  
  public abstract TppBusiness findByNid(String paramString, Long paramLong);
}
