package com.baozupo.admin.restapi;


import com.baozupo.base.enums.APIRquest;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.service.SysDictService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.vo.sys.SysDictVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@RestController
@RequestMapping("/sysdict")
@Api(value = "字典接口", tags = {"字典接口"})
public class SysDictApi {

    @Resource
    SysDictService sysDictService;

    @ApiOperation(value = "获取字典列表", notes = "获取字典列表")
    @PostMapping("/getPageList")
    public CommonResult getList(@RequestBody SysDictVO sysDictVO){


        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysDictService.getPageList(sysDictVO));
    }

    @ApiOperation(value = "新增字典", notes = "新增字典")
    @PostMapping("/add")
    public CommonResult addSysDict(@RequestBody SysDictVO sysDictVO){


        return sysDictService.addSysDict(sysDictVO);
    }

    @ApiOperation(value = "修改字典", notes = "修改字典")
    @PostMapping("/update")
    public CommonResult updateSysDict(@RequestBody SysDictVO sysDictVO){

        return sysDictService.updateSysDict(sysDictVO);
    }

    @ApiOperation(value = "删除字典", notes = "删除字典")
    @PostMapping("/delete")
    public CommonResult deleteSysDict(@RequestBody SysDictVO sysDictVO){

        return sysDictService.deleteSysDict(sysDictVO);
    }
}

