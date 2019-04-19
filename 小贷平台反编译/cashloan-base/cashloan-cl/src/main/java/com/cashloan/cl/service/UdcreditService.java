package com.cashloan.cl.service;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public abstract interface UdcreditService
{
  public abstract Map<String, Object> udcredit(MultipartFile paramMultipartFile1, MultipartFile paramMultipartFile2, MultipartFile paramMultipartFile3, MultipartFile paramMultipartFile4, String paramString1, String paramString2, String paramString3)
    throws Exception;
}
