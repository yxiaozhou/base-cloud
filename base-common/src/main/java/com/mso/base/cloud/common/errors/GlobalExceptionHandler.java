package com.mso.base.cloud.common.errors;

import com.mso.base.cloud.common.domain.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 全局异常处理器
 *
 * @author tim
 * @update 2018-04-19
 * @create 2018-01-05
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理基类异常
     *
     * @param e 异常对象
     * @return 处理后的响应结果
     * @author tim
     * @create 2018-01-30
     */
    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public ResultVo handleBaseException(BaseException e) {
        log.debug("", e);
        return ResultVo.wrapCode(e.getCode(), e.getMessage());
    }

    /**
     * 处理全局异常
     *
     * @param e 异常对象
     * @return 处理后的响应结果
     * @author tim
     * @create 2018-01-30
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultVo handleException(Exception e) {
        log.error("", e);
        return ResultVo.wrapCode(ErrorCode.INTERNAL_ERROR, e.getMessage());
    }

    /**
     * 参数错误
     *
     * @param e 异常对象
     * @return 处理后的响应结果
     * @author tim
     * @create 2019-03-21
     */
    @ResponseBody
    @ExceptionHandler({
            ConversionFailedException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            BindException.class})
    public ResultVo handleParamException(Exception e) {
        log.debug("", e);
        String msg = e.getMessage();
        if (e instanceof MethodArgumentNotValidException) {
            msg = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage();
        } else if (e instanceof BindException) {
            msg = ((BindException) e).getBindingResult().getFieldError().getDefaultMessage();
        }

        return ResultVo.wrapCode(ErrorCode.COMMON_PARAM_ERROR, msg);
    }
}
