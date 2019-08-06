package com.mso.base.cloud.common.errors;

/**
 * 错误码
 *
 * @author yeshimin
 * @create 2018-04-19
 */
public class ErrorCode {

    // ____错误码基数____

    /**
     * 基础错误码基数
     */
    private static final int COMMON_BASE = 10000;

    /**
     * 后台系统基数
     */
    private static final int SYSTEM_BASE = 19000;

    /**
     * 支付宝小程序系统基数
     */
    private static final int MINI_BASE = 400000;

    /**
     * 用户模块
     */
    private static final int MINI_USER_BASE = MINI_BASE + 1000;

    /**
     * 商家（品牌店铺）模块
     */
    private static final int MINI_STORE_BASE = MINI_BASE + 2000;

    /**
     * 商品模块
     */
    private static final int MINI_PRODUCT_BASE = MINI_BASE + 3000;

    /**
     * 校区模块
     */
    private static final int MINI_CAMPUS_BASE = MINI_BASE + 4000;

    /**
     * 订单模块
     */
    private static final int MINI_ORDER_BASE = MINI_BASE + 5000;

    /**
     * （课程）预约模块
     */
    private static final int MINI_SUBSCRIBE_BASE = MINI_BASE + 6000;

    /**
     * 红包模块
     */
    private static final int MINI_PACKET_BASE = MINI_BASE + 7000;

    // ____基础错误码____

    /**
     * 成功
     */
    public static final int SUCCESS = 0;

    /**
     * 系统不可用
     */
    public static final int UNAVAILABLE = -1;

    /**
     * 未知错误
     */
    public static final int UNKNOWN = 999;

    /**
     * 内部错误
     */
    public static final int INTERNAL_ERROR = 998;

    /**
     * 参数错误
     */
    public static final int COMMON_PARAM_ERROR = COMMON_BASE + 1;

    /**
     * 数据不存在
     */
    public static final int COMMON_NOT_FOUND = COMMON_BASE + 2;

    /**
     * 网络错误
     */
    public static final int COMMON_NET_ERROR = COMMON_BASE + 3;

    /**
     * 磁盘IO错误
     */
    public static final int COMMON_IO_ERROR = COMMON_BASE + 4;

    /**
     * 会话(ID)失效
     */
    public static final int COMMON_SESSION_INVALID = COMMON_BASE + 5;

    /**
     * 权限不足
     */
    public static final int COMMON_PERMISSION_DENIED = COMMON_BASE + 6;

    /**
     * 数据已存在
     */
    public static final int COMMON_ALREADY_EXISTS = COMMON_BASE + 7;

    /**
     * 登陆失败，用户名或密码不正确
     */
    public static final int COMMON_LOGIN_FAIL = COMMON_BASE + 8;

    /**
     * token凭证验证失败
     */
    public static final int COMMON_TOKEN_VALID_FAIL = COMMON_BASE + 9;

    /**
     * 依赖数据不存在（不满足）
     */
    public static final int COMMON_DEPENDENCY_UNSATISFY = COMMON_BASE + 10;

    /**
     * 支付宝code验证码失效
     */
    public static final int COMMON_ALIPAY_TOKEN_VALID_FAIL = COMMON_BASE + 11;

    // ____具体业务相关的错误码____

    /**
     * 系统用户不存在
     */
    public static final int SYSTEM_SYS_USER_NOT_FOUND = SYSTEM_BASE + 1;

    /**
     * 系统用户未分配角色
     */
    public static final int SYSTEM_SYS_USER_NO_ROLES = SYSTEM_BASE + 2;

    /**
     * 系统角色未分配菜单
     */
    public static final int SYSTEM_SYS_ROLE_NO_MENUS = SYSTEM_BASE + 3;

    /**
     * 系统菜单根节点已存在
     */
    public static final int SYSTEM_SYS_MENU_ROOT_EXISTS = SYSTEM_BASE + 4;

    /**
     * 系统菜单父节点不存在
     */
    public static final int SYSTEM_SYS_MENU_PARENT_NOT_EXISTS = SYSTEM_BASE + 5;

    /**
     * 存在未删除的子菜单
     */
    public static final int SYSTEM_SYS_MENU_EXIST_UNDELETED_SUBS = SYSTEM_BASE + 6;

    /**
     * 城市子段不符合
     */
    public static final int SYSTEM_CITY = SYSTEM_BASE + 7;

    // ====================================================================================================

    /**
     * 用户模块
     */
    // 用户未授权（没有openid也没有手机号）（暂时弃用！！！）
    private static final int USER_NOT_AUTHORIZED = MINI_USER_BASE + 1;
    // 用户手机号解密失败
    public static final int USER_DECRYPT_PHONE_NUMBER_FAIL = MINI_USER_BASE + 2;
    // 用户未注册（没有手机号）
    public static final int USER_NOT_REGISTERED = MINI_USER_BASE + 3;
    // 用户未接入（没有openid）
    public static final int USER_NOT_ACCESSED = MINI_USER_BASE + 4;
    // 验证码发送次数达到上线
    public static final int USER_SMS_MAX = MINI_USER_BASE + 5;
    // 验证记录不存在
    public static final int USER_SMS_RECORD_NOT_FOUND = MINI_USER_BASE + 6;
    // 验证记录已过期
    public static final int USER_SMS_RECORD_EXPIRED = MINI_USER_BASE + 7;
    // 验证记录已验证
    public static final int USER_SMS_RECORD_VERIFIED = MINI_USER_BASE + 8;
    // 验证码不正确
    public static final int USER_SMS_CODE_INCORRECT = MINI_USER_BASE + 9;

    /**
     * 订单模块
     */
    // 创建支付宝交易失败
    public static final int ORDER_ALIPAY_TRADE_CREATE_FAIL = MINI_ORDER_BASE + 1;
    // 支付宝异步通知-参数异常
    public static final int ORDER_ALIPAY_NOTIFY_PARAM_ERROR = MINI_ORDER_BASE + 2;
    // 支付宝异步通知-本地订单不存在
    public static final int ORDER_ALIPAY_LOCAL_ORDER_NOT_EXISTS = MINI_ORDER_BASE + 3;
    // 支付宝异步通知-总金额不一致
    public static final int ORDER_ALIPAY_TOTAL_AMOUNT_INCONSISTENT = MINI_ORDER_BASE + 4;
    // 支付宝异步通知-seller_id不一致
    public static final int ORDER_ALIPAY_SELLERID_INCONSISTENT = MINI_ORDER_BASE + 5;
    // 支付宝异步通知-app_id不一致
    public static final int ORDER_ALIPAY_APPID_INCONSISTENT = MINI_ORDER_BASE + 6;
    // 支付宝异步通知-trade_status不正确
    public static final int ORDER_ALIPAY_TRADE_STATUS_INCORRECT = MINI_ORDER_BASE + 7;
    // 订单使用的红包（在付款前）已过期
    public static final int ORDER_PACKET_EXPIRED = MINI_ORDER_BASE + 8;
    // 订单状态不可支付
    public static final int ORDER_STATE_NOT_PAYABLE = MINI_ORDER_BASE + 9;
    // 订单已过期
    public static final int ORDER_EXPIRED = MINI_ORDER_BASE + 10;

    /**
     * 红包模块
     */
    // 红包不属于该用户
    public static final int PACKET_NOT_BELONG_TO_USER = MINI_PACKET_BASE + 1;
    // 红包已被使用
    public static final int PACKET_ALREADY_USED = MINI_PACKET_BASE + 2;
    // 满减条件不满足
    public static final int PACKET_RULE_UNSATISFIED = MINI_PACKET_BASE + 3;
}
