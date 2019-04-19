/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */
/*    */

import com.cashloan.cl.domain.ChannelApp;
import com.cashloan.cl.mapper.ChannelAppMapper;
import com.cashloan.cl.model.ChannelAppModel;
import com.cashloan.cl.service.ChannelAppService;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("channelAppService")
/*    */ public class ChannelAppServiceImpl
/*    */   extends BaseServiceImpl<ChannelApp, Long>
/*    */   implements ChannelAppService
/*    */ {
/*    */   @Resource
/*    */   private ChannelAppMapper channelAppMapper;
/*    */   
/*    */   public BaseMapper<ChannelApp, Long> getMapper()
/*    */   {
/* 36 */     return null;
/*    */   }
/*    */   
/*    */   public List<ChannelAppModel> listChannelAppModel()
/*    */   {
/* 41 */     List<ChannelAppModel> list = this.channelAppMapper.listChannelAppModel();
/* 42 */     if ((list != null) && (list.size() > 0)) {
/* 43 */       for (int i = 0; i < list.size(); i++) {
/* 44 */         ChannelAppModel app = new ChannelAppModel();
/* 45 */         app.setAppType(((ChannelAppModel)list.get(i)).getAppType());
/* 46 */         ((ChannelAppModel)list.get(i)).setAppTypeStr(app.getAppTypeStr());
/*    */       }
/*    */     }
/* 49 */     return list;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ChannelApp> listChannelApp()
/*    */   {
/* 55 */     return this.channelAppMapper.listSelective();
/*    */   }
/*    */   
/*    */   public ChannelApp findByPrimary(long id)
/*    */   {
/* 60 */     return this.channelAppMapper.findByPrimary(id);
/*    */   }
/*    */   
/*    */   public int save(ChannelApp channelApp)
/*    */   {
/* 65 */     return this.channelAppMapper.save(channelApp);
/*    */   }
/*    */   
/*    */   public int updateSelective(Map<String, Object> paramMap)
/*    */   {
/* 70 */     return this.channelAppMapper.updateSelective(paramMap);
/*    */   }
/*    */ }
