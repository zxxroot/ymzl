/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
import com.rongdu.cashloan.core.common.context.Global;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Map;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ public class HuaDaoBlackUtil
/*    */ {
/* 21 */   private static final Logger logger = LoggerFactory.getLogger(HuaDaoBlackUtil.class);
/*    */   
/* 23 */   public static final String TOKEN_ENDPOINT = Global.getValue("hudao_balck_partner_url");
/*    */   
/* 25 */   public static final String BLACK_ENDPOINT = Global.getValue("hudao_balck_is_balck_url");
/*    */   
/*    */   public static final String HUADAO_URL = "http://tempuri.org/";
/*    */   
/*    */   public static final String TOKEN_METHOD = "GetACCESS_TOKEN";
/*    */   public static final String BLACK_METHOD = "IS_Be_Overdue_Black";
/*    */   
/*    */   public static String getAccessToken(String appId, String appsecret, String key)
/*    */   {
/* 34 */     String res = "";
/*    */     
/* 36 */     Service service = new Service();
/*    */     try {
/* 38 */       Call call = (Call)service.createCall();
/* 39 */       call.setTargetEndpointAddress(new URL(TOKEN_ENDPOINT));
/* 40 */       call.setOperationName(new QName("http://tempuri.org/", "GetACCESS_TOKEN"));
/* 41 */       call.addParameter(new QName("http://tempuri.org/", "AppID"), XMLType.XSD_STRING, ParameterMode.IN);
/* 42 */       call.addParameter(new QName("http://tempuri.org/", "AppSecret"), XMLType.XSD_STRING, ParameterMode.IN);
/* 43 */       call.addParameter(new QName("http://tempuri.org/", "Key"), XMLType.XSD_STRING, ParameterMode.IN);
/* 44 */       call.setReturnType(XMLType.XSD_STRING);
/* 45 */       call.setUseSOAPAction(true);
/* 46 */       call.setSOAPActionURI("http://tempuri.org/GetACCESS_TOKEN");
/* 47 */       res = (String)call.invoke(new Object[] { appId, appsecret, key });
/* 48 */       Map<String, Object> resultMap = JSONObject.parseObject(res);
/* 49 */       res = String.valueOf(resultMap.get("access_token"));
/*    */     } catch (ServiceException e) {
/* 51 */       logger.error(e.getMessage(), e);
/*    */     } catch (MalformedURLException e) {
/* 53 */       logger.error(e.getMessage(), e);
/*    */     } catch (RemoteException e) {
/* 55 */       logger.error(e.getMessage(), e);
/*    */     } catch (Exception e) {
/* 57 */       logger.error(e.getMessage(), e);
/*    */     }
/* 59 */     return res;
/*    */   }
/*    */   
/*    */   public static String getIsBlack(String appId, String appsecret, String key, String phone)
/*    */   {
/* 64 */     String blackMsg = "";
/*    */     
/* 66 */     String access_token = getAccessToken(appId, appsecret, key);
/*    */     
/* 68 */     Service service = new Service();
/*    */     try {
/* 70 */       Call call = (Call)service.createCall();
/* 71 */       call.setTargetEndpointAddress(new URL(BLACK_ENDPOINT));
/* 72 */       call.setOperationName(new QName("http://tempuri.org/", "IS_Be_Overdue_Black"));
/* 73 */       call.addParameter(new QName("http://tempuri.org/", "Phone"), XMLType.XSD_STRING, ParameterMode.IN);
/* 74 */       call.addParameter(new QName("http://tempuri.org/", "ACCESS_TOKEN"), XMLType.XSD_STRING, ParameterMode.IN);
/* 75 */       call.setReturnType(XMLType.XSD_STRING);
/* 76 */       call.setUseSOAPAction(true);
/* 77 */       call.setSOAPActionURI("http://tempuri.org/IS_Be_Overdue_Black");
/* 78 */       blackMsg = (String)call.invoke(new Object[] { phone, access_token });
/*    */     } catch (ServiceException e) {
/* 80 */       e.printStackTrace();
/*    */     } catch (MalformedURLException e) {
/* 82 */       e.printStackTrace();
/*    */     } catch (RemoteException e) {
/* 84 */       e.printStackTrace();
/*    */     } catch (Exception e) {
/* 86 */       e.printStackTrace();
/*    */     }
/*    */     
/* 89 */     return blackMsg;
/*    */   }
/*    */   
/*    */   public static void main(String[] arg) {
/* 93 */     getIsBlack("201B36A3WB5E7W45B6W920EW37AA3DDDC95F", "C0D4DDADLFA09L4981LBECFL69917EEF06CA", "3669E8D2H5853H4028HB79AH471CE5D49A83", "18300674029");
/*    */   }
/*    */ }
