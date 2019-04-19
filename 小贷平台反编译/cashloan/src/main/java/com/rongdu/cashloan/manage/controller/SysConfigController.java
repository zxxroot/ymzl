/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.fasterxml.jackson.core.type.TypeReference;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.CacheUtil;
/*     */ import com.rongdu.cashloan.core.common.util.DateUtil;
/*     */ import com.rongdu.cashloan.core.common.util.HttpUtil;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.PropertiesUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.rc.domain.TppBusiness;
/*     */ import com.rongdu.cashloan.rc.service.TppBusinessService;
/*     */ import com.rongdu.cashloan.system.domain.SysConfig;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.model.SysConfigModel;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysConfigService;
/*     */ import com.rongdu.cashloan.system.service.SysDictService;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.util.StringUtils;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class SysConfigController
/*     */   extends BaseController
/*     */ {
/*  62 */   private static final Logger logger = LoggerFactory.getLogger(SysConfigController.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private SysConfigService sysConfigService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private SysDictService sysDictService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private TppBusinessService tppBusinessService;
/*     */   
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/config/save.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:config:save", name="系统管理-系统参数设置-新增")
/*     */   public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="json", required=false) String json, @RequestParam(value="status", required=false) String status)
/*     */     throws Exception
/*     */   {
/*  82 */     Map<String, Object> returnMap = new HashMap();
/*     */     
/*     */ 
/*  85 */     SysConfig sysConfig = new SysConfig();
/*     */     
/*  87 */     if (!StringUtils.isEmpty(json))
/*  88 */       sysConfig = (SysConfig)JsonUtil.parse(json, SysConfig.class);
/*  89 */     long flag; long flag; if ("create".equals(status)) {
/*  90 */       SysUser sysUser = getLoginUser(request);
/*  91 */       sysConfig.setStatus(Integer.valueOf(1));
/*  92 */       sysConfig.setCreator(sysUser.getId());
/*     */       
/*  94 */       flag = this.sysConfigService.insertSysConfig(sysConfig);
/*     */     }
/*     */     else {
/*  97 */       flag = this.sysConfigService.updateSysConfig(sysConfig);
/*     */     }
/*     */     
/* 100 */     if (flag > 0L) {
/* 101 */       returnMap.put("code", Integer.valueOf(200));
/* 102 */       returnMap.put("msg", "操作成功,刷新缓存后生效");
/*     */     } else {
/* 104 */       returnMap.put("code", Integer.valueOf(400));
/* 105 */       returnMap.put("msg", "操作失败");
/*     */     }
/*     */     
/* 108 */     ServletUtils.writeToResponse(response, returnMap);
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
/*     */   @RequestMapping({"/modules/manage/system/config/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:config:list", name="系统管理-系统参数设置-查询")
/*     */   public void listConfigs(HttpServletRequest request, HttpServletResponse response, @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize, @RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws Exception
/*     */   {
/* 132 */     Map<String, Object> paramap = new HashMap();
/* 133 */     if (!StringUtils.isEmpty(searchParams)) {
/* 134 */       paramap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/* 136 */     List<Map<String, Object>> typeList = new ArrayList();
/* 137 */     Map<String, Object> dataMap = new HashMap();
/*     */     
/* 139 */     List<Map<String, Object>> dicList = this.sysDictService.getDictsCache("SYSTEM_TYPE");
/* 140 */     for (Map<String, Object> dic : dicList) {
/* 141 */       Map<String, Object> types = new HashMap();
/* 142 */       types.put("systemType", dic.get("value"));
/* 143 */       types.put("systemTypeName", dic.get("text"));
/* 144 */       dataMap.put((String)dic.get("value"), dic.get("text"));
/* 145 */       typeList.add(types);
/*     */     }
/*     */     
/* 148 */     Page<SysConfig> page = this.sysConfigService.getSysConfigPageList(current.intValue(), pageSize.intValue(), paramap);
/*     */     
/* 150 */     Object sysModel = new ArrayList();
/* 151 */     if ((page != null) && (!page.isEmpty())) {
/* 152 */       for (SysConfig sys : page) {
/* 153 */         SysConfigModel model = new SysConfigModel();
/* 154 */         model = model.getSysModel(sys, dataMap);
/* 155 */         ((List)sysModel).add(model);
/*     */       }
/*     */     }
/* 158 */     Map<String, Object> returnMap = new HashMap();
/*     */     
/*     */ 
/* 161 */     returnMap.put("dicData", typeList);
/* 162 */     returnMap.put("data", sysModel);
/* 163 */     returnMap.put("page", new RdPage(page));
/* 164 */     returnMap.put("code", Integer.valueOf(200));
/* 165 */     returnMap.put("msg", "操作成功");
/*     */     
/* 167 */     ServletUtils.writeToResponse(response, returnMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/config/delete.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:config:delete", name="系统管理-系统参数设置- 修改状态")
/*     */   public void deleteSysConfig(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id, @RequestParam("status") int status)
/*     */     throws Exception
/*     */   {
/* 182 */     Map<String, Object> returnMap = new HashMap();
/*     */     
/* 184 */     SysConfig sysConfig = new SysConfig();
/*     */     
/* 186 */     sysConfig.setId(Long.valueOf(id));
/* 187 */     sysConfig.setStatus(Integer.valueOf(status));
/* 188 */     long flag = this.sysConfigService.updateSysConfig(sysConfig);
/*     */     
/* 190 */     if (flag > 0L) {
/* 191 */       returnMap.put("code", Integer.valueOf(200));
/* 192 */       returnMap.put("msg", "操作成功,刷新缓存后生效");
/*     */     } else {
/* 194 */       returnMap.put("code", Integer.valueOf(400));
/* 195 */       returnMap.put("msg", "操作失败");
/*     */     }
/*     */     
/* 198 */     ServletUtils.writeToResponse(response, returnMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/config/reload.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:config:reload", name="系统管理-系统参数设置-缓存数据重加载")
/*     */   public void reload()
/*     */     throws Exception
/*     */   {
/* 209 */     Map<String, Object> returnMap = new HashMap();
/*     */     
/*     */ 
/* 212 */     CacheUtil.initSysConfig();
/*     */     
/*     */ 
/*     */ 
/* 216 */     String webCleanUrl = Global.getValue("server_host") + "/system/config/reload.htm";
/* 217 */     String webResult = null;
/*     */     try {
/* 219 */       webResult = HttpUtil.getHttpResponse(webCleanUrl);
/* 220 */       logger.info("刷新api缓存结果:" + webResult);
/*     */     } catch (Exception e) {
/* 222 */       logger.info("刷新api缓存出错");
/* 223 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */     
/* 226 */     if (StringUtil.isNotBlank(webResult))
/*     */     {
/* 228 */       Map<String, Object> result = (Map)JsonUtil.parse(webResult, Map.class);
/* 229 */       String resultCode = StringUtil.isNull(result.get("code"));
/* 230 */       if ((StringUtil.isNotBlank(resultCode)) && 
/* 231 */         (StringUtil.isNull(Integer.valueOf(200)).equals(resultCode))) {
/* 232 */         returnMap.put("code", Integer.valueOf(200));
/* 233 */         returnMap.put("msg", "操作成功");
/*     */       } else {
/* 235 */         returnMap.put("code", Integer.valueOf(400));
/* 236 */         returnMap.put("msg", "操作失败");
/*     */       }
/*     */     } else {
/* 239 */       returnMap.put("code", Integer.valueOf(200));
/* 240 */       returnMap.put("msg", "后台缓存刷新完成,前台缓存刷新失败");
/*     */     }
/*     */     
/*     */ 
/* 244 */     ServletUtils.writeToResponse(this.response, returnMap);
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
/*     */   @RequestMapping({"/modules/manage/system/config/testConfiguration.htm"})
/*     */   public void testConfiguration(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="searchParams", required=false) String searchParams)
/*     */   {
/*     */     try
/*     */     {
/* 262 */       Map<String, Object> returnMap = new HashMap();
/* 263 */       Map<String, Object> paramap = new HashMap();
/* 264 */       if (!StringUtils.isEmpty(searchParams)) {
/* 265 */         paramap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */       }
/* 267 */       List<SysConfig> list = this.sysConfigService.getList(paramap);
/*     */       
/* 269 */       FileWriter fw = null;
/* 270 */       BufferedWriter bw = null;
/* 271 */       FileReader fr = null;
/* 272 */       BufferedReader br = null;
/* 273 */       String basepath = getClass().getResource("/").getPath() + "configuration";
/*     */       
/* 275 */       File folder = new File(basepath);
/* 276 */       folder.mkdirs();
/* 277 */       String fileName = DateUtil.dateStr(new Date(), "yyyyMMddHHmm");
/* 278 */       String path_ = basepath + "/" + fileName;
/*     */       
/* 280 */       fw = new FileWriter(path_ + ".txt");
/* 281 */       bw = new BufferedWriter(fw);
/* 282 */       String content = "";
/* 283 */       String s = "配置正常";
/* 284 */       List<Map<String, Object>> dataList = new ArrayList();
/* 285 */       SysConfig configBorrowDay = new SysConfig();
/* 286 */       SysConfig configFee = new SysConfig();
/* 287 */       SysConfig configPenaltyFee = new SysConfig();
/* 288 */       for (SysConfig sysConfig : list) {
/* 289 */         Map<String, Object> mapDate = new HashMap();
/* 290 */         if (sysConfig.getValue().contains("xxxxx")) {
/* 291 */           s = "配置错误";
/* 292 */           content = appendContent(content, sysConfig);
/*     */         }
/* 294 */         if (sysConfig.getCode().equals("fee")) {
/* 295 */           configFee = sysConfig;
/* 296 */         } else if (sysConfig.getCode().equals("penalty_fee")) {
/* 297 */           configPenaltyFee = sysConfig;
/* 298 */         } else if (sysConfig.getCode().equals("borrow_day")) {
/* 299 */           configBorrowDay = sysConfig;
/*     */         }
/* 301 */         mapDate.put("code", sysConfig.getCode());
/* 302 */         mapDate.put("value", sysConfig.getValue());
/* 303 */         mapDate.put("status", s);
/* 304 */         dataList.add(mapDate);
/*     */       }
/*     */       
/* 307 */       Map<String, Object> penaltyFeeValueMap = new HashMap();
/* 308 */       Object feeValueMap = new HashMap();
/* 309 */       String[] borrowDayValue = configBorrowDay.getValue().split(",");
/* 310 */       String[] feeValue = configFee.getValue().split(",");
/* 311 */       String[] penaltyFeeValue = configPenaltyFee.getValue().split(",");
/* 312 */       penaltyFeeValueMap.put("code", "{" + configBorrowDay.getCode() + "}<==>{" + configPenaltyFee.getCode() + "}");
/* 313 */       penaltyFeeValueMap.put("value", "{" + configBorrowDay.getValue() + "}<==>{" + configPenaltyFee.getValue() + "}");
/* 314 */       if (borrowDayValue.length != penaltyFeeValue.length) {
/* 315 */         penaltyFeeValueMap.put("status", "借款天数与预期利率不匹配");
/*     */       } else {
/* 317 */         penaltyFeeValueMap.put("status", "借款天数与预期利率配置正常");
/*     */       }
/* 319 */       ((Map)feeValueMap).put("code", "{" + configBorrowDay.getCode() + "}<==>{" + configFee.getCode() + "}");
/* 320 */       ((Map)feeValueMap).put("value", "{" + configBorrowDay.getValue() + "}<==>{" + configFee.getValue() + "}");
/* 321 */       if (borrowDayValue.length != feeValue.length) {
/* 322 */         ((Map)feeValueMap).put("status", "借款天数与综合费用不匹配");
/*     */       } else {
/* 324 */         ((Map)feeValueMap).put("status", "借款天数与综合费用配置正常");
/*     */       }
/* 326 */       dataList.add(penaltyFeeValueMap);
/* 327 */       dataList.add(feeValueMap);
/* 328 */       Map<String, Object> toMap = new HashMap();
/* 329 */       ObjectMapper mapper = new ObjectMapper();
/* 330 */       String types = PropertiesUtil.getValue("types");
/* 331 */       String[] codes = types.split(",");
/* 332 */       String[] arrayOfString1; int j = (arrayOfString1 = codes).length; for (int i = 0; i < j; i++) { String code = arrayOfString1[i];
/* 333 */         String figValue = "";
/* 334 */         String figCode = "";
/* 335 */         SysConfig configs = this.sysConfigService.findByCode(code);
/* 336 */         String codevalue = "";
/* 337 */         if (configs != null) {
/* 338 */           codevalue = configs.getValue();
/*     */         }
/* 340 */         String sysConfigMap = PropertiesUtil.getValue(code + "_" + codevalue);
/* 341 */         toMap = (Map)mapper.readValue(sysConfigMap, new TypeReference() {});
/* 342 */         Map<String, Object> mapDate = new HashMap();
/* 343 */         int status = 0;
/* 344 */         String codeAppen = "";
/* 345 */         for (Map.Entry<String, Object> entry : toMap.entrySet()) {
/* 346 */           SysConfig sc = this.sysConfigService.findByCode((String)entry.getKey());
/* 347 */           if (sc == null) {
/* 348 */             TppBusiness tppBusiness = (TppBusiness)this.tppBusinessService.getById(Long.valueOf(StringUtil.toLong((String)entry.getKey())));
/* 349 */             if (tppBusiness == null) {
/*     */               continue;
/*     */             }
/* 352 */             figValue = tppBusiness.getUrl();
/* 353 */             figCode = tppBusiness.getId().toString();
/*     */           } else {
/* 355 */             figValue = sc.getValue();
/* 356 */             figCode = sc.getCode();
/*     */           }
/* 358 */           if (!entry.getValue().toString().contains(figValue)) {
/* 359 */             status++;
/* 360 */             content = 
/* 361 */               content + DateUtil.dateStr(new Date()) + "【" + code + "】                code:" + (String)entry.getKey() + "       value:" + figValue + "\r\n";
/*     */           }
/* 363 */           codeAppen = codeAppen + "{code:" + figCode + "     value:" + figValue + "},  ";
/*     */         }
/* 365 */         if (status > 0) {
/* 366 */           mapDate.put("status", "配置错误");
/* 367 */           mapDate.put("code", code);
/* 368 */           mapDate.put("value", codeAppen);
/* 369 */           dataList.add(mapDate);
/*     */         }
/*     */       }
/* 372 */       bw.write(content);
/* 373 */       bw.newLine();
/* 374 */       bw.flush();
/* 375 */       fr = new FileReader(path_ + ".txt");
/* 376 */       br = new BufferedReader(fr);
/* 377 */       String line = br.readLine();
/* 378 */       while (line != null) {
/* 379 */         System.out.print(line);
/* 380 */         line = br.readLine();
/*     */       }
/* 382 */       fr.close();
/* 383 */       fw.close();
/* 384 */       br.close();
/* 385 */       returnMap.put("code", Integer.valueOf(200));
/* 386 */       returnMap.put("msg", "操作成功");
/* 387 */       returnMap.put("data", dataList);
/* 388 */       ServletUtils.writeToResponse(response, returnMap);
/*     */     } catch (Exception e) {
/* 390 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public String appendContent(String content, SysConfig sysConfig)
/*     */   {
/* 396 */     String status = sysConfig.getStatus().intValue() == 1 ? "启用" : "关闭";
/* 397 */     return content = content + DateUtil.dateStr(new Date()) + ": <" + 
/* 398 */       sysConfig.getName() + ">" + "配置详情：" + "    id:" + 
/* 399 */       sysConfig.getId() + "    type:" + sysConfig.getType() + 
/* 400 */       "    code:" + sysConfig.getCode() + "    value:" + 
/* 401 */       sysConfig.getValue() + "     状态:" + status + "\r\n";
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SysConfigController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */