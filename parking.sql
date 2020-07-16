/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.5.27 : Database - parking
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`parking` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `parking`;

/*Table structure for table `authority` */

DROP TABLE IF EXISTS `authority`;

CREATE TABLE `authority` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(15) NOT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `authority` */

insert  into `authority`(`vid`,`authority`) values (1,'vip'),(2,'admin');

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `license` varchar(20) NOT NULL,
  `carName` varchar(15) NOT NULL,
  `inparking` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cid`,`license`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `car` */

insert  into `car`(`cid`,`license`,`carName`,`inparking`) values (11,'赣A666','兰博基尼。魅影',0),(12,'赣C66666','玛莎拉蒂总裁',1),(14,'赣B6666','兰博基尼。魅影',0),(15,'好几个8','二手奥拓',0),(16,'赣A666666','劳斯莱斯.幻影',0);

/*Table structure for table `car_user` */

DROP TABLE IF EXISTS `car_user`;

CREATE TABLE `car_user` (
  `cuid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`cuid`),
  KEY `cc` (`cid`),
  KEY `uu` (`uid`),
  CONSTRAINT `cc` FOREIGN KEY (`cid`) REFERENCES `car` (`cid`),
  CONSTRAINT `uu` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `car_user` */

insert  into `car_user`(`cuid`,`cid`,`uid`) values (15,14,6),(16,11,1),(17,15,1),(18,16,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `money` int(11) NOT NULL DEFAULT '0',
  `name` varchar(10) NOT NULL DEFAULT '顾客',
  PRIMARY KEY (`uid`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`tel`,`money`,`name`) values (1,'abc132','123456','100861',3300,'吴飞'),(2,'lzh438','123456','1008611',10,'乐小帅'),(3,'lk456','123456','100100',0,'刘小科'),(4,'kw438438','123456','10086111a',100,'砍王'),(5,'pds438','666666','438438',500,'潘大帅'),(6,'xiao12345','123456','1008611',500,'xiao');

/*Table structure for table `user_authority` */

DROP TABLE IF EXISTS `user_authority`;

CREATE TABLE `user_authority` (
  `auid` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL DEFAULT '1',
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`auid`),
  KEY `aa` (`aid`),
  KEY `uuu` (`uid`),
  CONSTRAINT `aa` FOREIGN KEY (`aid`) REFERENCES `authority` (`vid`),
  CONSTRAINT `uuu` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user_authority` */

insert  into `user_authority`(`auid`,`aid`,`uid`) values (1,1,1),(2,1,2),(3,1,4),(4,1,5),(5,2,6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
