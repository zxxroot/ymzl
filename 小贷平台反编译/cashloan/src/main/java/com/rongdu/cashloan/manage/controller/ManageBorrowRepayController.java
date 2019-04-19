/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.domain.BorrowRepay;
/*     */ import com.rongdu.cashloan.cl.model.ManageBRepayModel;
/*     */ import com.rongdu.cashloan.cl.model.ManageBorrowModel;
/*     */ import com.rongdu.cashloan.cl.model.RepayExcelModel;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayLogService;
/*     */ import com.rongdu.cashloan.cl.service.BorrowRepayService;
/*     */ import com.rongdu.cashloan.core.common.exception.BussinessException;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.multipart.MultipartFile;
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
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @Scope("prototype")
/*     */ public class ManageBorrowRepayController
/*     */   extends ManageBaseController
/*     */ {
/*  64 */   private static final Logger logger = LoggerFactory.getLogger(ManageBorrowRepayController.class);
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private BorrowRepayService borrowRepayService;
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private BorrowRepayLogService borrowRepayLogService;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/modules/manage/borrow/repay/list.htm"})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:list", name="还款信息列表")
/*     */   public void list(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/*  83 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  84 */     Page<ManageBRepayModel> page = this.borrowRepayService.listModel(params, 
/*  85 */       currentPage, pageSize);
/*  86 */     Map<String, Object> result = new HashMap();
/*  87 */     result.put("data", page);
/*  88 */     result.put("page", new RdPage(page));
/*  89 */     result.put("code", Integer.valueOf(200));
/*  90 */     result.put("msg", "获取成功2");
/*  91 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/confirmRepay.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:confirmRepay", name="确认还款")
/*     */   public void confirmRepay(@RequestParam("id") Long id, @RequestParam(value="amount", required=false) String amount, @RequestParam(value="penaltyAmout", required=false) String penaltyAmout, @RequestParam("repayTime") String repayTime, @RequestParam("repayWay") String repayWay, @RequestParam("serialNumber") String serialNumber, @RequestParam("repayAccount") String repayAccount, @RequestParam("state") String state)
/*     */   {
/* 117 */     Map<String, Object> resultMap = new HashMap();
/* 118 */     Map<String, Object> result = new HashMap();
/*     */     try {
/* 120 */       Map<String, Object> param = new HashMap();
/* 121 */       param.put("id", id);
/* 122 */       param.put("repayTime", DateUtil.valueOf(repayTime, "yyyy-MM-dd HH:mm:ss"));
/* 123 */       param.put("repayWay", repayWay);
/* 124 */       param.put("repayAccount", repayAccount);
/* 125 */       param.put("amount", amount);
/* 126 */       param.put("serialNumber", serialNumber);
/* 127 */       param.put("penaltyAmout", penaltyAmout);
/* 128 */       param.put("state", state);
/* 129 */       BorrowRepay br = (BorrowRepay)this.borrowRepayService.getById(id);
/* 130 */       if (br != null) {
/* 131 */         if (!br.getState().equals("10")) {
/* 132 */           resultMap = this.borrowRepayService.confirmRepay(param);
/*     */         } else {
/* 134 */           resultMap.put("Code", Integer.valueOf(400));
/* 135 */           resultMap.put("Msg", "该还款计划已还款");
/*     */         }
/*     */       } else {
/* 138 */         resultMap.put("Code", Integer.valueOf(400));
/* 139 */         resultMap.put("Msg", "还款计划不存在");
/*     */       }
/*     */     } catch (Exception e) {
/* 142 */       logger.info(e.getMessage(), e);
/* 143 */       resultMap.put("Code", Integer.valueOf(400));
/* 144 */       resultMap.put("Msg", "还款失败");
/*     */     }
/* 146 */     result.put("code", resultMap.get("Code"));
/* 147 */     result.put("msg", resultMap.get("Msg"));
/* 148 */     ServletUtils.writeToResponse(this.response, result);
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
/*     */   @RequestMapping(value={"/modules/manage/borrow/repayList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @RequiresPermission(code="modules:manage:borrow:repayList.htm", name="催收管理列表")
/*     */   public void repayList(@RequestParam(value="searchParams", required=false) String searchParams, @RequestParam("current") int currentPage, @RequestParam("pageSize") int pageSize)
/*     */   {
/* 164 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/* 165 */     if (params == null) {
/* 166 */       params = new HashMap();
/* 167 */       List<String> stateList = Arrays.asList(new String[] { "50", 
/* 168 */         "90", "30" });
/* 169 */       params.put("stateList", stateList);
/* 170 */       params.put("state", "30");
/*     */     } else {
/* 172 */       String state = StringUtil.isNull(params.get("state"));
/* 173 */       if ((state == null) || (StringUtil.isBlank(state))) {
/* 174 */         List<String> stateList = Arrays.asList(new String[] { "50", 
/* 175 */           "90", "30" });
/* 176 */         params.put("stateList", stateList);
/* 177 */         params.put("state", "30");
/*     */       } else {
/* 179 */         List<String> stateList = Arrays.asList(new String[] { state });
/* 180 */         params.put("stateList", stateList);
/* 181 */         params.put("state", state);
/*     */       }
/*     */     }
/* 184 */     Page<ManageBorrowModel> page = this.borrowRepayService.listRepayModel(
/* 185 */       params, currentPage, pageSize);
/* 186 */     Map<String, Object> result = new HashMap();
/* 187 */     result.put("data", page);
/* 188 */     result.put("page", new RdPage(page));
/* 189 */     result.put("code", Integer.valueOf(200));
/* 190 */     result.put("msg", "获取成功");
/* 191 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/fileBatchRepay.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:fileBatchRepay", name="文件上传批量还款")
/*     */   public void fileBatchRepay(@RequestParam("repayFile") MultipartFile repayFile, @RequestParam("type") String type)
/*     */   {
/* 203 */     Map<String, Object> result = new HashMap();
/* 204 */     List<List<String>> list = new ArrayList();
/*     */     try {
/* 206 */       list = this.borrowRepayService.fileBatchRepay(repayFile, type);
/* 207 */       String title = "批量还款匹配结果";
/* 208 */       RepayExcelModel report = new RepayExcelModel();
/* 209 */       String fileName = report.saveExcelByList(list, title, repayFile.getOriginalFilename(), this.request);
/* 210 */       result.put("data", "/modules/manage/borrow/repay/downRepayByFile.htm?path=" + fileName);
/* 211 */       result.put("code", Integer.valueOf(200));
/* 212 */       result.put("msg", "获取成功");
/*     */     } catch (BussinessException e) {
/* 214 */       logger.error(e.getMessage(), e);
/* 215 */       result.put("code", Integer.valueOf(400));
/* 216 */       result.put("msg", e.getMessage());
/*     */     } catch (Exception e) {
/* 218 */       logger.error(e.getMessage(), e);
/* 219 */       result.put("code", Integer.valueOf(400));
/* 220 */       result.put("msg", "批量还款失败");
/*     */     }
/* 222 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/borrow/repay/downRepayByFile.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:borrow:repay:downRepayByFile", name="下载批量确认还款模板")
/*     */   public void fileBatchRepay(HttpServletRequest request, HttpServletResponse response, HttpSession session)
/*     */     throws IOException
/*     */   {
/* 233 */     response.setCharacterEncoding("UTF-8");
/* 234 */     String fileBatchRepay = "批量确认还款模板.zip";
/* 235 */     InputStream input = null;
/*     */     try
/*     */     {
/* 238 */       request.setCharacterEncoding("UTF-8");
/* 239 */       String url = session.getServletContext().getRealPath("/") + "/excel/批量确认还款模板.zip";
/* 240 */       File file = new File(url);
/* 241 */       input = FileUtils.openInputStream(file);
/* 242 */       byte[] data = IOUtils.toByteArray(input);
/* 243 */       response.reset();
/* 244 */       response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileBatchRepay, "UTF-8"));
/* 245 */       response.addHeader("Content-Length", data.length);
/*     */       
/* 247 */       response.setContentType("text/html;charset=UTF-8");
/* 248 */       IOUtils.write(data, response.getOutputStream());
/*     */     } catch (Exception e) {
/* 250 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ManageBorrowRepayController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */