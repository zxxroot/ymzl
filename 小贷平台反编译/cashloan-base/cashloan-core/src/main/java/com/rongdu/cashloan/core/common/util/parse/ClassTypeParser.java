package com.rongdu.cashloan.core.common.util.parse;

public abstract interface ClassTypeParser
{
  public abstract <T> T parse(String paramString, Class<T> paramClass);
}


/* parse\ClassTypeParser.class

 */