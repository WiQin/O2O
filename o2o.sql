/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : o2o

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-01-30 17:42:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(2) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) NOT NULL,
  `area_desc` varchar(1000) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES ('3', '东苑', '东苑', '12', '2017-06-04 19:12:58', '2017-06-04 19:12:58');
INSERT INTO `tb_area` VALUES ('4', '南苑', '南苑', '10', '2017-06-04 19:13:09', '2017-06-04 19:13:09');
INSERT INTO `tb_area` VALUES ('5', '西苑', '西苑', '9', '2017-06-04 19:13:18', '2017-06-04 19:13:18');
INSERT INTO `tb_area` VALUES ('6', '北苑', '北苑', '7', '2017-06-04 19:13:29', '2017-06-04 19:13:29');

-- ----------------------------
-- Table structure for tb_head_line
-- ----------------------------
DROP TABLE IF EXISTS `tb_head_line`;
CREATE TABLE `tb_head_line` (
  `line_id` int(100) NOT NULL AUTO_INCREMENT,
  `line_name` varchar(1000) DEFAULT NULL,
  `line_link` varchar(2000) NOT NULL,
  `line_img` varchar(2000) NOT NULL,
  `priority` int(2) DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_head_line
-- ----------------------------

-- ----------------------------
-- Table structure for tb_local_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_local_auth`;
CREATE TABLE `tb_local_auth` (
  `local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `user_name` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`local_auth_id`),
  UNIQUE KEY `uk_local_profile` (`user_name`),
  KEY `fk_localauth_profile` (`user_id`),
  CONSTRAINT `fk_localauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_local_auth
-- ----------------------------

-- ----------------------------
-- Table structure for tb_person_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_person_info`;
CREATE TABLE `tb_person_info` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `profile_img` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0' COMMENT '0:禁止使用 1:允许使用',
  `user_type` int(2) NOT NULL DEFAULT '1' COMMENT '1:顾客 2:店家 3:超级管理员',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_person_info
-- ----------------------------
INSERT INTO `tb_person_info` VALUES ('1', null, null, null, null, null, null, '0', '1');

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_desc` varchar(2000) DEFAULT NULL,
  `img_addr` varchar(2000) DEFAULT '',
  `normal_price` varchar(100) DEFAULT NULL,
  `promotion_price` varchar(100) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `product_category_id` int(11) DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`),
  KEY `fk_product_shop` (`shop_id`),
  KEY `fk_product_procate` (`product_category_id`),
  CONSTRAINT `fk_product_procate` FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_category` (`product_category_id`),
  CONSTRAINT `fk_product_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_category`;
CREATE TABLE `tb_product_category` (
  `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category_name` varchar(100) NOT NULL,
  `priority` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_category_id`),
  KEY `fk_procate_shop` (`shop_id`),
  CONSTRAINT `fk_procate_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product_category
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_img`;
CREATE TABLE `tb_product_img` (
  `product_img_id` int(20) NOT NULL AUTO_INCREMENT,
  `img_addr` varchar(2000) NOT NULL,
  `img_desc` varchar(2000) DEFAULT NULL,
  `priority` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `product_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`product_img_id`),
  KEY `fk_proimg_product` (`product_id`),
  CONSTRAINT `fk_proimg_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product_img
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop` (
  `shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `owner_id` int(10) DEFAULT NULL COMMENT '店铺创建人',
  `area_id` int(5) DEFAULT NULL,
  `shop_category_id` int(11) DEFAULT NULL,
  `shop_name` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `shop_desc` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_addr` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_img` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `priority` int(3) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `advice` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `fk_shop_profile` (`owner_id`),
  KEY `fk_shop_area` (`area_id`),
  KEY `fk_shop_shopcate` (`shop_category_id`),
  CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`),
  CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`),
  CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------
INSERT INTO `tb_shop` VALUES ('23', '1', '3', '14', '测试店铺', '测试信息', 'XXX-XXX-XXX', '13812345678', 'upload\\item\\shopadmin\\23\\2020013012524545484.jpg', '0', '2020-01-30 12:52:45', '2020-01-30 12:52:45', '0', null);
INSERT INTO `tb_shop` VALUES ('24', '1', '3', '14', '测试店铺', '测试信息', 'XXX-XXX-XXX', '13812345678', 'upload\\item\\shopadmin\\24\\202001301253103859.jpg', '0', '2020-01-30 12:53:10', '2020-01-30 12:53:10', '0', null);
INSERT INTO `tb_shop` VALUES ('25', '1', '3', '14', '测试店铺', '测试信息', 'XXX-XXX-XXX', '13812345678', 'upload\\item\\shopadmin\\25\\2020013012551379943.jpg', '0', '2020-01-30 12:55:13', '2020-01-30 12:55:13', '0', null);

