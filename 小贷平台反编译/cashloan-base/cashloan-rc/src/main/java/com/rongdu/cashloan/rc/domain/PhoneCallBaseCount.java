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
/*     */ public class PhoneCallBaseCount
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private Integer count;
/*     */   private String nameMatching;
/*     */   private String addressMatching;
/*     */   private Integer monthSource;
/*     */   private Integer countOne;
/*     */   private Integer countTwo;
/*     */   private Integer countThree;
/*     */   private Integer countFour;
/*     */   private Integer countFive;
/*     */   private Integer countSix;
/*     */   private Integer countSeven;
/*     */   private Integer countEight;
/*     */   private Integer countNine;
/*     */   private Integer countTen;
/*     */   private Integer countEleven;
/*     */   private Integer countTwelve;
/*     */   private Integer countThirteen;
/*     */   private Integer countFourteen;
/*     */   private Integer countFifteen;
/*     */   private Integer countSixteen;
/*     */   private Integer countSeventeen;
/*     */   private Integer countEighteen;
/*     */   private Integer countNineteen;
/*     */   private Integer countTwenty;
/*     */   private Integer countTwentyOne;
/*     */   private Integer countTwentyTwo;
/*     */   private Integer countTwentyThree;
/*     */   private Integer countTwentyFour;
/*     */   private Date createTime;
/*     */   private Date updateTime;
/*     */   
/*     */   public PhoneCallBaseCount() {}
/*     */   
/*     */   public PhoneCallBaseCount(OperatorCountModel model)
/*     */   {
/* 189 */     this.userId = model.getUserId();
/* 190 */     this.count = model.getCountVoices90();
/* 191 */     this.countOne = model.getJoinMonthCount();
/* 192 */     this.countTwo = model.getEmerConcatTimes6Month();
/* 193 */     this.countThree = model.getVoiceTimes30();
/* 194 */     this.countFour = model.getVoiceTimes30Calling();
/* 195 */     this.countFive = model.getVoiceTimes30Called();
/* 196 */     this.countSix = model.getVoiceDuration30();
/* 197 */     this.countSeven = model.getVoiceDuration30Calling();
/* 198 */     this.countEight = model.getVoiceDuration30Called();
/* 199 */     this.countNine = model.getVoiceTimes90();
/* 200 */     this.countTen = model.getVoiceTimes90Calling();
/* 201 */     this.countEleven = model.getVoiceTimes90Called();
/* 202 */     this.countTwelve = model.getVoiceDuration90();
/* 203 */     this.countThirteen = model.getVoiceDuration90Calling();
/* 204 */     this.countFourteen = model.getVoiceDuration90Called();
/* 205 */     this.countFifteen = model.getPhoneNumCount90();
/* 206 */     this.countSixteen = model.getPhoneNumCount90Calling();
/* 207 */     this.countSeventeen = model.getPhoneNumCount90Called();
/* 208 */     this.countEighteen = model.getGe5TimesNumCount90();
/* 209 */     this.countNineteen = model.getGe3Times60SNumCount90();
/* 210 */     this.createTime = DateUtil.getNow();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 219 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 228 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 237 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 247 */     this.userId = userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCount()
/*     */   {
/* 256 */     return this.count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCount(Integer count)
/*     */   {
/* 266 */     this.count = count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNameMatching()
/*     */   {
/* 275 */     return this.nameMatching;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNameMatching(String nameMatching)
/*     */   {
/* 285 */     this.nameMatching = nameMatching;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAddressMatching()
/*     */   {
/* 294 */     return this.addressMatching;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddressMatching(String addressMatching)
/*     */   {
/* 304 */     this.addressMatching = addressMatching;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getMonthSource()
/*     */   {
/* 313 */     return this.monthSource;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMonthSource(Integer monthSource)
/*     */   {
/* 323 */     this.monthSource = monthSource;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountOne()
/*     */   {
/* 332 */     return this.countOne;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountOne(Integer countOne)
/*     */   {
/* 342 */     this.countOne = countOne;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwo()
/*     */   {
/* 351 */     return this.countTwo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwo(Integer countTwo)
/*     */   {
/* 361 */     this.countTwo = countTwo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountThree()
/*     */   {
/* 370 */     return this.countThree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountThree(Integer countThree)
/*     */   {
/* 380 */     this.countThree = countThree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountFour()
/*     */   {
/* 389 */     return this.countFour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountFour(Integer countFour)
/*     */   {
/* 399 */     this.countFour = countFour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountFive()
/*     */   {
/* 408 */     return this.countFive;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountFive(Integer countFive)
/*     */   {
/* 418 */     this.countFive = countFive;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountSix()
/*     */   {
/* 427 */     return this.countSix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountSix(Integer countSix)
/*     */   {
/* 437 */     this.countSix = countSix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountSeven()
/*     */   {
/* 446 */     return this.countSeven;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountSeven(Integer countSeven)
/*     */   {
/* 456 */     this.countSeven = countSeven;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountEight()
/*     */   {
/* 465 */     return this.countEight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountEight(Integer countEight)
/*     */   {
/* 475 */     this.countEight = countEight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountNine()
/*     */   {
/* 484 */     return this.countNine;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountNine(Integer countNine)
/*     */   {
/* 494 */     this.countNine = countNine;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTen()
/*     */   {
/* 503 */     return this.countTen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTen(Integer countTen)
/*     */   {
/* 513 */     this.countTen = countTen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountEleven()
/*     */   {
/* 522 */     return this.countEleven;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountEleven(Integer countEleven)
/*     */   {
/* 532 */     this.countEleven = countEleven;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwelve()
/*     */   {
/* 541 */     return this.countTwelve;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwelve(Integer countTwelve)
/*     */   {
/* 551 */     this.countTwelve = countTwelve;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountThirteen()
/*     */   {
/* 560 */     return this.countThirteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountThirteen(Integer countThirteen)
/*     */   {
/* 570 */     this.countThirteen = countThirteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountFourteen()
/*     */   {
/* 579 */     return this.countFourteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountFourteen(Integer countFourteen)
/*     */   {
/* 589 */     this.countFourteen = countFourteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountFifteen()
/*     */   {
/* 598 */     return this.countFifteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountFifteen(Integer countFifteen)
/*     */   {
/* 608 */     this.countFifteen = countFifteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountSixteen()
/*     */   {
/* 617 */     return this.countSixteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountSixteen(Integer countSixteen)
/*     */   {
/* 627 */     this.countSixteen = countSixteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountSeventeen()
/*     */   {
/* 636 */     return this.countSeventeen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountSeventeen(Integer countSeventeen)
/*     */   {
/* 646 */     this.countSeventeen = countSeventeen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountEighteen()
/*     */   {
/* 655 */     return this.countEighteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountEighteen(Integer countEighteen)
/*     */   {
/* 665 */     this.countEighteen = countEighteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountNineteen()
/*     */   {
/* 674 */     return this.countNineteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountNineteen(Integer countNineteen)
/*     */   {
/* 684 */     this.countNineteen = countNineteen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwenty()
/*     */   {
/* 693 */     return this.countTwenty;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwenty(Integer countTwenty)
/*     */   {
/* 703 */     this.countTwenty = countTwenty;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwentyOne()
/*     */   {
/* 712 */     return this.countTwentyOne;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwentyOne(Integer countTwentyOne)
/*     */   {
/* 722 */     this.countTwentyOne = countTwentyOne;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwentyTwo()
/*     */   {
/* 731 */     return this.countTwentyTwo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwentyTwo(Integer countTwentyTwo)
/*     */   {
/* 741 */     this.countTwentyTwo = countTwentyTwo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwentyThree()
/*     */   {
/* 750 */     return this.countTwentyThree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwentyThree(Integer countTwentyThree)
/*     */   {
/* 760 */     this.countTwentyThree = countTwentyThree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCountTwentyFour()
/*     */   {
/* 769 */     return this.countTwentyFour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCountTwentyFour(Integer countTwentyFour)
/*     */   {
/* 779 */     this.countTwentyFour = countTwentyFour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 788 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 798 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUpdateTime()
/*     */   {
/* 807 */     return this.updateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUpdateTime(Date updateTime)
/*     */   {
/* 817 */     this.updateTime = updateTime;
/*     */   }
/*     */ }
