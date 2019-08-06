package com.mso.base.cloud.campus.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mso.base.cloud.campus.domain.ShelfState;
import com.mso.base.cloud.campus.domain.po.SCampus;
import com.mso.base.cloud.campus.domain.vo.CampusDetailVo;
import com.mso.base.cloud.campus.domain.vo.CampusListVo;
import com.mso.base.cloud.campus.domain.vo.CampusProductListVo;
import com.mso.base.cloud.campus.service.CampusService;
import com.mso.base.cloud.campus.domain.dto.*;
import com.mso.base.cloud.common.aop.OperationLog;
import com.mso.base.cloud.common.controller.BaseController;
import com.mso.base.cloud.common.domain.CommonPage;
import com.mso.base.cloud.common.domain.PagedResultVo;
import com.mso.base.cloud.common.domain.ResultVo;
import com.mso.base.cloud.common.errors.ErrorCode;
import com.mso.base.cloud.common.errors.ErrorMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 校区管理 controller
 *
 * @author Dana
 * @create 2019-07-08 09:57
 * @update 2019-07-08 09:57
 */
@Slf4j
@RestController
@RequestMapping("/campus")
public class CampusController extends BaseController {

    @Autowired
    private CampusService campusService;

    /**
     * 新增校区
     *
     * @param campusDto
     * @return ResultVo
     * @author Dana
     * @create 2019-07-08 15:54
     * @update 2019-07-08 15:54
     */
    @PostMapping("/add")
    @OperationLog(message = "新增校区")
    public ResultVo addCampus(@Validated @RequestBody AddCampusDto campusDto) {
        //校验上架时间
        if (campusDto.getState() == ShelfState.DEF && campusDto.getStartTime() != null) {
            if (campusDto.getStartTime().before(new Date())) {
                return ResultVo.wrapCode(ErrorCode.COMMON_PARAM_ERROR, ErrorMsg.COMMON_PARAM_ERROR);
            }
        }
        //校验校区名称是否重复
        SCampus campus = campusService.getByNameAndStoreId(campusDto.getName(), campusDto.getStoreId());
        if (campus != null) {
            return ResultVo.wrapCode(ErrorCode.COMMON_ALREADY_EXISTS, ErrorMsg.COMMON_ALREADY_EXISTS);
        }
        //用户id
        String userId = super.getUserId();
        campusDto.setCreateBy(userId);
        campusDto.setUpdateBy(userId);
        //保存校区数据
        campusService.addCampus(campusDto);
        return ResultVo.wrapCode(ErrorCode.SUCCESS, ErrorMsg.SUCCESS);
    }

    /**
     * 查询校区详情
     *
     * @param id 校区id
     * @return ResultVo
     * @author Dana
     * @create 2019-07-08 15:40
     * @update 2019-07-08 15:40
     */
    @GetMapping("/detail")
    @OperationLog(message = "查询校区详情")
    public ResultVo getCampusDetail(@RequestParam("id") Integer id) {
        //根据id查询校区详情
        CampusDetailVo campusDetail = campusService.getCampusDetail(id);
        return ResultVo.wrap(ErrorCode.SUCCESS, ErrorMsg.SUCCESS, campusDetail);
    }

    /**
     * 修改校区
     *
     * @param campusDto
     * @return ResultVo
     * @author Dana
     * @create 2019-07-08 15:54
     * @update 2019-07-08 15:54
     */
    @PostMapping("/update")
    @OperationLog(message = "修改校区")
    public ResultVo updateCampus(@Validated @RequestBody UpdateCampusDto campusDto) {
        //校验上架时间
        if (campusDto.getState() == ShelfState.DEF && campusDto.getStartTime() != null) {
            if (campusDto.getStartTime().before(new Date())) {
                return ResultVo.wrapCode(ErrorCode.COMMON_PARAM_ERROR, ErrorMsg.COMMON_PARAM_ERROR);
            }
        }
        //校验校区名称是否重复
        SCampus campus = campusService.getByNameAndStoreId(campusDto.getName(), campusDto.getStoreId());
        if (campus != null && !campusDto.getId().equals(campus.getId())) {
            return ResultVo.wrapCode(ErrorCode.COMMON_ALREADY_EXISTS, ErrorMsg.COMMON_ALREADY_EXISTS);
        }
        //用户id
        String userId = super.getUserId();
        campusDto.setCreateBy(userId);
        campusDto.setUpdateBy(userId);
        //保存校区数据
        campusService.updateCampus(campusDto);
        return ResultVo.wrapCode(ErrorCode.SUCCESS, ErrorMsg.SUCCESS);
    }

