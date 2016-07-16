package com.yunmeng.florallife.bean;

/**
 * Created by 59857 on 2016/7/14.
 */
public class UrlConfig {
    // 专题
    // 首页 list：
    public static final String URL_SIMPLE_LIST = "http://m.htxq.net/servlet/SysArticleServlet?pageSize=20&action=mainList&currentPageIndex=0&cateId=";
    // 首页导航栏：
    public static final String URL_SIMPLE_GUIDE = "http://m.htxq.net/servlet/SysCategoryServlet?action=getList";
    // 下面list数据：
    public static final String URL_SIMPLE_GUIDE_LIST = "http://m.htxq.net/servlet/SysArticleServlet?pageSize=20&action=mainList&currentPageIndex=0&cateId=";
    /**
     * 注释：
     * cateId 是上面获取到的 id
     * 家居庭院  cateId=79eb0990-3cfd-4d6f-aabd-93ba001d0076
     * 缤纷小物 cateId=ef590bfe-47f2-11e5-a94d-f0def1b6f49e
     * 1、内部list内容是该json内的pageUrl
     * 2、content 作者详情页面的签名
     */
    public static final String URL_ARTICLE_DETAIL="http://m.htxq.net/servlet/SysArticleServlet?action=getArticleDetail&articleId=";


    // TOP: baseUrl：
    public static final String URL_TOPBASE = "http://m.htxq.net/servlet/SysArticleServlet?";
    // 作者 ：
    public static final String URL_AUTHER = "pageSize=10&action=topArticleAuthor&currentPageIndex=0";
    // 专栏 ：
    public static final String URL_SIMPLELIST = "pageSize=10&action=topContents&currentPageIndex=0";
    // 作者中心：
    public static final String URL_AUTHER_CENTER = "http://m.htxq.net/servlet/UserCustomerServlet?action=getUserDetail&userId=";


    // 专题下拉：
    // 文章：
    public static final String URL_ZT_ARTICLE = "http://m.htxq.net/servlet/SysArticleServlet?pageSize=20&action=mainList&isVideo=false&currentPageIndex=0&cateId=";
    // 视频：
    public static final String URL_ZT_VIDEO  = "http://m.htxq.net/servlet/SysArticleServlet?pageSize=20&action=mainList&isVideo=true&currentPageIndex=0&cateId=";


    // 商城
    // 商城导航栏：
    public static final String URL_SHOP_GUIDE = "http://ec.htxq.net/rest/htxq/item/tree";
    // childlistview：
    public static final String URL_SHOP_GUIDE_LIST_BASE = "http://ec.htxq.net/rest/htxq/goods/itemGoods?itemId=";
    // itemid= 为导航栏获取的fnId
    // 除了itemid外还需要加上以下后缀
    public static final String URL_SHOP_GUIDE_LIST_END = "&pageIndex=1&pageSize=20";
    //headimg
    public static final String URL_SHOP_HEAD = "http://ec.htxq.net/rest/htxq/index/carousel";
    // 精选 ：
    public static final String URL_SHOP_CHOOSE = "http://ec.htxq.net/rest/htxq/index/jingList/1";
    // 商城 ：
    public static final String URL_SHOP_BUY = "http://ec.htxq.net/rest/htxq/index/theme";
    // 积分 ：
    public static final String URL_SHOP_SCORE = "http://m.htxq.net/rest/htxq/index/jifenList/1";
    // 积分规则 ：
    public static final String URL_SHOP_SCORE_RULE = "http://m.htxq.net/servlet/SysContentServlet?action=getDetail&id=309356e8-6bde-40f4-98aa-6d745e804b1f";
}
