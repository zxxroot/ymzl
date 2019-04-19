/*     */ package com.rongdu.cashloan.manage.controller;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.rongdu.cashloan.cl.model.ChannelSettlementModel;
/*     */ import com.rongdu.cashloan.cl.service.ChannelSettlementService;
/*     */ import com.rongdu.cashloan.core.common.exception.BussinessException;
/*     */ import com.rongdu.cashloan.core.common.util.JsonUtil;
/*     */ import com.rongdu.cashloan.core.common.util.RdPage;
/*     */ import com.rongdu.cashloan.core.common.util.ServletUtils;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.permission.annotation.RequiresPermission;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URLEncoder;
/*     */ import java.text.ParseException;
/*     */ import java.util.HashMap;
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
/*     */ public class ChannelSettlementController
/*     */   extends ManageBaseController
/*     */ {
/*  53 */   private static final Logger logger = LoggerFactory.getLogger(ManageBorrowRepayController.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   private ChannelSettlementService channelSettlementService;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelSettlement/channelSettlementList.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void channelSettlementList(@RequestParam("pageSize") int pageSize, @RequestParam("current") int current, @RequestParam(value="searchParams", required=false) String searchParams)
/*     */     throws ParseException
/*     */   {
/*  70 */     Map<String, Object> params = (Map)JsonUtil.parse(searchParams, Map.class);
/*  71 */     Page<ChannelSettlementModel> page = this.channelSettlementService.channelStaffDetails(current, pageSize, params);
/*  72 */     Map<String, Object> result = new HashMap();
/*  73 */     result.put("data", page);
/*  74 */     result.put("page", new RdPage(page));
/*  75 */     result.put("code", Integer.valueOf(200));
/*  76 */     result.put("msg", "获取成功");
/*  77 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelSettlement/downRepayByFile.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:promotion:channelSettlement:downRepayByFile", name="下载渠道批量结算模板")
/*     */   public void fileBatchRepay(HttpServletRequest request, HttpServletResponse response, HttpSession session)
/*     */     throws IOException
/*     */   {
/*  90 */     response.setCharacterEncoding("UTF-8");
/*  91 */     String fileBatchRepay = "渠道批量结算模板.zip";
/*  92 */     InputStream input = null;
/*     */     try
/*     */     {
/*  95 */       request.setCharacterEncoding("UTF-8");
/*  96 */       String url = session.getServletContext().getRealPath("/") + "/excel/渠道批量结算模板.zip";
/*  97 */       File file = new File(url);
/*  98 */       input = FileUtils.openInputStream(file);
/*  99 */       byte[] data = IOUtils.toByteArray(input);
/* 100 */       response.reset();
/* 101 */       response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileBatchRepay, "UTF-8"));
/* 102 */       response.addHeader("Content-Length", data.length);
/*     */       
/* 104 */       response.setContentType("text/html;charset=UTF-8");
/* 105 */       IOUtils.write(data, response.getOutputStream());
/*     */     } catch (Exception e) {
/* 107 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/modules/manage/promotion/channelSettlement/fileBatchRepay.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @RequiresPermission(code="modules:manage:promotion:channelSettlement:fileBatchRepay", name="文件上传渠道批量结算")
/*     */   public void fileBatchRepay(@RequestParam("repayFile") MultipartFile repayFile, @RequestParam("type") String type)
/*     */   {
/* 121 */     SysUser userinfo = getLoginUser(this.request);
/* 122 */     String loginUserName = userinfo.getName();
/* 123 */     Map<String, Object> result = new HashMap();
/*     */     try {
/* 125 */       this.channelSettlementService.fileBatchRepay(repayFile, type, loginUserName);
/* 126 */       result.put("code", Integer.valueOf(200));
/* 127 */       result.put("msg", "获取成功");
/*     */     } catch (BussinessException e) {
/* 129 */       logger.error(e.getMessage(), e);
/* 130 */       result.put("code", Integer.valueOf(400));
/* 131 */       result.put("msg", e.getMessage());
/*     */     } catch (Exception e) {
/* 133 */       logger.error(e.getMessage(), e);
/* 134 */       result.put("code", Integer.valueOf(400));
/* 135 */       result.put("msg", "批量结算失败");
/*     */     }
/* 137 */     ServletUtils.writeToResponse(this.response, result);
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\controller\ChannelSettlementController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */