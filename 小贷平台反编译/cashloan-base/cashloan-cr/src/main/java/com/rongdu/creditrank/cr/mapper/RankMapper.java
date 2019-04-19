package com.rongdu.creditrank.cr.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.creditrank.cr.domain.Rank;
import com.rongdu.creditrank.cr.model.RankModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface RankMapper
  extends BaseMapper<Rank, Long>
{
  public abstract List<Rank> findRankLeve(Long paramLong, Integer paramInteger);
  
  public abstract List<RankModel> countList();
  
  public abstract int deleteSelective(long paramLong);
  
  public abstract List<RankModel> countList(Map<String, Object> paramMap);
  
  public abstract List<Rank> findAll();
}
