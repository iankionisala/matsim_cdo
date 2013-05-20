-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 20, 2013 at 12:10 PM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `matsim`
--

-- --------------------------------------------------------

--
-- Table structure for table `person_info`
--

DROP TABLE IF EXISTS `person_info`;
CREATE TABLE IF NOT EXISTS `person_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `person_info`
--

INSERT INTO `person_info` (`id`, `name`) VALUES
(1, 'DV Police'),
(2, 'Maria Reyna'),
(3, 'Provincial Hospital'),
(4, 'Sabal Hospital'),
(5, 'Polymedic'),
(6, 'Maternity'),
(7, 'Madonna Hospital'),
(8, 'City Hospital'),
(9, 'Polymedic plaza'),
(10, 'Medical Hospital'),
(11, 'DV Police'),
(12, 'Maria Reyna'),
(13, 'Macabalan Fire Station'),
(14, 'Aloba Fire Station'),
(15, 'Macabalan Fire Station'),
(16, 'agora police'),
(17, 'carmen police'),
(18, 'Macabalan police'),
(19, 'Macasandig Police'),
(20, 'Operation Director Police'),
(21, 'Provincial Director Police'),
(22, 'CUMC'),
(23, 'Macabalan police'),
(24, 'CDO Fire Station'),
(25, 'Aloba Fire Station'),
(26, 'agora police'),
(27, 'Polymedic plaza'),
(28, 'CDO Fire Station'),
(29, 'CUMC'),
(30, 'Provincial Director Police'),
(31, 'carmen police'),
(32, 'Operation Director Police'),
(33, 'aloba Fire Station'),
(34, 'Sabal Hospital'),
(35, 'Macasandig Police'),
(36, 'CDO Fire Station'),
(37, 'Provincial Hospital'),
(38, 'Madonna Hospital'),
(39, 'Polymedic'),
(40, 'City Hospital'),
(41, 'Maternity'),
(42, 'Medical Hospital'),
(43, 'cogon police'),
(44, 'cogon police'),
(45, 'Polymedic plaza');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
