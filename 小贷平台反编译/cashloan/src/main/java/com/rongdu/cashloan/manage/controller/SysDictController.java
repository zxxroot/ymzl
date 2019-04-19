/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.core.common.web.controller.BaseController;
/*     */ import com.rongdu.cashloan.system.domain.SysDict;
/*     */ import com.rongdu.cashloan.system.domain.SysDictDetail;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import com.rongdu.cashloan.system.service.SysDictDetailService;
/*     */ import com.rongdu.cashloan.system.service.SysDictService;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
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
/*     */ public class SysDictController
/*     */   extends BaseController
/*     */ {
/*     */   @Resource
/*     */   private SysDictService sysDictService;
/*     */   @Resource
/*     */   private SysDictDetailService sysDictDetailService;
/*     */   
/*     */   @RequestMapping({"/modules/manage/system/dict/page.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:page", name=" 获取字典列表")
/*     */   public void listDicts(HttpServletResponse response, HttpServletRequest request, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize, @RequestParam(value="search", required=false) String search)
/*     */     throws Exception
/*     */   {
/*  72 */     Map<String, Object> searchMap = new HashMap();
/*  73 */     if (search != null) {
/*  74 */       searchMap = (Map)JsonUtil.parse(search, Map.class);
/*     */     }
/*  76 */     Page<SysDict> page = this.sysDictService.getDictPageList(current, pageSize, searchMap);
/*     */     
/*  78 */     Map<String, Object> result = new HashMap();
/*  79 */     result.put("data", page);
/*  80 */     result.put("page", new RdPage(page));
/*  81 */     result.put("code", Integer.valueOf(200));
/*  82 */     result.put("msg", "获取成功");
/*  83 */     ServletUtils.writeToResponse(response, result);
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
/*     */   @RequestMapping({"/modules/manage/system/dict/findByTypeCode.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:findByTypeCode", name="获取字典详情列表")
/*     */   public void findByTypeCode(@RequestParam("current") int current, @RequestParam("pageSize") int pageSize, @RequestParam("code") String code)
/*     */     throws Exception
/*     */   {
/*  99 */     SysDict dict = this.sysDictService.findByTypeCode(code);
/* 100 */     Map<String, Object> result = new HashMap();
/* 101 */     Map<String, Object> data = new HashMap();
/* 102 */     if (StringUtil.isNotBlank(dict)) {
/* 103 */       data.put("parentId", dict.getId());
/* 104 */       Page<SysDictDetail> page = this.sysDictDetailService.getDictDetailList(current, pageSize, data);
/* 105 */       result.put("data", page);
/* 106 */       result.put("page", new RdPage(page));
/* 107 */       result.put("code", Integer.valueOf(200));
/* 108 */       result.put("msg", "获取成功");
/*     */     } else {
/* 110 */       result.put("code", Integer.valueOf(400));
/* 111 */       result.put("msg", "获取失败");
/*     */     }
/* 113 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/dict/listByTypeCode.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:listByTypeCode", name="获取字典列表")
/*     */   public void listByTypeCode(@RequestParam("code") String code)
/*     */     throws Exception
/*     */   {
/* 127 */     Map<String, Object> result = new HashMap();
/* 128 */     Map<String, Object> data = new HashMap();
/* 129 */     if (StringUtil.isNotBlank(code)) {
/* 130 */       data.put("typeCode", code);
/* 131 */       List<SysDictDetail> list = this.sysDictDetailService.listByTypeCode(data);
/* 132 */       result.put("data", list);
/* 133 */       result.put("code", Integer.valueOf(200));
/* 134 */       result.put("msg", "获取成功");
/*     */     } else {
/* 136 */       result.put("code", Integer.valueOf(400));
/* 137 */       result.put("msg", "获取失败");
/*     */     }
/* 139 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/dict/listUpdateCode.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:listUpdateCode", name="修改时获取未使用字典列表")
/*     */   public void listUpdateCode(@RequestParam("code") String code, @RequestParam("id") long id)
/*     */     throws Exception
/*     */   {
/* 154 */     SysDict dict = this.sysDictService.findByTypeCode(code);
/* 155 */     Map<String, Object> result = new HashMap();
/* 156 */     Map<String, Object> data = new HashMap();
/* 157 */     if (StringUtil.isNotBlank(dict)) {
/* 158 */       data.put("parentId", dict.getId());
/* 159 */       data.put("id", Long.valueOf(id));
/* 160 */       List<SysDictDetail> list = this.sysDictDetailService.listUpdateCode(data);
/* 161 */       result.put("data", list);
/* 162 */       result.put("code", Integer.valueOf(200));
/* 163 */       result.put("msg", "获取成功");
/*     */     } else {
/* 165 */       result.put("code", Integer.valueOf(400));
/* 166 */       result.put("msg", "获取失败");
/*     */     }
/* 168 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping({"/modules/manage/system/dict/detail/find.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:detail:find", name="字典详情")
/*     */   public void findDictDetail(HttpServletResponse response, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize, @RequestParam(value="id", required=false) String id)
/*     */     throws Exception
/*     */   {
/* 190 */     Map<String, Object> data = new HashMap();
/* 191 */     Map<String, Object> result = new HashMap();
/* 192 */     if (id != null) {
/* 193 */       data.put("parentId", id);
/* 194 */       Page<SysDictDetail> page = this.sysDictDetailService.getDictDetailList(current, pageSize, data);
/* 195 */       result.put("data", page);
/* 196 */       result.put("page", new RdPage(page));
/* 197 */       result.put("code", Integer.valueOf(200));
/* 198 */       result.put("msg", "获取成功");
/*     */     } else {
/* 200 */       result.put("code", Integer.valueOf(400));
/* 201 */       result.put("msg", "获取失败");
/*     */     }
/*     */     
/* 204 */     ServletUtils.writeToResponse(response, result);
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
/*     */   @RequestMapping({"/modules/manage/system/dict/save.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:save", name="新增修改字典")
/*     */   public void saveOrUpdateDict(HttpServletResponse response, @RequestParam(value="form", required=false) String form, @RequestParam(value="status", required=false) String status)
/*     */     throws Exception
/*     */   {
/* 225 */     SysDict sysDict = (SysDict)JsonUtil.parse(form, SysDict.class);
/* 226 */     Map<String, Object> res = new HashMap();
/*     */     
/* 228 */     boolean backstauts = this.sysDictService.addOrModify(sysDict, status);
/* 229 */     if (backstauts) {
/* 230 */       res.put("code", Integer.valueOf(200));
/* 231 */       if ("create".equals(status)) {
/* 232 */         res.put("msg", "插入成功");
/*     */       } else {
/* 234 */         res.put("msg", "更新成功");
/*     */       }
/*     */     }
/* 237 */     ServletUtils.writeToResponse(response, res);
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
/*     */   @RequestMapping({"/modules/manage/system/dict/detail/save.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:detail:save", name="新增修改字典详情")
/*     */   public void saveOrUpdateDictDetail(HttpServletResponse response, @RequestParam(value="form", required=false) String data, @RequestParam(value="status", required=false) String status)
/*     */     throws Exception
/*     */   {
/* 254 */     SysDictDetail dictDetail = (SysDictDetail)JsonUtil.parse(data, SysDictDetail.class);
/* 255 */     Map<String, Object> res = new HashMap();
/*     */     
/* 257 */     this.sysDictDetailService.addOrModify(dictDetail, status);
/*     */     
/* 259 */     res.put("code", Integer.valueOf(200));
/* 260 */     if ("create".equals(status)) {
/* 261 */       res.put("msg", "插入成功");
/*     */     } else {
/* 263 */       res.put("msg", "更新成功");
/*     */     }
/* 265 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/dict/delete.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:delete", name="删除字典")
/*     */   public void deleteDict(HttpServletResponse response, @RequestParam("id") String id)
/*     */     throws ServiceException
/*     */   {
/* 279 */     Map<String, Object> req = new HashMap();
/*     */     
/* 281 */     Map<String, Object> res = new HashMap();
/*     */     
/* 283 */     if (id != null) {
/* 284 */       req.put("parentId", id);
/*     */     } else {
/* 286 */       return;
/*     */     }
/* 288 */     if (this.sysDictDetailService.getItemCountMap(req).longValue() > 0L)
/*     */     {
/* 290 */       res.put("code", Integer.valueOf(200));
/* 291 */       res.put("msg", "有字典子项，删除失败,请先删除子项");
/*     */     } else {
/* 293 */       this.sysDictService.deleteDict(Long.valueOf(id));
/* 294 */       res.put("code", Integer.valueOf(200));
/* 295 */       res.put("msg", "删除成功");
/*     */     }
/*     */     
/* 298 */     ServletUtils.writeToResponse(response, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/dict/detail/delete.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:detail:delete", name="删除字典详情")
/*     */   public void deleteDictDetail(HttpServletResponse response, @RequestParam("id") String id)
/*     */     throws Exception
/*     */   {
/* 313 */     Map<String, Object> res = new HashMap();
/*     */     
/* 315 */     if (id != null) {
/* 316 */       this.sysDictDetailService.deleteSysDictDetail(Long.valueOf(id));
/* 317 */       res.put("code", Integer.valueOf(200));
/* 318 */       res.put("msg", "删除成功");
/*     */     }
/* 320 */     ServletUtils.writeToResponse(response, res);
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
/*     */   @RequestMapping({"/modules/manage/system/dict/cache/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:cache:list", name="缓存字典使用")
/*     */   public void listCache(HttpServletResponse response, @RequestParam("type") String type)
/*     */     throws Exception
/*     */   {
/* 336 */     List<Map<String, Object>> dicList = null;
/* 337 */     Map<String, Object> res = new HashMap();
/* 338 */     if (type != null) {
/* 339 */       dicList = this.sysDictService.getDictsCache(type);
/*     */     }
/* 341 */     if (dicList != null) {
/* 342 */       res.put("data", dicList);
/* 343 */       res.put("code", Integer.valueOf(200));
/* 344 */       res.put("msg", "获取成功");
/*     */     } else {
/* 346 */       res.put("code", Integer.valueOf(400));
/* 347 */       res.put("msg", "获取失败");
/*     */     }
/* 349 */     ServletUtils.writeToResponse(response, res);
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
/*     */   @RequestMapping({"/modules/manage/system/dict/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:list", name="查询所有字典")
/*     */   public void listAll(HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 368 */     List<Map<String, Object>> list = this.sysDictDetailService.queryAllDic();
/*     */     
/* 370 */     Map<String, Object> rec = new LinkedHashMap();
/* 371 */     for (Map<String, Object> o : list) {
/* 372 */       Map dic = (Map)rec.get(o.get("itemCode"));
/* 373 */       if (dic == null) {
/* 374 */         dic = new LinkedHashMap();
/* 375 */         rec.put(o.get("itemCode").toString(), dic);
/*     */       }
/* 377 */       dic.put(o.get("itemCode"), o.get("itemValue"));
/*     */     }
/* 379 */     Map<String, Object> result = new HashMap();
/* 380 */     result.put("code", Integer.valueOf(200));
/* 381 */     result.put("data", rec);
/* 382 */     ServletUtils.writeToResponse(response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/system/dict/findAllByName.htm"})
/*     */   @RequiresPermission(code="modules:manage:system:dict:findAllByName", name="根据名称查询字典数据")
/*     */   public void findAllByName(@RequestParam("name") String name)
/*     */   {
/* 392 */     List<Map<String, Object>> list = this.sysDictDetailService.queryAllDicByParentName(name);
/* 393 */     Map<String, Object> result = new HashMap();
/* 394 */     result.put("code", Integer.valueOf(200));
/* 395 */     result.put("data", list);
/* 396 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\SysDictController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */