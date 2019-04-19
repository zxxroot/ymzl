package com.rongdu.cashloan.core.common.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongdu.cashloan.core.common.exception.BussinessException;
import com.rongdu.cashloan.core.common.exception.ParamValideException;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.exception.SimpleMessageException;
import com.rongdu.cashloan.core.common.model.URLConfig;
import com.rongdu.cashloan.core.common.util.ServletUtils;
import com.rongdu.cashloan.core.common.util.ValidateCode;
import com.rongdu.cashloan.system.domain.SysRole;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.cashloan.system.security.userdetails.UserFunction;
import com.rongdu.cashloan.system.security.userdetails.UserRole;
import com.rongdu.cashloan.system.service.SysRoleService;
import com.rongdu.cashloan.system.service.SysUserService;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import tool.util.NumberUtil;
import tool.util.StringUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public abstract class BaseController
/*     */   extends AbstractController
/*     */ {
/*  81 */   protected Logger logger = LoggerFactory.getLogger(getClass());
/*     */   protected HttpServletRequest request;
/*     */   public HttpServletResponse response;
/*     */   protected HttpSession session;
/*     */   static final String CHARSET_UTF_8 = "UTF-8";
/*     */   static final boolean IS_DEBUG = true;
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
/*  97 */     this.request = request;
/*  98 */     this.response = response;
/*  99 */     this.session = request.getSession();
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   @InitBinder
/*     */   protected final void initBinderInternal(WebDataBinder binder)
/*     */   {
/* 109 */     registerDefaultCustomDateEditor(binder);
/* 110 */     registerDefaultCustomNumberEditor(binder);
/* 111 */     initBinder(binder);
/*     */   }
/*     */
/*     */   private void registerDefaultCustomNumberEditor(WebDataBinder binder)
/*     */   {
/* 116 */     NumberFormat numberFormat = new DecimalFormat("#0.00");
/* 117 */     binder.registerCustomEditor(Double.class, new CustomNumberEditor(
/* 118 */       Double.class, numberFormat, true));
/*     */   }
/*     */
/*     */   protected void registerDefaultCustomDateEditor(WebDataBinder binder)
/*     */   {
/* 123 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 124 */     dateFormat.setLenient(false);
/* 125 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(
/* 126 */       dateFormat, true));
/*     */   }
/*     */   protected void initBinder(WebDataBinder binder) {}
/*     */
/*     */   protected SysUser getLoginUser(HttpServletRequest request)
/*     */   {
/* 145 */     Object obj = request.getSession().getAttribute("SysUser");
/* 146 */     if (obj != null) {
/* 147 */       return (SysUser)obj;
/*     */     }
/* 149 */     return null;
/*     */   }
/*     */
/*     */   protected SysUser getSysUser()
/*     */     throws ServiceException
/*     */   {
/* 160 */     UserDetails user = (UserDetails)SecurityContextHolder.getContext()
/* 161 */       .getAuthentication().getPrincipal();
/* 162 */     SysUser sysUser = this.sysUserService.getUserByUserName(user.getUsername());
/* 163 */     return sysUser;
/*     */   }
/*     */
/*     */   protected void setToken(String tokenName, HttpServletRequest request)
/*     */   {
/* 176 */     HttpSession session = request.getSession(false);
/* 177 */     if (session == null) {
/* 178 */       session = request.getSession();
/*     */     }
/* 180 */     session.setAttribute(tokenName, "true");
/*     */   }
/*     */
/*     */   protected String isToken(String tokenName, HttpServletRequest request)
/*     */   {
/* 194 */     HttpSession session = request.getSession(false);
/* 195 */     if (session == null) {
/* 196 */       session = request.getSession();
/*     */     }
/* 198 */     String tokenValue = (String)session.getAttribute(tokenName);
/* 199 */     String paramValue = request.getParameter(tokenName);
/*     */
/*     */
/* 202 */     if ((StringUtil.isBlank(paramValue)) && (StringUtil.isBlank(tokenValue)))
/* 203 */       return "会话Token未设定！";
/* 204 */     if ((StringUtil.isBlank(paramValue)) &&
/* 205 */       (!StringUtil.isBlank(tokenValue)))
/* 206 */       return "表单Token未设定！";
/* 207 */     if ((paramValue.equals(tokenValue)) &&
/* 208 */       (!StringUtil.isBlank(tokenValue)) && ("true".equals(tokenValue))) {
/* 209 */       session.setAttribute(tokenName, "false");
/* 210 */       return "";
/*     */     }
/* 212 */     return "请勿重复提交！";
/*     */   }
/*     */
/*     */   protected void message(HttpServletResponse response) throws IOException
/*     */   {
/* 217 */     message(response, "", true);
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
/* 228 */     message(response, msg, true);
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
/* 239 */     HashMap<String, Object> data = new HashMap();
/* 240 */     data.put("success", Boolean.valueOf(result));
/* 241 */     data.put("msg", msg);
/* 242 */     jsonResponse(response, data);
/*     */   }
/*     */
/*     */   protected Integer paramInt(HttpServletRequest request, String str) {
/* 246 */     return Integer.valueOf(NumberUtil.getInt(request.getParameter(str)));
/*     */   }
/*     */
/*     */   protected Long paramLong(HttpServletRequest request, String str) {
/* 250 */     return Long.valueOf(NumberUtil.getLong(request.getParameter(str)));
/*     */   }
/*     */
/*     */   protected String paramString(HttpServletRequest request, String str) {
/* 254 */     return StringUtil.isNull(request.getParameter(str));
/*     */   }
/*     */
/*     */   protected String redirect(String url) {
/* 258 */     return "redirect:" + this.mlmsAppServerConfig + url;
/*     */   }
/*     */
/*     */   protected String redirectLogin() {
/* 262 */     return redirect("/modules/login.htm");
/*     */   }
/*     */
/*     */   protected String success() {
/* 266 */     return redirect("/success.htm");
/*     */   }
/*     */
/*     */   protected String error() {
/* 270 */     return redirect("/error.htm");
/*     */   }
/*     */
/*     */   protected String success(ModelMap model) {
/* 274 */     return "success";
/*     */   }
/*     */
/*     */   protected String error(ModelMap model) {
/* 278 */     return "error";
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
/* 289 */     Map<String, UserFunction> functionMap = ((UserRole)
/* 290 */       SecurityContextHolder.getContext().getAuthentication().getPrincipal())
/* 291 */       .getFunctionMap();
/* 292 */     if (functionMap.containsKey(url)) {
/* 293 */       return true;
/*     */     }
/* 295 */     return false;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   @ExceptionHandler({AuthorizationException.class})
/*     */   public void authorizationExceptionHandler(AuthorizationException e, HttpServletResponse response)
/*     */   {
/* 305 */     Map<String, Object> res = new HashMap();
/* 306 */     res.put("code", Integer.valueOf(403));
/* 307 */     res.put("msg", "对不起，您没有该权限");
/* 308 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */
/*     */   @ExceptionHandler({Exception.class})
/*     */   public void exceptionHandler(Exception e, HttpServletResponse response)
/*     */   {
/* 314 */     Map<String, Object> res = new HashMap();
/* 315 */     res.put("code", "400");
/* 316 */     res.put("msg", "系统出错了，请检查参数是否正确");
/* 317 */     this.logger.error("Exception:", e);
/* 318 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */
/*     */   @ExceptionHandler({MethodArgumentNotValidException.class})
/*     */   public void notNullException(MethodArgumentNotValidException e, HttpServletResponse response) throws IOException
/*     */   {
/* 324 */     Map<String, Object> res = new HashMap();
/* 325 */     res.put("code", "400");
/* 326 */     BindingResult bindingResult = e.getBindingResult();
/* 327 */     if (bindingResult.hasErrors()) {
/* 328 */       String msg = bindingResult.getFieldError().getDefaultMessage();
/* 329 */       res.put("msg", msg);
/*     */     } else {
/* 331 */       res.put("msg", e.getMessage());
/*     */     }
/* 333 */     this.logger.error("MethodArgumentNotValidException:", e);
/* 334 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */
/*     */   @ExceptionHandler({ParamValideException.class})
/*     */   public void paramValideException(ParamValideException e, HttpServletResponse response) {
/* 339 */     Map<String, Object> res = new HashMap();
/* 340 */     res.put("code", "404");
/* 341 */     res.put("msg", e.getMessage());
/* 342 */     this.logger.error("MethodArgumentNotValidException:", e);
/* 343 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */
/*     */   @ExceptionHandler({ServiceException.class})
/*     */   public void excptionDispose(ServiceException e, HttpServletResponse response) {
/* 348 */     Map<String, Object> res = new HashMap();
/* 349 */     res.put("code", Integer.valueOf(e.getCode()));
/* 350 */     res.put("msg", "操作失败");
/*     */
/* 352 */     this.logger.error("ServiceException:", e);
/*     */
/* 354 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */
/*     */   @ExceptionHandler({RuntimeException.class})
/*     */   public void runtimeExcptionDispose(RuntimeException e, HttpServletResponse response) {
/* 359 */     Map<String, Object> res = new HashMap();
/* 360 */     res.put("code", Integer.valueOf(500));
/* 361 */     res.put("msg", "系统出错了");
/*     */
/* 363 */     this.logger.error("RuntimeException", e);
/*     */
/* 365 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */
/*     */   @ExceptionHandler({BussinessException.class})
/*     */   public void bussinessException(BussinessException e, HttpServletResponse response) {
/* 370 */     Map<String, Object> res = new HashMap();
/* 371 */     if (org.apache.commons.lang3.StringUtils.isNotBlank(e.getCode())) {
/* 372 */       res.put("code", e.getCode());
/*     */     } else {
/* 374 */       res.put("code", Integer.valueOf(500));
/*     */     }
/* 376 */     res.put("msg", e.getMessage());
/*     */
/* 378 */     this.logger.error("BussinessException", e);
/*     */
/* 380 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */
/*     */   @ExceptionHandler({SimpleMessageException.class})
/*     */   public void simpleMessageException(SimpleMessageException e, HttpServletResponse response) {
/* 385 */     Map<String, Object> res = new HashMap();
/* 386 */     if (org.apache.commons.lang3.StringUtils.isNotBlank(e.getCode())) {
/* 387 */       res.put("code", e.getCode());
/*     */     } else {
/* 389 */       res.put("code", Integer.valueOf(500));
/*     */     }
/* 391 */     res.put("msg", e.getMessage());
/*     */
/* 393 */     this.logger.error("SimpleMessageException", e);
/*     */
/* 395 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */
/*     */   @ExceptionHandler({BindException.class})
/*     */   public void bindException(BindException e, HttpServletResponse response)
/*     */   {
/* 401 */     Map<String, Object> res = new HashMap();
/* 402 */     res.put("code", Integer.valueOf(500));
/* 403 */     res.put("msg", "数据保存失败，请稍后重试");
/*     */
/* 405 */     this.logger.error("参数校验失败" + e.getFieldError().getDefaultMessage(), e);
/*     */
/* 407 */     ServletUtils.writeToResponse(response, res);
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
/* 418 */     List<Long> roles = new ArrayList();
/* 419 */     HttpSession session = request.getSession();
/* 420 */     Long role = (Long)session.getAttribute("roleId");
/* 421 */     roles.add(role);
/*     */
/* 423 */     return roles;
/*     */   }
/*     */
/*     */   public SysRole getRoleForLoginUser(HttpServletRequest request) throws ServiceException
/*     */   {
/* 428 */     HttpSession session = request.getSession();
/* 429 */     Long roleId = (Long)session.getAttribute("roleId");
/* 430 */     if (roleId == null) {
/* 431 */       return new SysRole();
/*     */     }
/* 433 */     SysRole role = this.roleService.getRoleById(roleId.longValue());
/*     */
/* 435 */     return role;
/*     */   }
/*     */
/*     */   public String getLoginUserName(HttpServletRequest request) throws ServiceException
/*     */   {
/* 440 */     SysUser loginUser = getLoginUser(request);
/*     */
/* 442 */     return loginUser.getUserName();
/*     */   }
/*     */
/*     */   public List<String> getCoverdOffices(SysUser loginUser) {
/* 446 */     ArrayList<String> list = new ArrayList();
/* 447 */     String coverdOfficeStr = loginUser.getOfficeOver();
/* 448 */     if (!org.springframework.util.StringUtils.hasLength(coverdOfficeStr)) {
/* 449 */       coverdOfficeStr = "null";
/*     */     }
/* 451 */     StringTokenizer stringTokenizer = new StringTokenizer(coverdOfficeStr, ",");
/* 452 */     while (stringTokenizer.hasMoreElements()) {
/* 453 */       list.add(stringTokenizer.nextToken());
/*     */     }
/* 455 */     return list;
/*     */   }
/*     */
/*     */   public Map<String, Object> getRequestFormMap(HttpServletRequest request) throws UnsupportedEncodingException {
/* 459 */     String str = getRequestParams(request);
/* 460 */     Map<String, Object> params = new HashMap();
/* 461 */     Enumeration<String> paramNames = request.getParameterNames();
/* 462 */     while (paramNames.hasMoreElements()) {
/* 463 */       String paramName = (String)paramNames.nextElement();
/*     */
/* 465 */       String[] paramValues = request.getParameterValues(paramName);
/* 466 */       if (paramValues.length == 1) {
/* 467 */         String paramValue = paramValues[0];
/* 468 */         if (paramValue.length() != 0) {
/* 469 */           params.put(paramName, paramValue);
/*     */         }
/*     */       }
/*     */     }
/* 473 */     if ((StringUtil.isNotBlank(str)) && (params.size() == 0)) {
/* 474 */       String str1 = URLDecoder.decode(str, "UTF-8");
/* 475 */       String[] strs = str.split("name=");
/* 476 */       String[] strs1 = str1.split("&");
/* 477 */       for (int i = 1; i < strs.length; i++) {
/* 478 */         String temp = strs[i].substring(0, strs[i].indexOf("------"));
/* 479 */         int index = temp.indexOf("\"", 1);
/* 480 */         index++;
/* 481 */         String key = temp.substring(0, index);
/* 482 */         String value = temp.substring(index, temp.length());
/* 483 */         params.put(key, value);
/*     */       }
/* 485 */       for (int i = 0; i < strs1.length; i++) {
/* 486 */         String[] temp = strs1[i].split("=");
/* 487 */         params.put(temp[0], temp[1]);
/*     */       }
/*     */     }
/* 490 */     return params;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public String getRequestParams(HttpServletRequest request)
/*     */   {
/* 500 */     String params = "";
/*     */     try {
/* 502 */       request.setCharacterEncoding("UTF-8");
/* 503 */       InputStream in = request.getInputStream();
/* 504 */       StringBuilder sb = new StringBuilder();
/* 505 */       BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
/*     */       String line;
/* 507 */       while ((line = reader.readLine()) != null) {
/* 508 */         sb.append(line);
/*     */       }
/* 510 */       params = sb.toString();
/*     */     } catch (Exception e) {
/* 512 */       this.logger.error(e.getMessage(), e);
/*     */     }
/* 514 */     return params;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */   protected void generateImgCode()
/*     */     throws Exception
/*     */   {
/* 523 */     this.response.setContentType("image/jpeg");
/*     */
/* 525 */     this.response.setHeader("Pragma", "no-cache");
/* 526 */     this.response.setHeader("Cache-Control", "no-cache");
/* 527 */     this.response.setDateHeader("Expires", 0L);
/*     */
/* 529 */     HttpSession session = this.request.getSession();
/*     */
/* 531 */     ValidateCode vCode = new ValidateCode(120, 40, 4, 50);
/* 532 */     session.setAttribute("code", vCode.getCode());
/* 533 */     vCode.write(this.response.getOutputStream());
/* 534 */     this.response.getOutputStream().flush();
/*     */   }
/*     */
/*     */   protected Map<String, Object> getParams(HttpServletRequest request) {
/* 538 */     Map<String, String[]> rec = request.getParameterMap();
/* 539 */     Map<String, Object> result = new LinkedHashMap();
/* 540 */     for (Map.Entry<String, String[]> entry : rec.entrySet()) {
/* 541 */       String name = (String)entry.getKey();
/* 542 */       Object value = ((String[])entry.getValue())[0];
/* 543 */       result.put(name, value);
/*     */     }
/* 545 */     return result;
/*     */   }
/*     */
/*     */
/*     */   protected JSONObject getRequestJson(HttpServletRequest request)
/*     */     throws IOException
/*     */   {
/* 552 */     InputStream in = request.getInputStream();
/* 553 */     byte[] b = new byte['⠀'];
/*     */
/* 555 */     ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 556 */     int len; while ((len = in.read(b)) > 0) {
/* 557 */       baos.write(b, 0, len);
/*     */     }
/* 559 */     String bodyText = new String(baos.toByteArray(), "UTF-8");
/* 560 */     JSONObject json = (JSONObject)JSONObject.parse(bodyText);
/*     */
/* 562 */     this.logger.info("getRequestJson(HttpServletRequest) - received notify message={}",
/* 563 */       JSON.toJSONString(json, true));
/*     */
/* 565 */     return json;
/*     */   }
/*     */ }