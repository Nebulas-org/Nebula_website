/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : uccn

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-08-29 11:41:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文章',
  `img_path` varchar(255) DEFAULT NULL COMMENT '文章图片视频url，JSON 结构',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0 下线，1 上线',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1166251772962287618 DEFAULT CHARSET=utf8 COMMENT='文章详情';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '123', '经审理查明：被告人吴小晖隐瞒股权实控关系，以其个人实际控制的多家公司掌管安邦财产保险股份有限公司（以下简称安邦财险）、安邦集团股份有限公司（以下简称安邦集团），并先后担任安邦财险副董事长和安邦集团董事长、总经理等职。2011年1月起，吴小晖以安邦财险等公司为融资平台，指令他人使用虚假材料骗取原保监会批准和延续销售投资型保险产品。2011年7月至2017年1月，吴小晖指令他人采用制作虚假财务报表、披露虚假信息、虚假增资、虚构偿付能力、瞒报并隐匿保费收入等手段，欺骗监管机构和社会公众，以承诺还本付息且高于银行同期存款利率为诱饵，超过原保监会批准的规模向社会公众销售投资型保险产品非法吸收巨额资金。其间，吴小晖以虚假名义将部分超募保费转移至其个人实际控制的百余家公司，用于其个人归还公司债务、投资经营、向安邦集团增资等，至案发实际骗取652亿余元。此外，法院还查明，吴小晖利用职务便利非法侵占安邦财险保费资金100亿元。案发后，公安机关查封、冻结吴小晖及其个人实际控制的相关公司名下银行账户、房产、股权等资产。', null, '0', '2019-08-27 14:54:59', '2019-08-27 14:55:02');
INSERT INTO `article` VALUES ('2', '456', '　中国政府对经济的介入并非每次都值得叫好，但这一次，政府前所未有地对安邦保险集团实施接管，却值得抱以热烈的掌声。\r\n\r\n　　安邦通过举债在全球大举收购资产之后，已经成为了中国金融体系的一个巨大威胁。其收购对象包括纽约的华尔道夫酒店，而资金来源则是出售高收益保单。这些高风险产品让安邦从籍籍无名一跃而起，在短短几年时间里晋升成为中国最大的保险公司之一。\r\n\r\n　　中国保监会在网站上发布公告称，将从2月23日起对安邦实施接管，期限为1年；其创始人、原董事长吴小晖则因涉嫌经济犯罪，将被依法提起公诉。吴小晖于2017年6月被带走调查。\r\n', null, '0', '2019-08-27 14:55:35', '2019-08-27 14:55:38');
INSERT INTO `article` VALUES ('1166247935228653569', '安邦', '截至2017年第一季度末，安邦已经跃升为中国的第二大保险商，仅次于国有的中国人寿。它曾把贪婪的收购触角伸向喜达屋酒店及度假村国际集团，但这一150亿美元的交易意向最终流产。安邦还曾计划投资纽约第五大道666号，美国总统唐纳德·特朗普女婿贾里德·库什纳的家族企业Kushner Cos.持有这栋大楼的股份。', null, '0', null, '2019-08-27 15:15:50');
INSERT INTO `article` VALUES ('1166248544090664962', '安邦123', '截至2017年第一季度末，安邦已经跃升为中国的第二大保险商，仅次于国有的中国人寿。它曾把贪婪的收购触角伸向喜达屋酒店及度假村国际集团，但这一150亿美元的交易意向最终流产。安邦还曾计划投资纽约第五大道666号，美国总统唐纳德·特朗普女婿贾里德·库什纳的家族企业Kushner Cos.持有这栋大楼的股份。', null, '0', null, '2019-08-27 15:18:15');
INSERT INTO `article` VALUES ('1166249192035065858', '安邦456', '截至2017年第一季度末，安邦已经跃升为中国的第二大保险商，仅次于国有的中国人寿。它曾把贪婪的收购触角伸向喜达屋酒店及度假村国际集团，但这一150亿美元的交易意向最终流产。安邦还曾计划投资纽约第五大道666号，美国总统唐纳德·特朗普女婿贾里德·库什纳的家族企业Kushner Cos.持有这栋大楼的股份。', null, '0', '2019-08-27 07:20:50', '2019-08-27 15:20:49');
INSERT INTO `article` VALUES ('1166251513255202817', '安邦159', '截至2017年第一季度末，安邦已经跃升为中国的第二大保险商，仅次于国有的中国人寿。它曾把贪婪的收购触角伸向喜达屋酒店及度假村国际集团，但这一150亿美元的交易意向最终流产。安邦还曾计划投资纽约第五大道666号，美国总统唐纳德·特朗普女婿贾里德·库什纳的家族企业Kushner Cos.持有这栋大楼的股份。', null, '0', '2019-08-27 07:30:03', '2019-08-27 15:30:03');
INSERT INTO `article` VALUES ('1166251772962287617', '安邦1591', '截至2017年第一季度末，安邦已经跃升为中国的第二大保险商，仅次于国有的中国人寿。它曾把贪婪的收购触角伸向喜达屋酒店及度假村国际集团，但这一150亿美元的交易意向最终流产。安邦还曾计划投资纽约第五大道666号，美国总统唐纳德·特朗普女婿贾里德·库什纳的家族企业Kushner Cos.持有这栋大楼的股份。', null, '0', '2019-08-27 07:31:05', '2019-08-27 15:31:05');

-- ----------------------------
-- Table structure for `banner`
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `img_path` varchar(255) DEFAULT NULL COMMENT '文章图片url，JSON 结构',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0 下线，1 上线',
  `type` int(1) DEFAULT NULL COMMENT '0:banner,1:单个作品，2：作品集',
  `name_remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1164440742556782596 DEFAULT CHARSET=utf8 COMMENT='首页banner';

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1164428507788836865', 'd:\\picture\\BANNER\\图片4.png', '1', '0', null, '2019-08-22 06:46:01');
INSERT INTO `banner` VALUES ('1164428507788836866', 'd:\\picture\\BANNER\\图片4.png', '0', '2', '123', '2019-08-28 16:51:52');
INSERT INTO `banner` VALUES ('1164440742556782593', 'd:\\picture\\BANNER\\图片5.png', '1', '0', null, '2019-08-22 07:34:40');
INSERT INTO `banner` VALUES ('1164440742556782595', 'd:\\picture\\BANNER\\图片5.png', '1', '2', '256', '2019-08-28 16:52:23');

-- ----------------------------
-- Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '办公地址',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '手机号码',
  `email` varchar(255) NOT NULL DEFAULT '' COMMENT '邮箱',
  `qq` varchar(255) NOT NULL DEFAULT '' COMMENT 'qq',
  `wx` varchar(255) NOT NULL DEFAULT '' COMMENT '微信',
  `ownership` varchar(255) NOT NULL DEFAULT '' COMMENT '版权所有者，公司名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='联系方式表';

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1', '四川省成都市高新区天晖中街21号', '18008085420', 'wangyie-201@163.com', '280550256', '18008085420', '拾星云成都科技有限公司', '2018-08-29 21:14:49');

-- ----------------------------
-- Table structure for `presentation`
-- ----------------------------
DROP TABLE IF EXISTS `presentation`;
CREATE TABLE `presentation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '标题',
  `brief` text COMMENT '简介',
  `trademark` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌',
  `marketing` varchar(255) NOT NULL DEFAULT '' COMMENT '营销',
  `trademark_small_label_1` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌小便签1',
  `trademark_small_label_2` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌小便签5',
  `trademark_small_label_3` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌小便签3',
  `trademark_small_label_4` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌小便签4',
  `marketing_small_label_1` varchar(255) NOT NULL DEFAULT '' COMMENT '营销小便签1',
  `marketing_small_label_2` varchar(255) NOT NULL DEFAULT '' COMMENT '营销小便签2',
  `marketing_small_label_3` varchar(255) NOT NULL DEFAULT '' COMMENT '营销小便签3',
  `marketing_small_label_4` varchar(255) NOT NULL DEFAULT '' COMMENT '营销小便签4',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '1 为有效 2 为禁用',
  `crateDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='公司简介表';

-- ----------------------------
-- Records of presentation
-- ----------------------------
INSERT INTO `presentation` VALUES ('1', '我们是中国的品牌和设计机构。', '近年来，随着微商市场份额的逐渐扩大，越来越多的企业开始进入微商渠道，但微商究竟怎么玩，怎么做品牌策划方面的工作，大部分的企业仍然一头雾水，鹰九营销策划公司就微商层面，分析了部分微商案例为大家提供更多思考。', '品牌体验', '媒体营销', '', '', '', '', '', '', '', '', '1', '2018-08-29 23:47:27');
INSERT INTO `presentation` VALUES ('2', '我们是中国的品牌和设计机构。', '近年来，随着微商市场份额的逐渐扩大，越来越多的企业开始进入微商渠道，但微商究竟怎么玩，怎么做品牌策划方面的工作，大部分的企业仍然一头雾水，鹰九营销策划公司就微商层面，分析了部分微商案例为大家提供更多思考。', '品牌体验', '媒体营销', '', '', '', '', '', '', '', '', '1', '2018-08-29 23:55:17');
INSERT INTO `presentation` VALUES ('3', '我们是中国的品牌和设计机构。', '近年来，随着微商市场份额的逐渐扩大，越来越多的企业开始进入微商渠道，但微商究竟怎么玩，怎么做品牌策划方面的工作，大部分的企业仍然一头雾水，鹰九营销策划公司就微商层面，分析了部分微商案例为大家提供更多思考。', '品牌体验', '媒体营销', '彰显个性', '追求互动', '蕴含情感', '创造快乐', '社会化媒体', '新媒体', '跨媒体', '移动媒体', '1', '2018-08-29 23:56:15');
INSERT INTO `presentation` VALUES ('4', '我们是中国的品牌和设计机构。', '123456', '品牌体验', '媒体营销', '彰显个性', '追求互动', '蕴含情感', '创造快乐', '社会化媒体', '新媒体', '跨媒体', '移动媒体', '1', '2019-08-20 11:28:44');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `email` varchar(255) NOT NULL DEFAULT '',
  `avatar` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1 为有效 2 为禁用',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '1 为管理员  2 为编辑',
  `mobile` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1164440742556782591 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1164440742556782590', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'wangyie-201@163.com', null, '1', '1', '18008085420', '2019-06-18 08:08:08');
