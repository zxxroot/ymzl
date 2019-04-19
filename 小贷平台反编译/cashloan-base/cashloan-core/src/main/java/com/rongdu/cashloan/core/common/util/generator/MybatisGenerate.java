/*     */ package com.rongdu.cashloan.core.common.util.generator;
/*     */
/*     */ import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import tool.util.StringUtil;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

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
/*     */ public class MybatisGenerate
/*     */ {
/*  29 */   public static final Logger logger = LoggerFactory.getLogger(MybatisGenerate.class);
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
/*     */   public static void generateCode(String db, String url, String MysqlUser, String mysqlPassword, String database, String table, String commonName, String packageName, String batisName, String moduleName, String classAuthor, String functionName, String classNamePrefix)
/*     */     throws SQLException, IOException, TemplateException
/*     */   {
/*  52 */     Boolean needsDomain = Boolean.valueOf(true);
/*  53 */     Boolean needsDao = Boolean.valueOf(true);
/*  54 */     Boolean needsService = Boolean.valueOf(true);
/*  55 */     Boolean needsAction = Boolean.valueOf(false);
/*  56 */     Boolean needsMapper = Boolean.valueOf(true);
/*  57 */     String dbClass = null;
/*  58 */     String showTables = null;
/*  59 */     String getTable = null;
/*  60 */     String executeSql = null;
/*     */
/*     */
/*     */
/*  64 */     String str1 = db; switch (db.hashCode()) {case -1008861826:  if (str1.equals("oracle")) break;  case 104382626:  if (str1.equals("mysql"))
/*     */       {
/*  66 */         dbClass = "com.mysql.jdbc.Driver";
/*  67 */         showTables = "show tables";
/*  68 */         getTable = "Tables_in_" + database;
/*  69 */         executeSql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM INFORMATION_SCHEMA.`COLUMNS` WHERE table_name = '" +
/*  70 */           table + "'  AND table_schema = '" + database + "'";
/*     */
/*  74 */         dbClass = "oracle.jdbc.driver.OracleDriver";
/*  75 */         showTables = "SELECT TABLE_NAME FROM USER_ALL_TABLES";
/*  76 */         getTable = "TABLE_NAME";
/*  77 */         executeSql = "select column_name,data_type,(select t_s.comments  from all_col_comments t_s where t_s.column_name=t.column_name and t_s.table_name='" +
/*     */
/*  79 */           table + "' and t_s.owner='" + database + "') column_comment " +
/*  80 */           "from all_tab_columns t  where  table_name =upper('" + table + "' ) and owner='" + database +
/*  81 */           "' order by column_id "; }
/*  82 */       break;
/*     */     }
/*  84 */     System.err.println("---暂不支持该类型数据库----");
/*     */
/*     */
/*     */
/*  89 */     Connection connection = GenerateUtils.getDblink(dbClass, url, MysqlUser, mysqlPassword);
/*  90 */     Statement stateMent_table = connection.createStatement();
/*     */
/*  92 */     ResultSet tables = stateMent_table.executeQuery(showTables);
/*  93 */     while (tables.next()) {
/*  94 */       String table_name = tables.getString(getTable);
/*     */
/*  96 */       if (table_name.equals(table))
/*     */       {
/*     */
/*     */
/*     */
/*     */
/*     */
/* 103 */         String className = StringUtil.firstCharUpperCase(classNamePrefix);
/*     */
/* 105 */         String separator = File.separator;
/*     */
/*     */
/* 108 */         File projectPath = new DefaultResourceLoader().getResource("").getFile();
/* 109 */         while (!new File(projectPath.getPath() + separator + "src").exists()) {
/* 110 */           projectPath = projectPath.getParentFile();
/*     */         }
/*     */
/*     */
/* 114 */         String tplPath = "";
/* 115 */         if ("mysql".equals(db)) {
/* 116 */           tplPath = StringUtil.replace(projectPath + "/generate/template/mysql", "/", separator);
/* 117 */         } else if ("oracle".equals(db)) {
/* 118 */           tplPath = StringUtil.replace(projectPath + "/generate/template/oracle", "/", separator);
/*     */         }
/*     */
/*     */
/* 122 */         String javaPath = StringUtil.replaceEach(
/* 123 */           projectPath + "/src/main/java/" + StringUtil.lowerCase(packageName), new String[] { "/", "." },
/* 124 */           new String[] { separator, separator });
/*     */
/*     */
/*     */
/* 128 */         String batisPath =
/* 129 */           StringUtil.replace(projectPath + "/src/main/resources/" + batisName + "/" + moduleName, "/", separator);
/*     */
/*     */
/* 132 */         Configuration cfg = new Configuration();
/* 133 */         cfg.setDirectoryForTemplateLoading(new File(tplPath));
/*     */
/*     */
/* 136 */         Map<String, Object> model = new HashMap();
/* 137 */         model.put("commonName", StringUtil.lowerCase(commonName));
/* 138 */         model.put("packageName", StringUtil.lowerCase(packageName));
/* 139 */         model.put("moduleName", StringUtil.lowerCase(moduleName));
/* 140 */         model.put("className", StringUtil.uncapitalize(className));
/* 141 */         model.put("ClassName", className);
/* 142 */         model.put("classAuthor", classAuthor);
/* 143 */         model.put("classDate", GenerateUtils.getDate());
/* 144 */         model.put("functionName", functionName);
/* 145 */         model.put("tableName", StringUtil.lowerCase(table_name));
/* 146 */         model.put("urlPrefix", model.get("moduleName") + " /" + model.get("className"));
/* 147 */         model.put("permissionPrefix", model.get("moduleName") + " :" + model.get("className"));
/* 148 */         model.put("list", GenerateUtils.getList(dbClass, table_name, url, MysqlUser, mysqlPassword, database,
/* 149 */           executeSql));
/* 150 */         model.put("listSize",
/* 151 */           Integer.valueOf(GenerateUtils.getList(dbClass, table_name, url, MysqlUser, mysqlPassword, database, executeSql).size()));
/*     */
/* 153 */         model.put("leftBraces", "{");
/*     */
/* 155 */         model.put("rightBraces", "}");
/*     */
/* 157 */         model.put("dollarSign", "$");
/*     */
/*     */
/*     */
/*     */
/*     */
/* 163 */         if (needsMapper.booleanValue()) {
/* 164 */           Template ibatisTemplate = cfg.getTemplate("dbmapper.ftl");
/*     */
/* 166 */           String ibatisContent = FreeMarkers.renderTemplate(ibatisTemplate, model);
/*     */
/* 168 */           String batisSql = batisPath + separator + model.get("ClassName") + "Mapper.xml";
/*     */
/* 170 */           GenerateUtils.writeFile(ibatisContent, batisSql);
/*     */         }
/*     */
/*     */
/*     */
/* 175 */         if (needsDomain.booleanValue())
/*     */         {
/* 177 */           Template beanTemplate = cfg.getTemplate("domain.ftl");
/*     */
/* 179 */           String beanContent = FreeMarkers.renderTemplate(beanTemplate, model);
/*     */
/* 181 */           String beanFile = javaPath + separator + model.get("moduleName") + separator + "domain" + separator +
/* 182 */             model.get("ClassName") + ".java";
/*     */
/* 184 */           GenerateUtils.writeFile(beanContent, beanFile);
/*     */         }
/*     */
/*     */
/*     */
/*     */
/* 190 */         if (needsDao.booleanValue())
/*     */         {
/* 192 */           Template daoTemplate = cfg.getTemplate("mapper.ftl");
/*     */
/* 194 */           String daoContent = FreeMarkers.renderTemplate(daoTemplate, model);
/*     */
/* 196 */           String daoFile = javaPath + separator + model.get("moduleName") + separator + "mapper" + separator +
/* 197 */             model.get("ClassName") + "Mapper.java";
/*     */
/* 199 */           GenerateUtils.writeFile(daoContent, daoFile);
/*     */         }
/*     */
/*     */
/*     */
/*     */
/* 205 */         if (needsService.booleanValue())
/*     */         {
/* 207 */           Template serviceTemplate = cfg.getTemplate("service.ftl");
/*     */
/* 209 */           String serviceContent = FreeMarkers.renderTemplate(serviceTemplate, model);
/*     */
/* 211 */           String serviceFile = javaPath + separator + model.get("moduleName") + separator + "service" +
/* 212 */             separator + model.get("ClassName") + "Service.java";
/*     */
/* 214 */           GenerateUtils.writeFile(serviceContent, serviceFile);
/*     */
/*     */
/*     */
/*     */
/*     */
/* 220 */           Template serviceI_Template = cfg.getTemplate("serviceImpl.ftl");
/*     */
/* 222 */           String serviceI_Content = FreeMarkers.renderTemplate(serviceI_Template, model);
/*     */
/* 224 */           String serviceI_File = javaPath + separator + model.get("moduleName") + separator + "service" +
/* 225 */             separator + "impl" + separator + model.get("ClassName") + "ServiceImpl.java";
/*     */
/* 227 */           GenerateUtils.writeFile(serviceI_Content, serviceI_File);
/*     */         }
/*     */
/*     */
/*     */
/*     */
/* 233 */         if (needsAction.booleanValue())
/*     */         {
/* 235 */           Template actionTemplate = cfg.getTemplate("controller.ftl");
/*     */
/* 237 */           String actionContent = FreeMarkers.renderTemplate(actionTemplate, model);
/*     */
/* 239 */           String actionFile = javaPath + separator + model.get("moduleName") + separator + "controller" +
/* 240 */             separator + model.get("ClassName") + "Controller.java";
/*     */
/* 242 */           GenerateUtils.writeFile(actionContent, actionFile);
/*     */         }
/*     */       }
/*     */     }
/*     */
/*     */
/* 248 */     logger.info("代码生成成功");
/* 249 */     tables.close();
/* 250 */     stateMent_table.close();
/* 251 */     connection.close();
/*     */   }
/*     */ }


/* generator\MybatisGenerate.class

 */