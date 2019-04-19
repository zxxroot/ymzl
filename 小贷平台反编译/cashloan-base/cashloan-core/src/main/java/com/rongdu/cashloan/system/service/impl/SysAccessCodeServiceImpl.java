/*     */ package com.rongdu.cashloan.system.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.system.domain.SysAccessCode;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.cashloan.system.mapper.SysAccessCodeMapper;
import com.rongdu.cashloan.system.model.SysAccessCodeModel;
import com.rongdu.cashloan.system.service.SysAccessCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
/*     */ @Service("sysAccessCodeService")
/*     */ public class SysAccessCodeServiceImpl
/*     */   extends BaseServiceImpl<SysAccessCode, Long>
/*     */   implements SysAccessCodeService
/*     */ {
/*     */   @Resource
/*     */   private SysAccessCodeMapper sysAccessCodeMapper;
/*     */   
/*     */   public BaseMapper<SysAccessCode, Long> getMapper()
/*     */   {
/*  40 */     return this.sysAccessCodeMapper;
/*     */   }
/*     */   
/*     */   public Page<SysAccessCodeModel> listAccessCodeModel(Map<String, Object> params, int currentPage, int pageSize)
/*     */   {
/*  45 */     PageHelper.startPage(currentPage, pageSize);
/*  46 */     List<SysAccessCodeModel> list = this.sysAccessCodeMapper.listAccessCodeModel(params);
/*  47 */     if ((list != null) && (list.size() > 0)) {
/*  48 */       for (int i = 0; i < list.size(); i++) {
/*  49 */         SysAccessCodeModel code = new SysAccessCodeModel();
/*  50 */         code.setState(((SysAccessCodeModel)list.get(i)).getState());
/*  51 */         ((SysAccessCodeModel)list.get(i)).setStateStr(code.getStateStr());
/*     */       }
/*     */     }
/*  54 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public int save(SysAccessCode accessCode, String time)
/*     */   {
/*  59 */     Date exceedTime = null;
/*  60 */     Calendar ca = Calendar.getInstance();
/*  61 */     Date now = ca.getTime();
/*  62 */     String str; switch ((str = time).hashCode()) {case 1537:  if (str.equals("01")) break; break; case 1538:  if (str.equals("02")) {} break; case 1539:  if (str.equals("03")) {} break; case 1540:  if (str.equals("04")) {} break; case 1541:  if (str.equals("05")) {} break; case 1542:  if (str.equals("06")) {} break; case 1543:  if (str.equals("07")) {} break; case 1544:  if (!str.equals("08")) {
/*  64 */         ca.add(11, 2);
/*  65 */         exceedTime = ca.getTime();
/*     */         
/*  68 */         ca.add(11, 12);
/*  69 */         exceedTime = ca.getTime();
/*     */         
/*  72 */         ca.add(5, 1);
/*  73 */         exceedTime = ca.getTime();
/*     */         
/*  76 */         ca.add(5, 2);
/*  77 */         exceedTime = ca.getTime();
/*     */         
/*  80 */         ca.add(5, 7);
/*  81 */         exceedTime = ca.getTime();
/*     */         
/*  84 */         ca.add(5, 30);
/*  85 */         exceedTime = ca.getTime();
/*     */         
/*  88 */         ca.add(5, 90);
/*  89 */         exceedTime = ca.getTime();
/*     */       }
/*     */       else {
/*  92 */         ca.add(5, 180);
/*  93 */         exceedTime = ca.getTime(); }
/*     */       break; }
/*     */     label333:
/*  96 */     accessCode.setExceedTime(exceedTime);
/*  97 */     accessCode.setCreateTime(now);
/*  98 */     accessCode.setState("10");
/*  99 */     return this.sysAccessCodeMapper.save(accessCode);
/*     */   }
/*     */   
/*     */   public int update(SysAccessCode ac, String time)
/*     */   {
/* 104 */     Date exceedTime = null;
/* 105 */     Calendar ca = Calendar.getInstance();
/* 106 */     ca.setTime(ac.getCreateTime());
/* 107 */     String str; switch ((str = time).hashCode()) {case 1537:  if (str.equals("01")) break; break; case 1538:  if (str.equals("02")) {} break; case 1539:  if (str.equals("03")) {} break; case 1540:  if (str.equals("04")) {} break; case 1541:  if (str.equals("05")) {} break; case 1542:  if (str.equals("06")) {} break; case 1543:  if (str.equals("07")) {} break; case 1544:  if (!str.equals("08")) {
/* 109 */         ca.add(11, 2);
/* 110 */         exceedTime = ca.getTime();
/*     */         
/* 112 */         ca.add(11, 12);
/*     */         
/* 114 */         ca.add(5, 1);
/* 115 */         exceedTime = ca.getTime();
/*     */         
/* 118 */         ca.add(5, 2);
/* 119 */         exceedTime = ca.getTime();
/*     */         
/* 122 */         ca.add(5, 7);
/* 123 */         exceedTime = ca.getTime();
/*     */         
/* 126 */         ca.add(5, 30);
/* 127 */         exceedTime = ca.getTime();
/*     */         
/* 130 */         ca.add(5, 90);
/* 131 */         exceedTime = ca.getTime();
/*     */       }
/*     */       else {
/* 134 */         ca.add(5, 180);
/* 135 */         exceedTime = ca.getTime(); }
/*     */       break; }
/*     */     label321:
/* 138 */     ac.setExceedTime(exceedTime);
/* 139 */     return this.sysAccessCodeMapper.update(ac);
/*     */   }
/*     */   
/*     */   public int countCode(long sysUserId, String code)
/*     */   {
/* 144 */     Map<String, Object> data = new HashMap();
/* 145 */     data.put("sysUserId", Long.valueOf(sysUserId));
/* 146 */     data.put("code", code);
/* 147 */     return this.sysAccessCodeMapper.countCode(data);
/*     */   }
/*     */   
/*     */   public List<SysAccessCode> listSysAccessCode(Long sysUserId)
/*     */   {
/* 152 */     return this.sysAccessCodeMapper.listSysAccessCode(sysUserId);
/*     */   }
/*     */   
/*     */   public SysAccessCode findSysAccessCode(Map<String, Object> map)
/*     */   {
/* 157 */     return this.sysAccessCodeMapper.findSysAccessCode(map);
/*     */   }
/*     */   
/*     */   public int updateState(SysAccessCode ac)
/*     */   {
/* 162 */     return this.sysAccessCodeMapper.update(ac);
/*     */   }
/*     */   
/*     */   public List<SysUser> listUserName()
/*     */   {
/* 167 */     return this.sysAccessCodeMapper.listUserName();
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\service\impl\SysAccessCodeServiceImpl.class

 */