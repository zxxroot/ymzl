package com.rongdu.cashloan.rc.controller;

import com.rongdu.cashloan.core.common.web.controller.BaseController;
import com.rongdu.cashloan.rc.service.TppReqLogService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class TppReqLogController
  extends BaseController
{
  @Resource
  private TppReqLogService tppReqLogService;
}
