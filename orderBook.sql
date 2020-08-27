-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 26, 2020 at 10:49 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
drop database if exists orderbook;
create database orderbook;
use orderbook;
--
-- Database: `orderbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `audit`
--


CREATE TABLE `audit` (
  `id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `message` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `audit`
--

INSERT INTO `audit` (`id`, `time`, `message`) VALUES
(3, '2020-08-25 11:32:13', 'ORDER 11: LCH BUY GOOG CREATED.'),
(4, '2020-08-25 11:33:33', 'ORDER 12: LCH BUY GOOG CREATED.'),
(5, '2020-08-25 11:36:21', 'ORDER 13: LCH BUY GOOG CREATED.'),
(6, '2020-08-25 11:40:42', 'ORDER 14: LCH BUY GOOG CREATED.'),
(7, '2020-08-25 11:45:31', 'ORDER 15: LCH BUY GOOG CREATED.'),
(8, '2020-08-25 11:45:54', 'ORDER 16: LCH BUY GOOG CREATED.'),
(9, '2020-08-25 11:57:51', 'ORDER 17: LCH BUY GOOG CREATED.'),
(10, '2020-08-25 11:57:51', 'TRADE 3 BUY ORDER VERSION: 12 SELL ORDER VERSION: 2 PRICE: 34.34 SIZE: 123'),
(11, '2020-08-25 11:58:17', 'ORDER 18: XLON BUY GOOG CREATED.'),
(12, '2020-08-25 11:58:17', 'TRADE 4 BUY ORDER VERSION: 14 SELL ORDER VERSION: 13 PRICE: 34.34 SIZE: 111'),
(13, '2020-08-25 11:58:49', 'ORDER 19: LCH BUY GOOG CREATED.'),
(14, '2020-08-25 11:59:17', 'ORDER 20: XLON SELL GOOG CREATED.'),
(15, '2020-08-25 11:59:17', 'TRADE 5 BUY ORDER VERSION: 4 SELL ORDER VERSION: 17 PRICE: 123.89 SIZE: 11'),
(16, '2020-08-25 12:00:09', 'ORDER 21: XLON SELL GOOG CREATED.'),
(17, '2020-08-25 12:00:09', 'TRADE 6 BUY ORDER VERSION: 18 SELL ORDER VERSION: 19 PRICE: 123.89 SIZE: 100'),
(18, '2020-08-25 12:11:32', 'ORDER 22: XLON SELL GOOG CREATED.'),
(19, '2020-08-25 12:11:32', 'TRADE 7 BUY ORDER VERSION: 11 SELL ORDER VERSION: 21 PRICE: 22.00 SIZE: 1231'),
(20, '2020-08-25 12:11:32', 'TRADE 8 BUY ORDER VERSION: 22 SELL ORDER VERSION: 23 PRICE: 22.00 SIZE: 3'),
(21, '2020-08-25 12:24:07', 'ORDER 23: LCH BUY GOOG CREATED.'),
(22, '2020-08-25 12:24:07', 'TRADE 9 BUY ORDER VERSION: 25 SELL ORDER VERSION: 15 PRICE: 34.34 SIZE: 116'),
(23, '2020-08-25 12:24:07', 'TRADE 10 BUY ORDER VERSION: 27 SELL ORDER VERSION: 26 PRICE: 34.34 SIZE: 34'),
(24, '2020-08-25 12:25:04', 'ORDER 24: LCH BUY GOOG CREATED.'),
(25, '2020-08-25 12:25:04', 'TRADE 11 BUY ORDER VERSION: 29 SELL ORDER VERSION: 28 PRICE: 34.34 SIZE: 48'),
(26, '2020-08-25 12:25:04', 'TRADE 12 BUY ORDER VERSION: 30 SELL ORDER VERSION: 20 PRICE: 69.00 SIZE: 752'),
(27, '2020-08-25 12:26:03', 'ORDER 25: LCH BUY GOOG CREATED.'),
(28, '2020-08-25 12:26:03', 'TRADE 13 BUY ORDER VERSION: 32 SELL ORDER VERSION: 31 PRICE: 69.00 SIZE: 50'),
(37, '2020-08-25 12:26:44', 'ORDER 27: XLON SELL GOOG CREATED.'),
(38, '2020-08-25 12:26:44', 'TRADE 21 BUY ORDER VERSION: 24 SELL ORDER VERSION: 42 PRICE: 22.00 SIZE: 888'),
(39, '2020-08-25 12:27:05', 'ORDER 28: LCH BUY GOOG CREATED.'),
(40, '2020-08-25 12:27:05', 'TRADE 22 BUY ORDER VERSION: 44 SELL ORDER VERSION: 33 PRICE: 69.00 SIZE: 7'),
(41, '2020-08-25 12:27:05', 'TRADE 23 BUY ORDER VERSION: 45 SELL ORDER VERSION: 3 PRICE: 111.11 SIZE: 400'),
(42, '2020-08-25 12:33:07', 'ORDER 29: LCH SELL APPL CREATED.'),
(43, '2020-08-25 12:33:07', 'TRADE 24 BUY ORDER VERSION: 5 SELL ORDER VERSION: 47 PRICE: 12.78 SIZE: 145'),
(50, '2020-08-25 12:37:43', 'ORDER 33: LCH SELL APPL CREATED.'),
(51, '2020-08-25 12:37:43', 'TRADE 28 BUY ORDER VERSION: 48 SELL ORDER VERSION: 56 PRICE: 12.78 SIZE: 11'),
(52, '2020-08-25 12:38:13', 'ORDER 34: LCH SELL APPL CREATED.'),
(53, '2020-08-25 12:38:24', 'ORDER 35: LCH SELL APPL CREATED.'),
(57, '2020-08-25 12:41:56', 'ORDER 37: LCH BUY APPL CREATED.'),
(58, '2020-08-25 12:41:56', 'TRADE 31 BUY ORDER VERSION: 63 SELL ORDER VERSION: 58 PRICE: 14.00 SIZE: 234'),
(59, '2020-08-25 12:44:53', 'ORDER 38: LCH BUY APPL CREATED.'),
(61, '2020-08-25 12:51:49', 'ORDER 40: LCH SELL APPL CREATED.'),
(62, '2020-08-25 12:51:55', 'ORDER 41: LCH BUY APPL CREATED.'),
(63, '2020-08-25 12:53:02', 'ORDER 42: LCH SELL APPL CREATED.');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `party` varchar(5) NOT NULL,
  `stock` varchar(5) NOT NULL,
  `buy` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `party`, `stock`, `buy`) VALUES
