package com.baozupo.admin.restapi;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozupo.base.enums.APIRquest;
import com.baozupo.biz.global.MessageConf;
import com.baozupo.biz.service.SysMenuService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysMenu;
import com.baozupo.common.domain.vo.sys.SysMenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
@RestController
@RequestMapping("/sysmenu")
@Api(value = "菜单接口", tags = {"菜单接口"})
public class SysMenuApi {

    @Resource
    private SysMenuService sysMenuService;

    @ApiOperation(value = "获取菜单分页列表", notes = "获取菜单分页列表")
    @GetMapping("/getPageList")
    public CommonResult getMenuList(HttpServletRequest request,
                                    @ApiParam(name = "keyword", value = "关键字", required = false) @RequestParam(name = "keyword", required = false) String keyword,
                                    @ApiParam(name = "currentPage", value = "当前页数", required = false) @RequestParam(name = "currentPage", required = false, defaultValue = "1") Long currentPage,
                                    @ApiParam(name = "pageSize", value = "每页显示数目", required = false) @RequestParam(name = "pageSize", required = false, defaultValue = "10") Long pageSize){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        Page<SysMenu> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);

        int total = sysMenuService.count(queryWrapper);
        page.setTotal(total);
        IPage<SysMenu> pageList = sysMenuService.page(page, queryWrapper);
        List<SysMenu> list = pageList.getRecords();

        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, pageList);
    }

    @ApiOperation(value = "获取菜单父子表数据", notes = "获取菜单父子表数据")
    @PostMapping("/getExpandPageList")
    public CommonResult getExpandPageList(@RequestBody SysMenuVO sysMenuVO){

        return new CommonResult(APIRquest.REQUEST_SUCCESS, MessageConf.OPERATION_SUCCESS, sysMenuService.getExpandPageList(sysMenuVO));
    }

    @ApiOperation(value = "获取所有菜单数据数据", notes = "获取所有菜单数据数据")
    @PostMapping("/getAllMenu")
    public CommonResult getAllMenu(){

        return sysMenuService.getAllMenu();
    }

    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    @PostMapping("/add")
    public CommonResult addMenu(@RequestBody SysMenuVO sysMenuVO){

        return sysMenuService.addMenu(sysMenuVO);
    }

    @ApiOperation(value = "修改菜单信息", notes = "修改菜单信息")
    @PostMapping("/update")
    public CommonResult updateMenu(@RequestBody SysMenuVO sysMenuVO){

        return sysMenuService.updateMenu(sysMenuVO);
    }

    @ApiOperation(value = "查询菜单信息", notes = "查询菜单信息")
    @GetMapping("/get")
    public CommonResult getMenu( @ApiParam(name = "id", value = "菜单id", required = false) @RequestParam(name = "id", required = false) Long id){

        return sysMenuService.getMenuById(id);
    }

    @ApiOperation(value = "删除菜单信息", notes = "删除菜单信息")
    @PostMapping("/delete")
    public CommonResult deleteMenu(@RequestBody SysMenuVO sysMenuVO){

        return sysMenuService.deleteMenu(sysMenuVO);
    }


}

