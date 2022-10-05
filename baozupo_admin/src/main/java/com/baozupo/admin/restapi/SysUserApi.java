package com.baozupo.admin.restapi;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozupo.base.enums.APIRquest;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.service.SysUserService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysUser;
import com.baozupo.common.domain.vo.sys.SysUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@RestController
@RequestMapping("/sysuser")
@Api(value = "管理员接口", tags = {"管理员接口"})
public class SysUserApi {

    @Resource
    SysUserService sysUserService;

    @ApiOperation(value = "getUser", notes = "测试getUser")
    @PostMapping("/getUser")
    public CommonResult getUser(@Validated @RequestBody SysUserVo userVo){

        System.out.println(">>>>>查询用户>>>>>>>>");

        return sysUserService.getUser(userVo);
    }

    @ApiOperation(value = "获取管理员列表", notes = "获取管理员列表")
    @GetMapping("/getPageList")
    @ResponseBody
    public CommonResult getMenuList(HttpServletRequest request,
                                    @ApiParam(name = "keyword", value = "关键字", required = false) @RequestParam(name = "keyword", required = false) String keyword,
                                    @ApiParam(name = "currentPage", value = "当前页数", required = false) @RequestParam(name = "currentPage", required = false, defaultValue = "1") Long currentPage,
                                    @ApiParam(name = "pageSize", value = "每页显示数目", required = false) @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long pageSize){
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        Page<SysUser> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        page.setTotal(0);

        int total = sysUserService.count(queryWrapper);
        page.setTotal(total);
        IPage<SysUser> pageList = sysUserService.page(page, queryWrapper);
        List<SysUser> list = pageList.getRecords();

        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, pageList);
    }

    @ApiOperation(value = "新增管理员", notes = "新增管理员")
    @PostMapping("/add")
    public CommonResult addSysUser(@RequestBody SysUserVo sysUserVo){

        return sysUserService.addSysUser(sysUserVo);
    }

    @ApiOperation(value = "修改管理员信息", notes = "修改管理员信息")
    @PostMapping("/update")
    public CommonResult updateSysUser(@RequestBody SysUserVo sysUserVo){

        return sysUserService.updateSysUser(sysUserVo);
    }

    @ApiOperation(value = "查询管理员信息", notes = "查询管理员信息")
    @GetMapping("/get")
    public CommonResult getSysUser( @ApiParam(name = "id", value = "管理员id", required = true) @RequestParam(name = "id", required = false) String id){

        return sysUserService.getSysUserById(id);
    }

    @ApiOperation(value = "删除管理员信息", notes = "删除管理员信息")
    @GetMapping("/delete")
    public CommonResult deleteSysUser(@RequestBody SysUserVo sysUserVo){

        return sysUserService.deleteSysUser(sysUserVo);
    }




}

