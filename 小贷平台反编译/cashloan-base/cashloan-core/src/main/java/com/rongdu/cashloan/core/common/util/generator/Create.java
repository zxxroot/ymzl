/*    */ package com.rongdu.cashloan.core.common.util.generator;
/*    */ 
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class Create
/*    */ {
/*  8 */   public static final Logger logger = LoggerFactory.getLogger(Create.class);
/*    */   
/* 10 */   public static void main(String[] args) { Create ot = new Create();
/* 11 */     ot.test();
/*    */   }
/*    */   
/*    */ 
/*    */   public void test()
/*    */   {
/* 17 */     String url = "jdbc:mysql://localhost:3306/p2p0308?useUnicode=true&characterEncoding=utf8";
/* 18 */     String MysqlUser = "root";
/* 19 */     String mysqlPassword = "root";
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 25 */     String database = "p2p0308";
/* 26 */     String table = "rd_create_number";
/*    */     
/*    */ 
/* 29 */     String classAuthor = "zyp";
/* 30 */     String functionName = "自动发布产品编号";
/*    */     
/*    */ 
/* 33 */     String commonName = "com.rongdu.cashloan.cl.common";
/*    */     
/* 35 */     String packageName = "com.rongdu.cashloan.cl";
/* 36 */     String moduleName = "";
/*    */     
/*    */ 
/* 39 */     String batisName = "config/mappers/doc";
/* 40 */     String db = "mysql";
/*    */     
/*    */ 
/* 43 */     String classNamePrefix = "CreateNumber";
/*    */     try
/*    */     {
/* 46 */       MybatisGenerate.generateCode(db, url, MysqlUser, mysqlPassword, database, table, commonName, packageName, batisName, moduleName, classAuthor, functionName, classNamePrefix);
/*    */     } catch (Exception e) {
/* 48 */       logger.error(e.getMessage(), e);
/*    */     }
/*    */   }
/*    */ }


/* generator\Create.class

 */