(1, 'LCH', 'GOOG', 0),
(2, 'LCH', 'GOOG', 0),
(3, 'LCH', 'GOOG', 1),
(4, 'LCH', 'APPL', 1),
(5, 'LCH', 'GOOG', 1),
(6, 'LCH', 'GOOG', 1),
(7, 'LCH', 'GOOG', 1),
(8, 'LCH', 'GOOG', 1),
(9, 'LCH', 'GOOG', 1),
(10, 'LCH', 'GOOG', 1),
(11, 'LCH', 'GOOG', 1),
(12, 'LCH', 'GOOG', 1),
(13, 'LCH', 'GOOG', 1),
(14, 'LCH', 'GOOG', 1),
(15, 'LCH', 'GOOG', 1),
(16, 'LCH', 'GOOG', 1),
(17, 'LCH', 'GOOG', 1),
(18, 'XLON', 'GOOG', 1),
(19, 'LCH', 'GOOG', 1),
(20, 'XLON', 'GOOG', 0),
(21, 'XLON', 'GOOG', 0),
(22, 'XLON', 'GOOG', 0),
(23, 'LCH', 'GOOG', 1),
(24, 'LCH', 'GOOG', 1),
(25, 'LCH', 'GOOG', 1),
(26, 'LCH', 'GOOG', 0),
(27, 'XLON', 'GOOG', 0),
(28, 'LCH', 'GOOG', 1),
(29, 'LCH', 'APPL', 0),
(30, 'LCH', 'APPL', 0),
(31, 'LCH', 'APPL', 1),
(32, 'LCH', 'APPL', 0),
(33, 'LCH', 'APPL', 0),
(34, 'LCH', 'APPL', 0),
(35, 'LCH', 'APPL', 0),
(36, 'LCH', 'APPL', 1),
(37, 'LCH', 'APPL', 1),
(38, 'LCH', 'APPL', 1),
(39, 'LCH', 'APPL', 1),
(40, 'LCH', 'APPL', 0),
(41, 'LCH', 'APPL', 1),
(42, 'LCH', 'APPL', 0);

-- --------------------------------------------------------

--
-- Table structure for table `orderversion`
--

CREATE TABLE `orderversion` (
  `id` int(11) NOT NULL,
  `orders` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `size` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderversion`
--

INSERT INTO `orderversion` (`id`, `orders`, `time`, `size`, `active`, `price`) VALUES
(1, 1, '2020-08-23 17:01:26', 250, 1, '123.21'),
(2, 1, '2020-08-24 14:46:54', 350, 0, '34.34'),
(3, 1, '2020-08-23 14:48:42', 400, 0, '111.11'),
(4, 5, '2020-08-23 14:51:58', 111, 0, '123.89'),
(5, 4, '2020-08-24 14:52:46', 450, 0, '12.78'),
(6, 11, '2020-08-25 11:32:13', 1231, 1, '22.00'),
(7, 12, '2020-08-25 11:33:33', 1231, 1, '22.00'),
(8, 13, '2020-08-25 11:36:21', 1231, 1, '22.00'),
(9, 14, '2020-08-25 11:40:42', 1231, 1, '22.00'),
(10, 15, '2020-08-25 11:45:31', 1231, 1, '22.00'),
(11, 16, '2020-08-25 11:45:54', 1231, 0, '22.00'),
(12, 17, '2020-08-25 11:57:51', 123, 0, '578.00'),
(13, 1, '2020-08-25 11:57:51', 227, 0, '34.34'),
(14, 18, '2020-08-25 11:58:17', 111, 0, '234.00'),
(15, 1, '2020-08-25 11:58:17', 116, 0, '34.34'),
(16, 19, '2020-08-25 11:58:49', 666, 1, '17.00'),
(17, 20, '2020-08-25 11:59:17', 11, 0, '55.00'),
(18, 5, '2020-08-25 11:59:17', 100, 0, '123.89'),
(19, 21, '2020-08-25 12:00:09', 909, 0, '69.00'),
(20, 21, '2020-08-25 12:00:09', 809, 0, '69.00'),
(21, 22, '2020-08-25 12:11:32', 1234, 0, '11.00'),
(22, 16, '2020-08-25 12:11:32', 1228, 0, '22.00'),
(23, 22, '2020-08-25 12:11:32', 3, 0, '11.00'),
(24, 16, '2020-08-25 12:11:32', 1225, 0, '22.00'),
(25, 23, '2020-08-25 12:24:07', 150, 0, '123.00'),
(26, 1, '2020-08-25 12:24:07', 82, 0, '34.34'),
(27, 23, '2020-08-25 12:24:07', 34, 0, '123.00'),
(28, 1, '2020-08-25 12:24:07', 48, 0, '34.34'),
(29, 24, '2020-08-25 12:25:04', 800, 0, '69.00'),
(30, 24, '2020-08-25 12:25:04', 752, 0, '69.00'),
(31, 21, '2020-08-25 12:25:04', 57, 0, '69.00'),
(32, 25, '2020-08-25 12:26:03', 50, 0, '69.00'),
(33, 21, '2020-08-25 12:26:03', 7, 0, '69.00'),
(42, 27, '2020-08-25 12:26:44', 888, 0, '12.00'),
(43, 16, '2020-08-25 12:26:44', 337, 1, '22.00'),
(44, 28, '2020-08-25 12:27:05', 1000, 0, '123.00'),
(45, 28, '2020-08-25 12:27:05', 993, 0, '123.00'),
(46, 28, '2020-08-25 12:27:05', 593, 1, '123.00'),
(47, 29, '2020-08-25 12:33:07', 145, 0, '11.00'),
(48, 4, '2020-08-25 12:33:07', 305, 0, '12.78'),
(56, 33, '2020-08-25 12:37:43', 11, 0, '12.00'),
(57, 4, '2020-08-25 12:37:43', 294, 1, '12.78'),
(58, 34, '2020-08-25 12:38:13', 1242, 0, '14.00'),
(63, 37, '2020-08-25 12:41:56', 234, 0, '156.00'),
(65, 38, '2020-08-25 12:44:53', 124, 1, '12.00'),
(67, 40, '2020-08-25 12:51:49', 14, 1, '155.00'),
(68, 41, '2020-08-25 12:51:55', 1234, 1, '12.00'),
(69, 42, '2020-08-25 12:53:02', 12342, 1, '1342.00');

-- --------------------------------------------------------

--
-- Table structure for table `party`
--

CREATE TABLE `party` (
  `symbol` varchar(5) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `party`
--

INSERT INTO `party` (`symbol`, `name`) VALUES
('LCH', 'LCHName'),
('XLON', 'London Exchange');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `symbol` varchar(5) NOT NULL,
  `ordersToday` int(11) NOT NULL,
  `volumeToday` int(11) NOT NULL,
  `latestMatch` decimal(10,2) NOT NULL,
  `tickSize` decimal(3,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`symbol`, `ordersToday`, `volumeToday`, `latestMatch`, `tickSize`) VALUES
('AMZN', 1000, 3400, '1600.56', '0.01'),
('APPL', 150, 200, '34.15', '0.05'),
('GOOG', 200, 300, '13.20', '1.00'),
('LOOP', 111, 123, '12.31', '0.01'),
('SDME', 321, 123, '334.56', '1.00');

-- --------------------------------------------------------

--
-- Table structure for table `trades`
--

CREATE TABLE `trades` (
  `id` int(11) NOT NULL,
  `buyOrderVersion` int(11) NOT NULL,
  `sellOrderVersion` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `time` datetime NOT NULL,
  `size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trades`
--

INSERT INTO `trades` (`id`, `buyOrderVersion`, `sellOrderVersion`, `price`, `time`, `size`) VALUES
(1, 1, 1, '145.69', '2020-08-23 19:02:09', 150),
(2, 3, 4, '123.66', '2020-08-24 14:54:14', 99),
(3, 12, 2, '34.34', '2020-08-25 11:57:51', 123),
(4, 14, 13, '34.34', '2020-08-25 11:58:17', 111),
(5, 4, 17, '123.89', '2020-08-25 11:59:17', 11),
(6, 18, 19, '123.89', '2020-08-25 12:00:09', 100),
(7, 11, 21, '22.00', '2020-08-25 12:11:32', 1231),
(8, 22, 23, '22.00', '2020-08-25 12:11:32', 3),
(9, 25, 15, '34.34', '2020-08-25 12:24:07', 116),
(10, 27, 26, '34.34', '2020-08-25 12:24:07', 34),
(11, 29, 28, '34.34', '2020-08-25 12:25:04', 48),
(12, 30, 20, '69.00', '2020-08-25 12:25:04', 752),
(13, 32, 31, '69.00', '2020-08-25 12:26:03', 50),
(21, 24, 42, '22.00', '2020-08-25 12:26:44', 888),
(22, 44, 33, '69.00', '2020-08-25 12:27:05', 7),
(23, 45, 3, '111.11', '2020-08-25 12:27:05', 400),
(24, 5, 47, '12.78', '2020-08-25 12:33:07', 145),
(28, 48, 56, '12.78', '2020-08-25 12:37:43', 11),
(31, 63, 58, '14.00', '2020-08-25 12:41:56', 234);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `audit`
--
ALTER TABLE `audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_orders_party` (`party`),
  ADD KEY `fk_orders_stock` (`stock`);

--
-- Indexes for table `orderversion`
--
ALTER TABLE `orderversion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_orderversion_order` (`orders`);

--
-- Indexes for table `party`
--
ALTER TABLE `party`
  ADD PRIMARY KEY (`symbol`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`symbol`);

--
-- Indexes for table `trades`
--
ALTER TABLE `trades`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_trades_buyOrderVersion` (`buyOrderVersion`),
  ADD KEY `fk_trades_sellOrderVersion` (`sellOrderVersion`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `audit`
--
ALTER TABLE `audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `orderversion`
--
ALTER TABLE `orderversion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `trades`
--
ALTER TABLE `trades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_orders_party` FOREIGN KEY (`party`) REFERENCES `party` (`symbol`),
  ADD CONSTRAINT `fk_orders_stock` FOREIGN KEY (`stock`) REFERENCES `stock` (`symbol`);

--
-- Constraints for table `orderversion`
--
ALTER TABLE `orderversion`
  ADD CONSTRAINT `fk_orderversion_order` FOREIGN KEY (`orders`) REFERENCES `orders` (`id`);

--
-- Constraints for table `trades`
--
ALTER TABLE `trades`
  ADD CONSTRAINT `fk_trades_buyOrderVersion` FOREIGN KEY (`buyOrderVersion`) REFERENCES `orderversion` (`id`),
  ADD CONSTRAINT `fk_trades_sellOrderVersion` FOREIGN KEY (`sellOrderVersion`) REFERENCES `orderversion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
