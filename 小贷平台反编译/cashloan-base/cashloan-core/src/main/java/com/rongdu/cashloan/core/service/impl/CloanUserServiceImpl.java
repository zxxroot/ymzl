/*     */ package com.rongdu.cashloan.core.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.cashloan.core.domain.User;
/*     */ import com.rongdu.cashloan.core.mapper.UserMapper;
/*     */ import com.rongdu.cashloan.core.model.CloanUserModel;
/*     */ import com.rongdu.cashloan.core.service.CloanUserService;
/*     */ import com.rongdu.cashloan.system.mapper.SysDictDetailMapper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
/*     */ import tool.util.DateUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("cloanUserService")
/*     */ public class CloanUserServiceImpl
/*     */   extends BaseServiceImpl<User, Long>
/*     */   implements CloanUserService
/*     */ {
/*  42 */   private static final Logger logger = LoggerFactory.getLogger(CloanUserServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   @Resource
/*     */   private SysDictDetailMapper sysDictDetailMapper;
/*     */   
/*     */   public BaseMapper<User, Long> getMapper()
/*     */   {
/*  51 */     return this.userMapper;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<CloanUserModel> listUser(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  57 */     PageHelper.startPage(currentPage, pageSize);
/*  58 */     List<CloanUserModel> list = this.userMapper.listModel(params);
/*  59 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List listUserExport(Map<String, Object> params)
/*     */   {
/*  65 */     List<CloanUserModel> list = this.userMapper.listModel(params);
/*     */     
/*  67 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public CloanUserModel getModelById(Long id)
/*     */   {
/*  73 */     CloanUserModel model = this.userMapper.getModel(id);
/*  74 */     return model;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Map<String, Object>> findAllDic()
/*     */   {
/*  80 */     List<Map<String, Object>> result = new ArrayList();
/*  81 */     List<Map<String, Object>> list = this.userMapper.queryAllDic();
/*  82 */     if ((list != null) && (!list.isEmpty())) {
/*  83 */       for (Map<String, Object> o : list) {
/*  84 */         Map<String, Object> fmap = new HashMap();
/*  85 */         String typeCode = o.get("typeCode").toString();
/*  86 */         List<Map<String, Object>> zlist = new ArrayList();
/*  87 */         if (!result.isEmpty()) {
/*  88 */           boolean flag = false;
/*  89 */           for (Map<String, Object> r : result) {
/*  90 */             if (r.containsKey(typeCode)) {
/*  91 */               flag = true;
/*  92 */               zlist = (List)r.get(typeCode);
/*  93 */               break;
/*     */             }
/*     */           }
/*  96 */           Map<String, Object> zmap = new HashMap();
/*  97 */           zmap.put(o.get("itemCode").toString(), o.get("itemValue").toString());
/*     */           
/*     */ 
/*     */ 
/* 101 */           if (flag) {
/* 102 */             zlist.add(zmap);
/*     */           } else {
/* 104 */             fmap.put(typeCode, zlist);
/* 105 */             result.add(fmap);
/*     */           }
/*     */         } else {
/* 108 */           Map<String, Object> zmap = new HashMap();
/* 109 */           zmap.put(o.get("itemCode").toString(), o.get("itemValue").toString());
/*     */           
/*     */ 
/* 112 */           zlist.add(zmap);
/* 113 */           fmap.put(typeCode, zlist);
/* 114 */           result.add(fmap);
/*     */         }
/*     */       }
/*     */     }
/* 118 */     return result;
/*     */   }
/*     */   
/*     */   public boolean updateByUuid(Map<String, Object> paramMap)
/*     */   {
/* 123 */     int result = this.userMapper.updateByUuid(paramMap);
/* 124 */     if (result > 0) {
/* 125 */       return true;
/*     */     }
/* 127 */     return false;
/*     */   }
/*     */   
/*     */   public User findByPhone(String phone)
/*     */   {
/* 132 */     return this.userMapper.findByLoginName(phone);
/*     */   }
/*     */   
/*     */   public long todayCount()
/*     */   {
/* 137 */     return this.userMapper.todayCount();
/*     */   }
/*     */   
/*     */   public void modify(String loginName)
/*     */   {
/* 142 */     Map<String, Object> map = new HashMap();
/* 143 */     map.put("loginName", loginName);
/* 144 */     User user = (User)this.userMapper.findSelective(map);
/* 145 */     if (user != null) {
/* 146 */       Map<String, Object> paramMap = new HashMap();
/* 147 */       paramMap.put("id", user.getId());
/* 148 */       paramMap.put("loginTime", DateUtil.getNow());
/* 149 */       this.userMapper.updateSelective(paramMap);
/*     */     }
/*     */   }
/*     */ }
