package com.mso.base.cloud.campus.domain.other;

/**
 * 保存调用tx接口获取的位置信息
 *
 * @author liu
 * @create 2018-11-01 17:08:58
 */
public class LocationMsg {

    //城市
    private String city;
    //省
    private String province;
    //腾讯接口返回的错误信息
    private String message;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LocationMsg [city=" + city + ", province=" + province + ", message=" + message + "]";
    }
}
