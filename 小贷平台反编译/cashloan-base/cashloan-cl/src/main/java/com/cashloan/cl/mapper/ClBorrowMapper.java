package com.cashloan.cl.mapper;

import com.cashloan.cl.model.*;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.core.domain.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface ClBorrowMapper
  extends BaseMapper<Borrow, Long>
{
  public abstract List<Borrow> findUserUnFinishedBorrow(@Param("userId") Long paramLong);
  
  public abstract List<IndexModel> listIndex();
  
  public abstract List<ClBorrowModel> findBorrow(Map<String, Object> paramMap);
  
  public abstract List<RepayModel> findRepay(Map<String, Object> paramMap);
  
  public abstract List<RepayModel> findRepaySuccess(Map<String, Object> paramMap);
  
  public abstract List<RepayModel> compute();
  
  public abstract List<ManageBorrowModel> listModel(Map<String, Object> paramMap);
  
  public abstract List<ClBorrowModel> listAll(Map<String, Object> paramMap);
  
  public abstract List<ManageBorrowModel> listModelNotUrge(Map<String, Object> paramMap);
  
  public abstract Borrow findRepayBorrow(Map<String, Object> paramMap);
  
  public abstract List<ManageBorrowTestModel> seleteUser();
  
  public abstract int updateState(@Param("state") String paramString, @Param("id") Long paramLong);
  
  public abstract List<ManageBorrowModel> listBorrowModel(Map<String, Object> paramMap);
  
  public abstract List<ManageBorrowModel> listBorrow(Map<String, Object> paramMap);
  
  public abstract Borrow findLast(Map<String, Object> paramMap);
  
  public abstract Borrow findByUserIdAndState(Map<String, Object> paramMap);
  
  public abstract int updatePayState(Map<String, Object> paramMap);
  
  public abstract long countBorrow(long paramLong);
  
  public abstract List<ManageBorrowExportModel> listExportModel(Map<String, Object> paramMap);
  
  public abstract int reviewState(Map<String, Object> paramMap);
  
  public abstract List<ManageBorrowModel> listReview(Map<String, Object> paramMap);
  
  public abstract Borrow findLastBorrow(long paramLong);
  
  public abstract double borrowAmountSum();
  
  public abstract int userBorrowCount(long paramLong);
  
  public abstract int countService(Map<String, Object> paramMap);
  
  public abstract Map<String, String> countSuccessBorrow(Map<String, Object> paramMap);
  
  public abstract List<GPSModel> listUserGPS(long paramLong);
  
  public abstract List<GPSModel> listBorrowGPS(long paramLong);
  
  public abstract Map<String, Long> countRiskBorrow(long paramLong);
  
  public abstract List<CreditReviewTotalModel> listSysUserByRole(Map<String, Object> paramMap);
  
  public abstract List<ManageCreditReviewModel> listReviewModel(Map<String, Object> paramMap);
  
  public abstract List<Long> listOrder(Map<String, Object> paramMap);
}