-- ----------------------------
-- Table structure for tb_shop_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_category`;
CREATE TABLE `tb_shop_category` (
  `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_category_name` varchar(100) NOT NULL DEFAULT '',
  `shop_category_desc` varchar(1000) DEFAULT '',
  `shop_category_img` varchar(2000) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`shop_category_id`),
  KEY `fk_shop_category_self` (`parent_id`),
  CONSTRAINT `fk_shop_category_self` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shop_category
-- ----------------------------
INSERT INTO `tb_shop_category` VALUES ('10', '二手市场', '二手商品交易', '/upload/images/item/shopcategory/2017061223272255687.png', '100', '2017-06-04 20:10:58', '2017-06-12 23:27:22', null);
INSERT INTO `tb_shop_category` VALUES ('11', '美容美发', '美容美发', '/upload/images/item/shopcategory/2017061223273314635.png', '99', '2017-06-04 20:12:57', '2017-06-12 23:27:33', null);
INSERT INTO `tb_shop_category` VALUES ('12', '美食饮品', '美食饮品', '/upload/images/item/shopcategory/2017061223274213433.png', '98', '2017-06-04 20:15:21', '2017-06-12 23:27:42', null);
INSERT INTO `tb_shop_category` VALUES ('13', '休闲娱乐', '休闲娱乐', '/upload/images/item/shopcategory/2017061223275121460.png', '97', '2017-06-04 20:19:29', '2017-06-12 23:27:51', null);
INSERT INTO `tb_shop_category` VALUES ('14', '旧车', '旧车', '/upload/images/item/shopcategory/2017060420315183203.png', '80', '2017-06-04 20:31:51', '2017-06-04 20:31:51', '10');
INSERT INTO `tb_shop_category` VALUES ('15', '二手书籍', '二手书籍', '/upload/images/item/shopcategory/2017060420322333745.png', '79', '2017-06-04 20:32:23', '2017-06-04 20:32:23', '10');
INSERT INTO `tb_shop_category` VALUES ('17', '护理', '护理', '/upload/images/item/shopcategory/2017060420372391702.png', '76', '2017-06-04 20:37:23', '2017-06-04 20:37:23', '11');
INSERT INTO `tb_shop_category` VALUES ('18', '理发', '理发', '/upload/images/item/shopcategory/2017060420374775350.png', '74', '2017-06-04 20:37:47', '2017-06-04 20:37:47', '11');
INSERT INTO `tb_shop_category` VALUES ('20', '大排档', '大排档', '/upload/images/item/shopcategory/2017060420460491494.png', '59', '2017-06-04 20:46:04', '2017-06-04 20:46:04', '12');
INSERT INTO `tb_shop_category` VALUES ('22', '奶茶店', '奶茶店', '/upload/images/item/shopcategory/2017060420464594520.png', '58', '2017-06-04 20:46:45', '2017-06-04 20:46:45', '12');
INSERT INTO `tb_shop_category` VALUES ('24', '密室逃生', '密室逃生', '/upload/images/item/shopcategory/2017060420500783376.png', '56', '2017-06-04 20:50:07', '2017-06-04 21:45:53', '13');
INSERT INTO `tb_shop_category` VALUES ('25', 'KTV', 'KTV', '/upload/images/item/shopcategory/2017060420505834244.png', '57', '2017-06-04 20:50:58', '2017-06-04 20:51:14', '13');
INSERT INTO `tb_shop_category` VALUES ('27', '培训教育', '培训教育', '/upload/images/item/shopcategory/2017061223280082147.png', '96', '2017-06-04 21:51:36', '2017-06-12 23:28:00', null);
INSERT INTO `tb_shop_category` VALUES ('28', '租赁市场', '租赁市场', '/upload/images/item/shopcategory/2017061223281361578.png', '95', '2017-06-04 21:53:52', '2017-06-12 23:28:13', null);
INSERT INTO `tb_shop_category` VALUES ('29', '程序设计', '程序设计', '/upload/images/item/shopcategory/2017060421593496807.png', '50', '2017-06-04 21:59:34', '2017-06-04 21:59:34', '27');
INSERT INTO `tb_shop_category` VALUES ('30', '声乐舞蹈', '声乐舞蹈', '/upload/images/item/shopcategory/2017060421595843693.png', '49', '2017-06-04 21:59:58', '2017-06-04 21:59:58', '27');
INSERT INTO `tb_shop_category` VALUES ('31', '演出道具', '演出道具', '/upload/images/item/shopcategory/2017060422114076152.png', '45', '2017-06-04 22:11:40', '2017-06-04 22:11:40', '28');
INSERT INTO `tb_shop_category` VALUES ('32', '交通工具', '交通工具', '/upload/images/item/shopcategory/2017060422121144586.png', '44', '2017-06-04 22:12:11', '2017-06-04 22:12:11', '28');

-- ----------------------------
-- Table structure for tb_wechat_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_wechat_auth`;
CREATE TABLE `tb_wechat_auth` (
  `wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `open_id` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`wechat_auth_id`),
  UNIQUE KEY `uk_oauth` (`open_id`) USING BTREE,
  KEY `fk_oauth_profile` (`user_id`),
  CONSTRAINT `fk_oauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_wechat_auth
-- ----------------------------
