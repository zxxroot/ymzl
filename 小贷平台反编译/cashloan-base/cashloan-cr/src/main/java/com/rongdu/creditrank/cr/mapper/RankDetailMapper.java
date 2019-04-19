package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.RankDetail;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface RankDetailMapper
  extends BaseMapper<RankDetail, Long>
{
  public abstract RankDetail findByParentIdAndScore(@Param("id") Long paramLong, @Param("score") Integer paramInteger);
}


/* Location:              D:\workspace\cashloan\cashloan-cr\src\main\java\!\com\rongdu\creditrank\cr\mapper\RankDetailMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */