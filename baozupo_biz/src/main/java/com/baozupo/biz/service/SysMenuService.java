package com.baozupo.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baozupo.common.domain.CommonResult;
import com.baozupo.common.domain.entity.sys.SysMenu;
import com.baozupo.common.domain.vo.sys.SysMenuVO;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
public interface SysMenuService extends IService<SysMenu> {
    public IPage<SysMenu> getExpandPageList(SysMenuVO sysMenuVO);

    public CommonResult addMenu(SysMenuVO sysMenuVO);

    public CommonResult getAllMenu();

    public CommonResult updateMenu(SysMenuVO sysMenuVO);

    public CommonResult getMenuById(Long id);

    public CommonResult deleteMenu(SysMenuVO sysMenuVO);
}
