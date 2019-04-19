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
/*     */ public class TppServiceInfoModel
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String SERVICE_TYPE_THIRD = "10";
/*     */   public static final String SERVICE_TYPE_STATISTICS = "20";
/*     */   public static final String GET_WAY_ONCE = "00";
/*     */   public static final String GET_WAY_EVERYTIMES = "10";
/*     */   public static final String GET_WAY_CYCLE = "20";
/*     */   public Long sceneId;
/*     */   public String sceneCode;
/*     */   public String getWay;
/*     */   public String period;
/*     */   public String merNo;
/*     */   public String signType;
/*     */   private Long tppId;
/*     */   public String tppKey;
/*     */   public String tppParams;
/*     */   public Long busId;
/*     */   public String busNid;
/*     */   public String busName;
/*     */   public String url;
/*     */   public String testUrl;
/*     */   public String serParams;
/*     */   private String type;
/*     */   
/*     */   public Long getSceneId()
/*     */   {
/* 129 */     return this.sceneId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSceneId(Long sceneId)
/*     */   {
/* 137 */     this.sceneId = sceneId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSceneCode()
/*     */   {
/* 144 */     return this.sceneCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSceneCode(String sceneCode)
/*     */   {
/* 151 */     this.sceneCode = sceneCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getGetWay()
/*     */   {
/* 158 */     return this.getWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGetWay(String getWay)
/*     */   {
/* 165 */     this.getWay = getWay;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPeriod()
/*     */   {
/* 172 */     return this.period;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPeriod(String period)
/*     */   {
/* 179 */     this.period = period;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMerNo()
/*     */   {
/* 186 */     return this.merNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMerNo(String merNo)
/*     */   {
/* 193 */     this.merNo = merNo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSignType()
/*     */   {
/* 200 */     return this.signType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSignType(String signType)
/*     */   {
/* 207 */     this.signType = signType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getTppId()
/*     */   {
/* 214 */     return this.tppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTppId(Long tppId)
/*     */   {
/* 221 */     this.tppId = tppId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTppKey()
/*     */   {
/* 228 */     return this.tppKey;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTppKey(String tppKey)
/*     */   {
/* 235 */     this.tppKey = tppKey;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTppParams()
/*     */   {
/* 242 */     return this.tppParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTppParams(String tppParams)
/*     */   {
/* 249 */     this.tppParams = tppParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getBusId()
/*     */   {
/* 256 */     return this.busId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBusId(Long busId)
/*     */   {
/* 263 */     this.busId = busId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBusNid()
/*     */   {
/* 271 */     return this.busNid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBusNid(String busNid)
/*     */   {
/* 279 */     this.busNid = busNid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBusName()
/*     */   {
/* 287 */     return this.busName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBusName(String busName)
/*     */   {
/* 295 */     this.busName = busName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getUrl()
/*     */   {
/* 302 */     return this.url;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUrl(String url)
/*     */   {
/* 309 */     this.url = url;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTestUrl()
/*     */   {
/* 316 */     return this.testUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTestUrl(String testUrl)
/*     */   {
/* 323 */     this.testUrl = testUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSerParams()
/*     */   {
/* 330 */     return this.serParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerParams(String serParams)
/*     */   {
/* 337 */     this.serParams = serParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getType()
/*     */   {
/* 345 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 353 */     this.type = type;
/*     */   }
/*     */ }

