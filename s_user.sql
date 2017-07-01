/*
Navicat MySQL Data Transfer

Source Server         : mc
Source Server Version : 50554
Source Host           : 123.206.214.132:3306
Source Database       : pe

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-07-01 08:51:03
*/

SET FOREIGN_KEY_CHECKS=0;

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
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('220150925821', 'cd2deeb588788b340083c064ab667755', '学生', '学生', '2017-06-20 17:15:15');
INSERT INTO `s_user` VALUES ('academy', 'cd2deeb588788b340083c064ab667755', '学院', '学院', '2017-06-18 17:15:15');
INSERT INTO `s_user` VALUES ('liuxq', 'cd2deeb588788b340083c064ab667755', '刘晓庆', '管理员', '2017-06-20 17:15:15');
INSERT INTO `s_user` VALUES ('mc', 'cd2deeb588788b340083c064ab667755', '马超', '管理员', '2017-06-18 17:15:15');
INSERT INTO `s_user` VALUES ('teacher', 'cd2deeb588788b340083c064ab667755', '老师', '教师', '2017-06-18 17:15:15');
INSERT INTO `s_user` VALUES ('xxxy', 'cd2deeb588788b340083c064ab667755', '信息科学与工程学院', '学院', '2017-06-18 17:15:15');
SET FOREIGN_KEY_CHECKS=1;
