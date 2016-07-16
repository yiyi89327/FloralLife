package com.yunmeng.florallife.bean;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by my on 2016/7/15.
 */
public class PersonalCenter {


    /**
     * msg : 获取数据成功
     * result : {"articleCount":0,"attentionCount":0,"attentioned":false,"auth":"专家","birthday":"","championM":false,"championW":false,"championY":false,"city":"北京,朝阳","content":"曹雪也是曹小花","countryCode":"86","createDate":"2015-11-04 19:11:28.0","dingYue":false,"email":"","experience":984,"fansCount":0,"gag":false,"gagBeginDate":"","gagEndDate":"","headImg":"http://m.htxq.net//UploadFiles/headimg/20160531184033453.jpg","id":"493a5ab4-e5ab-43bd-9586-58aea47bed5d","identity":"花艺家","imQQ":"","imWeibo":"","imWeixin":"oXJjcs5Ay_gtJEzzAvx2SOBL6Cq4","integral":17122,"j_PUSH_CODE":"091c867f846","jian":false,"level":6,"listContent":[{"contentFirst":"知名花艺设计师，被誉为\u201c当代花艺界的魔术师\u201d","contentSecond":"","contentThird":"","fnId":"863ff77e-70d8-4f7a-9301-71faecfc1f96","fnUserID":""},{"contentFirst":"美国花艺学院认证教授","contentSecond":"","contentThird":"","fnId":"2b6e6be4-5cae-46b9-af61-da0c99eb6953","fnUserID":""},{"contentFirst":"WFC世界花卉设计师协会会员","contentSecond":"","contentThird":"","fnId":"fad9c8ec-94a6-44c5-a99f-5673946d02c7","fnUserID":""},{"contentFirst":"《新娘modernbride》特邀明星封面花艺设计师","contentSecond":"","contentThird":"","fnId":"5e652bf0-bf54-49d3-9b5c-20889f442a83","fnUserID":""},{"contentFirst":"国内首位举办个人花艺展览者","contentSecond":"","contentThird":"","fnId":"47691d1e-801a-4f4c-b4c1-71661a23f25b","fnUserID":""}],"loginDate":"","market":"","mobile":"13811624090","newAuth":"2","newPassword":"","occSelected":1,"occupation":"","password":"baaac342c725c95dee15389d13117bbc","realName":"","sex":"男","speciality":"","state":"ONLINE","subscibeNum":5153,"terminal":"ios","token":"","uplevelPercent":"0.98","userName":"曹小花","validDate_M":"","validDate_W":"","validDate_Y":""}
     * status : true
     */

    private String msg;
    /**
     * articleCount : 0
     * attentionCount : 0
     * attentioned : false
     * auth : 专家
     * birthday :
     * championM : false
     * championW : false
     * championY : false
     * city : 北京,朝阳
     * content : 曹雪也是曹小花
     * countryCode : 86
     * createDate : 2015-11-04 19:11:28.0
     * dingYue : false
     * email :
     * experience : 984
     * fansCount : 0
     * gag : false
     * gagBeginDate :
     * gagEndDate :
     * headImg : http://m.htxq.net//UploadFiles/headimg/20160531184033453.jpg
     * id : 493a5ab4-e5ab-43bd-9586-58aea47bed5d
     * identity : 花艺家
     * imQQ :
     * imWeibo :
     * imWeixin : oXJjcs5Ay_gtJEzzAvx2SOBL6Cq4
     * integral : 17122
     * j_PUSH_CODE : 091c867f846
     * jian : false
     * level : 6
     * listContent : [{"contentFirst":"知名花艺设计师，被誉为\u201c当代花艺界的魔术师\u201d","contentSecond":"","contentThird":"","fnId":"863ff77e-70d8-4f7a-9301-71faecfc1f96","fnUserID":""},{"contentFirst":"美国花艺学院认证教授","contentSecond":"","contentThird":"","fnId":"2b6e6be4-5cae-46b9-af61-da0c99eb6953","fnUserID":""},{"contentFirst":"WFC世界花卉设计师协会会员","contentSecond":"","contentThird":"","fnId":"fad9c8ec-94a6-44c5-a99f-5673946d02c7","fnUserID":""},{"contentFirst":"《新娘modernbride》特邀明星封面花艺设计师","contentSecond":"","contentThird":"","fnId":"5e652bf0-bf54-49d3-9b5c-20889f442a83","fnUserID":""},{"contentFirst":"国内首位举办个人花艺展览者","contentSecond":"","contentThird":"","fnId":"47691d1e-801a-4f4c-b4c1-71661a23f25b","fnUserID":""}]
     * loginDate :
     * market :
     * mobile : 13811624090
     * newAuth : 2
     * newPassword :
     * occSelected : 1
     * occupation :
     * password : baaac342c725c95dee15389d13117bbc
     * realName :
     * sex : 男
     * speciality :
     * state : ONLINE
     * subscibeNum : 5153
     * terminal : ios
     * token :
     * uplevelPercent : 0.98
     * userName : 曹小花
     * validDate_M :
     * validDate_W :
     * validDate_Y :
     */

