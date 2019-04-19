/*    */ package com.rongdu.cashloan.system.service.impl;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*    */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*    */ import com.rongdu.cashloan.system.domain.SysRolePerm;
/*    */ import com.rongdu.cashloan.system.mapper.SysRolePermMapper;
/*    */ import com.rongdu.cashloan.system.service.SysRolePermService;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service("sysRolePermService")
/*    */ public class SysRolePermServiceImpl
/*    */   extends BaseServiceImpl<SysRolePerm, Long>
/*    */   implements SysRolePermService
/*    */ {
/*    */   @Resource
/*    */   private SysRolePermMapper sysRolePermMapper;
/*    */   
/*    */   public BaseMapper<SysRolePerm, Long> getMapper()
/*    */   {
/* 24 */     return this.sysRolePermMapper;
/*    */   }
/*    */   
/*    */   public int deleteByRoleId(Integer roleId) {
/* 28 */     return this.sysRolePermMapper.deleteByRoleId(roleId);
/*    */   }
/*    */   
/*    */   public void updatePerms(Integer roleId, List<Integer> permIds, String user) {
/* 32 */     this.sysRolePermMapper.deleteByRoleId(roleId);
/*    */     
/* 34 */     for (Integer permId : permIds) {
/* 35 */       if (permId != null) {
/* 36 */         SysRolePerm rolePerm = new SysRolePerm();
/* 37 */         rolePerm.setRoleId(roleId);
/* 38 */         rolePerm.setPermId(permId);
/* 39 */         rolePerm.setAddTime(new Date());
/* 40 */         rolePerm.setAddUser(user);
/* 41 */         this.sysRolePermMapper.save(rolePerm);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysRolePermServiceImpl.class

 */