/*    */ package com.rongdu.cashloan.manage.service;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.exception.BaseRuntimeException;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.jdbc.core.PreparedStatementCreator;
/*    */ import org.springframework.jdbc.support.GeneratedKeyHolder;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class DBService
/*    */ {
/*    */   @Autowired
/*    */   private JdbcTemplate jdbcTemplate;
/*    */   
/*    */   public long insert(final String sql, final Object... args)
/*    */   {
/* 28 */     GeneratedKeyHolder holder = new GeneratedKeyHolder();
/* 29 */     this.jdbcTemplate.update(new PreparedStatementCreator()
/*    */     {
/*    */       public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
/* 32 */         PreparedStatement ps = connection.prepareStatement(sql, 1);
/* 33 */         for (int i = 0; i < args.length; i++) {
/* 34 */           Object arg = args[i];
/* 35 */           ps.setObject(i + 1, arg);
/*    */         }
/* 37 */         return ps;
/*    */       }
/* 39 */     }, holder);
/* 40 */     return holder.getKey().longValue();
/*    */   }
/*    */   
/*    */   public int update(String sql, Object... args) {
/* 44 */     return this.jdbcTemplate.update(sql, args);
/*    */   }
/*    */   
/*    */   public List<Map<String, Object>> queryList(String sql, Object... args)
/*    */   {
/* 49 */     return this.jdbcTemplate.queryForList(sql, args);
/*    */   }
/*    */   
/*    */   public Map<String, Object> queryRec(String sql, Object... args)
/*    */   {
/* 54 */     List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql, args);
/* 55 */     if (list.size() > 1) {
/* 56 */       throw new BaseRuntimeException("期望1条，实际返回" + list.size() + "条");
/*    */     }
/* 58 */     return list.size() == 0 ? null : (Map)list.get(0);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\service\DBService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */