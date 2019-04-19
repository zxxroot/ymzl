/*    */ package com.cashloan.cl.model.pay.fuiou.newprotocol;
/*    */ 
/*    */

import com.rongdu.cashloan.cl.model.pay.fuiou.newprotocol.FuiouProtocolPayModel;
import com.rongdu.cashloan.core.common.context.Global;

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
/*    */ 
/*    */ public class UnbindModel
/*    */   extends FuiouProtocolPayModel
/*    */ {
/*    */   public String getUrl()
/*    */   {
/* 25 */     return Global.getValue("fuiou_newpro_unbind");
/*    */   }
/*    */   
/*    */   public void fillParams(Map<String, Object> map)
/*    */   {
/* 30 */     map.put("VERSION", getVersion());
/* 31 */     map.put("MCHNTCD", getMchntCd());
/* 32 */     map.put("USERID", getUserId());
/* 33 */     map.put("PROTOCOLNO", getProtocolNo());
/* 34 */     map.put("SIGN", getSign());
/*    */   }
/*    */   
/*    */   public String getSign()
/*    */   {
/* 39 */     String[] signItems = { getVersion(), getMchntCd(), getUserId(), getProtocolNo(), getMchntKey() };
/* 40 */     setSignItems(signItems);
/* 41 */     return super.getSign();
/*    */   }
/*    */ }
