/*     */ package com.cashloan.cl.utils;
/*     */ 
/*     */ import com.cashloan.cl.model.FileTypeUtil;
/*     */ import com.cashloan.cl.model.UploadFileRes;
/*     */ import com.rongdu.cashloan.core.common.context.Global;
/*     */ import com.rongdu.cashloan.core.common.util.StringUtil;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.math.BigDecimal;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.apache.commons.fileupload.disk.DiskFileItem;
/*     */ import org.apache.commons.httpclient.util.URIUtil;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.methods.HttpPost;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClientBuilder;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.multipart.commons.CommonsMultipartFile;
/*     */ import tool.util.DateUtil;
/*     */ 
/*     */ 
/*     */ public class OcrUdcreditUtils
/*     */ {
/*  34 */   private static final Logger logger = LoggerFactory.getLogger(OcrUdcreditUtils.class);
/*     */   
/*  36 */   private static final CloseableHttpClient client = HttpClientBuilder.create().build();
/*     */   private static String PUB_KEY;
/*     */   private static String SECRET_KEY;
/*     */   
/*     */   private static void init() {
/*  41 */     PUB_KEY = Global.getValue("ocr_udcredit_pubkey");
/*  42 */     SECRET_KEY = Global.getValue("ocr_udcredit_secretkey");
/*  43 */     PRODUCT_CODE = Global.getValue("ocr_udcredit_product_code");
/*  44 */     FFORMAT_STR = Global.getValue("ocr_udcredit_fformatStr");
/*     */   }
/*     */   
/*     */   public static void saveMultipartFile(List<UploadFileRes> list, MultipartFile file, String phone) {
/*  48 */     if (!file.isEmpty()) {
/*  49 */       UploadFileRes model = new UploadFileRes();
/*  50 */       model.setCreateTime(DateUtil.getNow());
/*     */       
/*  52 */       String picName = phone + "_" + file.getOriginalFilename();
/*  53 */       CommonsMultipartFile cf = (CommonsMultipartFile)file;
/*  54 */       DiskFileItem fi = (DiskFileItem)cf.getFileItem();
/*  55 */       File newFile = fi.getStoreLocation();
/*  56 */       logger.debug("图片----------" + newFile);
/*     */       
/*  58 */       String fileType = FileTypeUtil.getFileType(newFile);
/*  59 */       if ((StringUtil.isBlank(fileType)) || (!FileTypeUtil.isImage(newFile, fileType))) {
/*  60 */         model.setErrorMsg("图片格式错误或内容不规范");
/*  61 */         list.add(model);
/*  62 */         return;
/*     */       }
/*     */       
/*  65 */       Long picSize = Long.valueOf(file.getSize());
/*  66 */       if (picSize.compareTo(Long.valueOf(20971520L)) > 0) {
/*  67 */         model.setErrorMsg("文件超出20M大小限制");
/*  68 */         list.add(model);
/*  69 */         return;
/*     */       }
/*     */       
/*  72 */       String s = File.separator;
/*  73 */       String filePath = s + "data" + s + "image" + s + "faceID" + s + DateUtil.dateStr(DateUtil.getNow(), "yyyyMM") + s + picName;
/*  74 */       File files = new File(filePath);
/*  75 */       if (!files.exists()) {
/*     */         try {
/*  77 */           files.mkdirs();
/*     */         } catch (Exception e) {
/*  79 */           logger.error(e.getMessage(), e);
/*  80 */           model.setErrorMsg("文件目录不存在");
/*  81 */           list.add(model);
/*  82 */           return;
/*     */         }
/*     */       }
/*     */       try {
/*  86 */         file.transferTo(files);
/*     */       } catch (IllegalStateException|IOException e) {
/*  88 */         logger.error(e.getMessage(), e);
/*     */       }
/*     */       
/*  91 */       model.setResPath(filePath);
/*  92 */       model.setFileName(picName);
/*  93 */       model.setFileFormat(fileType);
/*  94 */       model.setFileSize(new BigDecimal(picSize.longValue()));
/*  95 */       list.add(model);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String apiCall(Map<String, String> parameter, String productCode) throws Exception {
/* 100 */     if ((parameter == null) || (parameter.isEmpty()))
/* 101 */       throw new Exception("error ! the parameter Map can't be null.");
/* 102 */     init();
/* 103 */     StringBuffer bodySb = new StringBuffer("{");
/* 104 */     for (Map.Entry<String, String> entry : parameter.entrySet()) {
/* 105 */       bodySb.append("'").append((String)entry.getKey()).append("':'").append((String)entry.getValue()).append("',");
/*     */     }
/* 107 */     String bodyStr = bodySb.substring(0, bodySb.length() - 1) + "}";
/* 108 */     String signature = md5(bodyStr + "|" + SECRET_KEY);
/* 109 */     String url = String.format(FFORMAT_STR, new Object[] { PUB_KEY, StringUtils.isBlank(productCode) ? PRODUCT_CODE : productCode, System.currentTimeMillis(), signature });
/* 110 */     logger.info("apiCall(Map<String,String>) - request parameter body=>{}, requestUrl=>{}", bodyStr, url);
/* 111 */     HttpResponse r = makePostRequest(url, bodyStr);
/* 112 */     return EntityUtils.toString(r.getEntity());
/*     */   }
/*     */   
/*     */   private static HttpResponse makePostRequest(String uri, String jsonData) throws ClientProtocolException, IOException {
/* 116 */     HttpPost httpPost = new HttpPost(URIUtil.encodeQuery(uri, "utf-8"));
/* 117 */     httpPost.setEntity(new StringEntity(jsonData, "UTF-8"));
/* 118 */     httpPost.setHeader("Accept", "application/json");
/* 119 */     httpPost.setHeader("Content-type", "application/json; charset=utf-8");
/* 120 */     return client.execute(httpPost);
/*     */   }
/*     */   
/*     */   private static String md5(String data) throws NoSuchAlgorithmException {
/* 124 */     MessageDigest md = MessageDigest.getInstance("MD5");
/* 125 */     md.update(data.toString().getBytes());
/* 126 */     return bytesToHex(md.digest());
/*     */   }
/*     */   
/*     */   private static String bytesToHex(byte[] ch) {
/* 130 */     StringBuffer ret = new StringBuffer("");
/* 131 */     for (int i = 0; i < ch.length; i++)
/* 132 */       ret.append(byteToHex(ch[i]));
/* 133 */     return ret.toString();
/*     */   }
/*     */   
/*     */   private static String PRODUCT_CODE;
/*     */   private static String FFORMAT_STR;
/*     */   private static String byteToHex(byte ch)
/*     */   {
/* 140 */     String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
/* 141 */     return str[(ch >> 4 & 0xF)] + str[(ch & 0xF)];
/*     */   }
/*     */   
/*     */   public static File getRemoteFile(String path) throws IOException {
/* 145 */     File file = new File(path);
/* 146 */     return file;
/*     */   }
/*     */ }
