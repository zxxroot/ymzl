package com.cashloan.cl.service;

import com.cashloan.cl.model.*;
import com.github.pagehelper.Page;
import com.rongdu.cashloan.core.common.service.BaseService;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.rule.domain.RuleEngineConfig;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract interface ClBorrowService
  extends BaseService<Borrow, Long>
{
  public abstract String verifyBorrow(Borrow paramBorrow, String paramString);
  
  public abstract void saveQcResult(String paramString, Borrow paramBorrow);
  
  public abstract boolean isCanBorrow(Borrow paramBorrow, String paramString);
  
  public abstract Borrow saveBorrow(Borrow paramBorrow);
  
  public abstract int modifyState(long paramLong, String paramString);
  
  public abstract void savePressState(Borrow paramBorrow, String paramString);
  
  public abstract int modifyCredit(Long paramLong, double paramDouble, String paramString);
  
  public abstract Map<String, Object> findIndex(String paramString);
  
  public abstract Map<String, Object> choice(double paramDouble, String paramString);
  
  public abstract List<Map<String, Object>> choices();
  
  public abstract List<Borrow> findBorrowByMap(Map<String, Object> paramMap);
  
  public abstract List<IndexModel> listIndex();
  
  public abstract List<RepayModel> findRepay(Map<String, Object> paramMap);
  
  public abstract Page<ClBorrowModel> page(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Page<ManageBorrowModel> listModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract int updateSelective(Map<String, Object> paramMap);
  
  public abstract Map<String, Object> findResult(long paramLong);
  
  public abstract List<ManageBorrowTestModel> seleteUser();
  
  public abstract void borrowLoan(Borrow paramBorrow, Date paramDate);
  
  public abstract int manualVerifyBorrow(Long paramLong1, String paramString1, String paramString2, Long paramLong2);
  
  public abstract Page<ManageBorrowModel> listBorrowModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Page<ManageBorrowModel> listBorrow(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract ManageBorrowModel getModelByBorrowId(long paramLong);
  
  public abstract Borrow findLast(Map<String, Object> paramMap);
  
  public abstract List<BorrowProgressModel> borrowProgress(Borrow paramBorrow, String paramString);
  
  public abstract void updatePayState(Map<String, Object> paramMap);
  
  public abstract Borrow findByPrimary(Long paramLong);
  
  public abstract Borrow rcBorrowApply(Borrow paramBorrow, String paramString1, String paramString2)
    throws Exception;
  
  public abstract void rcBorrowRuleVerify(Long paramLong, String paramString);
  
  public abstract void syncSceneBusinessLog(Long paramLong, String paramString1, int paramInt, String paramString2);
  
  public abstract Map<String, Object> syncSceneBusinessLog(String paramString1, Long paramLong, String paramString2, int paramInt);
  
  public abstract Map<String, Object> syncSceneBusinessLog(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void syncSceneBusinessLog(String paramString1, String paramString2, Long paramLong, String paramString3);
  
  public abstract List listBorrow(Map<String, Object> paramMap);
  
  public abstract void verifyBorrowData(long paramLong1, long paramLong2);
  
  public abstract void reVerifyBorrowData(Long paramLong);
  
  public abstract Page<ManageBorrowModel> listReview(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<Borrow> findUserUnFinishedBorrow(long paramLong);
  
  public abstract Borrow findLastBorrow(long paramLong);
  
  public abstract void rcRealAuthApply(String paramString1, String paramString2);
  
  public abstract Map<String, Object> verifyRealAuthData(String paramString1, String paramString2);
  
  public abstract List<RuleEngineConfig> findRuleEnginConfigForBorrow(@Param("adaptedId") String paramString);
  
  public abstract ManageBorrowTotalModel totalBorrow(Map<String, Object> paramMap);
  
  public abstract List<GPSModel> listUserGPS(long paramLong);
  
  public abstract List<GPSModel> listBorrowGPS(long paramLong);
  
  public abstract void rcRegisterApply(String paramString1, String paramString2);
  
  public abstract boolean verifyRegisterData(String paramString1, String paramString2);
  
  public abstract Map<String, Object> borrowOrLogin(String paramString);
  
  public abstract Map<String, Long> countRiskBorrow(Long paramLong);
  
  public abstract Page<ManageCreditReviewModel> listReviewModel(Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract List<Long> listOrder(Map<String, Object> paramMap);
  
  public abstract List<?> listReview(Map<String, Object> paramMap);
  
  public abstract void giveOrder(List<Long> paramList, List<Map<String, Object>> paramList1);
  
  public abstract String isRiskBorrow(Long paramLong);
}
