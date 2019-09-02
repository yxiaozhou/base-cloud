package com.mso.base.cloud.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 请求处理的工具类
 *
 * @author liu
 * @create 2017-10-25
 */
public class RequestUtils {

    /**
     * 获取用户ip地址
     *
     * @author liu
     * @create 2017-10-25
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        System.out.println(request.getRemoteAddr());
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            //"***.***.***.***".length() = 15
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    /**
     * 获取HttpServletRequest中指定name的attribute的值
     *
     * @param name 属性名
     * @return 指定属性名的attribute
     * @author liu
     * @create 2018年9月20日
     */
    public static Object getRequestAttribute(String name) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getAttribute(name);
    }

    /**
     * 设置HttpServletRequest的attribute
     *
     * @param name 属性名
     * @param obj  值
     * @author tim
     * @create 2018-09-21
     */
    public static void setRequestAttribute(String name, Object obj) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setAttribute(name, obj);
    }

    /**
     * 获取HttpServletRequest中指定name的header的值
     *
     * @param name 属性名
     * @return 指定属性名的header
     * @author tim
     * @create 2018-09-21
     */
    public static String getRequestHeader(String name) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getHeader(name);
    }

    /**
     * 转换request参数 Map<String, String[]> -> Map<String, String>
     *
     * @param request
     * @return
     * @author tim
     * @create 2019-06-12
     */
    public static Map<String, String> getRequestParams(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> params = new HashMap<>(parameterMap.size());
        parameterMap.forEach((k, v) -> {
            params.put(k, (v == null ? null : v[0]));
        });
        return params;
    }

    /**
     * 获取QueryString形式的请求参数
     *
     * @param request
     * @return
     * @author tim
     * @create 2019-07-09
     */
    public static String getRequestParamsString(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        StringBuilder sbResult = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = iterator.next();
            String key = entry.getKey();
            String values = entry.getValue() == null ? null :
                    StringUtils.join(Arrays.asList(entry.getValue()), ",");
            sbResult.append(key).append("=").append(values);
            if (iterator.hasNext()) {
                sbResult.append("&");
            }
        }
        return sbResult.toString();
    }
}
