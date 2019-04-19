/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.domain.QianchengReqlog;
/*    */ import com.cashloan.cl.mapper.QianchengReqlogMapper;
/*    */ import com.cashloan.cl.model.QianchengReqlogModel;
/*    */ import com.cashloan.cl.service.QianchengReqlogService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("qianchengReqlogService")
/*    */ public class QianchengReqlogServiceImpl
/*    */   extends BaseServiceImpl<QianchengReqlog, Long>
/*    */   implements QianchengReqlogService
/*    */ {
/*    */   @Resource
/*    */   private QianchengReqlogMapper qianchengReqlogMapper;
/*    */   
/*    */   public BaseMapper<QianchengReqlog, Long> getMapper()
/*    */   {
/* 40 */     return this.qianchengReqlogMapper;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Page<QianchengReqlogModel> listQianchengReqlog(Map<String, Object> params, int currentPage, int pageSize)
/*    */   {
/* 47 */     PageHelper.startPage(currentPage, pageSize);
/* 48 */     List<QianchengReqlogModel> list = this.qianchengReqlogMapper.listQianchengReqlog(params);
/* 49 */     if ((list != null) && (list.size() > 0)) {
/* 50 */       for (int i = 0; i < list.size(); i++) {
/* 51 */         QianchengReqlogModel reqLog = new QianchengReqlogModel();
/* 52 */         reqLog.setState(((QianchengReqlogModel)list.get(i)).getState());
/* 53 */         ((QianchengReqlogModel)list.get(i)).setStateStr(reqLog.getStateStr());
/*    */       }
/*    */     }
/* 56 */     return (Page)list;
/*    */   }
/*    */   
/*    */ 
/*    */   public QianchengReqlog findByOrderNo(String orderNo)
/*    */   {
/* 62 */     return this.qianchengReqlogMapper.findByOrderNo(orderNo);
/*    */   }
/*    */   
/*    */ 
/*    */   public int update(QianchengReqlog reqLog)
/*    */   {
/* 68 */     return this.qianchengReqlogMapper.update(reqLog);
/*    */   }
/*    */   
/*    */ 
/*    */   public QianchengReqlog findByBorrowId(Long borrowId)
/*    */   {
/* 74 */     return this.qianchengReqlogMapper.findByBorrowId(borrowId);
/*    */   }
/*    */ }


/*impl\QianchengReqlogServiceImpl.class

 */