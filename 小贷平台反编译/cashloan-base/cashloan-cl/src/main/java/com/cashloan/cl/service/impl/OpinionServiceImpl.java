/*    */ package com.cashloan.cl.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.Page;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.cashloan.cl.domain.Opinion;
/*    */ import com.cashloan.cl.mapper.OpinionMapper;
/*    */ import com.cashloan.cl.model.OpinionModel;
/*    */ import com.cashloan.cl.service.OpinionService;
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("opinionService")
/*    */ public class OpinionServiceImpl
/*    */   extends BaseServiceImpl<Opinion, Long>
/*    */   implements OpinionService
/*    */ {
/* 26 */   private static final Logger logger = LoggerFactory.getLogger(OpinionServiceImpl.class);
/*    */   
/*    */   @Resource
/*    */   private OpinionMapper opinionMapper;
/*    */   
/*    */   public BaseMapper<Opinion, Long> getMapper()
/*    */   {
/* 33 */     return this.opinionMapper;
/*    */   }
/*    */   
/*    */   public int save(long userId, String opinion)
/*    */   {
/* 38 */     Opinion o = new Opinion();
/* 39 */     o.setUserId(Long.valueOf(userId));
/* 40 */     o.setOpinion(opinion);
/* 41 */     o.setCreateTime(DateUtil.getNow());
/* 42 */     o.setState("10");
/* 43 */     return this.opinionMapper.save(o);
/*    */   }
/*    */   
/*    */   public int updateSelective(Map<String, Object> searchMap)
/*    */   {
/* 48 */     return this.opinionMapper.updateSelective(searchMap);
/*    */   }
/*    */   
/*    */   public List<Opinion> getOpinion(Map<String, Object> paramMap)
/*    */   {
/* 53 */     List<Opinion> list = this.opinionMapper.listSelective(paramMap);
/* 54 */     return list;
/*    */   }
/*    */   
/*    */ 
/*    */   public Page<OpinionModel> page(Map<String, Object> searchMap, int current, int pageSize)
/*    */   {
/* 60 */     PageHelper.startPage(current, pageSize);
/* 61 */     List<OpinionModel> list = this.opinionMapper.listModel(searchMap);
/* 62 */     for (int i = 0; i < list.size(); i++) {
/* 63 */       OpinionModel opinionModel = (OpinionModel)list.get(i);
/* 64 */       if ("10".equals(opinionModel.getState())) {
/* 65 */         opinionModel.setStateStr("待确认");
/* 66 */       } else if ("20".equals(opinionModel.getState())) {
/* 67 */         opinionModel.setStateStr("已确认");
/*    */       }
/* 69 */       list.set(i, opinionModel);
/*    */     }
/* 71 */     return (Page)list;
/*    */   }
/*    */ }
