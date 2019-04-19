package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UserEducationInfo;
import com.cashloan.cl.model.UserEducationInfoModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface UserEducationInfoMapper
  extends BaseMapper<UserEducationInfo, Long>
{
  public abstract List<UserEducationInfoModel> page(Map<String, Object> paramMap);
}