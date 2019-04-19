/*    */ package com.rongdu.cashloan.manage.service;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import org.springframework.jdbc.core.PreparedStatementCreator;
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
/*    */ class DBService$1
/*    */   implements PreparedStatementCreator
/*    */ {
/*    */   DBService$1(DBService paramDBService, String paramString, Object[] paramArrayOfObject) {}
/*    */   
/*    */   public PreparedStatement createPreparedStatement(Connection connection)
/*    */     throws SQLException
/*    */   {
/* 32 */     PreparedStatement ps = connection.prepareStatement(this.val$sql, 1);
/* 33 */     for (int i = 0; i < this.val$args.length; i++) {
/* 34 */       Object arg = this.val$args[i];
/* 35 */       ps.setObject(i + 1, arg);
/*    */     }
/* 37 */     return ps;
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\service\DBService$1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */