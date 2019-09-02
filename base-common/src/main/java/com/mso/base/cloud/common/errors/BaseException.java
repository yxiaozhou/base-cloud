package com.mso.base.cloud.common.errors;

import lombok.Data;

/**
 * 基类异常
 *
 * @author tim
 * @create 2018-01-05
 */
@Data
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private int code;

    public BaseException(int code) {
        this.code = code;
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }

}
