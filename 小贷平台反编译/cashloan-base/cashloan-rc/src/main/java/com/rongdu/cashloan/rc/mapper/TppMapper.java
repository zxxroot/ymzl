package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.Tpp;
import com.rongdu.cashloan.rc.model.ManageTppModel;
import com.rongdu.cashloan.rc.model.TppModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface TppMapper
  extends BaseMapper<Tpp, Long>
{
  public abstract List<TppModel> listAll();
  
  public abstract List<ManageTppModel> list(Map<String, Object> paramMap);
  
  public abstract List<TppModel> listAllWithBusiness();
}
