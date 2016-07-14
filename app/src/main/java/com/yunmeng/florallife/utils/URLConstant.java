package com.yunmeng.florallife.utils;

/**
 * Created by my on 2016/7/13.
 */
public class URLConstant {

    // 专题
    // 首页 list：
    public static final String mainList = "http://m.htxq.net/servlet/SysArticleServlet?pageSize=20&action=mainList&currentPageIndex=0&cateId=";
    // 首页导航栏：
    public static final String mainNavigationBar = "http://m.htxq.net/servlet/SysCategoryServlet?action=getList";
    // 下面list数据：
    public static final String listData = "http://m.htxq.net/servlet/SysCategoryServlet?pageSize=20&action=mainList&currentPageIndex=0&cateId=";
    /**
     * 注释：
     * cateId 是上面获取到的 id
     * 家居庭院  cateId=79eb0990-3cfd-4d6f-aabd-93ba001d0076
     * 缤纷小物 cateId=ef590bfe-47f2-11e5-a94d-f0def1b6f49e
     * 1、内部list内容是该json内的pageUrl
     * 2、content 作者详情页面的签名
     */

    // TOP: baseUrl：
    public static final String topBase = "http://m.htxq.net/servlet/SysArticleServlet?";
    // 作者 ：
    public static final String authorJoint = "pageSize=10&action=topArticleAuthor&currentPageIndex=0";
    // 专栏 ：
    public static final String coulmnJoint = "pageSize=10&action=topContents&currentPageIndex=0";
    // 作者中心：
    public static final String authorCenterBase = "http://m.htxq.net/servlet/UserCustomerServlet?action=getUserDetail&userId=";


    // 专题下拉：
    // 文章：
    public static final String zhuantiArticle = "http://m.htxq.net/servlet/SysArticleServlet?pageSize=20&action=mainList&isVideo=false&currentPageIndex=0&cateId=";
    // 视频：
    public static final String zhuantiVideo = "http://m.htxq.net/servlet/SysArticleServle t? pageSize=20&action=mainList&isVideo=true &currentPag eIndex=0&cateId=";

    // 商城
    // 商城导航栏：
    public static final String shoppingNavigationBar = "http://ec.htxq.net/rest/htxq/item/tree";
    // childlistview：
    public static final String ShoppingNavigationDetail = "http://ec.htxq.net/rest/htxq/goods/itemGoods?itemId=";
    // itemid= 为导航栏获取的fnId
    // 除了itemid外还需要加上以下后缀
    public static final String shoppingNavigationSuffix = "&pageIndex=1&pageSize=20";

    // 精选 ：
    public static final String MALLCHOSEN = "http://ec.htxq.net/rest/htxq/index/jingList/1";
    // 商城 ：
    public static final String MAllMall = "http://ec.htxq.net/rest/htxq/index/theme";
    // 积分 ：
    public static final String shoppingScore = "http://m.htxq.net/rest/htxq/index/jifenList/1";
    // 积分规则 ：
    public static final String shoppingScoreRule = "http://m.htxq.net/servlet/SysContentServlet?action=getDetail&id=309356e8-6bde-40f4-98aa-6d745e804b1f";



}
