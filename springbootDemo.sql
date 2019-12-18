/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.62 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `test`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(16) CHARACTER SET latin1 NOT NULL,
  `content` varchar(4000) CHARACTER SET latin1 NOT NULL,
  `type` varchar(16) CHARACTER SET latin1 DEFAULT NULL,
  `tags` varchar(16) CHARACTER SET latin1 DEFAULT NULL,
  `categories` varchar(16) CHARACTER SET latin1 DEFAULT NULL,
  `comments_count` int(11) DEFAULT NULL,
  `allow_comment` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  `author` varchar(16) CHARACTER SET latin1 NOT NULL,
  `author_id` int(5) NOT NULL,
  `create_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='博客文章表';

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`content`,`type`,`tags`,`categories`,`comments_count`,`allow_comment`,`status`,`author`,`author_id`,`create_date`,`modified_date`) values (1,'2412','sdafasd','1','saf','asdasd',5,1,1,'sdsd',1,'2019-12-16 08:30:00','2019-12-16 08:30:03');

/*Table structure for table `exception` */

DROP TABLE IF EXISTS `exception`;

CREATE TABLE `exception` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(20) CHARACTER SET latin1 NOT NULL,
  `method` varchar(20) CHARACTER SET latin1 NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `exception` */

insert  into `exception`(`id`,`class`,`method`,`date`) values (1,'UserServiceImpl','queryOne','2019-11-28 07:15:47');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(16) NOT NULL,
  `url` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='权限表';

/*Data for the table `permission` */

insert  into `permission`(`id`,`permission_name`,`url`) values (1,'user:resource','/resource/index');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='角色表';

/*Data for the table `role` */

insert  into `role`(`id`,`rolename`) values (1,'admin'),(2,'manager'),(3,'programmer');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(16) NOT NULL,
  `permission_name` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`rolename`,`permission_name`) values (1,'admin','user:resource'),(2,'manager','user:resource'),(3,'programmer','user:aaa'),(4,'admin','user:index');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET latin1 NOT NULL,
  `password` varchar(16) CHARACTER SET latin1 NOT NULL,
  `nick_name` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`nick_name`,`status`) values (1,'wangzhihao','wangzhihao','sadsad',1),(2,'aaa','aaa',NULL,1),(3,'bbb','bbb',NULL,1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `rolename` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`username`,`rolename`) values (1,'wangzhihao','admin'),(2,'wangzhihao','manager'),(3,'zhangyaojun','programmer');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
