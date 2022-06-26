-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.18-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_kontak
CREATE DATABASE IF NOT EXISTS `db_kontak` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_kontak`;

-- Dumping structure for table db_kontak.tb_kontak
CREATE TABLE IF NOT EXISTS `tb_kontak` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nm_kontak` varchar(50) DEFAULT '0',
  `no_kontak` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_kontak.tb_kontak: ~0 rows (approximately)
/*!40000 ALTER TABLE `tb_kontak` DISABLE KEYS */;
INSERT INTO `tb_kontak` (`id`, `nm_kontak`, `no_kontak`) VALUES
	(1, 'aminp', '085234242'),
	(2, 'tes', '083243294823'),
	(3, 'tes', '0u0238424'),
	(4, 'sdfsdf', '2342424');
/*!40000 ALTER TABLE `tb_kontak` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
