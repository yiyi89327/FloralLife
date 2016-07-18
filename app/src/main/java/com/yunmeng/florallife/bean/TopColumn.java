package com.yunmeng.florallife.bean;

import java.util.List;

/**
 * Top中的专栏的类
 * Created by hanyiyi on 2016/7/13.
 */
public class TopColumn {


    public String msg;
    public boolean status;


    public List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        public int appoint;
        public Object author;
        public Object category;
        public boolean check;
        public String content;
        public String content2;
        public String content3;
        public String contentTitle1;
        public String contentTitle2;
        public String contentTitle3;
        public String createDate;
        public String desc;
        public String descIcon;
        public String descTitle;
        public int favo;
        public int fnCommentNum;
        public int fnCuringNum;
        public int fnDifficultyNum;
        public String fnGoodsIds;
        public int fnHumidityNum;
        public int fnIsVph;
        public int fnVphReadNum;
        public boolean hasAddFavo;
        public boolean hasAppoint;
        public String id;
        public String keywords;
        public int newAppoint;
        public int newFavo;
        public int newRead;
        public int order;
        public String pageUrl;
        public int pass;
        public String pushTime;
        public int read;
        public int share;
        public String sharePageUrl;
        public String smallIcon;
        public String title;
        public boolean top;
        public boolean video;
        public String videoUrl;
        public List<?> goodsList;

        public int getAppoint() {
            return appoint;
        }

        public void setAppoint(int appoint) {
            this.appoint = appoint;
        }

        public Object getAuthor() {
            return author;
        }

        public void setAuthor(Object author) {
            this.author = author;
        }

        public Object getCategory() {
            return category;
        }

        public void setCategory(Object category) {
            this.category = category;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent2() {
            return content2;
        }

        public void setContent2(String content2) {
            this.content2 = content2;
        }

        public String getContent3() {
            return content3;
        }

        public void setContent3(String content3) {
            this.content3 = content3;
        }

        public String getContentTitle1() {
            return contentTitle1;
        }

        public void setContentTitle1(String contentTitle1) {
            this.contentTitle1 = contentTitle1;
        }

        public String getContentTitle2() {
            return contentTitle2;
        }

        public void setContentTitle2(String contentTitle2) {
            this.contentTitle2 = contentTitle2;
        }

        public String getContentTitle3() {
            return contentTitle3;
        }

        public void setContentTitle3(String contentTitle3) {
            this.contentTitle3 = contentTitle3;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDescIcon() {
            return descIcon;
        }

        public void setDescIcon(String descIcon) {
            this.descIcon = descIcon;
        }

        public String getDescTitle() {
            return descTitle;
        }

        public void setDescTitle(String descTitle) {
            this.descTitle = descTitle;
        }

        public int getFavo() {
            return favo;
        }

        public void setFavo(int favo) {
            this.favo = favo;
        }

        public int getFnCommentNum() {
            return fnCommentNum;
        }

        public void setFnCommentNum(int fnCommentNum) {
            this.fnCommentNum = fnCommentNum;
        }

        public int getFnCuringNum() {
            return fnCuringNum;
        }

        public void setFnCuringNum(int fnCuringNum) {
            this.fnCuringNum = fnCuringNum;
        }

        public int getFnDifficultyNum() {
            return fnDifficultyNum;
        }

        public void setFnDifficultyNum(int fnDifficultyNum) {
            this.fnDifficultyNum = fnDifficultyNum;
        }

        public String getFnGoodsIds() {
            return fnGoodsIds;
        }

        public void setFnGoodsIds(String fnGoodsIds) {
            this.fnGoodsIds = fnGoodsIds;
        }

        public int getFnHumidityNum() {
            return fnHumidityNum;
        }

        public void setFnHumidityNum(int fnHumidityNum) {
            this.fnHumidityNum = fnHumidityNum;
        }

        public int getFnIsVph() {
            return fnIsVph;
        }

        public void setFnIsVph(int fnIsVph) {
            this.fnIsVph = fnIsVph;
        }

        public int getFnVphReadNum() {
            return fnVphReadNum;
        }

        public void setFnVphReadNum(int fnVphReadNum) {
            this.fnVphReadNum = fnVphReadNum;
        }

        public boolean isHasAddFavo() {
            return hasAddFavo;
        }

        public void setHasAddFavo(boolean hasAddFavo) {
            this.hasAddFavo = hasAddFavo;
        }

        public boolean isHasAppoint() {
            return hasAppoint;
        }

        public void setHasAppoint(boolean hasAppoint) {
            this.hasAppoint = hasAppoint;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public int getNewAppoint() {
            return newAppoint;
        }

        public void setNewAppoint(int newAppoint) {
            this.newAppoint = newAppoint;
        }

        public int getNewFavo() {
            return newFavo;
        }

        public void setNewFavo(int newFavo) {
            this.newFavo = newFavo;
        }

        public int getNewRead() {
            return newRead;
        }

        public void setNewRead(int newRead) {
            this.newRead = newRead;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getPageUrl() {
            return pageUrl;
        }

        public void setPageUrl(String pageUrl) {
            this.pageUrl = pageUrl;
        }

        public int getPass() {
            return pass;
        }

        public void setPass(int pass) {
            this.pass = pass;
        }

        public String getPushTime() {
            return pushTime;
        }

        public void setPushTime(String pushTime) {
            this.pushTime = pushTime;
        }

        public int getRead() {
            return read;
        }

        public void setRead(int read) {
            this.read = read;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public String getSharePageUrl() {
            return sharePageUrl;
        }

        public void setSharePageUrl(String sharePageUrl) {
            this.sharePageUrl = sharePageUrl;
        }

        public String getSmallIcon() {
            return smallIcon;
        }

        public void setSmallIcon(String smallIcon) {
            this.smallIcon = smallIcon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isTop() {
            return top;
        }

        public void setTop(boolean top) {
            this.top = top;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public List<?> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<?> goodsList) {
            this.goodsList = goodsList;
        }
    }
}
