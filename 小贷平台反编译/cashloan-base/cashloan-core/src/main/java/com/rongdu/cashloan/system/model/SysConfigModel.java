/*    */ package com.rongdu.cashloan.system.model;
/*    */ 
/*    */ import com.rongdu.cashloan.system.domain.SysConfig;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SysConfigModel
/*    */   extends SysConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String typeStr;
/*    */   
/*    */   public String getTypeStr()
/*    */   {
/* 22 */     return this.typeStr;
/*    */   }
/*    */   
/*    */   public void setTypeStr(String typeStr) {
/* 26 */     this.typeStr = typeStr;
/*    */   }
/*    */   
/*    */   public SysConfigModel getSysModel(SysConfig sys, Map<String, Object> dataMap) {
/* 30 */     SysConfigModel model = new SysConfigModel();
/* 31 */     model.setId(sys.getId());
/* 32 */     model.setCode(sys.getCode());
/* 33 */     model.setCreator(sys.getCreator());
/* 34 */     model.setName(sys.getName());
/* 35 */     model.setRemark(sys.getRemark());
/* 36 */     model.setStatus(sys.getStatus());
/* 37 */     model.setType(sys.getType());
/* 38 */     model.setValue(sys.getValue());
/* 39 */     model.setTypeStr((String)dataMap.get(String.valueOf(sys.getType())));
/* 40 */     return model;
/*    */   }
/*    */ }
