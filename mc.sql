/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-06-22 21:26:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `MENU_ID` varchar(40) NOT NULL default '' COMMENT '菜单ID',
  `MENU_NAME` varchar(50) default NULL COMMENT '菜单名称',
  `PARENT_ID` varchar(40) default '' COMMENT '上级菜单ID',
  `MENU_URL` varchar(50) default NULL COMMENT '菜单URL',
  `ORDER_NO` int(20) default NULL COMMENT '排序号',
  `PERMITION` varchar(50) NOT NULL COMMENT '菜单的访问权限 0：普通用户 1：管理员',
  PRIMARY KEY  (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='èœå•';

-- ----------------------------
-- Records of s_menu
-- ----------------------------

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `userName` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `nickName` varchar(10) NOT NULL COMMENT '昵称',
  `role` varchar(20) NOT NULL COMMENT '角色',
  `createDate` varchar(20) NOT NULL COMMENT '创建时间',
  PRIMARY KEY  (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('mc', 'cd2deeb588788b340083c064ab667755', '马超', '管理员', '2017-06-18 17:15:15');
