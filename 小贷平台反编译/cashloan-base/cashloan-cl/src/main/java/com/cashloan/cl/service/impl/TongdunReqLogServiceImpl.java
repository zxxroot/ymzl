package com.cashloan.cl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.cashloan.cl.domain.*;
import com.cashloan.cl.mapper.*;
import com.cashloan.cl.model.TongdunReqLogModel;
import com.cashloan.cl.model.tongdun.PreloanApi;
import com.cashloan.cl.model.tongdun.model.PreloanApplyModel;
import com.cashloan.cl.model.tongdun.sdk.PreloanReportResponse;
import com.cashloan.cl.monitor.BusinessExceptionMonitor;
import com.cashloan.cl.service.ClBorrowService;
import com.cashloan.cl.service.TongdunReqLogService;
import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.exception.BaseRuntimeException;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.service.impl.BaseServiceImpl;
import com.rongdu.cashloan.core.common.util.DateUtil;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import com.rongdu.cashloan.core.common.util.StringUtil;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.domain.UserBaseInfo;
import com.rongdu.cashloan.core.domain.UserOtherInfo;
import com.rongdu.cashloan.core.mapper.UserBaseInfoMapper;
import com.rongdu.cashloan.core.mapper.UserMapper;
import com.rongdu.cashloan.core.mapper.UserOtherInfoMapper;
import com.rongdu.cashloan.rc.domain.TppBusiness;
import com.rongdu.cashloan.rc.mapper.TppBusinessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;








