/*     */ package com.rongdu.cashloan.core.common.web.controller;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.util.json.ObjToJsonSerializer;
/*     */ import com.rongdu.cashloan.core.common.util.json.fastjson.JsonSerializer;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
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
/*     */ public abstract class AbstractController
/*     */ {
/*     */   @Autowired
/*     */   private ObjToJsonSerializer objToJsonSerializer;
/*  24 */   protected final Logger logger = Logger.getLogger(getClass());
/*     */   
/*     */   public ObjToJsonSerializer getObjToJsonSerializer() {
/*  27 */     return this.objToJsonSerializer;
/*     */   }
/*     */   
/*     */   public void setObjToJsonSerializer(ObjToJsonSerializer objToJsonSerializer)
/*     */   {
/*  32 */     this.objToJsonSerializer = objToJsonSerializer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponse(HttpServletResponse response, JsonSerializer jsonSerializer)
/*     */   {
/*  43 */     PrintWriter out = null;
/*  44 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/*  46 */       out = response.getWriter();
/*  47 */       out.write(jsonSerializer.toString(null));
/*  48 */       out.flush();
/*  49 */       out.close();
/*     */     } catch (Exception e) {
/*  51 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponse(HttpServletResponse response, Object object)
/*     */   {
/*  62 */     PrintWriter out = null;
/*  63 */     JsonSerializer jsonSerializer = new JsonSerializer(null);
/*  64 */     jsonSerializer.addObject(object, null);
/*  65 */     response.setContentType("application/json");
/*  66 */     response.setCharacterEncoding("utf8");
/*     */     try {
/*  68 */       out = response.getWriter();
/*  69 */       out.write(jsonSerializer.toString(null));
/*  70 */       out.flush();
/*  71 */       out.close();
/*     */     } catch (Exception e) {
/*  73 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponse(HttpServletResponse response, Object object, String name)
/*     */   {
/*  84 */     PrintWriter out = null;
/*  85 */     JsonSerializer jsonSerializer = new JsonSerializer(name);
/*  86 */     jsonSerializer.addObject(object, name);
/*  87 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try
/*     */     {
/*  90 */       out = response.getWriter();
/*  91 */       out.write(jsonSerializer.toString(name));
/*  92 */       out.flush();
/*  93 */       out.close();
/*     */     } catch (Exception e) {
/*  95 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponseExclude(HttpServletResponse response, Object object, String name, String[] properties)
/*     */   {
/* 106 */     PrintWriter out = null;
/* 107 */     JsonSerializer jsonSerializer = new JsonSerializer(name);
/* 108 */     jsonSerializer.addObjectWithExclude(object, name, properties);
/* 109 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 111 */       out = response.getWriter();
/* 112 */       out.write(jsonSerializer.toString(name));
/* 113 */       out.flush();
/* 114 */       out.close();
/*     */     } catch (Exception e) {
/* 116 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponseInclude(HttpServletResponse response, Object object, String name, String[] properties)
/*     */   {
/* 127 */     PrintWriter out = null;
/* 128 */     JsonSerializer jsonSerializer = new JsonSerializer(name);
/* 129 */     jsonSerializer.addObjectWithInclude(object, name, properties);
/* 130 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 132 */       out = response.getWriter();
/* 133 */       out.write(jsonSerializer.toString(name));
/* 134 */       out.flush();
/* 135 */       out.close();
/*     */     } catch (Exception e) {
/* 137 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponseWithErrorInfo(HttpServletResponse response, Object object, String name, String errorNo, String errorInfo)
/*     */   {
/* 148 */     PrintWriter out = null;
/* 149 */     JsonSerializer jsonSerializer = new JsonSerializer(true, name);
/* 150 */     jsonSerializer.addObject(object, name);
/* 151 */     jsonSerializer.setErrorNo(errorNo);
/* 152 */     jsonSerializer.setErrorInfo(errorInfo);
/* 153 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 155 */       out = response.getWriter();
/* 156 */       out.write(jsonSerializer.toString(name));
/* 157 */       out.flush();
/* 158 */       out.close();
/*     */     } catch (Exception e) {
/* 160 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponseExcludeWithErrorInfo(HttpServletResponse response, Object object, String name, String errorNo, String errorInfo, String[] properties)
/*     */   {
/* 172 */     PrintWriter out = null;
/* 173 */     JsonSerializer jsonSerializer = new JsonSerializer(true, name);
/* 174 */     jsonSerializer.addObjectWithExclude(object, name, properties);
/* 175 */     jsonSerializer.setErrorNo(errorNo);
/* 176 */     jsonSerializer.setErrorInfo(errorInfo);
/* 177 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 179 */       out = response.getWriter();
/* 180 */       out.write(jsonSerializer.toString(name));
/* 181 */       out.flush();
/* 182 */       out.close();
/*     */     } catch (Exception e) {
/* 184 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponseIncludeWithErrorInfo(HttpServletResponse response, Object object, String name, String errorNo, String errorInfo, String[] properties)
/*     */   {
/* 195 */     PrintWriter out = null;
/* 196 */     JsonSerializer jsonSerializer = new JsonSerializer(true, name);
/* 197 */     jsonSerializer.addObjectWithInclude(object, name, properties);
/* 198 */     jsonSerializer.setErrorNo(errorNo);
/* 199 */     jsonSerializer.setErrorInfo(errorInfo);
/* 200 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 202 */       out = response.getWriter();
/* 203 */       out.write(jsonSerializer.toString(name));
/* 204 */       out.flush();
/* 205 */       out.close();
/*     */     } catch (Exception e) {
/* 207 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponseWithErrorinfo(HttpServletResponse response, Object object, String name)
/*     */   {
/* 219 */     PrintWriter out = null;
/* 220 */     JsonSerializer jsonSerializer = new JsonSerializer(true, name);
/* 221 */     jsonSerializer.addObject(object, name);
/* 222 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 224 */       out = response.getWriter();
/* 225 */       out.write(jsonSerializer.toString(name));
/* 226 */       out.flush();
/* 227 */       out.close();
/*     */     } catch (Exception e) {
/* 229 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponseWithErrorinfo(HttpServletResponse response, Object object)
/*     */   {
/* 240 */     PrintWriter out = null;
/* 241 */     JsonSerializer jsonSerializer = new JsonSerializer(true, null);
/* 242 */     jsonSerializer.addObject(object, null);
/* 243 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 245 */       out = response.getWriter();
/* 246 */       out.write(jsonSerializer.toString(null));
/* 247 */       out.flush();
/* 248 */       out.close();
/*     */     } catch (Exception e) {
/* 250 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonResponseWithErrorinfo(HttpServletResponse response, String errorNo, String errorInfo)
/*     */   {
/* 261 */     PrintWriter out = null;
/* 262 */     JsonSerializer jsonSerializer = new JsonSerializer(true, null);
/* 263 */     jsonSerializer.setErrorNo(errorNo);
/* 264 */     jsonSerializer.setErrorInfo(errorInfo);
/*     */     try {
/* 266 */       out = response.getWriter();
/* 267 */       out.write(jsonSerializer.toString(null));
/* 268 */       out.flush();
/* 269 */       out.close();
/*     */     } catch (Exception e) {
/* 271 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void textResponse(HttpServletResponse response, String text)
/*     */   {
/* 281 */     PrintWriter out = null;
/* 282 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 284 */       out = response.getWriter();
/* 285 */       out.write(text);
/* 286 */       out.flush();
/* 287 */       out.close();
/*     */     } catch (Exception e) {
/* 289 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonSingleObjIncludeResponse(HttpServletResponse response, Object obj, String[] properties)
/*     */   {
/* 300 */     PrintWriter out = null;
/* 301 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 303 */       out = response.getWriter();
/* 304 */       out.write(this.objToJsonSerializer.objectToJsonString(obj));
/* 305 */       out.flush();
/* 306 */       out.close();
/*     */     } catch (Exception e) {
/* 308 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonSingleObjExcludeResponse(HttpServletResponse response, Object obj, String[] properties)
/*     */   {
/* 319 */     PrintWriter out = null;
/* 320 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 322 */       out = response.getWriter();
/* 323 */       out.write(this.objToJsonSerializer.objectToJsonStringWithExclude(obj, properties));
/* 324 */       out.flush();
/* 325 */       out.close();
/*     */     } catch (Exception e) {
/* 327 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void jsonSingleObjResponse(HttpServletResponse response, Object obj)
/*     */   {
/* 337 */     PrintWriter out = null;
/* 338 */     response.setContentType("text/html;charset=UTF-8");
/*     */     try {
/* 340 */       out = response.getWriter();
/* 341 */       out.write(this.objToJsonSerializer.objectToJsonString(obj));
/* 342 */       out.flush();
/* 343 */       out.close();
/*     */     } catch (Exception e) {
/* 345 */       this.logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ }
