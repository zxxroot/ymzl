package com.cashloan.cl.mapper;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.ChannelSettlement;
import com.cashloan.cl.model.ChannelSettlementModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ChannelSettlementMapper
  extends BaseMapper<ChannelSettlement, Long>
{
  public abstract Page<ChannelSettlementModel> page(Map<String, Object> paramMap);
  
  public abstract List<ChannelSettlement> listMode(Map<String, Object> paramMap);
  
  public abstract int updateList(ChannelSettlement paramChannelSettlement);
  
  public abstract List<Long> listChannel(Map<String, Object> paramMap);
  
  public abstract int listSaveChannel(List<ChannelSettlement> paramList);
  
  public abstract int selectChannelState(Map<String, Object> paramMap);
}