    private ResultBean result;
    private boolean status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class ResultBean implements Serializable {
        private int articleCount;
        private int attentionCount;
        private boolean attentioned;
        private String auth;
        private String birthday;
        private boolean championM;
        private boolean championW;
        private boolean championY;
        private String city;
        private String content;
        private String countryCode;
        private String createDate;
        private boolean dingYue;
        private String email;
        private int experience;
        private int fansCount;
        private boolean gag;
        private String gagBeginDate;
        private String gagEndDate;
        private String headImg;
        private String id;
        private String identity;
        private String imQQ;
        private String imWeibo;
        private String imWeixin;
        private int integral;
        private String j_PUSH_CODE;
        private boolean jian;
        private int level;
        private String loginDate;
        private String market;
        private String mobile;
        private String newAuth;
        private String newPassword;
        private int occSelected;
        private String occupation;
        private String password;
        private String realName;
        private String sex;
        private String speciality;
        private String state;
        private int subscibeNum;
        private String terminal;
        private String token;
        private String uplevelPercent;
        private String userName;
        private String validDate_M;
        private String validDate_W;
        private String validDate_Y;
        /**
         * contentFirst : 知名花艺设计师，被誉为“当代花艺界的魔术师”
         * contentSecond :
         * contentThird :
         * fnId : 863ff77e-70d8-4f7a-9301-71faecfc1f96
         * fnUserID :
         */

        private List<ListContentBean> listContent;

        public int getArticleCount() {
            return articleCount;
        }

        public void setArticleCount(int articleCount) {
            this.articleCount = articleCount;
        }

        public int getAttentionCount() {
            return attentionCount;
        }

        public void setAttentionCount(int attentionCount) {
            this.attentionCount = attentionCount;
        }

        public boolean isAttentioned() {
            return attentioned;
        }

        public void setAttentioned(boolean attentioned) {
            this.attentioned = attentioned;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public boolean isChampionM() {
            return championM;
        }

        public void setChampionM(boolean championM) {
            this.championM = championM;
        }

        public boolean isChampionW() {
            return championW;
        }

        public void setChampionW(boolean championW) {
            this.championW = championW;
        }

        public boolean isChampionY() {
            return championY;
        }

        public void setChampionY(boolean championY) {
            this.championY = championY;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public boolean isDingYue() {
            return dingYue;
        }

        public void setDingYue(boolean dingYue) {
            this.dingYue = dingYue;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public boolean isGag() {
            return gag;
        }

        public void setGag(boolean gag) {
            this.gag = gag;
        }

        public String getGagBeginDate() {
            return gagBeginDate;
        }

        public void setGagBeginDate(String gagBeginDate) {
            this.gagBeginDate = gagBeginDate;
        }

        public String getGagEndDate() {
            return gagEndDate;
        }

        public void setGagEndDate(String gagEndDate) {
            this.gagEndDate = gagEndDate;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getImQQ() {
            return imQQ;
        }

        public void setImQQ(String imQQ) {
            this.imQQ = imQQ;
        }

        public String getImWeibo() {
            return imWeibo;
        }

        public void setImWeibo(String imWeibo) {
            this.imWeibo = imWeibo;
        }

        public String getImWeixin() {
            return imWeixin;
        }

        public void setImWeixin(String imWeixin) {
            this.imWeixin = imWeixin;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getJ_PUSH_CODE() {
            return j_PUSH_CODE;
        }

        public void setJ_PUSH_CODE(String j_PUSH_CODE) {
            this.j_PUSH_CODE = j_PUSH_CODE;
        }

        public boolean isJian() {
            return jian;
        }

        public void setJian(boolean jian) {
            this.jian = jian;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(String loginDate) {
            this.loginDate = loginDate;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNewAuth() {
            return newAuth;
        }

        public void setNewAuth(String newAuth) {
            this.newAuth = newAuth;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }

        public int getOccSelected() {
            return occSelected;
        }

        public void setOccSelected(int occSelected) {
            this.occSelected = occSelected;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getSubscibeNum() {
            return subscibeNum;
        }

        public void setSubscibeNum(int subscibeNum) {
            this.subscibeNum = subscibeNum;
        }

        public String getTerminal() {
            return terminal;
        }

        public void setTerminal(String terminal) {
            this.terminal = terminal;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUplevelPercent() {
            return uplevelPercent;
        }

        public void setUplevelPercent(String uplevelPercent) {
            this.uplevelPercent = uplevelPercent;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getValidDate_M() {
            return validDate_M;
        }

        public void setValidDate_M(String validDate_M) {
            this.validDate_M = validDate_M;
        }

        public String getValidDate_W() {
            return validDate_W;
        }

        public void setValidDate_W(String validDate_W) {
            this.validDate_W = validDate_W;
        }

        public String getValidDate_Y() {
            return validDate_Y;
        }

        public void setValidDate_Y(String validDate_Y) {
            this.validDate_Y = validDate_Y;
        }

        public List<ListContentBean> getListContent() {
            return listContent;
        }

        public void setListContent(List<ListContentBean> listContent) {
            this.listContent = listContent;
        }

        public static class ListContentBean {
            private String contentFirst;
            private String contentSecond;
            private String contentThird;
            private String fnId;
            private String fnUserID;

            public String getContentFirst() {
                return contentFirst;
            }

            public void setContentFirst(String contentFirst) {
                this.contentFirst = contentFirst;
            }

            public String getContentSecond() {
                return contentSecond;
            }

            public void setContentSecond(String contentSecond) {
                this.contentSecond = contentSecond;
            }

            public String getContentThird() {
                return contentThird;
            }

            public void setContentThird(String contentThird) {
                this.contentThird = contentThird;
            }

            public String getFnId() {
                return fnId;
            }

            public void setFnId(String fnId) {
                this.fnId = fnId;
            }

            public String getFnUserID() {
                return fnUserID;
            }

            public void setFnUserID(String fnUserID) {
                this.fnUserID = fnUserID;
            }

            ///////////////////////////////////////////////////////////////

            @Override
            public String toString() {
                return "ListContentBean{" +
                        "contentFirst='" + contentFirst + '\'' +
                        ", contentSecond='" + contentSecond + '\'' +
                        ", contentThird='" + contentThird + '\'' +
                        ", fnId='" + fnId + '\'' +
                        ", fnUserID='" + fnUserID + '\'' +
                        '}';
            }

            //////////////////////////////////////////////////////////////////
        }
    }
}
