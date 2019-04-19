package com.rongdu.cashloan.rc.service;

import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.rc.domain.Tpp;
import com.rongdu.cashloan.rc.model.ManageTppModel;
import com.rongdu.cashloan.rc.model.TppModel;
import java.util.List;
import java.util.Map;

public abstract interface TppService
  extends BaseService<Tpp, Long>
{
  public abstract Page<ManageTppModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<TppModel> listAll();
  
  public abstract List<TppModel> listAllWithBusiness();
  
  public abstract boolean save(Tpp paramTpp);
  
  public abstract boolean update(Tpp paramTpp);
  
  public abstract boolean enable(Long paramLong);
  
  public abstract boolean disable(Long paramLong);
}
