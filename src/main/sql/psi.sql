/*
 Navicat Premium Data Transfer

 Source Server         : HY
 Source Server Type    : MySQL
 Source Server Version : 50559
 Source Host           : localhost:3306
 Source Schema         : psi

 Target Server Type    : MySQL
 Target Server Version : 50559
 File Encoding         : 65001

 Date: 24/12/2019 20:10:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限类型[menu/permission]',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限编码[只有type= permission才有  user:view]',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '状态【0不可用1可用】',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 0, 'menu', '尚学堂进销存管理系统', NULL, '&#xe68e;', '', '', 1);
INSERT INTO `sys_permission` VALUES (2, 1, 'menu', '基础管理', NULL, '&#xe857;', '', '', 1);
INSERT INTO `sys_permission` VALUES (3, 1, 'menu', '进货管理', NULL, '&#xe645;', '', NULL, 1);
INSERT INTO `sys_permission` VALUES (4, 1, 'menu', '销售管理', NULL, '&#xe611;', '', '', 1);
INSERT INTO `sys_permission` VALUES (5, 1, 'menu', '系统管理', NULL, '&#xe614;', '', '', 1);
INSERT INTO `sys_permission` VALUES (6, 1, 'menu', '其它管理', NULL, '&#xe628;', '', '', 1);
INSERT INTO `sys_permission` VALUES (7, 2, 'menu', '客户管理', NULL, '&#xe651;', '/bus/toCustomerManager', '', 1);
INSERT INTO `sys_permission` VALUES (8, 2, 'menu', '供应商管理', NULL, '&#xe658;', '/bus/toProviderManager', '', 1);
INSERT INTO `sys_permission` VALUES (9, 2, 'menu', '商品管理', NULL, '&#xe657;', '/bus/toGoodsManager', '', 1);
INSERT INTO `sys_permission` VALUES (10, 3, 'menu', '商品进货', NULL, '&#xe756;', '/bus/toInportManager', '', 1);
INSERT INTO `sys_permission` VALUES (11, 3, 'menu', '商品退货查询', NULL, '&#xe65a;', '/bus/toOutportManager', '', 1);
INSERT INTO `sys_permission` VALUES (12, 4, 'menu', '商品销售', NULL, '&#xe65b;', '', '', 1);
INSERT INTO `sys_permission` VALUES (13, 4, 'menu', '销售退货查询', NULL, '&#xe770;', '', '', 1);
INSERT INTO `sys_permission` VALUES (14, 5, 'menu', '部门管理', NULL, '&#xe770;', '/sys/toDeptManager', '', 1);
INSERT INTO `sys_permission` VALUES (15, 5, 'menu', '菜单管理', NULL, '&#xe857;', '/sys/toMenuManager', '', 1);
INSERT INTO `sys_permission` VALUES (16, 5, 'menu', '权限管理', '', '&#xe857;', '/sys/toPermissionManager', '', 1);
INSERT INTO `sys_permission` VALUES (17, 5, 'menu', '角色管理', '', '&#xe650;', '/sys/toRoleManager', '', 1);
INSERT INTO `sys_permission` VALUES (18, 5, 'menu', '用户管理', '', '&#xe612;', '/sys/toUserManager', '', 1);
INSERT INTO `sys_permission` VALUES (21, 6, 'menu', '登陆日志', NULL, '&#xe675;', '/sys/toLoginfoManager', '', 1);
INSERT INTO `sys_permission` VALUES (22, 6, 'menu', '系统公告', NULL, '&#xe756;', '/sys/toNoticeManager', NULL, 1);
INSERT INTO `sys_permission` VALUES (23, 6, 'menu', '图标管理', NULL, '&#xe670;', '../resources/page/icon.html', NULL, 1);
INSERT INTO `sys_permission` VALUES (30, 14, 'permission', '添加部门', 'dept:create', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (31, 14, 'permission', '修改部门', 'dept:update', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (32, 14, 'permission', '删除部门', 'dept:delete', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (34, 15, 'permission', '添加菜单', 'menu:create', '', '', '', 1);
INSERT INTO `sys_permission` VALUES (35, 15, 'permission', '修改菜单', 'menu:update', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (36, 15, 'permission', '删除菜单', 'menu:delete', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (38, 16, 'permission', '添加权限', 'permission:create', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (39, 16, 'permission', '修改权限', 'permission:update', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (40, 16, 'permission', '删除权限', 'permission:delete', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (42, 17, 'permission', '添加角色', 'role:create', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (43, 17, 'permission', '修改角色', 'role:update', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (44, 17, 'permission', '角色删除', 'role:delete', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (46, 17, 'permission', '分配权限', 'role:selectPermission', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (47, 18, 'permission', '添加用户', 'user:create', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (48, 18, 'permission', '修改用户', 'user:update', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (49, 18, 'permission', '删除用户', 'user:delete', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (51, 18, 'permission', '用户分配角色', 'user:selectRole', '', NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (52, 18, 'permission', '重置密码', 'user:resetPwd', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (53, 14, 'permission', '部门查询', 'dept:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (54, 15, 'permission', '菜单查询', 'menu:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (55, 16, 'permission', '权限查询', 'permission:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (56, 17, 'permission', '角色查询', 'role:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (57, 18, 'permission', '用户查询', 'user:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (68, 7, 'permission', '客户查询', 'customer:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (69, 7, 'permission', '客户添加', 'customer:create', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (70, 7, 'permission', '客户修改', 'customer:update', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (71, 7, 'permission', '客户删除', 'customer:delete', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (73, 21, 'permission', '日志查询', 'info:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (74, 21, 'permission', '日志删除', 'info:delete', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (75, 21, 'permission', '日志批量删除', 'info:batchdelete', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (76, 22, 'permission', '公告查询', 'notice:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (77, 22, 'permission', '公告添加', 'notice:create', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (78, 22, 'permission', '公告修改', 'notice:update', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (79, 22, 'permission', '公告删除', 'notice:delete', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (81, 8, 'permission', '供应商查询', 'provider:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (82, 8, 'permission', '供应商添加', 'provider:create', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (83, 8, 'permission', '供应商修改', 'provider:update', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (84, 8, 'permission', '供应商删除', 'provider:delete', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (86, 22, 'permission', '公告查看', 'notice:viewnotice', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (91, 9, 'permission', '商品查询', 'goods:view', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (92, 9, 'permission', '商品添加', 'goods:create', NULL, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (94, 9, 'permission', '商品修改', 'goods:update', NULL, 'goods:update', NULL, 1);
INSERT INTO `sys_permission` VALUES (95, 6, 'menu', '缓存管理', NULL, '&#xe681;', '/sys/toCacheManager', '', 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `salt` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL,
  `type` int(1) NULL DEFAULT NULL COMMENT '用户类型',
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `psi_sys_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'ba61ce8fa1e3725876e6363c76043c8d', 'a', NULL, 0, 0, '2019-12-07 01:38:49', '2019-12-06 01:38:54');

SET FOREIGN_KEY_CHECKS = 1;
