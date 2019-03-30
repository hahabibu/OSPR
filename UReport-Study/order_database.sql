/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : dada-report

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-13 15:36:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `master_id` varchar(40) DEFAULT NULL COMMENT '明细对应主表id',
  `prod_id` varchar(40) DEFAULT NULL COMMENT '商品id',
  `quantity` int(10) DEFAULT NULL COMMENT '处理数量',
  `unit_price` double(10,2) DEFAULT NULL COMMENT '商品单价',
  `amount` double(10,2) DEFAULT NULL COMMENT '当前明细总额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('e342da016aec444f9eb4b3a92dfa21a5', '42f074b594b1464ba2c4f717328965ce', '1', '3.90', '3.90');
INSERT INTO `order_detail` VALUES ('e342da016aec444f9eb4b3a92dfa21a5', 'e6ab4a0d2b1447abbae44e24e06d9b6b', '1', '23.50', '23.50');
INSERT INTO `order_detail` VALUES ('e7fcf44910844ee7b4b781aff62c8391', '65e13ada22ea47729353a487dd299945', '1', '6.90', '6.90');
INSERT INTO `order_detail` VALUES ('e7fcf44910844ee7b4b781aff62c8391', '0f5e6469bb654097b5c1f871ab084809', '6', '69.90', '419.40');
INSERT INTO `order_detail` VALUES ('e7fcf44910844ee7b4b781aff62c8391', '376a14f67a924841acacf43f499d22ba', '4', '4999.90', '19999.60');
INSERT INTO `order_detail` VALUES ('e7fcf44910844ee7b4b781aff62c8391', '1208de2d0c4d42d7b10c01c4f4da761f', '9', '399.90', '3599.10');
INSERT INTO `order_detail` VALUES ('991a8c01596d4ff594f0c0232969b3fc', '1208de2d0c4d42d7b10c01c4f4da761f', '6', '399.90', '2399.40');
INSERT INTO `order_detail` VALUES ('991a8c01596d4ff594f0c0232969b3fc', 'e6ab4a0d2b1447abbae44e24e06d9b6b', '7', '23.50', '164.50');
INSERT INTO `order_detail` VALUES ('991a8c01596d4ff594f0c0232969b3fc', '364108d902844c9384a539b5f67c7dc8', '9', '1.90', '17.10');
INSERT INTO `order_detail` VALUES ('991a8c01596d4ff594f0c0232969b3fc', '42f074b594b1464ba2c4f717328965ce', '5', '3.90', '19.50');
INSERT INTO `order_detail` VALUES ('991a8c01596d4ff594f0c0232969b3fc', 'd8478ab4e9654af2b32da719087cdea2', '1', '299.90', '299.90');
INSERT INTO `order_detail` VALUES ('991a8c01596d4ff594f0c0232969b3fc', '2e22e515d0b346789082e6a1c9ebeec3', '1', '39.90', '39.90');
INSERT INTO `order_detail` VALUES ('991a8c01596d4ff594f0c0232969b3fc', '46e0ab7574fe42ecbc7838cff0e356ab', '10', '4.90', '49.00');
INSERT INTO `order_detail` VALUES ('8061d794a5cc4b609871a364f7b2c9c3', 'd8478ab4e9654af2b32da719087cdea2', '10', '299.90', '2999.00');
INSERT INTO `order_detail` VALUES ('8061d794a5cc4b609871a364f7b2c9c3', 'e6ab4a0d2b1447abbae44e24e06d9b6b', '1', '23.50', '23.50');
INSERT INTO `order_detail` VALUES ('8061d794a5cc4b609871a364f7b2c9c3', '154767bd90f745d5816399bd2d941b14', '8', '26.50', '212.00');
INSERT INTO `order_detail` VALUES ('8061d794a5cc4b609871a364f7b2c9c3', '75115f84d9da423f92d990f1d4a4379b', '1', '3.90', '3.90');
INSERT INTO `order_detail` VALUES ('8061d794a5cc4b609871a364f7b2c9c3', '0f5e6469bb654097b5c1f871ab084809', '2', '69.90', '139.80');
INSERT INTO `order_detail` VALUES ('8061d794a5cc4b609871a364f7b2c9c3', '42f074b594b1464ba2c4f717328965ce', '3', '3.90', '11.70');
INSERT INTO `order_detail` VALUES ('13efea833e7646d6ab3546f28e4d58c4', 'e6ab4a0d2b1447abbae44e24e06d9b6b', '7', '23.50', '164.50');
INSERT INTO `order_detail` VALUES ('13efea833e7646d6ab3546f28e4d58c4', '0bddf95f1d7d40849f251d7b8f169756', '6', '24.50', '147.00');
INSERT INTO `order_detail` VALUES ('5902cc1845ff4e029dbcfbc80abd43bf', '42f074b594b1464ba2c4f717328965ce', '6', '3.90', '23.40');
INSERT INTO `order_detail` VALUES ('65f3bce9c1384c5894600a35fb081c19', '97efab7b824c4bde921a22aa27e495f2', '6', '3.90', '23.40');
INSERT INTO `order_detail` VALUES ('65f3bce9c1384c5894600a35fb081c19', '376a14f67a924841acacf43f499d22ba', '1', '4999.90', '4999.90');
INSERT INTO `order_detail` VALUES ('65f3bce9c1384c5894600a35fb081c19', '2e22e515d0b346789082e6a1c9ebeec3', '5', '39.90', '199.50');
INSERT INTO `order_detail` VALUES ('65f3bce9c1384c5894600a35fb081c19', 'e1cf8247178e400fbf68270aa695866f', '5', '9.90', '49.50');
INSERT INTO `order_detail` VALUES ('65f3bce9c1384c5894600a35fb081c19', 'd8478ab4e9654af2b32da719087cdea2', '2', '299.90', '599.80');
INSERT INTO `order_detail` VALUES ('65f3bce9c1384c5894600a35fb081c19', '154767bd90f745d5816399bd2d941b14', '10', '26.50', '265.00');
INSERT INTO `order_detail` VALUES ('65f3bce9c1384c5894600a35fb081c19', '1208de2d0c4d42d7b10c01c4f4da761f', '4', '399.90', '1599.60');
INSERT INTO `order_detail` VALUES ('8eadd9af46b840f78233de9a8b52487d', '65e13ada22ea47729353a487dd299945', '10', '6.90', '69.00');
INSERT INTO `order_detail` VALUES ('8eadd9af46b840f78233de9a8b52487d', '1208de2d0c4d42d7b10c01c4f4da761f', '6', '399.90', '2399.40');
INSERT INTO `order_detail` VALUES ('8eadd9af46b840f78233de9a8b52487d', '75115f84d9da423f92d990f1d4a4379b', '2', '3.90', '7.80');
INSERT INTO `order_detail` VALUES ('8eadd9af46b840f78233de9a8b52487d', '8298c8452a1248688e5cbfa058289bf8', '1', '59.90', '59.90');
INSERT INTO `order_detail` VALUES ('8eadd9af46b840f78233de9a8b52487d', 'e1cf8247178e400fbf68270aa695866f', '1', '9.90', '9.90');
INSERT INTO `order_detail` VALUES ('621c01284e0c4128be0bf5a2c8c92541', 'fab01f7aa2274eb9994d69887608234d', '3', '3.90', '11.70');
INSERT INTO `order_detail` VALUES ('621c01284e0c4128be0bf5a2c8c92541', 'e6ab4a0d2b1447abbae44e24e06d9b6b', '2', '23.50', '47.00');
INSERT INTO `order_detail` VALUES ('621c01284e0c4128be0bf5a2c8c92541', '46e0ab7574fe42ecbc7838cff0e356ab', '8', '4.90', '39.20');
INSERT INTO `order_detail` VALUES ('621c01284e0c4128be0bf5a2c8c92541', 'c9458bd95b144853a8cf9f3db7fdf03f', '1', '35.50', '35.50');
INSERT INTO `order_detail` VALUES ('621c01284e0c4128be0bf5a2c8c92541', '2e22e515d0b346789082e6a1c9ebeec3', '3', '39.90', '119.70');
INSERT INTO `order_detail` VALUES ('621c01284e0c4128be0bf5a2c8c92541', '65e13ada22ea47729353a487dd299945', '4', '6.90', '27.60');
INSERT INTO `order_detail` VALUES ('621c01284e0c4128be0bf5a2c8c92541', '0527a136d3754fa4aeba3ef8bac38dff', '10', '3.90', '39.00');
INSERT INTO `order_detail` VALUES ('400069ba80954d3c926eced818a27f7c', 'c9458bd95b144853a8cf9f3db7fdf03f', '4', '35.50', '142.00');
INSERT INTO `order_detail` VALUES ('400069ba80954d3c926eced818a27f7c', '154767bd90f745d5816399bd2d941b14', '8', '26.50', '212.00');
INSERT INTO `order_detail` VALUES ('400069ba80954d3c926eced818a27f7c', '0527a136d3754fa4aeba3ef8bac38dff', '7', '3.90', '27.30');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `master_id` varchar(40) DEFAULT NULL COMMENT '订单主表id',
  `order_num` varchar(40) DEFAULT NULL COMMENT '订单编号',
  `customer_name` varchar(100) DEFAULT NULL COMMENT '对应顾客(顾客名称)',
  `handle_time` datetime DEFAULT NULL COMMENT '订单处理时间',
  `handle_status` varchar(40) DEFAULT NULL COMMENT '订单处理状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('e342da016aec444f9eb4b3a92dfa21a5', '7643426589', '汝弘', '1974-08-31 00:00:00', '预订');
