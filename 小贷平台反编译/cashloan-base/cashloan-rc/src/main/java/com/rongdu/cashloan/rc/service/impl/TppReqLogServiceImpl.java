/*    */ package com.rongdu.cashloan.rc.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.rc.domain.TppReqLog;
/*    */ import com.rongdu.cashloan.rc.mapper.TppReqLogMapper;
/*    */ import com.rongdu.cashloan.rc.service.TppReqLogService;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
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
/*    */ @Service("tppReqLogService")
/*    */ public class TppReqLogServiceImpl
/*    */   extends BaseServiceImpl<TppReqLog, Long>
/*    */   implements TppReqLogService
/*    */ {
/*    */   @Resource
/*    */   private TppReqLogMapper tppReqLogMapper;
/*    */   
/*    */   public BaseMapper<TppReqLog, Long> getMapper()
/*    */   {
/* 35 */     return this.tppReqLogMapper;
/*    */   }
/*    */   
/*    */   public int modifyTppReqLog(TppReqLog log)
/*    */   {
/* 40 */     return this.tppReqLogMapper.modifyTppReqLog(log);
/*    */   }
/*    */   
/*    */   public TppReqLog findSelective(Map<String, Object> params)
/*    */   {
/* 45 */     return (TppReqLog)this.tppReqLogMapper.findSelective(params);
/*    */   }
/*    */ }
