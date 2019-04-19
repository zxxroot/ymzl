/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */

import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.system.domain.SysConfig;
import com.rongdu.cashloan.system.service.SysConfigService;
import jxl.common.Logger;
import tool.util.BeanUtil;
import tool.util.StringUtil;

import java.util.HashMap;
import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CacheUtil
/*    */ {
/* 30 */   private static final Logger logger = Logger.getLogger(CacheUtil.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void initSysConfig()
/*    */   {
/* 37 */     logger.info("初始化系统配置Config...");
/*    */     
/*    */ 
/* 40 */     SysConfigService sysConfigService = (SysConfigService)BeanUtil.getBean("sysConfigService");
/*    */     
/* 42 */     Map<String, Object> configMap = new HashMap();
/*    */     
/* 44 */     List<SysConfig> sysConfigs = sysConfigService.findAll();
/* 45 */     for (SysConfig sysConfig : sysConfigs) {
/* 46 */       if ((sysConfig != null) && (StringUtil.isNotBlank(sysConfig.getCode()))) {
/* 47 */         configMap.put(sysConfig.getCode(), sysConfig.getValue());
/*    */       }
/*    */     }
/*    */     
/* 51 */     Global.configMap = new HashMap();
/* 52 */     Global.configMap.putAll(configMap);
/*    */   }
/*    */ }
