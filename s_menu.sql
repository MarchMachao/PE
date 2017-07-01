/*
Navicat MySQL Data Transfer

Source Server         : mc
Source Server Version : 50554
Source Host           : 123.206.214.132:3306
Source Database       : pe

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-07-01 08:50:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `MENU_ID` varchar(40) NOT NULL DEFAULT '' COMMENT '菜单ID',
  `MENU_NAME` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `PARENT_ID` varchar(40) DEFAULT '' COMMENT '上级菜单ID',
  `MENU_URL` varchar(50) DEFAULT NULL COMMENT '菜单URL',
  `ORDER_NO` int(20) DEFAULT NULL COMMENT '排序号',
  `PERMITION` varchar(50) NOT NULL COMMENT '菜单的访问权限 0：普通用户 1：管理员',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='èœå•';

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('2000', '用户管理', '0', 'userManger.html', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2001', '体侧信息', '0', 'getStudentById.do', '1', ',学生,管理员,');
INSERT INTO `s_menu` VALUES ('2002', '教师成绩输入', '0', 'teacherManger.html', '1', ',教师,管理员,');
INSERT INTO `s_menu` VALUES ('2003', '学院成绩输入', '0', 'academyManger.html', '1', ',学院,管理员,');
INSERT INTO `s_menu` VALUES ('2004', '学院成绩审核', '0', 'checkAcademyManger.html', '1', ',学院审核,管理员,');
INSERT INTO `s_menu` VALUES ('2005', '教师审核列表', '0', 'getCheckList.do', '1', ',教师审核,管理员,');
INSERT INTO `s_menu` VALUES ('2006', '管理员界面', '0', 'adminManger.html', '1', ',管理员,');
SET FOREIGN_KEY_CHECKS=1;
