/*    */ package com.rongdu.cashloan.manage.service;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.mybatis.spring.SqlSessionTemplate;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class MybatisService
/*    */ {
/*    */   @Resource
/*    */   private SqlSessionTemplate sessionTemplate;
/*    */   
/*    */   public List<Map> querySql(String statment, Object parameter)
/*    */   {
/* 21 */     return this.sessionTemplate.selectList(statment, parameter);
/*    */   }
/*    */   
/*    */   public Map queryRec(String statment, Object parameter) {
/* 25 */     return (Map)this.sessionTemplate.selectOne(statment, parameter);
/*    */   }
/*    */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\service\MybatisService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */