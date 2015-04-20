CREATE TABLE IF NOT EXISTS `client_sub_status_change_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_Id` bigint(20) DEFAULT NULL,
  `sub_status` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2991 DEFAULT CHARSET=utf8;
