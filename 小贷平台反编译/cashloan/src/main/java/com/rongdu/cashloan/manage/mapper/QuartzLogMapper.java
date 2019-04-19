package com.rongdu.cashloan.manage.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.manage.domain.QuartzLog;
import com.rongdu.cashloan.manage.model.QuartzLogModel;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

@RDBatisDao
public abstract interface QuartzLogMapper
  extends BaseMapper<QuartzLog, Long>
{
  public abstract String findLastTimeByQzInfoId(@Param("quartzId") Long paramLong);
  
  public abstract List<QuartzLogModel> page(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\mapper\QuartzLogMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */