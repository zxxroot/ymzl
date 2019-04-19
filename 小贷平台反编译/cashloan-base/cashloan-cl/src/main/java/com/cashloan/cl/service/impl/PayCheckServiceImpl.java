/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.domain.PayCheck;
/*    */ import com.cashloan.cl.mapper.PayCheckMapper;
/*    */ import com.cashloan.cl.model.ManagePayCheckModel;
/*    */ import com.cashloan.cl.service.PayCheckService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
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
/*    */ @Service("payCheckService")
/*    */ public class PayCheckServiceImpl
/*    */   extends BaseServiceImpl<PayCheck, Long>
/*    */   implements PayCheckService
/*    */ {
/* 34 */   private static final Logger logger = LoggerFactory.getLogger(PayCheckServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private PayCheckMapper payCheckMapper;
/*    */   
/*    */   public BaseMapper<PayCheck, Long> getMapper()
/*    */   {
/* 41 */     return this.payCheckMapper;
/*    */   }
/*    */   
/*    */   public boolean save(PayCheck payCheck)
/*    */   {
/* 46 */     int result = this.payCheckMapper.save(payCheck);
/* 47 */     if (result > 0) {
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public Page<ManagePayCheckModel> page(int current, int pageSize, Map<String, Object> searchMap)
/*    */   {
/* 56 */     PageHelper.startPage(current, pageSize);
/* 57 */     Page<ManagePayCheckModel> page = (Page)this.payCheckMapper.page(searchMap);
/* 58 */     return page;
/*    */   }
/*    */   
/*    */   public PayCheck findSelective(Map<String, Object> searchMap)
/*    */   {
/* 63 */     PayCheck payCheck = null;
/*    */     try {
/* 65 */       payCheck = (PayCheck)this.payCheckMapper.findSelective(searchMap);
/*    */     } catch (Exception e) {
/* 67 */       logger.error(e.getMessage(), e);
/*    */     }
/* 69 */     return payCheck;
/*    */   }
/*    */   
/*    */ 
/*    */   public List listPayCheck(Map<String, Object> params)
/*    */   {
/* 75 */     List<ManagePayCheckModel> list = this.payCheckMapper.page(params);
/* 76 */     return list;
/*    */   }
/*    */ }


/*impl\PayCheckServiceImpl.class

 */