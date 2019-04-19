package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.ProfitAgent;
import com.cashloan.cl.model.ManageAgentListModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.User;
import java.util.Date;

public abstract interface ProfitAgentService
  extends BaseService<ProfitAgent, Long>
{
  public abstract int pass(int paramInt, long paramLong);
  
  public abstract int rankUp(long paramLong1, long paramLong2);
  
  public abstract Page<ManageAgentListModel> findAgentList(String paramString, int paramInt1, int paramInt2);
  
  public abstract Page<User> findUserLevel(String paramString, int paramInt1, int paramInt2);
  
  public abstract int freezeAgent(long paramLong, Date paramDate);
  
  public abstract int saveOne(long paramLong, Date paramDate);
  
  public abstract int saveTwo(long paramLong, String paramString1, String paramString2, Date paramDate);
}
