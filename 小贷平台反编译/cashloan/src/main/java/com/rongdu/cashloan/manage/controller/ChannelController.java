/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */

import com.github.pagehelper.Page;
import com.rongdu.cashloan.cl.domain.Channel;
import com.rongdu.cashloan.cl.model.ChannelBorrowModel;
import com.rongdu.cashloan.cl.model.ChannelListModel;
import com.rongdu.cashloan.cl.service.ChannelService;
import com.rongdu.cashloan.cl.service.UrgeRepayOrderService;
import com.rongdu.cashloan.core.common.util.JsonUtil;
import com.rongdu.cashloan.core.common.util.RdPage;
import com.rongdu.cashloan.core.common.util.ServletUtils;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ChannelController
/*     */   extends ManageBaseController
/*     */ {
/*     */   @Resource
/*     */   private ChannelService channelService;
/*     */   @Resource
/*     */   private UrgeRepayOrderService urgeRepayOrderService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/promotion/channel/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void save(HttpServletRequest request, HttpServletResponse response, @RequestParam("code") String code, @RequestParam("name") String name, @RequestParam(value="params", required=false) String params)
/*     */     throws Exception
/*     */   {
/*  69 */     SysUser userinfo = getLoginUser(request);
/*  70 */     Map<String, Object> param = (Map)JsonUtil.parse(params, Map.class);
/*  71 */     Map<String, Object> result = this.channelService.save(param, userinfo.getName(), code, name);
/*  72 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/promotion/channel/listChannel.htm"})
/*     */   public void listChannel(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  86 */     Map<String, Object> result = new HashMap();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */     SysUser userinfo = getLoginUser(this.request);
/*     */     
/*  94 */     Map<String, Object> searchMap = new HashMap();
/*  95 */     if (!StringUtils.isEmpty(searchParams)) {
/*  96 */       searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/*  98 */     if (userinfo != null) {
/*  99 */       searchMap.put("parentCode", "-1");
/*     */     } else {
/* 101 */       Object parentCode = this.session.getAttribute("channelCode");
/* 102 */       if (parentCode != null) {
/* 103 */         searchMap.put("parentCode", parentCode);
/*     */       } else {
/* 105 */         result.put("code", Integer.valueOf(200));
/* 106 */         result.put("msg", "查询成功");
/* 107 */         ServletUtils.writeToResponse(this.response, result);
/* 108 */         return;
/*     */       }
/*     */     }
/*     */     
/* 112 */     Page<Channel> page = this.channelService.listChannel1(current, pageSize, searchMap);
/* 113 */     result.put("data", page);
/* 114 */     result.put("page", new RdPage(page));
/* 115 */     result.put("code", Integer.valueOf(200));
/* 116 */     result.put("msg", "查询成功");
/* 117 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/modules/manage/promotion/channel/listChannelMap.htm"})
/*     */   public void listChannelMap() throws Exception {
/* 122 */     Map<String, Object> result = new HashMap();
/* 123 */     List<Channel> page = this.channelService.listChannel();
/* 124 */     result.put("data", page);
/* 125 */     result.put("code", Integer.valueOf(200));
/* 126 */     result.put("msg", "查询成功");
/* 127 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/promotion/channel/page.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void page(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 145 */     Map<String, Object> searchMap = new HashMap();
/* 146 */     if (!StringUtils.isEmpty(searchParams)) {
/* 147 */       searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/* 149 */     Page<ChannelListModel> page = this.channelService.page(current, pageSize, searchMap);
/* 150 */     Map<String, Object> result = new HashMap();
/* 151 */     result.put("data", page);
/* 152 */     result.put("page", new RdPage(page));
/* 153 */     result.put("code", Integer.valueOf(200));
/* 154 */     result.put("msg", "查询成功");
/* 155 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/promotion/channel/update.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void update(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Long id, @RequestParam(value="params", required=false) String params)
/*     */     throws Exception
/*     */   {
/* 175 */     Map<String, Object> param = (Map)JsonUtil.parse(params, Map.class);
/*     */     
/* 177 */     Map<String, Object> result = new HashMap();
/*     */     
/* 179 */     SysUser userinfo = getLoginUser(request);
/* 180 */     String value = "";
/* 181 */     if ((userinfo == null) && (this.session.getAttribute("channelCode") == null)) {
/* 182 */       result.put("code", "操作失败");
/* 183 */       result.put("msg", "用户未登录");
/* 184 */       ServletUtils.writeToResponse(response, result);
/* 185 */       return; }
/* 186 */     if (userinfo != null) {
/* 187 */       value = userinfo.getName();
/* 188 */     } else if ((userinfo == null) && (this.session.getAttribute("channelCode") != null)) {
/* 189 */       value = this.session.getAttribute("channelCode");
/*     */     }
/*     */     
/* 192 */     boolean flag = this.channelService.update(id, value, param);
/*     */     
/* 194 */     if (flag) {
/* 195 */       result.put("code", Integer.valueOf(200));
/* 196 */       result.put("msg", "操作成功");
/*     */     } else {
/* 198 */       result.put("code", Integer.valueOf(400));
/* 199 */       result.put("msg", "操作失败");
/*     */     }
/* 201 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channel/channelDetails.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void channelDetails(@RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/* 211 */     Channel channel = this.channelService.channelDetails(id);
/* 212 */     Map<String, Object> data = new HashMap();
/* 213 */     data.put("channel", channel);
/* 214 */     Map<String, Object> result = new HashMap();
/* 215 */     if (channel != null) {
/* 216 */       result.put("data", data);
/* 217 */       result.put("code", Integer.valueOf(200));
/* 218 */       result.put("msg", "操作成功");
/*     */     } else {
/* 220 */       result.put("code", Integer.valueOf(400));
/* 221 */       result.put("msg", "操作失败");
/*     */     }
/* 223 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channel/updateState.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void updateState(@RequestParam("id") Long id, @RequestParam("state") String state)
/*     */     throws Exception
/*     */   {
/* 233 */     Map<String, Object> paramMap = new HashMap();
/* 234 */     paramMap.put("id", id);
/* 235 */     paramMap.put("state", state);
/* 236 */     Map<String, Object> result = new HashMap();
/*     */     
/* 238 */     SysUser userinfo = getLoginUser(this.request);
/* 239 */     if ((userinfo == null) && (this.session.getAttribute("channelCode") == null)) {
/* 240 */       result.put("code", "操作失败");
/* 241 */       result.put("msg", "用户未登录");
/* 242 */       ServletUtils.writeToResponse(this.response, result);
/* 243 */       return;
/*     */     }
/* 245 */     boolean flag = this.channelService.updateState(paramMap);
/* 246 */     if (flag) {
/* 247 */       result.put("code", Integer.valueOf(200));
/* 248 */       result.put("msg", "操作成功");
/*     */     } else {
/* 250 */       result.put("code", Integer.valueOf(400));
/* 251 */       result.put("msg", "渠道未结算，不可禁用");
/*     */     }
/* 253 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channel/channelIsDelete.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void channelIsDelete(@RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/* 262 */     Map<String, Object> paramMap = new HashMap();
/* 263 */     paramMap.put("id", id);
/* 264 */     paramMap.put("isDelete", Integer.valueOf(10));
/* 265 */     Map<String, Object> result = new HashMap();
/*     */     
/* 267 */     SysUser userinfo = getLoginUser(this.request);
/* 268 */     if ((userinfo == null) && (this.session.getAttribute("channelCode") == null)) {
/* 269 */       result.put("code", "操作失败");
/* 270 */       result.put("msg", "用户未登录");
/* 271 */       ServletUtils.writeToResponse(this.response, result);
/* 272 */       return;
/*     */     }
/* 274 */     boolean flag = this.channelService.updateState(paramMap);
/* 275 */     if (flag) {
/* 276 */       result.put("code", Integer.valueOf(200));
/* 277 */       result.put("msg", "操作成功");
/*     */     } else {
/* 279 */       result.put("code", Integer.valueOf(400));
/* 280 */       result.put("msg", "渠道未结算，不可禁用");
/*     */     }
/* 282 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/promotion/channel/statisticsCpa.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void statisticsCpa(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/* 324 */     Map<String, Object> result = new HashMap();
/* 325 */     String parentCode = null;
/*     */     
/* 327 */     SysUser userinfo = getLoginUser(this.request);
/* 328 */     if ((userinfo == null) && (this.session.getAttribute("channelCode") == null)) {
/* 329 */       result.put("code", "操作失败");
/* 330 */       result.put("msg", "用户未登录");
/* 331 */       ServletUtils.writeToResponse(this.response, result);
/* 332 */       return;
/*     */     }
/*     */     
/* 335 */     if (userinfo != null) {
/* 336 */       parentCode = "-1";
/* 337 */     } else if (this.session.getAttribute("channelCode") != null) {
/* 338 */       parentCode = this.session.getAttribute("channelCode");
/*     */     }
/*     */     
/* 341 */     Map<String, Object> searchMap = new HashMap();
/* 342 */     if (!StringUtils.isEmpty(searchParams)) {
/* 343 */       searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/*     */     
/* 346 */     if (StringUtils.isEmpty(parentCode)) {
/* 347 */       parentCode = "-1";
/*     */     }
/* 349 */     searchMap.put("parentCode", parentCode);
/* 350 */     Page<Map<String, Object>> page = (Page)this.channelService.statisticsCpa(searchMap, current, pageSize);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 356 */     result.put("data", page);
/* 357 */     result.put("page", new RdPage(page));
/* 358 */     result.put("code", Integer.valueOf(200));
/* 359 */     result.put("msg", "查询成功");
/* 360 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/promotion/channel/statisticsMySelfCpa.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void statisticsMySelfCpa(@RequestParam(value="searchParams", required=false) String searchParams) throws Exception
/*     */   {
/* 366 */     Map<String, Object> searchMap = new HashMap();
/* 367 */     Map<String, Object> result = new HashMap();
/* 368 */     if (!StringUtils.isEmpty(searchParams)) {
/* 369 */       searchMap = (Map)JsonUtil.parse(searchParams, Map.class);
/*     */     }
/*     */     
/* 372 */     SysUser userinfo = getLoginUser(this.request);
/* 373 */     if ((userinfo == null) && (this.session.getAttribute("channelCode") == null)) {
/* 374 */       result.put("code", "操作失败");
/* 375 */       result.put("msg", "用户未登录");
/* 376 */       ServletUtils.writeToResponse(this.response, result);
/* 377 */       return;
/*     */     }
/*     */     
/* 380 */     if (this.session.getAttribute("channelCode") != null) {
/* 381 */       searchMap.put("code", this.session.getAttribute("channelCode"));
/*     */     } else {
/* 383 */       result.put("code", "操作失败");
/* 384 */       result.put("msg", "用户未登录");
/* 385 */       ServletUtils.writeToResponse(this.response, result);
/* 386 */       return;
/*     */     }
/*     */     
/* 389 */     Map data = this.channelService.statisticsMySelfCpa(searchMap);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 394 */     List list = new ArrayList();
/* 395 */     list.add(data);
/* 396 */     result.put("data", list);
/*     */     
/* 398 */     result.put("code", Integer.valueOf(200));
/* 399 */     result.put("msg", "查询成功");
/* 400 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/channel/borrowRepayList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:channel:borrowRepayList", name="渠道借款订单列表 ")
/*     */   public void borrowRepayList(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 413 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 414 */     Page<ChannelBorrowModel> page = this.channelService.listBorrowModel(params, current, pageSize);
/* 415 */     Map<String, Object> result = new HashMap();
/* 416 */     result.put("data", page);
/* 417 */     result.put("page", new RdPage(page));
/* 418 */     result.put("code", Integer.valueOf(200));
/* 419 */     result.put("msg", "获取成功");
/* 420 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ChannelController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */