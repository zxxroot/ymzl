/*    */ package com.rongdu.cashloan.core.common.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class ShardTableUtil
/*    */ {
/* 17 */   public static List<String> tables = new ArrayList();
/*    */   
/* 19 */   static { tables.add("cl_user_contacts");
/* 20 */     tables.add("cl_operator_voices");
/* 21 */     tables.add("cl_user_messages");
/* 22 */     tables.add("cl_operator_voices_contact");
/* 23 */     tables.add("cl_operator_rep_application_check");
/* 24 */     tables.add("cl_operator_rep_behavior_check");
/* 25 */     tables.add("cl_operator_rep_contact_region");
/* 26 */     tables.add("cl_operator_rep_trip_info");
/* 27 */     tables.add("cl_operator_rep_main_service");
/* 28 */     tables.add("cl_operator_cell_behavior");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String generateTableNameById(String tableName, long id, long shardId)
/*    */   {
/* 37 */     if (tables.contains(tableName)) {
/* 38 */       long num = id / shardId + 1L;
/* 39 */       return tableName + "_" + num;
/*    */     }
/* 41 */     return tableName;
/*    */   }
/*    */ }
