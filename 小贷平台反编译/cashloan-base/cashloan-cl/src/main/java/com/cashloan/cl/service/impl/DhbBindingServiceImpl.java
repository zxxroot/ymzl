/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.DhbBinding;
/*    */ import com.cashloan.cl.mapper.DhbBindingMapper;
/*    */ import com.cashloan.cl.service.DhbBindingService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.util.List;
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
/*    */ @Service("dhbBindingService")
/*    */ public class DhbBindingServiceImpl
/*    */   extends BaseServiceImpl<DhbBinding, Long>
/*    */   implements DhbBindingService
/*    */ {
/*    */   @Resource
/*    */   private DhbBindingMapper dhbBindingMapper;
/*    */   
/*    */   public BaseMapper<DhbBinding, Long> getMapper()
/*    */   {
/* 32 */     return this.dhbBindingMapper;
/*    */   }
/*    */   
/*    */   public DhbBinding findSelective(Map<String, Object> map)
/*    */   {
/* 37 */     List<DhbBinding> list = this.dhbBindingMapper.listSelective(map);
/* 38 */     if ((list == null) || (list.isEmpty())) {
/* 39 */       return new DhbBinding();
/*    */     }
/* 41 */     return (DhbBinding)list.get(0);
/*    */   }
/*    */ }


/*impl\DhbBindingServiceImpl.class

 */