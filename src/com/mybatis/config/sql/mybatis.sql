/*
Navicat MySQL Data Transfer

Source Server         : yunfei
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-02-15 13:18:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for command
-- ----------------------------
DROP TABLE IF EXISTS `command`;
CREATE TABLE `command` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `command` varchar(16) DEFAULT NULL,
  `description` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of command
-- ----------------------------
INSERT INTO `command` VALUES ('1', '1', '11111');
INSERT INTO `command` VALUES ('2', '2', '22222');

-- ----------------------------
-- Table structure for command_content
-- ----------------------------
DROP TABLE IF EXISTS `command_content`;
CREATE TABLE `command_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `commandId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COMMAND` (`commandId`),
  CONSTRAINT `FK_COMMAND` FOREIGN KEY (`commandId`) REFERENCES `command` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of command_content
-- ----------------------------
INSERT INTO `command_content` VALUES ('1', '23232343243', '1');
INSERT INTO `command_content` VALUES ('2', '456574565352', '2');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `command` varchar(16) DEFAULT NULL,
  `description` varchar(32) DEFAULT NULL,
  `content` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '查看', '输入查看', null);
