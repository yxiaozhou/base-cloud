package com.mso.base.cloud.common.domain;

import com.github.pagehelper.PageInfo;
import lombok.Data;

/**
 * 通用返回分页对象
 *
 * @author dana
 * @create 2018-09-06 10:52
 * @update 2018-09-06 10:52
 * @update 2018-09-13 by yeshimin 字段命名调整
 **/
@Data
public class CommonPage {

    private Integer pageNum;
    private Integer pageSize;
    private Long total;
    private Integer pages;

    public static CommonPage getCommonPage(PageInfo pageInfo) {
        CommonPage m = new CommonPage();
        m.setPageNum(pageInfo.getPageNum());
        m.setPageSize(pageInfo.getPageSize());
        m.setTotal(pageInfo.getTotal());
        m.setPages(pageInfo.getPages());
        return m;
    }
}
