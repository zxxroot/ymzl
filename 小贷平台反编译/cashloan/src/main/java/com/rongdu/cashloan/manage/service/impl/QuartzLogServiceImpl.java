/*    */ package com.rongdu.cashloan.manage.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.manage.domain.QuartzLog;
/*    */ import com.rongdu.cashloan.manage.mapper.QuartzLogMapper;
/*    */ import com.rongdu.cashloan.manage.model.QuartzLogModel;
/*    */ import com.rongdu.cashloan.manage.service.QuartzLogService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("quartzLogService")
/*    */ public class QuartzLogServiceImpl
/*    */   extends BaseServiceImpl<QuartzLog, Long>
/*    */   implements QuartzLogService
/*    */ {
/* 38 */   private static final Logger logger = LoggerFactory.getLogger(QuartzLogServiceImpl.class);
/*    */   
/*    */ 
/*    */   @Resource
/*    */   private QuartzLogMapper quartzLogMapper;
/*    */   
/*    */ 
/*    */ 
/*    */   public BaseMapper<QuartzLog, Long> getMapper()
/*    */   {
/* 48 */     return this.quartzLogMapper;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int save(QuartzLog ql)
/*    */   {
/* 56 */     return this.quartzLogMapper.save(ql);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Page<QuartzLogModel> page(Map<String, Object> searchMap, int current, int pageSize)
/*    */   {
/* 65 */     PageHelper.startPage(current, pageSize);
/* 66 */     List<QuartzLogModel> list = this.quartzLogMapper.page(searchMap);
/* 67 */     return (Page)list;
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\service\impl\QuartzLogServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */