/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : zsh

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-06-21 15:22:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `devotion_inf`
-- ----------------------------
DROP TABLE IF EXISTS `devotion_inf`;
CREATE TABLE `devotion_inf` (
  `devotion_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_title` varchar(50) NOT NULL,
  `resource_content` longtext NOT NULL,
  `resource_describe` varchar(100) DEFAULT NULL,
  `resource_label` varchar(20) DEFAULT NULL,
  `resource_filePath` longtext,
  `resource_id` int(11) NOT NULL,
  `devotion_createdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `status` int(20) NOT NULL DEFAULT '1',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`devotion_id`),
  KEY `user_id` (`user_id`),
  KEY `resource_id` (`resource_id`),
  CONSTRAINT `devotion_inf_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_inf` (`user_id`),
  CONSTRAINT `devotion_inf_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `resource_inf` (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of devotion_inf
-- ----------------------------
INSERT INTO `devotion_inf` VALUES ('1', '菜单VV', 'fdssadgg', 'dweqr', 'dsfd', null, '1', '2020-06-21 12:47:15', '1', '1');
INSERT INTO `devotion_inf` VALUES ('2', '菜单深V', 'Dev', null, '撒', null, '1', '2020-06-21 10:10:46', '1', '2');
INSERT INTO `devotion_inf` VALUES ('3', '闺女', '宝贝', '信息', '这些', null, '3', '2020-06-21 12:47:19', '1', '3');
INSERT INTO `devotion_inf` VALUES ('4', '刚刚', '版本', '那你', '那你', null, '4', '2020-06-21 10:08:55', '1', '3');

-- ----------------------------
-- Table structure for `post_content_inf`
-- ----------------------------
DROP TABLE IF EXISTS `post_content_inf`;
CREATE TABLE `post_content_inf` (
  `content_id` int(11) NOT NULL AUTO_INCREMENT,
  `content_recordnum` int(11) NOT NULL,
  `content_reply` longtext NOT NULL,
  `content_likenum` longtext,
  `content_dislikenum` longtext,
  `content_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `reply_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  KEY `post_id` (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `post_content_inf_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post_inf` (`post_id`),
  CONSTRAINT `post_content_inf_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_inf` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_content_inf
-- ----------------------------
INSERT INTO `post_content_inf` VALUES ('6', '2', '<p>aa</p>\r\n', '1,', '1,', '2020-06-21 11:23:19', '1', '5', null);
INSERT INTO `post_content_inf` VALUES ('7', '2', '<p>bb</p>', null, null, '2020-06-21 11:23:32', '1', '5', '1');

-- ----------------------------
-- Table structure for `post_inf`
-- ----------------------------
DROP TABLE IF EXISTS `post_inf`;
CREATE TABLE `post_inf` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(20) NOT NULL,
  `post_content` longtext NOT NULL,
  `post_label` varchar(100) DEFAULT NULL,
  `post_reminder` varchar(100) DEFAULT NULL,
  `post_ifrefined` int(11) NOT NULL DEFAULT '1',
  `post_collection` longtext,
  `post_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `space_id` int(11) NOT NULL,
  `post_likenum` longtext,
  `post_dislikenum` longtext,
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  KEY `space_id` (`space_id`),
  CONSTRAINT `post_inf_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_inf` (`user_id`),
  CONSTRAINT `post_inf_ibfk_2` FOREIGN KEY (`space_id`) REFERENCES `space_inf` (`space_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_inf
-- ----------------------------
INSERT INTO `post_inf` VALUES ('4', 'b', '<p>b</p>\r\n', '技术博客,', null, '1', null, '2020-06-21 11:06:15', '1', '1', null, null);
INSERT INTO `post_inf` VALUES ('5', 'a', '<p>a</p>\r\n', '疑惑,', null, '2', '1,', '2020-06-21 11:22:40', '1', '1', '1,', '1,');
INSERT INTO `post_inf` VALUES ('6', 'c', '<p>c</p>\r\n', '技术博客,', null, '2', '1,', '2020-06-21 14:35:36', '1', '1', '1,', '1,');

-- ----------------------------
-- Table structure for `resource_content_inf`
-- ----------------------------
DROP TABLE IF EXISTS `resource_content_inf`;
CREATE TABLE `resource_content_inf` (
  `resource_content_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_recordnum` int(11) NOT NULL DEFAULT '2',
  `resource_reply` longtext NOT NULL,
  `resource_updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `resource_likenum` int(11) DEFAULT NULL,
  `resource_dislikenum` int(11) DEFAULT NULL,
  `resource_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT '1',
  `reply_user_id` int(11) DEFAULT '1',
  `reply_resource_id` int(11) DEFAULT NULL,
  `reply_content_id` int(11) DEFAULT '0',
  PRIMARY KEY (`resource_content_id`),
  KEY `user_id` (`user_id`),
  KEY `resource_id` (`resource_id`),
  CONSTRAINT `resource_content_inf_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_inf` (`user_id`),
  CONSTRAINT `resource_content_inf_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `resource_inf` (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_content_inf
-- ----------------------------
INSERT INTO `resource_content_inf` VALUES ('1', '2', '写的真好写的真好写的真好写的真好写的真好写的真好写的真好写的真好写的真好写的真好写的真好写的真好', '2020-06-17 00:10:13', '5', '11', '1', '1', '1', '0', '0');
INSERT INTO `resource_content_inf` VALUES ('2', '2', '你说得对', '2020-06-17 00:42:56', '11', '22', '1', '1', '1', '1', '1');
INSERT INTO `resource_content_inf` VALUES ('3', '2', '我觉得他说的也对', '2020-06-17 10:43:43', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `resource_content_inf` VALUES ('4', '2', '写的不好写的不好', '2020-06-17 10:44:19', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `resource_content_inf` VALUES ('5', '2', '你在无中生有', '2020-06-17 10:44:44', '1', '1', '1', '1', '1', '1', '4');
INSERT INTO `resource_content_inf` VALUES ('6', '2', '暗度陈仓', '2020-06-17 10:45:16', '1', '1', '1', '1', '1', '1', '4');
INSERT INTO `resource_content_inf` VALUES ('7', '2', '12123', '2020-06-20 02:31:36', null, null, '1', '1', '1', null, '0');
INSERT INTO `resource_content_inf` VALUES ('8', '2', '328740', '2020-06-21 12:50:04', null, null, '21', '1', '1', null, '0');

-- ----------------------------
-- Table structure for `resource_inf`
-- ----------------------------
DROP TABLE IF EXISTS `resource_inf`;
CREATE TABLE `resource_inf` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_title` varchar(50) NOT NULL DEFAULT '',
  `resource_content` longtext NOT NULL,
  `resource_describe` varchar(100) DEFAULT '',
  `resource_label` varchar(500) DEFAULT '',
  `resource_file_path` longtext,
  `space_id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `resource_create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `resource_collection_ids` varchar(200) DEFAULT NULL COMMENT '资源收藏人ids',
  `resource_like_ids` varchar(255) DEFAULT NULL COMMENT '资源点赞人id',
  `resource_if_refined` int(11) DEFAULT NULL,
  `resource_if_main` int(11) DEFAULT NULL,
  `resource_like_num` int(11) DEFAULT NULL,
  `resource_dislike_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`resource_id`),
  KEY `user_id` (`user_id`),
  KEY `space_id` (`space_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_inf
-- ----------------------------
INSERT INTO `resource_inf` VALUES ('1', '我是文章标题_1', '我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容我是文章内容_1', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '0', '1', '1', '1');
INSERT INTO `resource_inf` VALUES ('2', '我也是文章标题_2', '我也是文章标题我也是文章标题我也是文章标题我也是文章标题_2', '我是文章描述', '我是标签', '我是图片url', '1', '1', '2020-06-17 00:00:00', '1', '1', '0', '1', '1', '1');
INSERT INTO `resource_inf` VALUES ('3', '我是文章标题11_3', '我是文章内容_3', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '0', '1', '1', '1');
INSERT INTO `resource_inf` VALUES ('4', '我是文章标题22_4', '我是文章内容_4', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '0', '1', '1', '1');
INSERT INTO `resource_inf` VALUES ('5', '我是文章标题_5', '我是文章内容_5', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '0', '1', '1', '1');
INSERT INTO `resource_inf` VALUES ('6', '我是文章标题_6', '我是文章内容_6', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '1', '1', '1', '1');
INSERT INTO `resource_inf` VALUES ('7', '我是文章标题_7', '我是文章内容_7', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '1', '0', '1', '1');
INSERT INTO `resource_inf` VALUES ('8', '我是文章标题_8', '我是文章内容_8', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '1', '0', '1', '1');
INSERT INTO `resource_inf` VALUES ('9', '我是文章标题_9', '我是文章内容_9', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '1', '0', '1', '1');
INSERT INTO `resource_inf` VALUES ('10', '我是文章标题_10', '我是文章内容_10', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '1', '0', '1', '1');
INSERT INTO `resource_inf` VALUES ('11', '我是文章标题_11', '我是文章内容_11', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '1', '0', '1', '1');
INSERT INTO `resource_inf` VALUES ('12', '我是文章标题_12', '我是文章内容_12', 'resourceresourceresource', '111', '111', '1', '1', '2020-06-16 00:00:00', '1', '1', '1', '0', '1', '1');
INSERT INTO `resource_inf` VALUES ('17', '123', '<p>111111</p>', '<p>111111</p>', '', null, '1', '1', '2020-06-16 00:00:00', null, null, null, '1', null, null);
INSERT INTO `resource_inf` VALUES ('18', 'æ é¢insert', '<p>alskdjflkasjdflasjdfl;asjdasf</p>', '<p>alskdjflkasjdflasjdfl;asjdasf</p>', 'ææ¯åå®¢,çæ,ç»éª', null, '1', '1', '2020-06-20 01:41:21', null, null, null, '1', null, null);
INSERT INTO `resource_inf` VALUES ('19', 'æ é¢insert', '<p>alskdjflkasjdflasjdfl;asjdasf</p>', '<p>alskdjflkasjdflasjdfl;asjdasf</p>', 'ææ¯åå®¢,çæ,ç»éª', null, '1', '1', '2020-06-20 01:42:14', null, null, null, '1', null, null);
INSERT INTO `resource_inf` VALUES ('20', '123123123', '<p>123123123</p>', '<p>123123123</p>', 'ææ¯åå®¢', null, '1', '1', '2020-06-20 01:47:04', null, null, null, '1', null, null);
INSERT INTO `resource_inf` VALUES ('21', '123123123', '<p>123123123</p>', '<p>123123123</p>', 'ææ¯åå®¢', null, '1', '1', '2020-06-20 01:54:26', null, null, null, '1', null, null);

-- ----------------------------
-- Table structure for `space_collect_info`
-- ----------------------------
DROP TABLE IF EXISTS `space_collect_info`;
CREATE TABLE `space_collect_info` (
  `space_collect_id` int(11) NOT NULL AUTO_INCREMENT,
  `space_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`space_collect_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of space_collect_info
-- ----------------------------
INSERT INTO `space_collect_info` VALUES ('3', '5', '1');
INSERT INTO `space_collect_info` VALUES ('4', '5', '2');
INSERT INTO `space_collect_info` VALUES ('6', '6', '1');
INSERT INTO `space_collect_info` VALUES ('7', '6', '2');
INSERT INTO `space_collect_info` VALUES ('8', '1', '2');

-- ----------------------------
-- Table structure for `space_inf`
-- ----------------------------
DROP TABLE IF EXISTS `space_inf`;
CREATE TABLE `space_inf` (
  `space_id` int(11) NOT NULL AUTO_INCREMENT,
  `space_name` varchar(30) NOT NULL,
  `space_describe` varchar(100) DEFAULT NULL,
  `space_top` int(11) DEFAULT '0' COMMENT '1代表置顶标签，2代表普通标签',
  `space_status` int(11) DEFAULT '2' COMMENT '1表示公开，0表示私有',
  `space_createtime` datetime DEFAULT NULL,
  `space_updatetime` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `space_picture` varchar(100) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`space_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `space_inf_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_inf` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of space_inf
-- ----------------------------
INSERT INTO `space_inf` VALUES ('1', 'cold', '冷啊！！！', '0', '0', '2020-06-14 17:43:41', '2020-06-14 23:58:04', 'GXT_pink.jpg', '1');
INSERT INTO `space_inf` VALUES ('2', 'Learn', '学习', '1', '1', '2020-06-14 18:43:34', '2020-06-14 23:58:05', 'GXT_football.jpg', '1');
INSERT INTO `space_inf` VALUES ('3', 'hot', '热', '0', '0', '2020-06-14 18:45:24', '2020-06-14 23:58:08', 'GXT_red.jpg', '1');
INSERT INTO `space_inf` VALUES ('4', 'snow', '雪', '0', '0', '2020-06-14 18:50:44', '2020-06-14 23:58:09', 'GXT_white.jpg', '2');
INSERT INTO `space_inf` VALUES ('5', 'sweet', '甜蜜', '1', '1', '2020-06-14 18:52:26', '2020-06-14 23:58:11', 'GXT_sweet.jpg', '2');
INSERT INTO `space_inf` VALUES ('6', 'good', '好棒', '0', '1', '2020-06-15 01:35:48', '2020-06-15 01:35:52', 'GXT_pink.jpg', '2');
INSERT INTO `space_inf` VALUES ('7', 'ok', '00', '0', '0', '2020-06-15 21:43:20', '2020-06-15 21:47:38', 'GXT_pink.jpg', '1');
INSERT INTO `space_inf` VALUES ('8', '好好学习，天天向上', '我只想成为我自己不想成为谁', '0', '0', '2020-06-15 21:48:39', '2020-06-16 02:56:35', 'GXT_pink.jpg', '1');

-- ----------------------------
-- Table structure for `space_laud`
-- ----------------------------
DROP TABLE IF EXISTS `space_laud`;
CREATE TABLE `space_laud` (
  `space_laud_id` int(11) NOT NULL AUTO_INCREMENT,
  `space_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`space_laud_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of space_laud
-- ----------------------------
INSERT INTO `space_laud` VALUES ('1', '1', '1');
INSERT INTO `space_laud` VALUES ('2', '1', '2');
INSERT INTO `space_laud` VALUES ('3', '4', '1');
INSERT INTO `space_laud` VALUES ('4', '5', '1');
INSERT INTO `space_laud` VALUES ('5', '6', '2');
INSERT INTO `space_laud` VALUES ('6', '4', '2');

-- ----------------------------
-- Table structure for `space_member`
-- ----------------------------
DROP TABLE IF EXISTS `space_member`;
CREATE TABLE `space_member` (
  `space_member_id` int(11) NOT NULL AUTO_INCREMENT,
  `space_member_status` int(11) DEFAULT NULL COMMENT '0表示普通用户，1代表管理者，2代表创建者',
  `space_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `space_member_createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`space_member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of space_member
-- ----------------------------
INSERT INTO `space_member` VALUES ('1', '1', '1', '1', '2020-06-16 05:50:06');
INSERT INTO `space_member` VALUES ('2', '2', '1', '2', '2020-06-16 05:50:09');
INSERT INTO `space_member` VALUES ('3', '0', '1', '0', '2020-06-16 05:50:11');

-- ----------------------------
-- Table structure for `user_inf`
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_phone` varchar(20) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  `user_email` varchar(20) DEFAULT NULL,
  `user_job` int(11) NOT NULL DEFAULT '1' COMMENT '假设1代表学生，2代表老师，3代表其他',
  `user_dept` varchar(20) DEFAULT NULL,
  `user_homepage` varchar(100) DEFAULT NULL,
  `user_myself` varchar(100) DEFAULT NULL,
  `user_picture` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES ('1', 'admin', '8583101', '1234', 'admin@qq.com', '1', '艺术表演学院', '渴望一个很大的舞台', '我是一名演员', 'GXT_pink.jpg');
INSERT INTO `user_inf` VALUES ('2', 'userinfo', '8583102', '1234', 'userinfo@qq .com', '2', '北京大学', '教育至上', '我是一名老师', 'GXT_football.jpg');
INSERT INTO `user_inf` VALUES ('3', 'user', '8583103', '1234', 'user@qq.com', '1', '清华大学', '学习至上', '我是一名学生', 'GXT_red.jpg');
