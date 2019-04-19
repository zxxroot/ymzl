/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
/*    */ public class MapRender
/*    */ {
/*    */   private Collection<Map> mapList;
/* 16 */   private Map renders = new HashMap();
/* 17 */   public static final Logger logger = LoggerFactory.getLogger(MapRender.class);
/*    */   
/* 19 */   public MapRender(Collection<Map> mapList) { this.mapList = mapList; }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public MapRender registerRender(Object[][] renders)
/*    */   {
/* 27 */     this.renders = new HashMap();
/* 28 */     Object[][] arrayOfObject; int j = (arrayOfObject = renders).length; for (int i = 0; i < j; i++) { Object[] render = arrayOfObject[i];
/* 29 */       this.renders.put(render[0], (Render)render[1]);
/*    */     }
/* 31 */     return this;
/*    */   }
/*    */   
/* 34 */   public Collection<Map> render() { Collection<Map> newMapList = null;
/*    */     try {
/* 36 */       newMapList = (Collection)this.mapList.getClass().newInstance();
/* 37 */       Iterator localIterator2; for (Iterator localIterator1 = this.mapList.iterator(); localIterator1.hasNext(); 
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 43 */           localIterator2.hasNext())
/*    */       {
/* 37 */         Map item = (Map)localIterator1.next();
/* 38 */         Map newMap = (Map)item.getClass().newInstance();
/* 39 */         newMap.putAll(item);
/*    */         
/* 41 */         newMapList.add(newMap);
/*    */         
/* 43 */         localIterator2 = this.renders.entrySet().iterator();
Object renderKey = localIterator2.next();
/* 44 */         Render render = (Render)this.renders.get(renderKey);
/* 45 */         Object value = item.get(renderKey);
/*    */         
/* 47 */         if (item.containsKey(renderKey)) {
/* 48 */           Object[] par = new Object[2];
/* 49 */           value = render.render(value, renderKey, item, par);
/* 50 */           newMap.put(renderKey, value);
/* 51 */           if ((par[0] != null) && (par[1] != null)) {
/* 52 */             newMap.put(par[0], par[1]);
/*    */           }
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 58 */       this.mapList.clear();
/* 59 */       this.mapList.addAll(newMapList);
/*    */     } catch (InstantiationException|IllegalAccessException e) {
/* 61 */       logger.error(e.getMessage(), e);
/*    */     }
/* 63 */     return newMapList;
/*    */   }
/*    */   
/*    */   public static abstract interface Render
/*    */   {
/*    */     public abstract Object render(Object paramObject1, Object paramObject2, Map paramMap, Object[] paramArrayOfObject);
/*    */   }
/*    */ }
