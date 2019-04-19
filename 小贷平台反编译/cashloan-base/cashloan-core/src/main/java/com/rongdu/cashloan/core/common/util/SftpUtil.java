/*     */ package com.rongdu.cashloan.core.common.util;
/*     */ 
/*     */

import com.jcraft.jsch.*;
import com.rongdu.cashloan.core.common.context.Global;
import jxl.common.Logger;
import tool.util.NumberUtil;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

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
/*     */ public class SftpUtil
/*     */ {
/*  33 */   private static final Logger logger = Logger.getLogger(SftpUtil.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static String host;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static int port;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static String username;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static String password;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static String path;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static String privateKey;
/*     */   
/*     */ 
/*     */ 
/*     */   protected static String passphrase;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void init()
/*     */   {
/*  74 */     String sftp = Global.getValue("lianlian_sftp");
/*     */     try
/*     */     {
/*  77 */       logger.info("连连sftp配置:" + sftp);
/*     */       
/*  79 */       host = JsonUtil.get(sftp, "host");
/*  80 */       port = NumberUtil.getInt(JsonUtil.get(sftp, "port"));
/*  81 */       username = JsonUtil.get(sftp, "user");
/*  82 */       password = JsonUtil.get(sftp, "passwd");
/*  83 */       path = JsonUtil.get(sftp, "path");
/*     */     } catch (Exception e) {
/*  85 */       logger.error("初始化sftp连接出错:" + e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ChannelSftp connect()
/*     */   {
/*  95 */     init();
/*  96 */     JSch jsch = new JSch();
/*  97 */     Channel channel = null;
/*     */     try {
/*  99 */       Session session = jsch.getSession(username, host, port);
/* 100 */       if ((password != null) && (!"".equals(password))) {
/* 101 */         session.setPassword(password);
/*     */       }
/* 103 */       Properties sshConfig = new Properties();
/* 104 */       sshConfig.put("StrictHostKeyChecking", "no");
/* 105 */       session.setConfig(sshConfig);
/* 106 */       session.setServerAliveInterval(92000);
/* 107 */       session.connect();
/* 108 */       logger.debug("创建sftp连接成功");
/*     */       
/* 110 */       channel = session.openChannel("sftp");
/* 111 */       channel.connect();
/*     */     } catch (JSchException e) {
/* 113 */       logger.error(e);
/*     */     }
/* 115 */     return (ChannelSftp)channel;
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 120 */     connect();
/*     */   }
/*     */
/*     */   
/*     */   public static boolean download(String directory, String downloadFile, String saveDirectory, ChannelSftp sftp)
/*     */   {
/* 163 */     logger.info("下载sftp对账文件：" + downloadFile);
/*     */     
/* 165 */     File file = new File(saveDirectory);
/* 166 */     if (!file.exists()) {
/* 167 */       file.mkdirs();
/*     */     }
/*     */     try
/*     */     {
/* 171 */       sftp.cd(directory);
/* 172 */       sftp.get(downloadFile, saveDirectory);
/* 173 */       return true;
/*     */     } catch (Exception e) {
/* 175 */       logger.error(e.getMessage(), e); }
/* 176 */     return false;
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
/*     */   public static InputStream getFileStream(String fileName, ChannelSftp sftp)
/*     */   {
/* 190 */     InputStream in = null;
/* 191 */     logger.info("读取sftp对账文件输入流：" + fileName);
/*     */     try {
/* 193 */       sftp.cd(path);
/* 194 */       in = sftp.get(fileName);
/*     */     } catch (Exception e) {
/* 196 */       logger.error("读取sftp输入流异常：", e);
/*     */     }
/* 198 */     return in;
/*     */   }
/*     */ }
