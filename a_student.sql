/*
Navicat MySQL Data Transfer

Source Server         : mc
Source Server Version : 50554
Source Host           : 123.206.214.132:3306
Source Database       : pe

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-07-01 08:49:59
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `a_student` VALUES ('220150925821', '刘晓庆', '男', '信息科学与工程学院', '2015', '', '4', '正常', '学院');
INSERT INTO `a_student` VALUES ('220150925822', '冯广博', '男', '信息科学与工程学院', '2013', '2', '4', '请假', '胡老师');
INSERT INTO `a_student` VALUES ('220150925823', '马超', '男', '文学院', '2016', '2', '4', '正常', '何老师');
SET FOREIGN_KEY_CHECKS=1;
