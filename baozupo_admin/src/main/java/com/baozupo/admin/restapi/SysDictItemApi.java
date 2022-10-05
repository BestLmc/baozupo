package com.baozupo.admin.restapi;


import com.baozupo.base.enums.APIRquest;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.service.SysDictItemService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.vo.sys.SysDictItemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 字典数据项表 前端控制器
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@RestController
@RequestMapping("/sysdictitem")
@Api(value = "字典项接口", tags = {"字典项接口"})
public class SysDictItemApi {

    @Resource
    SysDictItemService sysDictItemService;

    @ApiOperation(value = "获取字典项分页列表", notes = "获取字典项分页列表")
    @PostMapping("/getPageList")
    public CommonResult getPageList(@RequestBody SysDictItemVO sysDictItemVO){


        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysDictItemService.getPageList(sysDictItemVO));
    }

    @ApiOperation(value = "获取字典项列表", notes = "获取字典项列表")
    @PostMapping("/getList")
    public CommonResult getList(@RequestBody SysDictItemVO sysDictItemVO){


        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysDictItemService.getList(sysDictItemVO));
    }

    @ApiOperation(value = "新增字典项", notes = "新增字典项")
    @PostMapping("/add")
    public CommonResult add(@RequestBody SysDictItemVO sysDictItemVO){


        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysDictItemService.add(sysDictItemVO));
    }

    @ApiOperation(value = "修改字典项", notes = "修改字典项")
    @PostMapping("/update")
    public CommonResult update(@RequestBody SysDictItemVO sysDictItemVO){


        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysDictItemService.update(sysDictItemVO));
    }

    @ApiOperation(value = "删除字典项", notes = "删除字典项")
    @PostMapping("/delete")
    public CommonResult delete(@RequestBody SysDictItemVO sysDictItemVO){

        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysDictItemService.delete(sysDictItemVO));
    }
}

