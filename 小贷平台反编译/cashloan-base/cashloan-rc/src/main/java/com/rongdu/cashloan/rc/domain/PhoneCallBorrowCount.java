/*     */ package com.rongdu.cashloan.rc.domain;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.rc.model.OperatorCountModel;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
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
/*     */ public class PhoneCallBorrowCount
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Integer countTwenty;
/*     */   private Integer countTwentyOne;
/*     */   private Integer countTwentyTwo;
/*     */   private Integer countTwentyThree;
/*     */   private Integer countTwentyFour;
/*     */   private Date createTime;
/*     */   private Date updateTime;
/*     */   
/*     */   public PhoneCallBorrowCount() {}
/*     */   
/*     */   public PhoneCallBorrowCount(OperatorCountModel model)
/*     */   {
/*  69 */     this.userId = model.getUserId();
/*  70 */     this.countTwenty = model.getPre20NumBorrowY90();
/*  71 */     this.countTwentyOne = model.getPre20NumBorrowN90();
/*  72 */     this.countTwentyTwo = model.getPre20NumBorrowN90M3();
/*  73 */     this.countTwentyThree = model.getPre20NumBorrowNMore30M1();
/*  74 */     this.countTwentyFour = model.getPre20NumBorrowNLess30M1();
/*  75 */     this.createTime = DateUtil.getNow();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  85 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  93 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 101 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 109 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwenty()
/*     */   {
/* 117 */     return this.countTwenty;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwenty(Integer countTwenty)
/*     */   {
/* 125 */     this.countTwenty = countTwenty;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwentyOne()
/*     */   {
/* 133 */     return this.countTwentyOne;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwentyOne(Integer countTwentyOne)
/*     */   {
/* 141 */     this.countTwentyOne = countTwentyOne;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwentyTwo()
/*     */   {
/* 149 */     return this.countTwentyTwo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwentyTwo(Integer countTwentyTwo)
/*     */   {
/* 157 */     this.countTwentyTwo = countTwentyTwo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwentyThree()
/*     */   {
/* 165 */     return this.countTwentyThree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwentyThree(Integer countTwentyThree)
/*     */   {
/* 173 */     this.countTwentyThree = countTwentyThree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwentyFour()
/*     */   {
/* 181 */     return this.countTwentyFour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwentyFour(Integer countTwentyFour)
/*     */   {
/* 189 */     this.countTwentyFour = countTwentyFour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 197 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 205 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 213 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 221 */     this.updateTime = updateTime;
/*     */   }
/*     */ }
