/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.rongdu.cashloan.cl.domain.Channel;
/*     */ import com.rongdu.cashloan.cl.domain.ChannelApp;
/*     */ import com.rongdu.cashloan.cl.model.ChannelAppModel;
/*     */ import com.rongdu.cashloan.cl.service.ChannelAppService;
/*     */ import com.rongdu.cashloan.cl.service.ChannelService;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class ManageChannelAppController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private ChannelAppService channelAppService;
/*     */   @Resource
/*     */   private ChannelService channelService;
/*     */   
/*     */   @RequestMapping(value={"/modules/manage/channelApp/list.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void listchannelApp()
/*     */   {
/*  51 */     List<ChannelAppModel> list = this.channelAppService.listChannelAppModel();
/*  52 */     Map<String, Object> result = new HashMap();
/*  53 */     result.put("code", Integer.valueOf(200));
/*  54 */     result.put("data", list);
/*  55 */     result.put("msg", "获取成功");
/*  56 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/channelApp/save.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void save(@RequestParam("channelId") long channelId, @RequestParam("appType") String appType, @RequestParam(value="latestVersion", required=false) String latestVersion, @RequestParam(value="minVersion", required=false) String minVersion, @RequestParam(value="downloadUrl", required=false) String downloadUrl)
/*     */   {
/*  68 */     ChannelApp channelApp = new ChannelApp();
/*  69 */     channelApp.setChannelId(Long.valueOf(channelId));
/*  70 */     channelApp.setAppType(appType);
/*  71 */     channelApp.setlatestVersion(latestVersion);
/*  72 */     channelApp.setMinVersion(minVersion);
/*  73 */     channelApp.setDownloadUrl(downloadUrl);
/*  74 */     channelApp.setState("10");
/*  75 */     int msg = this.channelAppService.save(channelApp);
/*  76 */     Map<String, Object> result = new HashMap();
/*  77 */     if (msg > 0) {
/*  78 */       result.put("code", Integer.valueOf(200));
/*  79 */       result.put("msg", "添加成功");
/*     */     } else {
/*  81 */       result.put("code", Integer.valueOf(400));
/*  82 */       result.put("msg", "添加失败");
/*     */     }
/*  84 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/channelApp/update.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void update(@RequestParam("id") long id, @RequestParam(value="appType", required=false) String appType, @RequestParam(value="latestVersion", required=false) String latestVersion, @RequestParam(value="minVersion", required=false) String minVersion, @RequestParam(value="downloadUrl", required=false) String downloadUrl)
/*     */   {
/*  96 */     Map<String, Object> paramMap = new HashMap();
/*  97 */     paramMap.put("id", Long.valueOf(id));
/*  98 */     paramMap.put("appType", appType);
/*  99 */     paramMap.put("latestVersion", latestVersion);
/* 100 */     paramMap.put("minVersion", minVersion);
/* 101 */     paramMap.put("downloadUrl", downloadUrl);
/* 102 */     int msg = this.channelAppService.updateSelective(paramMap);
/* 103 */     Map<String, Object> result = new HashMap();
/* 104 */     if (msg > 0) {
/* 105 */       result.put("code", Integer.valueOf(200));
/* 106 */       result.put("msg", "更新成功");
/*     */     } else {
/* 108 */       result.put("code", Integer.valueOf(400));
/* 109 */       result.put("msg", "更新失败");
/*     */     }
/* 111 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/channelApp/enable.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void enable(@RequestParam("id") long id)
/*     */   {
/* 120 */     Map<String, Object> result = new HashMap();
/* 121 */     Map<String, Object> paramMap = new HashMap();
/* 122 */     paramMap.put("id", Long.valueOf(id));
/* 123 */     paramMap.put("state", "10");
/* 124 */     int msg = this.channelAppService.updateSelective(paramMap);
/* 125 */     if (msg > 0) {
/* 126 */       result.put("code", Integer.valueOf(200));
/* 127 */       result.put("msg", "启用成功");
/*     */     } else {
/* 129 */       result.put("code", Integer.valueOf(400));
/* 130 */       result.put("msg", "启用失败");
/*     */     }
/* 132 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/channelApp/disable.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void disable(@RequestParam("id") long id)
/*     */   {
/* 142 */     Map<String, Object> result = new HashMap();
/* 143 */     Map<String, Object> paramMap = new HashMap();
/* 144 */     paramMap.put("id", Long.valueOf(id));
/* 145 */     paramMap.put("state", "20");
/* 146 */     int msg = this.channelAppService.updateSelective(paramMap);
/* 147 */     if (msg > 0) {
/* 148 */       result.put("code", Integer.valueOf(200));
/* 149 */       result.put("msg", "禁用成功");
/*     */     } else {
/* 151 */       result.put("code", Integer.valueOf(400));
/* 152 */       result.put("msg", "禁用失败");
/*     */     }
/* 154 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/channelApp/channelNamelist.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void listChannelName()
/*     */   {
/* 162 */     List<Channel> list = this.channelService.listChannelWithoutApp();
/* 163 */     Map<String, Object> result = new HashMap();
/* 164 */     result.put("code", Integer.valueOf(200));
/* 165 */     result.put("data", list);
/* 166 */     result.put("msg", "获取成功");
/* 167 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageChannelAppController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */