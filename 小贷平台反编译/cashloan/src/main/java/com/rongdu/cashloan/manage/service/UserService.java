/*     */ package com.rongdu.cashloan.manage.service;
/*     */ 
/*     */ import com.rongdu.cashloan.cl.model.tongdun.util.EncryptUtil;
/*     */ import com.rongdu.cashloan.cl.service.ClSmsService;
/*     */ import com.rongdu.cashloan.cl.service.UserAuthService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.SqlUtil;
/*     */ import java.util.Date;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("clUserService_")
/*     */ public class UserService
/*     */ {
/*  34 */   private Logger logger = LoggerFactory.getLogger(UserService.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private ClSmsService clSmsService;
/*     */   
/*     */   @Resource
/*     */   protected DBService dbService;
/*     */   
/*     */   @Resource
/*     */   protected MybatisService mybatisService;
/*     */   
/*     */   @Resource
/*     */   private UserAuthService userAuthService;
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public void registerUser(HttpServletRequest request, String phone, long channelId)
/*     */   {
/*     */     try
/*     */     {
/*  55 */       String pwd = getStringRandom(6);
/*  56 */       String uuid = UUID.randomUUID().toString().replaceAll("-", "");
/*  57 */       long userId = this.dbService.insert(SqlUtil.buildInsertSqlMap("cl_user", new Object[][] {
/*  58 */         { "login_name", phone }, 
/*  59 */         { "login_pwd", EncryptUtil.MD5Encode(pwd).toUpperCase() }, 
/*  60 */         { "invitation_code", randomInvitationCode(6) }, 
/*  61 */         { "regist_time", new Date() }, 
/*  62 */         { "uuid", uuid }, 
/*  63 */         { "level", Integer.valueOf(3) }, 
/*  64 */         { "channel_id", Long.valueOf(channelId) } }), new Object[0]);
/*     */       
/*     */ 
/*  67 */       this.dbService.insert(SqlUtil.buildInsertSqlMap("cl_user_base_info", new Object[][] {
/*  68 */         { "user_id", Long.valueOf(userId) }, 
/*  69 */         { "phone", phone } }), new Object[0]);
/*     */       
/*     */ 
/*  72 */       this.dbService.insert(SqlUtil.buildInsertSqlMap("arc_credit", new Object[][] {
/*  73 */         { "consumer_no", Long.valueOf(userId) }, 
/*  74 */         { "total", Global.getValue("init_credit") }, 
/*  75 */         { "unuse", Global.getValue("init_credit") }, 
/*  76 */         { "state", Integer.valueOf(10) } }), new Object[0]);
/*     */       
/*  78 */       this.dbService.insert(SqlUtil.buildInsertSqlMap("cl_profit_amount", new Object[][] {
/*  79 */         { "user_id", Long.valueOf(userId) }, 
/*  80 */         { "state", "10" } }), new Object[0]);
/*     */       
/*     */ 
/*  83 */       this.dbService.insert(SqlUtil.buildInsertSqlMap("cl_user_auth", new Object[][] {
/*  84 */         { "user_id", Long.valueOf(userId) }, 
/*  85 */         { "real_name_state", Integer.valueOf(10) }, 
/*  86 */         { "id_state", Integer.valueOf(10) }, 
/*  87 */         { "zhima_state", Integer.valueOf(10) }, 
/*  88 */         { "phone_state", Integer.valueOf(10) }, 
/*  89 */         { "contact_state", Integer.valueOf(10) }, 
/*  90 */         { "bank_card_state", Integer.valueOf(10) }, 
/*  91 */         { "work_info_state", Integer.valueOf(10) }, 
/*  92 */         { "other_info_state", Integer.valueOf(10) } }), new Object[0]);
/*     */       
/*     */ 
/*  95 */       this.clSmsService.registerSuccess(phone, pwd);
/*     */     } catch (Exception e) {
/*  97 */       this.logger.error("注册失败", e);
/*     */     }
/*     */   }
/*     */   
/*     */   private String randomInvitationCode(int len) {
/*     */     String str;
/*     */     do {
/* 104 */       str = randomNumAlph(len);
/* 105 */     } while (this.mybatisService.queryRec("usr.queryUserByInvitation", str) != null);
/* 106 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getStringRandom(int length)
/*     */   {
/* 113 */     String val = "";
/* 114 */     Random random = new Random();
/* 115 */     val = val + (char)(random.nextInt(26) + 97);
/*     */     
/* 117 */     for (int i = 0; i < length - 1; i++) {
/* 118 */       val = val + String.valueOf(random.nextInt(10));
/*     */     }
/* 120 */     return val;
/*     */   }
/*     */   
/*     */   private static String randomNumAlph(int len) {
/* 124 */     Random random = new Random();
/*     */     
/* 126 */     StringBuilder sb = new StringBuilder();
/* 127 */     byte[][] list = {
/* 128 */       { 48, 57 }, 
/* 129 */       { 97, 122 }, 
/* 130 */       { 65, 90 } };
/*     */     
/* 132 */     for (int i = 0; i < len; i++) {
/* 133 */       byte[] o = list[random.nextInt(list.length)];
/* 134 */       byte value = (byte)(random.nextInt(o[1] - o[0] + 1) + o[0]);
/* 135 */       sb.append((char)value);
/*     */     }
/* 137 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\service\UserService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */