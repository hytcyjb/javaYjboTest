/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-01-16 20:09:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `day15customer`
-- ----------------------------
DROP TABLE IF EXISTS `day15customer`;
CREATE TABLE `day15customer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `birthday` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `hobby` varchar(50) NOT NULL,
  `kind` varchar(50) NOT NULL,
  `remarks` varchar(5000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of day15customer
-- ----------------------------
INSERT INTO `day15customer` VALUES ('2', '杨建波1', '男', '1992-05-06', '18501481884', 'yangjbm@yonyou.com', '看电影,学习', '普通客户', '偶遇同楼的女生遛狗，一次就让人绝望了，这辈子是追不上她了');
INSERT INTO `day15customer` VALUES ('3', '杨建波2', '男', '1992-05-06', '18501481884', 'yangjbm@yonyou.com', '看电影,学习', '普通客户', '偶遇同楼的女生遛狗，一次就让人绝望了，这辈子是追不上她了');
INSERT INTO `day15customer` VALUES ('4', '杨建波2', '男', '1992-05-06', '18501481884', 'yangjbm@yonyou.com', '看电影,学习', '普通客户', '偶遇同楼的女生遛狗，一次就让人绝望了，这辈子是追不上她了');
INSERT INTO `day15customer` VALUES ('5', '严江', '女', '1993-02-02', '18505225638', '14587455@qq.com', '看电影,学习', '非客户', '郭德纲和曹云金12年前的生活照，吃贴饼，蘸大葱');
INSERT INTO `day15customer` VALUES ('6', '严江2', '男', '1991-01-01', '1221213', '13311321', '跳舞,看电影', '重要客户', '不要觉得自己在锻炼，偶尔放纵一下没关系。那就错了！');
INSERT INTO `day15customer` VALUES ('7', 'sasa', '男', '1905-8-8', '2121313', 'wqadsad', '看电影', '非客户', 'sadsadsasad');
INSERT INTO `day15customer` VALUES ('19', '杨建波6', '男', '1995-8-13', '214343', '21sa', '看电影', '非客户', '洒出来撒出来看见索拉卡Jack拉萨从刹车撒城市擦');
INSERT INTO `day15customer` VALUES ('20', '杨建波7', '男', '1995-8-13', '214343', '21sa', '看电影', '非客户', '洒出来撒出来看见索拉卡Jack拉萨从刹车撒城市擦');
INSERT INTO `day15customer` VALUES ('21', '杨建波6', '男', '1995-8-13', '214343', '21sa', '看电影', '非客户', '洒出来撒出来看见索拉卡Jack拉萨从刹车撒城市擦');
INSERT INTO `day15customer` VALUES ('22', '杨建波8', '男', '1900-1-1', '2121', '33213', '看电影', '非客户', '而非QQ我擦千瓦城市三次撒出去洒出三成');
INSERT INTO `day15customer` VALUES ('23', '杨建波8', '男', '1900-1-1', '2121', '33213', '看电影', '非客户', '而非QQ我擦千瓦城市三次撒出去洒出三成');
INSERT INTO `day15customer` VALUES ('24', '杨建波8', '男', '1908-1-1', '12', '32323', '看电影', '非客户', '吃的飒飒城市吃三次擦按时吃擦刹车access');
INSERT INTO `day15customer` VALUES ('25', '杨建波8', '男', '1924-9-3', '122121', '21212e', '看电影', '非客户', '出现在市场撒村洒出三成洒出三成擦');
INSERT INTO `day15customer` VALUES ('26', '杨建波6', '男', '1995-8-13', '214343', '21sa', '看电影', '非客户', '洒出来撒出来看见索拉卡Jack拉萨从刹车撒城市擦');
INSERT INTO `day15customer` VALUES ('27', '杨建波9', '男', '1900-1-1', '2121', '54', '看电影', '非客户', '23人啥端茶倒水发vDVD是');
INSERT INTO `day15customer` VALUES ('28', '杨建波9', '男', '1900-1-1', '2121', '54', '看电影', '非客户', '23人啥端茶倒水发vDVD是');
INSERT INTO `day15customer` VALUES ('29', '杨建波10', '男', '1900-1-1', '212121', '212121', '看电影', '非客户', '的飒飒撒擦擦是');
INSERT INTO `day15customer` VALUES ('31', '杨建波10', '男', '1900-1-1', '212121', '212121', '看电影', '非客户', '的飒飒撒擦擦是');
INSERT INTO `day15customer` VALUES ('32', '杨建波10', '男', '1900-1-1', '212121', '212121', '看电影', '非客户', '的飒飒撒擦擦是');
INSERT INTO `day15customer` VALUES ('33', '杨建波10', '男', '1900-1-1', '212121', '212121', '看电影', '非客户', '的飒飒撒擦擦是');
INSERT INTO `day15customer` VALUES ('34', '杨建波10', '男', '1900-1-1', '212121', '212121', '看电影', '非客户', '的飒飒撒擦擦是');
INSERT INTO `day15customer` VALUES ('35', '杨建波1339', '男', '1981-6-12', '322322', '23232223', '看电影', '非客户', 'v但是得v是v的诞生v是DVDv撒但是v');
INSERT INTO `day15customer` VALUES ('36', '杨建波1347', '男', '1993-9-14', '123456', '322332', '看电影', '非客户', 'sendRedirect可以将页面跳转到任何路径，不局限于web应用中，跳转的过程中url地址变化，无法使用request.setAttribute来传递。');
INSERT INTO `day15customer` VALUES ('37', '杨建波1141354', '男', '1992-7-16', '45121233', '544545', '看电影', '非客户', '刹车撒村洒出来卡萨看出来撒村');
INSERT INTO `day15customer` VALUES ('38', '杨建波1141355', '男', '1983-9-22', '212132131', '232323', '看电影', '非客户', 'v十点多v时的萨达撒女');
INSERT INTO `day15customer` VALUES ('39', '杨建波1141451', '男', '1991-10-19', '122121213', '453545', '看电影', '非客户', '但是vv多撒多所v的v是v但是得v是');
INSERT INTO `day15customer` VALUES ('40', '杨建波1141505', '男', '1991-10-10', '5656565656', '455555', '跳舞,学习', '非客户', '更好吃就好了就好了极乐空间好欧UGG牛皮');
INSERT INTO `day15customer` VALUES ('41', '杨建波1141513', '男', '1992-5-6', '4545454', '1454545', '跳舞,学习,逛街', '非客户', 'v的诞生v但是vdsv但是v但是vdsvvshjjm,hmhj 给你发给你发给你发');
INSERT INTO `day15customer` VALUES ('42', '杨建波1141524', '男', '1919-1-1', '111', '2212', '跳舞,看电影,学习', '非客户', '现在现在V型在V型在V型在v');
INSERT INTO `day15customer` VALUES ('43', '杨贵妃', '男', '1902-7-14', '18520520456', '14222@qq.com', '跳舞', '非客户', '杨玉环（公元719年6月22日－公元756年7月15日），号太真。[1]  姿质丰艳，善歌舞，通音律，为唐代宫廷音乐家、舞蹈家。其音乐才华在历代后妃中鲜见，被后世誉为中国古代四大美女之一。\n其籍贯存在争议，主要有五种说法：虢州阌乡（今河南灵宝）[2-3]  、蒲州永乐（今山西永济）说、弘农华阴（今陕西华阴）说、蜀州（今四川成都）、容州（今广西容县）说。她出生于宦门世家，父亲杨玄琰曾担任过蜀州司户。[4] \n她先为唐玄宗儿子寿王李瑁王妃，受令出家后，又被公爹唐玄宗册封为贵妃。天宝十五载（756年），安禄山发动叛乱，随李隆基流亡蜀中，途经马嵬驿，杨玉环于六月十四日，在马嵬驿死于乱军之中，香消玉殒。[5-6] \n杜甫有《哀江头》诗：“明眸皓齿今何在，血污游魂归不得。清渭东流剑阁深，去住彼此无消息。人生有情泪沾臆，江花江草岂终极！”、白居易形容她“温泉水滑洗凝脂”、“回眸一笑百媚生，六宫粉黛无颜色”。李白的《清平调》则说她\"云想衣裳花想容,春风拂槛露华浓。“');