    /**
     * 修改校区状态
     *
     * @param dto
     * @return ResultVo
     * @author Dana
     * @create 2019-07-08 15:40
     * @update 2019-07-08 15:40
     */
    @PostMapping("/update-state")
    @OperationLog(message = "修改校区状态")
    public ResultVo updateCampusState(@Validated @RequestBody UpdateCampusStateDto dto) {
        //用户id
        String userId = super.getUserId();
        dto.setCreateBy(userId);
        dto.setUpdateBy(userId);
        UpdateCampusDto campusDto = new UpdateCampusDto();
        BeanUtils.copyProperties(dto, campusDto);
        //修改校区状态
        campusService.updateCampus(campusDto);
        return ResultVo.wrapCode(ErrorCode.SUCCESS, ErrorMsg.SUCCESS);
    }

    /**
     * 查询校区管理列表
     *
     * @param dto
     * @return PagedResultVo
     * @author Dana
     * @create 2019-07-08 17:20
     * @update 2019-07-08 17:20
     */
    @PostMapping("/list")
    @OperationLog(message = "查询校区管理列表")
    public PagedResultVo getCampusList(@Validated @RequestBody GetCampusListDto dto) {
        PageHelper.startPage(dto.getPage(), dto.getSize());
        //查询校区列表数据
        List<CampusListVo> campusList = campusService.getCampusList(dto.getName(), dto.getState(), dto.getStoreId());
        //分页处理
        PageInfo pageInfo = new PageInfo(campusList);
        CommonPage commonPage = CommonPage.getCommonPage(pageInfo);
        return new PagedResultVo(ErrorCode.SUCCESS, ErrorMsg.SUCCESS, pageInfo.getList(), commonPage);
    }

    /**
     * 校区商品配置
     *
     * @param dto
     * @return ResultVo
     * @author Dana
     * @create 2019-07-09 15:57
     * @update 2019-07-09 15:57
     */
    @PostMapping("/products")
    @OperationLog(message = "校区商品配置")
    public ResultVo addCampusProducts(@Validated @RequestBody AddCampusProductsDto dto) {
        //校区商品配置
        campusService.addCampusProducts(dto);
        return ResultVo.wrapCode(ErrorCode.SUCCESS, ErrorMsg.SUCCESS);
    }

    /**
     * 查询已选商品列表
     *
     * @param campusId 校区id
     * @return PagedResultVo
     * @author Dana
     * @create 2019-07-09 16:58
     * @update 2019-07-09 16:58
     */
    @GetMapping("/products/exist")
    @OperationLog(message = "查询已选商品列表")
    public ResultVo getCampusProducts(@RequestParam("campusId") Integer campusId
                                      //,@RequestParam("page") Integer page
                                      //,@RequestParam("size") Integer size
    ) {
        //PageHelper.startPage(page, size);
        //根据校区id查询数据
        List<CampusProductListVo> list = campusService.getCampusProducts(campusId);
        //分页处理
        //PageInfo pageInfo = new PageInfo(list);
        //CommonPage commonPage = CommonPage.getCommonPage(pageInfo);
        return ResultVo.wrap(ErrorCode.SUCCESS, ErrorMsg.SUCCESS, list);
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
//    @PostMapping("/products/notexist")
//    @OperationLog(message = "查询待选商品列表")
//    public ResultVo getCampusProductList(@Validated @RequestBody GetCampusProductsDto dto) {
//        //PageHelper.startPage(dto.getPage(), dto.getSize());
//        //根据校区id查询数据
//        List<CampusProductListVo> list = campusService.getCampusProductList(dto);
//        //分页处理
//        //PageInfo pageInfo = new PageInfo(list);
//        //CommonPage commonPage = CommonPage.getCommonPage(pageInfo);
//        return ResultVo.wrap(ErrorCode.SUCCESS, ErrorMsg.SUCCESS, list);
//    }
}
