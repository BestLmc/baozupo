package com.baozupo.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baozupo.common.domain.entity.sys.SysMenu;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author bestlmc
 * @since 2022-10-04
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    public SysMenu getMenuById(@Param("id") Long id);
}
