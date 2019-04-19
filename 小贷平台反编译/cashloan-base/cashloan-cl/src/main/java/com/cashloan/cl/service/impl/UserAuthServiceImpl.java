/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.cashloan.cl.domain.OperatorReqLog;
/*     */ import com.cashloan.cl.domain.UserAuth;
/*     */ import com.cashloan.cl.mapper.UserAuthMapper;
/*     */ import com.cashloan.cl.model.UserAuthModel;
/*     */ import com.cashloan.cl.service.OperatorReqLogService;
/*     */ import com.cashloan.cl.service.OperatorRespDetailService;
/*     */ import com.cashloan.cl.service.OperatorService;
/*     */ import com.cashloan.cl.service.UserAuthService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("userAuthService")
/*     */ public class UserAuthServiceImpl
/*     */   extends BaseServiceImpl<UserAuth, Long>
/*     */   implements UserAuthService
/*     */ {
/*  43 */   private static final Logger logger = LoggerFactory.getLogger(UserAuthServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UserAuthMapper userAuthMapper;
/*     */   @Resource
/*     */   private OperatorReqLogService operatorReqLogService;
/*     */   @Resource
/*     */   private OperatorRespDetailService operatorRespDetailService;
/*     */   @Resource
/*     */   private OperatorService operatorService;
/*     */   
/*     */   public BaseMapper<UserAuth, Long> getMapper()
/*     */   {
/*  56 */     return this.userAuthMapper;
/*     */   }
/*     */   
/*     */   public UserAuth getUserAuth(Map<String, Object> paramMap)
/*     */   {
/*  61 */     UserAuth userAuth = (UserAuth)this.userAuthMapper.findSelective(paramMap);
/*  62 */     String phoneState = userAuth.getPhoneState();
/*  63 */     OperatorReqLog operatorReqLog = this.operatorReqLogService.findLastRecord(paramMap);
/*     */     
/*  65 */     if (("20".equals(userAuth.getPhoneState())) && (operatorReqLog != null)) {
/*  66 */       int resetTime = 5;
/*  67 */       int diffTime = DateUtil.minuteBetween(operatorReqLog.getCreateTime(), DateUtil.getNow());
/*     */       
/*  69 */       if (resetTime <= diffTime) {
/*  70 */         Map<String, Object> modifyMap = new HashMap();
/*  71 */         modifyMap.put("userId", userAuth.getUserId());
/*  72 */         modifyMap.put("phoneState", "10");
/*  73 */         updateByUserId(modifyMap);
/*     */       }
/*     */     }
/*  76 */     userAuth.setPhoneState(phoneState);
/*  77 */     return userAuth;
/*     */   }
/*     */   
/*     */   public Integer updateByUserId(Map<String, Object> paramMap)
/*     */   {
/*  82 */     return Integer.valueOf(this.userAuthMapper.updateByUserId(paramMap));
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<UserAuthModel> listUserAuth(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  88 */     PageHelper.startPage(currentPage, pageSize);
/*  89 */     List<UserAuthModel> list = this.userAuthMapper.listUserAuthModel(params);
/*  90 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public UserAuth findSelective(long userId)
/*     */   {
/*  95 */     Map<String, Object> map = new HashMap();
/*  96 */     map.put("userId", Long.valueOf(userId));
/*  97 */     return (UserAuth)this.userAuthMapper.findSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<String, Object> getAuthState(Map<String, Object> paramMap)
/*     */   {
/* 103 */     String resultSql = "";
/* 104 */     String qualifiedSql = "";
/* 105 */     int qualifiedCount = 4;
/*     */     
/* 107 */     String zhima_auth = Global.getValue("zhima_auth");
/* 108 */     if ("30".equals(zhima_auth)) {
/* 109 */       resultSql = resultSql + "+IF (zhima_state = 30, 1, 0)";
/* 110 */       qualifiedSql = qualifiedSql + "+IF (zhima_state = 30, 1, 0)";
/* 111 */       qualifiedCount++;
/* 112 */     } else if ("20".equals(zhima_auth)) {
/* 113 */       resultSql = "+IF (zhima_state = 30, 1, 0)";
/*     */     }
/* 115 */     String taobao_auth = Global.getValue("taobao_auth");
/* 116 */     if ("30".equals(taobao_auth)) {
/* 117 */       resultSql = resultSql + "+IF (tb_state = 30, 1, 0)";
/* 118 */       qualifiedSql = qualifiedSql + "+IF (tb_state = 30, 1, 0)";
/* 119 */       qualifiedCount++;
/* 120 */     } else if ("20".equals(taobao_auth)) {
/* 121 */       resultSql = "+IF (tb_state = 30, 1, 0)";
/*     */     }
/*     */     
/*     */ 
/* 125 */     String acc_fund_auth = Global.getValue("acc_fund_auth");
/* 126 */     if ("30".equals(acc_fund_auth)) {
/* 127 */       resultSql = resultSql + "+IF (acc_fund_state = 30, 1, 0)";
/* 128 */       qualifiedSql = qualifiedSql + "+IF (acc_fund_state = 30, 1, 0)";
/* 129 */       qualifiedCount++;
/* 130 */     } else if ("20".equals(acc_fund_auth)) {
/* 131 */       resultSql = "+IF (acc_fund_state = 30, 1, 0)";
/*     */     }
/*     */     
/*     */ 
/* 135 */     String sql = "\tSELECT (IF (id_state = 30, 1, 0) +IF (phone_state = 30, 1, 0) +IF (contact_state = 30, 1, 0) +IF (bank_card_state = 30, 1, 0) +IF (work_info_state = 30, 1, 0) +IF (other_info_state = 30, 1, 0)" + 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */       resultSql + 
/* 143 */       ") AS result," + 
/* 144 */       Global.getValue("auth_total") + " AS total," + 
/* 145 */       "IF (" + 
/* 146 */       "(IF (id_state = 30, 1, 0) +" + 
/* 147 */       "IF (phone_state = 30, 1, 0) +" + 
/* 148 */       "IF (contact_state = 30, 1, 0) +" + 
/* 149 */       "IF (bank_card_state = 30, 1, 0) " + 
/* 150 */       qualifiedSql + 
/* 151 */       ") = " + 
/* 152 */       qualifiedCount + 
/* 153 */       ",1,0) AS qualified " + 
/* 154 */       "FROM cl_user_auth " + 
/* 155 */       "WHERE user_id = " + paramMap.get("userId");
/* 156 */     paramMap = new HashMap();
/* 157 */     paramMap.put("sqlstring", sql);
/* 158 */     return this.userAuthMapper.executeSql(paramMap);
/*     */   }
/*     */   
/*     */ 
/*     */   public int updatePhoneState(Map<String, Object> userAuth)
/*     */   {
/* 164 */     return this.userAuthMapper.updatePhoneState(userAuth);
/*     */   }
/*     */ }


/*impl\UserAuthServiceImpl.class

 */