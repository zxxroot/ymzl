package com.rongdu.cashloan.core.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.core.domain.Borrow;
import com.rongdu.cashloan.core.model.BorrowModel;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface BorrowMapper
  extends BaseMapper<Borrow, Long>
{
  public abstract List<BorrowModel> selectByConditions(Map<String, Object> paramMap);
  
  public abstract List<BorrowModel> findByConsumerAndBorrow(String paramString1, String paramString2);
  
  public abstract String findValidValue(@Param("statement") String paramString);
}
