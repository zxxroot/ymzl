package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.UserInvite;
import com.cashloan.cl.model.InviteBorrowModel;
import com.cashloan.cl.model.ManageAgentModel;
import com.cashloan.cl.model.ManageProfitModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface UserInviteMapper
  extends BaseMapper<UserInvite, Long>
{
  public abstract List<ManageProfitModel> findAgent(Map<String, Object> paramMap);
  
  public abstract List<ManageAgentModel> findSysAgent(Map<String, Object> paramMap);
  
  public abstract long count(Long paramLong);
  
  public abstract List<InviteBorrowModel> listInviteBorrow(Map<String, Object> paramMap);
}
