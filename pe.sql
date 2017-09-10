/*
Navicat MySQL Data Transfer

Source Server         : sweet
Source Server Version : 50554
Source Host           : 123.206.214.132:3306
Source Database       : pe

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-09-11 00:38:21
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
INSERT INTO `a_data` VALUES ('220150925821', '2015', '183', '78.5', '4020', '8.5', '200.5', '-15.0', '', '8\'12\'\'', null, '20', '85', '已审核', '已审核');
INSERT INTO `a_data` VALUES ('220150925821', '2016', '185', '84.0', '5450', '8.3', '200.5', '-10.0', '10\'22\'\'', '', '22', null, '70', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925821', '2017', null, null, null, null, null, null, null, null, null, null, null, '', '');
INSERT INTO `a_data` VALUES ('220150925822', '2016', '175', '67.0', '4562', '9.3', '150.3', '-20.0', null, '8\'22\'\'', null, '30', '88', '被退回', '未审核');
INSERT INTO `a_data` VALUES ('220150925823', '2015', '173', '56.0', '13554', '12.5', '152.2', '-38.0', '8\'44\'\'', '', '23', null, '55', '已审核', '已审核');
INSERT INTO `a_data` VALUES ('220150925823', '2016', '174', '65.0', '5842', '8.9', '150.3', '-16.0', '8\'22\'\'', '', '30', null, '70', '已审核', '已审核');
INSERT INTO `a_data` VALUES ('220150925823', '2017', null, null, null, null, null, null, null, null, null, null, null, '', '');
INSERT INTO `a_data` VALUES ('220150925824', '2015', '183', '54.0', '5456', '4.4', '50.0', '10.0', null, '2‘22’‘', '0', '10', '125', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925824', '2017', null, null, null, null, null, null, null, null, null, null, null, '', '');
INSERT INTO `a_data` VALUES ('220150925853', '2015', '153', '15.0', '5431', '4.3', '20.0', '10.0', null, '5‘22‘’', '0', '10', '123', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925856', '2017', null, null, null, null, null, null, null, null, null, null, null, '', '');
INSERT INTO `a_data` VALUES ('220150932243', '2015', '153', '13.0', '5621', '131.0', '200.3', '-13.0', '8\'22\'\'', '3', '0', '12', '13', '未审核', '未审核');

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
INSERT INTO `a_student` VALUES ('220150925822', '冯广博', '男', '信息科学与工程学院', '2013', '2', '4', '已毕业', '老师');
INSERT INTO `a_student` VALUES ('220150925823', '马超', '男', '文学院', '2016', '2', '4', '正常', '老师');
INSERT INTO `a_student` VALUES ('220150925824', '白江伟', '男', '外国语学院', '2016', '2', '4', '正常', '学院');
INSERT INTO `a_student` VALUES ('220150925853', '司马懿', '男', '新闻与传播学院', '2015', '2', '2', '已毕业', '学院');
INSERT INTO `a_student` VALUES ('220150925856', '张春华', '女', '文学院', '2016', '2', '4', '正常', '老师');
INSERT INTO `a_student` VALUES ('220150932213', '凯凯1', '男', '文学院', '2016', '2', '4', '正常', '老师');
INSERT INTO `a_student` VALUES ('220150932243', '波波', '男', '经济学院', '2015', '22', '4', '正常', '老师');
INSERT INTO `a_student` VALUES ('2201509323', '凯凯2', '男', '文学院', '2016', '3', '4', '正常', '老师');

-- ----------------------------
-- Table structure for a_student1
-- ----------------------------
DROP TABLE IF EXISTS `a_student1`;
CREATE TABLE `a_student1` (
  `id` varchar(20) NOT NULL DEFAULT '0' COMMENT '学号',
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
INSERT INTO `a_student1` VALUES ('220150', 'nan', 'lxq', '文学院', '2015', '2', '4', '正常', 'he');
INSERT INTO `a_student1` VALUES ('2201525', 'f', 'mac', '文学院', '2016', '3', '4', '正常', '55');

-- ----------------------------
-- Table structure for a_teacher
-- ----------------------------
DROP TABLE IF EXISTS `a_teacher`;
CREATE TABLE `a_teacher` (
  `studentid` varchar(12) NOT NULL,
  `year` int(4) NOT NULL COMMENT '年份',
  `teacher` varchar(20) NOT NULL,
  `subjectid` varchar(20) NOT NULL COMMENT '课程编号',
  `subjectname` varchar(20) NOT NULL,
  PRIMARY KEY (`studentid`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_teacher
-- ----------------------------
INSERT INTO `a_teacher` VALUES ('220150925821', '2017', '何老师', '1022', 'HEHEEEE');
INSERT INTO `a_teacher` VALUES ('220150925822', '2015', '何老师', '1311', '排球');
INSERT INTO `a_teacher` VALUES ('220150925823', '2016', '何老师', '1011', '篮球');
INSERT INTO `a_teacher` VALUES ('220150925824', '2015', '何老师', '1011', '篮球');
INSERT INTO `a_teacher` VALUES ('220150925856', '2017', '何老师', '1023', '足球');
INSERT INTO `a_teacher` VALUES ('220150932243', '2016', '李老师', '1311', '排球');

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
INSERT INTO `s_menu` VALUES ('2002', '教师成绩输入', '0', 'none', '2', ',教师,');
INSERT INTO `s_menu` VALUES ('2003', '学院成绩输入', '0', 'academyManger.html', '3', ',学院,');
INSERT INTO `s_menu` VALUES ('2004', '学院成绩审核', '0', 'checkAcademyManger.ftl', '5', ',学院审核,');
INSERT INTO `s_menu` VALUES ('2005', '教师成绩审核', '0', 'getCheckList.do', '4', ',教师审核,');
INSERT INTO `s_menu` VALUES ('2006', '学生信息查询', '0', 'none', '6', ',管理员,');
INSERT INTO `s_menu` VALUES ('2008', '用户管理', '0', 'none', '7', ',管理员,');
INSERT INTO `s_menu` VALUES ('2009', '学生账号管理', '2008', 'adminStudentUser.html', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2010', '教职账号管理', '2008', 'adminTeacherUser.html', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2011', '密码修改', '0', 'updatePassword.html', '8', ',教师,学院审核,管理员,,学院,教师审核,');
INSERT INTO `s_menu` VALUES ('2016', '已毕业学生', '2006', 'adminGraduateManger.html', '2', ',管理员,');
INSERT INTO `s_menu` VALUES ('2017', '在读学生', '2006', 'adminManger.html', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2018', '管理员成绩审核', '0', 'getAdminCheckList.do', '1', ',管理员,');
INSERT INTO `s_menu` VALUES ('2019', '大一/大二体侧数据', '2002', 'teacherFreshmanList.do', '2', ',教师,');
INSERT INTO `s_menu` VALUES ('2020', '大三/大四体侧数据', '2002', 'teacherJuniorManger.html', '3', ',教师,');

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
INSERT INTO `s_user` VALUES ('11111', 'cd2deeb588788b340083c064ab667755', '男', '学生');
INSERT INTO `s_user` VALUES ('220150925821', 'cd2deeb588788b340083c064ab667755', '男', '学生');
INSERT INTO `s_user` VALUES ('220150925853', 'cd2deeb588788b340083c064ab667755', '男', '学生');
INSERT INTO `s_user` VALUES ('220150925856', 'cd2deeb588788b340083c064ab667755', '张春华', '学生');
INSERT INTO `s_user` VALUES ('2201509322', 'cd2deeb588788b340083c064ab667755', '凯凯1', '学生');
INSERT INTO `s_user` VALUES ('2201509323', 'cd2deeb588788b340083c064ab667755', '凯凯2', '学生');
INSERT INTO `s_user` VALUES ('academy', 'cd2deeb588788b340083c064ab667755', '学院', '学院');
INSERT INTO `s_user` VALUES ('admin', 'cd2deeb588788b340083c064ab667755', '管理员', '管理员');
INSERT INTO `s_user` VALUES ('liuxq', 'cd2deeb588788b340083c064ab667755', '刘晓庆', '管理员');
INSERT INTO `s_user` VALUES ('mc', 'cd2deeb588788b340083c064ab667755', '马超', '管理员');
INSERT INTO `s_user` VALUES ('teacherHe', 'cd2deeb588788b340083c064ab667755', '何老师', '教师');
INSERT INTO `s_user` VALUES ('teachersh', 'cd2deeb588788b340083c064ab667755', '老师', '教师审核');
INSERT INTO `s_user` VALUES ('wgy', 'cd2deeb588788b340083c064ab667755', '外国语学院', '学院');
INSERT INTO `s_user` VALUES ('xxxy', 'cd2deeb588788b340083c064ab667755', '信息科学与工程学院', '学院');
INSERT INTO `s_user` VALUES ('xxxysh', 'cd2deeb588788b340083c064ab667755', '信息科学与工程学院', '学院审核');

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
INSERT INTO `s_user1` VALUES ('220150', '1', '0', '1');
INSERT INTO `s_user1` VALUES ('220150925821', 'nan', '1', '1');
SET FOREIGN_KEY_CHECKS=1;
