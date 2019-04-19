/*     */ package com.rongdu.cashloan.rc.service.impl;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.mapper.UserMapper;
/*     */ import com.rongdu.cashloan.rc.domain.BorrowCount;
/*     */ import com.rongdu.cashloan.rc.mapper.BorrowCountMapper;
/*     */ import com.rongdu.cashloan.rc.mapper.RcBorrowCountMapper;
/*     */ import com.rongdu.cashloan.rc.mapper.RcBorrowRepayCountMapper;
/*     */ import com.rongdu.cashloan.rc.service.BorrowCountService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.DateUtil;
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
/*     */ @Service("borrowCountService")
/*     */ public class BorrowCountServiceImpl
/*     */   extends BaseServiceImpl<BorrowCount, Long>
/*     */   implements BorrowCountService
/*     */ {
/*  41 */   private static final Logger logger = LoggerFactory.getLogger(BorrowCountServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private BorrowCountMapper borrowCountMapper;
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   @Resource
/*     */   private RcBorrowCountMapper rcBorrowCountMapper;
/*     */   @Resource
/*     */   private RcBorrowRepayCountMapper rcBorrowRepayCountMapper;
/*     */   
/*     */   public BaseMapper<BorrowCount, Long> getMapper()
/*     */   {
/*  54 */     return this.borrowCountMapper;
/*     */   }
/*     */   
/*     */   public int countBorrowRefusedTimes(Long userId) {
/*  58 */     BorrowCount bc = new BorrowCount();
/*  59 */     bc.setUserId(userId);
/*     */     
/*  61 */     bc.setCount(this.rcBorrowCountMapper.borrowCount(userId));
/*  62 */     bc.setFailCount(this.rcBorrowCountMapper.borrowFailCount(userId));
/*  63 */     bc.setDayFailCount(this.rcBorrowCountMapper.dayFailCount(userId));
/*  64 */     bc.setCountOne(this.rcBorrowCountMapper.failCount(userId));
/*  65 */     bc.setCountTwo(this.rcBorrowRepayCountMapper.countFailNinety(userId));
/*  66 */     bc.setCountThree(this.rcBorrowRepayCountMapper.countFailThirty(userId));
/*  67 */     bc.setCountFour(this.rcBorrowRepayCountMapper.countFailWithinThirty(userId));
/*     */     
/*  69 */     bc.setCountFive(this.rcBorrowCountMapper.failCountRelative(userId));
/*  70 */     bc.setCountSix(this.rcBorrowRepayCountMapper.countRelativeNinety(userId));
/*  71 */     bc.setCountSeven(this.rcBorrowRepayCountMapper.countRelativeThirty(userId));
/*  72 */     bc.setCountEight(this.rcBorrowRepayCountMapper.countRelativeWithinThirty(userId));
/*     */     
/*  74 */     bc.setCreateTime(DateUtil.getNow());
/*     */     
/*  76 */     return this.borrowCountMapper.save(bc);
/*     */   }
/*     */   
/*     */   public int save()
/*     */   {
/*  81 */     int msg = 0;
/*  82 */     Map<String, Object> paramMap = new HashMap();
/*  83 */     List<User> list = this.userMapper.listSelective(paramMap);
/*  84 */     BorrowCount bc = new BorrowCount();
/*  85 */     for (User user : list) {
/*  86 */       bc.setUserId(user.getId());
/*     */       
/*  88 */       bc.setCount(this.rcBorrowCountMapper.borrowCount(user.getId()));
/*  89 */       bc.setFailCount(this.rcBorrowCountMapper.borrowFailCount(user.getId()));
/*  90 */       bc.setDayFailCount(this.rcBorrowCountMapper.dayFailCount(user.getId()));
/*  91 */       bc.setCountOne(this.rcBorrowCountMapper.failCount(user.getId()));
/*  92 */       bc.setCountTwo(this.rcBorrowRepayCountMapper.countFailNinety(user.getId()));
/*  93 */       bc.setCountThree(this.rcBorrowRepayCountMapper.countFailThirty(user.getId()));
/*  94 */       bc.setCountFour(this.rcBorrowRepayCountMapper.countFailWithinThirty(user.getId()));
/*     */       
/*  96 */       bc.setCountFive(this.rcBorrowCountMapper.failCountRelative(user.getId()));
/*  97 */       bc.setCountSix(this.rcBorrowRepayCountMapper.countRelativeNinety(user.getId()));
/*  98 */       bc.setCountSeven(this.rcBorrowRepayCountMapper.countRelativeThirty(user.getId()));
/*  99 */       bc.setCountEight(this.rcBorrowRepayCountMapper.countRelativeWithinThirty(user.getId()));
/*     */       
/* 101 */       bc.setCreateTime(DateUtil.getNow());
/*     */       
/* 103 */       msg = this.borrowCountMapper.save(bc);
/*     */     }
/* 105 */     return msg;
/*     */   }
/*     */   
/*     */   public int dispose(long userId, int i) {
/* 109 */     int msg = 0;
/* 110 */     return msg;
/*     */   }
/*     */ }
