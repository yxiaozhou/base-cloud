package com.mso.base.cloud.campus.service;

import com.mso.base.cloud.campus.domain.ShelfState;
import com.mso.base.cloud.campus.domain.dto.AddCampusDto;
import com.mso.base.cloud.campus.domain.dto.AddCampusProductsDto;
import com.mso.base.cloud.campus.domain.dto.UpdateCampusDto;
import com.mso.base.cloud.campus.domain.po.RCampusProduct;
import com.mso.base.cloud.campus.domain.po.SCampus;
import com.mso.base.cloud.campus.domain.vo.CampusDetailVo;
import com.mso.base.cloud.campus.domain.vo.CampusListVo;
import com.mso.base.cloud.campus.domain.vo.CampusProductListVo;
import com.mso.base.cloud.campus.mybatis.mapper.RCampusProductRepository;
import com.mso.base.cloud.campus.mybatis.mapper.SCampusRepository;
//import com.mshuoke.babyclass.common.repository.ProductRepository;
import com.mso.base.cloud.common.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 校区管理 service
 *
 * @author Dana
 * @create 2019-07-08 09:59
 * @update 2019-07-08 09:59
 */
@Service
public class CampusService {

    @Autowired
    private SCampusRepository campusRepo;

    @Autowired
    private RCampusProductRepository rCampusProductRepo;

//    @Autowired
//    private ProductRepository productRepo;

    /**
     * 新增校区
     *
     * @param campusDto
     * @return int
     * @author Dana
     * @create 2019-05-29 20:24
     * @update 2019-05-29 20:24
     */
    @Transactional(rollbackFor = Exception.class)
    public int addCampus(AddCampusDto campusDto) {
        SCampus campus = new SCampus();
        BeanUtils.copyProperties(campusDto, campus);
        if (campusDto.getState() == ShelfState.ON) {
            campus.setStartTime(new Date());
        }
        //保存校区数据
        int i = campusRepo.insertSelective(campus);
        return i;
    }

    /**
     * 查询校区详情
     *
     * @param id 校区id
     * @return CampusDetailVo
     * @author Dana
     * @create 2019-07-08 15:40
     * @update 2019-07-08 15:40
     */
    public CampusDetailVo getCampusDetail(Integer id) {
        //根据id查询校区数据
        SCampus sCampus = campusRepo.selectByPrimaryKey(id);
        if (sCampus != null) {
            //封装返回前端的vo
            CampusDetailVo detailVo = new CampusDetailVo();
            BeanUtils.copyProperties(sCampus, detailVo);
            return detailVo;
        }
        return null;
    }

    /**
     * 修改校区
     *
     * @param campusDto
     * @return int
     * @author Dana
     * @create 2019-05-29 20:24
     * @update 2019-05-29 20:24
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateCampus(UpdateCampusDto campusDto) {
        SCampus campus = new SCampus();
        BeanUtils.copyProperties(campusDto, campus);
        //设置上架时间
        if (campusDto.getState() == ShelfState.ON) {
            campus.setStartTime(new Date());
        } else if (campusDto.getState() == ShelfState.OFF) {
            campus.setStartTime(DateUtil.parse("9999-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss"));
        }
        //保存校区数据
        int i = campusRepo.updateByPrimaryKeySelective(campus);
        return i;
    }

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
    public List<CampusListVo> getCampusList(String name, Integer state, String storeId) {
        //查询校区管理列表
        List<CampusListVo> campusList = campusRepo.getCampusList(name, state, storeId);
        return campusList;
    }

    /**
     * 校区商品配置
     *
     * @param dto
     * @return
     * @author Dana
     * @create 2019-07-09 15:57
     * @update 2019-07-09 15:57
     */
    @Transactional(rollbackFor = Exception.class)
    public void addCampusProducts(AddCampusProductsDto dto) {
        //校区id
        Integer campusId = dto.getCampusId();
        //商品id
        List<String> productIds = dto.getProductIds();
        rCampusProductRepo.deleteByCampusId(campusId);
        if (!CollectionUtils.isEmpty(productIds)) {
            //批量插入校区和商品的关系
            List<RCampusProduct> list = new ArrayList<>();
            for (String productId : productIds) {
                RCampusProduct rCampusProduct = new RCampusProduct();
                rCampusProduct.setCampusId(campusId);
                rCampusProduct.setProductId(productId);
                list.add(rCampusProduct);
            }
            rCampusProductRepo.insertBatch(list);
        }
    }

    /**
     * 查询已选商品列表
     *
     * @param campusId 校区id
     * @return List<CampusProductListVo>
     * @author Dana
     * @create 2019-07-09 16:58
     * @update 2019-07-09 16:58
     */
    public List<CampusProductListVo> getCampusProducts(Integer campusId) {
        //查询已选商品列表
        return rCampusProductRepo.getCampusProducts(campusId);
    }

//    /**
//     * 查询待选商品列表
//     *
//     * @param dto
//     * @return PagedResultVo
//     * @author Dana
//     * @create 2019-07-09 16:58
//     * @update 2019-07-09 16:58
//     */
//    public List<CampusProductListVo> getCampusProductList(GetCampusProductsDto dto) {
//        //查询已选商品idList
//        List<String> productIds = rCampusProductRepo.selectProductIdsByCampusId(dto.getCampusId());
//        //查询待选商品列表
//        //List<CampusProductListVo> list = productRepo.selectCampusProducts(dto.getName(), dto.getType(), dto.getStoreId(), productIds);
//        List<CampusProductListVo> list = productRepo.selectCampusProducts(dto.getStoreId(), productIds);
//        return list;
//    }

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
    public SCampus getByNameAndStoreId(String name, String storeId) {
        SCampus campus = campusRepo.getByNameAndStoreId(name, storeId);
        return campus;
    }

}
