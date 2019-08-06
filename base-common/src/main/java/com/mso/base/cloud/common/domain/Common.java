package com.mso.base.cloud.common.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 公共常量
 *
 * @author yeshimin
 * @create 2018-09-10
 */
public class Common {

    /**
     * 接入UAA所分配的系统类型
     */
    public static final int UAA_SYS_TYPE = 7;

    /**
     * 默认分页偏移
     */
    public static final int PAGE_DEFAULT = 1;

    /**
     * 默认分页大小
     */
    public static final int SIZE_DEFAULT = 10;

    /**
     * 最大分页大小.
     */
    public static final int SIZE_MAX = 2000;

    /**
     * 默认缓存时间：30分钟
     */
    public static final int DEFAULT_CACHE_EXPIRATION = 30 * 60;

    /**
     * PageHelper包装过的(Page)List data
     */
    public static final String PAGE_DATA = "page_data";

    /**
     * 普通VO data
     */
    public static final String VO_DATA = "vo_data";

    /**
     * 系统菜单根节点的父ID
     */
    public static final int SYS_MENU_ROOT_PARENT_ID = 0;

    // jwt小程序用户群
    public static final String JWT_SUBJECT_ALIPAYMINI_USER = "user";

    /**
     * jwt后台系统用户群
     */
    public static final String JWT_SUBJECT_SYSTEM_USER = "sysuser";

    /**
     * redis db index
     */
    public static final int REDIS_DB_INDEX = 3;

    /**
     * 默认的操作员
     */
    public static String user_operator = "0";

    /**
     * AOP中提取的"token"头部的键
     */
    public static final String TOKEN_KEY = "token";

    /**
     * AOP中提取设置的"用户ID"的键
     */
    public static final String USER_ID_KEY = "user_id";

    /**
     * 商品类型 1-短课包
     */
    public static final Integer PRODUCT_TYPE_1 = 1;
    /**
     * 商品类型 2-预约课程
     */
    public static final Integer PRODUCT_TYPE_2 = 2;

    /**
     * 系统城市数据
     */
    public static final String SYSTEM_CITY_DATA = "citys";

    /**
     * 最大时间（字符串形式）
     */
    public static final String MAX_DATETIME_STR = "9999-12-29 23:59:59";

    /**
     * 一般时间格式
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 最大时间："9999-12-31 23:59:59"
     */
    public static final LocalDateTime MAX_LOCAL_DATETIME =
            LocalDateTime.parse(MAX_DATETIME_STR, DateTimeFormatter.ofPattern(DATETIME_FORMAT));
}
