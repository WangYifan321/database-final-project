/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost:3306
 Source Schema         : bookshop

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 02/01/2021 12:23:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(10) NOT NULL,
  `img_url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `press` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cangkuname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `num` int(11) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for cangku
-- ----------------------------
DROP TABLE IF EXISTS `cangku`;
CREATE TABLE `cangku`  (
  `cangku_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`cangku_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `vip_id` int(11) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `book_comment`(`book_id`) USING BTREE,
  INDEX `vip_comment`(`vip_id`) USING BTREE,
  CONSTRAINT `book_comment` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vip_comment` FOREIGN KEY (`vip_id`) REFERENCES `vipuser` (`vip_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dingdan
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan`  (
  `dingdan_id` int(11) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `vip_id` int(11) NULL DEFAULT NULL,
  `ying_money` int(11) NULL DEFAULT NULL,
  `shi_money` int(11) NULL DEFAULT NULL,
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '购买成功',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dingdan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for fahuo
-- ----------------------------
DROP TABLE IF EXISTS `fahuo`;
CREATE TABLE `fahuo`  (
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vip_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for press
-- ----------------------------
DROP TABLE IF EXISTS `press`;
CREATE TABLE `press`  (
  `press_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`press_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tiaomu
-- ----------------------------
DROP TABLE IF EXISTS `tiaomu`;
CREATE TABLE `tiaomu`  (
  `tiaomu_id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `money` int(11) NOT NULL,
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img_url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` smallint(10) NOT NULL DEFAULT 0,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tiaomu_id`) USING BTREE,
  INDEX `tiaomu_vip`(`username`) USING BTREE,
  CONSTRAINT `tiaomu_vip` FOREIGN KEY (`username`) REFERENCES `vipuser` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vipuser
-- ----------------------------
DROP TABLE IF EXISTS `vipuser`;
CREATE TABLE `vipuser`  (
  `vip_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'unique',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `personid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`vip_id`, `username`) USING BTREE,
  INDEX `vip_id`(`vip_id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- View structure for book_sale
-- ----------------------------
DROP VIEW IF EXISTS `book_sale`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `book_sale` AS #图书销售情况的视图
SELECT
	vipuser.vip_id,
	vipuser.`name`,
	tiaomu.username,
	vipuser.phone,
	vipuser.address,
	vipuser.sex,
	book.book_id,
	tiaomu.book_name,
	book.price ,
	book.cangkuname,
	book.press,
	book.author,
	book.type
FROM
	tiaomu,
	book,
	vipuser 
WHERE
	tiaomu.book_name = book.`name` 
	AND tiaomu.username = vipuser.username ;

-- ----------------------------
-- View structure for cangku_1
-- ----------------------------
DROP VIEW IF EXISTS `cangku_1`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `cangku_1` AS SELECT
	book.book_id,
	book.`name`,
	book.type,
	cangku_id,
	book.cangkuname,
	location,
	phone 
FROM
	book,cangku 
WHERE
	cangku.num > 0
	and book.cangkuname = cangku.`name` ;

-- ----------------------------
-- View structure for vip_book_comment
-- ----------------------------
DROP VIEW IF EXISTS `vip_book_comment`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `vip_book_comment` AS #用户与评论的视图，用于管理评论区
SELECT
	book.NAME,
	vipuser.username,
	`comment`.content 
FROM
	book,
	vipuser,
COMMENT 
WHERE
	COMMENT.book_id = book.book_id 
	AND COMMENT.vip_id = vipuser.vip_id ;

-- ----------------------------
-- View structure for vip_sale
-- ----------------------------
DROP VIEW IF EXISTS `vip_sale`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `vip_sale` AS #每一个用户的下单量的视图
SELECT
	vipuser.vip_id,
	dingdan.dingdan_id 
FROM
	vipuser,
	dingdan 
WHERE
	dingdan.vip_id = vipuser.vip_id ;

-- ----------------------------
-- Procedure structure for addbook
-- ----------------------------
DROP PROCEDURE IF EXISTS `addbook`;
delimiter ;;
CREATE PROCEDURE `addbook`(in book_cangku_name varchar(255), in book_booktype_name varchar(255),  in book_press varchar(23))
BEGIN
#增加一本书时，若没有此书对应的仓库或者书的类型、出版社，先在数据库中增加仓库或者书的类型、出版社，在进行保存

	 declare num int;
	 select count(*) 
	   into num 
		   from cangku 
			   where name = book_cangku_name;
	 if num = 0 then
	 insert into cangku (name) 
	    values (book_cangku_name);#判断仓库的数量，没有的话增加
	 end if; 
	 select count(*) 
	   into num 
		   from booktype 
			   where name = book_booktype_name;
	 if num = 0 then
	 insert into booktype (name) 
	   values (book_booktype_name);#判断书的类型有无
	 end if;
   	 select count(*) into num 
		   from press 
			   where name = book_press;
	 if num = 0 then
	 insert into press (name) 
	   values (book_press);#判断出版社信息有无，没有的话增加
	 end if;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deletevip
-- ----------------------------
DROP PROCEDURE IF EXISTS `deletevip`;
delimiter ;;
CREATE PROCEDURE `deletevip`(in vip_id1 int,in book_id1 int)
BEGIN
#删除一个用户会员时，先判断数据库中有无此人的信息，有的话处理完，之后删除所有与之相关的表，在删除此用户
	declare username1 varchar(30);
	declare name1 varchar(30);
	if vip_id1>0 then
	select name into name1 
	 from vipuser where vip_id = vip_id1;
	 select username into username1
	 from vip_user where vip_id = vip_id1;
	 delete from comment 
	   where vip_id = vip_id1;
	 delete from dingdan
	   where username = name1;
		 delete from fahuo
		 where vip_name = name1;
		 delete from tiaomu
		where username = username1;
		delete from vipuser
		where vip_id = vip_id1;
		end if;
		if book_id1!=0 then
		delete from book
		 where book_id = book_id1;
	 delete from comment
	 where book_id = book_id1;
	 end if;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for open_comment
-- ----------------------------
DROP PROCEDURE IF EXISTS `open_comment`;
delimiter ;;
CREATE PROCEDURE `open_comment`(in tiaomu_id1 int,in vip_id1 int)
BEGIN
#此存储过程用于开启评论，用户购买此书成功后，在相应的书后面开启评论功能
	declare booknum int;
	declare vipnum int;
	declare booksum int;
	declare book_id1 int;
	declare book_name1 varchar(30);
	select book_name into book_name1
	from tiaomu
	where tiaomu_id = tiaomu_id1;
	 select book_id into book_id1 
	 from book where name = book_name1;
	select count(*) 
	    into booknum
	  from book where book_id = book_id1; 
	select count(*) 
	   into vipnum
		   from vipuser where vip_id = vip_id1;
 if booknum!=0 and vipnum!=0 then
   insert into comment (vip_id,book_id)
	  values (vip_id1,book_id1);
		end if;
	if booknum=0 then
	delete from comment 
	  where book_id = book_id1 and vip_id = vip_id1;
		end if;
			if vipnum=0 then
	delete from comment 
	  where book_id = book_id1 and vip_id = vip_id1;
		end if;
		select num into booksum 
		  from book
			 where book_id = book_id1;
			 if booksum >1 then
	  update book set num = booksum-1
		 where book_id = book_id1;
		 end if;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for submit
-- ----------------------------
DROP PROCEDURE IF EXISTS `submit`;
delimiter ;;
CREATE PROCEDURE `submit`(in vipname varchar(200))
BEGIN
#用户从购物车提交相应的商品后，生成订单
	declare summoney int;
	declare vip int;
	declare num int;
	declare uname varchar(40); 
	select sum(money) 
	  into summoney 
	    from tiaomu 
	      where username = vipname and state = 1;
	select vip_id 
	  into vip 
	    from vipuser 
	      where username = vipname;
		select name
		  into uname
			  from vipuser  
				  where username = vipname;
  delete from tiaomu 
		  where username = vipname and state =1;
   insert into dingdan (vip_id,ying_money,shi_money,username) 
	   values (vip,summoney,summoney,uname);
	 END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table booktype
-- ----------------------------
DROP TRIGGER IF EXISTS `delete`;
delimiter ;;
CREATE TRIGGER `delete` AFTER DELETE ON `booktype` FOR EACH ROW BEGIN
#类型删除后，相应的图书也删除
declare booktype1 varchar(30);
declare num int;
select name 
 into booktype1 from booktype 
  where type_id = old.type_id;
select count(*) 
 into num from book 
  where type = booktype1;
if num>0 then
delete from book where type = booktype1;
end if;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table cangku
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_cangku`;
delimiter ;;
CREATE TRIGGER `delete_cangku` AFTER DELETE ON `cangku` FOR EACH ROW BEGIN
#删除这个仓库后，删除相应的图书
declare name1 varchar(30);
declare num1 int;
select name into name1 
 from cangku 
  where cangku_id = old.cangku_id;
select count(*) into num1 
 from book 
  where cangkuname = name1;
if num1>0 then
 delete from book where cangkuname = name1;
 end if;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tiaomu
-- ----------------------------
DROP TRIGGER IF EXISTS `getaddress`;
delimiter ;;
CREATE TRIGGER `getaddress` AFTER UPDATE ON `tiaomu` FOR EACH ROW BEGIN
#加入购物车提交订单后，生成相应的发货信息，以便于后续的发货
declare username1 varchar(40);
declare book_name1 varchar(40);
declare address1 varchar(40);
declare phone1 varchar(40);
declare vip_name1 varchar(40);
select username into username1 
  from tiaomu 
	  where tiaomu_id = old.tiaomu_id;
select book_name into book_name1 
  from tiaomu 
	 where tiaomu_id = old.tiaomu_id;
select address into address1 
  from vipuser 
	  where username = username1;
select name into vip_name1 
  from vipuser 
	  where username = username1;
select phone into phone1 
  from vipuser 
	  where username = username1;
insert into fahuo 
  values (book_name1,address1,vip_name1,phone1);
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table vipuser
-- ----------------------------
DROP TRIGGER IF EXISTS `onupdatevip`;
delimiter ;;
CREATE TRIGGER `onupdatevip` AFTER UPDATE ON `vipuser` FOR EACH ROW BEGIN
#当一个用户的信息更新之后，找到数据库中所有与之相关的信息，进行更新
declare phone1 varchar(12);
declare address1 varchar(30);
declare vip_name1 varchar(30);
declare username1 varchar(30);
select phone 
 into phone1 from vipuser 
   where vip_id = old.vip_id;
select username into username1 from vipuser where vip_id = old.vip_id;
select name into vip_name1 
  from vipuser 
	  where vip_id = old.vip_id;
select address 
 into address1 from vipuser 
  where vip_id = old.vip_id;
update fahuo 
  set phone = phone1  
	  where vip_name = old.name;
update fahuo 
 set address = address1 
  where vip_name = old.name;
update fahuo 
  set vip_name = vip_name1 
	 where vip_name = old.name;
update dingdan 
 set username = vip_name1 
   where username = old.name;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
