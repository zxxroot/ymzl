/*    */ package com.rongdu.cashloan.rule.model;
/*    */ 
/*    */ import com.rongdu.cashloan.rule.domain.BorrowRuleConfig;
/*    */ 
/*    */ public class BorrowRuleConfigModel
/*    */ {
/*    */   private BorrowRuleConfig rule;
/*    */   private java.util.List<BorrowRuleConfig> configList;
/*    */   
/*    */   public BorrowRuleConfig getRule()
/*    */   {
/* 12 */     return this.rule;
/*    */   }
/*    */   
/*    */   public void setRule(BorrowRuleConfig rule) {
/* 16 */     this.rule = rule;
/*    */   }
/*    */   
/*    */   public java.util.List<BorrowRuleConfig> getConfigList() {
/* 20 */     return this.configList;
/*    */   }
/*    */   
/*    */   public void setConfigList(java.util.List<BorrowRuleConfig> configList) {
/* 24 */     this.configList = configList;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 29 */     int prime = 31;
/* 30 */     int result = 1;
/* 31 */     result = 31 * result + (
/* 32 */       this.configList == null ? 0 : this.configList.hashCode());
/* 33 */     result = 31 * result + (this.rule == null ? 0 : this.rule.hashCode());
/* 34 */     return result;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 39 */     if (this == obj)
/* 40 */       return true;
/* 41 */     if (obj == null)
/* 42 */       return false;
/* 43 */     if (getClass() != obj.getClass())
/* 44 */       return false;
/* 45 */     BorrowRuleConfigModel other = (BorrowRuleConfigModel)obj;
/* 46 */     if (this.configList == null) {
/* 47 */       if (other.configList != null)
/* 48 */         return false;
/* 49 */     } else if (!this.configList.equals(other.configList))
/* 50 */       return false;
/* 51 */     if (this.rule == null) {
/* 52 */       if (other.rule != null)
/* 53 */         return false;
/* 54 */     } else if (!this.rule.equals(other.rule))
/* 55 */       return false;
/* 56 */     return true;
/*    */   }
/*    */ }
