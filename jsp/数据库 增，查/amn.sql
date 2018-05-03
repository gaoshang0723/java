/*
Navicat MySQL Data Transfer

Source Server         : 127.0.01
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : amn

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-05-03 21:44:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('张三', '21');
INSERT INTO `stu` VALUES ('李四', '29');
INSERT INTO `stu` VALUES ('amn', '11');
INSERT INTO `stu` VALUES ('lll', '999');
INSERT INTO `stu` VALUES ('a', '2');
INSERT INTO `stu` VALUES ('mx', '2');
INSERT INTO `stu` VALUES ('111', '11');
INSERT INTO `stu` VALUES ('kill', '1');
