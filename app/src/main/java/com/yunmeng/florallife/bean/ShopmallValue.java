package com.yunmeng.florallife.bean;

import java.util.List;

/**
 * Created by 59857 on 2016/7/15.
 */
public class ShopmallValue {

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

    public List<ResultBean> result;

    public static class ResultBean {
        public String fnId;
        public String fnName;
        public Object fnCreateDate;
        public int fnIsUse;
        public String fnDesc;
        public Object fnAttachment;
        public Object fnEnName;
        public int fnSequence;

        public String getFnId() {
            return fnId;
        }

        public void setFnId(String fnId) {
            this.fnId = fnId;
        }

        public String getFnName() {
            return fnName;
        }

        public void setFnName(String fnName) {
            this.fnName = fnName;
        }

        public Object getFnCreateDate() {
            return fnCreateDate;
        }

        public void setFnCreateDate(Object fnCreateDate) {
            this.fnCreateDate = fnCreateDate;
        }

        public int getFnIsUse() {
            return fnIsUse;
        }

        public void setFnIsUse(int fnIsUse) {
            this.fnIsUse = fnIsUse;
        }

        public String getFnDesc() {
            return fnDesc;
        }

        public void setFnDesc(String fnDesc) {
            this.fnDesc = fnDesc;
        }

        public Object getFnAttachment() {
            return fnAttachment;
        }

        public void setFnAttachment(Object fnAttachment) {
            this.fnAttachment = fnAttachment;
        }

        public Object getFnEnName() {
            return fnEnName;
        }

        public void setFnEnName(Object fnEnName) {
            this.fnEnName = fnEnName;
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

        public List<ChildrenListBean> childrenList;

        public static class ChildrenListBean {
            public String fnId;
            public String fnThemeId;
            public String fnGoodsId;
            public int fnSequence;
            public long fnCreateDate;
            public Object fnType;
            public PGoodsBean pGoods;

            public String getFnId() {
                return fnId;
            }

            public void setFnId(String fnId) {
                this.fnId = fnId;
            }

            public String getFnThemeId() {
                return fnThemeId;
            }

            public void setFnThemeId(String fnThemeId) {
                this.fnThemeId = fnThemeId;
            }

            public String getFnGoodsId() {
                return fnGoodsId;
            }

            public void setFnGoodsId(String fnGoodsId) {
                this.fnGoodsId = fnGoodsId;
            }

            public int getFnSequence() {
                return fnSequence;
            }

            public void setFnSequence(int fnSequence) {
                this.fnSequence = fnSequence;
            }

            public long getFnCreateDate() {
                return fnCreateDate;
            }

            public void setFnCreateDate(long fnCreateDate) {
                this.fnCreateDate = fnCreateDate;
            }

            public Object getFnType() {
                return fnType;
            }

            public void setFnType(Object fnType) {
                this.fnType = fnType;
            }

            public PGoodsBean getpGoods() {
                return pGoods;
            }

            public void setpGoods(PGoodsBean pGoods) {
                this.pGoods = pGoods;
            }

            public static class PGoodsBean {
                public String fnId;
                public String fnName;
                public String fnGoodsCode;
                public String fnSpec;
                public String fnMaterial;
                public Object fnFirstTitle;
                public Object fnFirstEnTitle;
                public String fnFirstDesc;
                public Object fnSecondTitle;
                public Object fnSecondEnTitle;
                public String fnSecondDesc;
                public Object fnThreeTitle;
                public Object fnThreeEnTitle;
                public String fnThreeDesc;
                public Object fnFourthTitle;
                public Object fnFourthEnTitle;
                public String fnFourthDesc;
                public Object fnFifthTitle;
                public Object fnFifthEnTitle;
                public String fnFifthDesc;
                public long fnCreateDate;
                public int fnSequence;
                public String fnMerchantsId;
                public String fnItemId;
                public int fnAuditStatus;
                public int fnReleaseStatus;
                public String fnLastAdmin;
                public int fnTotalNum;
                public int fnSaleNum;
                public int fnJian;
                public String fnAttachment;
                public String fnAttachmentSnap;
                public long fnUpdateDate;
                public Object fnStartSaleDate;
                public Object fnEndSaleDate;
                public Object fnOnSaleDate;
                public int fnInitClickNum;
                public int fnAppClickNum;
                public int fnAppointNum;
                public int fnShareClickNum;
                public float fnMarketPrice;
                public String fnLimitArea;
                public int fnGoodsType;
                public String fnEnName;
                public String fnKeyWords;
                public String fnAdvImg;
                public String fnAdvUrl;
                public int fnReturnable;
                public String fnRecommendGoods;
                public Object themeName;
                public int fnIsAddTheme;
                public int fnIsSelectShipDate;
                public String fnAttachment1;
                public String fnAttachmentSnap1;
                public String fnAttachment2;
                public Object fnAttachmentSnap2;
                public int fnIsUseSpec;
                public Object fnKolUserId;
                public int leftNum;
                public Object pItem;
                public Object recommendGoodsList;
                public Object uAddress;

                public String getFnId() {
                    return fnId;
                }

                public void setFnId(String fnId) {
                    this.fnId = fnId;
                }

                public String getFnName() {
                    return fnName;
                }

                public void setFnName(String fnName) {
                    this.fnName = fnName;
                }

                public String getFnGoodsCode() {
                    return fnGoodsCode;
                }

                public void setFnGoodsCode(String fnGoodsCode) {
                    this.fnGoodsCode = fnGoodsCode;
                }

                public String getFnSpec() {
                    return fnSpec;
                }

                public void setFnSpec(String fnSpec) {
                    this.fnSpec = fnSpec;
                }

                public String getFnMaterial() {
                    return fnMaterial;
                }

                public void setFnMaterial(String fnMaterial) {
                    this.fnMaterial = fnMaterial;
                }

                public Object getFnFirstTitle() {
                    return fnFirstTitle;
                }

                public void setFnFirstTitle(Object fnFirstTitle) {
                    this.fnFirstTitle = fnFirstTitle;
                }

                public Object getFnFirstEnTitle() {
                    return fnFirstEnTitle;
                }

                public void setFnFirstEnTitle(Object fnFirstEnTitle) {
                    this.fnFirstEnTitle = fnFirstEnTitle;
                }

                public String getFnFirstDesc() {
                    return fnFirstDesc;
                }

                public void setFnFirstDesc(String fnFirstDesc) {
                    this.fnFirstDesc = fnFirstDesc;
                }

                public Object getFnSecondTitle() {
                    return fnSecondTitle;
                }

                public void setFnSecondTitle(Object fnSecondTitle) {
                    this.fnSecondTitle = fnSecondTitle;
                }

                public Object getFnSecondEnTitle() {
                    return fnSecondEnTitle;
                }

                public void setFnSecondEnTitle(Object fnSecondEnTitle) {
                    this.fnSecondEnTitle = fnSecondEnTitle;
                }

                public String getFnSecondDesc() {
                    return fnSecondDesc;
                }

                public void setFnSecondDesc(String fnSecondDesc) {
                    this.fnSecondDesc = fnSecondDesc;
                }

                public Object getFnThreeTitle() {
                    return fnThreeTitle;
                }

                public void setFnThreeTitle(Object fnThreeTitle) {
                    this.fnThreeTitle = fnThreeTitle;
                }

                public Object getFnThreeEnTitle() {
                    return fnThreeEnTitle;
                }

                public void setFnThreeEnTitle(Object fnThreeEnTitle) {
                    this.fnThreeEnTitle = fnThreeEnTitle;
                }

                public String getFnThreeDesc() {
                    return fnThreeDesc;
                }

                public void setFnThreeDesc(String fnThreeDesc) {
                    this.fnThreeDesc = fnThreeDesc;
                }

                public Object getFnFourthTitle() {
                    return fnFourthTitle;
                }

                public void setFnFourthTitle(Object fnFourthTitle) {
                    this.fnFourthTitle = fnFourthTitle;
                }

                public Object getFnFourthEnTitle() {
                    return fnFourthEnTitle;
                }

                public void setFnFourthEnTitle(Object fnFourthEnTitle) {
                    this.fnFourthEnTitle = fnFourthEnTitle;
                }

                public String getFnFourthDesc() {
                    return fnFourthDesc;
                }

                public void setFnFourthDesc(String fnFourthDesc) {
                    this.fnFourthDesc = fnFourthDesc;
                }

                public Object getFnFifthTitle() {
                    return fnFifthTitle;
                }

                public void setFnFifthTitle(Object fnFifthTitle) {
                    this.fnFifthTitle = fnFifthTitle;
                }

                public Object getFnFifthEnTitle() {
                    return fnFifthEnTitle;
                }

                public void setFnFifthEnTitle(Object fnFifthEnTitle) {
                    this.fnFifthEnTitle = fnFifthEnTitle;
                }

                public String getFnFifthDesc() {
                    return fnFifthDesc;
                }

                public void setFnFifthDesc(String fnFifthDesc) {
                    this.fnFifthDesc = fnFifthDesc;
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

                public String getFnMerchantsId() {
                    return fnMerchantsId;
                }

                public void setFnMerchantsId(String fnMerchantsId) {
                    this.fnMerchantsId = fnMerchantsId;
                }

                public String getFnItemId() {
                    return fnItemId;
                }

                public void setFnItemId(String fnItemId) {
                    this.fnItemId = fnItemId;
                }

                public int getFnAuditStatus() {
                    return fnAuditStatus;
                }

                public void setFnAuditStatus(int fnAuditStatus) {
                    this.fnAuditStatus = fnAuditStatus;
                }

                public int getFnReleaseStatus() {
                    return fnReleaseStatus;
                }

                public void setFnReleaseStatus(int fnReleaseStatus) {
                    this.fnReleaseStatus = fnReleaseStatus;
                }

                public String getFnLastAdmin() {
                    return fnLastAdmin;
                }

                public void setFnLastAdmin(String fnLastAdmin) {
                    this.fnLastAdmin = fnLastAdmin;
                }

                public int getFnTotalNum() {
                    return fnTotalNum;
                }

                public void setFnTotalNum(int fnTotalNum) {
                    this.fnTotalNum = fnTotalNum;
                }

                public int getFnSaleNum() {
                    return fnSaleNum;
                }

                public void setFnSaleNum(int fnSaleNum) {
                    this.fnSaleNum = fnSaleNum;
                }

                public int getFnJian() {
                    return fnJian;
                }

                public void setFnJian(int fnJian) {
                    this.fnJian = fnJian;
                }

                public String getFnAttachment() {
                    return fnAttachment;
                }

                public void setFnAttachment(String fnAttachment) {
                    this.fnAttachment = fnAttachment;
                }

                public String getFnAttachmentSnap() {
                    return fnAttachmentSnap;
                }

                public void setFnAttachmentSnap(String fnAttachmentSnap) {
                    this.fnAttachmentSnap = fnAttachmentSnap;
                }

                public long getFnUpdateDate() {
                    return fnUpdateDate;
                }

                public void setFnUpdateDate(long fnUpdateDate) {
                    this.fnUpdateDate = fnUpdateDate;
                }

                public Object getFnStartSaleDate() {
                    return fnStartSaleDate;
                }

                public void setFnStartSaleDate(Object fnStartSaleDate) {
                    this.fnStartSaleDate = fnStartSaleDate;
                }

                public Object getFnEndSaleDate() {
                    return fnEndSaleDate;
                }

                public void setFnEndSaleDate(Object fnEndSaleDate) {
                    this.fnEndSaleDate = fnEndSaleDate;
                }

                public Object getFnOnSaleDate() {
                    return fnOnSaleDate;
                }

                public void setFnOnSaleDate(Object fnOnSaleDate) {
                    this.fnOnSaleDate = fnOnSaleDate;
                }

                public int getFnInitClickNum() {
                    return fnInitClickNum;
                }

                public void setFnInitClickNum(int fnInitClickNum) {
                    this.fnInitClickNum = fnInitClickNum;
                }

                public int getFnAppClickNum() {
                    return fnAppClickNum;
                }

                public void setFnAppClickNum(int fnAppClickNum) {
                    this.fnAppClickNum = fnAppClickNum;
                }

                public int getFnAppointNum() {
                    return fnAppointNum;
                }

                public void setFnAppointNum(int fnAppointNum) {
                    this.fnAppointNum = fnAppointNum;
                }

                public int getFnShareClickNum() {
                    return fnShareClickNum;
                }

                public void setFnShareClickNum(int fnShareClickNum) {
                    this.fnShareClickNum = fnShareClickNum;
                }

                public float getFnMarketPrice() {
                    return fnMarketPrice;
                }

                public void setFnMarketPrice(float fnMarketPrice) {
                    this.fnMarketPrice = fnMarketPrice;
                }

                public String getFnLimitArea() {
                    return fnLimitArea;
                }

                public void setFnLimitArea(String fnLimitArea) {
                    this.fnLimitArea = fnLimitArea;
                }

                public int getFnGoodsType() {
                    return fnGoodsType;
                }

                public void setFnGoodsType(int fnGoodsType) {
                    this.fnGoodsType = fnGoodsType;
                }

                public String getFnEnName() {
                    return fnEnName;
                }

                public void setFnEnName(String fnEnName) {
                    this.fnEnName = fnEnName;
                }

                public String getFnKeyWords() {
                    return fnKeyWords;
                }

                public void setFnKeyWords(String fnKeyWords) {
                    this.fnKeyWords = fnKeyWords;
                }

                public String getFnAdvImg() {
                    return fnAdvImg;
                }

                public void setFnAdvImg(String fnAdvImg) {
                    this.fnAdvImg = fnAdvImg;
                }

                public String getFnAdvUrl() {
                    return fnAdvUrl;
                }

                public void setFnAdvUrl(String fnAdvUrl) {
                    this.fnAdvUrl = fnAdvUrl;
                }

                public int getFnReturnable() {
                    return fnReturnable;
                }

                public void setFnReturnable(int fnReturnable) {
                    this.fnReturnable = fnReturnable;
                }

                public String getFnRecommendGoods() {
                    return fnRecommendGoods;
                }

                public void setFnRecommendGoods(String fnRecommendGoods) {
                    this.fnRecommendGoods = fnRecommendGoods;
                }

                public Object getThemeName() {
                    return themeName;
                }

                public void setThemeName(Object themeName) {
                    this.themeName = themeName;
                }

                public int getFnIsAddTheme() {
                    return fnIsAddTheme;
                }

                public void setFnIsAddTheme(int fnIsAddTheme) {
                    this.fnIsAddTheme = fnIsAddTheme;
                }

                public int getFnIsSelectShipDate() {
                    return fnIsSelectShipDate;
                }

                public void setFnIsSelectShipDate(int fnIsSelectShipDate) {
                    this.fnIsSelectShipDate = fnIsSelectShipDate;
                }

                public String getFnAttachment1() {
                    return fnAttachment1;
                }

                public void setFnAttachment1(String fnAttachment1) {
                    this.fnAttachment1 = fnAttachment1;
                }

                public String getFnAttachmentSnap1() {
                    return fnAttachmentSnap1;
                }

                public void setFnAttachmentSnap1(String fnAttachmentSnap1) {
                    this.fnAttachmentSnap1 = fnAttachmentSnap1;
                }

                public String getFnAttachment2() {
                    return fnAttachment2;
                }

                public void setFnAttachment2(String fnAttachment2) {
                    this.fnAttachment2 = fnAttachment2;
                }

                public Object getFnAttachmentSnap2() {
                    return fnAttachmentSnap2;
                }

                public void setFnAttachmentSnap2(Object fnAttachmentSnap2) {
                    this.fnAttachmentSnap2 = fnAttachmentSnap2;
                }

                public int getFnIsUseSpec() {
                    return fnIsUseSpec;
                }

                public void setFnIsUseSpec(int fnIsUseSpec) {
                    this.fnIsUseSpec = fnIsUseSpec;
                }

                public Object getFnKolUserId() {
                    return fnKolUserId;
                }

                public void setFnKolUserId(Object fnKolUserId) {
                    this.fnKolUserId = fnKolUserId;
                }

                public int getLeftNum() {
                    return leftNum;
                }

                public void setLeftNum(int leftNum) {
                    this.leftNum = leftNum;
                }

                public Object getpItem() {
                    return pItem;
                }

                public void setpItem(Object pItem) {
                    this.pItem = pItem;
                }

                public Object getRecommendGoodsList() {
                    return recommendGoodsList;
                }

                public void setRecommendGoodsList(Object recommendGoodsList) {
                    this.recommendGoodsList = recommendGoodsList;
                }

                public Object getuAddress() {
                    return uAddress;
                }

                public void setuAddress(Object uAddress) {
                    this.uAddress = uAddress;
                }

                public List<SkuListBean> getSkuList() {
                    return skuList;
                }

                public void setSkuList(List<SkuListBean> skuList) {
                    this.skuList = skuList;
                }

                public List<SpecListBean> getSpecList() {
                    return specList;
                }

                public void setSpecList(List<SpecListBean> specList) {
                    this.specList = specList;
                }

                public List<SkuListBean> skuList;

                public List<SpecListBean> specList;

                public static class SkuListBean {
                    public String fnId;
                    public String fnSkuName;
                    public String fnGoodsId;
                    public int fnTotalInQuantity;
                    public int fnTotalOutQuantity;
                    public int fnCurrentQuantity;
                    public int fnNewestInQuantity;
                    public int fnNewestOutQuantity;
                    public float fnPrice;
                    public Object fnMarketPrice;
                    public Object fnCost;
                    public Object fnDiscount;
                    public String fnSkuCode;
                    public String fnItemId;
                    public String fnMerchantsId;
                    public Object fnIsUse;
                    public long fnCreateDate;
                    public Object fnUpdateDate;
                    public Object fnOnSaleDate;
                    public Object fnStartSaleDate;
                    public Object fnEndSaleDate;
                    public Object fnStatus;
                    public Object fnAttrIdGroup;
                    public Object fnAttrNameGroup;
                    public Object fnAttrValueIdGroup;
                    public Object fnAttrValueNameGroup;
                    public Object fnAttrKeyGroup;
                    public Object fnAttrSaleGroup;
                    public Object fnAttrSelfGroup;
                    public Object fnAttrCommonGroup;
                    public String fnLastAdmin;
                    public Object fnPayType;
                    public Object fnPayMaxScore;
                    public String fnAttachment;
                    public String fnAttachmentSnap;
                    public Object fnStockHouse;
                    public long fnNewestInDate;
                    public Object fnNewestOutDate;
                    public String fnSpecId;
                    public String fnSpecName;

                    public String getFnId() {
                        return fnId;
                    }

                    public void setFnId(String fnId) {
                        this.fnId = fnId;
                    }

                    public String getFnSkuName() {
                        return fnSkuName;
                    }

                    public void setFnSkuName(String fnSkuName) {
                        this.fnSkuName = fnSkuName;
                    }

                    public String getFnGoodsId() {
                        return fnGoodsId;
                    }

                    public void setFnGoodsId(String fnGoodsId) {
                        this.fnGoodsId = fnGoodsId;
                    }

                    public int getFnTotalInQuantity() {
                        return fnTotalInQuantity;
                    }

                    public void setFnTotalInQuantity(int fnTotalInQuantity) {
                        this.fnTotalInQuantity = fnTotalInQuantity;
                    }

                    public int getFnTotalOutQuantity() {
                        return fnTotalOutQuantity;
                    }

                    public void setFnTotalOutQuantity(int fnTotalOutQuantity) {
                        this.fnTotalOutQuantity = fnTotalOutQuantity;
                    }

                    public int getFnCurrentQuantity() {
                        return fnCurrentQuantity;
                    }

                    public void setFnCurrentQuantity(int fnCurrentQuantity) {
                        this.fnCurrentQuantity = fnCurrentQuantity;
                    }

                    public int getFnNewestInQuantity() {
                        return fnNewestInQuantity;
                    }

                    public void setFnNewestInQuantity(int fnNewestInQuantity) {
                        this.fnNewestInQuantity = fnNewestInQuantity;
                    }

                    public int getFnNewestOutQuantity() {
                        return fnNewestOutQuantity;
                    }

                    public void setFnNewestOutQuantity(int fnNewestOutQuantity) {
                        this.fnNewestOutQuantity = fnNewestOutQuantity;
                    }

                    public float getFnPrice() {
                        return fnPrice;
                    }

                    public void setFnPrice(float fnPrice) {
                        this.fnPrice = fnPrice;
                    }

                    public Object getFnMarketPrice() {
                        return fnMarketPrice;
                    }

                    public void setFnMarketPrice(Object fnMarketPrice) {
                        this.fnMarketPrice = fnMarketPrice;
                    }

                    public Object getFnCost() {
                        return fnCost;
                    }

                    public void setFnCost(Object fnCost) {
                        this.fnCost = fnCost;
                    }

                    public Object getFnDiscount() {
                        return fnDiscount;
                    }

                    public void setFnDiscount(Object fnDiscount) {
                        this.fnDiscount = fnDiscount;
                    }

                    public String getFnSkuCode() {
                        return fnSkuCode;
                    }

                    public void setFnSkuCode(String fnSkuCode) {
                        this.fnSkuCode = fnSkuCode;
                    }

                    public String getFnItemId() {
                        return fnItemId;
                    }

                    public void setFnItemId(String fnItemId) {
                        this.fnItemId = fnItemId;
                    }

                    public String getFnMerchantsId() {
                        return fnMerchantsId;
                    }

                    public void setFnMerchantsId(String fnMerchantsId) {
                        this.fnMerchantsId = fnMerchantsId;
                    }

                    public Object getFnIsUse() {
                        return fnIsUse;
                    }

                    public void setFnIsUse(Object fnIsUse) {
                        this.fnIsUse = fnIsUse;
                    }

                    public long getFnCreateDate() {
                        return fnCreateDate;
                    }

                    public void setFnCreateDate(long fnCreateDate) {
                        this.fnCreateDate = fnCreateDate;
                    }

                    public Object getFnUpdateDate() {
                        return fnUpdateDate;
                    }

                    public void setFnUpdateDate(Object fnUpdateDate) {
                        this.fnUpdateDate = fnUpdateDate;
                    }

                    public Object getFnOnSaleDate() {
                        return fnOnSaleDate;
                    }

                    public void setFnOnSaleDate(Object fnOnSaleDate) {
                        this.fnOnSaleDate = fnOnSaleDate;
                    }

                    public Object getFnStartSaleDate() {
                        return fnStartSaleDate;
                    }

                    public void setFnStartSaleDate(Object fnStartSaleDate) {
                        this.fnStartSaleDate = fnStartSaleDate;
                    }

                    public Object getFnEndSaleDate() {
                        return fnEndSaleDate;
                    }

                    public void setFnEndSaleDate(Object fnEndSaleDate) {
                        this.fnEndSaleDate = fnEndSaleDate;
                    }

                    public Object getFnStatus() {
                        return fnStatus;
                    }

                    public void setFnStatus(Object fnStatus) {
                        this.fnStatus = fnStatus;
                    }

                    public Object getFnAttrIdGroup() {
                        return fnAttrIdGroup;
                    }

                    public void setFnAttrIdGroup(Object fnAttrIdGroup) {
                        this.fnAttrIdGroup = fnAttrIdGroup;
                    }

                    public Object getFnAttrNameGroup() {
                        return fnAttrNameGroup;
                    }

                    public void setFnAttrNameGroup(Object fnAttrNameGroup) {
                        this.fnAttrNameGroup = fnAttrNameGroup;
                    }

                    public Object getFnAttrValueIdGroup() {
                        return fnAttrValueIdGroup;
                    }

                    public void setFnAttrValueIdGroup(Object fnAttrValueIdGroup) {
                        this.fnAttrValueIdGroup = fnAttrValueIdGroup;
                    }

                    public Object getFnAttrValueNameGroup() {
                        return fnAttrValueNameGroup;
                    }

                    public void setFnAttrValueNameGroup(Object fnAttrValueNameGroup) {
                        this.fnAttrValueNameGroup = fnAttrValueNameGroup;
                    }

                    public Object getFnAttrKeyGroup() {
                        return fnAttrKeyGroup;
                    }

                    public void setFnAttrKeyGroup(Object fnAttrKeyGroup) {
                        this.fnAttrKeyGroup = fnAttrKeyGroup;
                    }

                    public Object getFnAttrSaleGroup() {
                        return fnAttrSaleGroup;
                    }

                    public void setFnAttrSaleGroup(Object fnAttrSaleGroup) {
                        this.fnAttrSaleGroup = fnAttrSaleGroup;
                    }

                    public Object getFnAttrSelfGroup() {
                        return fnAttrSelfGroup;
                    }

                    public void setFnAttrSelfGroup(Object fnAttrSelfGroup) {
                        this.fnAttrSelfGroup = fnAttrSelfGroup;
                    }

                    public Object getFnAttrCommonGroup() {
                        return fnAttrCommonGroup;
                    }

                    public void setFnAttrCommonGroup(Object fnAttrCommonGroup) {
                        this.fnAttrCommonGroup = fnAttrCommonGroup;
                    }

                    public String getFnLastAdmin() {
                        return fnLastAdmin;
                    }

                    public void setFnLastAdmin(String fnLastAdmin) {
                        this.fnLastAdmin = fnLastAdmin;
                    }

                    public Object getFnPayType() {
                        return fnPayType;
                    }

                    public void setFnPayType(Object fnPayType) {
                        this.fnPayType = fnPayType;
                    }

                    public Object getFnPayMaxScore() {
                        return fnPayMaxScore;
                    }

                    public void setFnPayMaxScore(Object fnPayMaxScore) {
                        this.fnPayMaxScore = fnPayMaxScore;
                    }

                    public String getFnAttachment() {
                        return fnAttachment;
                    }

                    public void setFnAttachment(String fnAttachment) {
                        this.fnAttachment = fnAttachment;
                    }

                    public String getFnAttachmentSnap() {
                        return fnAttachmentSnap;
                    }

                    public void setFnAttachmentSnap(String fnAttachmentSnap) {
                        this.fnAttachmentSnap = fnAttachmentSnap;
                    }

                    public Object getFnStockHouse() {
                        return fnStockHouse;
                    }

                    public void setFnStockHouse(Object fnStockHouse) {
                        this.fnStockHouse = fnStockHouse;
                    }

                    public long getFnNewestInDate() {
                        return fnNewestInDate;
                    }

                    public void setFnNewestInDate(long fnNewestInDate) {
                        this.fnNewestInDate = fnNewestInDate;
                    }

                    public Object getFnNewestOutDate() {
                        return fnNewestOutDate;
                    }

                    public void setFnNewestOutDate(Object fnNewestOutDate) {
                        this.fnNewestOutDate = fnNewestOutDate;
                    }

                    public String getFnSpecId() {
                        return fnSpecId;
                    }

                    public void setFnSpecId(String fnSpecId) {
                        this.fnSpecId = fnSpecId;
                    }

                    public String getFnSpecName() {
                        return fnSpecName;
                    }

                    public void setFnSpecName(String fnSpecName) {
                        this.fnSpecName = fnSpecName;
                    }
                }

                public static class SpecListBean {
                    public String fnId;
                    public String fnSpecName;
                    public String fnGoodsId;
                    public String fnGoodsName;
                    public int fnSequence;
                    public int fnIsUse;
                    public long fnCreateDate;

                    public String getFnId() {
                        return fnId;
                    }

                    public void setFnId(String fnId) {
                        this.fnId = fnId;
                    }

                    public String getFnSpecName() {
                        return fnSpecName;
                    }

                    public void setFnSpecName(String fnSpecName) {
                        this.fnSpecName = fnSpecName;
                    }

                    public String getFnGoodsId() {
                        return fnGoodsId;
                    }

                    public void setFnGoodsId(String fnGoodsId) {
                        this.fnGoodsId = fnGoodsId;
                    }

                    public String getFnGoodsName() {
                        return fnGoodsName;
                    }

                    public void setFnGoodsName(String fnGoodsName) {
                        this.fnGoodsName = fnGoodsName;
                    }

                    public int getFnSequence() {
                        return fnSequence;
                    }

                    public void setFnSequence(int fnSequence) {
                        this.fnSequence = fnSequence;
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

                    public SkuBean getSku() {
                        return sku;
                    }

                    public void setSku(SkuBean sku) {
                        this.sku = sku;
                    }

                    public SkuBean sku;

                    public static class SkuBean {
                        public String fnId;
                        public String fnSkuName;
                        public String fnGoodsId;
                        public int fnTotalInQuantity;
                        public int fnTotalOutQuantity;
                        public int fnCurrentQuantity;
                        public int fnNewestInQuantity;
                        public int fnNewestOutQuantity;
                        public float fnPrice;
                        public Object fnMarketPrice;
                        public Object fnCost;
                        public Object fnDiscount;
                        public String fnSkuCode;
                        public String fnItemId;
                        public String fnMerchantsId;
                        public Object fnIsUse;
                        public long fnCreateDate;
                        public Object fnUpdateDate;
                        public Object fnOnSaleDate;
                        public Object fnStartSaleDate;
                        public Object fnEndSaleDate;
                        public Object fnStatus;
                        public Object fnAttrIdGroup;
                        public Object fnAttrNameGroup;
                        public Object fnAttrValueIdGroup;
                        public Object fnAttrValueNameGroup;
                        public Object fnAttrKeyGroup;
                        public Object fnAttrSaleGroup;
                        public Object fnAttrSelfGroup;
                        public Object fnAttrCommonGroup;
                        public String fnLastAdmin;
                        public Object fnPayType;
                        public Object fnPayMaxScore;
                        public String fnAttachment;
                        public String fnAttachmentSnap;
                        public Object fnStockHouse;
                        public long fnNewestInDate;
                        public Object fnNewestOutDate;
                        public String fnSpecId;
                        public String fnSpecName;

                        public String getFnId() {
                            return fnId;
                        }

                        public void setFnId(String fnId) {
                            this.fnId = fnId;
                        }

                        public String getFnSkuName() {
                            return fnSkuName;
                        }

                        public void setFnSkuName(String fnSkuName) {
                            this.fnSkuName = fnSkuName;
                        }

                        public String getFnGoodsId() {
                            return fnGoodsId;
                        }

                        public void setFnGoodsId(String fnGoodsId) {
                            this.fnGoodsId = fnGoodsId;
                        }

                        public int getFnTotalInQuantity() {
                            return fnTotalInQuantity;
                        }

                        public void setFnTotalInQuantity(int fnTotalInQuantity) {
                            this.fnTotalInQuantity = fnTotalInQuantity;
                        }

                        public int getFnTotalOutQuantity() {
                            return fnTotalOutQuantity;
                        }

                        public void setFnTotalOutQuantity(int fnTotalOutQuantity) {
                            this.fnTotalOutQuantity = fnTotalOutQuantity;
                        }

                        public int getFnCurrentQuantity() {
                            return fnCurrentQuantity;
                        }

                        public void setFnCurrentQuantity(int fnCurrentQuantity) {
                            this.fnCurrentQuantity = fnCurrentQuantity;
                        }

                        public int getFnNewestInQuantity() {
                            return fnNewestInQuantity;
                        }

                        public void setFnNewestInQuantity(int fnNewestInQuantity) {
                            this.fnNewestInQuantity = fnNewestInQuantity;
                        }

                        public int getFnNewestOutQuantity() {
                            return fnNewestOutQuantity;
                        }

                        public void setFnNewestOutQuantity(int fnNewestOutQuantity) {
                            this.fnNewestOutQuantity = fnNewestOutQuantity;
                        }

                        public float getFnPrice() {
                            return fnPrice;
                        }

                        public void setFnPrice(float fnPrice) {
                            this.fnPrice = fnPrice;
                        }

                        public Object getFnMarketPrice() {
                            return fnMarketPrice;
                        }

                        public void setFnMarketPrice(Object fnMarketPrice) {
                            this.fnMarketPrice = fnMarketPrice;
                        }

                        public Object getFnCost() {
                            return fnCost;
                        }

                        public void setFnCost(Object fnCost) {
                            this.fnCost = fnCost;
                        }

                        public Object getFnDiscount() {
                            return fnDiscount;
                        }

                        public void setFnDiscount(Object fnDiscount) {
                            this.fnDiscount = fnDiscount;
                        }

                        public String getFnSkuCode() {
                            return fnSkuCode;
                        }

                        public void setFnSkuCode(String fnSkuCode) {
                            this.fnSkuCode = fnSkuCode;
                        }

                        public String getFnItemId() {
                            return fnItemId;
                        }

                        public void setFnItemId(String fnItemId) {
                            this.fnItemId = fnItemId;
                        }

                        public String getFnMerchantsId() {
                            return fnMerchantsId;
                        }

                        public void setFnMerchantsId(String fnMerchantsId) {
                            this.fnMerchantsId = fnMerchantsId;
                        }

                        public Object getFnIsUse() {
                            return fnIsUse;
                        }

                        public void setFnIsUse(Object fnIsUse) {
                            this.fnIsUse = fnIsUse;
                        }

                        public long getFnCreateDate() {
                            return fnCreateDate;
                        }

                        public void setFnCreateDate(long fnCreateDate) {
                            this.fnCreateDate = fnCreateDate;
                        }

                        public Object getFnUpdateDate() {
                            return fnUpdateDate;
                        }

                        public void setFnUpdateDate(Object fnUpdateDate) {
                            this.fnUpdateDate = fnUpdateDate;
                        }

                        public Object getFnOnSaleDate() {
                            return fnOnSaleDate;
                        }

                        public void setFnOnSaleDate(Object fnOnSaleDate) {
                            this.fnOnSaleDate = fnOnSaleDate;
                        }

                        public Object getFnStartSaleDate() {
                            return fnStartSaleDate;
                        }

                        public void setFnStartSaleDate(Object fnStartSaleDate) {
                            this.fnStartSaleDate = fnStartSaleDate;
                        }

                        public Object getFnEndSaleDate() {
                            return fnEndSaleDate;
                        }

                        public void setFnEndSaleDate(Object fnEndSaleDate) {
                            this.fnEndSaleDate = fnEndSaleDate;
                        }

                        public Object getFnStatus() {
                            return fnStatus;
                        }

                        public void setFnStatus(Object fnStatus) {
                            this.fnStatus = fnStatus;
                        }

                        public Object getFnAttrIdGroup() {
                            return fnAttrIdGroup;
                        }

                        public void setFnAttrIdGroup(Object fnAttrIdGroup) {
                            this.fnAttrIdGroup = fnAttrIdGroup;
                        }

                        public Object getFnAttrNameGroup() {
                            return fnAttrNameGroup;
                        }

                        public void setFnAttrNameGroup(Object fnAttrNameGroup) {
                            this.fnAttrNameGroup = fnAttrNameGroup;
                        }

                        public Object getFnAttrValueIdGroup() {
                            return fnAttrValueIdGroup;
                        }

                        public void setFnAttrValueIdGroup(Object fnAttrValueIdGroup) {
                            this.fnAttrValueIdGroup = fnAttrValueIdGroup;
                        }

                        public Object getFnAttrValueNameGroup() {
                            return fnAttrValueNameGroup;
                        }

                        public void setFnAttrValueNameGroup(Object fnAttrValueNameGroup) {
                            this.fnAttrValueNameGroup = fnAttrValueNameGroup;
                        }

                        public Object getFnAttrKeyGroup() {
                            return fnAttrKeyGroup;
                        }

                        public void setFnAttrKeyGroup(Object fnAttrKeyGroup) {
                            this.fnAttrKeyGroup = fnAttrKeyGroup;
                        }

                        public Object getFnAttrSaleGroup() {
                            return fnAttrSaleGroup;
                        }

                        public void setFnAttrSaleGroup(Object fnAttrSaleGroup) {
                            this.fnAttrSaleGroup = fnAttrSaleGroup;
                        }

                        public Object getFnAttrSelfGroup() {
                            return fnAttrSelfGroup;
                        }

                        public void setFnAttrSelfGroup(Object fnAttrSelfGroup) {
                            this.fnAttrSelfGroup = fnAttrSelfGroup;
                        }

                        public Object getFnAttrCommonGroup() {
                            return fnAttrCommonGroup;
                        }

                        public void setFnAttrCommonGroup(Object fnAttrCommonGroup) {
                            this.fnAttrCommonGroup = fnAttrCommonGroup;
                        }

                        public String getFnLastAdmin() {
                            return fnLastAdmin;
                        }

                        public void setFnLastAdmin(String fnLastAdmin) {
                            this.fnLastAdmin = fnLastAdmin;
                        }

                        public Object getFnPayType() {
                            return fnPayType;
                        }

                        public void setFnPayType(Object fnPayType) {
                            this.fnPayType = fnPayType;
                        }

                        public Object getFnPayMaxScore() {
                            return fnPayMaxScore;
                        }

                        public void setFnPayMaxScore(Object fnPayMaxScore) {
                            this.fnPayMaxScore = fnPayMaxScore;
                        }

                        public String getFnAttachment() {
                            return fnAttachment;
                        }

                        public void setFnAttachment(String fnAttachment) {
                            this.fnAttachment = fnAttachment;
                        }

                        public String getFnAttachmentSnap() {
                            return fnAttachmentSnap;
                        }

                        public void setFnAttachmentSnap(String fnAttachmentSnap) {
                            this.fnAttachmentSnap = fnAttachmentSnap;
                        }

                        public Object getFnStockHouse() {
                            return fnStockHouse;
                        }

                        public void setFnStockHouse(Object fnStockHouse) {
                            this.fnStockHouse = fnStockHouse;
                        }

                        public long getFnNewestInDate() {
                            return fnNewestInDate;
                        }

                        public void setFnNewestInDate(long fnNewestInDate) {
                            this.fnNewestInDate = fnNewestInDate;
                        }

                        public Object getFnNewestOutDate() {
                            return fnNewestOutDate;
                        }

                        public void setFnNewestOutDate(Object fnNewestOutDate) {
                            this.fnNewestOutDate = fnNewestOutDate;
                        }

                        public String getFnSpecId() {
                            return fnSpecId;
                        }

                        public void setFnSpecId(String fnSpecId) {
                            this.fnSpecId = fnSpecId;
                        }

                        public String getFnSpecName() {
                            return fnSpecName;
                        }

                        public void setFnSpecName(String fnSpecName) {
                            this.fnSpecName = fnSpecName;
                        }
                    }
                }
            }
        }
    }
}
