/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.exception.BussinessException;
/*     */ import com.rongdu.cashloan.core.common.exception.ParamValideException;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.model.URLConfig;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.ValidateCode;
/*     */ import com.rongdu.cashloan.core.common.web.controller.AbstractController;
/*     */ import com.rongdu.cashloan.system.domain.SysRole;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.security.userdetails.UserFunction;
/*     */ import com.rongdu.cashloan.system.security.userdetails.UserRole;
/*     */ import com.rongdu.cashloan.system.service.SysRoleService;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.text.DateFormat;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.ServletOutputStream;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.shiro.authz.AuthorizationException;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*     */ import org.springframework.beans.propertyeditors.CustomNumberEditor;
/*     */ import org.springframework.security.core.Authentication;
/*     */ import org.springframework.security.core.context.SecurityContext;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindException;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.validation.FieldError;
/*     */ import org.springframework.web.bind.MethodArgumentNotValidException;
/*     */ import org.springframework.web.bind.WebDataBinder;
/*     */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*     */ import org.springframework.web.bind.annotation.InitBinder;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import tool.util.NumberUtil;
/*     */ import tool.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public abstract class ManageBaseController
/*     */   extends AbstractController
/*     */ {
/*  74 */   private static final Logger logger = LoggerFactory.getLogger(ManageBaseController.class);
/*     */   
/*     */   protected HttpServletRequest request;
/*     */   protected HttpServletResponse response;
/*     */   protected HttpSession session;
/*     */   @Autowired
/*     */   protected URLConfig mlmsAppServerConfig;
/*     */   @Resource
/*     */   protected SysUserService sysUserService;
/*     */   @Resource
/*     */   protected SysRoleService roleService;
/*     */   
/*     */   @ModelAttribute
/*     */   public void setReqAndRes(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  89 */     this.request = request;
/*  90 */     this.response = response;
/*  91 */     this.session = request.getSession();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @InitBinder
/*     */   protected final void initBinderInternal(WebDataBinder binder)
/*     */   {
/* 101 */     registerDefaultCustomDateEditor(binder);
/* 102 */     registerDefaultCustomNumberEditor(binder);
/* 103 */     initBinder(binder);
/*     */   }
/*     */   
/*     */   private void registerDefaultCustomNumberEditor(WebDataBinder binder)
/*     */   {
/* 108 */     NumberFormat numberFormat = new DecimalFormat("#0.00");
/* 109 */     binder.registerCustomEditor(Double.class, new CustomNumberEditor(
/* 110 */       Double.class, numberFormat, true));
/*     */   }
/*     */   
/*     */   protected void registerDefaultCustomDateEditor(WebDataBinder binder)
/*     */   {
/* 115 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 116 */     dateFormat.setLenient(false);
/* 117 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(
/* 118 */       dateFormat, true));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void initBinder(WebDataBinder binder) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected SysUser getLoginUser(HttpServletRequest request)
/*     */   {
/* 137 */     Object obj = request.getSession().getAttribute("SysUser");
/* 138 */     if (obj != null) {
/* 139 */       return (SysUser)obj;
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected SysUser getSysUser()
/*     */     throws ServiceException
/*     */   {
/* 152 */     UserDetails user = (UserDetails)SecurityContextHolder.getContext()
/* 153 */       .getAuthentication().getPrincipal();
/* 154 */     SysUser sysUser = this.sysUserService.getUserByUserName(user.getUsername());
/* 155 */     return sysUser;
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
/*     */   protected void setToken(String tokenName, HttpServletRequest request)
/*     */   {
/* 168 */     HttpSession session = request.getSession(false);
/* 169 */     if (session == null) {
/* 170 */       session = request.getSession();
/*     */     }
/* 172 */     session.setAttribute(tokenName, "true");
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
/*     */   protected String isToken(String tokenName, HttpServletRequest request)
/*     */   {
/* 186 */     HttpSession session = request.getSession(false);
/* 187 */     if (session == null) {
/* 188 */       session = request.getSession();
/*     */     }
/* 190 */     String tokenValue = (String)session.getAttribute(tokenName);
/* 191 */     String paramValue = request.getParameter(tokenName);
/*     */     
/*     */ 
/* 194 */     if ((StringUtil.isBlank(paramValue)) && (StringUtil.isBlank(tokenValue)))
/* 195 */       return "会话Token未设定！";
/* 196 */     if ((StringUtil.isBlank(paramValue)) && 
/* 197 */       (!StringUtil.isBlank(tokenValue)))
/* 198 */       return "表单Token未设定！";
/* 199 */     if ((paramValue.equals(tokenValue)) && 
/* 200 */       (!StringUtil.isBlank(tokenValue)) && ("true".equals(tokenValue))) {
/* 201 */       session.setAttribute(tokenName, "false");
/* 202 */       return "";
/*     */     }
/* 204 */     return "请勿重复提交！";
/*     */   }
/*     */   
/*     */   protected void message(HttpServletResponse response) throws IOException
/*     */   {
/* 209 */     message(response, "", true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void message(HttpServletResponse response, String msg)
/*     */     throws IOException
/*     */   {
/* 220 */     message(response, msg, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void message(HttpServletResponse response, String msg, boolean result)
/*     */     throws IOException
/*     */   {
/* 231 */     HashMap<String, Object> data = new HashMap();
/* 232 */     data.put("success", Boolean.valueOf(result));
/* 233 */     data.put("msg", msg);
/* 234 */     jsonResponse(response, data);
/*     */   }
/*     */   
/*     */   protected Integer paramInt(HttpServletRequest request, String str) {
/* 238 */     return Integer.valueOf(NumberUtil.getInt(request.getParameter(str)));
/*     */   }
/*     */   
/*     */   protected Long paramLong(HttpServletRequest request, String str) {
/* 242 */     return Long.valueOf(NumberUtil.getLong(request.getParameter(str)));
/*     */   }
/*     */   
/*     */   protected String paramString(HttpServletRequest request, String str) {
/* 246 */     return StringUtil.isNull(request.getParameter(str));
/*     */   }
/*     */   
/*     */   protected String redirect(String url) {
/* 250 */     return "redirect:" + this.mlmsAppServerConfig + url;
/*     */   }
/*     */   
/*     */   protected String redirectLogin() {
/* 254 */     return redirect("/modules/login.htm");
/*     */   }
/*     */   
/*     */   protected String success() {
/* 258 */     return redirect("/success.htm");
/*     */   }
/*     */   
/*     */   protected String error() {
/* 262 */     return redirect("/error.htm");
/*     */   }
/*     */   
/*     */   protected String success(ModelMap model) {
/* 266 */     return "success";
/*     */   }
/*     */   
/*     */   protected String error(ModelMap model) {
/* 270 */     return "error";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isAllowAccess(String url)
/*     */   {
/* 281 */     Map<String, UserFunction> functionMap = ((UserRole)
/* 282 */       SecurityContextHolder.getContext().getAuthentication().getPrincipal())
/* 283 */       .getFunctionMap();
/* 284 */     if (functionMap.containsKey(url)) {
/* 285 */       return true;
/*     */     }
/* 287 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @ExceptionHandler({AuthorizationException.class})
/*     */   public void authorizationExceptionHandler(AuthorizationException e, HttpServletResponse response)
/*     */   {
/* 297 */     Map<String, Object> res = new HashMap();
/* 298 */     res.put("code", Integer.valueOf(403));
/* 299 */     res.put("msg", "对不起，您没有该权限");
/* 300 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   @ExceptionHandler({Exception.class})
/*     */   public void exceptionHandler(Exception e, HttpServletResponse response)
/*     */   {
/* 306 */     Map<String, Object> res = new HashMap();
/* 307 */     res.put("code", "400");
/* 308 */     res.put("msg", "系统出错了，请检查参数是否正确");
/* 309 */     logger.error("Exception:", e);
/* 310 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   @ExceptionHandler({MethodArgumentNotValidException.class})
/*     */   public void notNullException(MethodArgumentNotValidException e, HttpServletResponse response)
/*     */   {
/* 316 */     Map<String, Object> res = new HashMap();
/* 317 */     res.put("code", "400");
/* 318 */     BindingResult bindingResult = e.getBindingResult();
/* 319 */     if (bindingResult.hasErrors()) {
/* 320 */       String msg = bindingResult.getFieldError().getDefaultMessage();
/* 321 */       res.put("msg", msg);
/*     */     } else {
/* 323 */       res.put("msg", e.getMessage());
/*     */     }
/* 325 */     logger.error("MethodArgumentNotValidException:", e);
/* 326 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   @ExceptionHandler({ParamValideException.class})
/*     */   public void paramValideException(ParamValideException e, HttpServletResponse response) {
/* 331 */     Map<String, Object> res = new HashMap();
/* 332 */     res.put("code", "404");
/* 333 */     res.put("msg", e.getMessage());
/* 334 */     logger.error("MethodArgumentNotValidException:", e);
/* 335 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   @ExceptionHandler({ServiceException.class})
/*     */   public void excptionDispose(ServiceException e, HttpServletResponse response) {
/* 340 */     Map<String, Object> res = new HashMap();
/* 341 */     res.put("code", Integer.valueOf(e.getCode()));
/* 342 */     res.put("msg", e.getMessage());
/*     */     
/* 344 */     logger.error("ServiceException:", e);
/*     */     
/* 346 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   @ExceptionHandler({RuntimeException.class})
/*     */   public void runtimeExcptionDispose(RuntimeException e, HttpServletResponse response) {
/* 351 */     Map<String, Object> res = new HashMap();
/* 352 */     res.put("code", Integer.valueOf(500));
/* 353 */     res.put("msg", "系统出错了");
/*     */     
/* 355 */     logger.error("RuntimeException", e);
/*     */     
/* 357 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   @ExceptionHandler({BussinessException.class})
/*     */   public void bussinessException(BussinessException e, HttpServletResponse response)
/*     */   {
/* 363 */     Map<String, Object> res = new HashMap();
/* 364 */     if (org.apache.commons.lang3.StringUtils.isNotBlank(e.getCode())) {
/* 365 */       res.put("code", e.getCode());
/*     */     } else {
/* 367 */       res.put("code", Integer.valueOf(500));
/*     */     }
/* 369 */     res.put("msg", e.getMessage());
/*     */     
/* 371 */     logger.error("BussinessException", e);
/*     */     
/* 373 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */   @ExceptionHandler({BindException.class})
/*     */   public void bindException(BindException e, HttpServletResponse response) {
/* 378 */     Map<String, Object> res = new HashMap();
/* 379 */     res.put("code", Integer.valueOf(500));
/* 380 */     res.put("msg", "数据保存失败，请稍后重试");
/*     */     
/* 382 */     logger.error("参数校验失败" + e.getFieldError().getDefaultMessage(), e);
/*     */     
/* 384 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getRole(HttpServletRequest request)
/*     */   {
/* 395 */     List<Long> roles = new ArrayList();
/* 396 */     HttpSession session = request.getSession();
/* 397 */     Long role = (Long)session.getAttribute("roleId");
/* 398 */     roles.add(role);
/*     */     
/* 400 */     return roles;
/*     */   }
/*     */   
/*     */   public SysRole getRoleForLoginUser(HttpServletRequest request) throws ServiceException
/*     */   {
/* 405 */     HttpSession session = request.getSession();
/* 406 */     Long roleId = (Long)session.getAttribute("roleId");
/* 407 */     if (roleId == null) {
/* 408 */       return new SysRole();
/*     */     }
/* 410 */     SysRole role = this.roleService.getRoleById(roleId.longValue());
/*     */     
/* 412 */     return role;
/*     */   }
/*     */   
/*     */   public String getLoginUserName(HttpServletRequest request) throws ServiceException
/*     */   {
/* 417 */     SysUser loginUser = getLoginUser(request);
/*     */     
/* 419 */     return loginUser.getUserName();
/*     */   }
/*     */   
/*     */   public List<String> getCoverdOffices(SysUser loginUser) {
/* 423 */     ArrayList<String> list = new ArrayList();
/* 424 */     String coverdOfficeStr = loginUser.getOfficeOver();
/* 425 */     if (!org.springframework.util.StringUtils.hasLength(coverdOfficeStr)) {
/* 426 */       coverdOfficeStr = "null";
/*     */     }
/* 428 */     StringTokenizer stringTokenizer = new StringTokenizer(coverdOfficeStr, ",");
/* 429 */     while (stringTokenizer.hasMoreElements()) {
/* 430 */       list.add(stringTokenizer.nextToken());
/*     */     }
/* 432 */     return list;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getRequestFormMap(HttpServletRequest request) throws UnsupportedEncodingException {
/* 436 */     String str = getRequestParams(request);
/* 437 */     Map<String, Object> params = new HashMap();
/* 438 */     Enumeration<String> paramNames = request.getParameterNames();
/* 439 */     while (paramNames.hasMoreElements()) {
/* 440 */       String paramName = (String)paramNames.nextElement();
/*     */       
/* 442 */       String[] paramValues = request.getParameterValues(paramName);
/* 443 */       if (paramValues.length == 1) {
/* 444 */         String paramValue = paramValues[0];
/* 445 */         if (paramValue.length() != 0) {
/* 446 */           params.put(paramName, paramValue);
/*     */         }
/*     */       }
/*     */     }
/* 450 */     if ((StringUtil.isNotBlank(str)) && (params.size() == 0)) {
/* 451 */       String str1 = URLDecoder.decode(str, "UTF-8");
/* 452 */       String[] strs = str.split("name=");
/* 453 */       String[] strs1 = str1.split("&");
/* 454 */       for (int i = 1; i < strs.length; i++) {
/* 455 */         String temp = strs[i].substring(0, strs[i].indexOf("------"));
/* 456 */         int index = temp.indexOf("\"", 1);
/* 457 */         index++;
/* 458 */         String key = temp.substring(0, index);
/* 459 */         String value = temp.substring(index, temp.length());
/* 460 */         params.put(key, value);
/*     */       }
/* 462 */       for (int i = 0; i < strs1.length; i++) {
/* 463 */         String[] temp = strs1[i].split("=");
/* 464 */         params.put(temp[0], temp[1]);
/*     */       }
/*     */     }
/* 467 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRequestParams(HttpServletRequest request)
/*     */   {
/* 477 */     String params = "";
/*     */     try {
/* 479 */       request.setCharacterEncoding("UTF-8");
/* 480 */       InputStream in = request.getInputStream();
/* 481 */       StringBuilder sb = new StringBuilder();
/* 482 */       BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
/*     */       String line;
/* 484 */       while ((line = reader.readLine()) != null) { String line;
/* 485 */         sb.append(line);
/*     */       }
/* 487 */       params = sb.toString();
/*     */     } catch (Exception e) {
/* 489 */       logger.error(e.getMessage(), e);
/*     */     }
/* 491 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void generateImgCode()
/*     */     throws Exception
/*     */   {
/* 500 */     this.response.setContentType("image/jpeg");
/*     */     
/* 502 */     this.response.setHeader("Pragma", "no-cache");
/* 503 */     this.response.setHeader("Cache-Control", "no-cache");
/* 504 */     this.response.setDateHeader("Expires", 0L);
/*     */     
/* 506 */     HttpSession session = this.request.getSession();
/*     */     
/* 508 */     ValidateCode vCode = new ValidateCode(120, 40, 4, 50);
/* 509 */     session.setAttribute("code", vCode.getCode());
/* 510 */     vCode.write(this.response.getOutputStream());
/* 511 */     this.response.getOutputStream().flush();
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageBaseController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */