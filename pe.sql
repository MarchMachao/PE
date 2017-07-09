/*
Navicat MySQL Data Transfer

Source Server         : sweet
Source Server Version : 50554
Source Host           : 123.206.214.132:3306
Source Database       : pe

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-07-09 20:16:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for a_data
-- ----------------------------
DROP TABLE IF EXISTS `a_data`;
CREATE TABLE `a_data` (
  `id` varchar(20) NOT NULL COMMENT '学号',
  `year` int(4) NOT NULL COMMENT '年份',
  `height` int(10) DEFAULT NULL COMMENT '身高',
  `weight` double(10,1) DEFAULT NULL COMMENT '体重',
  `vital_capacity` int(10) DEFAULT NULL COMMENT '肺活量',
  `fivem` double(10,1) DEFAULT NULL COMMENT '50m跑',
  `long_jump` double(10,1) DEFAULT NULL COMMENT '立定跳远',
  `reach` double(10,1) DEFAULT NULL COMMENT '坐位体前屈',
  `eightm` varchar(10) DEFAULT NULL COMMENT '800m',
  `tenm` varchar(10) DEFAULT NULL COMMENT '1000米',
  `sit_ups` int(10) DEFAULT NULL COMMENT '仰卧起坐',
  `pull_up` int(10) DEFAULT NULL COMMENT '引体向上',
  `score` int(10) DEFAULT NULL COMMENT '成绩',
  `first_check` varchar(10) DEFAULT '' COMMENT '审核：未审核，审核通过，被退回',
  `second_check` varchar(10) DEFAULT '' COMMENT '审核：未审核，正在审核，审核通过，被退回',
  PRIMARY KEY (`id`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_data
-- ----------------------------
INSERT INTO `a_data` VALUES ('220150925821', '2015', '183', '78.5', '4020', '8.5', '200.5', '-15.0', '', '8\'12\'\'', null, '20', '85', '已审核', '审核通过');
INSERT INTO `a_data` VALUES ('220150925821', '2016', '185', '84.0', '5450', '8.3', '200.5', '-10.0', '10\'22\'\'', '', '20', null, '69', '已审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925821', '2017', null, null, null, null, null, null, null, null, null, null, null, '', '');
INSERT INTO `a_data` VALUES ('220150925822', '2016', '175', '67.0', '4562', '9.3', '150.3', '-20.0', null, '8\'22\'\'', null, '30', '88', '被退回', '未审核');
INSERT INTO `a_data` VALUES ('220150925822', '2017', '183', '70.0', '5000', '6.7', '200.0', '0.0', '', '3\'23', '0', '10', '96', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925823', '2015', '173', '56.0', '13554', '12.5', '152.2', '-38.0', '8\'44\'\'', '', '23', null, '55', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925823', '2016', '174', '65.0', '5842', '8.9', '150.3', '-16.0', '8\'22\'\'', '', '30', null, '70', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925823', '2017', '173', '65.0', '5000', '6.7', '200.0', '0.0', '', '3\'22', '0', '10', '100', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925824', '2015', '183', '54.0', '5456', '4.4', '50.0', '10.0', null, '2‘22’‘', '0', '10', '125', '未审核', '未审核');

-- ----------------------------
-- Table structure for a_student
-- ----------------------------
DROP TABLE IF EXISTS `a_student`;
CREATE TABLE `a_student` (
  `id` varchar(20) NOT NULL COMMENT '学号',
  `name` varchar(12) NOT NULL COMMENT '姓名',
  `gender` varchar(4) NOT NULL COMMENT '性别',
  `school` varchar(20) NOT NULL COMMENT '学院',
  `grade` int(20) NOT NULL COMMENT '年级',
  `classes` varchar(20) DEFAULT '' COMMENT '班级',
  `duration` int(4) NOT NULL COMMENT '学制：4,5',
  `state` varchar(10) NOT NULL DEFAULT '' COMMENT '学生状态：正常、免测、请假、毕业',
  `teacher` varchar(10) DEFAULT NULL COMMENT '所属老师',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_student
-- ----------------------------
INSERT INTO `a_student` VALUES ('220150925821', '刘晓庆', '男', '信息科学与工程学院', '2015', '2', '4', '正常', '学院');
INSERT INTO `a_student` VALUES ('220150925822', '冯广博', '男', '信息科学与工程学院', '2013', '2', '4', '已毕业', '胡老师');
INSERT INTO `a_student` VALUES ('220150925823', '马超', '男', '文学院', '2016', '2', '4', '正常', '何老师');
INSERT INTO `a_student` VALUES ('220150925824', '白江伟', '男', '外国语学院', '2016', '2', '4', '正常', '学院');
INSERT INTO `a_student` VALUES ('34', '342', '53', '342', '342', '', '342', '342', null);

-- ----------------------------
-- Table structure for a_student1
-- ----------------------------
DROP TABLE IF EXISTS `a_student1`;
CREATE TABLE `a_student1` (
  `id` varchar(20) NOT NULL COMMENT '学号',
  `name` varchar(12) NOT NULL DEFAULT '1' COMMENT '姓名',
  `gender` varchar(4) NOT NULL DEFAULT '1' COMMENT '性别',
  `school` varchar(20) NOT NULL DEFAULT '1' COMMENT '学院',
  `grade` int(20) NOT NULL DEFAULT '1' COMMENT '年级',
  `classes` varchar(20) DEFAULT '1' COMMENT '班级',
  `duration` int(4) NOT NULL DEFAULT '4' COMMENT '学制：4,5',
  `state` varchar(10) NOT NULL DEFAULT '1' COMMENT '学生状态：正常、免测、请假、毕业',
  `teacher` varchar(10) DEFAULT '1' COMMENT '所属老师',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_student1
-- ----------------------------

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
INSERT INTO `s_menu` VALUES ('2001', '体侧信息', '0', 'getStudentById.do', '1', ',学生,管理员,');
INSERT INTO `s_menu` VALUES ('2002', '教师成绩输入', '0', 'teacherManger.html', '1', ',教师,管理员,');
INSERT INTO `s_menu` VALUES ('2003', '学院成绩输入', '0', 'academyManger.html', '1', ',学院,管理员,');
INSERT INTO `s_menu` VALUES ('2004', '学院成绩审核', '0', 'checkAcademyManger.ftl', '1', ',学院审核,管理员,,学院,');
INSERT INTO `s_menu` VALUES ('2005', '教师审核列表', '0', 'getCheckList.do', '1', ',教师审核,管理员,');
INSERT INTO `s_menu` VALUES ('2006', '管理员已毕业界面', '0', 'adminGraduateManger.html', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2007', '管理员未毕业界面', '0', 'adminManger.html', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2008', '用户管理', '0', 'none', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2009', '学生账号管理', '2008', 'studentPassword.html', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2010', '教职账号管理', '2008', 'teacherPassword.html', '1', ',管理员,');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `userName` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `nickName` varchar(10) NOT NULL COMMENT '昵称',
  `role` varchar(20) NOT NULL COMMENT '角色',
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('220150925821', 'cd2deeb588788b340083c064ab667755', '学生', '学生');
INSERT INTO `s_user` VALUES ('academy', 'cd2deeb588788b340083c064ab667755', '学院', '学院');
INSERT INTO `s_user` VALUES ('gdgasg', '7d3747e6f0de893f8994f5a028c512a2', 'dfadga', '学生');
INSERT INTO `s_user` VALUES ('liuxq', 'cd2deeb588788b340083c064ab667755', '刘晓庆', '管理员');
INSERT INTO `s_user` VALUES ('lll', '123442', 'dfaf', 'dfs');
INSERT INTO `s_user` VALUES ('mc', 'cd2deeb588788b340083c064ab667755', '马超', '管理员');
INSERT INTO `s_user` VALUES ('mcdfa', '7d3747e6f0de893f8994f5a028c512a2', 'dfadga', '学生');
INSERT INTO `s_user` VALUES ('teacher', 'cd2deeb588788b340083c064ab667755', '老师', '教师');
INSERT INTO `s_user` VALUES ('wgy', 'cd2deeb588788b340083c064ab667755', '外国语学院', '学院');
INSERT INTO `s_user` VALUES ('xxxy', 'cd2deeb588788b340083c064ab667755', '信息科学与工程学院', '学院');

-- ----------------------------
-- Table structure for s_user1
-- ----------------------------
DROP TABLE IF EXISTS `s_user1`;
CREATE TABLE `s_user1` (
  `userName` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(50) NOT NULL DEFAULT '1' COMMENT '密码',
  `nickName` varchar(10) NOT NULL DEFAULT '1' COMMENT '昵称',
  `role` varchar(20) NOT NULL DEFAULT '1' COMMENT '角色',
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user1
-- ----------------------------
INSERT INTO `s_user1` VALUES ('454', '4525', '1', '1');
SET FOREIGN_KEY_CHECKS=1;
