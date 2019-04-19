/*     */ package com.rongdu.creditrank.cr.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.rongdu.cashloan.core.common.mapper.BaseMapper;
/*     */ import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
/*     */ import com.rongdu.creditrank.cr.domain.Info;
/*     */ import com.rongdu.creditrank.cr.mapper.InfoMapper;
/*     */ import com.rongdu.creditrank.cr.model.InfoModel;
/*     */ import com.rongdu.creditrank.cr.service.InfoService;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ @Service("infoService")
/*     */ public class InfoServiceImpl
/*     */   extends BaseServiceImpl<Info, Long>
/*     */   implements InfoService
/*     */ {
/*  40 */   private static final Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);
/*     */   
/*     */ 
/*     */   @Resource
/*     */   private InfoMapper infoMapper;
/*     */   
/*     */ 
/*     */ 
/*     */   public BaseMapper<Info, Long> getMapper()
/*     */   {
/*  50 */     return this.infoMapper;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Info findByTbNid(String tbNid)
/*     */   {
/*  58 */     return this.infoMapper.findByTbNid(tbNid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int save(String tbNid, String tbName, String detail)
/*     */   {
/*  66 */     Info info = new Info();
/*  67 */     info.setTbNid(tbNid);
/*  68 */     info.setTbName(tbName);
/*  69 */     info.setDetail(detail);
/*  70 */     info.setState("10");
/*  71 */     info.setAddTime(new Date());
/*  72 */     return this.infoMapper.save(info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Page<InfoModel> page(Map<String, Object> secreditrankhMap, int current, int pageSize)
/*     */   {
/*  81 */     PageHelper.startPage(current, pageSize);
/*  82 */     List<InfoModel> list = this.infoMapper.listSelect(secreditrankhMap);
/*  83 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int updateSelective(Map<String, Object> updateMap)
/*     */   {
/*  91 */     return this.infoMapper.updateSelective(updateMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Info> listSelective(Map<String, Object> map)
/*     */   {
/*  99 */     return this.infoMapper.listSelective(map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Map<String, Object>> findTable()
/*     */   {
/* 106 */     List<Map<String, Object>> list = this.infoMapper.findTable();
/* 107 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Map<String, Object>> findColumnByName(Map<String, Object> map)
/*     */   {
/* 114 */     List<Map<String, Object>> list = this.infoMapper.findColumnByName(map);
/* 115 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Info findByPrimary(long id)
/*     */   {
/* 123 */     return (Info)this.infoMapper.findByPrimary(Long.valueOf(id));
/*     */   }
/*     */ }
