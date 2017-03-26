-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registerDate` datetime DEFAULT NULL,
  `lastLoginDate` datetime DEFAULT NULL,
  `expireDate` datetime DEFAULT NULL,
  `role` varchar(50) DEFAULT 'user',
  `email` varchar(50) DEFAULT '',
  `phone` varchar(50) DEFAULT '',
  `lastLoginIP` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;