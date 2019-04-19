package com.cashloan.cl.service;

import com.github.pagehelper.Page;
import com.cashloan.cl.model.CreditReviewTotalModel;
import java.util.Map;

public abstract interface CreditReviewService
{
  public abstract Page<CreditReviewTotalModel> memberCount(Map<String, Object> paramMap, int paramInt1, int paramInt2);
}
