/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.google.common.base.Optional;
/*     */ import com.rongdu.cashloan.cl.domain.UserAuth;
/*     */ import com.rongdu.cashloan.cl.domain.Zhima;
/*     */ import com.rongdu.cashloan.cl.model.zmxy.authorize.AuthInfoQuery;
/*     */ import com.rongdu.cashloan.cl.model.zmxy.base.ZmQueryCreator;
/*     */ import com.rongdu.cashloan.cl.model.zmxy.creditScore.WhiteKnightZhiMaResponse;
/*     */ import com.rongdu.cashloan.cl.service.UserAuthService;
/*     */ import com.rongdu.cashloan.cl.service.ZhimaService;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ZhimaController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private ZhimaService zhimaService;
/*     */   @Resource
/*     */   private UserAuthService userAuthService;
/*     */   @Resource
/*     */   private UserBaseInfoService userInfoService;
/*     */   
/*     */   @RequestMapping({"/api/act/mine/zhima/view.htm"})
/*     */   public void view(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="userId", required=false) Long userId)
/*     */     throws Exception
/*     */   {
/*  60 */     Map<String, Object> paramMap = new HashMap();
/*  61 */     Map<String, Object> result = new HashMap();
/*  62 */     paramMap.put("userId", userId);
/*  63 */     UserAuth userauth = this.userAuthService.getUserAuth(paramMap);
/*  64 */     if ((userauth != null) && ("30".equals(userauth.getZhimaState()))) {
/*  65 */       Zhima zhima = this.zhimaService.findByUserId(userId);
/*  66 */       result.put("data", zhima);
/*  67 */       result.put("code", Integer.valueOf(200));
/*  68 */       result.put("msg", "查询芝麻信用信息成功");
/*     */     } else {
/*  70 */       result.put("code", Integer.valueOf(403));
/*  71 */       result.put("msg", "请先进行芝麻信用授权");
/*     */     }
/*     */     
/*  74 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/api/act/mine/zhima/authorize.htm"})
/*     */   public void authorize(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="userId", required=false) Long userId)
/*     */     throws Exception
/*     */   {
/*  81 */     Map<String, Object> paramMap = new HashMap();
/*  82 */     Map<String, Object> result = new HashMap();
/*  83 */     paramMap.put("userId", userId);
/*  84 */     UserAuth userauth = this.userAuthService.getUserAuth(paramMap);
/*  85 */     if ((userauth != null) && ("30".equals(userauth.getZhimaState()))) {
/*  86 */       result.put("code", Integer.valueOf(403));
/*  87 */       result.put("msg", "该用户已授权");
/*     */     } else {
/*  89 */       ZmQueryCreator zmQueryCreator = new ZmQueryCreator();
/*  90 */       AuthInfoQuery authInfoQuery = (AuthInfoQuery)zmQueryCreator.create(AuthInfoQuery.class);
/*  91 */       if ((userauth != null) && ("30".equals(userauth.getIdState()))) {
/*  92 */         UserBaseInfo userinfo = this.userInfoService.findSelective(paramMap);
/*  93 */         if ((userinfo != null) && (userinfo.getIdNo() != null) && (userinfo.getRealName() != null))
/*     */         {
/*  95 */           String url = authInfoQuery.getPhoneAuthorizeUrl(userinfo.getIdNo(), userinfo.getRealName(), userinfo.getUserId());
/*  96 */           Map<String, Object> r = new HashMap();
/*  97 */           r.put("url", url);
/*  98 */           result.put("data", r);
/*  99 */           result.put("code", Integer.valueOf(200));
/* 100 */           result.put("msg", "查询成功");
/*     */         } else {
/* 102 */           result.put("code", Integer.valueOf(403));
/* 103 */           result.put("msg", "请先实名认证");
/*     */         }
/*     */       } else {
/* 106 */         result.put("code", Integer.valueOf(403));
/* 107 */         result.put("msg", "请先实名认证");
/*     */       }
/*     */     }
/*     */     
/* 111 */     ServletUtils.writeToResponse(response, result);
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
/*     */   @RequestMapping({"/api/actzm/mine/zhima/AuthCallBack.htm"})
/*     */   public String AuthCallBack(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="params", required=true) String params, @RequestParam(value="sign", required=true) String sign)
/*     */     throws Exception
/*     */   {
/* 126 */     Map<String, Object> result = this.zhimaService.authCallBack(params, null);
/* 127 */     request.setAttribute("msg", result.get("msg"));
/* 128 */     request.setAttribute("code", result.get("code"));
/* 129 */     request.setAttribute("zmScore", result.get("zmScore"));
/* 130 */     return "zhimaAuthReturnback";
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
/*     */   @RequestMapping({"/api/actzm/mine/zhima/WhiteKnightAuthCallBack.htm"})
/*     */   public void whiteKnightAuthCallBack(@RequestBody WhiteKnightZhiMaResponse whiteKnightZhiMaResponse)
/*     */     throws Exception
/*     */   {
/* 145 */     this.logger.info("芝麻信用授权认证的回调--白骑士---------------" + whiteKnightZhiMaResponse);
/* 146 */     String value = Global.getValue("zhima_model_switch");
/* 147 */     if ((StringUtils.isNotBlank(value)) && (StringUtils.equalsIgnoreCase(value, "1")) && 
/* 148 */       (Optional.fromNullable(whiteKnightZhiMaResponse).isPresent())) {
/* 149 */       String msgCode = whiteKnightZhiMaResponse.getMsgCode();
/* 150 */       if ((StringUtils.isNotBlank(msgCode)) && (!StringUtils.equalsIgnoreCase(msgCode, "CCOM3016"))) {
/* 151 */         String datatype = whiteKnightZhiMaResponse.getDataType();
/* 152 */         if ((StringUtils.isNotBlank(datatype)) && (StringUtils.equalsIgnoreCase(datatype, "zm"))) {
/* 153 */           this.zhimaService.wkzmrCallBack(whiteKnightZhiMaResponse);
/* 154 */         } else if ((!StringUtils.isNotBlank(datatype)) || (!StringUtils.equalsIgnoreCase(datatype, "jd")))
/*     */         {
/* 156 */           if (StringUtils.isNotBlank(datatype)) { StringUtils.equalsIgnoreCase(datatype, "tb");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 162 */     PrintWriter returnOut = this.response.getWriter();
/* 163 */     returnOut.print("CCOM1000");
/* 164 */     returnOut.flush();
/* 165 */     returnOut.close();
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ZhimaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */