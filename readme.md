#校园商铺平台项目实战

##实体类：
    1.区域  ID,权重，创建时间，修改时间，名称
    2.用户信息 ID,姓名，头像地址，邮箱，性别，状态，身份标识（顾客，店家，管理员），创建时间，修改时间
        2.1微信账号  ID,用户id,创建时间,openId(微信账号与公众号绑定标识)
        2.2本地账号  id,用户名, 密码 ,创建时间 ,用户id
    3.头条  id,权重,状态,名称,链接,图片,创建时间,修改时间
    4.店铺类别  id，权重，上级id，名称，描述，图片，创建时间，修改时间
    5.店铺  id，权重，门面照，店名，描述，联系方式，地址，区域id，类别id，用户id,状态，创建时间，修改时间，建议
    6.商品类别  id,名称，权重，所属店铺，创建时间
    7.商品  id,商品名，类别id，店铺id，描述，缩略图，原价，折扣价，状态，创建时间，修改时间，权重
        7.1详情图片  id,地址，说明，显示权重，创建时间，所属商品
        
##sql脚本
/*
Navicat MySQL Data Transfer

Date: 2019-09-22 19:16:46  
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;  
CREATE TABLE `tb_area` (  
  `area_id` int(2) NOT NULL AUTO_INCREMENT,  
  `area_name` varchar(200) NOT NULL,  
  `priority` int(2) DEFAULT '0',  
  `create_time` datetime DEFAULT NULL,  
  `update_time` datetime DEFAULT NULL,  
  PRIMARY KEY (`area_id`),  
  UNIQUE KEY `UK_AREA` (`area_name`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  

-- ----------------------------
-- Records of tb_area
-- ----------------------------

-- ----------------------------
-- Table structure for tb_head_line
-- ----------------------------
DROP TABLE IF EXISTS `tb_head_line`;  
CREATE TABLE `tb_head_line` (  
  `id` int(10) NOT NULL AUTO_INCREMENT,  
  `name` varchar(1000) DEFAULT NULL,  
  `url` varchar(2000) NOT NULL,  
  `img` varchar(2000) NOT NULL,  
  `priority` int(2) DEFAULT NULL,  
  `status` int(2) NOT NULL DEFAULT '0',  
  `create_time` datetime DEFAULT NULL,  
  `update_time` datetime DEFAULT NULL,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  

-- ----------------------------
-- Records of tb_head_line
-- ----------------------------

-- ----------------------------
-- Table structure for tb_local_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_local_auth`;  
CREATE TABLE `tb_local_auth` (  
  `id` int(10) NOT NULL AUTO_INCREMENT,  
  `user_id` int(10) NOT NULL,  
  `user_name` varchar(128) NOT NULL,  
  `password` varchar(128) NOT NULL,  
  `create_time` datetime DEFAULT NULL,  
  `update_time` datetime DEFAULT NULL,  
  PRIMARY KEY (`id`),  
  UNIQUE KEY `uk_localauth_profile` (`user_name`),  
  KEY `fk_localauth_profile` (`user_id`),  
  CONSTRAINT `fk_localauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_local_auth
-- ----------------------------

-- ----------------------------
-- Table structure for tb_person_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_person_info`;  
CREATE TABLE `tb_person_info` (  
  `user_id` int(10) NOT NULL AUTO_INCREMENT,   
  `name` varchar(32) DEFAULT NULL,  
  `img_url` varchar(1024) DEFAULT NULL,    
  `email` varchar(1024) DEFAULT NULL,  
  `gender` varchar(2) DEFAULT NULL,  
  `enable_status` int(2) NOT NULL DEFAULT '0' COMMENT '0:禁止,1:允许',  
  `user_type` int(2) NOT NULL DEFAULT '1' COMMENT '1.顾客 2.店家 3.管理员',  
  `create_time` datetime DEFAULT NULL,  
  `update_time` datetime DEFAULT NULL,  
  PRIMARY KEY (`user_id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_person_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;  
CREATE TABLE `tb_product` (  
  `id` int(100) NOT NULL AUTO_INCREMENT,  
  `name` varchar(100) NOT NULL,  
  `desc` varchar(2000) DEFAULT NULL,  
  `img_address` varchar(2000) DEFAULT '',  
  `origin_price` varchar(100) DEFAULT NULL,  
  `promotion_price` varchar(100) DEFAULT NULL,  
  `priority` int(2) NOT NULL DEFAULT '0',  
  `create_time` datetime DEFAULT NULL,  
  `update_time` datetime DEFAULT NULL,  
  `STATUS` int(2) NOT NULL DEFAULT '0',  
  `product_category_id` int(11) DEFAULT NULL,  
  `shop_id` int(20) NOT NULL DEFAULT '0',  
  PRIMARY KEY (`id`),  
  KEY `fk_product_procate` (`product_category_id`), 
  KEY `fk_product_shop` (`shop_id`),  
  CONSTRAINT `fk_product_procate` FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_category` (`id`),  
  CONSTRAINT `fk_product_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_category`;  
CREATE TABLE `tb_product_category` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `shop_id` int(20) NOT NULL DEFAULT '0',  
  `name` varchar(100) NOT NULL,  
  `priority` int(3) DEFAULT '0',  
  `create_time` datetime DEFAULT NULL,  
  PRIMARY KEY (`id`),  
  KEY `fk_procate_shop` (`shop_id`),  
  CONSTRAINT `fk_procate_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product_category
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_img`;  
CREATE TABLE `tb_product_img` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `address` varchar(2000) NOT NULL,  
  `desc` varchar(2000) DEFAULT NULL,  
  `priority` int(2) DEFAULT '0',  
  `create_time` datetime DEFAULT NULL,  
  `product_id` int(20) DEFAULT NULL,  
  PRIMARY KEY (`id`),  
  KEY `fk_proimg_product` (`product_id`),  
  CONSTRAINT `fk_proimg_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`id`)  

-- ----------------------------
-- Records of tb_product_img
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;  
CREATE TABLE `tb_shop` (  
  `id` int(10) NOT NULL AUTO_INCREMENT,  
  `owner_id` int(10) NOT NULL COMMENT '店铺创建人',  
  `area_id` int(5) DEFAULT NULL,  
  `shop_category_id` int(11) DEFAULT NULL,  
  `name` varchar(256) NOT NULL,  
  `desc` varchar(1024) DEFAULT NULL,  
  `address` varchar(200) DEFAULT NULL,  
  `img` varchar(128) DEFAULT NULL,  
  `priority` int(3) DEFAULT '0',  
  `create_time` datetime DEFAULT NULL,  
  `update_time` datetime DEFAULT NULL,  
  `status` int(2) NOT NULL DEFAULT '0',  
  `advice` varchar(255) DEFAULT NULL,  
  PRIMARY KEY (`id`),  
  KEY `fk_shop_area` (`area_id`),  
  KEY `fk_shop_profile` (`owner_id`),  
  KEY `fk_shop_shop_cate` (`shop_category_id`),  
  CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`),  
  CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`),  
  CONSTRAINT `fk_shop_shop_cate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shop_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_category`;  
CREATE TABLE `tb_shop_category` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `name` varchar(100) NOT NULL DEFAULT '',  
  `desc` varchar(1000) DEFAULT NULL,  
  `img` varchar(2000) DEFAULT NULL,  
  `priority` int(2) NOT NULL DEFAULT '0',  
  `create_time` datetime DEFAULT NULL,  
  `update_time` datetime DEFAULT NULL,  
  `parent_id` int(11) DEFAULT NULL,  
  PRIMARY KEY (`id`),  
  KEY `fk_shop_category_shelf` (`parent_id`),  
  CONSTRAINT `fk_shop_category_shelf` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shop_category
-- ----------------------------

-- ----------------------------
-- Table structure for tb_wechat_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_wechat_auth`;  
CREATE TABLE `tb_wechat_auth` (  
  `id` int(10) NOT NULL AUTO_INCREMENT,  
  `user_id` int(10) NOT NULL,  
  `open_id` varchar(100) NOT NULL,  
  `create_time` datetime DEFAULT NULL,  
  PRIMARY KEY (`id`),  
  UNIQUE KEY `open_id` (`open_id`),  
  KEY `fk_wechatauth_profile` (`user_id`),  
  CONSTRAINT `fk_wechatauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

-- ----------------------------
-- Records of tb_wechat_auth
-- ----------------------------

##项目结构
** web-inf  外部浏览器无法直接访问到  
** web.xml  初始化配置信息
** dto  弥补entity不足

##构建maven依赖

##配置文件
###jdbc
###mybatis
###spring
####spring-dao.xml
####spring-service.xml
####spring-web.xml

##基本架构搭建

##logback配置
    logback-access  
    logback-classic
    logback-core
    
    标签
    logger  存放日志对象，定义日志类型，级别
    appender  输出日志媒介
    layout
    
    加载顺序
    
##店铺模块  
###店铺注册
###更新店铺信息

