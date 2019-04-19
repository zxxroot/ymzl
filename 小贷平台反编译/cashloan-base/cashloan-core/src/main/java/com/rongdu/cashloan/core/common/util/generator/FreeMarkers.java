/*    */ package com.rongdu.cashloan.core.common.util.generator;
/*    */ 
/*    */ import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */

/*    */ 
/*    */ public class FreeMarkers
/*    */ {
/*    */   public static String renderString(String templateString, Map<String, ?> model)
/*    */     throws IOException, TemplateException
/*    */   {
/* 26 */     StringWriter result = new StringWriter();
/* 27 */     Template t = new Template("name", new StringReader(templateString), new Configuration());
/* 28 */     t.process(model, result);
/* 29 */     return result.toString();
/*    */   }
/*    */   
/*    */   public static String renderTemplate(Template template, Object model) throws TemplateException, IOException
/*    */   {
/* 34 */     StringWriter result = new StringWriter();
/* 35 */     template.process(model, result);
/* 36 */     return result.toString();
/*    */   }
/*    */   
/*    */   public static Configuration buildConfiguration(String directory) throws IOException {
/* 40 */     Configuration cfg = new Configuration();
/* 41 */     Resource path = new DefaultResourceLoader().getResource(directory);
/* 42 */     cfg.setDirectoryForTemplateLoading(path.getFile());
/* 43 */     return cfg;
/*    */   }
/*    */ }

