package com.cashloan.cl.model;

import com.cashloan.cl.domain.PayLog;

public class PayLogModel
  extends PayLog
{
  private static final long serialVersionUID = 1L;
  public static final String STATE_PAYMENT_WAIT = "10";
  public static final String STATE_PENDING_REVIEW = "15";
  public static final String STATE_AUDIT_PASSED = "20";
  public static final String STATE_AUDIT_NOT_PASS = "30";
  public static final String STATE_PAYMENT_SUCCESS = "40";
  public static final String STATE_PAYMENT_FAILED = "50";
  public static final String SOURCE_FUNDS_OWN = "10";
  public static final String SOURCE_FUNDS_OTHER = "20";
  public static final String TYPE_PAYMENT = "10";
  public static final String TYPE_COLLECT = "20";
  public static final String TYPE_OFFLINE_PAYMENT = "30";
  public static final String TYPE_OFFLINE_COLLECT = "40";
  public static final String SCENES_LOANS = "10";
  public static final String SCENES_PROFIT = "11";
  public static final String SCENES_REFUND = "12";
  public static final String SCENES_REPAYMENT = "20";
  public static final String SCENES_TASK_REPAYMENT = "50";
  public static final String SCENES_DEDUCTION = "21";
}
