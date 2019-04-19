/*    */ package com.rongdu.cashloan.core.common.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.BaseService;
/*    */ import java.io.Serializable;
/*    */ import javax.annotation.Resource;
/*    */ 
/*    */ public abstract class BaseServiceImpl<T, ID extends Serializable>
/*    */   implements BaseService<T, ID>
/*    */ {
/*    */   @Resource
/*    */   private BaseMapper<T, ID> baseMapper;
/*    */   
/*    */   public int insert(T record)
/*    */   {
/* 16 */     return getMapper().save(record);
/*    */   }
/*    */   
/*    */   public T getById(ID id) {
/* 20 */     return (T)getMapper().findByPrimary(id);
/*    */   }
/*    */   
/*    */   public int updateById(T record) {
/* 24 */     return getMapper().update(record);
/*    */   }
/*    */   
/*    */   public abstract BaseMapper<T, ID> getMapper();
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\service\impl\BaseServiceImpl.class

 */