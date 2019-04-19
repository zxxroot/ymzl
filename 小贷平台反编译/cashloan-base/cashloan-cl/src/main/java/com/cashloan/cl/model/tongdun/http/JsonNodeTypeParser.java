package com.cashloan.cl.model.tongdun.http;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Observer;

public abstract interface JsonNodeTypeParser
  extends Observer
{
  public abstract Object onTargetNode(List<JSONObject> paramList, String paramString)
    throws Exception;
  
  public abstract void onTargetPreviousNode(List<JSONObject> paramList, String paramString)
    throws Exception;
}
