package com.rongdu.cashloan.system.permission.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermission
{
  String code();
  
  String name();
}


/* Location:              D:\workspace\cashloan\cashloan-core\src\main\java\!\com\rongdu\cashloan\system\permission\annotation\RequiresPermission.class

 */