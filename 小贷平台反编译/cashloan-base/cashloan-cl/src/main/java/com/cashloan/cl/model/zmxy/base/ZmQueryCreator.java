/*    */ package com.cashloan.cl.model.zmxy.base;
/*    */ 
/*    */ import com.rongdu.cashloan.core.common.context.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

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
/*    */ public class ZmQueryCreator
/*    */ {
/* 17 */   public static final Logger logger = LoggerFactory.getLogger(ZmQueryCreator.class);
/*    */   
/*    */   private final String privateKey;
/*    */   
/*    */   private final String zhimaPublicKey;
/*    */   private final String appId;
/*    */   
/*    */   public ZmQueryCreator()
/*    */   {
/* 26 */     this.privateKey = Global.getValue("zhima_private_key");
/* 27 */     this.zhimaPublicKey = Global.getValue("zhima_public_key");
/* 28 */     this.appId = Global.getValue("zhima_app_id");
/*    */   }
/*    */   
/*    */   private ZmQueryCreator(String privateKey, String zhimaPublicKey, String appId) {
/* 32 */     this.privateKey = privateKey;
/* 33 */     this.zhimaPublicKey = zhimaPublicKey;
/* 34 */     this.appId = appId;
/*    */   }
/*    */   
/*    */   public static ZmQueryCreator newCreator(String privateKey, String zhimaPublicKey, String appId) {
/* 38 */     return new ZmQueryCreator(privateKey, zhimaPublicKey, appId);
/*    */   }
/*    */   
/*    */   public <T extends BaseQuery> T create(Class<T> clazz) {
/* 42 */     T t = null;
/*    */     try {
/* 44 */       Constructor<T> constructor = clazz.getConstructor(new Class[] { String.class, String.class, String.class });
/* 45 */       t = constructor.newInstance(new Object[] { this.privateKey, this.zhimaPublicKey, this.appId });
/*    */     } catch (Exception e) {
/* 47 */       logger.error(e.getMessage(), e);
/*    */     }
/* 49 */     return t;
/*    */   }
/*    */ }
