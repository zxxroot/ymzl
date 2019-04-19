/*     */ package com.rongdu.cashloan.rc.model;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class OperatorCountModel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Integer emerConcatTimes6Month;
/*     */   private Integer countVoices90;
/*     */   private Integer liveAddrVoice90N;
/*     */   private Integer voiceTimes30;
/*     */   private Integer voiceTimes30Calling;
/*     */   private Integer voiceTimes30Called;
/*     */   private Integer voiceTimes90;
/*     */   private Integer voiceTimes90Calling;
/*     */   private Integer voiceTimes90Called;
/*     */   private Integer voiceDuration30;
/*     */   private Integer voiceDuration30Calling;
/*     */   private Integer voiceDuration30Called;
/*     */   private Integer voiceDuration90;
/*     */   private Integer voiceDuration90Calling;
/*     */   private Integer voiceDuration90Called;
/*     */   private Integer phoneNumCount90;
/*     */   private Integer phoneNumCount90Calling;
/*     */   private Integer phoneNumCount90Called;
/*     */   private Double monthAmt;
/*     */   private Integer joinMonthCount;
/*     */   private Integer ge5TimesNumCount90;
/*     */   private Integer ge3Times60SNumCount90;
/*     */   private Integer pre20NumBorrowY90;
/*     */   private Integer pre20NumBorrowN90;
/*     */   private Integer pre20NumBorrowN90M3;
/*     */   private Integer pre20NumBorrowNMore30M1;
/*     */   private Integer pre20NumBorrowNLess30M1;
/*     */   private Long userId;
/*     */   private String phone;
/*     */   
/*     */   public Integer getLiveAddrVoice90N()
/*     */   {
/* 162 */     return this.liveAddrVoice90N;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLiveAddrVoice90N(Integer liveAddrVoice90N)
/*     */   {
/* 171 */     this.liveAddrVoice90N = liveAddrVoice90N;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceTimes30()
/*     */   {
/* 180 */     return this.voiceTimes30;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceTimes30(Integer voiceTimes30)
/*     */   {
/* 189 */     this.voiceTimes30 = voiceTimes30;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceTimes30Calling()
/*     */   {
/* 198 */     return this.voiceTimes30Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceTimes30Calling(Integer voiceTimes30Calling)
/*     */   {
/* 207 */     this.voiceTimes30Calling = voiceTimes30Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceTimes30Called()
/*     */   {
/* 216 */     return this.voiceTimes30Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceTimes30Called(Integer voiceTimes30Called)
/*     */   {
/* 225 */     this.voiceTimes30Called = voiceTimes30Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceTimes90()
/*     */   {
/* 234 */     return this.voiceTimes90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceTimes90(Integer voiceTimes90)
/*     */   {
/* 243 */     this.voiceTimes90 = voiceTimes90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceTimes90Calling()
/*     */   {
/* 252 */     return this.voiceTimes90Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceTimes90Calling(Integer voiceTimes90Calling)
/*     */   {
/* 261 */     this.voiceTimes90Calling = voiceTimes90Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceTimes90Called()
/*     */   {
/* 270 */     return this.voiceTimes90Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceTimes90Called(Integer voiceTimes90Called)
/*     */   {
/* 279 */     this.voiceTimes90Called = voiceTimes90Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceDuration30()
/*     */   {
/* 288 */     return this.voiceDuration30;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceDuration30(Integer voiceDuration30)
/*     */   {
/* 297 */     this.voiceDuration30 = voiceDuration30;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceDuration30Calling()
/*     */   {
/* 306 */     return this.voiceDuration30Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceDuration30Calling(Integer voiceDuration30Calling)
/*     */   {
/* 315 */     this.voiceDuration30Calling = voiceDuration30Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceDuration30Called()
/*     */   {
/* 324 */     return this.voiceDuration30Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceDuration30Called(Integer voiceDuration30Called)
/*     */   {
/* 333 */     this.voiceDuration30Called = voiceDuration30Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceDuration90()
/*     */   {
/* 342 */     return this.voiceDuration90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceDuration90(Integer voiceDuration90)
/*     */   {
/* 351 */     this.voiceDuration90 = voiceDuration90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceDuration90Calling()
/*     */   {
/* 360 */     return this.voiceDuration90Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceDuration90Calling(Integer voiceDuration90Calling)
/*     */   {
/* 369 */     this.voiceDuration90Calling = voiceDuration90Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getVoiceDuration90Called()
/*     */   {
/* 378 */     return this.voiceDuration90Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVoiceDuration90Called(Integer voiceDuration90Called)
/*     */   {
/* 387 */     this.voiceDuration90Called = voiceDuration90Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPhoneNumCount90()
/*     */   {
/* 396 */     return this.phoneNumCount90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneNumCount90(Integer phoneNumCount90)
/*     */   {
/* 405 */     this.phoneNumCount90 = phoneNumCount90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPhoneNumCount90Calling()
/*     */   {
/* 414 */     return this.phoneNumCount90Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneNumCount90Calling(Integer phoneNumCount90Calling)
/*     */   {
/* 423 */     this.phoneNumCount90Calling = phoneNumCount90Calling;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPhoneNumCount90Called()
/*     */   {
/* 432 */     return this.phoneNumCount90Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhoneNumCount90Called(Integer phoneNumCount90Called)
/*     */   {
/* 441 */     this.phoneNumCount90Called = phoneNumCount90Called;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getMonthAmt()
/*     */   {
/* 450 */     return this.monthAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMonthAmt(Double monthAmt)
/*     */   {
/* 459 */     this.monthAmt = monthAmt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getJoinMonthCount()
/*     */   {
/* 468 */     return this.joinMonthCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJoinMonthCount(Integer joinMonthCount)
/*     */   {
/* 477 */     this.joinMonthCount = joinMonthCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getGe5TimesNumCount90()
/*     */   {
/* 486 */     return this.ge5TimesNumCount90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGe5TimesNumCount90(Integer ge5TimesNumCount90)
/*     */   {
/* 495 */     this.ge5TimesNumCount90 = ge5TimesNumCount90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getGe3Times60SNumCount90()
/*     */   {
/* 504 */     return this.ge3Times60SNumCount90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGe3Times60SNumCount90(Integer ge3Times60SNumCount90)
/*     */   {
/* 513 */     this.ge3Times60SNumCount90 = ge3Times60SNumCount90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPre20NumBorrowY90()
/*     */   {
/* 522 */     return this.pre20NumBorrowY90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPre20NumBorrowY90(Integer pre20NumBorrowY90)
/*     */   {
/* 531 */     this.pre20NumBorrowY90 = pre20NumBorrowY90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPre20NumBorrowN90()
/*     */   {
/* 540 */     return this.pre20NumBorrowN90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPre20NumBorrowN90(Integer pre20NumBorrowN90)
/*     */   {
/* 549 */     this.pre20NumBorrowN90 = pre20NumBorrowN90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPre20NumBorrowN90M3()
/*     */   {
/* 558 */     return this.pre20NumBorrowN90M3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPre20NumBorrowN90M3(Integer pre20NumBorrowN90M3)
/*     */   {
/* 567 */     this.pre20NumBorrowN90M3 = pre20NumBorrowN90M3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 576 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 585 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 594 */     return this.phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 603 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountVoices90()
/*     */   {
/* 611 */     return this.countVoices90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountVoices90(Integer countVoices90)
/*     */   {
/* 619 */     this.countVoices90 = countVoices90;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPre20NumBorrowNMore30M1()
/*     */   {
/* 627 */     return this.pre20NumBorrowNMore30M1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPre20NumBorrowNMore30M1(Integer pre20NumBorrowNMore30M1)
/*     */   {
/* 635 */     this.pre20NumBorrowNMore30M1 = pre20NumBorrowNMore30M1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPre20NumBorrowNLess30M1()
/*     */   {
/* 643 */     return this.pre20NumBorrowNLess30M1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPre20NumBorrowNLess30M1(Integer pre20NumBorrowNLess30M1)
/*     */   {
/* 651 */     this.pre20NumBorrowNLess30M1 = pre20NumBorrowNLess30M1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getEmerConcatTimes6Month()
/*     */   {
/* 659 */     return this.emerConcatTimes6Month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEmerConcatTimes6Month(Integer emerConcatTimes6Month)
/*     */   {
/* 667 */     this.emerConcatTimes6Month = emerConcatTimes6Month;
/*     */   }
/*     */ }
