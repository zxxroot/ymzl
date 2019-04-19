package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.ProfitAgent;
import com.cashloan.cl.model.ManageAgentListModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ProfitAgentMapper
  extends BaseMapper<ProfitAgent, Long>
{
  public abstract List<ManageAgentListModel> findAgentList(Map<String, Object> paramMap);
}