INSERT INTO `order_master` VALUES ('e7fcf44910844ee7b4b781aff62c8391', '4910655585', '段奇', '2005-02-18 00:00:00', '预订');
INSERT INTO `order_master` VALUES ('991a8c01596d4ff594f0c0232969b3fc', '7752329804', '羿琴欢', '1979-11-01 00:00:00', '退货');
INSERT INTO `order_master` VALUES ('8061d794a5cc4b609871a364f7b2c9c3', '3864961836', '龚秋', '1989-07-27 00:00:00', '退货');
INSERT INTO `order_master` VALUES ('13efea833e7646d6ab3546f28e4d58c4', '7265074372', '蒋腾', '2004-03-31 00:00:00', '退货');
INSERT INTO `order_master` VALUES ('5902cc1845ff4e029dbcfbc80abd43bf', '5406853096', '萧君瑞', '1968-11-03 00:00:00', '退货');
INSERT INTO `order_master` VALUES ('65f3bce9c1384c5894600a35fb081c19', '1669949449', '牛翔', '1985-08-16 00:00:00', '退货');
INSERT INTO `order_master` VALUES ('8eadd9af46b840f78233de9a8b52487d', '7930143198', '禹洁', '1972-03-29 00:00:00', '退货');
INSERT INTO `order_master` VALUES ('621c01284e0c4128be0bf5a2c8c92541', '3372113235', '关良绍', '1961-09-21 00:00:00', '预订');
INSERT INTO `order_master` VALUES ('400069ba80954d3c926eced818a27f7c', '9858510918', '熊辰', '1992-09-20 00:00:00', '完成');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `prod_id` varchar(40) DEFAULT NULL COMMENT '商品id',
  `flow_id` varchar(40) DEFAULT NULL COMMENT '商品流水编号',
  `prod_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `prod_price` double(10,2) DEFAULT NULL COMMENT '商品售价',
  `prod_unit` varchar(100) DEFAULT NULL COMMENT '商品单位描述',
  `prod_origin` varchar(1000) DEFAULT NULL COMMENT '商品来源(产地)',
  `prod_date` datetime DEFAULT NULL COMMENT '商品生产日期',
  `prod_descr` varchar(1000) DEFAULT NULL COMMENT '商品描述',
  `vendor_name` varchar(100) DEFAULT NULL COMMENT '商品供应商名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('c9458bd95b144853a8cf9f3db7fdf03f', '0653985620', '清扬洗发水', '35.50', '瓶/支', '北京朝阳', '2019-01-01 00:00:00', '去屑用清扬，更自信', '美乐家日用品（中国）有限公司');
INSERT INTO `product` VALUES ('d8478ab4e9654af2b32da719087cdea2', '3567643447', '爱马仕箱包', '299.90', '个', '上海浦东', '2018-01-01 00:00:00', '爱在每时每分每秒，爱马仕,生活充满传奇!装的下,世界就是你的!', '美乐家日用品（中国）有限公司');
INSERT INTO `product` VALUES ('e1cf8247178e400fbf68270aa695866f', '8061215435', '纳爱斯香皂', '9.90', '个', '上海浦东', '2018-01-01 00:00:00', '啦啦啦', '美乐家日用品（中国）有限公司');
INSERT INTO `product` VALUES ('65e13ada22ea47729353a487dd299945', '0382900318', '可比克薯片', '6.90', '包', '哈尔滨', '2018-07-01 00:00:00', '薯我鲜,薯我辣,薯我脆,薯片可比克,片片都欢乐,我的选择可比克!', '');
INSERT INTO `product` VALUES ('364108d902844c9384a539b5f67c7dc8', '2790390676', '老北京鸡爪', '1.90', '个', '福建福州', '2019-01-01 00:00:00', '美味无穷,辣爪天下,吃辣敢挑战吗,来只爪!', '浙江青莲食品股份公司');
INSERT INTO `product` VALUES ('55ff19e3df5049a78dd24804114209cb', '3390617614', '康师傅红烧牛肉面', '4.50', '个', '四川', '2018-01-01 00:00:00', '康师傅牛肉面,好吃看得见！', '浙江青莲食品股份公司');
INSERT INTO `product` VALUES ('8298c8452a1248688e5cbfa058289bf8', '6670834570', '合味道（咖喱味）1*12规格', '59.90', '箱', '香港', '2018-01-01 00:00:00', '方便您的合味道,合您味道的方便面！', '浙江青莲食品股份公司');
INSERT INTO `product` VALUES ('75115f84d9da423f92d990f1d4a4379b', '0950903648', '鸡蛋雪糕', '3.90', '个/只', '山东', '2019-03-01 00:00:00', '总是在不经意的时候,给你带来一份最细致体贴的关怀！', '浙江青莲食品股份公司');
INSERT INTO `product` VALUES ('46e0ab7574fe42ecbc7838cff0e356ab', '5721574158', '唐僧肉（辣条）', '4.90', '包', '北京', '2018-01-01 00:00:00', '吃上一口唐僧肉,战胜上下五千年妖魔鬼怪！', '浙江青莲食品股份公司');
INSERT INTO `product` VALUES ('0527a136d3754fa4aeba3ef8bac38dff', '3525253773', '优悦矿泉水', '3.90', '瓶', '山东', '2018-01-01 00:00:00', '地下深水,喝的就是滋味', '华润怡宝饮料（中国）有限公司');
INSERT INTO `product` VALUES ('97efab7b824c4bde921a22aa27e495f2', '9781592342', '康师傅冰红茶', '3.90', '瓶', '长春', '2018-01-01 00:00:00', '冰力十足,无可替代! 传递品牌畅快,冰酷,乐趣的个性！', '华润怡宝饮料（中国）有限公司');
INSERT INTO `product` VALUES ('42f074b594b1464ba2c4f717328965ce', '9319884700', '晨光签字笔', '3.90', '只', '上海', '2013-01-20 00:00:00', 'Forever Thinking,Forever Writting', '美乐家日用品（中国）有限公司');
INSERT INTO `product` VALUES ('0f5e6469bb654097b5c1f871ab084809', '5937237218', '快客钢笔', '69.90', '只', '北京', '2018-01-30 00:00:00', '钢笔小世界,书写大乾坤', '美乐家日用品（中国）有限公司');
INSERT INTO `product` VALUES ('fab01f7aa2274eb9994d69887608234d', '7967407523', '作业本', '3.90', '本', '山东', '2018-06-01 00:00:00', '这是你曾经使用过的最舒适的笔记本', '美乐家日用品（中国）有限公司');
INSERT INTO `product` VALUES ('1208de2d0c4d42d7b10c01c4f4da761f', '4725904945', '娃哈哈儿童裝', '399.90', '套', '北京', '2019-01-01 00:00:00', '快乐童年我最棒！', '浙江盛邦服饰有限公司');
INSERT INTO `product` VALUES ('2e22e515d0b346789082e6a1c9ebeec3', '4231099780', 'snapback棒球帽', '39.90', '个', '广东深圳', '2018-01-01 00:00:00', '爱尚伊帽,时尚snapback棒球帽为您打造', '浙江盛邦服饰有限公司');
INSERT INTO `product` VALUES ('e6ab4a0d2b1447abbae44e24e06d9b6b', '5343381114', '盐焗鸡爪', '23.50', '包', '广东梅州', '2018-02-01 00:00:00', '盐焗鸡,好味道,少校老青都爱吃,吃后都说顶呱呱,顶呱呱,还能开胃呢!', '广东振成食品有限公司');
INSERT INTO `product` VALUES ('0bddf95f1d7d40849f251d7b8f169756', '8712472047', '香辣鸡爪', '24.50', '包', '广东梅州', '2018-09-01 00:00:00', '美食不可抵挡', '广东振成食品有限公司');
INSERT INTO `product` VALUES ('154767bd90f745d5816399bd2d941b14', '2693386899', '盐焗鸡翅', '26.50', '包', '广东梅州', '2019-01-20 00:00:00', '盐焗鸡,好味道,少校老青都爱吃,吃后都说顶呱呱,顶呱呱,还能开胃呢!', '广东振成食品有限公司');
INSERT INTO `product` VALUES ('376a14f67a924841acacf43f499d22ba', '0275773767', 'ACER笔记本电脑', '4999.90', '台', '香港', '2019-01-01 00:00:00', '我信我选acer', '美乐家日用品（中国）有限公司');
