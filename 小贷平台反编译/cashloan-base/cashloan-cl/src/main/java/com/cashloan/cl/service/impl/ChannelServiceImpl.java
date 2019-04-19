/*     */ package com.cashloan.cl.service.impl;
/*     */ 
/*     */

import com.cashloan.cl.mapper.ChannelMapper;
import com.cashloan.cl.model.ChannelBorrowModel;
import com.cashloan.cl.model.KeyValue;
import com.cashloan.cl.model.UserAuthModel;
import com.cashloan.cl.service.ChannelService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.cashloan.cl.domain.Channel;
import com.cashloan.cl.mapper.ChannelSettlementMapper;
import com.cashloan.cl.mapper.UserAuthMapper;
import com.cashloan.cl.model.ChannelCountModel;
import com.cashloan.cl.model.ChannelListModel;
import com.cashloan.cl.model.ChannelStaffCountModel;
import com.cashloan.cl.model.ChannelStaffModel;
import com.cashloan.cl.service.ChannelContactService;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.DateUtil;
import com.rongdu.cashloan.core.common.util.RC4;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
/*     */ @Service("channelService")
/*     */ public class ChannelServiceImpl
/*     */   extends BaseServiceImpl<Channel, Long>
/*     */   implements ChannelService
/*     */ {
/*     */   @Resource
/*     */   private ChannelMapper channelMapper;
/*     */   @Resource
/*     */   private ChannelSettlementMapper channelSettlementMapper;
/*     */   @Resource
/*     */   private UserAuthMapper userAuthMapper;
/*     */   @Resource
/*     */   private ChannelContactService channelContactService;
/*     */   
/*     */   public BaseMapper<Channel, Long> getMapper()
/*     */   {
/*  58 */     return this.channelMapper;
/*     */   }
/*     */   
/*     */   public Map<String, Object> save(Map<String, Object> param, String user, String code, String name)
/*     */   {
/*  63 */     Map<String, Object> result = new HashMap();
/*     */     
/*  65 */     int channelId = this.channelMapper.selectChannelId(code);
/*  66 */     if (channelId > 0) {
/*  67 */       result.put("code", Integer.valueOf(400));
/*  68 */       result.put("msg", "渠道编号已存在");
/*  69 */       return result;
/*     */     }
/*  71 */     Channel channel = new Channel();
/*  72 */     Date curDate = new Date();
/*  73 */     channel.setCode(code);
/*  74 */     channel.setName(name);
/*  75 */     channel.setCreateTime(curDate);
/*  76 */     channel.setUpdateTime(curDate);
/*  77 */     channel.setUpdateUser(user);
/*     */     
/*  79 */     channel.setInviteURL("h5/invite.jsp?channelCode=" + code);
/*  80 */     channel.setLoginURL("channel/index.html?c_id=" + code + "&c=" + RC4.toSerialCode(code));
/*     */     
/*  82 */     if ((param != null) && (!param.equals("")))
/*     */     {
/*  84 */       if (param.get("settlementSign") != null) {
/*  85 */         channel.setSettlementSign(Integer.valueOf(param.get("settlementSign").toString()).intValue());
/*     */       }
/*     */       
/*  88 */       if (param.get("settlement") != null) {
/*  89 */         channel.setSettlement(param.get("settlement").toString());
/*     */       }
/*     */       
/*  92 */       if (param.get("channelGrade") != null) {
/*  93 */         channel.setChannelGrade(Integer.valueOf(param.get("channelGrade").toString()).intValue());
/*     */       }
/*     */       
/*  96 */       if (param.get("channelStage") != null) {
/*  97 */         channel.setChannelStage(Integer.valueOf(param.get("channelStage").toString()).intValue());
/*     */       }
/*     */       
/* 100 */       if (param.get("remark") != null) {
/* 101 */         channel.setRemark(param.get("remark").toString());
/*     */       }
/*     */       
/* 104 */       if ((param.get("scaling") != null) && (NumberUtils.isNumber(param.get("scaling").toString()))) {
/* 105 */         channel.setScaling(new BigDecimal(param.get("scaling").toString()));
/*     */       }
/*     */     }
/*     */     
/* 109 */     channel.setState("10");
/* 110 */     int channelValue = this.channelMapper.save(channel);
/*     */     
/* 112 */     if (channelValue > 0) {
/* 113 */       result.put("code", Integer.valueOf(200));
/* 114 */       result.put("msg", "操作成功");
/* 115 */       return result;
/*     */     }
/* 117 */     result.put("code", Integer.valueOf(400));
/* 118 */     result.put("msg", "操作失败");
/* 119 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update(Long id, String name, Map<String, Object> param)
/*     */   {
/* 125 */     Channel channel = (Channel)this.channelMapper.findByPrimary(id);
/* 126 */     if ((param != null) && (channel != null)) {
/* 127 */       channel.setId(id);
/* 128 */       channel.setUpdateTime(new Date());
/* 129 */       channel.setUpdateUser(name);
/*     */       
/* 131 */       if (param.get("name") != null) {
/* 132 */         channel.setName(param.get("name").toString());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 139 */       if (param.get("channelProviderId") != null) {
/* 140 */         channel.setChannelProviderId(Long.valueOf(param.get("channelProviderId").toString()));
/*     */       }
/*     */       
/* 143 */       if (param.get("firstClassResponsiblePerson") != null) {
/* 144 */         channel.setFirstClassResponsiblePerson(param.get("firstClassResponsiblePerson").toString());
/*     */       }
/*     */       
/* 147 */       if (param.get("twoLevelResponsiblePerson") != null) {
/* 148 */         channel.setTwoLevelResponsiblePerson(param.get("twoLevelResponsiblePerson").toString());
/*     */       }
/*     */       
/* 151 */       if (param.get("settlementSign") != null) {
/* 152 */         channel.setSettlementSign(Integer.valueOf(param.get("settlementSign").toString()).intValue());
/*     */       }
/*     */       
/* 155 */       if (param.get("settlement") != null) {
/* 156 */         channel.setSettlement(param.get("settlement").toString());
/*     */       }
/*     */       
/* 159 */       if (param.get("channelGrade") != null) {
/* 160 */         channel.setChannelGrade(Integer.valueOf(param.get("channelGrade").toString()).intValue());
/*     */       }
/*     */       
/* 163 */       if (param.get("channelStage") != null) {
/* 164 */         channel.setChannelStage(Integer.valueOf(param.get("channelStage").toString()).intValue());
/*     */       }
/*     */       
/* 167 */       if (param.get("remark") != null) {
/* 168 */         channel.setRemark(param.get("remark").toString());
/*     */       }
/*     */       
/* 171 */       if (param.get("scaling") != null) {
/* 172 */         channel.setScaling(new BigDecimal(param.get("scaling").toString()));
/*     */       }
/* 174 */       int result = this.channelMapper.update(channel);
/* 175 */       if (result > 0) {
/* 176 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 180 */     return false;
/*     */   }
/*     */   
/*     */   public long findIdByCode(String code)
/*     */   {
/* 185 */     Map<String, Object> paramMap = new HashMap();
/* 186 */     paramMap.put("code", code);
/* 187 */     return this.channelMapper.findIdSelective(paramMap);
/*     */   }
/*     */   
/*     */   public Channel findByCode(String code)
/*     */   {
/* 192 */     Map<String, Object> paramMap = new HashMap();
/* 193 */     paramMap.put("code", code);
/* 194 */     return this.channelMapper.findSelective(paramMap);
/*     */   }
/*     */   
/*     */   public Page<ChannelListModel> page(int current, int pageSize, Map<String, Object> searchMap)
/*     */   {
/* 199 */     PageHelper.startPage(current, pageSize);
/* 200 */     Page<ChannelListModel> page = (Page)this.channelMapper.page(searchMap);
/* 201 */     return page;
/*     */   }
/*     */   
/*     */   public Page<Channel> pageChannel(int current, int pageSize, Map<String, Object> searchMap)
/*     */   {
/* 206 */     PageHelper.startPage(current, pageSize);
/* 207 */     Page<Channel> page = (Page)this.channelMapper.listMyChannel1(searchMap);
/* 208 */     return page;
/*     */   }
/*     */   
/*     */   public Page<ChannelCountModel> channelUserList(int current, int pageSize, Map<String, Object> searchMap)
/*     */   {
/* 213 */     PageHelper.startPage(current, pageSize);
/* 214 */     Page<ChannelCountModel> page = this.channelMapper.channelUserList(searchMap);
/* 215 */     return page;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Channel> listChannel()
/*     */   {
/* 221 */     return this.channelMapper.listChannel();
/*     */   }
/*     */   
/*     */ 
/*     */   public Page<Channel> listChannel1(int current, int pageSize, Map<String, Object> searchMap)
/*     */   {
/* 227 */     PageHelper.startPage(current, pageSize);
/* 228 */     Page<Channel> page = (Page)this.channelMapper.listMyChannel1(searchMap);
/* 229 */     return page;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Channel> listChannelWithoutApp()
/*     */   {
/* 235 */     return this.channelMapper.listChannelWithoutApp();
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> channelUserCount(Map<String, Object> paramMap, int current, int pageSize)
/*     */   {
/* 240 */     PageHelper.startPage(current, pageSize);
/* 241 */     Page<Map<String, Object>> result = (Page)this.channelMapper.countOne(paramMap);
/* 242 */     List<Map<String, Object>> one = result.getResult();
/*     */     
/*     */ 
/* 245 */     for (Map<String, Object> map : one) {
/* 246 */       if ((paramMap.get("name") != null) && (paramMap.get("name").equals(map.get("name")))) {
/* 247 */         paramMap.put("channelId", map.get("channelId"));
/* 248 */         break;
/*     */       }
/*     */     }
/* 251 */     List<Map<String, Object>> two = this.channelMapper.countTwo(paramMap);
/* 252 */     Object three = this.channelMapper.countThree(paramMap);
/* 253 */     List<Map<String, Object>> four = this.channelMapper.countFour(paramMap);
/* 254 */     List<Map<String, Object>> five = this.channelMapper.countFive(paramMap);
/* 255 */     List<Map<String, Object>> six = this.channelMapper.countSix(paramMap);
/* 256 */     List<Map<String, Object>> seven = this.channelMapper.countSeven(paramMap);
/* 257 */     List<Map<String, Object>> eight = this.channelMapper.countEight(paramMap);
/* 258 */     List<Map<String, Object>> nine = this.channelMapper.countNine(paramMap);
/* 259 */     List<Map<String, Object>> ten = this.channelMapper.countTen(paramMap);
/* 260 */     List<Map<String, Object>> eleven = this.channelMapper.countEleven(paramMap);
/* 261 */     List<Map<String, Object>> uv = this.channelMapper.countUV(paramMap);
/* 262 */     for (int i = 0; i < one.size(); i++)
/*     */     {
/*     */ 
/* 265 */       count((Map)one.get(i), two, "registerCount", "countTwo");
/*     */       
/* 267 */       count((Map)one.get(i), (List)three, "borrowMember", "countThree");
/*     */       
/* 269 */       count((Map)one.get(i), four, "borrowCount", "countFour");
/*     */       
/* 271 */       count((Map)one.get(i), five, "borrowAmout", "countFive");
/*     */       
/* 273 */       count((Map)one.get(i), six, "newPayCount", "countSix");
/*     */       
/* 275 */       count((Map)one.get(i), seven, "repeatPayCount", "countSeven");
/*     */       
/* 277 */       count((Map)one.get(i), eight, "payAccount", "countEight");
/*     */       
/* 279 */       count((Map)one.get(i), nine, "payCount", "countNine");
/*     */       
/* 281 */       count((Map)one.get(i), ten, "registeredLoan", "countTen");
/*     */       
/* 283 */       count((Map)one.get(i), eleven, "applyForLoan", "countEleven");
/*     */       
/* 285 */       count((Map)one.get(i), uv, "uv", "countUV");
/*     */     }
/* 287 */     return result;
/*     */   }
/*     */   
/*     */   private void count(Map<String, Object> oneMap, List<Map<String, Object>> listMap, String remark, String keyWord)
/*     */   {
/* 292 */     for (Map<String, Object> map : listMap) {
/* 293 */       if ((map.equals("")) || (map == null)) {
/*     */         break;
/*     */       }
/* 296 */       String s = map.get("channelId").toString();
/* 297 */       if ((s != null) && (!s.equals("")) && (!s.equals("null")) && (s.equals(oneMap.get("channelId")))) {
/* 298 */         oneMap.put(remark, map.get(keyWord) == null ? "0" : map.get(keyWord));
/* 299 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Page<ChannelStaffCountModel> channelCount(Map<String, Object> params, int current, int pageSize)
/*     */     throws ParseException
/*     */   {
/* 307 */     PageHelper.startPage(current, pageSize);
/* 308 */     List<ChannelStaffCountModel> modelList = this.channelMapper.listSysUserByRole(params);
/* 309 */     for (ChannelStaffCountModel model : modelList) {
/* 310 */       long userId = model.getUserId().longValue();
/*     */       
/* 312 */       params.clear();
/* 313 */       params.put("userId", Long.valueOf(userId));
/*     */       
/* 315 */       model.setChannelCount(this.channelMapper.countOrder(params));
/*     */       
/* 317 */       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
/* 318 */       Calendar m = Calendar.getInstance();
/* 319 */       String month = format.format(m.getTime());
/* 320 */       params.put("beginDate", month);
/* 321 */       model.setChannelAddCount(this.channelMapper.countOrder(params));
/*     */     }
/*     */     
/* 324 */     return (Page)modelList;
/*     */   }
/*     */   
/*     */   public ChannelStaffModel channelStaffDetails(Long userId)
/*     */   {
/* 329 */     ChannelStaffModel modelList = this.channelMapper.SysUserDetailsByUserId(userId);
/* 330 */     return modelList;
/*     */   }
/*     */   
/*     */   public List<Channel> relationChannelList(Map<String, Object> param)
/*     */   {
/* 335 */     param.put("state", Integer.valueOf(10));
/* 336 */     List<Channel> channel = this.channelMapper.listSelectiveChannel(param);
/* 337 */     return channel;
/*     */   }
/*     */   
/*     */   public List<Channel> relationChannelListALL(Map<String, Object> param)
/*     */   {
/* 342 */     param.put("state", Integer.valueOf(10));
/* 343 */     List<Channel> channel = this.channelMapper.listSelective(param);
/* 344 */     return channel;
/*     */   }
/*     */   
/*     */   public Map<String, Object> updateChannelById(Long userId, String[] channelList)
/*     */   {
/* 349 */     Map<String, Object> result = new HashMap();
/* 350 */     List<String> list = new ArrayList();
/*     */     
/*     */ 
/* 353 */     ChannelStaffModel modelList = this.channelMapper.SysUserDetailsByUserId(userId);
/* 354 */     if ((modelList == null) || (modelList.getStatus().equals("0"))) {
/* 355 */       result.put("code", Integer.valueOf(400));
/* 356 */       result.put("msg", "渠道员不可修改");
/* 357 */       return result;
/*     */     }
/*     */     
/* 360 */     this.channelMapper.updateByUserId(userId);
/*     */     
/* 362 */     if (("".equals(channelList)) || (channelList.length == 0)) {
/* 363 */       result.put("code", Integer.valueOf(200));
/* 364 */       result.put("msg", "提交成功");
/* 365 */       return result;
/*     */     }
/* 367 */     for (int i = 0; i < channelList.length; i++) {
/* 368 */       list.add(channelList[i]);
/*     */     }
/* 370 */     Map<String, Object> param = new HashMap();
/* 371 */     param.put("userId", modelList.getUserId());
/* 372 */     param.put("linker", modelList.getName());
/* 373 */     param.put("phone", modelList.getPhone());
/* 374 */     param.put("channelList", list);
/* 375 */     this.channelMapper.updateByIdList(param);
/* 376 */     result.put("code", Integer.valueOf(200));
/* 377 */     result.put("msg", "提交成功");
/* 378 */     return result;
/*     */   }
/*     */   
/*     */   public boolean updateState(Map<String, Object> paramMap)
/*     */   {
/* 383 */     int result = this.channelMapper.updateSelective(paramMap);
/* 384 */     if (result > 0) {
/* 385 */       return true;
/*     */     }
/* 387 */     return false;
/*     */   }
/*     */   
/*     */   private int selectChannel(Long id) {
/* 391 */     Map<String, Object> paramMap = new HashMap();
/* 392 */     paramMap.put("id", id);
/* 393 */     paramMap.put("state", Integer.valueOf(10));
/* 394 */     int result = this.channelSettlementMapper.selectChannelState(paramMap);
/* 395 */     if (result > 0) {
/* 396 */       return result;
/*     */     }
/*     */     
/* 399 */     SimpleDateFormat time = new SimpleDateFormat("yyyy-MM");
/* 400 */     Date date = new Date();
/* 401 */     paramMap.put("date", DateUtil.valueOf(time.format(date) + "-01 00:00:00"));
/* 402 */     result = this.channelMapper.selectUserChannel(paramMap);
/* 403 */     return result;
/*     */   }
/*     */   
/*     */   public Channel channelDetails(Long id)
/*     */   {
/* 408 */     Channel channel = (Channel)this.channelMapper.findByPrimary(id);
/* 409 */     return channel;
/*     */   }
/*     */   
/*     */   public List<?> listChannel(Map<String, Object> searchMap)
/*     */   {
/* 414 */     List<ChannelListModel> list = this.channelMapper.page(searchMap);
/* 415 */     return list;
/*     */   }
/*     */   
/*     */   public Page listBorrowModel(Map<String, Object> params, int current, int pageSize)
/*     */   {
/* 420 */     PageHelper.startPage(current, pageSize);
/* 421 */     List<ChannelBorrowModel> list = this.channelMapper.listBorrowModel(params);
/* 422 */     return (Page)list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean updatechannelUV(String code, String equipmentId)
/*     */   {
/* 429 */     Map<String, Object> params = new HashMap();
/* 430 */     params.put("code", code);
/* 431 */     params.put("equipmentId", equipmentId);
/* 432 */     int result = this.channelMapper.selectChannelUV(params);
/* 433 */     if (result > 0) {
/* 434 */       return true;
/*     */     }
/*     */     
/* 437 */     Date date = new Date();
/* 438 */     params.put("date", date);
/* 439 */     result = this.channelMapper.addchannelUV(params);
/* 440 */     if (result > 0) {
/* 441 */       return true;
/*     */     }
/* 443 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Map<String, Object>> statisticsCpa(Map<String, Object> paramMap, int current, int pageSize)
/*     */   {
/* 450 */     PageHelper.startPage(current, pageSize);
/* 451 */     Page<Map<String, Object>> page = (Page)this.channelMapper.listMyChannel2(paramMap);
/*     */     
/* 453 */     List<Map<String, Object>> channel = page.getResult();
/*     */     
/*     */ 
/* 456 */     List<UserAuthModel> userAuthMode = this.userAuthMapper.listUserAuthModel(new HashMap());
/*     */     
/* 458 */     List<String> req = this.channelMapper.userBorrow(paramMap);
/* 459 */     paramMap.put("state", "true");
/*     */     
/* 461 */     List<String> reqSucces = this.channelMapper.userBorrow2(paramMap);
/*     */     
/* 463 */     List<String> userBorrow3 = this.channelMapper.userBorrow3(paramMap);
/*     */     
/* 465 */     List<String> userBorrow4 = this.channelMapper.userBorrow4(paramMap);
/*     */     
/* 467 */     List<String> register = this.channelMapper.userRegister(paramMap);
/*     */     
/*     */ 
/* 470 */     for (Map<String, Object> c : channel)
/*     */     {
/*     */ 
/* 473 */       c.put("shiming", Integer.valueOf(0));
/* 474 */       c.put("zhima", Integer.valueOf(0));
/* 475 */       c.put("taobao", Integer.valueOf(0));
/* 476 */       c.put("bank", Integer.valueOf(0));
/* 477 */       c.put("phone", Integer.valueOf(0));
/* 478 */       c.put("shenq", Integer.valueOf(0));
/* 479 */       c.put("shensucc", Integer.valueOf(0));
/* 480 */       c.put("userBorrow3", Integer.valueOf(0));
/* 481 */       c.put("userBorrow4", Integer.valueOf(0));
/* 482 */       c.put("userNum", Integer.valueOf(0));
/* 483 */       Long channelId = Long.valueOf(c.get("id").toString());
/* 484 */       List<Long> userIDS = this.channelMapper.listMyUser(channelId);
/*     */       
/* 486 */       if ((userIDS != null) && (userIDS.size() > 0))
/*     */       {
/*     */ 
/* 489 */         c.put("userNum", Integer.valueOf(userIDS.size()));
/* 490 */         for (UserAuthModel userAuth : userAuthMode) {
/* 491 */           if (userIDS.contains(userAuth.getUserId())) {
/* 492 */             int count0 = Integer.parseInt(c.get("shiming") == null ? "0" : c.get("shiming").toString());
/* 493 */             int count1 = Integer.parseInt(c.get("zhima") == null ? "0" : c.get("zhima").toString());
/* 494 */             int count2 = Integer.parseInt(c.get("bank") == null ? "0" : c.get("bank").toString());
/* 495 */             int count3 = Integer.parseInt(c.get("phone") == null ? "0" : c.get("phone").toString());
/* 496 */             int count4 = Integer.parseInt(c.get("taobao") == null ? "0" : c.get("taobao").toString());
/*     */             
/* 498 */             if ("30".equals(userAuth.getRealNameState())) {
/* 499 */               c.put("shiming", Integer.valueOf(count0 + 1));
/*     */             }
/*     */             
/* 502 */             if ("30".equals(userAuth.getZhimaState())) {
/* 503 */               c.put("zhima", Integer.valueOf(count1 + 1));
/*     */             }
/*     */             
/* 506 */             if ("30".equals(userAuth.getBankCardState())) {
/* 507 */               c.put("bank", Integer.valueOf(count2 + 1));
/*     */             }
/*     */             
/* 510 */             if ("30".equals(userAuth.getPhoneState())) {
/* 511 */               c.put("phone", Integer.valueOf(count3 + 1));
/*     */             }
/*     */             
/* 514 */             if ("30".equals(userAuth.getTaoBaoState())) {
/* 515 */               c.put("taobao", Integer.valueOf(count4 + 1));
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 522 */         for (String sq : req) {
/* 523 */           if (userIDS.contains(Long.valueOf(sq))) {
/* 524 */             int count0 = Integer.parseInt(c.get("shenq") == null ? "0" : c.get("shenq").toString());
/* 525 */             c.put("shenq", Integer.valueOf(count0 + 1));
/*     */           }
/*     */         }
/*     */         
/* 529 */         for (String sq : reqSucces) {
/* 530 */           if (userIDS.contains(Long.valueOf(sq))) {
/* 531 */             int count0 = Integer.parseInt(c.get("shensucc") == null ? "0" : c.get("shensucc").toString());
/* 532 */             c.put("shensucc", Integer.valueOf(count0 + 1));
/*     */           }
/*     */         }
/*     */         
/* 536 */         for (String sq : userBorrow3) {
/* 537 */           if (userIDS.contains(Long.valueOf(sq))) {
/* 538 */             int count0 = Integer.parseInt(c.get("userBorrow3") == null ? "0" : c.get("userBorrow3").toString());
/* 539 */             c.put("userBorrow3", Integer.valueOf(count0 + 1));
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 544 */         for (String sq : userBorrow4) {
/* 545 */           if (userIDS.contains(Long.valueOf(sq))) {
/* 546 */             int count0 = Integer.parseInt(c.get("userBorrow4") == null ? "0" : c.get("userBorrow4").toString());
/* 547 */             c.put("userBorrow4", Integer.valueOf(count0 + 1));
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 552 */         c.put("zhuanhua", "10");
/*     */         
/* 554 */         Object o = c.get("scaling");
/* 555 */         if (o != null) {
/* 556 */           double value = Double.parseDouble(o.toString());
/* 557 */           if ((value > 0.0D) && (value < 100.0D)) {
/* 558 */             c.put("shiming", c.get("shiming").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("shiming").toString()) * value)
/* 559 */               .divide(new BigDecimal(100), 0, 4));
/* 560 */             c.put("zhima", c.get("zhima").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("zhima").toString()) * value)
/* 561 */               .divide(new BigDecimal(100), 0, 4));
/* 562 */             c.put("taobao", c.get("taobao").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("taobao").toString()) * value)
/* 563 */               .divide(new BigDecimal(100), 0, 4));
/* 564 */             c.put("bank", c.get("bank").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("bank").toString()) * value)
/* 565 */               .divide(new BigDecimal(100), 0, 4));
/* 566 */             c.put("phone", c.get("phone").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("phone").toString()) * value)
/* 567 */               .divide(new BigDecimal(100), 0, 4));
/* 568 */             c.put("shenq", c.get("shenq").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("shenq").toString()) * value)
/* 569 */               .divide(new BigDecimal(100), 0, 4));
/* 570 */             c.put("shensucc", c.get("shensucc").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("shensucc").toString()) * value)
/* 571 */               .divide(new BigDecimal(100), 0, 4));
/* 572 */             c.put("userBorrow3", c.get("userBorrow3").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("userBorrow3").toString()) * value)
/* 573 */               .divide(new BigDecimal(100), 0, 4));
/* 574 */             c.put("userBorrow4", c.get("userBorrow4").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("userBorrow4").toString()) * value)
/* 575 */               .divide(new BigDecimal(100), 0, 4));
/* 576 */             c.put("userNum", c.get("userNum").toString() + "/" + new BigDecimal(Integer.parseInt(c.get("userNum").toString()) * value)
/* 577 */               .divide(new BigDecimal(100), 0, 4));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 582 */     return page;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<String, Object> statisticsMySelfCpa(Map<String, Object> paramMap)
/*     */   {
/* 590 */     List<Map<String, Object>> channel = this.channelMapper.listMyChannel2(paramMap);
/* 591 */     Long channelId = Long.valueOf(0L);
/* 592 */     if ((channel == null) || (channel.size() != 1)) {
/* 593 */       return null;
/*     */     }
/* 595 */     channelId = Long.valueOf(((Map)channel.get(0)).get("id").toString());
/*     */     
/* 597 */     List<Long> userIDS = this.channelMapper.listMyUser(channelId);
/*     */     
/* 599 */     if ((userIDS == null) || (userIDS.size() < 0)) {
/* 600 */       return null;
/*     */     }
/*     */     
/* 603 */     Map<String, Object> c = (Map)channel.get(0);
/*     */     
/* 605 */     c.put("shiming", Integer.valueOf(0));
/* 606 */     c.put("zhima", Integer.valueOf(0));
/* 607 */     c.put("bank", Integer.valueOf(0));
/* 608 */     c.put("phone", Integer.valueOf(0));
/* 609 */     c.put("shenq", Integer.valueOf(0));
/* 610 */     c.put("taobao", Integer.valueOf(0));
/* 611 */     c.put("shensucc", Integer.valueOf(0));
/* 612 */     c.put("userBorrow3", Integer.valueOf(0));
/* 613 */     c.put("userBorrow4", Integer.valueOf(0));
/* 614 */     c.put("userNum", Integer.valueOf(userIDS.size()));
/*     */     
/*     */ 
/* 617 */     List<UserAuthModel> userAuthMode = this.userAuthMapper.listUserAuthModel(new HashMap());
/*     */     
/* 619 */     List<String> req = this.channelMapper.userBorrow(paramMap);
/* 620 */     paramMap.put("state", "true");
/*     */     
/* 622 */     List<String> reqSucces = this.channelMapper.userBorrow2(paramMap);
/*     */     
/* 624 */     List<String> userBorrow3 = this.channelMapper.userBorrow3(paramMap);
/*     */     
/* 626 */     List<String> userBorrow4 = this.channelMapper.userBorrow4(paramMap);
/*     */     
/* 628 */     for (UserAuthModel userAuth : userAuthMode) {
/* 629 */       if (userIDS.contains(userAuth.getUserId())) {
/* 630 */         int count0 = Integer.parseInt(c.get("shiming") == null ? "0" : c.get("shiming").toString());
/* 631 */         int count1 = Integer.parseInt(c.get("zhima") == null ? "0" : c.get("zhima").toString());
/* 632 */         int count2 = Integer.parseInt(c.get("bank") == null ? "0" : c.get("bank").toString());
/* 633 */         int count3 = Integer.parseInt(c.get("phone") == null ? "0" : c.get("phone").toString());
/* 634 */         int count4 = Integer.parseInt(c.get("taobao") == null ? "0" : c.get("taobao").toString());
/*     */         
/* 636 */         if ("30".equals(userAuth.getRealNameState())) {
/* 637 */           c.put("shiming", Integer.valueOf(count0 + 1));
/*     */         }
/*     */         
/* 640 */         if ("30".equals(userAuth.getZhimaState())) {
/* 641 */           c.put("zhima", Integer.valueOf(count1 + 1));
/*     */         }
/*     */         
/* 644 */         if ("30".equals(userAuth.getBankCardState())) {
/* 645 */           c.put("bank", Integer.valueOf(count2 + 1));
/*     */         }
/*     */         
/* 648 */         if ("30".equals(userAuth.getPhoneState())) {
/* 649 */           c.put("phone", Integer.valueOf(count3 + 1));
/*     */         }
/*     */         
/* 652 */         if ("30".equals(userAuth.getTaoBaoState())) {
/* 653 */           c.put("taobao", Integer.valueOf(count4 + 1));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 660 */     for (String sq : req) {
/* 661 */       if (userIDS.contains(Long.valueOf(sq))) {
/* 662 */         int count0 = Integer.parseInt(c.get("shenq") == null ? "0" : c.get("shenq").toString());
/* 663 */         c.put("shenq", Integer.valueOf(count0 + 1));
/*     */       }
/*     */     }
/*     */     
/* 667 */     for (String sq : reqSucces) {
/* 668 */       if (userIDS.contains(Long.valueOf(sq))) {
/* 669 */         int count0 = Integer.parseInt(c.get("shensucc") == null ? "0" : c.get("shensucc").toString());
/* 670 */         c.put("shensucc", Integer.valueOf(count0 + 1));
/*     */       }
/*     */     }
/*     */     
/* 674 */     for (String sq : userBorrow3) {
/* 675 */       if (userIDS.contains(Long.valueOf(sq))) {
/* 676 */         int count0 = Integer.parseInt(c.get("userBorrow3") == null ? "0" : c.get("userBorrow3").toString());
/* 677 */         c.put("userBorrow3", Integer.valueOf(count0 + 1));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 682 */     for (String sq : userBorrow4) {
/* 683 */       if (userIDS.contains(Long.valueOf(sq))) {
/* 684 */         int count0 = Integer.parseInt(c.get("userBorrow4") == null ? "0" : c.get("userBorrow4").toString());
/* 685 */         c.put("userBorrow4", Integer.valueOf(count0 + 1));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 690 */     c.put("zhuanhua", "10");
/* 691 */     Object o = ((Map)channel.get(0)).get("scaling");
/* 692 */     if (o != null) {
/* 693 */       double value = Double.parseDouble(o.toString());
/* 694 */       if ((value > 0.0D) && (value < 100.0D)) {
/* 695 */         c.put("shiming", new BigDecimal(Integer.parseInt(c.get("shiming").toString()) * value)
/* 696 */           .divide(new BigDecimal(100), 0, 4));
/* 697 */         c.put("zhima", new BigDecimal(Integer.parseInt(c.get("zhima").toString()) * value)
/* 698 */           .divide(new BigDecimal(100), 0, 4));
/* 699 */         c.put("taobao", new BigDecimal(Integer.parseInt(c.get("taobao").toString()) * value)
/* 700 */           .divide(new BigDecimal(100), 0, 4));
/* 701 */         c.put("bank", new BigDecimal(Integer.parseInt(c.get("bank").toString()) * value)
/* 702 */           .divide(new BigDecimal(100), 0, 4));
/* 703 */         c.put("phone", new BigDecimal(Integer.parseInt(c.get("phone").toString()) * value)
/* 704 */           .divide(new BigDecimal(100), 0, 4));
/* 705 */         c.put("shenq", new BigDecimal(Integer.parseInt(c.get("shenq").toString()) * value)
/* 706 */           .divide(new BigDecimal(100), 0, 4));
/* 707 */         c.put("shensucc", new BigDecimal(Integer.parseInt(c.get("shensucc").toString()) * value)
/* 708 */           .divide(new BigDecimal(100), 0, 4));
/* 709 */         c.put("userBorrow3", new BigDecimal(Integer.parseInt(c.get("userBorrow3").toString()) * value)
/* 710 */           .divide(new BigDecimal(100), 0, 4));
/* 711 */         c.put("userBorrow4", new BigDecimal(Integer.parseInt(c.get("userBorrow4").toString()) * value)
/* 712 */           .divide(new BigDecimal(100), 0, 4));
/* 713 */         c.put("userNum", new BigDecimal(Integer.parseInt(c.get("userNum").toString()) * value)
/* 714 */           .divide(new BigDecimal(100), 0, 4));
/*     */       }
/*     */     }
/* 717 */     return c;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<KeyValue> listChannelContactId()
/*     */   {
/* 723 */     Map<String, Object> params = new HashMap();
/* 724 */     List<String> roleNid = new ArrayList();
/* 725 */     roleNid.add("channelSupervisor");
/* 726 */     roleNid.add("channelStaff");
/* 727 */     params.put("roleNid", roleNid);
/* 728 */     List<KeyValue> keyValue = this.channelMapper.listChannelContactId(params);
/* 729 */     return keyValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Channel> listMyChannel(String code)
/*     */   {
/* 737 */     return null;
/*     */   }
/*     */ }


/*impl\ChannelServiceImpl.class

 */