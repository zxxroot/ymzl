/*     */ package com.cashloan.cl.domain;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
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
/*     */ public class Channel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String code;
/*     */   private String name;
/*     */   private String linker;
/*     */   private String phone;
/*     */   private String type;
/*     */   private String state;
/*     */   private Date createTime;
/*     */   private int channelStage;
/*     */   private int channelGrade;
/*     */   private Date updateTime;
/*     */   private String firstClassResponsiblePerson;
/*     */   private String twoLevelResponsiblePerson;
/*     */   private int settlementSign;
/*     */   private Long channelProviderId;
/*     */   private Long channelContactId;
/*     */   private String updateUser;
/*     */   private String remark;
/*     */   private int isDelete;
/*     */   private BigDecimal scaling;
/*     */   private String settlement;
/*     */   private String inviteURL;
/*     */   private String loginURL;
/*     */   private int divLevel;
/*     */   private String parentCode;
/*     */   private String parentPath;
/*     */   private Long userNum;
/*     */   private String cuserid;
/*     */   
/*     */   public Long getId()
/*     */   {
/* 140 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 149 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCode()
/*     */   {
/* 158 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/* 167 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 176 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 185 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getLinker()
/*     */   {
/* 190 */     return this.linker;
/*     */   }
/*     */   
/*     */   public void setLinker(String linker) {
/* 194 */     this.linker = linker;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 198 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 202 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/* 211 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 220 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getState()
/*     */   {
/* 229 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 238 */     this.state = state;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 242 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 246 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public int getChannelStage() {
/* 250 */     return this.channelStage;
/*     */   }
/*     */   
/*     */   public void setChannelStage(int channelStage) {
/* 254 */     this.channelStage = channelStage;
/*     */   }
/*     */   
/*     */   public int getChannelGrade() {
/* 258 */     return this.channelGrade;
/*     */   }
/*     */   
/*     */   public void setChannelGrade(int channelGrade) {
/* 262 */     this.channelGrade = channelGrade;
/*     */   }
/*     */   
/*     */   public Date getUpdateTime() {
/* 266 */     return this.updateTime;
/*     */   }
/*     */   
/*     */   public void setUpdateTime(Date updateTime) {
/* 270 */     this.updateTime = updateTime;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/* 274 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/* 278 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getFirstClassResponsiblePerson() {
/* 282 */     return this.firstClassResponsiblePerson;
/*     */   }
/*     */   
/*     */   public void setFirstClassResponsiblePerson(String firstClassResponsiblePerson) {
/* 286 */     this.firstClassResponsiblePerson = firstClassResponsiblePerson;
/*     */   }
/*     */   
/*     */   public String getTwoLevelResponsiblePerson() {
/* 290 */     return this.twoLevelResponsiblePerson;
/*     */   }
/*     */   
/*     */   public void setTwoLevelResponsiblePerson(String twoLevelResponsiblePerson) {
/* 294 */     this.twoLevelResponsiblePerson = twoLevelResponsiblePerson;
/*     */   }
/*     */   
/*     */   public int getSettlementSign() {
/* 298 */     return this.settlementSign;
/*     */   }
/*     */   
/*     */   public void setSettlementSign(int settlementSign) {
/* 302 */     this.settlementSign = settlementSign;
/*     */   }
/*     */   
/*     */   public Long getChannelProviderId() {
/* 306 */     return this.channelProviderId;
/*     */   }
/*     */   
/*     */   public void setChannelProviderId(Long channelProviderId) {
/* 310 */     this.channelProviderId = channelProviderId;
/*     */   }
/*     */   
/*     */   public Long getChannelContactId() {
/* 314 */     return this.channelContactId;
/*     */   }
/*     */   
/*     */   public void setChannelContactId(Long channelContactId) {
/* 318 */     this.channelContactId = channelContactId;
/*     */   }
/*     */   
/*     */   public String getUpdateUser() {
/* 322 */     return this.updateUser;
/*     */   }
/*     */   
/*     */   public void setUpdateUser(String updateUser) {
/* 326 */     this.updateUser = updateUser;
/*     */   }
/*     */   
/*     */   public String getRemark() {
/* 330 */     return this.remark;
/*     */   }
/*     */   
/*     */   public void setRemark(String remark) {
/* 334 */     this.remark = remark;
/*     */   }
/*     */   
/*     */   public int getIsDelete() {
/* 338 */     return this.isDelete;
/*     */   }
/*     */   
/*     */   public void setIsDelete(int isDelete) {
/* 342 */     this.isDelete = isDelete;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getUserNum()
/*     */   {
/* 374 */     return this.userNum;
/*     */   }
/*     */   
/*     */   public void setUserNum(Long userNum) {
/* 378 */     this.userNum = userNum;
/*     */   }
/*     */   
/*     */   public String getCuserid() {
/* 382 */     return this.cuserid;
/*     */   }
/*     */   
/*     */   public void setCuserid(String cuserid) {
/* 386 */     this.cuserid = cuserid;
/*     */   }
/*     */   
/*     */   public String getParentCode() {
/* 390 */     return this.parentCode;
/*     */   }
/*     */   
/*     */   public void setParentCode(String parentCode) {
/* 394 */     this.parentCode = parentCode;
/*     */   }
/*     */   
/*     */   public String getParentPath() {
/* 398 */     return this.parentPath;
/*     */   }
/*     */   
/*     */   public void setParentPath(String parentPath) {
/* 402 */     this.parentPath = parentPath;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInviteURL()
/*     */   {
/* 410 */     return this.inviteURL;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setInviteURL(String inviteURL)
/*     */   {
/* 416 */     this.inviteURL = inviteURL;
/*     */   }
/*     */   
/*     */   public String getInviteURL1() {
/* 420 */     String server1 = Global.getValue("server_host");
/* 421 */     if ((this.inviteURL != null) && (!"".equals(this.inviteURL))) {
/* 422 */       return server1 + this.inviteURL;
/*     */     }
/* 424 */     return this.inviteURL;
/*     */   }
/*     */   
/* 427 */   public String getLoginURL1() { String server = Global.getValue("manage_host");
/* 428 */     if ((this.loginURL != null) && (!"".equals(this.loginURL))) {
/* 429 */       return server + this.loginURL;
/*     */     }
/* 431 */     return this.loginURL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLoginURL()
/*     */   {
/* 439 */     return this.loginURL;
/*     */   }
/*     */   
/*     */   public void setLoginURL(String loginURL) {
/* 443 */     this.loginURL = loginURL;
/*     */   }
/*     */   
/*     */   public int getDivLevel() {
/* 447 */     return this.divLevel;
/*     */   }
/*     */   
/*     */   public void setDivLevel(int divLevel) {
/* 451 */     this.divLevel = divLevel;
/*     */   }
/*     */   
/*     */   public String getSettlement() {
/* 455 */     return this.settlement;
/*     */   }
/*     */   
/*     */   public void setSettlement(String settlement) {
/* 459 */     this.settlement = settlement;
/*     */   }
/*     */   
/*     */   public BigDecimal getScaling() {
/* 463 */     if (this.scaling == null)
/* 464 */       this.scaling = new BigDecimal("0.00");
/* 465 */     return this.scaling;
/*     */   }
/*     */   
/*     */   public void setScaling(BigDecimal scaling) {
/* 469 */     this.scaling = scaling;
/*     */   }
/*     */ }
