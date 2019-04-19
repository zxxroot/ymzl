/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.manage.domain.QuartzInfo;
/*     */ import com.rongdu.cashloan.manage.model.QuartzInfoModel;
/*     */ import com.rongdu.cashloan.manage.model.QuartzManager;
/*     */ import com.rongdu.cashloan.manage.service.QuartzInfoService;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.util.StringUtils;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import tool.util.DateUtil;
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
/*     */ @Scope("prototype")
/*     */ @Controller
/*     */ public class QuartzInfoController
/*     */   extends BaseController
/*     */ {
/*  45 */   private static final Logger logger = Logger.getLogger(QuartzInfoController.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private QuartzInfoService quartzInfoService;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/quartz/page.htm"})
/*     */   public void page(@RequestParam("search") String search, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize)
/*     */     throws Exception
/*     */   {
/*  64 */     Map<String, Object> searchMap = new HashMap();
/*  65 */     if (!StringUtils.isEmpty(search)) {
/*  66 */       searchMap = (Map)JsonUtil.parse(search, Map.class);
/*     */     }
/*     */     
/*  69 */     Page<QuartzInfoModel> page = this.quartzInfoService.page(searchMap, current, pageSize);
/*  70 */     Map<String, Object> result = new HashMap();
/*  71 */     result.put("data", page);
/*  72 */     result.put("page", new RdPage(page));
/*  73 */     result.put("code", Integer.valueOf(200));
/*  74 */     result.put("msg", "查询成功");
/*  75 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/quartz/addition.htm"})
/*     */   public void addition(@RequestParam("name") String name, @RequestParam("code") String code, @RequestParam("cycle") String cycle, @RequestParam("className") String className)
/*     */     throws Exception
/*     */   {
/*  91 */     Map<String, Object> paramMap = new HashMap();
/*  92 */     paramMap.put("code", code);
/*  93 */     QuartzInfo qzInfo = this.quartzInfoService.findSelective(paramMap);
/*     */     
/*  95 */     boolean flag = false;
/*  96 */     Map<String, Object> data = new HashMap();
/*  97 */     if (qzInfo == null) {
/*  98 */       qzInfo = new QuartzInfo();
/*  99 */       qzInfo.setName(name);
/* 100 */       qzInfo.setCode(code);
/* 101 */       qzInfo.setCycle(cycle);
/* 102 */       qzInfo.setClassName(className);
/* 103 */       qzInfo.setSucceed(Integer.valueOf(0));
/* 104 */       qzInfo.setFail(Integer.valueOf(0));
/* 105 */       qzInfo.setState("20");
/* 106 */       qzInfo.setCreateTime(DateUtil.getNow());
/* 107 */       flag = this.quartzInfoService.save(qzInfo);
/*     */     } else {
/* 109 */       data.put("message", "任务已存在,请勿重复添加");
/*     */     }
/*     */     
/* 112 */     Map<String, Object> result = new HashMap();
/* 113 */     if (flag) {
/* 114 */       result.put("code", Integer.valueOf(200));
/* 115 */       result.put("msg", "操作成功");
/*     */     } else {
/* 117 */       result.put("data", data);
/* 118 */       result.put("code", Integer.valueOf(400));
/* 119 */       result.put("msg", "操作失败");
/*     */     }
/* 121 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/quartz/execute.htm"})
/*     */   public void execute(@RequestParam("id") Long id)
/*     */   {
/* 132 */     logger.info("【启动任务】开始...");
/*     */     
/* 134 */     boolean flag = true;
/* 135 */     Object cl = null;
/*     */     
/* 137 */     QuartzInfo quartzInfo = (QuartzInfo)this.quartzInfoService.getById(id);
/* 138 */     if ((quartzInfo == null) || (StringUtil.isBlank(quartzInfo.getClassName()))) {
/* 139 */       flag = false;
/*     */     }
/*     */     
/*     */ 
/* 143 */     if (flag) {
/*     */       try {
/* 145 */         cl = Class.forName(quartzInfo.getClassName()).newInstance();
/*     */       }
/*     */       catch (InstantiationException|IllegalAccessException|ClassNotFoundException e) {
/* 148 */         logger.info("定时任务启动异常...", e);
/* 149 */         flag = false;
/*     */       }
/*     */     }
/*     */     
/* 153 */     if (flag)
/*     */     {
/* 155 */       QuartzManager.addJob(quartzInfo.getCode(), cl.getClass(), quartzInfo.getCycle());
/*     */       
/*     */ 
/* 158 */       Map<String, Object> data = new HashMap();
/* 159 */       data.put("id", quartzInfo.getId());
/* 160 */       data.put("state", "10");
/* 161 */       flag = this.quartzInfoService.update(data);
/*     */     }
/*     */     
/*     */ 
/* 165 */     Map<String, Object> result = new HashMap();
/* 166 */     if (flag) {
/* 167 */       result.put("code", Integer.valueOf(200));
/* 168 */       result.put("msg", "操作成功");
/*     */     } else {
/* 170 */       result.put("code", Integer.valueOf(400));
/* 171 */       result.put("msg", "操作失败");
/*     */     }
/* 173 */     logger.info("【启动任务】结束...");
/* 174 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/quartz/delete.htm"})
/*     */   public void delete(@RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/* 185 */     logger.info("【删除任务】开始...");
/*     */     
/* 187 */     QuartzInfo quartzInfo = (QuartzInfo)this.quartzInfoService.getById(id);
/* 188 */     if ((quartzInfo != null) && ("10".equals(quartzInfo.getState()))) {
/* 189 */       QuartzManager.removeJob(quartzInfo.getCode());
/*     */     }
/*     */     
/* 192 */     Map<String, Object> data = new HashMap();
/* 193 */     data.put("id", id);
/* 194 */     data.put("state", "20");
/* 195 */     boolean flag = this.quartzInfoService.update(data);
/*     */     
/* 197 */     Map<String, Object> result = new HashMap();
/* 198 */     if (flag) {
/* 199 */       result.put("code", Integer.valueOf(200));
/* 200 */       result.put("msg", "操作成功");
/*     */     } else {
/* 202 */       result.put("code", Integer.valueOf(400));
/* 203 */       result.put("msg", "操作失败");
/*     */     }
/* 205 */     logger.info("【删除任务】结束...");
/* 206 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/quartz/update.htm"})
/*     */   public void update(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("cycle") String cycle)
/*     */     throws Exception
/*     */   {
/* 219 */     logger.info("【修改任务】开始...");
/*     */     
/* 221 */     QuartzInfo quartzInfo = (QuartzInfo)this.quartzInfoService.getById(Long.valueOf(id));
/* 222 */     if ((quartzInfo != null) && ("10".equals(quartzInfo.getState()))) {
/* 223 */       QuartzManager.modifyJobTime(quartzInfo.getCode(), cycle);
/*     */     }
/*     */     
/* 226 */     Map<String, Object> data = new HashMap();
/* 227 */     data.put("id", Long.valueOf(id));
/* 228 */     data.put("name", name);
/* 229 */     data.put("cycle", cycle);
/* 230 */     boolean flag = this.quartzInfoService.update(data);
/* 231 */     Map<String, Object> result = new HashMap();
/* 232 */     if (flag) {
/* 233 */       result.put("code", Integer.valueOf(200));
/* 234 */       result.put("msg", "操作成功");
/*     */     } else {
/* 236 */       result.put("code", Integer.valueOf(400));
/* 237 */       result.put("msg", "操作失败");
/*     */     }
/* 239 */     logger.info("【修改任务】结束...");
/* 240 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/quartz/shutdownJobs.htm"})
/*     */   public void shutdownJobs()
/*     */     throws Exception
/*     */   {
/* 251 */     logger.info("【关闭所有任务】开始...");
/* 252 */     QuartzManager.shutdownJobs();
/* 253 */     logger.info("【关闭所有任务】结束...");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/quartz/runJobNow.htm"})
/*     */   public void runJobNow(@RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/* 265 */     logger.info("【执行】开始...");
/* 266 */     QuartzInfo quartzInfo = (QuartzInfo)this.quartzInfoService.getById(id);
/*     */     
/* 268 */     if ((quartzInfo == null) || ("20".equals(quartzInfo.getState()))) {
/* 269 */       Map<String, Object> result = new HashMap();
/* 270 */       result.put("code", Integer.valueOf(400));
/* 271 */       result.put("msg", "任务不存在或已停止");
/* 272 */       ServletUtils.writeToResponse(this.response, result);
/* 273 */       return;
/*     */     }
/*     */     
/* 276 */     QuartzManager.startJobNow(quartzInfo.getCode());
/* 277 */     Map<String, Object> result = new HashMap();
/* 278 */     result.put("code", Integer.valueOf(200));
/* 279 */     result.put("msg", "操作成功");
/* 280 */     logger.info("【执行任务】结束...");
/* 281 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\QuartzInfoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */