package com.yunmeng.florallife.bean;

import java.util.List;

/**
 * Created by 59857 on 2016/7/18.
 */
public class HeadImgValue {


    /**
     * status : true
     * msg : 操作成功
     * result : [{"fnId":"639d300f-0a66-4aca-af61-13d1294a6c60","fnAid":"c42a3c6f-6c75-427e-b590-05c512137fa0","fnTitle":"\u201c深灰迷影\u201d花瓶","fnStartDate":1468166400000,"fnEndDate":1469289600000,"fnImageUrl":"http://static.htxq.net/UploadFiles/2016/07/10/20160710225704092472.jpg","fnUrl":"bbc99e6d-4f45-4b3e-aba8-1bcf25364dd9","fnContent":null,"fnEnable":1,"fnCreateDate":null,"fnType":"0","fnOrder":1}]
     */

    public boolean status;
    public String msg;
    /**
     * fnId : 639d300f-0a66-4aca-af61-13d1294a6c60
     * fnAid : c42a3c6f-6c75-427e-b590-05c512137fa0
     * fnTitle : “深灰迷影”花瓶
     * fnStartDate : 1468166400000
     * fnEndDate : 1469289600000
     * fnImageUrl : http://static.htxq.net/UploadFiles/2016/07/10/20160710225704092472.jpg
     * fnUrl : bbc99e6d-4f45-4b3e-aba8-1bcf25364dd9
     * fnContent : null
     * fnEnable : 1
     * fnCreateDate : null
     * fnType : 0
     * fnOrder : 1
     */

    public List<ResultBean> result;

    public static class ResultBean {
        public String fnId;
        public String fnAid;
        public String fnTitle;
        public long fnStartDate;
        public long fnEndDate;
        public String fnImageUrl;
        public String fnUrl;
        public Object fnContent;
        public int fnEnable;
        public Object fnCreateDate;
        public String fnType;
        public int fnOrder;

        public String getFnId() {
            return fnId;
        }

        public void setFnId(String fnId) {
            this.fnId = fnId;
        }

        public String getFnAid() {
            return fnAid;
        }

        public void setFnAid(String fnAid) {
            this.fnAid = fnAid;
        }

        public String getFnTitle() {
            return fnTitle;
        }

        public void setFnTitle(String fnTitle) {
            this.fnTitle = fnTitle;
        }

        public long getFnStartDate() {
            return fnStartDate;
        }

        public void setFnStartDate(long fnStartDate) {
            this.fnStartDate = fnStartDate;
        }

        public long getFnEndDate() {
            return fnEndDate;
        }

        public void setFnEndDate(long fnEndDate) {
            this.fnEndDate = fnEndDate;
        }

        public String getFnImageUrl() {
            return fnImageUrl;
        }

        public void setFnImageUrl(String fnImageUrl) {
            this.fnImageUrl = fnImageUrl;
        }

        public String getFnUrl() {
            return fnUrl;
        }

        public void setFnUrl(String fnUrl) {
            this.fnUrl = fnUrl;
        }

        public Object getFnContent() {
            return fnContent;
        }

        public void setFnContent(Object fnContent) {
            this.fnContent = fnContent;
        }

        public int getFnEnable() {
            return fnEnable;
        }

        public void setFnEnable(int fnEnable) {
            this.fnEnable = fnEnable;
        }

        public Object getFnCreateDate() {
            return fnCreateDate;
        }

        public void setFnCreateDate(Object fnCreateDate) {
            this.fnCreateDate = fnCreateDate;
        }

        public String getFnType() {
            return fnType;
        }

        public void setFnType(String fnType) {
            this.fnType = fnType;
        }

        public int getFnOrder() {
            return fnOrder;
        }

        public void setFnOrder(int fnOrder) {
            this.fnOrder = fnOrder;
        }
    }
}
