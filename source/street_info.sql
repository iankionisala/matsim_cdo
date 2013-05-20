-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 20, 2013 at 11:50 AM
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
-- Table structure for table `street_info`
--

DROP TABLE IF EXISTS `street_info`;
CREATE TABLE IF NOT EXISTS `street_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(255) NOT NULL,
  `link_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=62 ;

--
-- Dumping data for table `street_info`
--

INSERT INTO `street_info` (`id`, `street_name`, `link_id`) VALUES
(1, 'yacapin', 87219577),
(2, 'yacapin', 88191076),
(3, 'yacapin', 114444371),
(4, 'yacapin', 88191019),
(5, 'yacapin', 25879947),
(6, 'yacapin', 182107013),
(7, 'yacapin', 182107015),
(9, 'corrales', 1912528738),
(10, 'corrales', 114444358),
(11, 'corrales', 190256571),
(12, 'corrales', 114444363),
(13, 'corrales', 190256572),
(14, 'corrales', 180693369),
(15, 'corrales', 114444355),
(16, 'corrales', 90610197),
(17, 'capistrano', 90799241),
(18, 'capistrano', 25879938),
(19, 'capistrano', 141722259),
(20, 'capistrano', 114444385),
(21, 'J.R. Borja Extension', 181547936),
(22, 'J.R. Borja Extension', 142886612),
(23, 'J.R. Borja Extension', 181548026),
(24, 'J.R. Borja ', 181548192),
(25, 'J.R. Borja ', 142886603),
(26, 'J.R. Borja ', 181548197),
(27, 'J.R. Borja ', 178432025),
(28, 'J.R. Borja ', 181547936),
(29, 'J.R. Borja ', 181548202),
(30, 'J.R. Borja ', 181548198),
(31, 'J.R. Borja ', 88191106),
(32, 'J.R. Borja ', 178414932),
(33, 'J.R. Borja ', 182107019),
(34, 'J.R. Borja ', 181548200),
(35, 'J.R. Borja ', 181547908),
(36, 'J.R. Borja ', 142886612),
(37, 'J.R. Borja ', 181548026),
(38, 'J.R. Borja ', 187999676),
(39, 'Don Apolinar Velez Street', 178417400),
(40, 'Don Apolinar Velez Street', 180370012),
(41, 'Carmen Bridge', 88617165),
(42, 'Golden Mile Bridge', 105471073),
(43, 'Golden Mile Bridge', 105471070),
(44, 'Golden Mile Bridge', 180369807),
(45, 'Marcos Bridge', 90610117),
(46, 'Sen. Aquilino Pimentel Bridge', 182104591),
(47, 'Sen. Aquilino Pimentel Bridge', 141597398),
(48, 'Sen. Aquilino Pimentel Bridge', 182104584),
(49, 'Pelaez Bridge', 105470447),
(50, 'vamenta', 205570925),
(51, 'vamenta', 180783334),
(52, 'vamenta', 205570821),
(53, 'vamenta', 212542516),
(54, 'vamenta', 205433977),
(55, 'vamenta', 205570819),
(56, 'Masterson Avenue', 32806805),
(57, 'Masterson Avenue', 88617173),
(58, 'Julio Pacana', 88317186),
(59, 'Julio Pacana', 88317168),
(60, 'Julio Pacana', 182104590),
(61, 'Julio Pacana', 179721519);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
