/*    */ package com.rongdu.cashloan.system.model;
/*    */ 
/*    */ import com.rongdu.cashloan.system.domain.SysConfig;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.HashMap;
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
/*    */ public class ConfigModel
/*    */   extends SysConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int page;
/*    */   private int size;
/*    */   private Map<String, SysConfig> map;
/*    */   
/*    */   public ConfigModel()
/*    */   {
/* 32 */     this.map = Collections.synchronizedMap(new HashMap());
/*    */   }
/*    */   
/*    */   public static ConfigModel instance(SysConfig sconfig) {
/* 36 */     ConfigModel systemConfigModel = new ConfigModel();
/* 37 */     BeanUtils.copyProperties(sconfig, systemConfigModel);
/* 38 */     return systemConfigModel;
/*    */   }
/*    */   
/*    */   public SysConfig prototype() {
/* 42 */     SysConfig sconfig = new SysConfig();
/* 43 */     BeanUtils.copyProperties(this, sconfig);
/* 44 */     return sconfig;
/*    */   }
/*    */   
/*    */   public void addConfig(SysConfig sys) {
/* 48 */     this.map.put(sys.getCode().replace("con_", ""), sys);
/*    */   }
/*    */   
/*    */   private SysConfig getConfig(String key) {
/* 52 */     SysConfig sys = (SysConfig)this.map.get(key);
/* 53 */     return sys;
/*    */   }
/*    */   
/*    */   public String getValue(String key) {
/* 57 */     SysConfig c = getConfig(key);
/* 58 */     if (c == null)
/* 59 */       return null;
/* 60 */     return c.getValue();
/*    */   }
/*    */   
/*    */   public Integer getStatus(String key) {
/* 64 */     SysConfig c = getConfig(key);
/* 65 */     if (c == null)
/* 66 */       return null;
/* 67 */     return getConfig(key).getStatus();
/*    */   }
/*    */   
/*    */   public int getPage() {
/* 71 */     return this.page;
/*    */   }
/*    */   
/*    */   public void setPage(int page) {
/* 75 */     this.page = page;
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 79 */     return this.size;
/*    */   }
/*    */   
/*    */   public void setSize(int size) {
/* 83 */     this.size = size;
/*    */   }
/*    */   
/*    */   public Map<String, SysConfig> getMap() {
/* 87 */     return this.map;
/*    */   }
/*    */   
/*    */   public void setMap(Map<String, SysConfig> map) {
/* 91 */     this.map = map;
/*    */   }
/*    */ }
