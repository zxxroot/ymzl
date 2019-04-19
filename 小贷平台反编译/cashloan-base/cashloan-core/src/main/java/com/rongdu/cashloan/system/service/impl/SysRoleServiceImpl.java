/*     */ package com.rongdu.cashloan.system.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.exception.BussinessException;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.system.domain.SysRole;
/*     */ import com.rongdu.cashloan.system.mapper.SysRoleMapper;
/*     */ import com.rongdu.cashloan.system.security.authentication.encoding.PasswordEncoder;
/*     */ import com.rongdu.cashloan.system.service.SysRoleService;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("sysRoleServiceImpl")
/*     */ public class SysRoleServiceImpl
/*     */   extends BaseServiceImpl
/*     */   implements SysRoleService
/*     */ {
/*     */   @Resource
/*     */   private SysRoleMapper sysRoleMapper;
/*     */   @Resource
/*     */   private PasswordEncoder passwordEncoder;
/*     */   
/*     */   public List<SysRole> getRoleListByUserId(long userId) throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/*  33 */       return this.sysRoleMapper.getRoleListByUserId(Long.valueOf(userId));
/*     */     } catch (Exception e) {
/*  35 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public SysRole getRoleById(long id) throws ServiceException
/*     */   {
/*     */     try {
/*  42 */       return (SysRole)this.sysRoleMapper.findByPrimary(Long.valueOf(id));
/*     */     } catch (Exception e) {
/*  44 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public int deleteRole(long id) throws ServiceException
/*     */   {
/*     */     try {
/*  51 */       return this.sysRoleMapper.deleteById(id);
/*     */     } catch (Exception e) {
/*  53 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public Page<SysRole> getRolePageList(int currentPage, int pageSize, Map<String, Object> mapdata) throws ServiceException
/*     */   {
/*     */     try {
/*  60 */       PageHelper.startPage(currentPage, pageSize);
/*  61 */       return (Page)this.sysRoleMapper.listSelective(mapdata);
/*     */     } catch (Exception e) {
/*  63 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public long addRole(SysRole role) throws BussinessException
/*     */   {
/*     */     try {
/*  70 */       return this.sysRoleMapper.save(role);
/*     */     } catch (Exception e) {
/*  72 */       throw new BussinessException("保存失败,参数有误或唯一标识已存在");
/*     */     }
/*     */   }
/*     */   
/*     */   public long insertByMap(Map<String, Object> data) throws ServiceException
/*     */   {
/*     */     try {
/*  79 */       return this.sysRoleMapper.insertByMap(data);
/*     */     } catch (Exception e) {
/*  81 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public int updateRole(Map<String, Object> arg) throws BussinessException
/*     */   {
/*     */     try {
/*  88 */       return this.sysRoleMapper.updateByMap(arg);
/*     */     }
/*     */     catch (Exception e) {
/*  91 */       throw new BussinessException("保存失败,参数有误或唯一标识已存在");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SysRole> getList(Map<String, Object> paramMap)
/*     */   {
/*  98 */     return this.sysRoleMapper.listSelective(paramMap);
/*     */   }
/*     */   
/*     */   public BaseMapper getMapper()
/*     */   {
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> getByUserPassRolesList(String username, String password)
/*     */     throws ServiceException
/*     */   {
/* 109 */     Map<String, Object> data = new HashMap();
/*     */     
/* 111 */     data.put("username", username);
/* 112 */     data.put("password", this.passwordEncoder.encodePassword(password, "rongdumlms"));
/*     */     try
/*     */     {
/* 115 */       List<Map<String, Object>> roles = this.sysRoleMapper.getByUserPassRolesList(data);
/*     */       
/* 117 */       if (roles == null)
/*     */       {
/* 119 */         throw new ServiceException("获取角色数据失败");
/*     */       }
/* 121 */       return roles;
/*     */     }
/*     */     catch (Exception e) {
/* 124 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getRolecount(Map<String, Object> mapdata) throws ServiceException
/*     */   {
/*     */     try {
/* 131 */       return this.sysRoleMapper.getRolecount(mapdata);
/*     */     } catch (Exception e) {
/* 133 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public SysRole findByNid(String nid)
/*     */   {
/* 139 */     Map<String, Object> roleMap = new HashMap();
/* 140 */     roleMap.put("nid", nid);
/* 141 */     return (SysRole)this.sysRoleMapper.findSelective(roleMap);
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysRoleServiceImpl.class

 */