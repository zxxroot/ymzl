/*     */ package com.rongdu.cashloan.rc.service.impl;
/*     */ 
/*     */

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.rc.domain.SceneBusinessLog;
import com.rongdu.cashloan.rc.mapper.SceneBusinessLogMapper;
import com.rongdu.cashloan.rc.mapper.SceneBusinessMapper;
import com.rongdu.cashloan.rc.service.BorrowCountService;
import com.rongdu.cashloan.rc.service.ContactCountService;
import com.rongdu.cashloan.rc.service.OperatorCountService;
import com.rongdu.cashloan.rc.service.SceneBusinessLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("sceneBusinessLogService")
/*     */ @Transactional(rollbackFor={Exception.class})
/*     */ public class SceneBusinessLogServiceImpl
/*     */   extends BaseServiceImpl<SceneBusinessLog, Long>
/*     */   implements SceneBusinessLogService
/*     */ {
/*  32 */   public static final Logger logger = LoggerFactory.getLogger(SceneBusinessLogServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private SceneBusinessLogMapper sceneBusinessLogMapper;
/*     */   @Resource
/*     */   private SceneBusinessMapper sceneBusinessMapper;
/*     */   @Resource
/*     */   private BorrowCountService borrowCountService;
/*     */   @Resource
/*     */   private ContactCountService contactCountService;
/*     */   @Resource
/*     */   private OperatorCountService operatorCountService;
/*     */   
/*     */   public BaseMapper<SceneBusinessLog, Long> getMapper()
/*     */   {
/*  47 */     return this.sceneBusinessLogMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean needExcute(Long userId, Long busId, String getWay, String period)
/*     */   {
/*     */     try
/*     */     {
/*  60 */       if ("10".equals(getWay))
/*  61 */         return true;
/*  62 */       if ("20".equals(getWay)) {
/*  63 */         if (StringUtil.isNotBlank(period)) {
/*  64 */           int days = Integer.parseInt(period);
/*  65 */           SceneBusinessLog log = this.sceneBusinessLogMapper.findLastExcute(userId, busId);
/*     */           
/*  67 */           if (log == null) {
/*  68 */             return true;
/*     */           }
/*  70 */           Calendar cl = Calendar.getInstance();
/*  71 */           cl.setTime(log.getCreateTime());
/*  72 */           cl.set(5, cl.get(5) + days);
/*     */           
/*  74 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  75 */           Date nextTime = sdf.parse(sdf.format(cl.getTime()));
/*     */           
/*  77 */           Date nowTime = sdf.parse(sdf.format(new Date()));
/*  78 */           if ((nextTime.equals(nowTime)) || (nextTime.before(nowTime))) {
/*  79 */             return true;
/*     */           }
/*     */         }
/*  82 */       } else if ("00".equals(getWay)) {
/*  83 */         SceneBusinessLog log = this.sceneBusinessLogMapper.findLastExcute(userId, busId);
/*  84 */         if (log == null) {
/*  85 */           return true;
/*     */         }
/*     */       }
/*     */     } catch (ParseException e) {
/*  89 */       logger.error("数据接口执行错误");
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean needExcute(String phone, Long busId, String getWay, String period)
/*     */   {
/*     */     try
/*     */     {
/* 104 */       if ("10".equals(getWay))
/* 105 */         return true;
/* 106 */       if ("20".equals(getWay)) {
/* 107 */         if (StringUtil.isNotBlank(period)) {
/* 108 */           int days = Integer.parseInt(period);
/* 109 */           SceneBusinessLog log = this.sceneBusinessLogMapper.findLastExcuteByPhone(phone, busId);
/*     */           
/* 111 */           if (log == null) {
/* 112 */             return true;
/*     */           }
/* 114 */           Calendar cl = Calendar.getInstance();
/* 115 */           cl.setTime(log.getCreateTime());
/* 116 */           cl.set(5, cl.get(5) + days);
/*     */           
/* 118 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 119 */           Date nextTime = sdf.parse(sdf.format(cl.getTime()));
/*     */           
/* 121 */           Date nowTime = sdf.parse(sdf.format(new Date()));
/* 122 */           if ((nextTime.equals(nowTime)) || (nextTime.before(nowTime))) {
/* 123 */             return true;
/*     */           }
/*     */         }
/* 126 */       } else if ("00".equals(getWay)) {
/* 127 */         SceneBusinessLog log = this.sceneBusinessLogMapper.findLastExcuteByPhone(phone, busId);
/* 128 */         if (log == null) {
/* 129 */           return true;
/*     */         }
/*     */       }
/*     */     } catch (ParseException e) {
/* 133 */       logger.error("数据接口执行错误");
/*     */     }
/* 135 */     return false;
/*     */   }
/*     */   
/*     */   public boolean haveNeedExcuteService(SceneBusinessLog bean)
/*     */   {
/* 140 */     int count = this.sceneBusinessLogMapper.countUnFinishLog(bean);
/* 141 */     return count > 0;
/*     */   }
/*     */ }
