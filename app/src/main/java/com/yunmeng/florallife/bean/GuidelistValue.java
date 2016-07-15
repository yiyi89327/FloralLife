package com.yunmeng.florallife.bean;

import java.util.List;

/**
 * Created by 59857 on 2016/7/14.
 */
public class GuidelistValue {

    /**
     * msg : 获取成功
     * result : [{"createDate":"2015-09-17 10:00:16.0","id":"79eb0990-3cfd-4d6f-aabd-93ba001d0076","name":"家居庭院","order":7},{"createDate":"2015-08-21 18:54:03.0","id":"ef590bfe-47f2-11e5-a94d-f0def1b6f49e","name":"缤纷小物","order":6},{"createDate":"2016-04-29 14:51:21.0","id":"1fe2ea84-ea8e-45bc-addf-75c0a4451b63","name":"奇葩之物","order":5},{"createDate":"2015-09-22 15:22:12.0","id":"a56aa5d0-aa6b-42b7-967d-59b77771e6eb","name":"花田秘籍","order":3},{"createDate":"2015-09-22 16:44:04.0","id":"8e665b7f-2bf5-466e-993b-feca8f39db56","name":"跨界鉴赏","order":2},{"createDate":"2015-09-24 13:52:41.0","id":"a9b9bb7f-3b50-4291-9706-05c69742a32f","name":"城市微光","order":1},{"createDate":"2016-06-06 18:33:52.0","id":"649e2ff5-f03d-4305-a0eb-c53193cadfef","name":"花间小事","order":0}]
     * status : true
     */

    public String msg;
    public boolean status;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    /**
     * createDate : 2015-09-17 10:00:16.0
     * id : 79eb0990-3cfd-4d6f-aabd-93ba001d0076
     * name : 家居庭院
     * order : 7
     */

    public List<ResultBean> result;

    public static class ResultBean {
        public String createDate;
        public String id;
        public String name;
        public int order;

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }
}
