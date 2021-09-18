/*
 Navicat Premium Data Transfer

 Source Server         : phpstudy
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 18/09/2021 19:37:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `bName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书书名',
  `author` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者姓名',
  `pubComp` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `pubDate` datetime NULL DEFAULT NULL COMMENT '出版日期',
  `bCount` int(11) NULL DEFAULT NULL COMMENT '现存数量',
  `price` float(6, 2) NULL DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'jsp入门指栏', '曹枫', '长江出版社', '2021-03-12 14:14:39', 10, 29.90);
INSERT INTO `book` VALUES (2, 'SM从入门到捆绑', '陈维', '武汉大学出版社', '2020-09-01 14:15:21', 30, 19.90);
INSERT INTO `book` VALUES (3, 'Spring春天来了', '马龙', '春天出版社', '2020-08-05 14:15:56', 5, 39.90);
INSERT INTO `book` VALUES (4, 'MySQL从删库到跑路', '冯旭', '北京大学出版社', '2021-02-01 14:16:27', 100, 99.90);
INSERT INTO `book` VALUES (5, 'Java从入门到精通', '刘天培', '南京大学出版社', '2021-03-10 14:17:10', 50, 20.00);
INSERT INTO `book` VALUES (6, 'SM从入门到捆绑', '陈维', '武汉大学出版社', '2020-09-01 14:15:21', 30, 19.90);
INSERT INTO `book` VALUES (7, 'Spring春天来了', '马龙', '春天出版社', '2020-08-05 14:15:56', 5, 39.90);
INSERT INTO `book` VALUES (8, 'Java从入门到精通', '刘天培', '南京大学出版社', '2021-03-10 14:17:10', 50, 20.00);
INSERT INTO `book` VALUES (9, 'MySQL从删库到跑路', '冯旭', '北京大学出版社', '2021-02-01 14:16:27', 100, 99.90);
INSERT INTO `book` VALUES (10, 'jsp入门指栏', '曹枫', '长江出版社', '2021-03-12 14:14:39', 10, 29.90);
INSERT INTO `book` VALUES (11, 'Spring春天来了', '马龙', '春天出版社', '2020-08-05 14:15:56', 5, 39.90);
INSERT INTO `book` VALUES (12, 'MySQL从删库到跑路', '冯旭', '北京大学出版社', '2021-02-01 14:16:27', 100, 99.90);
INSERT INTO `book` VALUES (13, 'Java从入门到精通', '刘天培', '南京大学出版社', '2021-03-10 14:17:10', 50, 20.00);
INSERT INTO `book` VALUES (14, 'SM从入门到捆绑', '陈维', '武汉大学出版社', '2020-09-01 14:15:21', 30, 19.90);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin');
INSERT INTO `user` VALUES (2, 'null', 'null');

SET FOREIGN_KEY_CHECKS = 1;
