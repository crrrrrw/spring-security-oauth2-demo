/*
Navicat MySQL Data Transfer

Source Server         : dev3306
Source Server Version : 50157
Source Host           : 10.0.0.20:3306
Source Database       : wealth

Target Server Type    : MYSQL
Target Server Version : 50157
File Encoding         : 65001

Date: 2018-11-21 17:08:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sec_user
-- ----------------------------
DROP TABLE IF EXISTS `sec_user`;
CREATE TABLE `sec_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `roles` varchar(64) NOT NULL DEFAULT '' COMMENT '身份',
  `create_at` bigint(20) NOT NULL,
  `update_at` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sec_user
-- ----------------------------
INSERT INTO `sec_user` VALUES ('1', 'admin', '123456', 'admin', 'ROLE_USER', '1542782031000', '1542782031000');
