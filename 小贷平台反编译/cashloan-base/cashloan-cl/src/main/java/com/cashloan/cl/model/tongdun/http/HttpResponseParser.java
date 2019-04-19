package com.cashloan.cl.model.tongdun.http;

import org.springframework.http.ResponseEntity;

public abstract interface HttpResponseParser<T extends HttpRestResponse>
{
  public abstract T handle(ResponseEntity<String> paramResponseEntity)
    throws HttpRestException;
}
