package com.yunmeng.florallife.bean;

import java.util.List;

/**
 * Created by 59857 on 2016/7/15.
 */
public class ShopGuideValue {

    /**
     * status : true
     * msg : 操作成功
     * result : [{"fnId":"8792457a-0f91-414a-9c4a-969326d6955e","fnPid":"0","fnName":"花植","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1459936511000,"fnSequence":0,"childrenMap":{},"childrenList":[{"fnId":"80d04359-6e21-4f7e-b4f8-6544b154730a","fnPid":"8792457a-0f91-414a-9c4a-969326d6955e","fnName":"鲜切花","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1461919623000,"fnSequence":0,"childrenMap":{},"childrenList":[]},{"fnId":"97f6caab-f50d-47a4-a884-462e606a36f8","fnPid":"8792457a-0f91-414a-9c4a-969326d6955e","fnName":"一周一花","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1460359080000,"fnSequence":0,"childrenMap":{},"childrenList":[]}]},{"fnId":"860885f6-9126-409a-b0c8-4f2261f19e9a","fnPid":"0","fnName":"课堂","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1459936478000,"fnSequence":0,"childrenMap":{},"childrenList":[{"fnId":"2c01c5cf-5272-4025-bf58-bce07fe1aa77","fnPid":"860885f6-9126-409a-b0c8-4f2261f19e9a","fnName":"兴趣课","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1459936483000,"fnSequence":0,"childrenMap":{},"childrenList":[]}]},{"fnId":"e11cc8f0-7ba6-4739-a1f2-f08b60476154","fnPid":"0","fnName":"杂物","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1459926027000,"fnSequence":0,"childrenMap":{},"childrenList":[{"fnId":"86617adb-1879-40cd-8735-efdcd06fa099","fnPid":"e11cc8f0-7ba6-4739-a1f2-f08b60476154","fnName":"花器","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1465994360000,"fnSequence":0,"childrenMap":{},"childrenList":[]},{"fnId":"8ac8dc7d-bc26-4818-b9a2-f359b6226495","fnPid":"e11cc8f0-7ba6-4739-a1f2-f08b60476154","fnName":"工具","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1461051182000,"fnSequence":0,"childrenMap":{},"childrenList":[]},{"fnId":"1cf8a184-1304-4d5f-889d-cf494b9437f7","fnPid":"e11cc8f0-7ba6-4739-a1f2-f08b60476154","fnName":"书籍","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1460964951000,"fnSequence":0,"childrenMap":{},"childrenList":[]},{"fnId":"62650583-8624-4738-ba70-0642901a2d66","fnPid":"e11cc8f0-7ba6-4739-a1f2-f08b60476154","fnName":"周边","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1459935594000,"fnSequence":0,"childrenMap":{},"childrenList":[]}]}]
     */

    public boolean status;
    public String msg;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    /**
     * fnId : 8792457a-0f91-414a-9c4a-969326d6955e
     * fnPid : 0
     * fnName : 花植
     * fnPic : null
     * fnMerchantsId : htxq
     * fnDesc : null
     * fnIsUse : 1
     * fnCreateDate : 1459936511000
     * fnSequence : 0
     * childrenMap : {}
     * childrenList : [{"fnId":"80d04359-6e21-4f7e-b4f8-6544b154730a","fnPid":"8792457a-0f91-414a-9c4a-969326d6955e","fnName":"鲜切花","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1461919623000,"fnSequence":0,"childrenMap":{},"childrenList":[]},{"fnId":"97f6caab-f50d-47a4-a884-462e606a36f8","fnPid":"8792457a-0f91-414a-9c4a-969326d6955e","fnName":"一周一花","fnPic":null,"fnMerchantsId":"htxq","fnDesc":null,"fnIsUse":1,"fnCreateDate":1460359080000,"fnSequence":0,"childrenMap":{},"childrenList":[]}]
     */

    public List<ResultBean> result;

    public static class ResultBean {
        public String fnId;
        public String fnPid;
        public String fnName;
        public Object fnPic;
        public String fnMerchantsId;
        public Object fnDesc;
        public int fnIsUse;
        public long fnCreateDate;
        public int fnSequence;

        public String getFnId() {
            return fnId;
        }

