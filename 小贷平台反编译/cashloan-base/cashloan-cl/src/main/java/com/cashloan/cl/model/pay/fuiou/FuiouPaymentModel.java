/*     */ package com.cashloan.cl.model.pay.fuiou;
/*     */ 
/*     */ import com.rongdu.cashloan.core.common.context.Global;
import com.rongdu.cashloan.core.common.util.OrderNoUtil;
import org.apache.http.NameValuePair;

import java.util.List;

/*     */
/*     */
/*     */
/*     */ 
/*     */ public class FuiouPaymentModel
/*     */ {
    /*  16 */   private String orderNo = OrderNoUtil.getSerialNumber();
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */   private String service;
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */   private String url;
    /*     */
    /*     */
    /*     */
    /*     */   private List<NameValuePair> params;
    /*     */
    /*     */
    /*     */
    /*  34 */   private String isCallback = "0";
    /*     */
    /*     */
    /*     */
    /*  38 */   private String busiCd = "AC01";
    /*     */
    /*     */
    /*     */
    /*  42 */   private String credtTp = "0";
    /*     */
    /*     */
    /*     */
    /*  46 */   private String srcChnl = "DSF";
    /*     */
    /*     */
    /*     */
    /*  50 */   private String acntTp = "01";
    /*     */
    /*     */
    /*     */
    /*  54 */   private String mchntCd = Global.getValue("fuiou_mchnt");
    /*     */
    /*     */
    /*     */
    /*  58 */   private String reserved1 = "备注";

    public FuiouPaymentModel() {
    }

    /*     */
    /*     */
    public String getIsCallback()
    /*     */ {
        /*  62 */
        return this.isCallback;
        /*     */
    }

    /*     */
    /*     */
    public void setIsCallback(String isCallback) {
        /*  66 */
        this.isCallback = isCallback;
        /*     */
    }

    /*     */
    /*     */
    public String getBusiCd() {
        /*  70 */
        return this.busiCd;
        /*     */
    }

    /*     */
    /*     */
    public void setBusiCd(String busiCd) {
        /*  74 */
        this.busiCd = busiCd;
        /*     */
    }

    /*     */
    /*     */
    public String getCredtTp() {
        /*  78 */
        return this.credtTp;
        /*     */
    }

    /*     */
    /*     */
    public void setCredtTp(String credtTp) {
        /*  82 */
        this.credtTp = credtTp;
        /*     */
    }

    /*     */
    /*     */
    public String getSrcChnl() {
        /*  86 */
        return this.srcChnl;
        /*     */
    }

    /*     */
    /*     */
    public void setSrcChnl(String srcChnl) {
        /*  90 */
        this.srcChnl = srcChnl;
        /*     */
    }

    /*     */
    /*     */
    public String getAcntTp() {
        /*  94 */
        return this.acntTp;
        /*     */
    }

    /*     */
    /*     */
    public void setAcntTp(String acntTp) {
        /*  98 */
        this.acntTp = acntTp;
        /*     */
    }

    /*     */
    /*     */
    public String getMchntCd() {
        /* 102 */
        return this.mchntCd;
        /*     */
    }

    /*     */
    /*     */
    public void setMchntCd(String mchntCd) {
        /* 106 */
        this.mchntCd = mchntCd;
        /*     */
    }

    /*     */
    /*     */
    public String getReserved1() {
        /* 110 */
        return this.reserved1;
        /*     */
    }

    /*     */
    /*     */
    public void setReserved1(String reserved1) {
        /* 114 */
        this.reserved1 = reserved1;
        /*     */
    }

    /*     */
    /*     */
    public String getOrderNo() {
        /* 118 */
        return this.orderNo;
        /*     */
    }

    /*     */
    /*     */
    public void setOrderNo(String orderNo) {
        /* 122 */
        this.orderNo = orderNo;
        /*     */
    }

    /*     */
    /*     */
    public String getUrl() {
        /* 126 */
        return this.url;
        /*     */
    }

    /*     */
    /*     */
    public String getService() {
        /* 130 */
        return this.service;
        /*     */
    }

    /*     */
    /*     */
    public void setService(String service) {
        /* 134 */
        this.service = service;
        /*     */
    }

    /*     */
    /*     */
    public void setUrl(String url) {
        /* 138 */
        this.url = url;
        /*     */
    }

    /*     */
    /*     */
    public List<NameValuePair> getParams() {
        /* 142 */
        return this.params;
        /*     */
    }

    public void setParams(List<NameValuePair> params) {
        /* 138 */
        this.params = params;
        /*     */
    }
}