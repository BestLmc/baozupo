package com.baozupo.admin.restapi;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozupo.base.enums.APIRquest;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.service.SysRoleService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysRole;
import com.baozupo.common.domain.vo.sys.SysRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@RestController
@RequestMapping("/sysrole")
@Api(value = "角色接口", tags = {"角色接口"})
public class SysRoleApi {

    @Resource
    SysRoleService sysRoleService;

    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
    @GetMapping("/getPageList")
    public CommonResult getMenuList(HttpServletRequest request,
                                    @ApiParam(name = "keyword", value = "关键字", required = false) @RequestParam(name = "keyword", required = false) String keyword,
                                    @ApiParam(name = "currentPage", value = "当前页数", required = false) @RequestParam(name = "currentPage", required = false, defaultValue = "1") Long currentPage,
                                    @ApiParam(name = "pageSize", value = "每页显示数目", required = false) @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long pageSize){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        Page<SysRole> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);

        int total = sysRoleService.count(queryWrapper);
        page.setTotal(total);
        IPage<SysRole> pageList = sysRoleService.page(page, queryWrapper);
        List<SysRole> list = pageList.getRecords();

        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, pageList);
    }

    @ApiOperation(value = "新增角色", notes = "新增角色")
    @PostMapping("/add")
    public CommonResult addRole(@RequestBody SysRoleVO sysRoleVO){

        return sysRoleService.addRole(sysRoleVO);
    }

    @ApiOperation(value = "修改角色信息", notes = "修改角色信息")
    @PostMapping("/update")
    public CommonResult updateRole(@RequestBody SysRoleVO sysRoleVO){

        return sysRoleService.updateRole(sysRoleVO);
    }

    @ApiOperation(value = "查询角色信息", notes = "查询角色信息")
    @GetMapping("/get")
    public CommonResult getRoleById( @ApiParam(name = "uid", value = "角色id", required = false) @RequestParam(name = "uid", required = false) String uid){

        return sysRoleService.getRoleById(uid);
    }

    @ApiOperation(value = "删除角色信息", notes = "删除角色信息")
    @GetMapping("/delete")
    public CommonResult deleteRoleById(@RequestBody SysRoleVO sysRoleVO){

        return sysRoleService.deleteRole(sysRoleVO);
    }


}

