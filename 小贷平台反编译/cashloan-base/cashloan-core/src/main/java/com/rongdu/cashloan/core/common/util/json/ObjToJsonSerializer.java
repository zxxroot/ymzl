package com.rongdu.cashloan.core.common.util.json;

public abstract interface ObjToJsonSerializer
{
  public abstract String objectToJsonString(Object paramObject, String[] paramArrayOfString, Boolean paramBoolean);
  
  public abstract String objectToJsonString(Object paramObject);
  
  public abstract String objectToJsonStringWithInclude(Object paramObject, String[] paramArrayOfString);
  
  public abstract String objectToJsonStringWithExclude(Object paramObject, String[] paramArrayOfString);
}
