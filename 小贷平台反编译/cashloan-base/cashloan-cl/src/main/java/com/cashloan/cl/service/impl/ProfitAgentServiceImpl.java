/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */ import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.cashloan.cl.domain.ProfitAgent;
import com.cashloan.cl.mapper.ProfitAgentMapper;
import com.cashloan.cl.model.ManageAgentListModel;
import com.cashloan.cl.service.ProfitAgentService;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.exception.ServiceException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.domain.User;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.core.mapper.UserMapper;
import com.rongdu.cashloan.system.domain.SysAccessCode;
import com.rongdu.cashloan.system.domain.SysRole;
import com.rongdu.cashloan.system.domain.SysUser;
import com.rongdu.cashloan.system.mapper.SysAccessCodeMapper;
import com.rongdu.cashloan.system.mapper.SysRoleMapper;
import com.rongdu.cashloan.system.mapper.SysUserMapper;
import com.rongdu.cashloan.system.security.authentication.encoding.PasswordEncoder;
import com.rongdu.cashloan.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tool.util.DateUtil;
import tool.util.StringUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
/*     */ @Service("profitAgentService")
/*     */ public class ProfitAgentServiceImpl
/*     */   extends BaseServiceImpl<ProfitAgent, Long>
/*     */   implements ProfitAgentService
/*     */ {
/*  45 */   private static final Logger logger = LoggerFactory.getLogger(ProfitAgentServiceImpl.class);
/*     */   
/*     */   @Resource
/*     */   private ProfitAgentMapper profitAgentMapper;
/*     */   @Resource
/*     */   private UserMapper userMapper;
/*     */   @Resource
/*     */   private SysUserMapper sysUserMapper;
/*     */   @Resource
/*     */   private UserBaseInfoMapper userBaseInfoMapper;
/*     */   @Resource
/*     */   private SysUserService sysUserService;
/*     */   @Resource
/*     */   private PasswordEncoder passwordEncoder;
/*     */   @Resource
/*     */   private SysRoleMapper sysRoleMapper;
/*     */   @Resource
/*     */   private SysAccessCodeMapper sysAccessCodeMapper;
/*     */   
/*     */   public BaseMapper<ProfitAgent, Long> getMapper()
/*     */   {
/*  66 */     return this.profitAgentMapper;
/*     */   }
/*     */   
/*     */   public int pass(int isUse, long id)
/*     */   {
/*  71 */     Map<String, Object> result = new HashMap();
/*  72 */     result.put("id", Long.valueOf(id));
/*  73 */     result.put("isUse", Integer.valueOf(isUse));
/*  74 */     return this.profitAgentMapper.updateSelective(result);
/*     */   }
/*     */   
/*     */   public int rankUp(long id, long userId)
/*     */   {
/*  79 */     double levelOne = Double.valueOf(Global.getValue("level_one")).doubleValue();
/*  80 */     Map<String, Object> result = new HashMap();
/*  81 */     result.put("id", Long.valueOf(id));
/*  82 */     ProfitAgent agent = (ProfitAgent)this.profitAgentMapper.findByPrimary(Long.valueOf(id));
/*  83 */     int msg = 0;
/*  84 */     if (agent != null) {
/*  85 */       result.put("userId", Long.valueOf(userId));
/*  86 */       result.put("level", Integer.valueOf(1));
/*  87 */       result.put("rate", Double.valueOf(levelOne / 100.0D));
/*  88 */       result.put("applyTime", new Date());
/*  89 */       result.put("oldRate", Double.valueOf(agent.getRate().doubleValue() / 100.0D));
/*  90 */       msg = this.profitAgentMapper.updateSelective(result);
/*  91 */       if (msg > 0) {
/*  92 */         User user = new User();
/*  93 */         user.setId(Long.valueOf(userId));
/*  94 */         user.setLevel(Integer.valueOf(1));
/*  95 */         msg = this.userMapper.updateLevel(user);
/*     */       }
/*     */     }
/*  98 */     return msg;
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<ManageAgentListModel> findAgentList(String userName, int current, int pageSize)
/*     */   {
/* 104 */     PageHelper.startPage(current, pageSize);
/* 105 */     Map<String, Object> map = new HashMap();
/* 106 */     if (StringUtil.isNotBlank(userName)) {
/* 107 */       map.put("userName", "%" + userName + "%");
/*     */     }
/* 109 */     List<ManageAgentListModel> list = this.profitAgentMapper.findAgentList(map);
/* 110 */     for (ManageAgentListModel manageAgentListModel : list) {
/* 111 */       manageAgentListModel.setRate(Double.valueOf(manageAgentListModel.getRate().doubleValue() * 100.0D));
/*     */     }
/* 113 */     return (Page)list;
/*     */   }
/*     */   
/*     */   public Page<User> findUserLevel(String userName, int current, int pageSize)
/*     */   {
/* 118 */     PageHelper.startPage(current, pageSize);
/* 119 */     Map<String, Object> map = new HashMap();
/* 120 */     if (StringUtil.isNotBlank(userName)) {
/* 121 */       map.put("loginName", "%" + userName + "%");
/*     */     }
/* 123 */     List<User> list = this.userMapper.findUserLevel(map);
/* 124 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */   public int freezeAgent(long userId, Date updateTime)
/*     */   {
/* 130 */     Map<String, Object> map = new HashMap();
/* 131 */     map.put("userId", Long.valueOf(userId));
/* 132 */     ProfitAgent pa = (ProfitAgent)this.profitAgentMapper.findSelective(map);
/* 133 */     if (StringUtil.isNotBlank(pa)) {
/* 134 */       map.put("id", pa.getId());
/* 135 */       map.put("level", Integer.valueOf(3));
/* 136 */       map.put("rate", Double.valueOf(0.05D));
/* 137 */       map.put("isUse", Integer.valueOf(20));
/* 138 */       map.put("updateTime", updateTime);
/* 139 */       int msg = this.profitAgentMapper.updateSelective(map);
/* 140 */       if (msg > 0) {
/* 141 */         User user = new User();
/* 142 */         user.setId(Long.valueOf(userId));
/* 143 */         user.setLevel(Integer.valueOf(3));
/* 144 */         msg = this.userMapper.updateLevel(user);
/*     */       }
/* 146 */       if ((msg > 0) && (pa.getLevel().intValue() == 1)) {
/* 147 */         User user = (User)this.userMapper.findByPrimary(Long.valueOf(userId));
/* 148 */         Map<String, Object> result = new HashMap();
/* 149 */         result.put("userName", user.getLoginName());
/* 150 */         SysUser sys = (SysUser)this.sysUserMapper.findSelective(result);
/* 151 */         if (sys != null) {
/* 152 */           result = new HashMap();
/* 153 */           result.put("status", Byte.valueOf((byte)1));
/* 154 */           result.put("id", sys.getId());
/* 155 */           this.sysUserMapper.updateState(result);
/*     */         }
/*     */       }
        return msg;
/*     */     } else {
/* 159 */       return 0; }
/*     */   }
/*     */   
/*     */ 
/*     */   public int saveOne(long userId, Date updateTime)
/*     */   {
/* 167 */     User user = (User)this.userMapper.findByPrimary(Long.valueOf(userId));
/* 168 */     if (StringUtil.isBlank(user)) {
/* 169 */       return 0;
/*     */     }
/* 171 */     Map<String, Object> result = new HashMap();
/* 172 */     result.put("userId", user.getId());
/* 173 */     UserBaseInfo ubi = (UserBaseInfo)this.userBaseInfoMapper.findSelective(result);
/* 174 */     if (StringUtil.isBlank(ubi)) {
/* 175 */       return 0;
/*     */     }
/*     */     
/* 178 */     double levelOne = Double.valueOf(Global.getValue("level_one")).doubleValue();
/* 179 */     result.put("userId", Long.valueOf(userId));
/* 180 */     ProfitAgent pa = (ProfitAgent)this.profitAgentMapper.findSelective(result);
/* 181 */     result = new HashMap();
/* 182 */     result.put("createTime", DateUtil.getNow());
/* 183 */     int msg; if (StringUtil.isBlank(pa)) {
/* 184 */       pa = new ProfitAgent();
/* 185 */       pa.setLevel(Integer.valueOf(1));
/* 186 */       pa.setUserId(Long.valueOf(userId));
/* 187 */       pa.setRate(Double.valueOf(levelOne / 100.0D));
/* 188 */       pa.setCreateTime(new Date());
/* 189 */       pa.setUpdateTime(new Date());
/* 190 */       pa.setIsUse(Integer.valueOf(10));
/* 191 */       msg = this.profitAgentMapper.save(pa);
/* 192 */       if (msg > 0) {
/* 193 */         sys(user, ubi);
/*     */       }
/*     */     } else {
/* 196 */       result = new HashMap();
/* 197 */       result.put("level", Integer.valueOf(1));
/* 198 */       result.put("leaderId", Integer.valueOf(0));
/* 199 */       result.put("rate", Double.valueOf(levelOne / 100.0D));
/* 200 */       result.put("isUse", Integer.valueOf(10));
/* 201 */       result.put("id", pa.getId());
/* 202 */       result.put("updateTime", updateTime);
/* 203 */       msg = this.profitAgentMapper.updateSelective(result);
/* 204 */       if (msg > 0) {
/* 205 */         sys(user, ubi);
/*     */       }
/*     */     }
/* 208 */     if (msg > 0) {
/* 209 */       user = new User();
/* 210 */       user.setId(Long.valueOf(userId));
/* 211 */       user.setLevel(Integer.valueOf(1));
/* 212 */       msg = this.userMapper.updateLevel(user);
/*     */     }
/* 214 */     return msg;
/*     */   }
/*     */   
/*     */ 
/*     */   public int saveTwo(long userId, String leaderId, String rate, Date updateTime)
/*     */   {
/* 220 */     User user = (User)this.userMapper.findByPrimary(Long.valueOf(userId));
/* 221 */     if (StringUtil.isBlank(user)) {
/* 222 */       return 0;
/*     */     }
/* 224 */     Map<String, Object> result = new HashMap();
/* 225 */     result.put("userId", Long.valueOf(userId));
/* 226 */     ProfitAgent pa = (ProfitAgent)this.profitAgentMapper.findSelective(result);
/* 227 */     result.put("createTime", DateUtil.getNow());
/* 228 */     int msg;
if (StringUtil.isBlank(pa)) {
/* 229 */       pa = new ProfitAgent();
/* 230 */       pa.setLevel(Integer.valueOf(2));
/* 231 */       pa.setUserId(Long.valueOf(userId));
/* 232 */       pa.setRate(Double.valueOf(Double.parseDouble(rate) / 100.0D));
/* 233 */       pa.setLeaderId(Long.valueOf(Long.parseLong(leaderId)));
/* 234 */       pa.setCreateTime(new Date());
/* 235 */       pa.setUpdateTime(new Date());
/* 236 */       pa.setIsUse(Integer.valueOf(10));
/* 237 */       msg = this.profitAgentMapper.save(pa);
/*     */     } else {
/* 239 */       result = new HashMap();
/* 240 */       result.put("level", Integer.valueOf(2));
/* 241 */       result.put("leaderId", Long.valueOf(Long.parseLong(leaderId)));
/* 242 */       result.put("rate", Double.valueOf(Double.parseDouble(rate) / 100.0D));
/* 243 */       result.put("isUse", Integer.valueOf(10));
/* 244 */       result.put("id", pa.getId());
/* 245 */       result.put("updateTime", updateTime);
/* 246 */       msg = this.profitAgentMapper.updateSelective(result);
/*     */     }
/* 248 */     if (msg > 0) {
/* 249 */       user = new User();
/* 250 */       user.setId(Long.valueOf(userId));
/* 251 */       user.setLevel(Integer.valueOf(2));
/* 252 */       msg = this.userMapper.updateLevel(user);
/*     */     }
/* 254 */     return msg;
/*     */   }
/*     */   
/*     */   public void sys(User user, UserBaseInfo ubi) {
/* 258 */     Map<String, Object> sysUserMap = new HashMap();
/* 259 */     sysUserMap.put("userName", user.getLoginName());
/* 260 */     SysUser sysUser = (SysUser)this.sysUserMapper.findSelective(sysUserMap);
/*     */     
/* 262 */     if (StringUtil.isBlank(sysUser)) {
/* 263 */       Map<String, Object> roleMap = new HashMap();
/* 264 */       roleMap.put("nid", "agent");
/* 265 */       SysRole role = (SysRole)this.sysRoleMapper.findSelective(roleMap);
/* 266 */       if (role != null) {
/* 267 */         sysUser = new SysUser();
/* 268 */         sysUser.setUserName(user.getLoginName());
/* 269 */         sysUser.setName(ubi.getRealName());
/* 270 */         sysUser.setPhone(user.getLoginName());
/* 271 */         sysUser.setStatus(Byte.valueOf((byte)0));
/* 272 */         sysUser.setAddTime(new Date());
/* 273 */         sysUser.setPassword(this.passwordEncoder.encodePassword("123456"));
/*     */         try
/*     */         {
/* 276 */           this.sysUserService.addUser(sysUser, role.getId().toString());
/*     */         } catch (ServiceException e) {
/* 278 */           logger.error(e.toString(), e);
/*     */         }
/*     */         
/* 281 */         sysUser = (SysUser)this.sysUserMapper.findSelective(sysUserMap);
/* 282 */         String accessCodeAble = Global.getValue("access_code_able");
/* 283 */         if (accessCodeAble.equals("10")) {
/* 284 */           SysAccessCode accessCode = new SysAccessCode(sysUser.getId().longValue(), "123456", 
/* 285 */             "10", DateUtil.rollYear(DateUtil.getNow(), 10));
/* 286 */           this.sysAccessCodeMapper.save(accessCode);
/*     */         }
/*     */       }
/*     */     }
/* 290 */     else if (sysUser.getStatus().byteValue() != 0) {
/* 291 */       Map<String, Object> map = new HashMap();
/* 292 */       map.put("status", Byte.valueOf((byte)0));
/* 293 */       map.put("id", sysUser.getId());
/* 294 */       this.sysUserMapper.updateState(map);
/*     */     }
/*     */   }
/*     */ }
