/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.cashloan.cl.domain.DhbUserBasic;
/*    */ import com.cashloan.cl.mapper.DhbUserBasicMapper;
/*    */ import com.cashloan.cl.service.DhbUserBasicService;
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
/*    */ @Service("dhbUserBasicService")
/*    */ public class DhbUserBasicServiceImpl
/*    */   extends BaseServiceImpl<DhbUserBasic, Long>
/*    */   implements DhbUserBasicService
/*    */ {
/*    */   @Resource
/*    */   private DhbUserBasicMapper dhbUserBasicMapper;
/*    */   
/*    */   public BaseMapper<DhbUserBasic, Long> getMapper()
/*    */   {
/* 32 */     return this.dhbUserBasicMapper;
/*    */   }
/*    */   
/*    */   public DhbUserBasic findSelective(Map<String, Object> map)
/*    */   {
/* 37 */     List<DhbUserBasic> list = this.dhbUserBasicMapper.listSelective(map);
/* 38 */     if ((list == null) || (list.isEmpty())) {
/* 39 */       return new DhbUserBasic();
/*    */     }
/* 41 */     return (DhbUserBasic)list.get(0);
/*    */   }
/*    */   
/*    */   public List<DhbUserBasic> listSelective(Map<String, Object> map)
/*    */   {
/* 46 */     return this.dhbUserBasicMapper.listSelective(map);
/*    */   }
/*    */ }


/*impl\DhbUserBasicServiceImpl.class

 */