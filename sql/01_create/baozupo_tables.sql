


CREATE DATABASE /*!32312 IF NOT EXISTS*/`baozupo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `baozupo`;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
    `username` varchar(255) NOT NULL COMMENT '用户名',
    `password` varchar(255) NOT NULL COMMENT '密码',
    `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
    `gender` varchar(1) DEFAULT NULL COMMENT '性别(1:男2:女)',
    `avatar` varchar(100) DEFAULT NULL COMMENT '个人头像',
    `phone` varchar(11) DEFAULT NULL COMMENT '手机',
    `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
    `birthday` date DEFAULT NULL COMMENT '出生年月日',
    `valid_code` varchar(50) DEFAULT NULL COMMENT '邮箱验证码',
    `introduce` varchar(200) DEFAULT NULL COMMENT '自我简介最多150字',
    `login_count` int(11) unsigned DEFAULT '0' COMMENT '登录次数',
    `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
    `last_login_ip` varchar(50) DEFAULT '127.0.0.1' COMMENT '最后登录IP',
    `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
    `is_admin` bit(1) DEFAULT b'0' COMMENT '是否为admin账号',
    `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
    `update_by` varchar(255) DEFAULT NULL COMMENT '更新者',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`) USING BTREE,
    UNIQUE KEY `uniq_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
   `user_id` bigint(20) NOT NULL COMMENT '用户ID',
   `role_id` bigint(20) NOT NULL COMMENT '角色ID',
   PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色关联';


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
    `data_scope` varchar(255) DEFAULT NULL COMMENT '数据权限',
    `role_name` varchar(255) NOT NULL COMMENT '角色名',
    `role_level` int(255) DEFAULT NULL COMMENT '角色级别',
    `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
    `introduce` varchar(255) DEFAULT NULL COMMENT '角色介绍',
    `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
    `update_by` varchar(255) DEFAULT NULL COMMENT '更新者',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uniq_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_menus`;
CREATE TABLE `sys_roles_menus` (
   `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
   `role_id` bigint(20) NOT NULL COMMENT '角色ID',
   PRIMARY KEY (`menu_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色菜单关联';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一uid',
    `pid` bigint(20) DEFAULT NULL COMMENT '上级菜单ID',
    `sub_count` int(5) DEFAULT 0 COMMENT '子菜单数目',
    `menu_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '菜单类型 0: 菜单   1: 按钮',
    `menu_name` varchar(255) NOT NULL COMMENT '菜单名称',
    `menu_code` varchar(255) NOT NULL COMMENT '菜单代码',
    `menu_level` tinyint(1) DEFAULT NULL COMMENT '菜单级别',
    `introduce` varchar(200) DEFAULT NULL COMMENT '简介',
    `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
    `icon` varchar(50) DEFAULT NULL COMMENT '图标',
    `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
    `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
    `is_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 1:是 0:否',
    `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
    `update_by` varchar(255) DEFAULT NULL COMMENT '更新者',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uniq_menu_code` (`menu_code`),
    UNIQUE KEY `uniq_menu_name` (`menu_name`),
    KEY `inx_pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单表';

/*Table structure for table `t_sys_dict` */
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `dict_name` varchar(100) DEFAULT NULL COMMENT '字典名称',
   `dict_code` varchar(50) DEFAULT NULL COMMENT '字典代码',
   `create_by` varchar(32) NOT NULL COMMENT '创建人UID',
   `update_by` varchar(32) NOT NULL COMMENT '最后更新人UID',
   `remark` varchar(255) DEFAULT NULL COMMENT '备注',
   `status` tinyint(1) DEFAULT '0' COMMENT '状态(1:启用，0:停用)',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='字典表';

/*Table structure for table `t_sys_dict_item` */
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `dict_id` bigint(20) DEFAULT NULL COMMENT 'sys_dict字典ID',
   `item_label` varchar(255) DEFAULT NULL COMMENT '字典标签',
   `item_value` varchar(255) DEFAULT NULL COMMENT '字典键值',
   `create_by` varchar(32) DEFAULT NULL COMMENT '创建人UID',
   `update_by` varchar(32) DEFAULT NULL COMMENT '最后更新人UID',
   `remark` varchar(255) DEFAULT NULL COMMENT '备注',
   `status` tinyint(1) DEFAULT '0' COMMENT '状态(1:启用，0:停用)',
   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COMMENT='字典数据项表';







































