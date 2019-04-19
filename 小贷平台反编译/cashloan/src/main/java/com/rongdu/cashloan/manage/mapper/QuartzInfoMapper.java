package com.rongdu.cashloan.manage.mapper;

import com.rongdu.cashloan.core.common.mapper.BaseMapper;
import com.rongdu.cashloan.core.common.mapper.RDBatisDao;
import com.rongdu.cashloan.manage.domain.QuartzInfo;
import com.rongdu.cashloan.manage.model.QuartzInfoModel;
import java.util.List;
import java.util.Map;

@RDBatisDao
public abstract interface QuartzInfoMapper
  extends BaseMapper<QuartzInfo, Long>
{
  public abstract List<QuartzInfoModel> page(Map<String, Object> paramMap);
}


/* Location:              D:\workspace\小贷平台运行包\manage\WEB-INF\classes\!\com\rongdu\cashloan\manage\mapper\QuartzInfoMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */