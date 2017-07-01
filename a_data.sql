/*
Navicat MySQL Data Transfer

Source Server         : mc
Source Server Version : 50554
Source Host           : 123.206.214.132:3306
Source Database       : pe

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-07-01 08:49:49
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
INSERT INTO `a_data` VALUES ('220150925821', '2015', '183', '78.5', '4020', '8.5', '200.5', '-15.0', '', '8\'12\'\'', null, '20', '85', '未审核', '审核通过');
INSERT INTO `a_data` VALUES ('220150925821', '2016', '185', '84.0', '5450', '8.3', '200.5', '-10.0', '10\'22\'\'', '', '20', null, '69', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925821', '2017', null, null, null, null, null, null, null, null, null, null, null, '', '');
INSERT INTO `a_data` VALUES ('220150925822', '2016', '175', '67.0', '4562', '9.3', '150.3', '-20.0', null, '8\'22\'\'', null, '30', '88', '被退回', '未审核');
INSERT INTO `a_data` VALUES ('220150925822', '2017', '183', '70.0', '5000', '6.7', '200.0', '10.0', '', '3\'23', '0', '10', '101', '被退回', '未审核');
INSERT INTO `a_data` VALUES ('220150925823', '2015', '173', '56.0', '13554', '12.5', '152.2', '-38.0', '8\'44\'\'', '', '23', null, '55', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925823', '2016', '173', '65.0', '5842', '8.9', '150.3', '-16.0', '8\'22\'\'', '', '30', null, '70', '未审核', '未审核');
INSERT INTO `a_data` VALUES ('220150925823', '2017', '173', '65.0', '5000', '6.7', '200.0', '10.0', '', '3\'22', '0', '10', '105', '未审核', '未审核');
SET FOREIGN_KEY_CHECKS=1;
