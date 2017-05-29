-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 29, 2017 at 09:44 AM
-- Server version: 5.5.54-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hibernate`
--

-- --------------------------------------------------------

--
-- Table structure for table `ship`
--

CREATE TABLE IF NOT EXISTS `ship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `construction_year` float DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `gross_tonnage` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `length` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ship_class` varchar(255) DEFAULT NULL,
  `tonnage` int(11) DEFAULT NULL,
  `width` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `ship`
--

INSERT INTO `ship` (`id`, `construction_year`, `country`, `gross_tonnage`, `is_active`, `latitude`, `length`, `longitude`, `name`, `ship_class`, `tonnage`, `width`) VALUES
(1, 2011, 'Liberia', 17025, b'1', 43.39, 169.37, 29, 'Lord Mountbatten', 'cargo', 28207, 27.2),
(2, 1977, 'Romania', 6015, b'1', 45.41, 130.77, 30.76, 'Albatros', 'cargo', 8750, 17.73),
(3, 2006, 'UK', 2528, b'1', 43.38, 89.99, 37.37, 'SCOT PIONEER', 'cargo', 3638, 12.58),
(4, 2000, 'UK', 2545, b'1', 42.37, 88.78, 39.44, 'VEDETTE', 'cargo', 3850, 12.5),
(5, 2009, 'UK', 61328, b'1', 37.1, 199.99, 26.21, 'TORINO', 'cargo', 22160, 32),
(6, 2005, 'UK', 1922, b'1', 36.22, 82.98, 29.42, 'Whithaven', 'tanker', 2779, 12.5),
(7, 2007, 'UK', 47386, b'1', 35.6, 225.48, 32.29, 'Bw Birch', 'tanker', 58123, 36.64),
(8, 2016, 'UK', 27659, b'1', 35.85, 183, 34.29, 'British Cumulus', 'tanker', 39999, 32),
(9, 2011, 'UK', 11246, b'1', 36.43, 145.15, 19.59, 'Edzard Schulte', 'tanker', 16371, 23),
(10, 2007, 'UK', 7465, b'1', 35.1, 115, 23.26, 'Isabella Kosan', 'tanker', 8587, 18.6),
(11, 2007, 'UK', 72, b'1', 36.38, 22.1, 25.42, 'Flota Lass', 'passengers ship', 10, 6),
(12, 2001, 'UK', 30285, b'1', 36.08, 203.3, 17.92, 'Stena Superfast VIII', 'passengers ship', 5525, 25),
(13, 1990, 'UK', 771, b'1', 35.8, 45.3, 12.72, 'Earl Sigurd', 'passengers ship', 231, 12.2),
(14, 2001, 'UK', 5359, b'1', 41.11, 86.97, 12.17, 'St Clare', 'passengers ship', 769, 18.4),
(15, 1986, 'UK', 206, b'1', 41.49, 35.72, 17.64, 'Loch Striven', 'passengers ship', 65, 10.39),
(16, 2003, 'UK', 342, b'1', 44.77, 40, 14.48, 'Red Jet 4', 'high speed craft', 30, 11),
(17, 2009, 'UK', 520, b'1', 43.59, 41, 10.21, 'Wightryder 2', 'high speed craft', 130, 12),
(18, 2001, 'UK', 181, b'1', 38.47, 37.2, 14.96, 'Hurricane Clipper', 'high speed craft', 19, 9.54),
(19, 1998, 'UK', 213, b'1', 38.01, 32.9, 12.21, 'Red Jet 3', 'high speed craft', 22, 8.32),
(20, 2001, 'UK', 98, b'1', 35.44, 30.9, 12.5, 'Moon Clipper', 'high speed craft', 11, 7.8),
(21, 2003, 'UK', 302, b'1', 38.15, 26.75, 11.22, 'Brisca', 'fishing', 159, 8.28),
(22, 2003, 'UK', 150, b'1', 37.49, 26.3, 11.53, 'Inverdale', 'fishing', 151, 7),
(23, 2003, 'UK', 349, b'1', 38.73, 28, 8.23, 'Ocean Harvest', 'fishing', 250, 8),
(24, 2003, 'UK', 189, b'1', 40.14, 28, 8.06, 'Viking Senior', 'fishing', 335, 8),
(25, 2003, 'UK', 499, b'1', 39.63, 40.06, 2.19, 'Settler', 'fishing', 650, 10),
(26, 1994, 'Cayman Is', 421, b'1', 21.43, 44.76, -82.6, 'Il Sole', 'sailing vessel', 300, 8.81),
(27, 2009, 'Cayman Is', 493, b'1', 21.42, 49, -82.1, 'Pursuit', 'sailing vessel', 365, 9),
(28, 2014, 'Cayman Is', 499, b'1', 19.03, 48.67, -82.52, 'D''Natalin IV', 'sailing vessel', 94, 9.02),
(29, 2011, 'Cayman Is', 1560, b'1', 18.5, 70.54, -77.93, 'Talisman C', 'sailing vessel', 200, 12.14),
(30, 2002, 'Cayman Is', 555, b'1', 17.96, 47.44, -76.81, 'Helios 2', 'sailing vessel', 99, 8.64);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
