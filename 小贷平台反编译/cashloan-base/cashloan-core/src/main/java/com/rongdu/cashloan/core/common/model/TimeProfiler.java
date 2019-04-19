/*     */ package com.rongdu.cashloan.core.common.model;
/*     */ 
/*     */ import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

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
/*     */ public final class TimeProfiler
/*     */ {
/*  18 */   private static final Log logger = LogFactory.getLog(TimeProfiler.class);
/*     */   
/*     */   private static final int Default_Threshold = 10;
/*     */   
/*     */   public static final String NewLine = "\r\n";
/*     */   
/*     */   public static final String SummaryHeader = "Entire running time(millis)=[";
/*     */   
/*     */   public static final String SummaryHeaderTimeEnd = "]";
/*     */   
/*     */   public static final String In = "in";
/*     */   
/*     */   private String id;
/*     */   
/*     */   private int threshold;
/*     */   
/*  34 */   private long begin = 0L;
/*     */   
/*  36 */   private long end = 0L;
/*     */   
/*  38 */   private List<ProfilerTask> tasks = new ArrayList();
/*     */   
/*     */   private ProfilerTask currentTask;
/*     */   
/*  42 */   private static final ThreadLocal<TimeProfiler> local = new ThreadLocal();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private TimeProfiler(String id, int threshold)
/*     */   {
/*  51 */     this.id = id;
/*  52 */     this.threshold = threshold;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isProfileEnable()
/*     */   {
/*  61 */     return (logger.isInfoEnabled()) || (logger.isDebugEnabled());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TimeProfiler start(String name, int threshold)
/*     */   {
/*  71 */     TimeProfiler profiler = new TimeProfiler(name, threshold);
/*  72 */     local.set(profiler);
/*  73 */     profiler.begin = System.currentTimeMillis();
/*  74 */     return profiler;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TimeProfiler start(String name)
/*     */   {
/*  84 */     return start(name, 10);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void release()
/*     */   {
/*  92 */     release(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void release(String name)
/*     */   {
/* 101 */     local.remove();
/* 102 */     this.end = System.currentTimeMillis();
/* 103 */     logProfiler(name);
/*     */   }
/*     */   
/*     */   private void logProfiler(String name) {
/* 107 */     if (getTotalTimeMillis() < this.threshold) {
/* 108 */       return;
/*     */     }
/*     */     
/* 111 */     logger.debug(name == null ? prettyPrint() : prettyPrint(name));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static long getTotalTimeMillis()
/*     */   {
///* 123 */     return this.end - this.begin;
    return 0L;
/*     */   }
/*     */   
/*     */   private String shortSummary(String name) {
/* 127 */     StringBuilder sb = new StringBuilder();
/* 128 */     sb.append("TimeProfiler output:").append("\r\n");
/* 129 */     sb.append("Entire running time(millis)=[").append(getTotalTimeMillis()).append("]");
/* 130 */     sb.append(' ').append("in").append(' ').append(name);
/* 131 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private String shortSummary() {
/* 135 */     return shortSummary(this.id);
/*     */   }
/*     */   
/*     */   private String prettyPrint(String name) {
/* 139 */     StringBuilder sb = new StringBuilder(shortSummary(name));
/* 140 */     for (ProfilerTask task : this.tasks) {
/* 141 */       sb.append("\r\n").append(task.prettyPrint(this.begin));
/*     */     }
/* 143 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private String prettyPrint() {
/* 147 */     StringBuilder sb = new StringBuilder(shortSummary());
/* 148 */     for (ProfilerTask task : this.tasks) {
/* 149 */       sb.append("\r\n").append(task.prettyPrint(this.begin));
/*     */     }
/* 151 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void beginTask(String string)
/*     */   {
/* 159 */     TimeProfiler profiler = (TimeProfiler)local.get();
/* 160 */     boolean iFireIt = false;
/* 161 */     if (profiler == null) {
/* 162 */       profiler = start(string);
/* 163 */       iFireIt = true;
/*     */     }
/* 165 */     TimeProfiler tmp28_27 = profiler;tmp28_27.getClass();
ProfilerTask task = new ProfilerTask(string);
/* 166 */     task.fire = iFireIt;
/* 167 */     profiler.addTask(task);
/* 168 */     task.start();
/*     */   }
/*     */   
/*     */   private void addTask(ProfilerTask task) {
/* 172 */     taskJoin(task);
/* 173 */     this.currentTask = task;
/*     */   }
/*     */   
/*     */   private void taskJoin(ProfilerTask task) {
/* 177 */     if (this.currentTask == null) {
/* 178 */       this.tasks.add(task);
/*     */     } else {
/* 180 */       this.currentTask.addChildTask(task);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void endTask()
/*     */   {
/* 188 */     TimeProfiler profiler = (TimeProfiler)local.get();
/* 189 */     if (profiler == null) {
/* 190 */       throw new IllegalStateException(
/* 191 */         "Can't end ProfilerTask: TimeProfiler is not running");
/*     */     }
/* 193 */     if (profiler.currentTask == null) {
/* 194 */       throw new IllegalStateException(
/* 195 */         "Can't end ProfilerTask: currentTask is null");
/*     */     }
/* 197 */     ProfilerTask current = profiler.currentTask;
/* 198 */     current.end();
/* 199 */     boolean iFireIt = current.fire;
/* 200 */     profiler.currentTask = profiler.currentTask.getParentTask();
/* 201 */     if (iFireIt) {
/* 202 */       profiler.release();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addTrace(String string)
/*     */   {
/* 212 */     if (string == null) {
/* 213 */       return;
/*     */     }
/* 215 */     TimeProfiler profiler = (TimeProfiler)local.get();
/* 216 */     if (profiler == null) {
/*     */       return;
/*     */     }
/* 219 */     TimeProfiler tmp26_25 = profiler;tmp26_25.getClass();profiler.taskJoin(new TraceTask(string));
/*     */   }
/*     */   
/*     */ 
/*     */   public static class ProfilerTask
/*     */   {
/*     */     protected ProfilerTask parent;
/*     */     
/*     */     protected List<ProfilerTask> children;
/*     */     
/*     */     protected String name;
/*     */     
/*     */     protected long start;
/*     */     
/*     */     protected long end;
/* 234 */     protected int deep = 1;
/*     */     
/* 236 */     protected boolean fire = false;
/*     */     
/*     */     public ProfilerTask(String n) {
/* 239 */       this.name = n;
/*     */     }
/*     */     
/*     */     public StringBuilder prettyPrint(long profileStart) {
/* 243 */       StringBuilder sb = new StringBuilder();
/* 244 */       sb.append("Task:").append(this.name);
/* 245 */       sb.append(" running time(millis)");
/* 246 */       sb.append('[').append(this.start - profileStart).append("->").append(this.end - profileStart).append(']');
/* 247 */       sb.append('=').append(getTotalTimeMillis());
/* 248 */       double rate = getTotalTimeMillis() / 
/* 249 */         TimeProfiler.getTotalTimeMillis();
/* 250 */       rate *= 100.0D;
/* 251 */       sb.append(" ").append((int)rate).append('%');
/* 252 */       if (this.children != null) {
/* 253 */         for (ProfilerTask child : this.children) {
/* 254 */           sb.append("\r\n");
/* 255 */           for (int i = 0; i < this.deep; i++) {
/* 256 */             sb.append("--");
/*     */           }
/* 258 */           sb.append(child.prettyPrint(profileStart));
/*     */         }
/*     */       }
/* 261 */       return sb;
/*     */     }
/*     */     
/*     */     public void start() {
/* 265 */       this.start = System.currentTimeMillis();
/*     */     }
/*     */     
/*     */     public void addChildTask(ProfilerTask task) {
/* 269 */       if (this.children == null) {
/* 270 */         this.children = new ArrayList();
/*     */       }
/* 272 */       this.children.add(task);
/* 273 */       task.parent = this;
/* 274 */       this.deep += 1;
/*     */     }
/*     */     
/*     */     public void end() {
/* 278 */       this.end = System.currentTimeMillis();
/*     */     }
/*     */     
/*     */     public ProfilerTask getParentTask() {
/* 282 */       return this.parent;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 287 */       return this.name;
/*     */     }
/*     */     
/*     */     public long getTotalTimeMillis() {
/* 291 */       return this.end - this.start;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class TraceTask extends TimeProfiler.ProfilerTask {
/*     */     public TraceTask(String n) {
/* 297 */       super(n);
/*     */     }
/*     */     
/*     */     public StringBuilder prettyPrint(long profileStart)
/*     */     {
/* 302 */       StringBuilder sb = new StringBuilder();
/* 303 */       sb.append("Trace:").append(this.name);
/* 304 */       if (this.children != null) {
/* 305 */         for (TimeProfiler.ProfilerTask child : this.children) {
/* 306 */           sb.append("\r\n");
/* 307 */           for (int i = 0; i < this.deep; i++) {
/* 308 */             sb.append("--");
/*     */           }
/* 310 */           sb.append(child.prettyPrint(profileStart));
/*     */         }
/*     */       }
/* 313 */       return sb;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\model\TimeProfiler.class

 */