@Service("tongdunReqLogService")
public class TongdunReqLogServiceImpl
  extends BaseServiceImpl<TongdunReqLog, Long>
  implements TongdunReqLogService
{
  private static final Logger logger = LoggerFactory.getLogger(TongdunReqLogServiceImpl.class);
  @Resource
  private TongdunReqLogMapper tongdunReqLogMapper;
  @Resource
  private UserEmerContactsMapper userEmerContactsMapper;
  @Resource
  private UserMapper userMapper;
  @Resource
  private UserBaseInfoMapper userBaseInfoMapper;
  @Resource
  private UserContactsMapper userContactsMapper;
  @Resource
  private ClBorrowMapper clBorrowMapper;
  @Resource
  private BankCardMapper bankCardMapper;
  @Resource
  private UserAuthMapper userAuthMapper;
  @Resource
  private UserOtherInfoMapper userOtherInfoMapper;
  @Resource
  private UserEquipmentInfoMapper userEquipmentInfoMapper;
  @Resource
  private TppBusinessMapper tppBusinessMapper;
  @Resource
  private ClBorrowService clBorrowService;
  @Resource
  private TongdunRespDetailMapper tongdunRespDetailMapper;

  public BaseMapper<TongdunReqLog, Long> getMapper()
  {
    return this.tongdunReqLogMapper;
  }

  public int preloanApplyRequest(Long userId, Borrow borrow, TppBusiness bussiness, String mobileType)
  {
    int m = 0;

    PreloanApplyModel model = initModel(userId, borrow);
    TongdunReqLog log = new TongdunReqLog();
    log.setOrderNo(OrderNoUtil.getSerialNumber());
    log.setBorrowId(borrow.getId());
    log.setUserId(userId);
    log.setCreateTime(new Date());

    Map<String, Object> payload = new HashMap();
    payload.put("body", JSON.toJSONString(model));

    PreloanApi api = new PreloanApi();
    boolean testState = false;
    if (Global.getValue("tongdun_url_state") != null) {
      testState = "0".equals(Global.getValue("tongdun_url_state"));
    }

    String result = api.preloan(payload, bussiness, testState, mobileType);
    logger.info("借款borrowId：" + borrow.getId() + "，同盾贷前审核，同步响应结果：" + result);
    if (!StringUtil.isBlank(result)) {
      Map<String, Object> resultMap = (Map)JSONObject.parseObject(result, Map.class);
      log.setSubmitCode(String.valueOf(resultMap.get("code")));
      log.setSubmitParams(result);
      if ("200".equals(String.valueOf(resultMap.get("code")))) {
        log.setState("10");
        JSONObject data = (JSONObject)resultMap.get("data");
        String reportId = String.valueOf(data.get("report_id"));
        log.setReportId(reportId);
        this.tongdunReqLogMapper.save(log);

        TppBusiness b = this.tppBusinessMapper.findByNid("TongdunPreloan", bussiness.getTppId());
        String report_id = log.getReportId();
        m = reportTask(report_id, b, mobileType);
      } else {
        Object msg = resultMap.get("message");
        String message = "";
        if (StringUtil.isBlank(msg)) {
          message = "查询接口异常";
        } else {
          message = StringUtil.isNull(msg);
        }

        BusinessExceptionMonitor.add(BusinessExceptionMonitor.TYPE_10, log.getOrderNo(), message);

        log.setState("10");
        log.setRsScore(Integer.valueOf(0));
        log.setRsState(message);
        this.tongdunReqLogMapper.save(log);
      }
    } else {
      log.setState("10");
      log.setRsScore(Integer.valueOf(0));
      log.setRsState("查询接口异常");
      this.tongdunReqLogMapper.save(log);
    }
    return m;
  }

  public String preloanReportRequest(String report_id, TppBusiness bussiness, String mobileType)
  {
    Map<String, Object> model = new HashMap();
    model.put("report_id", report_id);
    Map<String, Object> map = new HashMap();
    map.put("body", JSON.toJSONString(model));

    PreloanApi api = new PreloanApi();
    boolean testState = false;
    if (Global.getValue("tongdun_url_state") != null) {
      testState = "0".equals(Global.getValue("tongdun_url_state"));
    }
    PreloanReportResponse response = api.preloanReport(map, bussiness, testState, mobileType);
    Map<String, Object> paramMap = new HashMap();
    paramMap.put("reportId", report_id);
    TongdunReqLog log = (TongdunReqLog)this.tongdunReqLogMapper.findSelective(paramMap);

    if (response.getSuccess().booleanValue()) {
      String result = response.postResponseToJsonStr();
      int m = saveReport(result, report_id);
      logger.info(result);
      return m == 1 ? "保存成功" : "保存失败";
    }
    JSONObject result = response.getData();
    logger.info(result.getString("reason_desc"));
    log.setUpdateTime(new Date());
    log.setQueryCode(String.valueOf(result.get("reason_code")));
    log.setState("30");
    int m = this.tongdunReqLogMapper.update(log);
    if (m > 0) {
      TongdunRespDetail detail = new TongdunRespDetail();
      detail.setReqId(log.getId());
      detail.setOrderNo(log.getOrderNo());
      detail.setReportId(report_id);
      detail.setQueryParams(result.toJSONString());
      this.tongdunRespDetailMapper.save(detail);
    }
    return result.getString("reason_desc");
  }








  public int reportTask(String report_id, TppBusiness bussiness, String mobileType)
  {
    int m = 0;
    String result = task(report_id, bussiness, mobileType);
    if (!StringUtil.isBlank(result)) {
      m = saveReport(result, report_id);
    } else {
      logger.debug("没有查询出同盾审核报告结果");
    }
    return m;
  }

  /* Error */
  public String task(String reportId, final TppBusiness bussiness, final String mobileType)
    throws BaseRuntimeException
  {
    // Byte code:
    //   0: ldc -21
    //   2: astore 4
    //   4: new 100	java/util/HashMap
    //   7: dup
    //   8: invokespecial 102	java/util/HashMap:<init>	()V
    //   11: astore 5
    //   13: aload 5
    //   15: ldc -57
    //   17: aload_1
    //   18: invokeinterface 111 3 0
    //   23: pop
    //   24: new 396	java/util/concurrent/FutureTask
    //   27: dup
    //   28: new 398	com/rongdu/cashloan/cl/service/impl/TongdunReqLogServiceImpl$1
    //   31: dup
    //   32: aload_0
    //   33: aload 5
    //   35: aload_2
    //   36: aload_3
    //   37: invokespecial 400	com/rongdu/cashloan/cl/service/impl/TongdunReqLogServiceImpl$1:<init>	(Lcom/rongdu/cashloan/cl/service/impl/TongdunReqLogServiceImpl;Ljava/util/Map;Lcom/rongdu/cashloan/rc/domain/TppBusiness;Ljava/lang/String;)V
    //   40: invokespecial 403	java/util/concurrent/FutureTask:<init>	(Ljava/util/concurrent/Callable;)V
    //   43: astore 6
    //   45: new 406	java/lang/Thread
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 408	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   54: invokevirtual 411	java/lang/Thread:start	()V
    //   57: goto +25 -> 82
    //   60: getstatic 46	com/rongdu/cashloan/cl/service/impl/TongdunReqLogServiceImpl:logger	Lorg/slf4j/Logger;
    //   63: ldc_w 414
    //   66: invokeinterface 158 2 0
    //   71: ldc2_w 416
    //   74: invokestatic 418	java/lang/Thread:sleep	(J)V
    //   77: goto +5 -> 82
    //   80: astore 7
    //   82: aload 6
    //   84: invokevirtual 422	java/util/concurrent/FutureTask:isDone	()Z
    //   87: ifeq -27 -> 60
    //   90: aload 6
    //   92: ldc2_w 425
    //   95: getstatic 427	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   98: invokevirtual 433	java/util/concurrent/FutureTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   101: checkcast 131	java/lang/String
    //   104: astore 4
    //   106: getstatic 46	com/rongdu/cashloan/cl/service/impl/TongdunReqLogServiceImpl:logger	Lorg/slf4j/Logger;
    //   109: ldc_w 436
    //   112: invokeinterface 158 2 0
    //   117: goto +110 -> 227
    //   120: astore 7
    //   122: getstatic 46	com/rongdu/cashloan/cl/service/impl/TongdunReqLogServiceImpl:logger	Lorg/slf4j/Logger;
    //   125: new 140	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 438
    //   132: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload 7
    //   137: invokevirtual 440	com/rongdu/cashloan/core/common/exception/BaseRuntimeException:getMessage	()Ljava/lang/String;
    //   140: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokeinterface 443 2 0
    //   151: aload 7
    //   153: invokevirtual 440	com/rongdu/cashloan/core/common/exception/BaseRuntimeException:getMessage	()Ljava/lang/String;
    //   156: astore 4
    //   158: aload 6
    //   160: iconst_1
    //   161: invokevirtual 446	java/util/concurrent/FutureTask:cancel	(Z)Z
    //   164: pop
    //   165: goto +69 -> 234
    //   168: astore 7
    //   170: getstatic 46	com/rongdu/cashloan/cl/service/impl/TongdunReqLogServiceImpl:logger	Lorg/slf4j/Logger;
    //   173: new 140	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 450
    //   180: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_1
    //   184: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: aload 7
    //   192: invokevirtual 452	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   195: invokeinterface 455 3 0
    //   200: ldc_w 458
    //   203: astore 4
    //   205: aload 6
    //   207: iconst_1
    //   208: invokevirtual 446	java/util/concurrent/FutureTask:cancel	(Z)Z
    //   211: pop
    //   212: goto +22 -> 234
    //   215: astore 8
    //   217: aload 6
    //   219: iconst_1
    //   220: invokevirtual 446	java/util/concurrent/FutureTask:cancel	(Z)Z
    //   223: pop
    //   224: aload 8
    //   226: athrow
    //   227: aload 6
    //   229: iconst_1
    //   230: invokevirtual 446	java/util/concurrent/FutureTask:cancel	(Z)Z
    //   233: pop
    //   234: aload 4
    //   236: areturn
    // Line number table:
    //   Java source line #219	-> byte code offset #0
    //   Java source line #221	-> byte code offset #4
    //   Java source line #222	-> byte code offset #13
    //   Java source line #223	-> byte code offset #24
    //   Java source line #245	-> byte code offset #45
    //   Java source line #247	-> byte code offset #57
    //   Java source line #249	-> byte code offset #60
    //   Java source line #250	-> byte code offset #71
    //   Java source line #251	-> byte code offset #77
    //   Java source line #247	-> byte code offset #82
    //   Java source line #256	-> byte code offset #90
    //   Java source line #257	-> byte code offset #106
    //   Java source line #258	-> byte code offset #117
    //   Java source line #259	-> byte code offset #122
    //   Java source line #260	-> byte code offset #151
    //   Java source line #265	-> byte code offset #158
    //   Java source line #261	-> byte code offset #168
    //   Java source line #262	-> byte code offset #170
    //   Java source line #263	-> byte code offset #200
    //   Java source line #265	-> byte code offset #205
    //   Java source line #264	-> byte code offset #215
    //   Java source line #265	-> byte code offset #217
    //   Java source line #266	-> byte code offset #224
    //   Java source line #265	-> byte code offset #227
    //   Java source line #268	-> byte code offset #234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	TongdunReqLogServiceImpl
    //   0	237	1	reportId	String
    //   0	237	2	bussiness	TppBusiness
    //   0	237	3	mobileType	String
    //   2	233	4	report	String
    //   11	23	5	model	Map<String, Object>
    //   43	185	6	task	java.util.concurrent.FutureTask<String>
    //   80	1	7	localInterruptedException	InterruptedException
    //   120	32	7	e	BaseRuntimeException
    //   168	23	7	e	Exception
    //   215	10	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   60	77	80	java/lang/InterruptedException
    //   90	117	120	com/rongdu/cashloan/core/common/exception/BaseRuntimeException
    //   90	117	168	java/lang/InterruptedException
    //   90	117	168	java/util/concurrent/ExecutionException
    //   90	117	168	java/util/concurrent/TimeoutException
    //   90	158	215	finally
    //   168	205	215	finally
  }

  public int saveReport(String result, String report_id)
  {
    Map<String, Object> paramMap = new HashMap();
    paramMap.put("reportId", report_id);
    TongdunReqLog log = (TongdunReqLog)this.tongdunReqLogMapper.findSelective(paramMap);
    Map<String, Object> resultMap = (Map)JSONObject.parseObject(result, Map.class);
    log.setUpdateTime(new Date());
    log.setQueryCode(String.valueOf(resultMap.get("code")));
    if (log.getQueryCode().equals("200")) {
      log.setState("20");
      JSONObject data = (JSONObject)resultMap.get("data");
      log.setRsScore(Integer.valueOf(String.valueOf(data.get("final_score"))));
      log.setRsState(PreloanApplyModel.getMessage(String.valueOf(data.get("final_decision"))));
    } else {
      log.setState("30");
      log.setRsScore(Integer.valueOf(0));
      log.setRsState("建议审核");
    }

    int m = this.tongdunReqLogMapper.update(log);
    if (m > 0) {
      TongdunRespDetail detail = new TongdunRespDetail();
      detail.setReqId(log.getId());
      detail.setOrderNo(log.getOrderNo());
      detail.setReportId(report_id);
      detail.setQueryParams(result);
      this.tongdunRespDetailMapper.save(detail);
    }
    return m;
  }






  public PreloanApplyModel initModel(Long userId, Borrow borrow)
  {
    PreloanApplyModel model = new PreloanApplyModel();

    UserBaseInfo info = this.userBaseInfoMapper.findByUserId(userId);
    model.setName(info.getRealName());
    model.setMobile(info.getPhone());
    model.setId_number(info.getIdNo());
    model.setWork_phone(info.getCompanyPhone());
    model.setWork_time(info.getWorkingYears());
    model.setCompany_name(info.getCompanyName());
    model.setCompany_address(info.getCompanyAddr());
    model.setAnnual_income(info.getSalary());
    model.setDiploma(info.getEducation());
    model.setMarriage(info.getMarryState());
    model.setRegistered_address(info.getIdAddr());
    model.setHome_address(info.getLiveAddr());


    Map<String, Object> paramMap = new HashMap();
    paramMap.put("userId", userId);
    BankCard card = (BankCard)this.bankCardMapper.findSelective(paramMap);
    if (card != null) {
      model.setCard_number(card.getCardNo());
    }


    UserOtherInfo otherInfo = (UserOtherInfo)this.userOtherInfoMapper.findSelective(paramMap);
    if (otherInfo != null) {
      model.setQq(otherInfo.getQq());
      model.setEmail(otherInfo.getEmail());
    }

    model.setLoan_amount(borrow.getAmount().doubleValue());
    model.setLoan_term(Integer.valueOf(borrow.getTimeLimit()));
    model.setLoan_term_unit("DAY");
    model.setLoan_date(DateUtil.dateStr(borrow.getCreateTime(), "yyyy-MM-dd"));
    model.setIp_address(borrow.getIp());

    UserAuth auth = (UserAuth)this.userAuthMapper.findSelective(paramMap);
    if (auth != null) {
      model.setIs_id_checked("30".equals(auth.getIdState()));
    }

    List<UserEmerContacts> contacts = this.userEmerContactsMapper.listSelective(paramMap);
    if (contacts != null) {
      for (int i = 0; i < contacts.size(); i++) {
        UserEmerContacts c = (UserEmerContacts)contacts.get(i);
        if (i == 0) {
          model.setContact1_name(c.getName());
          model.setContact1_mobile(c.getPhone());
          model.setContact1_relation(c.getRelation());
        } else if (i == 1) {
          model.setContact2_name(c.getName());
          model.setContact2_mobile(c.getPhone());
          model.setContact2_relation(c.getRelation());
        } else if (i == 2) {
          model.setContact3_name(c.getName());
          model.setContact3_mobile(c.getPhone());
          model.setContact3_relation(c.getRelation());
        } else if (i == 3) {
          model.setContact4_name(c.getName());
          model.setContact4_mobile(c.getPhone());
          model.setContact4_relation(c.getRelation());
        } else if (i == 4) {
          model.setContact5_name(c.getName());
          model.setContact5_mobile(c.getPhone());
          model.setContact5_relation(c.getRelation());
        }
      }
    }

    UserEquipmentInfo equipmentInfo = (UserEquipmentInfo)this.userEquipmentInfoMapper.findSelective(paramMap);
    if (equipmentInfo != null) {
      model.setBlack_box(equipmentInfo.getBlackBox());
    }


    return model;
  }


  public Page<TongdunReqLogModel> pageListModel(Map<String, Object> params, int current, int pageSize)
  {
    PageHelper.startPage(current, pageSize);
    List<TongdunReqLogModel> list = this.tongdunReqLogMapper.listModelByMap(params);
    return (Page)list;
  }

  public TongdunReqLogModel getModelById(long id)
  {
    TongdunReqLogModel model = this.tongdunReqLogMapper.findModelById(id);
    return model;
  }

  public List<TongdunReqLogModel> listByMap(Map<String, Object> params)
  {
    List<TongdunReqLogModel> list = this.tongdunReqLogMapper.listModelByMap(params);
    return list;
  }
}
