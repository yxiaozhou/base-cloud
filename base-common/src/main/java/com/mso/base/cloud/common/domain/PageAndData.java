package com.mso.base.cloud.common.domain;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageAndData {

    private List pagedData;
    private List puredData;

    private PageAndData(List pagedData, List puredData) {
        this.pagedData = pagedData;
        this.puredData = puredData;
    }

    public static PageAndData wrap(List pagedData, List puredData) {
        return new PageAndData(pagedData, puredData);
    }

    public List getData() {
        return this.puredData;
    }

    public PageInfo getPageInfo() {
        return new PageInfo(this.pagedData);
    }
}
