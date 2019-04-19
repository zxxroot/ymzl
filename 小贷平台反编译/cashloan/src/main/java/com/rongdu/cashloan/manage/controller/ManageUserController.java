/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.alibaba.druid.util.StringUtils;
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.BankCard;
/*     */ import com.rongdu.cashloan.cl.domain.Channel;
/*     */ import com.rongdu.cashloan.cl.domain.UserAuth;
/*     */ import com.rongdu.cashloan.cl.domain.UserEducationInfo;
/*     */ import com.rongdu.cashloan.cl.domain.UserEmerContacts;
/*     */ import com.rongdu.cashloan.cl.domain.Zhima;
/*     */ import com.rongdu.cashloan.cl.model.InviteBorrowModel;
/*     */ import com.rongdu.cashloan.cl.model.UserAuthModel;
/*     */ import com.rongdu.cashloan.cl.model.UserEducationInfoModel;
/*     */ import com.rongdu.cashloan.cl.service.BankCardService;
/*     */ import com.rongdu.cashloan.cl.service.ChannelService;
/*     */ import com.rongdu.cashloan.cl.service.QianChengBlacklistLogService;
/*     */ import com.rongdu.cashloan.cl.service.RcHuadaoBlacklistLogService;
/*     */ import com.rongdu.cashloan.cl.service.UserAuthService;
/*     */ import com.rongdu.cashloan.cl.service.UserEducationInfoService;
/*     */ import com.rongdu.cashloan.cl.service.UserEmerContactsService;
/*     */ import com.rongdu.cashloan.cl.service.UserInviteService;
/*     */ import com.rongdu.cashloan.cl.service.ZhimaService;
/*     */ import com.rongdu.cashloan.core.common.context.ExportConstant;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.HttpUtil;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.excel.JsGridReportBase;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.domain.UserBaseInfo;
/*     */ import com.rongdu.cashloan.core.domain.UserOtherInfo;
/*     */ import com.rongdu.cashloan.core.model.CloanUserModel;
/*     */ import com.rongdu.cashloan.core.model.ManagerUserModel;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import com.rongdu.cashloan.core.service.UserBaseInfoService;
/*     */ import com.rongdu.cashloan.core.service.UserOtherInfoService;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.creditrank.cr.model.CreditModel;
/*     */ import com.rongdu.creditrank.cr.service.CreditService;
/*     */ import credit.CreditRequest;
/*     */ import credit.Header;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.jfree.util.Log;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class ManageUserController
/*     */   extends ManageBaseController
/*     */ {
/*  86 */   private static final Logger logger = LoggerFactory.getLogger(ManageUserController.class);
/*     */   
/*     */   @Resource
/*     */   private CloanUserService cloanUserService;
/*     */   
/*     */   @Resource
/*     */   private UserAuthService authService;
/*     */   
/*     */   @Resource
/*     */   private UserBaseInfoService userBaseInfoService;
/*     */   
/*     */   @Resource
/*     */   private BankCardService bankCardService;
/*     */   
/*     */   @Resource
/*     */   private UserEmerContactsService userEmerContactsService;
/*     */   
/*     */   @Resource
/*     */   private UserInviteService userInviteService;
/*     */   
/*     */   @Resource
/*     */   private UserOtherInfoService userOtherInfoService;
/*     */   
/*     */   @Resource
/*     */   private UserEducationInfoService userEducationService;
/*     */   
/*     */   @Resource
/*     */   private CreditService creditService;
/*     */   @Resource
/*     */   private ZhimaService zhimaService;
/*     */   @Resource
/*     */   private ChannelService channelService;
/*     */   @Resource
/*     */   private QianChengBlacklistLogService qianChengBlacklistLogService;
/*     */   @Resource
/*     */   private RcHuadaoBlacklistLogService rcHuadaoBlacklistLogService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/cl/cluser/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:cl:cluser:list", name="用户信息列表")
/*     */   public void list(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 127 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 128 */     Page<CloanUserModel> page = this.cloanUserService.listUser(params, currentPage, pageSize);
/* 129 */     Map<String, Object> result = new HashMap();
/* 130 */     result.put("data", page);
/* 131 */     result.put("page", new RdPage(page));
/* 132 */     result.put("code", Integer.valueOf(200));
/* 133 */     result.put("msg", "获取成功");
/* 134 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/userInfo/export.htm"})
/*     */   public void userInfoExport(@RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 145 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 146 */     List list = this.cloanUserService.listUserExport(params);
/* 147 */     SysUser user = (SysUser)this.request.getSession().getAttribute("SysUser");
/* 148 */     this.response.setContentType("application/msexcel;charset=UTF-8");
/*     */     
/* 150 */     String title = "用戶信息Excel表";
/* 151 */     String[] hearders = ExportConstant.EXPORT_USERINFO_LIST_HEARDERS;
/* 152 */     String[] fields = ExportConstant.EXPORT_USERINFO_LIST_FIELDS;
/* 153 */     JsGridReportBase report = new JsGridReportBase(this.request, this.response);
/* 154 */     report.exportExcel(list, title, hearders, fields, user.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cl/cluser/detail.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:cl:cluser:detail", name="用户详细信息")
/*     */   public void detail(@RequestParam("userId") Long userId)
/*     */   {
/* 166 */     String serverHost = Global.getValue("manage_host");
/* 167 */     HashMap<String, Object> map = new HashMap();
/* 168 */     User user = (User)this.cloanUserService.getById(userId);
/* 169 */     if ((user != null) && (user.getId() != null))
/*     */     {
/* 171 */       ManagerUserModel model = this.userBaseInfoService.getBaseModelByUserId(userId);
/* 172 */       model.setLivingImg(model.getLivingImg() != null ? serverHost + "/readFile.htm?path=" + model.getLivingImg() : "");
/* 173 */       model.setFrontImg(model.getFrontImg() != null ? serverHost + "/readFile.htm?path=" + model.getFrontImg() : "");
/* 174 */       model.setBackImg(model.getBackImg() != null ? serverHost + "/readFile.htm?path=" + model.getBackImg() : "");
/* 175 */       model.setOcrImg(model.getOcrImg() != null ? serverHost + "/readFile.htm?path=" + model.getOcrImg() : "");
/*     */       
/* 177 */       if (StringUtil.isNotBlank(model.getWorkingImg())) {
/* 178 */         String workImgStr = model.getWorkingImg();
/* 179 */         List<String> workImgList = Arrays.asList(workImgStr.split(";"));
/* 180 */         for (int i = 0; i < workImgList.size(); i++) {
/* 181 */           String workImg = (String)workImgList.get(i);
/* 182 */           workImgList.set(i, serverHost + "/readFile.htm?path=" + workImg);
/*     */         }
/* 184 */         map.put("workImgArr", workImgList);
/*     */       }
/*     */       
/*     */ 
/* 188 */       if ((this.qianChengBlacklistLogService.isBlack(userId)) || (this.rcHuadaoBlacklistLogService.isBlack(userId))) {
/* 189 */         model.setBlack("是");
/*     */       } else {
/* 191 */         model.setBlack("否");
/*     */       }
/*     */       
/*     */ 
/* 195 */       BankCard bankCard = this.bankCardService.getBankCardByUserId(user.getId());
/* 196 */       if (bankCard != null) {
/* 197 */         model.setBank(bankCard.getBank());
/* 198 */         model.setCardNo(bankCard.getCardNo());
/* 199 */         model.setBankPhone(bankCard.getPhone());
/*     */       }
/*     */       
/* 202 */       Channel cl = (Channel)this.channelService.getById(user.getChannelId());
/* 203 */       if (cl != null) {
/* 204 */         model.setChannelName(cl.getName());
/*     */       }
/*     */       
/*     */ 
/* 208 */       Zhima zm = this.zhimaService.findByUserId(userId);
/* 209 */       if ((zm != null) && (zm.getScore().doubleValue() > 0.0D)) {
/* 210 */         model.setScore(zm.getScore().toString());
/*     */       }
/* 212 */       map.put("userbase", model);
/*     */       
/*     */ 
/* 215 */       HashMap<String, Object> paramMap = new HashMap();
/* 216 */       paramMap.put("userId", user.getId());
/*     */       
/*     */ 
/* 219 */       UserAuth authModel = this.authService.getUserAuth(paramMap);
/* 220 */       map.put("userAuth", authModel);
/*     */       
/*     */ 
/* 223 */       List<UserEmerContacts> infoModel = this.userEmerContactsService.getUserEmerContactsByUserId(paramMap);
/* 224 */       map.put("userContactInfo", infoModel);
/*     */       
/*     */ 
/* 227 */       UserOtherInfo otherInfo = this.userOtherInfoService.getInfoByUserId(user.getId());
/* 228 */       map.put("userOtherInfo", otherInfo);
/*     */     }
/*     */     
/* 231 */     Map<String, Object> result = new HashMap();
/* 232 */     result.put("data", map);
/* 233 */     result.put("code", Integer.valueOf(200));
/* 234 */     result.put("msg", "获取成功");
/* 235 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/cl/cluser/userTaobao.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void userTaobao(@RequestParam("userId") Long userId)
/*     */   {
/* 247 */     Log.info("userId" + userId);
/* 248 */     String tokenURL = "https://credit.baiqishi.com/clweb/api/common/gettoken";
/* 249 */     String prefix = "https://credit.baiqishi.com/clweb/api/tb/getreportpage?";
/*     */     
/* 251 */     String partnerId = Global.getValue("white_knight_merno");
/* 252 */     String verifyKey = Global.getValue("white_knight_verifyKey");
/*     */     
/* 254 */     if ((userId == null) || (userId.longValue() == 0L)) {
/* 255 */       Map<String, Object> result = new HashMap();
/* 256 */       result.put("code", Integer.valueOf(400));
/* 257 */       result.put("msg", "获取失败");
/* 258 */       ServletUtils.writeToResponse(this.response, result);
/* 259 */       return;
/*     */     }
/*     */     try {
/* 262 */       UserBaseInfo info = this.userBaseInfoService.findByUserId(userId);
/* 263 */       long timeStamp = System.currentTimeMillis();
/*     */       
/* 265 */       if (info != null) {
/* 266 */         JSONObject req = new JSONObject();
/* 267 */         req.put("partnerId", partnerId);
/* 268 */         req.put("verifyKey", verifyKey);
/* 269 */         req.put("certNo", info.getIdNo());
/* 270 */         req.put("timeStamp", Long.valueOf(timeStamp));
/* 271 */         String encodeStr = URLEncoder.encode(JSON.toJSONString(req), "UTF-8");
/* 272 */         String resp = (String)HttpUtil.postClient4Obj(tokenURL, encodeStr, String.class);
/* 273 */         if (!StringUtils.isEmpty(resp)) {
/* 274 */           JSONObject json = JSONObject.parseObject(resp);
/* 275 */           String token = json.getString("data");
/* 276 */           String resultCode = json.getString("resultCode");
/* 277 */           if ("CCOM1000".equals(resultCode))
/*     */           {
/* 279 */             String name = URLEncoder.encode(info.getRealName(), "utf-8");
/* 280 */             String url = String.format("%spartnerId=%s&certNo=%s&name=%s&mobile=%s&timeStamp=%s&token=%s", new Object[] {
/* 281 */               prefix, partnerId, info.getIdNo(), name, info.getPhone(), Long.valueOf(timeStamp), token });
/* 282 */             Map<String, Object> result = new HashMap();
/* 283 */             result.put("code", Integer.valueOf(200));
/* 284 */             result.put("msg", "获取成功");
/* 285 */             result.put("data", url);
/* 286 */             ServletUtils.writeToResponse(this.response, result);
/* 287 */             return;
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 292 */       Map<String, Object> result = new HashMap();
/* 293 */       result.put("code", Integer.valueOf(400));
/* 294 */       result.put("msg", "获取失败");
/* 295 */       ServletUtils.writeToResponse(this.response, result);
/*     */     }
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
/*     */   @RequestMapping(value={"/modules/manage/cl/cluser/authlist.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:cl:cluser:authlist", name="用户认证信息列表")
/*     */   public void authlist(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 320 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 321 */     Page<UserAuthModel> page = this.authService.listUserAuth(params, currentPage, pageSize);
/* 322 */     Map<String, Object> result = new HashMap();
/* 323 */     result.put("data", page);
/* 324 */     result.put("page", new RdPage(page));
/* 325 */     result.put("code", Integer.valueOf(200));
/* 326 */     result.put("msg", "获取成功");
/* 327 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/cl/cluser/credit/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:cl:cluser:credit:list", name="查询用户列表")
/*     */   public void page(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 346 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/* 347 */     Page<CreditModel> page = this.creditService.page(searchMap, currentPage, pageSize);
/* 348 */     Map<String, Object> result = new HashMap();
/* 349 */     result.put("data", page);
/* 350 */     result.put("page", new RdPage(page));
/* 351 */     result.put("code", Integer.valueOf(200));
/* 352 */     result.put("msg", "查询成功");
/* 353 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/invite/listInviteBorrow.htm"})
/*     */   public void listInviteBorrow(@RequestParam("userId") long userId, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 368 */     Page<InviteBorrowModel> page = this.userInviteService.listInviteBorrow(userId, current, pageSize);
/* 369 */     Map<String, Object> data = new HashMap();
/* 370 */     data.put("list", page.getResult());
/* 371 */     Map<String, Object> result = new HashMap();
/* 372 */     result.put("data", data);
/* 373 */     result.put("page", new RdPage(page));
/* 374 */     result.put("code", Integer.valueOf(200));
/* 375 */     result.put("msg", "查询成功");
/* 376 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/user/updateState.htm"})
/*     */   public void updateState(@RequestParam("id") long id, @RequestParam("state") String state)
/*     */     throws Exception
/*     */   {
/* 389 */     int msg = this.userBaseInfoService.updateState(id, state);
/* 390 */     Map<String, Object> result = new HashMap();
/* 391 */     if (msg < 0) {
/* 392 */       result.put("code", Integer.valueOf(400));
/* 393 */       result.put("msg", "修改失败");
/*     */     } else {
/* 395 */       result.put("code", Integer.valueOf(200));
/* 396 */       result.put("msg", "修改成功");
/*     */     }
/*     */     
/* 399 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/user/educationRequest.htm"})
/*     */   public void apiEducationRequest(@RequestParam("name") String name, @RequestParam("idCard") String idCard)
/*     */     throws Exception
/*     */   {
/* 410 */     String APIKEY = Global.getValue("apikey");
/* 411 */     String SECRETKEY = Global.getValue("secretkey");
/* 412 */     String url = Global.getValue("tx_apihost");
/* 413 */     String channelNo = Global.getValue("tx_channelNo");
/* 414 */     String interfaceName = Global.getValue("tx_interfaceName");
/*     */     
/* 416 */     long timestamp = new Date().getTime();
/* 417 */     Header header = new Header(APIKEY, channelNo, interfaceName, timestamp);
/*     */     
/* 419 */     CreditRequest creditRequest = new CreditRequest(url, header);
/*     */     
/* 421 */     Map<String, Object> payload = new HashMap();
/*     */     
/* 423 */     payload.put("name", name);
/* 424 */     payload.put("idCard", idCard);
/*     */     
/* 426 */     creditRequest.setPayload(payload);
/*     */     
/* 428 */     creditRequest.signByKey(SECRETKEY);
/*     */     
/* 430 */     String resultStr = creditRequest.request();
/*     */     
/* 432 */     JSONObject resultJson = JSONObject.parseObject(resultStr);
/*     */     
/*     */ 
/* 435 */     Map<String, Object> map = new HashMap();
/* 436 */     map.put("loginName", name);
/* 437 */     User user = this.cloanUserService.findByPhone(name);
/*     */     
/* 439 */     UserBaseInfo ubi = new UserBaseInfo();
/* 440 */     if (user != null) {
/* 441 */       map = new HashMap();
/* 442 */       map.put("userId", user.getId());
/* 443 */       ubi = this.userBaseInfoService.findSelective(map);
/*     */     }
/*     */     
/* 446 */     int msg = 0;
/* 447 */     Map<String, Object> result = new HashMap();
/* 448 */     if ((ubi != null) && (resultJson.getInteger("code").intValue() == 200)) {
/* 449 */       JSONObject resJson = JSONObject.parseObject(StringUtil.isNull(resultJson.get("res")));
/* 450 */       logger.info(StringUtil.isNull(resJson));
/* 451 */       UserEducationInfo ue = new UserEducationInfo();
/* 452 */       ue.setUserId(ubi.getUserId());
/* 453 */       ue.setEducationType(resJson.getString("educationType"));
/* 454 */       ue.setProfession(resJson.getString("profession"));
/* 455 */       ue.setMatriculationTime(resJson.getString("matriculationTime"));
/* 456 */       ue.setGraduateSchool(resJson.getString("graduateSchool"));
/* 457 */       ue.setGraduationTime(resJson.getString("graduationTime"));
/* 458 */       ue.setGraduationConclusion(resJson.getString("graduationConclusion"));
/* 459 */       ue.setEducationBackground(resJson.getString("educationBackground"));
/* 460 */       ue.setState("20");
/* 461 */       msg = this.userEducationService.save(ue);
/*     */     }
/* 463 */     logger.info(resultJson.getString("message"));
/* 464 */     if (msg > 0) {
/* 465 */       result.put("code", Integer.valueOf(200));
/* 466 */       result.put("msg", "操作成功");
/*     */     } else {
/* 468 */       result.put("code", Integer.valueOf(400));
/* 469 */       result.put("msg", "操作失败");
/*     */     }
/*     */     
/* 472 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/user/updateEducation.htm"})
/*     */   public void updateEducation(UserEducationInfo uei)
/*     */     throws Exception
/*     */   {
/* 482 */     int msg = this.userEducationService.update(uei);
/* 483 */     Map<String, Object> result = new HashMap();
/* 484 */     if (msg < 0) {
/* 485 */       result.put("code", Integer.valueOf(400));
/* 486 */       result.put("msg", "修改失败");
/*     */     } else {
/* 488 */       result.put("code", Integer.valueOf(200));
/* 489 */       result.put("msg", "修改成功");
/*     */     }
/*     */     
/* 492 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/user/educationList.htm"})
/*     */   public void educationList(@RequestParam(value="search", required=false) String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 506 */     Map<String, Object> searchMap = (Map)JsonUtil.parse(search, Map.class);
/* 507 */     Page<UserEducationInfoModel> page = this.userEducationService.list(searchMap, current, pageSize);
/* 508 */     Map<String, Object> result = new HashMap();
/* 509 */     Map<String, Object> data = new HashMap();
/* 510 */     data.put("list", page.getResult());
/* 511 */     result.put("data", data);
/* 512 */     result.put("page", new RdPage(page));
/* 513 */     result.put("code", Integer.valueOf(200));
/* 514 */     result.put("msg", "查询成功");
/* 515 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageUserController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */