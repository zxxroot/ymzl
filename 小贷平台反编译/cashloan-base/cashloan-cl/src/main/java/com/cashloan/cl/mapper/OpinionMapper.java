package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.Opinion;
import com.cashloan.cl.model.OpinionModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface OpinionMapper
  extends BaseMapper<Opinion, Long>
{
  public abstract List<OpinionModel> listModel(Map<String, Object> paramMap);
}
