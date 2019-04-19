package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.domain.ChannelSettlement;
import com.cashloan.cl.model.ChannelSettlementModel;
import com.rongdu.cashloan.core.common.service.BaseService;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public abstract interface ChannelSettlementService
  extends BaseService<ChannelSettlement, Long>
{
  public abstract Page<ChannelSettlementModel> channelStaffDetails(int paramInt1, int paramInt2, Map<String, Object> paramMap);
  
  public abstract int fileBatchRepay(MultipartFile paramMultipartFile, String paramString1, String paramString2)
    throws Exception;
  
  public abstract boolean channelSettlementGenerate();
  
  public abstract List<?> listChannelStaff(Map<String, Object> paramMap);
}


/*ChannelSettlementService.class

 */