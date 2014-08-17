
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `blog_articles`
-- ----------------------------
DROP TABLE IF EXISTS `blog_articles`;
CREATE TABLE `blog_articles` (
  id` int(11) NOT NULL AUTO_INCREMENT,
  `h1` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `content_html` longtext,
  `count` int(11) NOT NULL DEFAULT '1',
  `author_id` int(11) NOT NULL,
  `pub_date` datetime DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `music_url` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `h1` (`h1`),
  KEY `category_id_refs_id_ca2a1fe6` (`category_id`) USING BTREE,
  CONSTRAINT `category_id_refs_id_ca2a1fe6` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `blog_authorinfo`
-- ----------------------------
DROP TABLE IF EXISTS `blog_authorinfo`;
CREATE TABLE `blog_authorinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `icon` varchar(200) NOT NULL,
  `login_name` varchar(20) NOT NULL DEFAULT 'nan',
  `password` varchar(20) NOT NULL DEFAULT 'nan',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `unique_login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `blog_category`
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `slug` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `slug` (`slug`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS = 1;