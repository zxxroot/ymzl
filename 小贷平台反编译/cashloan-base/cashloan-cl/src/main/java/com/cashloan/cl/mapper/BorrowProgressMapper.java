package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.BorrowProgress;
import com.cashloan.cl.model.BorrowProgressModel;
import com.cashloan.cl.model.ManageBorrowProgressModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface BorrowProgressMapper
  extends BaseMapper<BorrowProgress, Long>
{
  public abstract List<BorrowProgressModel> listIndex(Map<String, Object> paramMap);
  
  public abstract List<ManageBorrowProgressModel> listModel(Map<String, Object> paramMap);
  
  public abstract List<BorrowProgressModel> listProgress(Map<String, Object> paramMap);
}
