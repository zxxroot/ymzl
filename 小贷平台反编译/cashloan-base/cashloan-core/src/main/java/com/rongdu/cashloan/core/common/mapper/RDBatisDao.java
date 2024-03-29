package com.rongdu.cashloan.core.common.mapper;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@Documented
@Component
public @interface RDBatisDao
{
  String value() default "";
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\core\common\mapper\RDBatisDao.class

 */