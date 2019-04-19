package com.cashloan.cl.service;

import com.cashloan.cl.model.ChannelBorrowModel;
import com.cashloan.cl.model.KeyValue;
import com.github.pagehelper.Page;
import com.cashloan.cl.domain.Channel;
import com.cashloan.cl.model.ChannelCountModel;
import com.cashloan.cl.model.ChannelListModel;
import com.cashloan.cl.model.ChannelStaffCountModel;
import com.cashloan.cl.model.ChannelStaffModel;
import com.rongdu.cashloan.core.common.service.BaseService;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public abstract interface ChannelService
  extends BaseService<Channel, Long>
{
  public abstract Map<String, Object> save(Map<String, Object> paramMap, String paramString1, String paramString2, String paramString3);
  
  public abstract long findIdByCode(String paramString);
  
  public abstract Channel findByCode(String paramString);
  
  public abstract Page<ChannelListModel> page(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract Page<Channel> pageChannel(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract Page<ChannelCountModel> channelUserList(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract List<Channel> listChannel();
  
  public abstract Page<Channel> listChannel1(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract List<Channel> listMyChannel(String paramString);
  
  public abstract List<Channel> listChannelWithoutApp();
  
  public abstract List<Map<String, Object>> channelUserCount(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<Map<String, Object>> statisticsCpa(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Map<String, Object> statisticsMySelfCpa(Map<String, Object> paramMap);
  
  public abstract Page<ChannelStaffCountModel> channelCount(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws ParseException;
  
  public abstract ChannelStaffModel channelStaffDetails(Long paramLong);
  
  public abstract List<Channel> relationChannelList(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> updateChannelById(Long paramLong, String[] paramArrayOfString);
  
  public abstract boolean updateState(Map<String, Object> paramMap);
  
  public abstract Channel channelDetails(Long paramLong);
  
  public abstract boolean update(Long paramLong, String paramString, Map<String, Object> paramMap);
  
  public abstract List<?> listChannel(Map<String, Object> paramMap);
  
  public abstract Page<ChannelBorrowModel> listBorrowModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract boolean updatechannelUV(String paramString1, String paramString2);
  
  public abstract List<KeyValue> listChannelContactId();
  
  public abstract List<Channel> relationChannelListALL(Map<String, Object> paramMap);
}
