package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.UserInvite;
import com.cashloan.cl.model.InviteBorrowModel;
import com.cashloan.cl.model.ManageAgentModel;
import com.cashloan.cl.model.ManageProfitModel;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.Map;

public abstract interface UserInviteService
  extends BaseService<UserInvite, Long>
{
  public abstract Map<String, Object> findPhone(long paramLong);
  
  public abstract Page<ManageProfitModel> findAgent(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws ServiceException;
  
  public abstract Page<ManageAgentModel> findSysAgent(String paramString, int paramInt1, int paramInt2);
  
  public abstract Page<InviteBorrowModel> listInviteBorrow(long paramLong, int paramInt1, int paramInt2);
}
