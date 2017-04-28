/*
Navicat MySQL Data Transfer

Source Server         : gjz
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : cmssystem

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2013-12-03 14:09:38
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `web_column`
-- ----------------------------
DROP TABLE IF EXISTS `web_column`;
CREATE TABLE `web_column` (
  `id` bigint(20) NOT NULL auto_increment,
  `sjid` bigint(20) default NULL,
  `lmjb` varchar(50) character set utf8 default NULL,
  `lmmc` varchar(50) character set utf8 default NULL,
  `lmlx` varchar(50) character set utf8 default NULL,
  `lmmx` varchar(50) character set utf8 default NULL,
  `ljdz` varchar(50) character set utf8 default NULL,
  `lmpx` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_column
-- ----------------------------
INSERT INTO `web_column` VALUES ('18', '0', '', '新闻速览', 'news', '', '', '12');
INSERT INTO `web_column` VALUES ('19', '18', '', '国家新闻', '', '栏目模板-文章列表(系统自带)', 'gjxw', '1');
INSERT INTO `web_column` VALUES ('20', '18', '', '福建新闻', '', '栏目模板-文章列表(系统自带)', 'fjxw', '2');
INSERT INTO `web_column` VALUES ('23', '0', '', '重点项目新闻kk', '', '', '', '12');
INSERT INTO `web_column` VALUES ('27', '19', '198', '19下', 'news', '栏目内容模板-系统自带', '19xia', '34');
INSERT INTO `web_column` VALUES ('28', '19', '23', 'test下下级', 'ss', '栏目模板-文章列表(系统自带)', 'efseh', '34');
INSERT INTO `web_column` VALUES ('29', '18', '321', 'testNews', 'sfse', '栏目模板-文章列表(系统自带)', 'tyutrty', '453');
INSERT INTO `web_column` VALUES ('30', '0', '111', '111', '111', '', '111', '111');
INSERT INTO `web_column` VALUES ('31', '30', '222', '222', '222', '栏目模板-文章列表(系统自带)', '222', '222');
INSERT INTO `web_column` VALUES ('32', '30', '333', '333', '333', '栏目内容模板-系统自带', '333', '333');
INSERT INTO `web_column` VALUES ('33', '31', '444', '444', '444', '栏目模板-文章列表(系统自带)', '444', '444');
INSERT INTO `web_column` VALUES ('34', '31', '555', '555', '555', '栏目内容模板-系统自带', '555', '555');
INSERT INTO `web_column` VALUES ('35', '33', '666', '666', '666', '栏目模板-文章列表(系统自带)', '666', '666');
INSERT INTO `web_column` VALUES ('36', '31', '777', '777', '777', '栏目模板-文章列表(系统自带)', '777', '777');
INSERT INTO `web_column` VALUES ('37', '36', '888', '888', '888', '栏目内容模板-系统自带', '888', '888');

-- ----------------------------
-- Table structure for `web_config`
-- ----------------------------
DROP TABLE IF EXISTS `web_config`;
CREATE TABLE `web_config` (
  `id` bigint(8) NOT NULL auto_increment,
  `dwmc` varchar(50) default NULL,
  `zdmc` varchar(50) default NULL,
  `wzym` varchar(50) default NULL,
  `sybt` varchar(50) default NULL,
  `ymgjc` varchar(50) default NULL,
  `ymms` varchar(50) default NULL,
  `fwtj` varchar(50) default NULL,
  `bqxx` varchar(50) default NULL,
  `fjml` varchar(50) default NULL,
  `fllx` varchar(50) default NULL,
  `bcfs` varchar(50) default NULL,
  `wjdx` int(4) default NULL,
  `tpdx` int(4) default NULL,
  `mmgq` int(4) default NULL,
  `dlcwcs` int(4) default NULL,
  `tpcd` int(4) default NULL,
  `tpkd` int(4) default NULL,
  `sltc` int(4) default NULL,
  `sltk` int(4) default NULL,
  `tpsy` varchar(50) default NULL,
  `sywz` varchar(50) default NULL,
  `syzl` int(4) default NULL,
  `sywj` varchar(50) default NULL,
  `sytmd` int(4) default NULL,
  `sywzi` varchar(50) default NULL,
  `zyzt` varchar(50) default NULL,
  `zyztdx` int(4) default NULL,
  `lxdh` varchar(50) default NULL,
  `czhm` varchar(50) default NULL,
  `glyyx` varchar(50) default NULL,
  `icp` varchar(50) default NULL,
  `gbwz` varchar(50) default NULL,
  `gbyy` varchar(500) default NULL,
  `tjdm` varchar(50) default NULL,
  `stmp` varchar(50) default NULL,
  `stmpdk` varchar(50) default NULL,
  `fjrdz` varchar(50) default NULL,
  `yxzh` varchar(50) default NULL,
  `yxmm` varchar(50) default NULL,
  `fjrnc` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_config
-- ----------------------------
INSERT INTO `web_config` VALUES ('1', 'test', 'xx网站     ', 'http://www.xx.com', 'test', 'test', ' 测试数据 testtest ', 'fff', 'test 这是测试   ', 'ff', 'ff', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `web_infomation`
-- ----------------------------
DROP TABLE IF EXISTS `web_infomation`;
CREATE TABLE `web_infomation` (
  `id` bigint(20) NOT NULL auto_increment,
  `lmid` bigint(11) default NULL,
  `bt` varchar(50) default NULL,
  `btys` varchar(50) default NULL,
  `fbt` varchar(50) default NULL,
  `ljwz` varchar(50) default NULL,
  `sx` varchar(50) default NULL,
  `zz` varchar(50) default NULL,
  `ly` varchar(50) default NULL,
  `sj` datetime default NULL,
  `dd` varchar(50) default NULL,
  `llcs` int(11) default NULL,
  `nr` text,
  `zt` varchar(50) default NULL,
  `plcs` int(11) default NULL,
  `ip` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_infomation
-- ----------------------------
INSERT INTO `web_infomation` VALUES ('3', '20', '测试测试测试测试20', null, null, null, null, null, null, '2013-11-14 10:48:09', null, null, null, null, null, null);
INSERT INTO `web_infomation` VALUES ('8', '27', '19xia', null, null, 'dfads', null, '管理员', null, null, null, null, '<p>请在这里编辑文章！得高高的</p>', null, null, null);
INSERT INTO `web_infomation` VALUES ('9', '35', 'sdfae', null, null, 'fesdvbf', null, '管理员', null, null, null, null, '<p>sfae&nbsp; httyj<br/></p>', null, null, null);

-- ----------------------------
-- Table structure for `web_log`
-- ----------------------------
DROP TABLE IF EXISTS `web_log`;
CREATE TABLE `web_log` (
  `id` bigint(8) NOT NULL auto_increment,
  `yhm` varchar(20) default NULL,
  `xm` varchar(20) default NULL,
  `nr` varchar(100) default NULL,
  `sj` datetime default NULL,
  `ip` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_log
-- ----------------------------
INSERT INTO `web_log` VALUES ('1', 'admin', 'ss', '登录', '2013-11-05 10:10:31', '112.125.6.3');
INSERT INTO `web_log` VALUES ('2', 'admin', 'ss', '删除用户', '2013-11-09 10:55:30', '43.89.6.0');
INSERT INTO `web_log` VALUES ('3', 'sdf', 'ef', 'es', null, 'ee');
INSERT INTO `web_log` VALUES ('11', 'fsef', 'dfsfa', 'esa', null, 'fsef');

-- ----------------------------
-- Table structure for `web_model`
-- ----------------------------
DROP TABLE IF EXISTS `web_model`;
CREATE TABLE `web_model` (
  `id` bigint(20) NOT NULL auto_increment,
  `mxbt` varchar(50) character set utf8 default NULL,
  `mxpx` int(11) default NULL,
  `xtmr` varchar(10) character set utf8 default NULL,
  `mxurl` varchar(200) character set utf8 default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_model
-- ----------------------------
INSERT INTO `web_model` VALUES ('1', '栏目模板-文章列表(系统自带)', '1', '否', '/model/column_list_model.jsp');
INSERT INTO `web_model` VALUES ('3', '栏目内容模板-系统自带', '4', '是', '/model/column_content_model.jsp');

-- ----------------------------
-- Table structure for `web_question`
-- ----------------------------
DROP TABLE IF EXISTS `web_question`;
CREATE TABLE `web_question` (
  `id` bigint(20) NOT NULL auto_increment,
  `question` varchar(200) default NULL,
  `answer` varchar(1000) default NULL,
  `time` datetime default NULL,
  `author` varchar(50) default NULL,
  `url` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_question
-- ----------------------------
INSERT INTO `web_question` VALUES ('1', 'xxx', '<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; xxx\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>', '2013-11-11 20:32:59', 'xxx', 'xxxxx');
INSERT INTO `web_question` VALUES ('2', 'www', 'www', '2013-11-04 20:33:26', 'www', 'www');
INSERT INTO `web_question` VALUES ('3', 'test', '<p>tes<em>tfgd</em><br/></p>', null, 'test', 'test');

-- ----------------------------
-- Table structure for `web_role`
-- ----------------------------
DROP TABLE IF EXISTS `web_role`;
CREATE TABLE `web_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(50) character set utf8 default NULL,
  `power` varchar(500) character set utf8 default NULL,
  `descr` varchar(500) character set utf8 default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_role
-- ----------------------------
INSERT INTO `web_role` VALUES ('1', 'test', 'null', 'test');
INSERT INTO `web_role` VALUES ('6', 'grefg', 'null', '234214');
INSERT INTO `web_role` VALUES ('7', 'trdfs', 'null', 'dfgerqa');

-- ----------------------------
-- Table structure for `web_subcolumn`
-- ----------------------------
DROP TABLE IF EXISTS `web_subcolumn`;
CREATE TABLE `web_subcolumn` (
  `id` bigint(20) NOT NULL auto_increment,
  `ztid` bigint(20) default NULL,
  `lmmc` varchar(50) character set utf8 default NULL,
  `lmlx` varchar(50) character set utf8 default NULL,
  `lmmx` varchar(50) character set utf8 default NULL,
  `ljdz` varchar(50) character set utf8 default NULL,
  `lmpx` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_subcolumn
-- ----------------------------
INSERT INTO `web_subcolumn` VALUES ('4', '0', '十八大精神学习', 'news', '栏目模板-文章列表(系统自带)', 'null', '14');
INSERT INTO `web_subcolumn` VALUES ('11', '4', 'kkkk', 'null', '栏目模板-文章列表(系统自带)', 'null', '34');
INSERT INTO `web_subcolumn` VALUES ('12', '0', 'rewr', 'fsf', '栏目模板-文章列表(系统自带)', 'null', '43');
INSERT INTO `web_subcolumn` VALUES ('13', '12', 'eff', 'sfer', '栏目模板-文章列表(系统自带)', 'ewr', '57');

-- ----------------------------
-- Table structure for `web_subinfo`
-- ----------------------------
DROP TABLE IF EXISTS `web_subinfo`;
CREATE TABLE `web_subinfo` (
  `id` bigint(20) NOT NULL auto_increment,
  `lmid` bigint(11) default NULL,
  `bt` varchar(50) default NULL,
  `btys` varchar(50) default NULL,
  `fbt` varchar(50) default NULL,
  `ljwz` varchar(50) default NULL,
  `sx` varchar(50) default NULL,
  `zz` varchar(50) default NULL,
  `ly` varchar(50) default NULL,
  `sj` datetime default NULL,
  `dd` varchar(50) default NULL,
  `llcs` int(11) default NULL,
  `nr` text,
  `zt` varchar(50) default NULL,
  `plcs` int(11) default NULL,
  `ip` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_subinfo
-- ----------------------------
INSERT INTO `web_subinfo` VALUES ('7', '11', 'eeef', null, null, '', null, '管理员', null, null, null, null, '<p>请在这里编辑文章！fff</p>', null, null, null);

-- ----------------------------
-- Table structure for `web_suggestion`
-- ----------------------------
DROP TABLE IF EXISTS `web_suggestion`;
CREATE TABLE `web_suggestion` (
  `id` bigint(20) NOT NULL auto_increment,
  `xm` varchar(50) default NULL,
  `lxfs` varchar(50) default NULL,
  `bt` varchar(50) default NULL,
  `nr` varchar(1000) default NULL,
  `sj` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_suggestion
-- ----------------------------
INSERT INTO `web_suggestion` VALUES ('1', 'xx', '新罗区', '加油', '加油', '2013-11-12 17:58:43');

-- ----------------------------
-- Table structure for `web_user`
-- ----------------------------
DROP TABLE IF EXISTS `web_user`;
CREATE TABLE `web_user` (
  `id` bigint(8) NOT NULL auto_increment,
  `yhm` varchar(20) default NULL,
  `xm` varchar(20) default NULL,
  `mm` varchar(20) default NULL,
  `tswt` varchar(50) default NULL,
  `tsda` varchar(50) default NULL,
  `yx` varchar(50) default NULL,
  `dh` varchar(50) default NULL,
  `qx` varchar(500) default NULL,
  `dlsj` datetime default NULL,
  `scdlsj` datetime default NULL,
  `dlcs` int(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_user
-- ----------------------------
INSERT INTO `web_user` VALUES ('5', 'admin', 'sss', 'admin', null, null, '', '', null, null, null, null);
