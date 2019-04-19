package com.cashloan.cl.mapper;

import com.cashloan.cl.model.ChannelBorrowModel;
import com.cashloan.cl.model.KeyValue;
import com.github.pagehelper.Page;
import com.cashloan.cl.domain.Channel;
import com.cashloan.cl.model.ChannelCountModel;
import com.cashloan.cl.model.ChannelListModel;
import com.cashloan.cl.model.ChannelStaffCountModel;
import com.cashloan.cl.model.ChannelStaffModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ChannelMapper
  extends BaseMapper<Channel, Long>
{
  public abstract long findIdSelective(Map<String, Object> paramMap);
  
  public abstract Channel findSelective(Map<String, Object> paramMap);
  
  public abstract List<ChannelListModel> page(Map<String, Object> paramMap);
  
  public abstract Page<ChannelCountModel> channelUserList(Map<String, Object> paramMap);
  
  public abstract List<Channel> listChannel();
  
  public abstract List<Map<String, Object>> listMyChannel2(Map<String, Object> paramMap);
  
  public abstract List<Channel> listMyChannel1(Map<String, Object> paramMap);
  
  public abstract List<Channel> listChannelWithoutApp();
  
  public abstract List<Map<String, Object>> countOne(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countTwo(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countThree(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countFour(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countFive(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countSix(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countSeven(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countEight(Map<String, Object> paramMap);
  
  public abstract List<ChannelStaffCountModel> listSysUserByRole(Map<String, Object> paramMap);
  
  public abstract List<String> userBorrow(Map<String, Object> paramMap);
  
  public abstract List<String> userBorrow2(Map<String, Object> paramMap);
  
  public abstract List<String> userBorrow3(Map<String, Object> paramMap);
  
  public abstract List<String> userBorrow4(Map<String, Object> paramMap);
  
  public abstract int countOrder(Map<String, Object> paramMap);
  
  public abstract ChannelStaffModel SysUserDetailsByUserId(@Param("userId") Long paramLong);
  
  public abstract List<Channel> channelByIdList(@Param("list") List<String> paramList);
  
  public abstract int updateByIdList(Map<String, Object> paramMap);
  
  public abstract int updateByUserId(Long paramLong);
  
  public abstract int selectChannelId(@Param("code") String paramString);
  
  public abstract List<ChannelBorrowModel> listBorrowModel(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countNine(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countTen(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countEleven(Map<String, Object> paramMap);
  
  public abstract List<KeyValue> listChannelContactId(Map<String, Object> paramMap);
  
  public abstract int addchannelUV(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> countUV(Map<String, Object> paramMap);
  
  public abstract int selectUserChannel(Map<String, Object> paramMap);
  
  public abstract List<Channel> listSelectiveChannel(Map<String, Object> paramMap);
  
  public abstract int selectChannelUV(Map<String, Object> paramMap);
  
  public abstract Long selectChannelCode(@Param("code") String paramString);
  
  public abstract int updateChannelNum(Map<String, Object> paramMap);
  
  public abstract List<String> userRegister(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> promotion(Map<String, Object> paramMap);
  
  public abstract List<Long> listMyUser(Long paramLong);
}
