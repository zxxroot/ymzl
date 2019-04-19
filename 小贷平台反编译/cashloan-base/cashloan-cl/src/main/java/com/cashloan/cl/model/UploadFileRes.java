/*    */ package com.cashloan.cl.model;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
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
/*    */ public class UploadFileRes
/*    */ {
/*    */   private String sysUserName;
/*    */   private Date createTime;
/*    */   private String resPath;
/*    */   private String fileName;
/*    */   private String fileFormat;
/*    */   private BigDecimal fileSize;
/*    */   private String errorMsg;
/*    */   
/*    */   public String getResPath()
/*    */   {
/* 46 */     return this.resPath;
/*    */   }
/*    */   
/* 49 */   public void setResPath(String resPath) { this.resPath = resPath; }
/*    */   
/*    */   public String getFileName() {
/* 52 */     return this.fileName;
/*    */   }
/*    */   
/* 55 */   public void setFileName(String fileName) { this.fileName = fileName; }
/*    */   
/*    */   public String getFileFormat() {
/* 58 */     return this.fileFormat;
/*    */   }
/*    */   
/* 61 */   public void setFileFormat(String fileFormat) { this.fileFormat = fileFormat; }
/*    */   
/*    */   public BigDecimal getFileSize() {
/* 64 */     return this.fileSize;
/*    */   }
/*    */   
/* 67 */   public void setFileSize(BigDecimal fileSize) { this.fileSize = fileSize; }
/*    */   
/*    */   public String getSysUserName() {
/* 70 */     return this.sysUserName;
/*    */   }
/*    */   
/* 73 */   public void setSysUserName(String sysUserName) { this.sysUserName = sysUserName; }
/*    */   
/*    */   public Date getCreateTime() {
/* 76 */     return this.createTime;
/*    */   }
/*    */   
/* 79 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*    */   
/*    */   public String getErrorMsg() {
/* 82 */     return this.errorMsg;
/*    */   }
/*    */   
/* 85 */   public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
/*    */ }
