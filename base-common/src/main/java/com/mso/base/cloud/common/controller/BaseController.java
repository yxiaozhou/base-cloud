package com.mso.base.cloud.common.controller;

import com.mso.base.cloud.common.domain.Common;
import com.mso.base.cloud.common.errors.BaseException;
import com.mso.base.cloud.common.errors.ErrorCode;
import com.mso.base.cloud.common.utils.RequestUtils;
import org.springframework.validation.Errors;

/**
 * 基类Controller
 *
 * @author yeshimin
 * @create 2018-09-21
 */
public abstract class BaseController {

    /**
     * 从 request headers 中取出 token
     *
     * @return token
     * @author yeshimin
     * @create 2018-09-21
     */
    protected String getToken() {
        return RequestUtils.getRequestHeader(Common.TOKEN_KEY);
    }

    /**
     * 从 request attributes 中取出 user_id
     *
     * @return 用户ID
     * @author yeshimin
     * @create 2018-09-21
     */
    protected String getUserId() {
        return (String) RequestUtils.getRequestAttribute(Common.USER_ID_KEY);
    }

    /**
     * 检查参数错误
     *
     * @param errors
     * @author yeshimin
     * @create 2018-09-21
     * @update 2018-09-26 有参数错误直接抛异常 by yeshimin
     */
    protected void checkParamsError(Errors errors) {
        if (errors.hasErrors()) {
            throw new BaseException(ErrorCode.COMMON_PARAM_ERROR, errors.getFieldError().getDefaultMessage());
        }
    }
}