        public void setFnId(String fnId) {
            this.fnId = fnId;
        }

        public String getFnPid() {
            return fnPid;
        }

        public void setFnPid(String fnPid) {
            this.fnPid = fnPid;
        }

        public String getFnName() {
            return fnName;
        }

        public void setFnName(String fnName) {
            this.fnName = fnName;
        }

        public Object getFnPic() {
            return fnPic;
        }

        public void setFnPic(Object fnPic) {
            this.fnPic = fnPic;
        }

        public String getFnMerchantsId() {
            return fnMerchantsId;
        }

        public void setFnMerchantsId(String fnMerchantsId) {
            this.fnMerchantsId = fnMerchantsId;
        }

        public Object getFnDesc() {
            return fnDesc;
        }

        public void setFnDesc(Object fnDesc) {
            this.fnDesc = fnDesc;
        }

        public int getFnIsUse() {
            return fnIsUse;
        }

        public void setFnIsUse(int fnIsUse) {
            this.fnIsUse = fnIsUse;
        }

        public long getFnCreateDate() {
            return fnCreateDate;
        }

        public void setFnCreateDate(long fnCreateDate) {
            this.fnCreateDate = fnCreateDate;
        }

        public int getFnSequence() {
            return fnSequence;
        }

        public void setFnSequence(int fnSequence) {
            this.fnSequence = fnSequence;
        }

        public List<ChildrenListBean> getChildrenList() {
            return childrenList;
        }

        public void setChildrenList(List<ChildrenListBean> childrenList) {
            this.childrenList = childrenList;
        }

        /**
         * fnId : 80d04359-6e21-4f7e-b4f8-6544b154730a
         * fnPid : 8792457a-0f91-414a-9c4a-969326d6955e
         * fnName : 鲜切花
         * fnPic : null
         * fnMerchantsId : htxq
         * fnDesc : null
         * fnIsUse : 1
         * fnCreateDate : 1461919623000
         * fnSequence : 0
         * childrenMap : {}
         * childrenList : []
         */

        public List<ChildrenListBean> childrenList;

        public static class ChildrenListBean {
            public String fnId;
            public String fnPid;
            public String fnName;
            public Object fnPic;
            public String fnMerchantsId;
            public Object fnDesc;
            public int fnIsUse;
            public long fnCreateDate;
            public int fnSequence;
            public ChildrenMapBean childrenMap;
            public List<?> childrenList;

            public String getFnId() {
                return fnId;
            }

            public void setFnId(String fnId) {
                this.fnId = fnId;
            }

            public String getFnPid() {
                return fnPid;
            }

            public void setFnPid(String fnPid) {
                this.fnPid = fnPid;
            }

            public String getFnName() {
                return fnName;
            }

            public void setFnName(String fnName) {
                this.fnName = fnName;
            }

            public Object getFnPic() {
                return fnPic;
            }

            public void setFnPic(Object fnPic) {
                this.fnPic = fnPic;
            }

            public String getFnMerchantsId() {
                return fnMerchantsId;
            }

            public void setFnMerchantsId(String fnMerchantsId) {
                this.fnMerchantsId = fnMerchantsId;
            }

            public Object getFnDesc() {
                return fnDesc;
            }

            public void setFnDesc(Object fnDesc) {
                this.fnDesc = fnDesc;
            }

            public int getFnIsUse() {
                return fnIsUse;
            }

            public void setFnIsUse(int fnIsUse) {
                this.fnIsUse = fnIsUse;
            }

            public long getFnCreateDate() {
                return fnCreateDate;
            }

            public void setFnCreateDate(long fnCreateDate) {
                this.fnCreateDate = fnCreateDate;
            }

            public int getFnSequence() {
                return fnSequence;
            }

            public void setFnSequence(int fnSequence) {
                this.fnSequence = fnSequence;
            }

            public ChildrenMapBean getChildrenMap() {
                return childrenMap;
            }

            public void setChildrenMap(ChildrenMapBean childrenMap) {
                this.childrenMap = childrenMap;
            }

            public List<?> getChildrenList() {
                return childrenList;
            }

            public void setChildrenList(List<?> childrenList) {
                this.childrenList = childrenList;
            }

            public static class ChildrenMapBean {
            }
        }
    }
}
