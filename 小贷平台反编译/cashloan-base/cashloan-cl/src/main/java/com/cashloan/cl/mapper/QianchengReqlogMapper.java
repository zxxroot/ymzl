package com.cashloan.cl.mapper;

import com.cashloan.cl.domain.QianchengReqlog;
import com.cashloan.cl.model.QianchengReqlogModel;
import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface QianchengReqlogMapper
  extends BaseMapper<QianchengReqlog, Long>
{
  public abstract int demoSave(QianchengReqlog paramQianchengReqlog);
  
  public abstract QianchengReqlog findByOrderNo(@Param("orderNo") String paramString);
  
  public abstract List<QianchengReqlogModel> listQianchengReqlog(Map<String, Object> paramMap);
  
  public abstract QianchengReqlog findByBorrowId(@Param("borrowId") Long paramLong);
}
