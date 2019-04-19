package com.cashloan.cl.mapper;

import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface SystemCountMapper
{
  public abstract Integer countRegister(Map<String, Object> paramMap);
  
  public abstract Integer countLogin(Map<String, Object> paramMap);
  
  public abstract double countBorrow(Map<String, Object> paramMap);
  
  public abstract double countBorrowPass(Map<String, Object> paramMap);
  
  public abstract Integer countBorrowLoan(Map<String, Object> paramMap);
  
  public abstract Integer countBorrowRepay(Map<String, Object> paramMap);
  
  public abstract Integer countBorrowLoanHistory();
  
  public abstract Integer countBorrowRepayHistory();
  
  public abstract Double sumBorrowNeedRepay();
  
  public abstract Double sumBorrowOverdueRepay();
  
  public abstract String sumBorrowAmtByProvince(String paramString);
  
  public abstract String sumBorrowRepayByProvince(String paramString);
  
  public abstract String countRegisterByProvince(String paramString);
  
  public abstract List<Map<String, Object>> countFifteenDaysLoan();
  
  public abstract List<Map<String, Object>> countRepaySource();
  
  public abstract List<Map<String, Object>> countFifteenDaysNeedRepay();
  
  public abstract List<Map<String, Object>> countFifteenDaysRealRepay();
  
  public abstract double countBorrow2(Map<String, Object> paramMap);
  
  public abstract double countBorrowPass2(Map<String, Object> paramMap);
  
  public abstract int countUnReviewLoanOrderNum();
  
  public abstract int countCuishou();
  
  public abstract int countReviewPay();
  
  public abstract int countCallback();
}
