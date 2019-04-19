/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.YoudunDevicesList;
/*    */ import com.cashloan.cl.mapper.YoudunDevicesListMapper;
/*    */ import com.cashloan.cl.service.YoudunDevicesListService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
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
/*    */ @Service("youdunDevicesListService")
/*    */ public class YoudunDevicesListServiceImpl
/*    */   extends BaseServiceImpl<YoudunDevicesList, Long>
/*    */   implements YoudunDevicesListService
/*    */ {
/*    */   @Resource
/*    */   private YoudunDevicesListMapper youdunDevicesListMapper;
/*    */   
/*    */   public BaseMapper<YoudunDevicesList, Long> getMapper()
/*    */   {
/* 34 */     return this.youdunDevicesListMapper;
/*    */   }
/*    */ }
