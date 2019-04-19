/*     */ package com.cashloan.cl.model;
/*     */ 
/*     */ import com.cashloan.cl.domain.PayCheck;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManagePayCheckModel
/*     */   extends PayCheck
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String typeStr;
/*     */   private String stateStr;
/*     */   private String processWayStr;
/*     */   private String processResultStr;
/*     */   private String scenes;
/*     */   private String scenesStr;
/*     */   private String payType;
/*     */   private String payTypeStr;
/*     */   
/*     */   public ManagePayCheckModel() {}
/*     */   
/*     */   public ManagePayCheckModel(String orderNo, double orderAmount, double realPayAmount, String type, String processResult)
/*     */   {
/*  68 */     super(orderNo, orderAmount, realPayAmount, type, processResult);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTypeStr()
/*     */   {
/*  78 */     this.typeStr = typeConvert(getType());
/*  79 */     return this.typeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTypeStr(String typeStr)
/*     */   {
/*  88 */     this.typeStr = typeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getStateStr()
/*     */   {
/*  97 */     this.stateStr = stateConvert(getState());
/*  98 */     return this.stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStateStr(String stateStr)
/*     */   {
/* 107 */     this.stateStr = stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getProcessWayStr()
/*     */   {
/* 116 */     this.processWayStr = processWayConvert(getProcessWay());
/* 117 */     return this.processWayStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setProcessWayStr(String processWayStr)
/*     */   {
/* 126 */     this.processWayStr = processWayStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getProcessResultStr()
/*     */   {
/* 135 */     this.processResultStr = processResultConvert(getProcessResult());
/* 136 */     return this.processResultStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setProcessResultStr(String processResultStr)
/*     */   {
/* 145 */     this.processResultStr = processResultStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScenes()
/*     */   {
/* 154 */     return this.scenes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScenes(String scenes)
/*     */   {
/* 163 */     this.scenes = scenes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getScenesStr()
/*     */   {
/* 172 */     this.scenesStr = ManagePayLogModel.scenesConvert(getScenes());
/* 173 */     return this.scenesStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScenesStr(String scenesStr)
/*     */   {
/* 182 */     this.scenesStr = scenesStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPayType()
/*     */   {
/* 191 */     return this.payType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayType(String payType)
/*     */   {
/* 200 */     this.payType = payType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPayTypeStr()
/*     */   {
/* 209 */     this.payTypeStr = ManagePayLogModel.typeConvert(getPayType());
/* 210 */     return this.payTypeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPayTypeStr(String payTypeStr)
/*     */   {
/* 219 */     this.payTypeStr = payTypeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String typeConvert(String type)
/*     */   {
/* 229 */     String typeStr = null;
/* 230 */     if ("10".equals(type)) {
/* 231 */       typeStr = "金额不匹配";
/* 232 */     } else if ("20".equals(type)) {
/* 233 */       typeStr = "我方单边账";
/* 234 */     } else if ("30".equals(type)) {
/* 235 */       typeStr = "支付方单边账";
/*     */     } else {
/* 237 */       typeStr = " - ";
/*     */     }
/* 239 */     return typeStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String stateConvert(String state)
/*     */   {
/* 246 */     String stateStr = null;
/* 247 */     if ("0".equals(state)) {
/* 248 */       stateStr = "交易成功";
/* 249 */     } else if ("5".equals(state)) {
/* 250 */       stateStr = "退款";
/*     */     } else {
/* 252 */       stateStr = " - ";
/*     */     }
/* 254 */     return stateStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String processWayConvert(String processWay)
/*     */   {
/* 261 */     String processWayStr = null;
/* 262 */     if ("10".equals(processWay)) {
/* 263 */       processWayStr = "不处理 ";
/* 264 */     } else if ("20".equals(processWay)) {
/* 265 */       processWayStr = "补录 ";
/* 266 */     } else if ("30".equals(processWay)) {
/* 267 */       processWayStr = "退还 ";
/* 268 */     } else if ("40".equals(processWay)) {
/* 269 */       processWayStr = "补扣 ";
/*     */     } else {
/* 271 */       processWayStr = " - ";
/*     */     }
/* 273 */     return processWayStr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String processResultConvert(String processResult)
/*     */   {
/* 281 */     String processResultStr = null;
/* 282 */     if ("10".equals(processResult)) {
/* 283 */       processResultStr = "未处理";
/* 284 */     } else if ("20".equals(processResult)) {
/* 285 */       processResultStr = "已处理";
/*     */     } else {
/* 287 */       processResultStr = " - ";
/*     */     }
/* 289 */     return processResultStr;
/*     */   }
/*     */ }
