/*    */ package com.cashloan.cl.utils;
/*    */ 
/*    */ import net.sf.ehcache.Cache;
/*    */ import net.sf.ehcache.CacheManager;
/*    */ import net.sf.ehcache.Element;
/*    */ import net.sf.ehcache.config.CacheConfiguration;
/*    */ import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EhcacheUtil
/*    */ {
/*    */   private static final int time = 3;
/* 18 */   private static final CacheManager cacheManager = new CacheManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   private static Cache cache = new Cache(new CacheConfiguration("com.ibrjf.app.web.passwordRetryCache", 5000).memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.FIFO).timeoutMillis(180L).timeToLiveSeconds(180L));
/*    */   
/*    */   static {
/* 26 */     cacheManager.addCache(cache);
/*    */   }
/*    */   
/*    */   public static void putItem(String key, Object item) {
/* 30 */     if (cache.get(key) != null) {
/* 31 */       cache.remove(key);
/*    */     }
/* 33 */     Element element = new Element(key, item);
/* 34 */     cache.put(element);
/*    */   }
/*    */   
/*    */   public static void removeItem(String key) {
/* 38 */     cache.remove(key);
/*    */   }
/*    */   
/*    */   public static void updateItem(String key, Object value) {
/* 42 */     putItem(key, value);
/*    */   }
/*    */   
/*    */   public static Object getItem(String key) {
/* 46 */     Element element = cache.get(key);
/* 47 */     if (element != null) {
/* 48 */       return element.getObjectValue();
/*    */     }
/* 50 */     return null;
/*    */   }
/*    */ }
