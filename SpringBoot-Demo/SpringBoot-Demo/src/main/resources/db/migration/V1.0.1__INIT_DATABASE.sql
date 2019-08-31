/*
Navicat MySQL Data Transfer

Source Server         : dev
Source Server Version : 50711
Source Host           : 99.6.185.11:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-03-13 09:54:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mbcc_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `mbcc_sys_user`;
CREATE TABLE `mbcc_sys_user` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `login_name` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT 'MD5加盐后密文',
  `role_id` int(64) NOT NULL COMMENT '角色id',
  `no` varchar(20) DEFAULT NULL COMMENT '工号',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `photo` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
  `create_by` int(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `mbcc_sys_user_login_name` (`login_name`),
  KEY `mbcc_sys_user_update_date` (`update_date`),
  KEY `mbcc_sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of mbcc_sys_user
-- ----------------------------
INSERT INTO `mbcc_sys_user` VALUES ('0', 'licf', '687e47f8642984a98624ae20e4e090e79916d32e26a45a44', '0', null, '李灿峰', null, null, null, null, null, null, '1', '1', '2019-03-11 19:45:31', '1', '2019-03-11 19:45:37', null, '0');
INSERT INTO `mbcc_sys_user` VALUES ('1', 'gujj', '687e47f8642984a98624ae20e4e090e79916d32e26a45a44', '0', null, '顾杰杰', null, null, null, null, null, null, '1', '1', '2019-03-12 11:39:50', '0', '2019-03-12 15:48:45', null, '1');
INSERT INTO `mbcc_sys_user` VALUES ('2', 'test', '687e47f8642984a98624ae20e4e090e79916d32e26a45a44', '0', null, '普通账户', null, null, null, null, null, null, '1', '1', '2019-03-11 19:45:31', '1', '2019-03-11 19:45:37', null, '0');
INSERT INTO `mbcc_sys_user` VALUES ('3', 'manager', '687e47f8642984a98624ae20e4e090e79916d32e26a45a44', '0', null, '主管账户', null, null, null, null, null, null, '1', '1', '2019-03-11 19:45:31', '1', '2019-03-11 19:45:37', null, '0');


/*
Navicat MySQL Data Transfer

Source Server         : dev
Source Server Version : 50711
Source Host           : 99.6.185.11:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-03-13 09:54:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mbcc_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `mbcc_sys_role`;
CREATE TABLE `mbcc_sys_role` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `enname` varchar(20) DEFAULT NULL COMMENT '英文名称',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围',
  `role_type` int(2) DEFAULT NULL COMMENT '角色类型',
  `is_sys` char(1) DEFAULT '0' COMMENT '是否系统数据',
  `useable` int(1) DEFAULT '1' COMMENT '是否可用',
  `create_by` int(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记 0:已删除 1：未删除',
  PRIMARY KEY (`id`),
  KEY `mbcc_sys_role_del_flag` (`del_flag`),
  KEY `mbcc_sys_role_enname` (`enname`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of mbcc_sys_role
-- ----------------------------
INSERT INTO `mbcc_sys_role` VALUES ('0', 'admin', 'admin', null, '0', '1', '1', '0', '2019-03-12 10:59:21', '0', '2019-03-12 10:59:32', '系统角色', '0');
INSERT INTO `mbcc_sys_role` VALUES ('1', 'manager', 'manager', null, '0', '1', '1', '0', '2019-03-12 11:40:44', '0', '2019-03-12 11:40:52', '主管角色', '0');
INSERT INTO `mbcc_sys_role` VALUES ('2', 'staff', 'staff', null, '0', '0', '1', '0', '2019-03-12 11:41:36', '0', '2019-03-12 11:41:44', '普通角色', '0');


/*
Navicat MySQL Data Transfer

Source Server         : dev
Source Server Version : 50711
Source Host           : 99.6.185.11:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-03-13 09:54:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mbcc_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `mbcc_sys_user_role`;
CREATE TABLE `mbcc_sys_user_role` (
  `user_id` int(64) NOT NULL COMMENT '用户编号',
  `role_id` int(64) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of mbcc_sys_user_role
-- ----------------------------
INSERT INTO `mbcc_sys_user_role` VALUES ('0', '0');
INSERT INTO `mbcc_sys_user_role` VALUES ('1', '0');
INSERT INTO `mbcc_sys_user_role` VALUES ('2', '2');
INSERT INTO `mbcc_sys_user_role` VALUES ('3', '1');



/*
Navicat MySQL Data Transfer

Source Server         : dev
Source Server Version : 50711
Source Host           : 99.6.185.11:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-03-13 09:54:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mbcc_black_user
-- ----------------------------
DROP TABLE IF EXISTS `mbcc_black_user`;
CREATE TABLE `mbcc_black_user` (
  `id` varchar(255) NOT NULL COMMENT '用户ID',
  `number` int(11) DEFAULT NULL,
  `is_black_party` tinyint(4) DEFAULT NULL COMMENT '0：不是 1：是',
  `delete_flag` tinyint(4) NOT NULL COMMENT '0：未删除 1：已删除',
  `gmt_create` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mbcc_black_user
-- ----------------------------


/*
Navicat MySQL Data Transfer

Source Server         : dev
Source Server Version : 50711
Source Host           : 99.6.185.11:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-03-13 09:54:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mbcc_black_ip
-- ----------------------------
DROP TABLE IF EXISTS `mbcc_black_ip`;
CREATE TABLE `mbcc_black_ip` (
  `id` varchar(255) NOT NULL COMMENT '用户ID',
  `number` int(11) DEFAULT NULL,
  `is_black_party` tinyint(4) DEFAULT NULL COMMENT '0：不是 1：是',
  `delete_flag` tinyint(4) NOT NULL COMMENT '0：未删除 1：已删除',
  `gmt_create` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mbcc_black_ip
-- ----------------------------


/*
Navicat MySQL Data Transfer

Source Server         : dev
Source Server Version : 50711
Source Host           : 99.6.185.11:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-03-13 09:54:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mbcc_black_device
-- ----------------------------
DROP TABLE IF EXISTS `mbcc_black_device`;
CREATE TABLE `mbcc_black_device` (
  `id` varchar(255) NOT NULL COMMENT '用户ID',
  `number` int(11) DEFAULT NULL,
  `is_black_party` tinyint(4) DEFAULT NULL COMMENT '0：不是 1：是',
  `delete_flag` tinyint(4) NOT NULL COMMENT '0：未删除 1：已删除',
  `gmt_create` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mbcc_black_device
-- ----------------------------


