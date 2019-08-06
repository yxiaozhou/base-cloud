package com.mso.base.cloud.campus.domain.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * 接口响应模型
 *
 * @author yeshimin
 * @update 2018-04-19
 * @create 2017-04-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {

    /**
     * 响应code码
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;

    public ResultVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultVo wrap(int code, String msg, Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo wrapData(int code, Object data) {
        return wrap(code, null, data);
    }

    public static ResultVo wrapData(Object data) {
        return wrapData(0, data);
    }

    public static ResultVo wrapCode(int code, String msg) {
        return wrap(code, msg, null);
    }

    public static ResultVo wrapCode(int code) {
        return wrapCode(code, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return (msg == null ? "" : msg);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return (data == null ? new HashMap() : data);
    }

    public void setData(Object data) {
        this.data = data;
    }

}
