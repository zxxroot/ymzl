package com.rongdu.cashloan.rc.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import com.rongdu.cashloan.rc.model.ManageTppBusinessModel;
import com.rongdu.cashloan.rc.model.TppBusinessModel;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface TppBusinessMapper
  extends BaseMapper<TppBusiness, Long>
{
  public abstract List<TppBusinessModel> listAll();
  
  public abstract List<ManageTppBusinessModel> list(Map<String, Object> paramMap);
  
  public abstract ManageTppBusinessModel findByTppId(long paramLong);
  
  public abstract TppBusiness findByNid(@Param("nid") String paramString, @Param("tppId") Long paramLong);
}
