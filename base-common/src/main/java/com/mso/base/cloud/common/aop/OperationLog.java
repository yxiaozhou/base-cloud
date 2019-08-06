package com.mso.base.cloud.common.aop;

import java.lang.annotation.*;

/**
 * 记录操作日志
 *
 * @author tim
 * @date 2019/6/11
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    /**
     * 操作日志
     */
    String message();
}
