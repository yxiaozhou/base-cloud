/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：MdcAddressQueryFeignApi.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.mso.base.cloud.user.service;

import com.mso.base.cloud.common.wrapper.Wrapper;
import com.mso.base.cloud.user.service.hystrix.UserQueryFeignHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 */
@FeignClient(value = "base-service-user-api",  fallback = UserQueryFeignHystrix.class)
public interface UserQueryFeignApi {

	/**
	 * Select by id wrapper.
	 *
	 * @param addressId the address id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/hi")
	Wrapper<Object> getById(@PathVariable("addressId") Long addressId);
}
