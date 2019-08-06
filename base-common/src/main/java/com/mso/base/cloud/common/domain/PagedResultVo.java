package com.mso.base.cloud.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回带分页结果信息的对象
 *
 * @author dana
 * @create 2018-09-06 13:35
 * @update 2018-09-06 13:35
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedResultVo {

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

    /**
     * 分页信息
     */
    private CommonPage page;

    public static PagedResultVo wrap(PageAndData pageAndData) {
        PagedResultVo resultVo = new PagedResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("success");
        resultVo.setData(pageAndData.getData());
        resultVo.setPage(CommonPage.getCommonPage(pageAndData.getPageInfo()));
        return resultVo;
    }
}
