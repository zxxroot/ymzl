/*     */ package com.rongdu.cashloan.system.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.exception.ServiceException;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.system.domain.SysRole;
/*     */ import com.rongdu.cashloan.system.domain.SysUser;
/*     */ import com.rongdu.cashloan.system.domain.SysUserRole;
/*     */ import com.rongdu.cashloan.system.mapper.SysRoleMapper;
/*     */ import com.rongdu.cashloan.system.mapper.SysUserMapper;
/*     */ import com.rongdu.cashloan.system.mapper.SysUserRoleMapper;
/*     */ import com.rongdu.cashloan.system.security.authentication.encoding.PasswordEncoder;
/*     */ import com.rongdu.cashloan.system.service.SysUserService;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("sysUserService")
/*     */ public class SysUserServiceImpl
/*     */   extends BaseServiceImpl<SysUser, Long>
/*     */   implements SysUserService
/*     */ {
/*  32 */   public static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private SysUserMapper sysUserMapper;
/*     */   
/*     */   @Resource
/*     */   private SysUserRoleMapper sysUserRoleMapper;
/*     */   
/*     */   @Resource
/*     */   private SysRoleMapper sysRoleMapper;
/*     */   
/*     */   @Autowired
/*     */   private PasswordEncoder passwordEncoder;
/*     */   
/*     */   public SysUserMapper getSysUserMapper()
/*     */   {
/*  48 */     return this.sysUserMapper;
/*     */   }
/*     */   
/*     */   public void setSysUserMapper(SysUserMapper sysUserMapper) {
/*  52 */     this.sysUserMapper = sysUserMapper;
/*     */   }
/*     */   
/*     */   public SysUserRoleMapper getSysUserRoleMapper() {
/*  56 */     return this.sysUserRoleMapper;
/*     */   }
/*     */   
/*     */   public void setSysUserRoleMapper(SysUserRoleMapper sysUserRoleMapper) {
/*  60 */     this.sysUserRoleMapper = sysUserRoleMapper;
/*     */   }
/*     */   
/*     */   public SysRoleMapper getSysRoleMapper() {
/*  64 */     return this.sysRoleMapper;
/*     */   }
/*     */   
/*     */   public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
/*  68 */     this.sysRoleMapper = sysRoleMapper;
/*     */   }
/*     */   
/*     */   public Boolean editUserLoginInfo(SysUser sysUser) throws ServiceException
/*     */   {
/*     */     try {
/*  74 */       return this.sysUserMapper.editUserLoginInfo(sysUser);
/*     */     } catch (Exception e) {
/*  76 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean editUserPassWord(SysUser sysUser) throws ServiceException
/*     */   {
/*     */     try {
/*  83 */       return this.sysUserMapper.editUserPassWord(sysUser);
/*     */     } catch (Exception e) {
/*  85 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public SysUser getUserById(long id) throws ServiceException
/*     */   {
/*     */     try {
/*  92 */       return (SysUser)this.sysUserMapper.findByPrimary(Long.valueOf(id));
/*     */     } catch (Exception e) {
/*  94 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public SysRole getRoleById(long id) throws ServiceException
/*     */   {
/*     */     try {
/* 101 */       return (SysRole)this.sysRoleMapper.findByPrimary(Long.valueOf(id));
/*     */     } catch (Exception e) {
/* 103 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public int userUpdate(SysUser sysUser) throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/* 111 */       return this.sysUserMapper.update(sysUser);
/*     */     } catch (Exception e) {
/* 113 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public Page<Map<String, Object>> getUserPageList(int currentPage, int pageSize, Map<String, Object> mapdata) throws ServiceException
/*     */   {
/*     */     try {
/* 120 */       PageHelper.startPage(currentPage, pageSize);
/*     */       
/* 122 */       return (Page)this.sysUserMapper.listUserInfo(mapdata);
/*     */     } catch (Exception e) {
/* 124 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getUserSum(Map<String, Object> map) throws ServiceException
/*     */   {
/*     */     try {
/* 131 */       return this.sysUserMapper.getPageCountOracle(map);
/*     */     } catch (Exception e) {
/* 133 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addUser(SysUser sysUser, String roleIdArr) throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/* 141 */       this.sysUserMapper.save(sysUser);
/* 142 */       String temp = roleIdArr.replaceAll("\\[", "").replaceAll("\\]", "");
/* 143 */       String[] roles = temp.split(",");
/* 144 */       for (int i = 0; i < roles.length; i++) {
/* 145 */         String role = roles[i].trim();
/*     */         
/* 147 */         SysUserRole sysUserRole = new SysUserRole();
/* 148 */         sysUserRole.setRoleId(Long.valueOf(Long.parseLong(role)));
/* 149 */         sysUserRole.setUserId(sysUser.getId());
/* 150 */         this.sysUserRoleMapper.save(sysUserRole);
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   @Transactional(rollbackFor={Exception.class})
/*     */   public Boolean updateSysUserById(Map<String, Object> map) throws ServiceException
/*     */   {
/*     */     try {
/* 161 */       Boolean result = Boolean.valueOf(false);
/*     */       
/* 163 */       Long userId = Long.valueOf(String.valueOf(map.get("id")));
/* 164 */       this.sysUserRoleMapper.deleteByUserId(userId.longValue());
/* 165 */       String temp = String.valueOf(map.get("roleId")).replaceAll("\\[", "").replaceAll("\\]", "");
/* 166 */       String[] roles = temp.split(",");
/* 167 */       for (int i = 0; i < roles.length; i++) {
/* 168 */         String role = roles[i].trim();
/*     */         
/* 170 */         SysUserRole sysUserRole = new SysUserRole();
/* 171 */         sysUserRole.setRoleId(Long.valueOf(Long.parseLong(role)));
/* 172 */         sysUserRole.setUserId(userId);
/* 173 */         this.sysUserRoleMapper.save(sysUserRole);
/*     */       }
/* 175 */       int isU = this.sysUserMapper.updateSysUserById(map);
/* 176 */       if (isU > 0) {}
/* 177 */       return Boolean.valueOf(true);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 181 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public SysUser getUserByUserName(String userName) throws ServiceException
/*     */   {
/*     */     try {
/* 188 */       return this.sysUserMapper.getUserByUserName(userName);
/*     */     } catch (Exception e) {
/* 190 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public int queryRoleUserIsUse(Map<String, Object> data) throws ServiceException
/*     */   {
/*     */     try {
/* 197 */       return this.sysUserMapper.queryRoleUserIsUse(data);
/*     */     } catch (Exception e) {
/* 199 */       throw new ServiceException(e.getMessage(), e, 400);
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> getUserInfo(Map<String, Object> params) throws ServiceException
/*     */   {
/* 205 */     return this.sysUserMapper.getUserInfo(params);
/*     */   }
/*     */   
/*     */   public BaseMapper<SysUser, Long> getMapper()
/*     */   {
/* 210 */     return this.sysUserMapper;
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysUserServiceImpl.class

 */