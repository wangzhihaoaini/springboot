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
  `title` varchar(100) NOT NULL,
  `content` varchar(4000) NOT NULL,
  `type` varchar(16) DEFAULT NULL,
  `tags` varchar(16) DEFAULT NULL,
  `categories` varchar(16) DEFAULT NULL,
  `comments_count` int(11) DEFAULT '0',
  `allow_comment` int(1) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `author` varchar(16) NOT NULL,
  `author_id` int(5) NOT NULL,
  `create_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='博客文章表';

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`content`,`type`,`tags`,`categories`,`comments_count`,`allow_comment`,`status`,`author`,`author_id`,`create_date`,`modified_date`) values (1,'<h2>分而治之</h2>\r\n<h3>从汉诺塔问题理解分而治之的算法思想</h3>','<p>既然要讨论分而治之的算法思想，那么首先我们就要弄清楚：分而治之是什么？</p>\r\n\r\n<p>有时直接解决一个复杂的问题是相当困难的，往往绞尽脑汁，却无功而返。这时候，不妨换个思路，既然理解一个理解庞大的问题是如此吃力，不如把它看成一些独立，较容易的相同问题，以便逐个击破。ps:举一个不那么恰当的例子：既然找个适合的女朋友是如此困难，不如一步一步来，先学会和女生聊天好了。没错了，这就是分而治之的思想。</p>\r\n<p>作为算法思想，就不得不提到分而治之与递归的关系。用分治法解决问题，原问题被不断分解为较小的子问题，最后求出子问题的解。这与递归思想，简直如出一辙。这是因为如此，它们常常同时应用在算法设计之中，并由此产生许多高效的算法。</p>\r\n\r\n<h2 class=\"section-heading\">汉诺塔问题</h2>\r\n\r\n<p>空说无凭，作为分治思想的经典问题，我们通过汉诺塔问题来说明实际解决问题中，如何运用分而治之的算法思想。</p>\r\n\r\n<p>相传在古印度圣庙中，有一种被称为<a href=\"https://baike.baidu.com/item/汉诺塔问题/1945186\">汉诺塔(Hanoi)</a>的游戏。该游戏是在一块铜板装置上，有三根杆(编号A、B、C)，在A杆自下而上、由大到小按顺序放置64个金盘(如下图)。游戏的目标：把A杆上的金盘全部移到C杆上，并仍保持原有顺序叠好。操作规则：每次只能移动一个盘子，并且在移动过程中三根杆上都始终保持大盘在下，小盘在上，操作过程中盘子可以置于A、B、C任一杆上。</p>\r\n\r\n<p>如果尝试直接移动这么多的盘子，恐怕一时感到无从下手。这时采用分治思想，我们来看看当盘子数量少的时候，应该如何解决问题呢？</p><p>\r\n\r\n</p><h3>一个盘子</h3>\r\n<p>将盘子从A移动到C：A-&gt;C</p>\r\n\r\n<h3>两个盘子</h3>\r\n<p>将最大盘子之前的盘子从A移动到B：A-&gt;B</p>\r\n<p>将最大的盘子从A移动到C：A-&gt;C</p>\r\n<p>将最大盘子之前的盘子从B移动到C：B-&gt;C</p>\r\n\r\n<h3>三个盘子</h3>\r\n<div style=\"text-align: center;\">\r\n<img class=\"img-fluid\" src=\"/img/blog/2018-04-27-分而治之-img/hanoi-3.gif\" alt=\"hanoi-3\">\r\n<span class=\"caption text-muted\">3个盘子的汉诺塔演示-<a href=\"https://www.zhihu.com/people/GalAster/activities\">作者：酱紫君</a></span>	\r\n</div>\r\n\r\n<p>如图，虽然三个盘子的搬运就显得略微复杂，但是它们的思想是一致的。</p>\r\n\r\n<p>step1:将最大盘子之前的盘子从A移动到B：A-&gt;B</p>\r\n<p>A-&gt;C</p>\r\n<p>A-&gt;B</p>\r\n<p>C-&gt;B</p>\r\n<p>step2:将最大盘子从A移动到C：A-&gt;C</p>\r\n<p>A-&gt;C</p>\r\n<p>step3:将最大盘子之前的盘子从B移动到C：B-&gt;C</p>\r\n<p>B-&gt;A</p>\r\n<p>B-&gt;C</p>\r\n<p>A-&gt;C</p>\r\n\r\n<p>想到了这样的分解思路之后我们就可以写出相应的程序了。</p>\r\n\r\n<pre style=\"background:#e1e9ed;\"><code>include &lt;stdio.h&gt;\r\n//计数变量\r\nint count = 1;\r\n//汉诺塔函数\r\nvoid hanoi(int n, char A, char B, char C);\r\n\r\nint main(int argc, const char * argv[]) {\r\n	\r\n//    作为linux C程序运行的预处理\r\n//    if (argc == 2) {\r\n//        const char * N = argv[1];\r\n//        int n = (int)(N[0] - 48);\r\n//        hanoi(n, \'A\', \'B\', \'C\');\r\n//    }else{\r\n//        printf(\"please input n as number of plates\");\r\n//    }\r\n	\r\n//  一般的C程序\r\n	hanoi(3, \'A\', \'B\', \'C\');\r\n	return 0;\r\n}\r\nvoid hanoi(int n, char A, char B, char C) {\r\n	if (n == 1) {\r\n		//只有一个盘子时，只需要把它从A柱移动到C柱\r\n		printf(\"第%d次移动，将第%d个盘子移动，从%c移动到%c\\n\", count++,n,A,C);\r\n	}else{\r\n		//step1:将最大盘子之前的盘子从A移动到B：A-&gt;B\r\n		hanoi(n - 1, A, C, B);\r\n		//step2:将最大盘子从A移动到C：A-&gt;C\r\n		printf(\"第%d次移动，将第%d个盘子移动，从%c移动到%c\\n\", count++,n,A,C);\r\n		//step3:将最大盘子之前的盘子从B移动到C：B-&gt;C\r\n		hanoi(n - 1, B, A, C);\r\n	}\r\n}\r\n</code></pre>\r\n\r\n<p>想要理解上述的递归程序，重点不在于对整个递归过程的推敲，而在于理解分而治之的处理过程。</p>\r\n<ul>\r\n	<li>step1:将最大盘子之前的盘子从A移动到B：A-&gt;B(把冰箱的门打开)</li>\r\n	<li>step2:将最大盘子从A移动到C：A-&gt;C(把大象放进去)</li>\r\n	<li>step3:将最大盘子之前的盘子从B移动到C：B-&gt;C(把冰箱的门关上)</li>\r\n</ul> \r\n\r\n<h2 class=\"section-heading\">总结</h2>\r\n<p>重复性工作，并不是人类最擅长的部分，而计算机恰恰很擅长这样傻瓜式的重复性工作。编写递归算法，重点在于掌握分而治之的处理过程（怎么把面对的复杂问题，分解成规模更小的相同问题去解决），至于递归的栈调用，就交给傻乎乎的计算机去做吧。</p>\r\n<blockquote class=\"blockquote\">这次我们简单介绍了用分而治之思想去解决经典的汉诺塔问题，今后还会不定时的更新一些算法问题的解决思路，欢迎读者交流看法，分享观点。</blockquote> \r\n\r\n\r\n      <hr>\r\n\r\n      <div class=\"clearfix\">\r\n\r\n        \r\n        \r\n      </div>\r\n\r\n<!-- 添加评论 -->\r\n      <div id=\"disqus_thread\"></div>\r\n      <script>\r\n      \r\n      var disqus_config = function () {\r\n      this.page.url = \"http://yukundream.com//2018/04/27/%E5%88%86%E8%80%8C%E6%B2%BB%E4%B9%8B.html\";\r\n      this.page.identifier = \"/2018/04/27/%E5%88%86%E8%80%8C%E6%B2%BB%E4%B9%8B.html\";\r\n      };\r\n      \r\n      (function() { // DON\'T EDIT BELOW THIS LINE\r\n      var d = document, s = d.createElement(\'script\');\r\n      s.setAttribute(\'data-timestamp\', +new Date());\r\n      (d.head || d.body).appendChild(s);\r\n      })();\r\n      </script>\r\n      <noscript>要查看<a href=\"http://disqus.com/?ref_noscript\"> Disqus </a>评论，请启用 JavaScript</noscript>','1','saf','asdasd',5,1,1,'Yukun Jin',1,'2019-12-16 20:50:17','2019-12-16 23:01:08'),(3,'阿萨大大撒旦','案说法啊','1',NULL,NULL,0,1,1,'sadsad',1,'2020-01-03 16:04:17','2020-01-03 16:04:17'),(4,'adasd','sadasd','1',NULL,NULL,0,1,1,'sadsad',1,'2020-01-03 16:28:12','2020-01-03 16:28:12'),(5,'阿斯顿撒','','1',NULL,NULL,0,0,1,'sadsad',1,'2020-01-03 16:51:39','2020-01-03 16:51:39');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `user_nickname` varchar(16) COLLATE utf8mb4_bin NOT NULL,
  `comment` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `date` datetime DEFAULT NULL,
  `is_reported` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='留言评论表';

/*Data for the table `comment` */

insert  into `comment`(`id`,`article_id`,`user_nickname`,`comment`,`date`,`is_reported`) values (1,1,'sadsad','aaa','2019-12-30 00:50:33',0),(7,1,'sadsad','啊我死了','2019-12-30 08:50:33',0),(8,1,'sadsad','asdsad','2019-12-30 08:02:14',0),(16,1,'sadsad','asdffdas','2020-01-02 09:34:53',0),(17,1,'sadsad','阿萨啊 啊啊啊啊啊','2020-01-02 09:45:00',0);

/*Table structure for table `exception` */

DROP TABLE IF EXISTS `exception`;

CREATE TABLE `exception` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(20) NOT NULL,
  `method` varchar(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `exception` */

insert  into `exception`(`id`,`class`,`method`,`date`) values (1,'UserServiceImpl','queryOne','2019-11-28 07:15:47');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(16) NOT NULL,
  `url` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='权限表';

/*Data for the table `permission` */

insert  into `permission`(`id`,`permission_name`,`url`) values (1,'user:resource','/resource/index');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `role` */

insert  into `role`(`id`,`rolename`) values (1,'admin'),(2,'manager'),(3,'programmer');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(16) NOT NULL,
  `permission_name` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`rolename`,`permission_name`) values (1,'admin','user:resource'),(2,'manager','user:resource'),(3,'programmer','user:aaa'),(4,'admin','user:index');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `nick_name` varchar(10) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`nick_name`,`status`) values (1,'wangzhihao','wangzhihao','sadsad',1),(2,'aaa','aaa',NULL,1),(3,'bbb','bbb',NULL,1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `rolename` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`username`,`rolename`) values (1,'wangzhihao','admin'),(2,'wangzhihao','manager'),(3,'zhangyaojun','programmer');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
