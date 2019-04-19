/*     */ package com.rongdu.cashloan.manage.model;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import org.quartz.CronTrigger;
/*     */ import org.quartz.JobDetail;
/*     */ import org.quartz.Scheduler;
/*     */ import org.quartz.SchedulerException;
/*     */ import org.quartz.SchedulerFactory;
/*     */ import org.quartz.impl.StdSchedulerFactory;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuartzManager
/*     */ {
/*  23 */   private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
/*  24 */   private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";
/*  25 */   private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";
/*     */   
/*  27 */   public static final Logger logger = LoggerFactory.getLogger(QuartzManager.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addJob(String jobName, Class cls, String time)
/*     */   {
/*     */     try
/*     */     {
/*  39 */       Scheduler sched = gSchedulerFactory.getScheduler();
/*  40 */       JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);
/*     */       
/*  42 */       CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);
/*  43 */       trigger.setCronExpression(time);
/*  44 */       sched.scheduleJob(jobDetail, trigger);
/*     */       
/*  46 */       if (!sched.isShutdown()) {
/*  47 */         sched.start();
/*     */       }
/*     */     } catch (SchedulerException|ParseException e) {
/*  50 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
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
/*     */   public static void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String time)
/*     */   {
/*     */     try
/*     */     {
/*  70 */       Scheduler sched = gSchedulerFactory.getScheduler();
/*  71 */       JobDetail jobDetail = new JobDetail(jobName, jobGroupName, jobClass);
/*     */       
/*  73 */       CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);
/*  74 */       trigger.setCronExpression(time);
/*  75 */       sched.scheduleJob(jobDetail, trigger);
/*     */     } catch (SchedulerException|ParseException e) {
/*  77 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void modifyJobTime(String jobName, String time)
/*     */   {
/*     */     try
/*     */     {
/*  91 */       Scheduler sched = gSchedulerFactory.getScheduler();
/*  92 */       CronTrigger trigger = (CronTrigger)sched.getTrigger(jobName, 
/*  93 */         TRIGGER_GROUP_NAME);
/*  94 */       if (trigger == null) {
/*  95 */         return;
/*     */       }
/*  97 */       String oldTime = trigger.getCronExpression();
/*  98 */       if (!oldTime.equalsIgnoreCase(time)) {
/*  99 */         JobDetail jobDetail = sched.getJobDetail(jobName, 
/* 100 */           JOB_GROUP_NAME);
/* 101 */         Class objJobClass = jobDetail.getJobClass();
/* 102 */         removeJob(jobName);
/*     */         
/* 104 */         addJob(jobName, objJobClass, time);
/*     */       }
/*     */     } catch (SchedulerException e) {
/* 107 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void modifyJobTime(String triggerName, String triggerGroupName, String time)
/*     */   {
/*     */     try
/*     */     {
/* 123 */       Scheduler sched = gSchedulerFactory.getScheduler();
/* 124 */       CronTrigger trigger = (CronTrigger)sched.getTrigger(triggerName, 
/* 125 */         triggerGroupName);
/* 126 */       if (trigger == null) {
/* 127 */         return;
/*     */       }
/* 129 */       String oldTime = trigger.getCronExpression();
/* 130 */       if (!oldTime.equalsIgnoreCase(time)) {
/* 131 */         CronTrigger ct = trigger;
/*     */         
/* 133 */         ct.setCronExpression(time);
/*     */         
/* 135 */         sched.resumeTrigger(triggerName, triggerGroupName);
/*     */       }
/*     */     } catch (SchedulerException|ParseException e) {
/* 138 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeJob(String jobName)
/*     */   {
/*     */     try
/*     */     {
/* 151 */       Scheduler sched = gSchedulerFactory.getScheduler();
/* 152 */       sched.pauseTrigger(jobName, TRIGGER_GROUP_NAME);
/* 153 */       sched.unscheduleJob(jobName, TRIGGER_GROUP_NAME);
/* 154 */       sched.deleteJob(jobName, JOB_GROUP_NAME);
/*     */     } catch (SchedulerException e) {
/* 156 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
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
/*     */   public static void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName)
/*     */   {
/*     */     try
/*     */     {
/* 173 */       Scheduler sched = gSchedulerFactory.getScheduler();
/* 174 */       sched.pauseTrigger(triggerName, triggerGroupName);
/* 175 */       sched.unscheduleJob(triggerName, triggerGroupName);
/* 176 */       sched.deleteJob(jobName, jobGroupName);
/*     */     } catch (SchedulerException e) {
/* 178 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startJobNow(String jobName)
/*     */   {
/*     */     try
/*     */     {
/* 191 */       Scheduler sched = gSchedulerFactory.getScheduler();
/* 192 */       sched.triggerJob(jobName, JOB_GROUP_NAME);
/*     */     } catch (SchedulerException e) {
/* 194 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startJobNow(String jobName, String jobGroupName)
/*     */   {
/*     */     try
/*     */     {
/* 210 */       Scheduler sched = gSchedulerFactory.getScheduler();
/* 211 */       sched.triggerJob(jobName, jobGroupName);
/*     */     } catch (SchedulerException e) {
/* 213 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startJobs()
/*     */   {
/*     */     try
/*     */     {
/* 224 */       Scheduler sched = gSchedulerFactory.getScheduler();
/* 225 */       sched.start();
/*     */     } catch (SchedulerException e) {
/* 227 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void shutdownJobs()
/*     */   {
/*     */     try
/*     */     {
/* 238 */       Scheduler sched = gSchedulerFactory.getScheduler();
/* 239 */       if (!sched.isShutdown()) {
/* 240 */         sched.shutdown();
/*     */       }
/*     */     } catch (SchedulerException e) {
/* 243 */       logger.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\model\QuartzManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */