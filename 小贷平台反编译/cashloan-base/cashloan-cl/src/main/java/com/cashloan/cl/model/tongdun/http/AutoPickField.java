package com.cashloan.cl.model.tongdun.http;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface AutoPickField
{
  String value() default "";
  
  Class type() default Object.class;
}
