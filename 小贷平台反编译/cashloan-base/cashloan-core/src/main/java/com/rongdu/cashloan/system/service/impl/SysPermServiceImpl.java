/*    */ package com.rongdu.cashloan.system.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.system.domain.SysPerm;
/*    */ import com.rongdu.cashloan.system.mapper.SysPermMapper;
/*    */ import com.rongdu.cashloan.system.service.SysPermService;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service("sysPermService")
/*    */ public class SysPermServiceImpl
/*    */   extends BaseServiceImpl<SysPerm, Long>
/*    */   implements SysPermService
/*    */ {
/*    */   @Resource
/*    */   private SysPermMapper sysPermDao;
/*    */   
/*    */   public int updateByPrimaryKeySelective(SysPerm record)
/*    */   {
/* 24 */     return this.sysPermDao.updateByPrimaryKeySelective(record);
/*    */   }
/*    */   
/*    */   public List<SysPerm> listByUserName(String userName)
/*    */   {
/* 29 */     return this.sysPermDao.listByUserName(userName);
/*    */   }
/*    */   
/*    */   public List<Map<String, Object>> fetchAll()
/*    */   {
/* 34 */     return this.sysPermDao.fetchAll();
/*    */   }
/*    */   
/*    */   public List<SysPerm> listByRoleId(Long roleId)
/*    */   {
/* 39 */     return this.sysPermDao.listByRoleId(roleId);
/*    */   }
/*    */   
/*    */   public BaseMapper<SysPerm, Long> getMapper()
/*    */   {
/* 44 */     return this.sysPermDao;
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysPermServiceImpl.class

 */