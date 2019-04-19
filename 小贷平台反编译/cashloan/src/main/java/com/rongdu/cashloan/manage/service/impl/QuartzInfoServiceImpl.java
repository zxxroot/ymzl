/*     */ package com.rongdu.cashloan.manage.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.manage.domain.QuartzInfo;
/*     */ import com.rongdu.cashloan.manage.mapper.QuartzInfoMapper;
/*     */ import com.rongdu.cashloan.manage.mapper.QuartzLogMapper;
/*     */ import com.rongdu.cashloan.manage.model.QuartzInfoModel;
/*     */ import com.rongdu.cashloan.manage.service.QuartzInfoService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.DateUtil;
/*     */ import tool.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("quartzInfoService")
/*     */ public class QuartzInfoServiceImpl
/*     */   extends BaseServiceImpl<QuartzInfo, Long>
/*     */   implements QuartzInfoService
/*     */ {
/*  40 */   private static final Logger logger = LoggerFactory.getLogger(QuartzInfoServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private QuartzInfoMapper quartzInfoMapper;
/*     */   
/*     */   @Resource
/*     */   private QuartzLogMapper quartzLogMapper;
/*     */   
/*     */   public BaseMapper<QuartzInfo, Long> getMapper()
/*     */   {
/*  50 */     return this.quartzInfoMapper;
/*     */   }
/*     */   
/*     */   public boolean save(QuartzInfo qi)
/*     */   {
/*  55 */     int result = this.quartzInfoMapper.save(qi);
/*  56 */     if (result > 0) {
/*  57 */       return true;
/*     */     }
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   public boolean update(Map<String, Object> search)
/*     */   {
/*  64 */     int result = this.quartzInfoMapper.updateSelective(search);
/*  65 */     if (result > 0) {
/*  66 */       return true;
/*     */     }
/*  68 */     return false;
/*     */   }
/*     */   
/*     */   public List<QuartzInfo> list(Map<String, Object> result)
/*     */   {
/*  73 */     return this.quartzInfoMapper.listSelective(result);
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<QuartzInfoModel> page(Map<String, Object> searchMap, int current, int pageSize)
/*     */   {
/*  79 */     PageHelper.startPage(current, pageSize);
/*  80 */     List<QuartzInfoModel> list = this.quartzInfoMapper.page(searchMap);
/*     */     
/*  82 */     for (QuartzInfoModel quartzInfoModel : list) {
/*  83 */       String lastStartTime = this.quartzLogMapper.findLastTimeByQzInfoId(quartzInfoModel.getId());
/*  84 */       if (StringUtil.isNotBlank(lastStartTime)) {
/*  85 */         quartzInfoModel.setLastStartTime(DateUtil.valueOf(lastStartTime));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  90 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public QuartzInfo findByCode(String code)
/*     */   {
/*     */     try {
/*  96 */       Map<String, Object> paramMap = new HashMap();
/*  97 */       paramMap.put("code", code);
/*  98 */       QuartzInfo quartzInfo = (QuartzInfo)this.quartzInfoMapper.findSelective(paramMap);
/*  99 */       if (quartzInfo != null) {
/* 100 */         return quartzInfo;
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       logger.error("查询定时任务异常", e);
/*     */     }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public QuartzInfo findSelective(Map<String, Object> paramMap)
/*     */   {
/*     */     try {
/* 111 */       QuartzInfo quartzInfo = (QuartzInfo)this.quartzInfoMapper.findSelective(paramMap);
/* 112 */       if (quartzInfo != null) {
/* 113 */         return quartzInfo;
/*     */       }
/*     */     } catch (Exception e) {
/* 116 */       logger.error("查询定时任务异常", e);
/*     */     }
/* 118 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\service\impl\QuartzInfoServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */