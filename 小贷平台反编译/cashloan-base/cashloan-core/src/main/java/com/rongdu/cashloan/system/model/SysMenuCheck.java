/*    */ package com.rongdu.cashloan.system.model;
/*    */ 
/*    */ import com.rongdu.cashloan.system.domain.SysMenu;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class SysMenuCheck
/*    */   extends SysMenu
/*    */ {
/*    */   private static final long serialVersionUID = 73161925067707896L;
/*    */   private boolean checked;
/*    */   private List<SysMenuCheck> children;
/*    */   
/*    */   public List<SysMenuCheck> getChildren()
/*    */   {
/* 16 */     return this.children;
/*    */   }
/*    */   
/*    */   public void setChildren(List<SysMenuCheck> children) {
/* 20 */     this.children = children;
/*    */   }
/*    */   
/*    */   public boolean isChecked() {
/* 24 */     return this.checked;
/*    */   }
/*    */   
/*    */   public void setChecked(boolean checked) {
/* 28 */     this.checked = checked;
/*    */   }
/*    */ }
