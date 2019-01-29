/*
MySQL Backup
Database: myres2
Backup Time: 2019-01-29 14:55:00
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `myres2`.`book`;
DROP TABLE IF EXISTS `myres2`.`deskstutas`;
DROP TABLE IF EXISTS `myres2`.`menu`;
DROP TABLE IF EXISTS `myres2`.`orderform`;
DROP TABLE IF EXISTS `myres2`.`user`;
CREATE TABLE `book` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `clientname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `deskid` int(11) DEFAULT NULL,
  `book_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deskid` (`deskid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`deskid`) REFERENCES `deskstutas` (`deskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `deskstutas` (
  `deskid` int(11) NOT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`deskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `menu` (
  `foodid` int(11) NOT NULL,
  `foodname` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `cost` decimal(10,2) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`foodid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `orderform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deskid` int(11) DEFAULT NULL,
  `clietname` varchar(255) DEFAULT NULL,
  `food` varchar(255) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `totalprice` decimal(10,2) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `paystatus` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deskid` (`deskid`),
  CONSTRAINT `orderform_ibfk_1` FOREIGN KEY (`deskid`) REFERENCES `deskstutas` (`deskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `userpwd` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `myres2`.`book` WRITE;
DELETE FROM `myres2`.`book`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `myres2`.`deskstutas` WRITE;
DELETE FROM `myres2`.`deskstutas`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `myres2`.`menu` WRITE;
DELETE FROM `myres2`.`menu`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `myres2`.`orderform` WRITE;
DELETE FROM `myres2`.`orderform`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `myres2`.`user` WRITE;
DELETE FROM `myres2`.`user`;
INSERT INTO `myres2`.`user` (`userid`,`username`,`userpwd`,`position`,`sex`,`status`) VALUES (1001, '路飞', '123456', '经理', '男', 1);
UNLOCK TABLES;
COMMIT;
