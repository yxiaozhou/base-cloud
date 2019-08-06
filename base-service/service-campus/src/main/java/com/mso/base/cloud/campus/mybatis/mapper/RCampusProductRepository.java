package com.mso.base.cloud.campus.mybatis.mapper;

import com.mso.base.cloud.campus.domain.po.RCampusProduct;
import com.mso.base.cloud.campus.domain.vo.CampusProductListVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RCampusProductRepository extends Mapper<RCampusProduct> {

    /**
     * 根据校区id删除数据
     *
     * @param campusId 校区id
     * @return int
     * @author Dana
     * @create 2019-07-09 16:13
     * @update 2019-07-09 16:13
     */
    int deleteByCampusId(Integer campusId);

    /**
     * 批量新增校区和商品的关系
     *
     * @param list
     * @return int
     * @author Dana
     * @create 2019-07-09 16:13
     * @update 2019-07-09 16:13
     */
    int insertBatch(@Param("list") List<RCampusProduct> list);

    /**
     * 查询已选商品列表
     *
     * @param campusId 校区id
     * @return List<CampusProductListVo>
     * @author Dana
     * @create 2019-07-09 16:58
     * @update 2019-07-09 16:58
     */
    List<CampusProductListVo> getCampusProducts(Integer campusId);

    /**
     * 根据校区id查询对应商品idlist
     *
     * @param campusId 校区id
     * @return int
     * @author Dana
     * @create 2019-07-09 16:13
     * @update 2019-07-09 16:13
     */
    List<String> selectProductIdsByCampusId(Integer campusId);
}
