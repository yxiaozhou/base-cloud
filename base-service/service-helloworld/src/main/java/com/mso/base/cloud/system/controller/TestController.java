package com.mso.base.cloud.system.controller;

import com.mso.base.cloud.common.wrapper.WrapMapper;
import com.mso.base.cloud.common.wrapper.Wrapper;
import com.mso.base.cloud.system.domain.po.SysUser;
import com.mso.base.cloud.system.mybatis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    public SysUserMapper sysUserMapper;

    @GetMapping("test")
    public Wrapper<List<SysUser>> test(){
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE,"success",sysUserMapper.selectAll());
    }
}
