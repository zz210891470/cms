/*
Navicat MySQL Data Transfer

Source Server         : cgkj
Source Server Version : 50161
Source Host           : localhost:3306
Source Database       : ckk

Target Server Type    : MYSQL
Target Server Version : 50161
File Encoding         : 65001

Date: 2014-03-25 19:56:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_area`
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `dq` varchar(50) DEFAULT NULL,
  `lx` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_area
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_cb_project`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cb_project`;
CREATE TABLE `tb_cb_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nd` int(4) DEFAULT NULL,
  `bh` varchar(50) DEFAULT NULL,
  `mc` varchar(100) DEFAULT NULL,
  `dq` varchar(50) DEFAULT NULL,
  `lb1` varchar(50) DEFAULT NULL,
  `lb2` varchar(50) DEFAULT NULL,
  `lb3` varchar(50) DEFAULT NULL,
  `jsdd` varchar(50) DEFAULT NULL,
  `jsgm` varchar(8000) DEFAULT NULL,
  `ztz` decimal(10,0) DEFAULT NULL,
  `xyfx` varchar(8000) DEFAULT NULL,
  `sbdw` varchar(50) DEFAULT NULL,
  `lxr` varchar(255) DEFAULT NULL,
  `lxdh` varchar(255) DEFAULT NULL,
  `chdw` varchar(255) DEFAULT NULL,
  `lxr1` varchar(255) DEFAULT NULL,
  `lxdh1` varchar(255) DEFAULT NULL,
  `bgs` varchar(255) DEFAULT NULL,
  `bssj` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_cb_project
-- ----------------------------
INSERT INTO `tb_cb_project` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_cb_project` VALUES ('3', '0', null, '8', null, null, null, null, '6', '6', '6', '6', '6', '6', null, '6', '6', '6', '6', null);

-- ----------------------------
-- Table structure for `tb_industry`
-- ----------------------------
DROP TABLE IF EXISTS `tb_industry`;
CREATE TABLE `tb_industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `dl` varchar(50) DEFAULT NULL,
  `xl` varchar(50) DEFAULT NULL,
  `lx` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_industry
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_zda_month`
-- ----------------------------
DROP TABLE IF EXISTS `tb_zda_month`;
CREATE TABLE `tb_zda_month` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bh` varchar(50) DEFAULT NULL,
  `yf` int(2) DEFAULT NULL,
  `bywc` decimal(10,0) DEFAULT NULL,
  `nczbywc` decimal(10,0) DEFAULT NULL,
  `wcndjh` decimal(10,0) DEFAULT NULL,
  `xxjd` varchar(1000) DEFAULT NULL,
  `czwt` varchar(1000) DEFAULT NULL,
  `gzjh` varchar(1000) DEFAULT NULL,
  `wcgzjd` varchar(1000) DEFAULT NULL,
  `tbsj` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zda_month
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_zda_project`
-- ----------------------------
DROP TABLE IF EXISTS `tb_zda_project`;
CREATE TABLE `tb_zda_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nd` int(4) DEFAULT NULL,
  `bh` varchar(50) DEFAULT NULL,
  `mc` varchar(100) DEFAULT NULL,
  `dq` varchar(50) DEFAULT NULL,
  `lb1` varchar(50) DEFAULT NULL,
  `lb2` varchar(50) DEFAULT NULL,
  `lb3` varchar(50) DEFAULT NULL,
  `jsdd` varchar(50) DEFAULT NULL,
  `jsgm` varchar(8000) DEFAULT NULL,
  `ztz` decimal(10,0) DEFAULT NULL,
  `xyfx` varchar(8000) DEFAULT NULL,
  `sbdw` varchar(50) DEFAULT NULL,
  `lxr` varchar(255) DEFAULT NULL,
  `lxdh` varchar(255) DEFAULT NULL,
  `chdw` varchar(255) DEFAULT NULL,
  `lxr1` varchar(255) DEFAULT NULL,
  `lxdh1` varchar(255) DEFAULT NULL,
  `bgs` varchar(255) DEFAULT NULL,
  `bssj` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zda_project
-- ----------------------------
INSERT INTO `tb_zda_project` VALUES ('1', '1', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_zda_project` VALUES ('2', '0', null, '54', null, null, null, null, '', '', '453', '', '', '', null, '', '', '', '', null);

-- ----------------------------
-- Table structure for `tb_zd_month`
-- ----------------------------
DROP TABLE IF EXISTS `tb_zd_month`;
CREATE TABLE `tb_zd_month` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bh` varchar(50) DEFAULT NULL,
  `yf` int(2) DEFAULT NULL,
  `jhtz1` decimal(10,0) DEFAULT NULL,
  `jhtz2` decimal(10,0) DEFAULT NULL,
  `jhtz3` decimal(10,0) DEFAULT NULL,
  `jhtzhj` decimal(10,0) DEFAULT NULL,
  `dwzj1` decimal(10,0) DEFAULT NULL,
  `dwzj2` decimal(10,0) DEFAULT NULL,
  `dwzj3` decimal(10,0) DEFAULT NULL,
  `dwzjhj` decimal(10,0) DEFAULT NULL,
  `dnljdw1` decimal(10,0) DEFAULT NULL,
  `dnljdw2` decimal(10,0) DEFAULT NULL,
  `dnljdw3` decimal(10,0) DEFAULT NULL,
  `dnljdwhj` decimal(10,0) DEFAULT NULL,
  `kgljdw1` decimal(10,0) DEFAULT NULL,
  `kgljdw2` decimal(10,0) DEFAULT NULL,
  `kgljdw3` decimal(10,0) DEFAULT NULL,
  `kgljdwhj` decimal(10,0) DEFAULT NULL,
  `bywc` decimal(10,0) DEFAULT NULL,
  `nczbywc` decimal(10,0) DEFAULT NULL,
  `wcndjh` decimal(10,0) DEFAULT NULL,
  `xxjd` varchar(1000) DEFAULT NULL,
  `scnl` varchar(1000) DEFAULT NULL,
  `czwt` varchar(1000) DEFAULT NULL,
  `xtjj` varchar(1000) DEFAULT NULL,
  `gzjh` varchar(1000) DEFAULT NULL,
  `jcqk` varchar(1000) DEFAULT NULL,
  `zjsm` varchar(1000) DEFAULT NULL,
  `sfkg` varchar(10) DEFAULT NULL,
  `kgqk` varchar(1000) DEFAULT NULL,
  `kgrq` varchar(20) DEFAULT NULL,
  `sfjg` varchar(10) DEFAULT NULL,
  `jgqk` varchar(1000) DEFAULT NULL,
  `jgrq` varchar(20) DEFAULT NULL,
  `tbsj` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zd_month
-- ----------------------------
INSERT INTO `tb_zd_month` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `tb_zd_project`
-- ----------------------------
DROP TABLE IF EXISTS `tb_zd_project`;
CREATE TABLE `tb_zd_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nd` int(4) DEFAULT NULL,
  `bh` varchar(50) DEFAULT NULL,
  `mc` varchar(100) DEFAULT NULL,
  `dq` varchar(50) DEFAULT NULL,
  `lb1` varchar(50) DEFAULT NULL,
  `lb2` varchar(50) DEFAULT NULL,
  `lb3` varchar(50) DEFAULT NULL,
  `jsdd` varchar(50) DEFAULT NULL,
  `jsgm` varchar(8000) DEFAULT NULL,
  `kgn` varchar(4) DEFAULT NULL,
  `kgy` varchar(2) DEFAULT NULL,
  `bawh` varchar(100) DEFAULT NULL,
  `jsnx1` int(4) DEFAULT NULL,
  `jsnx2` int(4) DEFAULT NULL,
  `ztz` decimal(10,0) DEFAULT NULL,
  `wctz` decimal(10,0) DEFAULT NULL,
  `jzqk` varchar(1000) DEFAULT NULL,
  `jhtz` decimal(10,0) DEFAULT NULL,
  `tz1` decimal(10,0) DEFAULT NULL,
  `tz2` decimal(10,0) DEFAULT NULL,
  `tz3` decimal(10,0) DEFAULT NULL,
  `tz4` decimal(10,0) DEFAULT NULL,
  `tz5` decimal(10,0) DEFAULT NULL,
  `tz6` decimal(10,0) DEFAULT NULL,
  `tz7` decimal(10,0) DEFAULT NULL,
  `tz8` decimal(10,0) DEFAULT NULL,
  `tz9` decimal(10,0) DEFAULT NULL,
  `tz10` decimal(10,0) DEFAULT NULL,
  `tz11` decimal(10,0) DEFAULT NULL,
  `tz12` decimal(10,0) DEFAULT NULL,
  `dwmc` varchar(50) DEFAULT NULL,
  `zrr` varchar(50) DEFAULT NULL,
  `gldw` varchar(50) DEFAULT NULL,
  `zzppzc` decimal(10,0) DEFAULT NULL,
  `zzppdk` decimal(10,0) DEFAULT NULL,
  `zzppzf` decimal(10,0) DEFAULT NULL,
  `tzztxz` varchar(50) DEFAULT NULL,
  `sfkg` varchar(2) DEFAULT NULL,
  `kgyf` varchar(2) DEFAULT NULL,
  `cz` decimal(10,0) DEFAULT NULL,
  `ss` decimal(10,0) DEFAULT NULL,
  `jy` decimal(10,0) DEFAULT NULL,
  `zd` decimal(10,0) DEFAULT NULL,
  `nyd` decimal(10,0) DEFAULT NULL,
  `nt` decimal(10,0) DEFAULT NULL,
  `ld` decimal(10,0) DEFAULT NULL,
  `sgyy` decimal(10,0) DEFAULT NULL,
  `hgyp` decimal(10,0) DEFAULT NULL,
  `yhdk` decimal(10,0) DEFAULT NULL,
  `sfscx` varchar(2) DEFAULT NULL,
  `sfzz` varchar(2) DEFAULT NULL,
  `sfss` varchar(2) DEFAULT NULL,
  `sfzy` varchar(2) DEFAULT NULL,
  `sfsjs` varchar(2) DEFAULT NULL,
  `sjslb` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zd_project
-- ----------------------------
INSERT INTO `tb_zd_project` VALUES ('2', '2', '2', '3', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_zd_project` VALUES ('3', '0', null, '8', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_zd_project` VALUES ('4', '0', null, '42', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `tb_zs_project`
-- ----------------------------
DROP TABLE IF EXISTS `tb_zs_project`;
CREATE TABLE `tb_zs_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nd` int(4) DEFAULT NULL,
  `bh` varchar(50) DEFAULT NULL,
  `mc` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `jsgm` varchar(8000) CHARACTER SET utf8 DEFAULT NULL,
  `hzfs` varchar(100) DEFAULT NULL,
  `lxdw` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `lxr` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `lxdh` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `qqgz` varchar(8000) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_zs_project
-- ----------------------------
INSERT INTO `tb_zs_project` VALUES ('4', '0', null, '7', '3', '3', '3', '3', '3', '');
INSERT INTO `tb_zs_project` VALUES ('6', '0', null, '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `tb_zs_project` VALUES ('7', '0', null, '3', '2', '2', '2', '2', '2', '');
INSERT INTO `tb_zs_project` VALUES ('8', '0', null, '4', '4', '4', '4', '4', '4', '4');
INSERT INTO `tb_zs_project` VALUES ('9', '0', null, '5', '5', '5', '5', '5', '5', '5');
INSERT INTO `tb_zs_project` VALUES ('10', '0', null, '6', '6', '6', '6', '6', '6', '6');
INSERT INTO `tb_zs_project` VALUES ('11', '0', null, '9', '9', '9', '9', '9', '9', '9');
INSERT INTO `tb_zs_project` VALUES ('12', '0', null, '2', '2', '2', '2', '2', '2', '2');
INSERT INTO `tb_zs_project` VALUES ('14', '0', null, '56', '56', '5', '5', '5', '5', '5');
INSERT INTO `tb_zs_project` VALUES ('16', '0', null, '564', '45', '34', '32', '354', '35', '2');
INSERT INTO `tb_zs_project` VALUES ('17', '0', null, '2342', '23412', '234124', '2341243', '23424', '234', '23432');
INSERT INTO `tb_zs_project` VALUES ('19', '0', null, '34535', '45645', '242', '3242', '2343', '43535', '23424');
INSERT INTO `tb_zs_project` VALUES ('20', '0', null, '3535543', '23542', '3453', '', '2354', '', '352');
INSERT INTO `tb_zs_project` VALUES ('21', '0', null, '4656756', '543', '463', '2', '46', '235', '3532');

-- ----------------------------
-- Table structure for `web_advert`
-- ----------------------------
DROP TABLE IF EXISTS `web_advert`;
CREATE TABLE `web_advert` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `imgurl` varchar(200) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_advert
-- ----------------------------
INSERT INTO `web_advert` VALUES ('1', '首页顶部广告', 'upload/20143/1395727218236.jpg', '1', '#');
INSERT INTO `web_advert` VALUES ('2', '首页中部广告', 'upload/20143/1395714945781.jpg', '1', '');
INSERT INTO `web_advert` VALUES ('3', '首页左侧广告', 'upload/20143/1395715225547.png', '0', '');
INSERT INTO `web_advert` VALUES ('4', '首页右侧广告', 'upload/20143/1395715232100.png', '0', '');
INSERT INTO `web_advert` VALUES ('5', '首页弹窗广告', 'upload/20143/1395715271810.jpg', '0', '');
INSERT INTO `web_advert` VALUES ('6', '首页漂浮广告', 'upload/20143/1395714557025.png', '0', '');

-- ----------------------------
-- Table structure for `web_column`
-- ----------------------------
DROP TABLE IF EXISTS `web_column`;
CREATE TABLE `web_column` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sjid` bigint(20) DEFAULT NULL,
  `lmjb` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lmmc` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lmlx` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lmmx` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ljdz` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lmpx` int(11) DEFAULT NULL,
  `llcs` bigint(20) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_column
-- ----------------------------
INSERT INTO `web_column` VALUES ('40', '0', '', '机构概况', '', '内容模型', '', '1', '1');
INSERT INTO `web_column` VALUES ('41', '0', '', '信息公开', '', '内容模型', '', '2', '1');
INSERT INTO `web_column` VALUES ('42', '0', '', '网上办事', '', '内容模型', '', '3', '1');
INSERT INTO `web_column` VALUES ('44', '0', '', '项目招商', '', 'null', '', '5', '1');
INSERT INTO `web_column` VALUES ('45', '40', '', '机构介绍', '', '内容模型', 'jgjs', '11', '1');
INSERT INTO `web_column` VALUES ('46', '40', '', '领导信息', '', '内容模型', 'ldxx', '12', '1');
INSERT INTO `web_column` VALUES ('47', '40', '', '机构设置', '', '内容模型', 'bmsz', '13', '1');
INSERT INTO `web_column` VALUES ('48', '40', '', '联系方式', '', '内容模型', 'lxfs', '14', '1');
INSERT INTO `web_column` VALUES ('49', '41', '', '新闻动态', '', '列表模型', 'xwdt', '21', '2');
INSERT INTO `web_column` VALUES ('50', '41', '', '通知公告', '', '列表模型', 'gsgg', '22', '1');
INSERT INTO `web_column` VALUES ('51', '41', '', '政策法规', '', '列表模型', 'zcfg', '23', '1');
INSERT INTO `web_column` VALUES ('56', '44', '', '投资环境', '', '列表模型', 'tzhj', '41', '1');
INSERT INTO `web_column` VALUES ('57', '44', '', '优惠政策', '', '列表模型', 'yhzc', '42', '1');
INSERT INTO `web_column` VALUES ('58', '44', '', '招商项目', '', '列表模型', 'xmzs', '43', '1');
INSERT INTO `web_column` VALUES ('59', '44', '', '前期项目', '', '列表模型', 'xmjs', '44', '1');
INSERT INTO `web_column` VALUES ('60', '41', '', '机关党建', '', '列表模型', 'jgdj', '28', '1');
INSERT INTO `web_column` VALUES ('61', '41', '', '廉政效能', '', '列表模型', 'lzxn', '29', '1');
INSERT INTO `web_column` VALUES ('62', '42', '1', '办事指南', '1', '列表模型', '', '1', '1');
INSERT INTO `web_column` VALUES ('63', '42', '1', '文件下载', '1', '下载模型', '', '2', '1');
INSERT INTO `web_column` VALUES ('64', '0', null, '项目建设', null, 'null', null, '4', '1');
INSERT INTO `web_column` VALUES ('67', '64', null, '在建重点项目', null, '列表模型', null, '1', '1');
INSERT INTO `web_column` VALUES ('69', '64', null, '预备重点项目', null, '列表模型', null, '2', '1');
INSERT INTO `web_column` VALUES ('70', '64', null, '开工项目', null, '列表模型', null, '3', '1');
INSERT INTO `web_column` VALUES ('71', '64', null, '竣工项目', null, '列表模型', null, '4', '1');
INSERT INTO `web_column` VALUES ('73', '44', null, '储备项目', null, '列表模型', null, '45', '1');
INSERT INTO `web_column` VALUES ('74', '44', null, '项目策划指南', null, '列表模型', null, '46', '1');
INSERT INTO `web_column` VALUES ('75', '41', null, '文件通知', null, '列表模型', null, '24', '1');

-- ----------------------------
-- Table structure for `web_config`
-- ----------------------------
DROP TABLE IF EXISTS `web_config`;
CREATE TABLE `web_config` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `dwmc` varchar(50) DEFAULT NULL,
  `zdmc` varchar(50) DEFAULT NULL,
  `wzym` varchar(50) DEFAULT NULL,
  `sybt` varchar(50) DEFAULT NULL,
  `ymgjc` varchar(50) DEFAULT NULL,
  `ymms` varchar(50) DEFAULT NULL,
  `fwtj` varchar(50) DEFAULT NULL,
  `bqxx` varchar(50) DEFAULT NULL,
  `fjml` varchar(50) DEFAULT NULL,
  `fllx` varchar(50) DEFAULT NULL,
  `bcfs` varchar(50) DEFAULT NULL,
  `wjdx` int(4) DEFAULT NULL,
  `tpdx` int(4) DEFAULT NULL,
  `mmgq` int(4) DEFAULT NULL,
  `dlcwcs` int(4) DEFAULT NULL,
  `tpcd` int(4) DEFAULT NULL,
  `tpkd` int(4) DEFAULT NULL,
  `sltc` int(4) DEFAULT NULL,
  `sltk` int(4) DEFAULT NULL,
  `tpsy` varchar(50) DEFAULT NULL,
  `sywz` varchar(50) DEFAULT NULL,
  `syzl` int(4) DEFAULT NULL,
  `sywj` varchar(50) DEFAULT NULL,
  `sytmd` int(4) DEFAULT NULL,
  `sywzi` varchar(50) DEFAULT NULL,
  `zyzt` varchar(50) DEFAULT NULL,
  `zyztdx` int(4) DEFAULT NULL,
  `lxdh` varchar(50) DEFAULT NULL,
  `czhm` varchar(50) DEFAULT NULL,
  `glyyx` varchar(50) DEFAULT NULL,
  `icp` varchar(50) DEFAULT NULL,
  `gbwz` varchar(50) DEFAULT NULL,
  `gbyy` varchar(500) DEFAULT NULL,
  `tjdm` varchar(50) DEFAULT NULL,
  `stmp` varchar(50) DEFAULT NULL,
  `stmpdk` varchar(50) DEFAULT NULL,
  `fjrdz` varchar(50) DEFAULT NULL,
  `yxzh` varchar(50) DEFAULT NULL,
  `yxmm` varchar(50) DEFAULT NULL,
  `fjrnc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_config
-- ----------------------------
INSERT INTO `web_config` VALUES ('1', 'test', 'xx网站     ', 'http://www.xx.com', 'test', 'test', ' 测试数据 testtest ', 'fff', 'test 这是测试   ', 'ff', 'ff', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `web_consult`
-- ----------------------------
DROP TABLE IF EXISTS `web_consult`;
CREATE TABLE `web_consult` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `xm` varchar(50) DEFAULT NULL,
  `lxfs` varchar(50) DEFAULT NULL,
  `bt` varchar(200) DEFAULT NULL,
  `nr` text,
  `sj` datetime DEFAULT NULL,
  `zt` varchar(50) DEFAULT NULL,
  `hfnr` text,
  `hfsj` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_consult
-- ----------------------------
INSERT INTO `web_consult` VALUES ('2', '222', '222', '222', '222', '2013-12-17 16:00:20', '已答复', '444', '2014-03-16 15:45:16');
INSERT INTO `web_consult` VALUES ('6', '绝色赌妃', '水电费', '上福娃', '的说法', null, null, null, null);
INSERT INTO `web_consult` VALUES ('7', '热问题', '额外热舞', '大锅饭', '分公司', null, null, null, null);
INSERT INTO `web_consult` VALUES ('8', '东风公司', '个人广东省', '地方噶', '第三关', null, null, null, null);
INSERT INTO `web_consult` VALUES ('9', '讽德诵功', '地方噶是', '损公肥私', '施工方的', null, null, null, null);
INSERT INTO `web_consult` VALUES ('10', '东风公司梵蒂冈', '都发生过', '是电饭锅', '大概', null, null, null, null);
INSERT INTO `web_consult` VALUES ('11', '第三关', '上官方', '双方各', '是电饭锅上', null, null, null, null);
INSERT INTO `web_consult` VALUES ('14', 'aaa', 'a', 'aa', 'a', null, null, null, null);
INSERT INTO `web_consult` VALUES ('15', 'aaa', 'aa', 'aa', 'aaa', null, null, null, null);

-- ----------------------------
-- Table structure for `web_infoguide`
-- ----------------------------
DROP TABLE IF EXISTS `web_infoguide`;
CREATE TABLE `web_infoguide` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_infoguide
-- ----------------------------
INSERT INTO `web_infoguide` VALUES ('1', '公开指南', '<p>1111</p>', '2013-12-30');
INSERT INTO `web_infoguide` VALUES ('2', '申请公开', '申请公开', null);
INSERT INTO `web_infoguide` VALUES ('3', '收费项目和标准', '收费项目和标准', null);
INSERT INTO `web_infoguide` VALUES ('4', '申请公开流程图', '申请公开流程图', null);

-- ----------------------------
-- Table structure for `web_infomation`
-- ----------------------------
DROP TABLE IF EXISTS `web_infomation`;
CREATE TABLE `web_infomation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lmid` bigint(11) DEFAULT NULL,
  `bt` varchar(50) DEFAULT NULL,
  `btys` varchar(50) DEFAULT NULL,
  `fbt` varchar(50) DEFAULT NULL,
  `ljwz` varchar(50) DEFAULT NULL,
  `sx` varchar(50) DEFAULT NULL,
  `zz` varchar(50) DEFAULT NULL,
  `ly` varchar(50) DEFAULT NULL,
  `zy` text,
  `sj` datetime DEFAULT NULL,
  `dd` varchar(50) DEFAULT NULL,
  `llcs` int(11) DEFAULT '0',
  `nr` text,
  `zt` varchar(50) DEFAULT NULL,
  `plcs` int(11) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `lstp` varchar(200) DEFAULT NULL,
  `px` bigint(20) DEFAULT NULL,
  `rd` int(11) DEFAULT NULL,
  `hd` int(11) DEFAULT NULL,
  `gd` int(11) DEFAULT NULL,
  `fbr` varchar(50) DEFAULT NULL,
  `rq` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_infomation
-- ----------------------------
INSERT INTO `web_infomation` VALUES ('11', '39', '公示1', null, null, 'gsgg1', null, '管理员', null, null, '2014-01-09 11:22:58', null, null, '<p>第一篇文章</p><p><br/></p><table><tbody><tr><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td></tr><tr><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td></tr><tr><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td></tr><tr><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td></tr><tr><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td></tr><tr><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td><td valign=\"top\" width=\"92\"><br/></td></tr></tbody></table><p>文章内容：&nbsp; <br/></p><p><br/></p>', '草稿', null, null, null, null, null, null, null, null, null);
INSERT INTO `web_infomation` VALUES ('12', '39', '公示2', null, null, 'gsgg2', null, '管理员', null, null, '2014-01-09 11:22:58', null, null, '<p>公示公告2：</p><p><br/></p><p>内容：</p><p><br/></p><p><br/></p><p><span style=\"text-decoration: underline;\"><em><strong>样式</strong></em></span></p><p><span style=\"text-decoration: underline;\"><em><strong>演示</strong></em></span></p><p>测试<br/></p>', '草稿', null, null, null, null, null, null, null, null, null);
INSERT INTO `web_infomation` VALUES ('13', '39', '公示3', null, null, 'gsgg3', null, '管理员', null, null, '2014-01-09 11:22:58', null, null, '<p>公示公告3：</p><p><br/></p><p>内容概要</p><p><br/></p><p>很多细节要改</p><p><br/></p><p>上传下载9:58:522013-12-09<img src=\"http://img.baidu.com/hi/jx2/j_0016.gif\"/></p>', '草稿', null, null, null, null, null, null, null, null, null);
INSERT INTO `web_infomation` VALUES ('14', '39', '公示4', null, null, 'gsgg4', null, '管理员', null, null, '2014-01-09 11:22:58', null, null, '<p>公示公告4</p><p><br/></p><p><br/></p><p>测试时取10个目前只有4个<br/></p>', '草稿', null, null, null, null, null, null, null, null, null);
INSERT INTO `web_infomation` VALUES ('81', '45', '机构介绍', null, null, 'null', null, '管理员', '', '', '2014-03-24 16:13:13', null, null, '<blockquote><p>如此介绍&nbsp; 好不好&nbsp; 先看看</p></blockquote>', '已发布', null, null, '', null, null, null, null, 'sss', '2014-01-16');
INSERT INTO `web_infomation` VALUES ('82', '46', '领导信息介绍ee', null, null, 'null', null, '管理员', '', '', '2014-03-24 10:43:00', null, null, '<p>这样介绍好不好&nbsp; 好<br/></p>', '已发布', null, null, '', null, null, null, null, 'sss', '2014-01-18');
INSERT INTO `web_infomation` VALUES ('83', '47', '部门设置信息', null, null, 'null', null, '管理员', '', '', '2014-03-24 10:43:11', null, null, '<p>部门设置信息，这里测试</p>', '已发布', null, null, '', null, null, null, null, 'sss', '2014-01-19');
INSERT INTO `web_infomation` VALUES ('84', '48', '联系方式信息', null, null, 'null', null, '管理员', '', '', '2014-03-24 10:43:23', null, null, '<p>这里测试联系方式信息</p>', '已发布', null, null, '', null, null, null, null, 'sss', '2014-01-18');
INSERT INTO `web_infomation` VALUES ('91', '62', 'aaaaa', null, null, '', null, '管理员', null, null, '2014-01-12 16:06:56', null, '5', '<p>请在这里编辑文章！</p>', '已删除', null, null, 'null', null, null, null, null, null, null);
INSERT INTO `web_infomation` VALUES ('92', '15', '1213314432', null, null, 'null', null, '', '', 'null', '2014-03-14 22:53:16', null, '0', 'null', '草稿', null, null, 'null', null, null, null, null, null, null);
INSERT INTO `web_infomation` VALUES ('93', '15', 'erte', null, null, 'null', null, 'dfgdfg', 'drgd', 'null', '2014-03-14 23:07:16', null, '0', 'null', '草稿', null, null, 'null', null, null, null, null, null, null);
INSERT INTO `web_infomation` VALUES ('137', '49', '福建省首辆新型镍氢动力电池快充新能源汽车近日下线试运行', null, null, 'null', null, '', '', 'null', '2014-03-25 16:19:52', null, '10', '<p style=\"TEXT-ALIGN: left\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;&nbsp;&nbsp; 该款新能源车是由福建卫东新能源有限公司自主研发，具有三大突出特点：快速充电，充电时间小于10分钟；充电基础设施投入少；使用混合动力和直驱电机，不改变驾驶习惯且降低驾驶员劳动强度。与传统纯电动车造价相比，成本降低近70万元；与传统汽油公交车油耗成本相比，每公里费用节开支降低了75%，是适合城市公交定点运输的新能源汽车。</span></p>', '已发布', null, null, 'upload/20143/1395734493250.jpg', null, null, '1', null, '综合科', '2014-01-20');
INSERT INTO `web_infomation` VALUES ('138', '49', '新龙马启腾M70获多项大客户订单', null, null, '', null, '', '', 'null', '2014-03-25 16:31:16', null, '3', '<p>&nbsp;&nbsp;&nbsp; 今年初，福汽集团正式发布旗下信龙马汽车全新自主小汽车品牌“启腾”。近期，新龙马启腾M70获多项大客户订单，涉及货运、客运、物流等多个领域。同时，福汽启腾正与河南邮政、天津冀津厢式货运CNG、沈阳城市货运等客户进行批量采购业务洽谈。</p><p>&nbsp;</p>', '已删除', null, null, 'upload/20143/1395735941812.jpg', null, null, '1', null, '综合科', '2014-01-05');
INSERT INTO `web_infomation` VALUES ('139', '49', '中航国际到新罗区考察通航布局', null, null, 'null', null, '', '', 'null', '2014-03-25 17:40:13', null, '4', '<p style=\"TEXT-ALIGN: left\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;&nbsp;&nbsp; 2月24</span><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">日，中航国际（福建）实业有限公司副总裁蒋聪萍在市发改委的陪同下，对省重点在建项目—龙岩直升机通航综合服务基地进行实地考察，充分了解龙岩新罗的通航布局，为下一步构建全市立体交通网络奠定基础。</span></p>', '已发布', null, null, 'upload/20143/1395736832625.jpg', null, null, '1', null, '综合科', '2014-01-03');
INSERT INTO `web_infomation` VALUES ('140', '57', '龙岩市优惠政策摘编', null, null, '', null, '', '招商项目手册', 'null', '2014-03-25 17:00:59', null, '3', '<p style=\"TEXT-ALIGN: center\"><span style=\"FONT-FAMILY: 黑体, SimHeiFONT-FAMILY: 黑体, SimHei; FONT-SIZE: 24px\">龙岩市优惠政策</span></p><p>&nbsp;&nbsp; <span style=\"LINE-HEIGHT: 0px\" id=\"_baidu_bookmark_start_6\">‍</span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; MARGIN-BOTTOM: 0pt\" class=\"p15\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">█&nbsp;优惠政策摘编</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><?xml:namespace prefix=\"o\" ns=\"urn:schemas-microsoft-com:office:office\"><o:p></o:p></?xml:namespace></span></p><p style=\"LINE-HEIGHT: 12pt; MARGIN-TOP: 0pt; MARGIN-BOTTOM: 0pt\" class=\"p15\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">&nbsp;</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 22.2pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">一、老区优惠政策</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;福建原中央苏区县参照执行西部地区政策。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 18pt; MARGIN-TOP: 0pt; TEXT-INDENT: 18pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 9pt; mso-spacerun: &#39;yes&#39;\">（摘自：国发﹝2009﹞24号《国务院关于支持福建省加快建设海峡西岸经济区的若干意见》）</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 9pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 36pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 9pt; mso-spacerun: &#39;yes&#39;\">注：龙岩全境均属原中央苏区县</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 9pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">&nbsp;&nbsp;&nbsp;&nbsp;●&nbsp;国发﹝2012﹞21号《国务院关于支持赣南等原中央苏区振兴发展的若干意见》</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;闽委﹝2011﹞30号《关于支持和促进革命老区加快发展的若干意见》</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 15.45pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">&nbsp;</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">二、建设用地政策</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: justify; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;项目建设用地可以按国家规定的工业用地最低出让价格出让土地。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;为鼓励集约节约用地，企业在完成合同约定的固定资产投资并建设两层以上工业厂房的，第二层厂房每平方米给予奖励20元人民币，每增加一层奖励标准每平方米增加10元。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;优先保障工业用地、提供优质配套服务。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: justify; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 22.2pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">三、财政优惠政策</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: left; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 24pt; MARGIN-BOTTOM: 0pt\" class=\"p15\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;土地使用税：按规定标准缴纳，从缴纳土地使用税之月起5年内其市、县分成部分通过财政支出渠道以财政奖励形式全额奖励给企业。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: left; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 24pt; MARGIN-BOTTOM: 0pt\" class=\"p15\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;城市基础设施配套费依法征收后通过财政支出渠道以财政奖励形式全额奖励给企业。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: left; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 24pt; MARGIN-BOTTOM: 0pt\" class=\"p15\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;产品实现销售收入后按规定缴纳的增值税，在项目交地后5年内地方所得市、县分成部分通过财政支出渠道以财政奖励形式全额奖励给企业。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: left; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 24pt; MARGIN-BOTTOM: 0pt\" class=\"p15\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;企业所得税在项目交地后5年内市、县分成部分通过财政支出渠道以财政奖励形式全额奖励给企业。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;发挥财政资金的引导作用。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 30pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">四、流动资金贷款贴息政策</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;完成固定资产投资1亿元以上，对其流动资金贷款由财政给予贴息两年，年贴息额50万元以内。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;加大企业技术改造支持力度：支持重大制造业技术改造。支持小微企业技改。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;支持企业技术创新和节能改造：鼓励企业开发新产品。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;帮扶企业融资：对融资担保机构帮助工业企业融资给予风险补偿。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;积极扶持中小微企业发展。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 22.2pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">五、促进人才引进和集聚政策</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;市、县政府在龙岩市区或工业园区为在工业园区就业的大学毕业生和企业中、高级技术人才、高技能人才配套建设保障性住房，解决大学毕业生和中、高级技术人才、高技能人才的住房问题，以解决企业专业技术人才和技能人才的后顾之忧。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;在龙岩高新技术产业开发区落户的高新技术企业和战略性新兴产业企业引进人才可以享受相应的优惠政策。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;引进高新区的创业创新人才，具有学士、硕士、博士及副高以上专业技术职务等各类紧缺专业人才和其他人才（含各类自主创业的高校毕业生和创业英才），分别享受不同的优惠政策。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;对工业发展紧缺急需的专业人才，享受人才引进的优惠政策。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: justify; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 30pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">六、原辅材料保障政策</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;保障落户园区规模企业的用水、用电供给，价格按有权物价部门批复的最优价执行。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;投资稀土应用产品精深加工的生产性项目，所需的稀土原材料由龙岩市稀土开发有限公司100%保证供给。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: justify; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 30pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\">七、其他</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 15pt; FONT-WEIGHT: bold; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;积极引进总部企业，给予开办补助、办公用房补助、经营贡献奖励、规费返还、人才激励等优惠政策；积极扶持市内现有总部企业发展。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;大力发展主导产业、突出抓好重大项目、扎实推进转型升级、做大做强工业园区。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"TEXT-ALIGN: justify; LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;对重大投资项目实行一事一议。对世界500强和国内100强企业、注册资金在5亿元以上的企业及对我市产业发展具有重要带动作用的项目、固定资产投资1亿元人民币或1000万美元以上的项目以及列入国家高新技术产业发展项目计划的项目，可实行一事一议，研究确定具体优惠政策。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;提升企业增长质量，实行“百家千户”培育工程奖励制度。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 24pt; MARGIN-TOP: 0pt; TEXT-INDENT: 21pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\">●&nbsp;实施“一企一策”：&nbsp;对投资强度大、税收贡献大、带动能力强的工业企业或重大工业项目，可实行“一企一策”的具体奖励和补助政策。</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 12pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"LINE-HEIGHT: 18pt; MARGIN-TOP: 0pt; TEXT-INDENT: 18pt; MARGIN-BOTTOM: 0pt\" class=\"p16\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 9pt; mso-spacerun: &#39;yes&#39;\">（以上摘自龙政综〔2010〕148号《关于推进龙岩汽车工业园建设的实施意见》、龙政综〔2010〕388号《福建（龙岩）稀土工业园鼓励客商投资优惠政策》、龙政综〔2011〕458号《龙岩市人民政府关于促进总部经济发展的实施意见》、龙政综〔2012〕520号《龙岩高新技术产业开发区引进人才优惠政策实施细则》、岩委〔2013〕44号《关于进一步加快工业发展的意见》、龙政综〔2013〕159号《关于帮扶工业稳增长促升级的若干意见》等，详见网址：Http://www.longyan.gov.cn）</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 9pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"MARGIN-TOP: 0pt; MARGIN-BOTTOM: 0pt\" class=\"p15\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 10.5pt; mso-spacerun: &#39;yes&#39;\">&nbsp;</span><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 10.5pt; mso-spacerun: &#39;yes&#39;\"><o:p></o:p></span></p><p style=\"MARGIN-TOP: 0pt; MARGIN-BOTTOM: 0pt\" class=\"p0\"><span style=\"FONT-FAMILY: &#39;宋体&#39;; FONT-SIZE: 10.5pt; mso-spacerun: &#39;yes&#39;\"><o:p>&nbsp;</o:p></span></p><!--EndFragment--><div style=\"POSITION: absolute; WIDTH: 1px; WHITE-SPACE: nowrap; HEIGHT: 1px; OVERFLOW: hidden; TOP: 31px; LEFT: -1000px\" id=\"baidu_pastebin\"><span style=\"LINE-HEIGHT: 0px; DISPLAY: none\" id=\"_baidu_bookmark_start_7\">‍</span></div>', '已发布', null, null, '', null, null, '1', null, '招商引资科', '2014-01-25');
INSERT INTO `web_infomation` VALUES ('141', '56', '龙岩市投资环境', null, null, '', null, '', '', 'null', '2014-03-25 17:18:06', null, '1', '<p></p><p style=\";text-align:center;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">龙岩市投资环境</span></p><p style=\";line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">█&nbsp;&nbsp;市情概况</span></p><p style=\"margin-left:60px;text-indent:36px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;仿宋_GB2312&#39;\">&nbsp;</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市通称闽西，位于福建省西部，地处闽粤赣三省交界，东临厦门、漳州、泉州，南邻广东梅州，西连江西赣州，北接三明。1997年5月撤地设市,现辖新罗区、漳平市和永定、上杭、武平、长汀、连城五县，人口302.55万，总面积1.91万平方公里。</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">2013年，全市实现地区生产总值1479.90</span><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">亿元，增长11.2%；地方财政收入249.14亿元，增长5%。是福建省继福州市、厦门市、泉州市之后第四个财政收入超过200亿元的设区市。</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">2011年9月，龙岩市第四次党代会提出到2015年实现“五个突破、五个翻番”（全市地区生产总值突破2000亿元，规模以上工业总产值突破3000亿元，全社会固定资产投资五年累计突破5000亿元，地方财政收入突破350亿元，社会消费品零售总额突破600亿元；上述5项指标均比2010年翻一番以上）的新目标和打造“五个龙岩”（产业龙岩、创新龙岩、生态龙岩、文化龙岩、民生龙岩）的新任务。2013年市委四届五次全会提出要把龙岩建设成为美丽、开放、幸福的全国生态文明建设先行区、国家可持续发展实验区、闽粤赣边区域性中心城市。</span></p><p style=\"text-indent:30px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;交通便利的邻海城市</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩距离厦门仅138公里，是距离厦门最近的邻海城市。目前，龙岩到厦门走高速公路只需一个半小时左右的车程，乘龙（厦）深动车，到厦门只需1小时，到深圳只需四小时。</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-weight:bold;font-size:16px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;全国著名的革命老区</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是第二次国内革命战争时期中央苏区的重要组成部分，长征出发地之一，所辖七个县（市、区）均为原中央苏区县，享有“二十年红旗不倒”赞誉，是毛泽东思想的重要发祥地。1929年在上杭古田召开红四军第九次党代表大会，会上通过毛泽东起草的《古田会议决议》，是建党建军的纲领性文件。2010年春节，原中共中央总书记、国家主席胡锦涛专程来到龙岩，和老区人民一起过年，在瞻仰古田会议会址时，再次重申“古田会议精神是我们党的宝贵精神财富”。</span></p><p style=\"text-indent:40px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●福建重要的矿区、林区</span></p><p style=\"text-indent: 32px;margin-bottom: 0;margin-top: 0;line-height: 37px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是福建省重要的矿区、林区，素有“金山银水”的美誉。已发现矿物种类64种，其中金、银、铜、铁、无烟煤、高岭土、石灰岩等16种矿物探明储量居福建省首位，马坑铁矿是华东第一大铁矿，紫金山铜矿是全国第二大铜矿，东宫下高岭土是全国四大优质高岭土矿之一，煤炭、稀土储量均超过全省的一半。是福建三大林区之一，森林覆盖率74.3%，居全省首位。2013年被评为中国最具生态竞争力城市，是全国生态文明建设试点城市。</span></p><p style=\"text-indent:40px;margin-right:62px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:62px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●海峡西岸新兴旅游区</span></p><p style=\"text-indent: 32px;margin-bottom: 0;margin-top: 0;line-height: 37px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是福建省新兴的旅游区，是中国最佳生态休闲旅游城市之一。现有1个世界文化遗产（福建土楼之永定土楼群）；6个国家4A级旅游区（永定土楼民俗文化村、龙硿洞、九鹏溪、古田会议会址、冠豸山、长汀红色旧址群旅游区）；1个国家自然遗产和国家重点风景名胜区（冠豸山），2个优秀旅游县（连城县、上杭县）、1个国家工业旅游示范点（紫金工业旅游区）、1个国家历史文化名城（长汀县）、1个国家农业旅游示范点（云顶茶园）、2个国家自然保护区（梅花山、梁野山）、4个国家森林公园（龙岩国家森林公园、上杭西普陀山公园、漳平天台山公园和永定王寿山国家森林公园）以及26个国家重点文物保护单位。福建旅游十大品牌中，龙岩就占2个，即“神秘的客家土楼”和“光辉的古田会议”。以永定客家土楼为代表的“客家之旅”，冠豸山、龙硿洞、九鹏溪、梅花山为代表的“绿色之旅”，古田会议会址为代表的“红色之旅”是享誉海内外的著名旅游精品。</span></p><p style=\"text-indent:24px;margin-right:38px;line-height:32px\"><span style=\";font-size:12px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:24px;margin-right:38px;line-height:32px\"><span style=\";font-size:12px;font-family:&#39;Times New Roman&#39;\">&nbsp;</span></p><p style=\"text-indent:24px;margin-right:38px;line-height:32px\"><span style=\";font-size:12px;font-family:&#39;Times New Roman&#39;\">&nbsp;</span></p><p style=\"margin-left:111px;margin-right:38px;line-height:32px\"><span style=\"font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;</span><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;享誉海内外的客家祖地和著名侨区</span></p><p style=\"text-indent: 32px;margin-bottom: 0;margin-top: 0;line-height: 37px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是客家民系形成的重要起点和重要聚集地。全市80%的人口是客家人，长汀被称为“客家首府”，汀江被誉为“客家母亲河”。有54个姓氏的居民迁往台湾，台湾现有500万客家人中，祖籍龙岩的有70多万人。在外华侨华人、港澳台同胞超过120万人。著名侨领胡文虎先生、中国国民党荣誉主席吴伯雄先生等名人政要的祖籍地就在龙岩。</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\";line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">█&nbsp;&nbsp;投资环境</span></p><p style=\"text-indent:47px;line-height:32px\"><span style=\";font-weight:bold;font-size:16px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;区位交通便利</span></p><p style=\"text-indent:32px;margin-right:2px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">近年来，龙岩大力推进交通基础设施建设，取得了明显成效。龙岩已有冠豸山机场，赣龙、龙梅、鹰厦（龙岩段）、龙厦等4条铁路，厦蓉（龙岩段）、永武、双永等3条高速公路。另有多条高速公路、铁路正在建设，现已“县县通高速公路”，力争2015年实现“县县通快速铁路”。龙岩到厦门、龙岩中心城市到各县（市）两个1小时经济圈已然形成。龙岩将成为海峡西岸东连沿海港口、西拓内陆腹地、北承长三角、南接珠三角的立体交通枢纽。</span></p><p style=\"text-indent:39px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;投资政策优惠&nbsp;</span></p><p style=\"text-indent:32px;margin-right:2px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是全国唯一所辖县（市、区）均为原中央苏区县的地级市。在国务院《关于支持福建省加快建设海峡西岸经济区的若干意见》中，明确提出福建原中央苏区县参照执行西部地区政策。目前，龙岩市梳理出的97项可参照执行西部地区政策项目，已有90项参照执行。2011年5月，福建省委、省政府专门出台了《关于支持和促进革命老区加快发展的若干意见》，在重大产业项目布局、财政资金补助等方面进一步给予倾斜扶持。龙岩还享有福建首个国家可持续发展实验区、全国首个国家可持续发展产业示范基地、国家加工贸易梯度转移重点承接地和国家级经济技术开发区等国家级的优惠政策。同时，龙岩还针对性地出台了加快工业发展、鼓励民间投资、培育总部经济、鼓励企业上市、促进外贸出口等政策措施，努力为企业发展营造更加良好的环境。</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;要素保障有力</span></p><p style=\"text-indent:32px;margin-right:2px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">境内有丰富的矿产资源、森林资源、水力资源和农副产品资源，可为企业提供充足的原辅材料和要素保障。与沿海发达地区相比，龙岩在用电、用地、用工等方面也具有相对优势。</span></p><p style=\"margin-right:50px;line-height:32px\"><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">注：工业用地价格：&nbsp;&nbsp;4-13.6万元/亩</span></p><p style=\"text-indent:28px;margin-right:50px;line-height:32px\"><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">大工业用电价格：0.511&nbsp;-0.6369元/千瓦时</span></p><p style=\"text-indent:28px;margin-right:50px;line-height:32px\"><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">工业用水价格：&nbsp;&nbsp;0.95-1.9元/吨</span></p><p style=\"text-indent:39px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;政府服务高效</span></p><p style=\"text-indent:32px;margin-right:2px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">近年来，在福建省政府系统绩效评估和投资环境监测中，龙岩市得分持续位居全省九个设区市前列，是海峡西岸经济区最受投资者认可的城市之一。优质规范的政务服务，为企业高效运作、成长壮大提供了宽松环境。龙岩行政服务中心主导制订的行政服务标准正式列入国家标准，将在全国推广执行。</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市发展和改革委员会&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-2999266</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市经济贸易委员会&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-2323166</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市对外贸易经济合作局&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-3383111</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市重点项目开发建设管理办公室&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-2339608</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩行政服务中心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-2529086</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:74px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;投资平台完善</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩有良好的投资平台，已经成为全国科技进步先进市，国家可持续发展实验区，全国首个可持续发展产业示范基地和全国东部地区唯一的国家加工贸易梯度转移重点承接地，全市有1个国家级台湾农民创业园、1个国家级经济技术开发区、8个省级工业园，正在全力创建国家高新技术产业开发区。同时，还设立了龙工配件工业园、汽车工业园、光电产业园、不锈钢产业园区、台商投资区等专业园区。</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;人居环境舒适</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩地处南亚热带向中亚热带过渡地带，年平均气温18-20℃，气候温和宜人。以中心城市为核心、县域城市为纽带、中心镇为基础，一体化建设龙岩中心城市与高坎、古蛟、龙雁三个新区，加快构建现代城市体系。典型示范，以点带面，加快建设美丽乡村。龙岩是国家园林城市、福建省森林城市，正全力创建全国文明城市、全国卫生城市、国家环保模范城市、国家森林城市和中国最佳旅游目的地。</span></p><p><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p><br/></p>', '已删除', null, null, '', null, null, '1', null, '招商引资科', '2014-01-25');
INSERT INTO `web_infomation` VALUES ('142', '56', '龙岩市投资环境', null, null, '', null, '', '', 'null', '2014-03-25 17:18:13', null, '1', '<p></p><p style=\";text-align:center;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">龙岩市投资环境</span></p><p style=\";line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">█&nbsp;&nbsp;市情概况</span></p><p style=\"margin-left:60px;text-indent:36px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;仿宋_GB2312&#39;\">&nbsp;</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市通称闽西，位于福建省西部，地处闽粤赣三省交界，东临厦门、漳州、泉州，南邻广东梅州，西连江西赣州，北接三明。1997年5月撤地设市,现辖新罗区、漳平市和永定、上杭、武平、长汀、连城五县，人口302.55万，总面积1.91万平方公里。</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">2013年，全市实现地区生产总值1479.90</span><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">亿元，增长11.2%；地方财政收入249.14亿元，增长5%。是福建省继福州市、厦门市、泉州市之后第四个财政收入超过200亿元的设区市。</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">2011年9月，龙岩市第四次党代会提出到2015年实现“五个突破、五个翻番”（全市地区生产总值突破2000亿元，规模以上工业总产值突破3000亿元，全社会固定资产投资五年累计突破5000亿元，地方财政收入突破350亿元，社会消费品零售总额突破600亿元；上述5项指标均比2010年翻一番以上）的新目标和打造“五个龙岩”（产业龙岩、创新龙岩、生态龙岩、文化龙岩、民生龙岩）的新任务。2013年市委四届五次全会提出要把龙岩建设成为美丽、开放、幸福的全国生态文明建设先行区、国家可持续发展实验区、闽粤赣边区域性中心城市。</span></p><p style=\"text-indent:30px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;交通便利的邻海城市</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩距离厦门仅138公里，是距离厦门最近的邻海城市。目前，龙岩到厦门走高速公路只需一个半小时左右的车程，乘龙（厦）深动车，到厦门只需1小时，到深圳只需四小时。</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-weight:bold;font-size:16px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;全国著名的革命老区</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是第二次国内革命战争时期中央苏区的重要组成部分，长征出发地之一，所辖七个县（市、区）均为原中央苏区县，享有“二十年红旗不倒”赞誉，是毛泽东思想的重要发祥地。1929年在上杭古田召开红四军第九次党代表大会，会上通过毛泽东起草的《古田会议决议》，是建党建军的纲领性文件。2010年春节，原中共中央总书记、国家主席胡锦涛专程来到龙岩，和老区人民一起过年，在瞻仰古田会议会址时，再次重申“古田会议精神是我们党的宝贵精神财富”。</span></p><p style=\"text-indent:40px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:38px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●福建重要的矿区、林区</span></p><p style=\"text-indent: 32px;margin-bottom: 0;margin-top: 0;line-height: 37px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是福建省重要的矿区、林区，素有“金山银水”的美誉。已发现矿物种类64种，其中金、银、铜、铁、无烟煤、高岭土、石灰岩等16种矿物探明储量居福建省首位，马坑铁矿是华东第一大铁矿，紫金山铜矿是全国第二大铜矿，东宫下高岭土是全国四大优质高岭土矿之一，煤炭、稀土储量均超过全省的一半。是福建三大林区之一，森林覆盖率74.3%，居全省首位。2013年被评为中国最具生态竞争力城市，是全国生态文明建设试点城市。</span></p><p style=\"text-indent:40px;margin-right:62px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:62px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●海峡西岸新兴旅游区</span></p><p style=\"text-indent: 32px;margin-bottom: 0;margin-top: 0;line-height: 37px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是福建省新兴的旅游区，是中国最佳生态休闲旅游城市之一。现有1个世界文化遗产（福建土楼之永定土楼群）；6个国家4A级旅游区（永定土楼民俗文化村、龙硿洞、九鹏溪、古田会议会址、冠豸山、长汀红色旧址群旅游区）；1个国家自然遗产和国家重点风景名胜区（冠豸山），2个优秀旅游县（连城县、上杭县）、1个国家工业旅游示范点（紫金工业旅游区）、1个国家历史文化名城（长汀县）、1个国家农业旅游示范点（云顶茶园）、2个国家自然保护区（梅花山、梁野山）、4个国家森林公园（龙岩国家森林公园、上杭西普陀山公园、漳平天台山公园和永定王寿山国家森林公园）以及26个国家重点文物保护单位。福建旅游十大品牌中，龙岩就占2个，即“神秘的客家土楼”和“光辉的古田会议”。以永定客家土楼为代表的“客家之旅”，冠豸山、龙硿洞、九鹏溪、梅花山为代表的“绿色之旅”，古田会议会址为代表的“红色之旅”是享誉海内外的著名旅游精品。</span></p><p style=\"text-indent:24px;margin-right:38px;line-height:32px\"><span style=\";font-size:12px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:24px;margin-right:38px;line-height:32px\"><span style=\";font-size:12px;font-family:&#39;Times New Roman&#39;\">&nbsp;</span></p><p style=\"text-indent:24px;margin-right:38px;line-height:32px\"><span style=\";font-size:12px;font-family:&#39;Times New Roman&#39;\">&nbsp;</span></p><p style=\"margin-left:111px;margin-right:38px;line-height:32px\"><span style=\"font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;</span><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;享誉海内外的客家祖地和著名侨区</span></p><p style=\"text-indent: 32px;margin-bottom: 0;margin-top: 0;line-height: 37px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是客家民系形成的重要起点和重要聚集地。全市80%的人口是客家人，长汀被称为“客家首府”，汀江被誉为“客家母亲河”。有54个姓氏的居民迁往台湾，台湾现有500万客家人中，祖籍龙岩的有70多万人。在外华侨华人、港澳台同胞超过120万人。著名侨领胡文虎先生、中国国民党荣誉主席吴伯雄先生等名人政要的祖籍地就在龙岩。</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\";line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">█&nbsp;&nbsp;投资环境</span></p><p style=\"text-indent:47px;line-height:32px\"><span style=\";font-weight:bold;font-size:16px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;区位交通便利</span></p><p style=\"text-indent:32px;margin-right:2px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">近年来，龙岩大力推进交通基础设施建设，取得了明显成效。龙岩已有冠豸山机场，赣龙、龙梅、鹰厦（龙岩段）、龙厦等4条铁路，厦蓉（龙岩段）、永武、双永等3条高速公路。另有多条高速公路、铁路正在建设，现已“县县通高速公路”，力争2015年实现“县县通快速铁路”。龙岩到厦门、龙岩中心城市到各县（市）两个1小时经济圈已然形成。龙岩将成为海峡西岸东连沿海港口、西拓内陆腹地、北承长三角、南接珠三角的立体交通枢纽。</span></p><p style=\"text-indent:39px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;投资政策优惠&nbsp;</span></p><p style=\"text-indent:32px;margin-right:2px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩是全国唯一所辖县（市、区）均为原中央苏区县的地级市。在国务院《关于支持福建省加快建设海峡西岸经济区的若干意见》中，明确提出福建原中央苏区县参照执行西部地区政策。目前，龙岩市梳理出的97项可参照执行西部地区政策项目，已有90项参照执行。2011年5月，福建省委、省政府专门出台了《关于支持和促进革命老区加快发展的若干意见》，在重大产业项目布局、财政资金补助等方面进一步给予倾斜扶持。龙岩还享有福建首个国家可持续发展实验区、全国首个国家可持续发展产业示范基地、国家加工贸易梯度转移重点承接地和国家级经济技术开发区等国家级的优惠政策。同时，龙岩还针对性地出台了加快工业发展、鼓励民间投资、培育总部经济、鼓励企业上市、促进外贸出口等政策措施，努力为企业发展营造更加良好的环境。</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;要素保障有力</span></p><p style=\"text-indent:32px;margin-right:2px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">境内有丰富的矿产资源、森林资源、水力资源和农副产品资源，可为企业提供充足的原辅材料和要素保障。与沿海发达地区相比，龙岩在用电、用地、用工等方面也具有相对优势。</span></p><p style=\"margin-right:50px;line-height:32px\"><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">注：工业用地价格：&nbsp;&nbsp;4-13.6万元/亩</span></p><p style=\"text-indent:28px;margin-right:50px;line-height:32px\"><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">大工业用电价格：0.511&nbsp;-0.6369元/千瓦时</span></p><p style=\"text-indent:28px;margin-right:50px;line-height:32px\"><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">工业用水价格：&nbsp;&nbsp;0.95-1.9元/吨</span></p><p style=\"text-indent:39px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;政府服务高效</span></p><p style=\"text-indent:32px;margin-right:2px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">近年来，在福建省政府系统绩效评估和投资环境监测中，龙岩市得分持续位居全省九个设区市前列，是海峡西岸经济区最受投资者认可的城市之一。优质规范的政务服务，为企业高效运作、成长壮大提供了宽松环境。龙岩行政服务中心主导制订的行政服务标准正式列入国家标准，将在全国推广执行。</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市发展和改革委员会&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-2999266</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市经济贸易委员会&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-2323166</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市对外贸易经济合作局&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-3383111</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩市重点项目开发建设管理办公室&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-2339608</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩行政服务中心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：0597-2529086</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;margin-right:74px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;投资平台完善</span></p><p style=\"text-indent:32px;margin-right:74px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩有良好的投资平台，已经成为全国科技进步先进市，国家可持续发展实验区，全国首个可持续发展产业示范基地和全国东部地区唯一的国家加工贸易梯度转移重点承接地，全市有1个国家级台湾农民创业园、1个国家级经济技术开发区、8个省级工业园，正在全力创建国家高新技术产业开发区。同时，还设立了龙工配件工业园、汽车工业园、光电产业园、不锈钢产业园区、台商投资区等专业园区。</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p style=\"text-indent:30px;line-height:32px\"><span style=\";font-weight:bold;font-size:20px;font-family:&#39;宋体&#39;\">●&nbsp;人居环境舒适</span></p><p style=\"text-indent:32px;line-height:32px\"><span style=\";font-size:16px;font-family:&#39;宋体&#39;\">龙岩地处南亚热带向中亚热带过渡地带，年平均气温18-20℃，气候温和宜人。以中心城市为核心、县域城市为纽带、中心镇为基础，一体化建设龙岩中心城市与高坎、古蛟、龙雁三个新区，加快构建现代城市体系。典型示范，以点带面，加快建设美丽乡村。龙岩是国家园林城市、福建省森林城市，正全力创建全国文明城市、全国卫生城市、国家环保模范城市、国家森林城市和中国最佳旅游目的地。</span></p><p><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p><span style=\";font-size:14px;font-family:&#39;宋体&#39;\">&nbsp;</span></p><p><br/></p>', '已发布', null, null, '', null, null, '1', null, '招商引资科', '2014-01-25');
INSERT INTO `web_infomation` VALUES ('143', '49', '新龙马启腾M70获多项大客户订单', null, null, 'null', null, '', '', 'null', '2014-03-25 17:47:31', null, '4', '<p style=\"TEXT-ALIGN: left\"><span style=\"FONT-SIZE: 20px\">&nbsp;&nbsp;&nbsp; 今年初，福汽集团正式发布旗下信龙马汽车全新自主小汽车品牌“启腾”。近期，新龙马启腾M70获多项大客户订单，涉及货运、客运、物流等多个领域。同时，福汽启腾正与河南邮政、天津冀津厢式货运CNG、沈阳城市货运等客户进行批量采购业务洽谈。</span></p>', '已发布', null, null, 'upload/20143/1395740686687.jpg', null, null, null, null, '综合科', '2014-01-03');
INSERT INTO `web_infomation` VALUES ('144', '49', '武平县召开重大项目融资对接会', null, null, 'null', null, '', '', 'null', '2014-03-25 18:02:45', null, '2', '<p style=\"TEXT-ALIGN: left\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;&nbsp;&nbsp; 为贯彻省市关于“多渠道增加社会资金供应”的工作部署，武平县于3月20日上午召开龙岩市（武平）重大项目融资对接暨“新三板”挂牌业务培训会。参加本次会议的有省发改委、福建证监局、市发改委等相关领导，兴业银行、全国中小企业股份转让系统有限责任公司、福建兴业证券等金融机构相关人员，全县已投产、成长性好且有融资需求的企业负责人等。会后，省、市金融机构同我县企业之间开展了金融对接活动，目前已有科宝活性石灰、创隆纺织、中恒通等参会企业有意向通过在“新三板”挂牌来解决融资问题。</span></p>', '已发布', null, null, '', null, null, null, null, '综合科', '2014-01-21');

-- ----------------------------
-- Table structure for `web_infoopen`
-- ----------------------------
DROP TABLE IF EXISTS `web_infoopen`;
CREATE TABLE `web_infoopen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `syh` varchar(255) DEFAULT NULL,
  `fl` varchar(255) DEFAULT NULL,
  `fbjg` varchar(255) DEFAULT NULL,
  `fwrq` date DEFAULT NULL,
  `bt` varchar(255) DEFAULT NULL,
  `wh` varchar(255) DEFAULT NULL,
  `ztc` varchar(255) DEFAULT NULL,
  `nr` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_infoopen
-- ----------------------------
INSERT INTO `web_infoopen` VALUES ('1', '3', '3', '3', '2010-10-10', '3', '3', '3', '<p>3</p>');
INSERT INTO `web_infoopen` VALUES ('2', '2', '2', '2', '2010-11-11', '2', '2', '2', '<p>2</p>');

-- ----------------------------
-- Table structure for `web_inforeg`
-- ----------------------------
DROP TABLE IF EXISTS `web_inforeg`;
CREATE TABLE `web_inforeg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) DEFAULT NULL,
  `content` text,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_inforeg
-- ----------------------------
INSERT INTO `web_inforeg` VALUES ('1', '2', '<p>2</p>', '2013-12-28');

-- ----------------------------
-- Table structure for `web_inforeport`
-- ----------------------------
DROP TABLE IF EXISTS `web_inforeport`;
CREATE TABLE `web_inforeport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) DEFAULT NULL,
  `content` text,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_inforeport
-- ----------------------------
INSERT INTO `web_inforeport` VALUES ('1', '111', '<p>111</p>', '2013-07-13');
INSERT INTO `web_inforeport` VALUES ('2', 'test', '<p>test</p>', '2013-07-13');
INSERT INTO `web_inforeport` VALUES ('3', 'test11', '<p>test11</p>', '2013-07-13');

-- ----------------------------
-- Table structure for `web_leader`
-- ----------------------------
DROP TABLE IF EXISTS `web_leader`;
CREATE TABLE `web_leader` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `xm` varchar(50) DEFAULT NULL,
  `bm` varchar(50) DEFAULT NULL,
  `zw` varchar(50) DEFAULT NULL,
  `gznr` varchar(1000) DEFAULT NULL,
  `xb` datetime DEFAULT NULL,
  `zp` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_leader
-- ----------------------------

-- ----------------------------
-- Table structure for `web_leadermail`
-- ----------------------------
DROP TABLE IF EXISTS `web_leadermail`;
CREATE TABLE `web_leadermail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `xm` varchar(50) DEFAULT NULL,
  `lxfs` varchar(50) DEFAULT NULL,
  `bt` varchar(50) DEFAULT NULL,
  `nr` text,
  `sj` datetime DEFAULT NULL,
  `lsh` varchar(50) DEFAULT NULL,
  `cxmm` varchar(50) DEFAULT NULL,
  `zt` varchar(50) DEFAULT NULL,
  `hfyh` varchar(50) DEFAULT NULL,
  `hfnr` text,
  `hfsj` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_leadermail
-- ----------------------------
INSERT INTO `web_leadermail` VALUES ('1', '111', '111', '111', '111', '2013-12-04 16:53:19', null, null, '已答复', null, '随碟附送', '2014-03-16 11:16:00');

-- ----------------------------
-- Table structure for `web_leaderstep`
-- ----------------------------
DROP TABLE IF EXISTS `web_leaderstep`;
CREATE TABLE `web_leaderstep` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pig` bigint(20) DEFAULT NULL,
  `pzyh` varchar(50) DEFAULT NULL,
  `jsyh` varchar(50) DEFAULT NULL,
  `pzyj` text,
  `pzsj` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_leaderstep
-- ----------------------------

-- ----------------------------
-- Table structure for `web_lmph`
-- ----------------------------
DROP TABLE IF EXISTS `web_lmph`;
CREATE TABLE `web_lmph` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `lmmc` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `llcs` bigint(10) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_lmph
-- ----------------------------
INSERT INTO `web_lmph` VALUES ('1', '机构概况', '23');
INSERT INTO `web_lmph` VALUES ('2', '信息公开', '105');
INSERT INTO `web_lmph` VALUES ('3', '网上办事', '36');
INSERT INTO `web_lmph` VALUES ('4', '公众参与', '296');
INSERT INTO `web_lmph` VALUES ('5', '项目建设', '23');

-- ----------------------------
-- Table structure for `web_log`
-- ----------------------------
DROP TABLE IF EXISTS `web_log`;
CREATE TABLE `web_log` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `yhm` varchar(20) DEFAULT NULL,
  `xm` varchar(20) DEFAULT NULL,
  `nr` varchar(100) DEFAULT NULL,
  `sj` datetime DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_log
-- ----------------------------
INSERT INTO `web_log` VALUES ('1', 'admin', 'sss', '用户登录', '2014-02-17 15:17:09', '127.0.0.1');
INSERT INTO `web_log` VALUES ('2', 'admin', 'sss', '用户登录', '2014-02-18 09:02:56', '127.0.0.1');
INSERT INTO `web_log` VALUES ('3', 'admin', 'sss', '用户登录', '2014-02-18 16:03:13', '127.0.0.1');
INSERT INTO `web_log` VALUES ('4', 'admin', 'sss', '用户登录', '2014-02-21 15:42:47', '127.0.0.1');
INSERT INTO `web_log` VALUES ('5', 'admin', 'sss', '用户登录', '2014-02-21 15:43:57', '127.0.0.1');
INSERT INTO `web_log` VALUES ('6', 'admin', 'sss', '用户登录', '2014-02-21 16:55:49', '127.0.0.1');
INSERT INTO `web_log` VALUES ('7', 'admin', 'sss', '用户登录', '2014-02-22 10:22:15', '127.0.0.1');
INSERT INTO `web_log` VALUES ('8', 'admin', 'sss', '用户登录', '2014-02-22 14:56:03', '127.0.0.1');
INSERT INTO `web_log` VALUES ('9', 'admin', 'sss', '用户登录', '2014-02-22 16:12:24', '127.0.0.1');
INSERT INTO `web_log` VALUES ('10', 'admin', 'sss', '用户登录', '2014-02-24 10:05:24', '127.0.0.1');
INSERT INTO `web_log` VALUES ('11', 'admin', 'sss', '用户登录', '2014-02-24 15:10:19', '127.0.0.1');
INSERT INTO `web_log` VALUES ('12', 'admin', 'sss', '用户登录', '2014-02-24 15:16:29', '127.0.0.1');
INSERT INTO `web_log` VALUES ('13', 'admin', 'sss', '用户登录', '2014-02-24 15:19:14', '127.0.0.1');
INSERT INTO `web_log` VALUES ('14', 'admin', 'sss', '用户登录', '2014-02-24 15:21:31', '127.0.0.1');
INSERT INTO `web_log` VALUES ('15', 'admin', 'sss', '用户登录', '2014-02-24 17:43:17', '127.0.0.1');
INSERT INTO `web_log` VALUES ('16', 'admin', 'sss', '用户登录', '2014-02-26 15:24:35', '127.0.0.1');
INSERT INTO `web_log` VALUES ('17', 'admin', 'sss', '用户登录', '2014-03-03 09:46:05', '127.0.0.1');
INSERT INTO `web_log` VALUES ('18', 'admin', 'sss', '用户登录', '2014-03-03 10:52:36', '127.0.0.1');
INSERT INTO `web_log` VALUES ('19', 'admin', 'sss', '用户登录', '2014-03-03 15:11:02', '127.0.0.1');
INSERT INTO `web_log` VALUES ('20', 'admin', 'sss', '用户登录', '2014-03-03 15:16:44', '127.0.0.1');
INSERT INTO `web_log` VALUES ('21', 'admin', 'sss', '用户登录', '2014-03-04 17:17:18', '127.0.0.1');
INSERT INTO `web_log` VALUES ('22', 'admin', 'sss', '用户登录', '2014-03-05 14:26:39', '127.0.0.1');
INSERT INTO `web_log` VALUES ('23', 'admin', 'sss', '用户登录', '2014-03-06 14:42:17', '127.0.0.1');
INSERT INTO `web_log` VALUES ('24', 'admin', 'sss', '用户登录', '2014-03-06 14:47:05', '127.0.0.1');
INSERT INTO `web_log` VALUES ('25', 'admin', 'sss', '用户登录', '2014-03-06 14:49:26', '127.0.0.1');
INSERT INTO `web_log` VALUES ('26', 'admin', 'sss', '用户登录', '2014-03-07 17:13:25', '127.0.0.1');
INSERT INTO `web_log` VALUES ('27', 'admin', 'sss', '用户登录', '2014-03-07 17:16:06', '127.0.0.1');
INSERT INTO `web_log` VALUES ('28', 'admin', 'sss', '用户登录', '2014-03-08 09:22:27', '127.0.0.1');
INSERT INTO `web_log` VALUES ('29', 'admin', 'sss', '用户登录', '2014-03-08 14:40:55', '127.0.0.1');
INSERT INTO `web_log` VALUES ('30', 'admin', 'sss', '用户登录', '2014-03-08 15:57:00', '127.0.0.1');
INSERT INTO `web_log` VALUES ('31', 'admin', 'sss', '用户登录', '2014-03-08 16:52:58', '127.0.0.1');
INSERT INTO `web_log` VALUES ('32', 'admin', 'sss', '用户登录', '2014-03-10 16:19:52', '127.0.0.1');
INSERT INTO `web_log` VALUES ('33', 'admin', 'sss', '用户登录', '2014-03-13 09:39:28', '127.0.0.1');
INSERT INTO `web_log` VALUES ('34', 'admin', 'sss', '用户登录', '2014-03-13 10:52:18', '127.0.0.1');
INSERT INTO `web_log` VALUES ('35', 'admin', 'sss', '用户登录', '2014-03-13 20:54:41', '127.0.0.1');
INSERT INTO `web_log` VALUES ('36', 'admin', 'sss', '用户登录', '2014-03-14 10:14:00', '127.0.0.1');
INSERT INTO `web_log` VALUES ('37', 'admin', 'sss', '用户登录', '2014-03-14 11:53:19', '127.0.0.1');
INSERT INTO `web_log` VALUES ('38', 'admin', 'sss', '用户登录', '2014-03-14 17:51:21', '127.0.0.1');
INSERT INTO `web_log` VALUES ('39', 'admin', 'sss', '用户登录', '2014-03-14 21:11:57', '127.0.0.1');
INSERT INTO `web_log` VALUES ('40', 'admin', 'sss', '用户登录', '2014-03-14 23:03:29', '127.0.0.1');
INSERT INTO `web_log` VALUES ('41', 'admin', 'sss', '用户登录', '2014-03-15 10:38:54', '127.0.0.1');
INSERT INTO `web_log` VALUES ('42', 'admin', 'sss', '用户登录', '2014-03-15 14:57:18', '127.0.0.1');
INSERT INTO `web_log` VALUES ('43', 'admin', 'sss', '用户登录', '2014-03-15 16:40:12', '127.0.0.1');
INSERT INTO `web_log` VALUES ('44', 'admin', 'sss', '用户登录', '2014-03-15 18:22:30', '127.0.0.1');
INSERT INTO `web_log` VALUES ('45', 'admin', 'sss', '用户登录', '2014-03-15 18:28:30', '127.0.0.1');
INSERT INTO `web_log` VALUES ('46', 'admin', 'sss', '用户登录', '2014-03-16 10:23:48', '127.0.0.1');
INSERT INTO `web_log` VALUES ('47', 'admin', 'sss', '用户登录', '2014-03-16 10:39:13', '127.0.0.1');
INSERT INTO `web_log` VALUES ('48', 'admin', 'sss', '用户登录', '2014-03-16 15:06:41', '127.0.0.1');
INSERT INTO `web_log` VALUES ('49', 'admin', 'sss', '用户登录', '2014-03-16 15:21:58', '127.0.0.1');
INSERT INTO `web_log` VALUES ('50', 'admin', 'sss', '用户登录', '2014-03-16 15:44:55', '127.0.0.1');
INSERT INTO `web_log` VALUES ('51', 'admin', 'sss', '用户登录', '2014-03-16 16:32:27', '127.0.0.1');
INSERT INTO `web_log` VALUES ('52', 'admin', 'sss', '用户登录', '2014-03-16 17:39:13', '127.0.0.1');
INSERT INTO `web_log` VALUES ('53', 'admin', 'sss', '用户登录', '2014-03-16 18:08:06', '127.0.0.1');
INSERT INTO `web_log` VALUES ('54', 'admin', 'sss', '用户登录', '2014-03-17 10:03:48', '127.0.0.1');
INSERT INTO `web_log` VALUES ('55', 'admin', 'sss', '用户登录', '2014-03-17 11:00:18', '127.0.0.1');
INSERT INTO `web_log` VALUES ('56', 'admin', 'sss', '用户登录', '2014-03-17 11:29:48', '127.0.0.1');
INSERT INTO `web_log` VALUES ('57', 'admin', 'sss', '用户登录', '2014-03-18 09:32:25', '127.0.0.1');
INSERT INTO `web_log` VALUES ('58', 'admin', 'sss', '用户登录', '2014-03-18 09:53:02', '127.0.0.1');
INSERT INTO `web_log` VALUES ('59', 'admin', 'sss', '用户登录', '2014-03-18 14:14:14', '127.0.0.1');
INSERT INTO `web_log` VALUES ('60', 'admin', 'sss', '用户登录', '2014-03-18 14:17:50', '127.0.0.1');
INSERT INTO `web_log` VALUES ('61', 'admin', 'sss', '用户登录', '2014-03-18 16:40:52', '127.0.0.1');
INSERT INTO `web_log` VALUES ('62', 'admin', 'sss', '用户登录', '2014-03-18 20:07:52', '127.0.0.1');
INSERT INTO `web_log` VALUES ('63', 'admin', 'sss', '用户登录', '2014-03-18 21:00:54', '127.0.0.1');
INSERT INTO `web_log` VALUES ('64', 'admin', 'sss', '用户登录', '2014-03-18 22:46:46', '127.0.0.1');
INSERT INTO `web_log` VALUES ('65', 'admin', 'sss', '用户登录', '2014-03-18 22:47:41', '127.0.0.1');
INSERT INTO `web_log` VALUES ('66', 'admin', 'sss', '用户登录', '2014-03-18 22:48:14', '127.0.0.1');
INSERT INTO `web_log` VALUES ('67', 'admin', 'sss', '用户登录', '2014-03-19 08:43:11', '127.0.0.1');
INSERT INTO `web_log` VALUES ('68', 'admin', 'sss', '用户登录', '2014-03-19 08:45:56', '127.0.0.1');
INSERT INTO `web_log` VALUES ('69', 'admin', 'sss', '用户登录', '2014-03-19 09:16:16', '127.0.0.1');
INSERT INTO `web_log` VALUES ('70', 'admin', 'sss', '用户登录', '2014-03-19 09:24:19', '127.0.0.1');
INSERT INTO `web_log` VALUES ('71', 'admin', 'sss', '用户登录', '2014-03-19 09:41:23', '127.0.0.1');
INSERT INTO `web_log` VALUES ('72', 'admin', 'sss', '用户登录', '2014-03-19 09:43:47', '127.0.0.1');
INSERT INTO `web_log` VALUES ('73', 'admin', 'sss', '用户登录', '2014-03-19 10:19:37', '127.0.0.1');
INSERT INTO `web_log` VALUES ('74', 'admin', 'sss', '用户登录', '2014-03-19 11:36:15', '127.0.0.1');
INSERT INTO `web_log` VALUES ('75', 'admin', 'sss', '用户登录', '2014-03-19 11:47:05', '127.0.0.1');
INSERT INTO `web_log` VALUES ('76', 'admin', 'sss', '用户登录', '2014-03-19 14:24:34', '127.0.0.1');
INSERT INTO `web_log` VALUES ('77', 'admin', 'sss', '用户登录', '2014-03-19 14:56:40', '127.0.0.1');
INSERT INTO `web_log` VALUES ('78', 'admin', 'sss', '用户登录', '2014-03-19 14:58:22', '127.0.0.1');
INSERT INTO `web_log` VALUES ('79', 'admin', 'sss', '用户登录', '2014-03-19 15:05:34', '127.0.0.1');
INSERT INTO `web_log` VALUES ('80', 'admin', 'sss', '用户登录', '2014-03-19 15:11:48', '127.0.0.1');
INSERT INTO `web_log` VALUES ('81', 'admin', 'sss', '用户登录', '2014-03-19 15:22:11', '127.0.0.1');
INSERT INTO `web_log` VALUES ('82', 'admin', 'sss', '用户登录', '2014-03-19 16:14:36', '127.0.0.1');
INSERT INTO `web_log` VALUES ('83', 'admin', 'sss', '用户登录', '2014-03-19 16:18:17', '127.0.0.1');
INSERT INTO `web_log` VALUES ('84', 'admin', 'sss', '用户登录', '2014-03-19 16:23:12', '127.0.0.1');
INSERT INTO `web_log` VALUES ('85', 'admin', 'sss', '用户登录', '2014-03-19 23:09:59', '127.0.0.1');
INSERT INTO `web_log` VALUES ('86', 'admin', 'sss', '用户登录', '2014-03-19 23:26:42', '127.0.0.1');
INSERT INTO `web_log` VALUES ('87', 'admin', 'sss', '用户登录', '2014-03-19 23:35:31', '127.0.0.1');
INSERT INTO `web_log` VALUES ('88', 'admin', 'sss', '用户登录', '2014-03-19 23:42:36', '127.0.0.1');
INSERT INTO `web_log` VALUES ('89', 'admin', 'sss', '用户登录', '2014-03-20 09:47:18', '127.0.0.1');
INSERT INTO `web_log` VALUES ('90', 'admin', 'sss', '用户登录', '2014-03-20 10:12:55', '127.0.0.1');
INSERT INTO `web_log` VALUES ('91', 'admin', 'sss', '用户登录', '2014-03-20 10:16:32', '127.0.0.1');
INSERT INTO `web_log` VALUES ('92', 'admin', 'sss', '用户登录', '2014-03-20 12:09:50', '127.0.0.1');
INSERT INTO `web_log` VALUES ('93', 'admin', 'sss', '用户登录', '2014-03-20 16:27:40', '127.0.0.1');
INSERT INTO `web_log` VALUES ('94', 'admin', 'sss', '用户登录', '2014-03-20 22:10:55', '127.0.0.1');
INSERT INTO `web_log` VALUES ('95', 'admin', 'sss', '用户登录', '2014-03-20 22:29:38', '127.0.0.1');
INSERT INTO `web_log` VALUES ('96', 'admin', 'sss', '用户登录', '2014-03-20 22:30:08', '127.0.0.1');
INSERT INTO `web_log` VALUES ('97', 'admin', 'sss', '用户登录', '2014-03-20 22:30:45', '127.0.0.1');
INSERT INTO `web_log` VALUES ('98', 'admin', 'sss', '用户登录', '2014-03-20 22:32:08', '127.0.0.1');
INSERT INTO `web_log` VALUES ('99', 'admin', 'sss', '用户登录', '2014-03-20 22:33:20', '127.0.0.1');
INSERT INTO `web_log` VALUES ('100', 'admin', 'sss', '用户登录', '2014-03-20 22:33:34', '127.0.0.1');
INSERT INTO `web_log` VALUES ('101', 'admin', 'sss', '用户登录', '2014-03-20 22:33:51', '127.0.0.1');
INSERT INTO `web_log` VALUES ('102', 'admin', 'sss', '用户登录', '2014-03-20 22:34:21', '127.0.0.1');
INSERT INTO `web_log` VALUES ('103', 'admin', 'sss', '用户登录', '2014-03-20 22:34:39', '127.0.0.1');
INSERT INTO `web_log` VALUES ('104', 'admin', 'sss', '用户登录', '2014-03-20 22:35:11', '127.0.0.1');
INSERT INTO `web_log` VALUES ('105', 'admin', 'sss', '用户登录', '2014-03-20 22:35:59', '127.0.0.1');
INSERT INTO `web_log` VALUES ('106', 'admin', 'sss', '用户登录', '2014-03-20 22:36:23', '127.0.0.1');
INSERT INTO `web_log` VALUES ('107', 'admin', 'sss', '用户登录', '2014-03-20 22:44:40', '127.0.0.1');
INSERT INTO `web_log` VALUES ('108', 'admin', 'sss', '用户登录', '2014-03-20 22:57:06', '127.0.0.1');
INSERT INTO `web_log` VALUES ('109', 'admin', 'sss', '用户登录', '2014-03-20 22:58:36', '127.0.0.1');
INSERT INTO `web_log` VALUES ('110', 'admin', 'sss', '用户登录', '2014-03-21 09:14:34', '127.0.0.1');
INSERT INTO `web_log` VALUES ('111', 'admin', 'sss', '用户登录', '2014-03-21 09:22:31', '127.0.0.1');
INSERT INTO `web_log` VALUES ('112', 'admin', 'sss', '用户登录', '2014-03-21 11:07:35', '127.0.0.1');
INSERT INTO `web_log` VALUES ('113', 'admin', 'sss', '用户登录', '2014-03-21 12:03:48', '127.0.0.1');
INSERT INTO `web_log` VALUES ('114', 'admin', 'sss', '用户登录', '2014-03-21 14:25:28', '127.0.0.1');
INSERT INTO `web_log` VALUES ('115', 'admin', 'sss', '用户登录', '2014-03-21 17:03:05', '127.0.0.1');
INSERT INTO `web_log` VALUES ('116', 'admin', 'sss', '用户登录', '2014-03-21 21:33:17', '127.0.0.1');
INSERT INTO `web_log` VALUES ('117', 'admin', 'sss', '用户登录', '2014-03-21 23:33:14', '127.0.0.1');
INSERT INTO `web_log` VALUES ('118', 'admin', 'sss', '用户登录', '2014-03-22 00:16:21', '127.0.0.1');
INSERT INTO `web_log` VALUES ('119', 'admin', 'sss', '用户登录', '2014-03-22 10:52:21', '127.0.0.1');
INSERT INTO `web_log` VALUES ('120', 'admin', 'sss', '用户登录', '2014-03-22 14:01:59', '127.0.0.1');
INSERT INTO `web_log` VALUES ('121', 'admin', 'sss', '用户登录', '2014-03-22 17:11:40', '127.0.0.1');
INSERT INTO `web_log` VALUES ('122', 'admin', 'sss', '用户登录', '2014-03-23 10:15:15', '127.0.0.1');
INSERT INTO `web_log` VALUES ('123', 'admin', 'sss', '用户登录', '2014-03-23 23:41:11', '127.0.0.1');
INSERT INTO `web_log` VALUES ('124', 'admin', 'sss', '用户登录', '2014-03-24 09:49:32', '127.0.0.1');
INSERT INTO `web_log` VALUES ('125', 'admin', 'sss', '用户登录', '2014-03-24 11:19:12', '127.0.0.1');
INSERT INTO `web_log` VALUES ('126', 'admin', 'sss', '用户登录', '2014-03-24 15:14:56', '127.0.0.1');
INSERT INTO `web_log` VALUES ('127', 'admin', 'sss', '用户登录', '2014-03-24 16:39:09', '127.0.0.1');
INSERT INTO `web_log` VALUES ('128', 'admin', 'sss', '用户登录', '2014-03-25 10:16:46', '127.0.0.1');
INSERT INTO `web_log` VALUES ('129', 'admin', 'sss', '用户登录', '2014-03-25 10:16:46', '127.0.0.1');
INSERT INTO `web_log` VALUES ('130', 'admin', 'sss', '用户登录', '2014-03-25 11:14:20', '127.0.0.1');
INSERT INTO `web_log` VALUES ('131', 'admin', 'sss', '用户登录', '2014-03-25 11:17:49', '127.0.0.1');
INSERT INTO `web_log` VALUES ('132', 'admin', 'sss', '用户登录', '2014-03-25 11:27:16', '127.0.0.1');
INSERT INTO `web_log` VALUES ('133', 'admin', 'sss', '用户登录', '2014-03-25 12:46:11', '127.0.0.1');
INSERT INTO `web_log` VALUES ('134', 'admin', 'sss', '用户登录', '2014-03-25 13:55:10', '127.0.0.1');
INSERT INTO `web_log` VALUES ('135', 'admin', 'sss', '用户登录', '2014-03-25 14:13:12', '127.0.0.1');
INSERT INTO `web_log` VALUES ('136', 'admin', 'sss', '用户登录', '2014-03-25 14:18:10', '127.0.0.1');
INSERT INTO `web_log` VALUES ('137', 'admin', 'sss', '用户登录', '2014-03-25 14:48:07', '127.0.0.1');
INSERT INTO `web_log` VALUES ('138', 'admin', 'sss', '用户登录', '2014-03-25 15:07:00', '220.162.162.24');
INSERT INTO `web_log` VALUES ('139', 'admin', '网站管理员', '用户登录', '2014-03-25 15:30:41', '220.162.162.24');
INSERT INTO `web_log` VALUES ('140', 'admin', '网站管理员', '用户登录', '2014-03-25 15:32:38', '220.162.162.24');
INSERT INTO `web_log` VALUES ('141', 'rmk', '人秘科', '用户登录', '2014-03-25 15:34:15', '220.162.162.24');
INSERT INTO `web_log` VALUES ('142', 'rmk', '人秘科', '用户登录', '2014-03-25 15:52:11', '218.67.94.81');
INSERT INTO `web_log` VALUES ('143', 'admin', '网站管理员', '用户登录', '2014-03-25 15:55:04', '218.67.94.87');
INSERT INTO `web_log` VALUES ('144', 'zhk', '综合科', '用户登录', '2014-03-25 15:57:15', '218.67.94.87');
INSERT INTO `web_log` VALUES ('145', 'admin', '网站管理员', '用户登录', '2014-03-25 16:13:17', '218.67.94.87');
INSERT INTO `web_log` VALUES ('146', 'zhk', '综合科', '用户登录', '2014-03-25 16:13:36', '218.67.94.86');
INSERT INTO `web_log` VALUES ('147', 'jsyxk', '建设运行科', '用户登录', '2014-03-25 16:16:02', '218.67.94.80');
INSERT INTO `web_log` VALUES ('148', 'zhk', '综合科', '用户登录', '2014-03-25 16:16:07', '218.67.94.87');
INSERT INTO `web_log` VALUES ('149', 'jsyxk', '建设运行科', '用户登录', '2014-03-25 16:21:21', '218.67.94.89');
INSERT INTO `web_log` VALUES ('150', 'zdxmqqk', '重大项目前期科', '用户登录', '2014-03-25 16:26:05', '218.67.94.84');
INSERT INTO `web_log` VALUES ('151', 'admin', '网站管理员', '用户登录', '2014-03-25 16:30:49', '218.67.94.80');
INSERT INTO `web_log` VALUES ('152', 'zsyzk', '招商引资科', '用户登录', '2014-03-25 16:34:53', '218.67.94.89');
INSERT INTO `web_log` VALUES ('153', 'zdxmqqk', '重大项目前期科', '用户登录', '2014-03-25 16:35:25', '218.67.94.84');
INSERT INTO `web_log` VALUES ('154', 'kfpsk', '开发评审科', '用户登录', '2014-03-25 16:43:13', '218.67.94.93');
INSERT INTO `web_log` VALUES ('155', 'admin', '网站管理员', '用户登录', '2014-03-25 16:44:50', '218.67.94.87');
INSERT INTO `web_log` VALUES ('156', 'jsyxk', '建设运行科', '用户登录', '2014-03-25 16:45:52', '218.67.94.87');
INSERT INTO `web_log` VALUES ('157', 'kfpsk', '开发评审科', '用户登录', '2014-03-25 16:52:54', '218.67.94.93');
INSERT INTO `web_log` VALUES ('158', 'zdxmqqk', '重大项目前期科', '用户登录', '2014-03-25 17:01:07', '218.67.94.84');
INSERT INTO `web_log` VALUES ('159', 'zsyzk', '招商引资科', '用户登录', '2014-03-25 17:04:50', '218.67.94.89');
INSERT INTO `web_log` VALUES ('160', 'zhk', '综合科', '用户登录', '2014-03-25 17:05:13', '218.67.94.87');
INSERT INTO `web_log` VALUES ('161', 'admin', '网站管理员', '用户登录', '2014-03-25 17:06:27', '218.67.94.89');
INSERT INTO `web_log` VALUES ('162', 'zsyzk', '招商引资科', '用户登录', '2014-03-25 17:07:17', '218.67.94.89');
INSERT INTO `web_log` VALUES ('163', 'admin', '网站管理员', '用户登录', '2014-03-25 17:07:48', '218.67.94.89');
INSERT INTO `web_log` VALUES ('164', 'zsyzk', '招商引资科', '用户登录', '2014-03-25 17:09:14', '218.67.94.89');
INSERT INTO `web_log` VALUES ('165', 'zsyzk', '招商引资科', '用户登录', '2014-03-25 17:22:41', '218.67.94.89');
INSERT INTO `web_log` VALUES ('166', 'zhk', '综合科', '用户登录', '2014-03-25 18:00:44', '218.67.94.87');

-- ----------------------------
-- Table structure for `web_model`
-- ----------------------------
DROP TABLE IF EXISTS `web_model`;
CREATE TABLE `web_model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mxbt` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `mxpx` int(11) DEFAULT NULL,
  `xtmr` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `mxurl` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question` varchar(200) DEFAULT NULL,
  `answer` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_question
-- ----------------------------
INSERT INTO `web_question` VALUES ('1', 'xxx', '<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; xxx\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>', '2013-11-11 20:32:59', 'xxx', 'xxxxx');
INSERT INTO `web_question` VALUES ('2', 'www', 'www', '2013-11-04 20:33:26', 'www', 'www');

-- ----------------------------
-- Table structure for `web_role`
-- ----------------------------
DROP TABLE IF EXISTS `web_role`;
CREATE TABLE `web_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `power` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `descr` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ztid` bigint(20) DEFAULT NULL,
  `lmmc` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lmlx` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lmmx` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ljdz` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lmpx` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of web_subcolumn
-- ----------------------------
INSERT INTO `web_subcolumn` VALUES ('4', '0', '重点项目情况通报', 'news', 'null', 'null', '1');
INSERT INTO `web_subcolumn` VALUES ('11', '4', '重点项目情况通报', 'null', '列表模型', 'null', '2');
INSERT INTO `web_subcolumn` VALUES ('12', '0', '重点项目简报', 'fsf', 'null', 'null', '2');
INSERT INTO `web_subcolumn` VALUES ('13', '12', '重点项目简报', 'sfer', '列表模型', 'ewr', '1');
INSERT INTO `web_subcolumn` VALUES ('19', '0', '龙岩市三维项目', null, 'null', null, '3');
INSERT INTO `web_subcolumn` VALUES ('20', '19', '三维项目', null, '列表模型', null, '1');
INSERT INTO `web_subcolumn` VALUES ('21', '0', '党的群众路线教育实践活动', null, 'null', null, '4');
INSERT INTO `web_subcolumn` VALUES ('22', '21', '党的群众路线教育实践活动', null, '列表模型', null, '1');

-- ----------------------------
-- Table structure for `web_subinfo`
-- ----------------------------
DROP TABLE IF EXISTS `web_subinfo`;
CREATE TABLE `web_subinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lmid` bigint(11) DEFAULT NULL,
  `bt` varchar(50) DEFAULT NULL,
  `btys` varchar(50) DEFAULT NULL,
  `fbt` varchar(50) DEFAULT NULL,
  `ljwz` varchar(50) DEFAULT NULL,
  `sx` varchar(50) DEFAULT NULL,
  `zz` varchar(50) DEFAULT NULL,
  `ly` varchar(50) DEFAULT NULL,
  `sj` datetime DEFAULT NULL,
  `dd` varchar(50) DEFAULT NULL,
  `llcs` int(11) DEFAULT NULL,
  `nr` text,
  `zt` varchar(50) DEFAULT NULL,
  `plcs` int(11) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `fbr` varchar(50) DEFAULT NULL,
  `rq` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_subinfo
-- ----------------------------
INSERT INTO `web_subinfo` VALUES ('9', '14', 'kkkxiaxia', null, null, '43gdgr', null, '管理员', null, null, null, null, '<p>fesefsew</p><table><tbody><tr><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td></tr><tr><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td></tr><tr><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td></tr><tr><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td></tr><tr><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td></tr><tr><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td><td valign=\"top\" width=\"136\"><br/></td></tr></tbody></table><p><br/></p>', null, null, null, null, null);
INSERT INTO `web_subinfo` VALUES ('11', '15', 'sdfaerrr', null, null, 'null', null, '管理员', null, null, null, null, '<p>请在这里编辑文章！</p>', null, null, null, null, null);
INSERT INTO `web_subinfo` VALUES ('13', '13', '234kkk', null, null, 'null', null, '管理员', null, null, null, null, '<p>请在这里编辑文章！</p>', null, null, null, null, null);
INSERT INTO `web_subinfo` VALUES ('15', '13', 'qqq', null, null, '', null, '管理员', null, null, null, null, '<p>请在这里编辑文章！</p>', null, null, null, null, null);
INSERT INTO `web_subinfo` VALUES ('16', '17', 'dfsgatrt', null, null, '', null, '管理员', null, null, null, null, '<p>请在这里编辑文章！</p>', null, null, null, null, null);
INSERT INTO `web_subinfo` VALUES ('17', '11', 'ccc', null, null, '', null, '管理员', null, null, null, null, '<p>请在这里编辑文章！</p>', null, null, null, null, null);
INSERT INTO `web_subinfo` VALUES ('18', '11', 'cccc', null, null, '', null, '管理员', null, null, null, null, '<p>请在这里编辑文章！</p>', null, null, null, null, null);
INSERT INTO `web_subinfo` VALUES ('22', '13', '重点项目简报2014年第1期总第33期', null, null, 'null', null, '管理员', null, null, null, null, '<p style=\"LINE-HEIGHT: 16px\">&nbsp;</p><p style=\"LINE-HEIGHT: 39px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">【领导之窗】</span></p><p style=\"LINE-HEIGHT: 39px; TEXT-INDENT: 42px\"><strong><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">省市领导对今年重点项目工作提出新的要求&nbsp;&nbsp;&nbsp; </span></strong><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">2013</span><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">年12月28日，在全省发展改革暨重点项目建设工作视频会议上,对做好今年重点项目工作，省政府常务副省长张志南强调：一要重视项目的前期论证。在项目的可研报告、初步设计、施工图设计等环节，对项目的环评、人员评估、社会稳定风险评估论证一定要充分，尽量优化、尽早规避风险，要在前期深度和质量上下足工夫。二要重视项目的要素保障。资金筹措既要发挥好财政资金四两拨千斤的作用，也要在金融信贷等渠道上充分拓展思路、创新模式，通过资产证券化等多元化投融资方式筹措资金；征地交地要强化属地原则，按照和谐征迁法的要求依法依规做好征迁工作；对项目的用地、用海、建筑材料、火工油品等也要提前谋划、有效保障。三要重视项目的组织协调。主要领导亲自抓，分管领导要到位，切实负起责任，扑下身子抓项目；项目建设单位要科学安排工期，加强工程调度；各级要重视发挥重点办的作用，加强跟踪管理、协调服务和考核督促，把重点项目管好、协调好，特别强调要抓好项目的安全质量和廉政建设。省发改委主任郑栅洁强调：一要落实工作责任；二要保障要素需求；三要加强协调服务；四要提升管理水平；五要强化督促检查。市委常委、市政府常务副市长张天洲就贯彻省会议精神时强调，抓发展就要抓项目，抓项目一定要真抓实干、落实到位。一是要组建项目工作班子。要充分发挥各级重点项目办的作用，明确市重点项目办去协调解决重点项目问题时就是代表市政府去协调。二是组建项目班子时一定要选好项目班子领军人物。三是抓项目要舍得投入人力、物力和精力，要把抓发展抓项目作为各级政府部门的主要工作职责。</span><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 20px\">（本办综合科）</span></p><p style=\"LINE-HEIGHT: 39px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;</span></p><p style=\"LINE-HEIGHT: 39px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">【</span><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">工作动态】</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">我市2014年省重点项目实现“三增长”&nbsp;&nbsp;&nbsp; 一是项目数增长。我市2014年省重点项目142个（不含14个省管项目），为历年来最多，比2013年增加6个，项目数在全省居第三。其中新列项目74个，占52%；二是总投资增长。142个省重点项目总投资1454.9亿元，比2013年增加136.6亿元，其中10亿至30亿元项目44个，30亿元以上项目10个；三是年度计划投资增长。年度计划投资216.8亿元，比2013年增加2亿元。</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">从区域分布看：市直12个，总投资142.2亿元，年度计划投资30.6亿元；新罗区26个，总投资491.8亿元，年度计划投资60.4亿元；永定县13个，总投资112.3亿元，年度计划投资15.4亿元；上杭县12个，总投资55.1亿元，年度计划投资10.3亿元；武平县12个，总投资82.6亿元，年度计划投资22.6亿元?怀ね∠?17个，总投资134.2亿元，年度计划投资23.2亿元；连城县10个，总投资45.7亿元，年度计划投资11.7亿元；漳平市13个，总投资115.3亿元，年度计划投资13.5亿元；龙岩经济技术开发区4个，总投资36.7亿元，年度计划投资7.8亿元；古蛟新区4个，总投资20.5亿元，年度计划投资5.5亿元；永丰新区5个，总投资81.4亿元，年度计划投资5.1亿元；龙雁新区8个，总投资49.4亿元，年度计划投资4.2亿元；福建(龙岩)稀土工业园区4个，总投资74.8亿元，年度计划投资4.6亿元；漳平台湾农民创业园2个，总投资13.1亿元，年度计划投资2亿元。</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">从行业分布看：交通项目6个，总投资63.6亿元，年度计划投资17亿元；工业项目64个，总投资589.9亿元，年度计划投资76.9亿元；农业水利项目10个，总投资68.6亿元，年度计划投资8.6亿元；社会事业项目7个，总投资65亿元，年度计划投资8.9亿元；城建项目6个，总投资107.5亿元，年度计划投资15.3亿元；商贸服务业项目49个，总投资560.2亿元，年度计划投资90.2亿元。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;(本办综合科)</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">我市一批项目和个人荣获省重点建设优胜项目、建设功臣和先进工作者&nbsp;&nbsp;&nbsp; 2013年12月28日，在全省发展改革暨重点项目建设工作视频会上，我市的上杭瓮福紫金湿法净化磷酸和磷酸二铵项目被省人民政府授予“2013年度福建省重点建设项目优胜奖”；福建省金弘达实业有限公司总经理廖仁其同志获得“2013年度福建省重点项目建设功臣”荣誉称号，同时省总工会授予“五一劳动奖章”；我市卢建辉等12位同志获得省发改委、重点办、人社厅、公务员局、总工会授予“2013年度福建省重点项目建设先进工作者”荣誉称号。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（本办综合科）</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">市重点项目办组织开展小分队招商活动&nbsp;&nbsp;&nbsp; 为了加强招商工作，为项目对接打好基础，市重点项目办于2013年11月中旬和12月中旬联合组织市工商联、新罗区招商局、上杭县经贸局、永定县重点项目办、长汀县发改局等部门，分别前往长三角和京津地区开展项目推介等招商活动。招商小分队通过召开座谈会和深入企业调研考察等形式，与上海、苏州、北京、天津等地一批闽西籍新、老企业家朋友进行了友好的交流对接，增进了了解，增强了友谊，并就我市的产业发展特别是汽车产业、稀土产业、铜产业发展进行了探讨，企业家乡贤提出了不少好的发展思路和建议，表达了择机回家乡龙岩考察的愿望。今后，市重点项目办将进一步加强与潜在客商的沟通联系，围绕我市重点产业和一县一优势产业发展规划，认真筛选出一批有针对性的重点招商项目，适时组织招商小分队，强化项目点对点对接，提高招商效果。 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">（本办招商引资科）</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">上杭县多举措推进重点项目建设年终冲刺&nbsp; 一是实地摸底，走访 “上杭紫金山铜金及有色金属矿产资源综合利用示范基地项目”、“ 上杭瓮福蓝天无水氟化氢生产项目”等项目，实地了解情况，鼓足业主干劲，加大项目投资。二是借力考核，结合各牵头、责任单位的年终绩效考核，针对重点项目目标责任任务，与各单位共同解决项目进展难题，寻找新突破点。三是嫁接推广，对取得突破性进展的项目进行认真分析，总结经验，嫁接推广到进度相对较慢的项目中，实现落后项目向前跟上。四是坚持跟进，召集项目工作人员，坚持对项目实时跟进，力争项目进展早知道，项目困难早解决，做好项目推进工作。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （上杭县重点办）</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">开发区领导深入重点项目现场调研&nbsp;&nbsp;&nbsp; 1月3日上午，龙岩经济技术开发区党工委书记陈开明和管委会主任阮满昌在经济发展局的陪同下，走访区内省市重点项目建设工地，了解人才限价房项目二期建设销售、冷链物流建设进展、恒宝城市广场建设进展及数码港招商、南方总部一期的桩机进度、中国农产品物流交易城项目地块水管迁移、中外运的基础建设、陆地港的龙港路后继完善及红田路二期前期工作等情况，与项目建设的施工方和项目业主进行深入地交流，了解项目建设过程中存在的困难和问题，要求开发区相关部门对个别不了解项目建设流程报批的业主进行专门指导，力促省市重点项目在2014年能加快建设步伐。</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;（龙岩经济技术开发区经发局）</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">古蛟新区“四举措”做强红色旅游实现五大跨越&nbsp;&nbsp;&nbsp; 古蛟新区依托丰富的红色文化资源，以“四举措”着力打造“红色圣地 大美古田”旅游品牌。一是完善景区景点建设。在景区游步道旁新增了9个庄重大方、造型生动的红色剪影小品，开工建设和维护红军戏台、红军哨所、红军桥等项目。二是策划重点红色项目。聘请策划大师熊大寻策划古田红色文化体验园（成功之路）项目。2013年共策划生成文化、体验休闲、基础配套等三类项目33个，总投资165亿元。三是研发红色旅游商品。加大红色旅游商品的开发力度，推出了主席像、古田会议会址徽章、会址模型、古田会议决议木雕书等系列旅游产品。四是加强红色教育宣传。通过各类媒体，举办各类专题旅游活动，多形式宣传红色旅游，扩大了市场影响力，提高了景区的知名度和美誉度。实现旅游五大跨越：一是旅游规模从景点到景区的跨越。二是旅游设施从滞后到完善的跨越。三是旅游经营从分散到集聚的跨越。四是旅游管理从传统到现代的跨越。五是旅游收入从单一到多元的跨越。&nbsp; &nbsp;&nbsp;</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">（古蛟新区经发局）</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">【简讯】</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">▲莆永高速公路于2013年12月31日全线通车，龙岩到福州只需3个小时。</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">▲龙岩至深圳北往返动车于2013年12月28日正式开通，龙岩到深圳只需4个小时。</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">▲日前，龙雁经济开发区正式揭牌。总规划面积19.37平方公里，以机械、能源、化工为主导产业，为省级经济开发区。</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">▲近期，我市梅花山入选2013年国家生态旅游示范区名单，成为全国首批“国家生态旅游示范区”之一。 &nbsp;</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">上杭县落户首个医用线缆生产项目，总投资2.1亿元，2014年计划投资8000万元，建设期2年。项目拟由厦门怡和泰电缆有限公司在上杭工业园区投资兴建。 </span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">2013年12月底，上杭客家缘建设项目、上杭紫金山铜金及有色金属矿产资源综合利用示范基地等一批省市重点建设项目集体竣工、投产。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （上杭县发改局）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">▲毛泽东才溪乡调查纪念馆改版提升工程于2013年底正式对外展出，该工程总投资3100万元，总面积3700平方米，共分四个展厅，内容包括三个部分：毛泽东才溪乡调查历史背景，毛泽东才溪乡调查的过程和丰硕成果，毛泽东才溪乡调查的重大影响和深远意义。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （上杭县重点办）</span></p><p>▲福建（龙岩）稀土工业园区110千伏变电站投入运营。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>（福建〔龙岩〕稀土工业园区）</p><p>&nbsp;&nbsp;&nbsp; ▲漳平台创园区规划建设龙岩首个闽台石博园度假农庄项目，总投资约12亿元，占地面积1163.4亩,总建设期为8年。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>（漳平台湾农民创业园经发局）&nbsp;</p><p>▲古田购物街二期主体建筑全面封顶。&nbsp;&nbsp;&nbsp;（古蛟新区经发局）</p><p>▲福建省最大种猪引进项目顺利实施，1450头加拿大进口种猪落户武平闽台农牧合作创业园。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （武平县重点项目办）</p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;</span></p><p><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">&nbsp;</span></p><p style=\"TEXT-INDENT: 43px\"><img src=\"http://211.149.172.65:8080/admin/editor/dialogs/attachment/fileTypeImages/icon_doc.gif\"/><a href=\"http://211.149.172.65:8080/admin/editor/jsp/upload/20140325/8371395739719203.doc\">20140103重点项目简报第1期总第33期.doc</a></p><p style=\"LINE-HEIGHT: 16px\">&nbsp;</p>', '已发布', null, null, '综合科', '2014-01-03');
INSERT INTO `web_subinfo` VALUES ('23', '13', '重点项目简报2014年第3期总第35期', null, null, 'null', null, '管理员', null, null, null, null, '<p><br clear=\"all\"/></p><p style=\"LINE-HEIGHT: 39px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">【工作动态】</span></p><p style=\"TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">国防大学副教育长郑云华一行来岩考察&nbsp;&nbsp;&nbsp; 2月8日～9日，国防大学副教育长郑云华一行到龙岩考察，并实地察看了省重点项目--</span><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">市委党校新校区校址。考察期间，市委书记黄晓炎介绍了龙岩市委党校搬迁建设的有关情况，双方就合作交流及国防大学古田教学基地挂牌仪式方案进行了讨论磋商。郑云华表示，国防大学将尽快办好古田教学基地挂牌这件大事、好事、喜事，与龙岩市一起把古田会议这个红色品牌做大做响。（市委党校迁建办）</span></p><p style=\"TEXT-ALIGN: left; TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">龙岩中心城市立体停车场建设加快&nbsp;&nbsp;&nbsp; 2月14日，陈盛仪副市长主持召开了关于市立体停车场建设及停车管理工作专题会议，各责任单位就目前立体停车场建设、停车管理工作情况作了汇报。目前，首批10个立体停车场建设项目中，北市场立体停车场作为第一个项目于2013年7月开工建设，现已完成基础浇筑，准备进行设备安装，预计今年5月份可建成使用；体育中心南侧立体停车场项目，正在进行地质勘察，预计今年年底可建成投入使用；西兴桥和登高西路两个出让地停车场建设项目，正在土地部门办理土地出让手续；其他6个项目正在进行征地拆迁。会议要求，各责任单位、责任人要在新年伊始就全面推进立体停车场建设，大力做好停车管理工作，尽快缓解市中心城市停车难的问题。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p><p style=\"TEXT-ALIGN: right; TEXT-INDENT: 40px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">（城市骨干路网项目组）</span></p><p style=\"TEXT-ALIGN: left; TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">永定县2014年开展重点项目建设“977行动计划”&nbsp;&nbsp;&nbsp; 即：抓好90个县重点项目（其中省市重点项目29个），总投资771.43亿元，完成年度投资77.31亿元以上。力争20个以上项目实现竣工或部分投产，30个以上项目实现开工建设，重点推进18个重大前期项目。90个重点项目中，工业项目34个，旅游文化产业项目19个，农林水项目10个，商贸物流项目2个，城镇民生项目18个，交通建设项目7个。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（永定县重点项目办）</span></p><p style=\"TEXT-ALIGN: left; TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">上杭县重点项目开工建设实现开门红&nbsp;&nbsp;&nbsp; 1月份，上杭县南门大桥开工建设，该桥属上杭城区汀江三桥（南门大桥、张滩大桥、潭头大桥）及道路接线工程之一，是连接上杭城区与南岗片区的重要过江通道，为全市单跨最大的市政?帕海畲罂缍?138米，桥长275米，宽33米，接线工程全长389.6米，目前已完成便桥建设，旧桥已拆除，正推进桥体孔桩浇筑。另有上杭傲农高效生物饲料生产项目一期年产20万吨高效生物饲料生产线主体厂房开工建设，该项目采用国内超微粉碎技术和工艺流程，总投资20054万元，年度计划投资8000万元；上杭客家新天地建筑博览园旅游建设项目开工建设，该项目总投资15亿元，年度计划投资4.8?谠钅拷ㄖ婊?40万平方米，以客家风情、客家文化为主导，建设博览园、圆楼、五凤楼（客家历史陈列馆）、方楼、九厅十八井等客家风格的建筑群，客家旅游小镇并配套建设高星级酒店及游客接待中心等服务设施，是集休闲、会议、度假于一体的综合性旅游度假区和宜居新城。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（上杭县重点办）</span></p><p style=\"TEXT-ALIGN: left; TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">连城县加快推进省级农民创业园省市重点项目建设&nbsp;&nbsp;&nbsp;&nbsp; 连城县抓住农创园被省里列为省级农民创业园的机遇，以重点项目建设为抓手，强化政策拉动、服务推动，全力推进农创园建设。连城县对农创园项目实行“一个产业、一套班子、一项政策”工作机制，优先申报省市重点项目、优先提供项目用地、代办用地用林审批、设立配套专项扶持资金，并在基础设施、税费减免、地价优惠、电价优惠、品牌创建、科技创新、融资担保等方面予以大力扶持。2014年连城农创园有原态农业白鸭产业化、茂景生态花木园区、海西（连城）农产品电子商务中心、龙跃食品物流中心四个项目列为省市重点建设项目。目前，原态农业、茂景生态二个在建项目正按年度计划顺利实施，农产品电子商务中心、龙跃食品物流中心二个新项目用地均已落实，有望提前开工建设。</span></p><p style=\"TEXT-ALIGN: right; TEXT-INDENT: 40px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">（连城县重点办）</span></p><p style=\"TEXT-ALIGN: left; TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">永丰新区举办新春劳务供需会&nbsp;&nbsp;&nbsp; 为服务新龙马微客、德泓光电、畅丰等重点项目，促进重点项目尽快达产，2月8日，永定县政府和永丰新区管委会在永丰新区联合举办2014年新春劳务供需见面会，新龙马、德泓光电等42家企业参加了供需会，提供就业岗位4300多个，5600多人参加供需会，3182人现场初步达成签约意向，其中返乡回流就业人数1290人。 （永丰新区经济发展局）</span></p><p style=\"TEXT-ALIGN: left\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">【经验做法】</span></p><p style=\"TEXT-ALIGN: left; TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">永定县出台《永定县重点项目专职特派员管理办法》&nbsp;&nbsp;&nbsp; 为推进项目建设，加快永定转型升级步伐，进一步健全重点项目专职特派员选派、管理和考核机制，发挥干部在服务项目建设、服务转型升级中的作用，树立正确导向，近期，永定县出台了《永定县重点项目专职特派员管理办法》。《办法》进一步明确规定了专职特派员的推荐选派办法和程序，专职特派员实行县委组织部、县重点项目办、项目责任单位三重管理和业务培训、工作日志、一线工作、定期汇报、服务承诺五项制度，进一步明确了专职特派员工作职责和职权，以及专职特派员的考核管理等内容。</span></p><p style=\"TEXT-ALIGN: right; TEXT-INDENT: 40px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">（永定县重点项目办）</span></p><p style=\"LINE-HEIGHT: 39px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">【简讯】</span></p><p style=\"TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">▲厦蓉高速改扩建工程初步设计1月份获交通运输部批复。</span></p><p style=\"TEXT-INDENT: 64px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">全长3450米的赣龙铁路新古田隧道1月24日贯通。</span></p><p style=\"TEXT-INDENT: 64px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">长汀汀江国家湿地公园获国家林业局批准开展试点工作。</span></p><p style=\"TEXT-INDENT: 43px\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 21px\">▲紫金山体育公园项目接待中心正式对外开放。</span></p><p style=\"TEXT-ALIGN: right\"><span style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 20px\">（新罗区重点项目办）</span></p><p>&nbsp;</p><p style=\"LINE-HEIGHT: 16px\"><img src=\"http://211.149.172.65:8080/admin/editor/jsp/upload/1395741205906.gif\"/><a href=\"http://211.149.172.65:8080/admin/editor/jsp/upload/20140325/6651395740926906.doc\">20140224重点项目简报第3期总第35期.doc</a></p><p>&nbsp;</p>', '已发布', null, null, '综合科', '2014-01-24');

-- ----------------------------
-- Table structure for `web_suggestion`
-- ----------------------------
DROP TABLE IF EXISTS `web_suggestion`;
CREATE TABLE `web_suggestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `xm` varchar(50) DEFAULT NULL,
  `lxfs` varchar(50) DEFAULT NULL,
  `bt` varchar(50) DEFAULT NULL,
  `nr` varchar(1000) DEFAULT NULL,
  `sj` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_suggestion
-- ----------------------------
INSERT INTO `web_suggestion` VALUES ('1', 'xx', '新罗区', '加油', '加油', '2013-11-12 17:58:43');
INSERT INTO `web_suggestion` VALUES ('3', '中文', 'erwerf', 'sdfa', 'sdfweewfr', null);

-- ----------------------------
-- Table structure for `web_url`
-- ----------------------------
DROP TABLE IF EXISTS `web_url`;
CREATE TABLE `web_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mc` varchar(200) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  `pxh` int(4) DEFAULT '0',
  `lb` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_url
-- ----------------------------

-- ----------------------------
-- Table structure for `web_user`
-- ----------------------------
DROP TABLE IF EXISTS `web_user`;
CREATE TABLE `web_user` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `yhm` varchar(20) DEFAULT NULL,
  `xm` varchar(20) DEFAULT NULL,
  `mm` varchar(20) DEFAULT NULL,
  `tswt` varchar(50) DEFAULT NULL,
  `tsda` varchar(50) DEFAULT NULL,
  `yx` varchar(50) DEFAULT NULL,
  `dh` varchar(50) DEFAULT NULL,
  `qx` varchar(500) DEFAULT NULL,
  `dlsj` datetime DEFAULT NULL,
  `scdlsj` datetime DEFAULT NULL,
  `dlcs` int(4) DEFAULT NULL,
  `zt` int(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_user
-- ----------------------------
INSERT INTO `web_user` VALUES ('5', 'admin', '网站管理员', '123456', null, null, '', '', ',lm40,lm45,lm46,lm47,lm48,lm41,lm49,lm50,lm51,lm75,lm60,lm61,lm42,lm62,lm63,lm64,lm67,lm69,lm70,lm71,lm44,lm56,lm57,lm58,lm59,lm73,lm74,zt4,zt11,zt12,zt13,zt19,zt20,zt21,zt22,shfb,@zf,@gz,@fz,@xt,', null, null, null, '1');
INSERT INTO `web_user` VALUES ('6', 'rmk', '人秘科', '123456', null, null, '', '', 'lm40lm45lm46lm47lm48lm41lm49lm50lm51lm75lm60lm61lm42lm62lm63shfb@zf@gz@fz', null, null, null, '1');
INSERT INTO `web_user` VALUES ('7', 'zhk', '综合科', '123456', null, null, '', '', ',lm40,lm45,lm46,lm47,lm48,lm41,lm49,lm50,zt12,zt13,shfb,', null, null, null, '1');
INSERT INTO `web_user` VALUES ('8', 'kfpsk', '开发评审科', '123456', null, null, '', '', 'lm64lm67lm69lm70lm71shfb', null, null, null, '1');
INSERT INTO `web_user` VALUES ('9', 'zsyzk', '招商引资科', '123456', null, null, '', '', ',lm44,lm56,lm57,lm58,lm59,lm73,lm74,zt19,zt20,shfb,', null, null, null, '1');
INSERT INTO `web_user` VALUES ('10', 'jsyxk', '建设运行科', '123456', null, null, '', '', 'lm64lm67lm69lm70lm71shfb', null, null, null, '1');
INSERT INTO `web_user` VALUES ('11', 'dctjk', '督查推进科', '123456', null, null, '', '', 'lm64lm67lm69lm70lm71shfb', null, null, null, '1');
INSERT INTO `web_user` VALUES ('12', 'zdxmqqk', '重大项目前期科', '123456', null, null, '', '', ',lm44,lm59,shfb,', null, null, null, '1');

-- ----------------------------
-- Table structure for `web_vote`
-- ----------------------------
DROP TABLE IF EXISTS `web_vote`;
CREATE TABLE `web_vote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `zt` varchar(200) DEFAULT NULL,
  `nr` text,
  `kssj` datetime DEFAULT NULL,
  `jssj` datetime DEFAULT NULL,
  `yhm` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_vote
-- ----------------------------
INSERT INTO `web_vote` VALUES ('5', '正式调查', '正式的调查', '2013-12-07 00:00:00', '2013-12-08 00:00:00', null);
INSERT INTO `web_vote` VALUES ('6', '第二次正式调查t', '第二次正式调查', '2013-12-11 00:00:00', '2013-12-12 00:00:00', null);
INSERT INTO `web_vote` VALUES ('7', 'ddddd', 'sdfsfdaadf', '2014-03-17 00:00:00', '2014-03-25 00:00:00', null);
INSERT INTO `web_vote` VALUES ('8', 'sfs', 'ewrwe', '2014-03-11 00:00:00', '2014-03-25 00:00:00', null);
INSERT INTO `web_vote` VALUES ('9', 'sdfwewrs', 'aewerwq', '2014-03-26 00:00:00', '2014-03-18 00:00:00', null);
INSERT INTO `web_vote` VALUES ('10', 'werwvddxc', 'sdfsfa', '2014-03-12 00:00:00', '2014-03-21 00:00:00', null);
INSERT INTO `web_vote` VALUES ('11', '第三方撒', '', '2014-03-11 00:00:00', '2014-03-18 00:00:00', null);
INSERT INTO `web_vote` VALUES ('12', '请问', '', '2014-03-18 00:00:00', '2014-03-19 00:00:00', null);
INSERT INTO `web_vote` VALUES ('13', 'sdfsdf', 'sdfasf', '2014-03-11 00:00:00', '2014-03-26 00:00:00', null);
INSERT INTO `web_vote` VALUES ('14', '11', '111', '2014-03-11 00:00:00', '2014-03-19 00:00:00', null);
INSERT INTO `web_vote` VALUES ('15', '算法', '32131', '2014-03-19 00:00:00', '2014-03-20 00:00:00', null);

-- ----------------------------
-- Table structure for `web_voteanswer`
-- ----------------------------
DROP TABLE IF EXISTS `web_voteanswer`;
CREATE TABLE `web_voteanswer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wtid` bigint(20) DEFAULT NULL,
  `da` varchar(200) DEFAULT NULL,
  `ps` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_voteanswer
-- ----------------------------
INSERT INTO `web_voteanswer` VALUES ('7', '4', '好', '0');
INSERT INTO `web_voteanswer` VALUES ('8', '4', '不好', '1');
INSERT INTO `web_voteanswer` VALUES ('9', '5', '你', '0');
INSERT INTO `web_voteanswer` VALUES ('10', '5', '我', '0');
INSERT INTO `web_voteanswer` VALUES ('11', '5', '他', '0');
INSERT INTO `web_voteanswer` VALUES ('17', '8', '对', '0');
INSERT INTO `web_voteanswer` VALUES ('18', '8', '不对', '0');
INSERT INTO `web_voteanswer` VALUES ('19', '9', '龙岩', '0');
INSERT INTO `web_voteanswer` VALUES ('20', '9', '北京', '1');
INSERT INTO `web_voteanswer` VALUES ('21', '9', '上海', '0');
INSERT INTO `web_voteanswer` VALUES ('22', '10', 'w', '0');
INSERT INTO `web_voteanswer` VALUES ('23', '10', 'w', '0');
INSERT INTO `web_voteanswer` VALUES ('24', '11', '3', '0');
INSERT INTO `web_voteanswer` VALUES ('25', '11', '4', '0');
INSERT INTO `web_voteanswer` VALUES ('26', '12', 'ewsfe', '0');
INSERT INTO `web_voteanswer` VALUES ('27', '12', 'sdf', '0');
INSERT INTO `web_voteanswer` VALUES ('28', '13', 'werw', '0');
INSERT INTO `web_voteanswer` VALUES ('29', '13', 'wer3', '0');
INSERT INTO `web_voteanswer` VALUES ('32', '15', '1', '0');
INSERT INTO `web_voteanswer` VALUES ('33', '15', '1', '0');
INSERT INTO `web_voteanswer` VALUES ('34', '16', '2', '0');
INSERT INTO `web_voteanswer` VALUES ('35', '16', '2', '0');
INSERT INTO `web_voteanswer` VALUES ('36', '17', '123', '0');
INSERT INTO `web_voteanswer` VALUES ('37', '17', '123', '0');
INSERT INTO `web_voteanswer` VALUES ('38', '18', '2342', '0');
INSERT INTO `web_voteanswer` VALUES ('39', '18', '2343', '0');
INSERT INTO `web_voteanswer` VALUES ('43', '21', 'sdfas', '0');
INSERT INTO `web_voteanswer` VALUES ('44', '21', 'sdfsa', '0');
INSERT INTO `web_voteanswer` VALUES ('45', '22', 'werwe', '0');
INSERT INTO `web_voteanswer` VALUES ('46', '22', 'ssdfs', '0');
INSERT INTO `web_voteanswer` VALUES ('47', '23', '1', '0');
INSERT INTO `web_voteanswer` VALUES ('48', '23', '1', '0');
INSERT INTO `web_voteanswer` VALUES ('49', '24', '撒飞洒', '0');
INSERT INTO `web_voteanswer` VALUES ('50', '24', '违法', '0');
INSERT INTO `web_voteanswer` VALUES ('51', '25', '收费为撒', '0');
INSERT INTO `web_voteanswer` VALUES ('52', '25', '法尔', '0');

-- ----------------------------
-- Table structure for `web_voteitem`
-- ----------------------------
DROP TABLE IF EXISTS `web_voteitem`;
CREATE TABLE `web_voteitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dcid` bigint(20) DEFAULT NULL,
  `wt` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_voteitem
-- ----------------------------
INSERT INTO `web_voteitem` VALUES ('4', '5', '好不好', '1', '1');
INSERT INTO `web_voteitem` VALUES ('5', '5', '谁', '2', '2');
INSERT INTO `web_voteitem` VALUES ('8', '6', '对不对', '1', '1');
INSERT INTO `web_voteitem` VALUES ('9', '6', '在哪', '2', '2');
INSERT INTO `web_voteitem` VALUES ('10', '7', 'eee', '333', '1');
INSERT INTO `web_voteitem` VALUES ('11', '7', 'e', '23', '2');
INSERT INTO `web_voteitem` VALUES ('12', '8', 'sfdw', '3', '1');
INSERT INTO `web_voteitem` VALUES ('13', '9', 'erw', '1', '1');
INSERT INTO `web_voteitem` VALUES ('15', '11', '1', '1', '1');
INSERT INTO `web_voteitem` VALUES ('16', '11', '2', '2', '2');
INSERT INTO `web_voteitem` VALUES ('17', '12', '3424', '1', '1');
INSERT INTO `web_voteitem` VALUES ('18', '12', '2342', '1', '2');
INSERT INTO `web_voteitem` VALUES ('21', '13', 'sdfa', '1', '1');
INSERT INTO `web_voteitem` VALUES ('22', '10', 'aerafsdf', '3', '1');
INSERT INTO `web_voteitem` VALUES ('23', '14', '而发生', '1', '1');
INSERT INTO `web_voteitem` VALUES ('24', '15', 'ewf', '2', '1');
INSERT INTO `web_voteitem` VALUES ('25', '15', '二娃', '3', '2');

-- ----------------------------
-- Table structure for `web_voteuser`
-- ----------------------------
DROP TABLE IF EXISTS `web_voteuser`;
CREATE TABLE `web_voteuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dcid` bigint(20) DEFAULT NULL,
  `xm` varchar(50) DEFAULT NULL,
  `lxfs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_voteuser
-- ----------------------------
