package com.mso.base.cloud.campus.mybatis.mapper;

import com.mso.base.cloud.campus.domain.po.SCampus;
import com.mso.base.cloud.campus.domain.vo.CampusListVo;
import com.mso.base.cloud.campus.domain.vo.CampusProductVo;
import com.mso.base.cloud.campus.domain.vo.SCampusVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SCampusRepository extends Mapper<SCampus> {

    /**
     * 校区列表
     *
     * @return
     */
    List<SCampusVo> getCampuses();

    /**
     * 查询校区管理列表
     *
     * @param name    校区名称
     * @param state   校区状态 0-未上架 1-上架
     * @param storeId 品牌商铺id
     * @return PagedResultVo
     * @author Dana
     * @create 2019-07-08 17:20
     * @update 2019-07-08 17:20
     */
    List<CampusListVo> getCampusList(@Param("name") String name,
                                     @Param("state") Integer state,
                                     @Param("storeId") String storeId);

    /**
     * 查询课程列表-校区
     *
     * @param id
     * @return List<CampusProductVo>
     * @author hao
     * @Description: TODO
     * @date 2019年5月31日上午11:32:13
     */
    List<CampusProductVo> findCampusProduct(@Param("id") Integer id);

    /**
     * 根据校区名称和商铺id查询校区
     *
     * @param name    校区名称
     * @param storeId 商铺id
     * @return SCampus
     * @author Dana
     * @create 2019-07-18 13:58
     * @update 2019-07-18 13:58
     */
    SCampus getByNameAndStoreId(@Param("name") String name,
                                @Param("storeId") String storeId);
    /**
     * 修改上下架状态
     * @param shelfState
     * @param storeId
     */
    int updateShelfState(@Param("shelfState") Integer shelfState, @Param("storeId") String storeId);
}
