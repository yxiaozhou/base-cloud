package com.mso.base.cloud.common.errors;

/**
 *  错误信息
 *
 * @author Dana
 * @create 2019-05-10 10:49
 * @update 2019-05-10 10:49
 */
public class ErrorMsg {

    /**
     * 成功
     */
    public static final String SUCCESS = "成功";

    /**
     * 系统不可用
     */
    public static final String UNAVAILABLE = "系统不可用";

    /**
     * 未知错误
     */
    public static final String UNKNOWN = "未知错误";

    /**
     * 内部错误
     */
    public static final String INTERNAL_ERROR = "内部错误";

    /**
     * 参数错误
     */
    public static final String COMMON_PARAM_ERROR = "参数错误";

    /**
     * 数据不存在
     */
    public static final String COMMON_NOT_FOUND = "数据不存在";

    /**
     * 网络错误
     */
    public static final String COMMON_NET_ERROR = "网络错误";

    /**
     * 磁盘IO错误
     */
    public static final String COMMON_IO_ERROR = "磁盘IO错误";

    /**
     * 会话(ID)失效
     */
    public static final String COMMON_SESSION_INVALID = "会话(ID)失效";

    /**
     * 权限不足
     */
    public static final String COMMON_PERMISSION_DENIED = "权限不足";

    /**
     * 数据已存在
     */
    public static final String COMMON_ALREADY_EXISTS = "数据已存在";

    /**
     * 登陆失败，用户名或密码不正确
     */
    public static final String COMMON_LOGIN_FAIL = "登陆失败，用户名或密码不正确";

    /**
     * token凭证验证失败
     */
    public static final String COMMON_TOKEN_VALID_FAIL = "token凭证验证失败";

    /**
     * 支付宝code验证码失效
     */
    public static final String COMMON_ALIPAY_TOKEN_VALID_FAIL = "支付宝code验证码失效";

    /**
     * 依赖数据不存在（不满足）
     */
    public static final String COMMON_DEPENDENCY_UNSATISFY = "依赖数据不存在（不满足）";

    /**
     * 系统用户不存在
     */
    public static final String SYSTEM_SYS_USER_NOT_FOUND = "系统用户不存在";

    /**
     * 系统用户未分配角色
     */
    public static final String SYSTEM_SYS_USER_NO_ROLES = "系统用户未分配角色";

    /**
     * 系统角色未分配菜单
     */
    public static final String SYSTEM_SYS_ROLE_NO_MENUS = "系统角色未分配菜单";

    /**
     * 系统菜单根节点已存在
     */
    public static final String SYSTEM_SYS_MENU_ROOT_EXISTS = "系统菜单根节点已存在";

    /**
     * 系统菜单父节点不存在
     */
    public static final String SYSTEM_SYS_MENU_PARENT_NOT_EXISTS = "系统菜单父节点不存在";

    /**
     * 存在未删除的子菜单
     */
    public static final String SYSTEM_SYS_MENU_EXIST_UNDELETED_SUBS = "存在未删除的子菜单";

    /**
     * 城市子段不符合
     */
    public static final String SYSTEM_SCITY_SUBS = "城市子段不符合";


    /**
     * 系统菜单根节点已存在
     */
    public static final String USER_NOT_AUTHORIZED = "获取access_token - 调用失败";

}
