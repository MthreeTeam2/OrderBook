-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2020 at 01:48 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `orderbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `audit`
--

DROP DATABASE IF EXISTS orderbook;

CREATE DATABASE orderbook;

USE orderbook;

CREATE TABLE `audit` (
  `id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `message` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `audit`
--

INSERT INTO `audit` (`id`, `time`, `message`) VALUES
(83, '2020-08-27 09:45:10', 'ORDER 49: CP1 BUY GOOG CREATED.'),
(84, '2020-08-27 09:45:15', 'ORDER 50: CP1 BUY GOOG CREATED.'),
(85, '2020-08-27 09:45:33', 'ORDER 51: CP1 BUY GOOG CREATED.'),
(86, '2020-08-27 09:45:36', 'ORDER 51: CP1 BUY GOOG CANCELLED.'),
(87, '2020-08-27 09:45:52', 'ORDER 52: CP1 BUY GOOG CREATED.'),
(88, '2020-08-27 09:45:59', 'ORDER 53: CP1 BUY GOOG CREATED.'),
(89, '2020-08-27 09:46:44', 'ORDER 54: CP1 BUY GOOG CREATED.'),
(90, '2020-08-27 09:46:54', 'ORDER 55: CP1 BUY GOOG CREATED.'),
(91, '2020-08-27 09:47:04', 'ORDER 56: CP1 BUY GOOG CREATED.'),
(92, '2020-08-27 09:47:19', 'ORDER 57: CP1 BUY GOOG CREATED.'),
(93, '2020-08-27 09:47:28', 'ORDER 58: CP1 BUY GOOG CREATED.'),
(94, '2020-08-27 09:47:38', 'ORDER 59: CP1 SELL GOOG CREATED.'),
(95, '2020-08-27 09:47:38', 'TRADE 37 BUY ORDER VERSION: 97 SELL ORDER VERSION: 98 PRICE: 30.00 SIZE: 20'),
(96, '2020-08-27 09:47:51', 'ORDER 60: CP1 SELL GOOG CREATED.'),
(97, '2020-08-27 09:47:58', 'ORDER 61: CP1 SELL GOOG CREATED.'),
(98, '2020-08-27 09:48:03', 'ORDER 62: CP1 BUY GOOG CREATED.'),
(99, '2020-08-27 09:48:03', 'TRADE 38 BUY ORDER VERSION: 101 SELL ORDER VERSION: 99 PRICE: 30.00 SIZE: 20'),
(100, '2020-08-27 09:48:03', 'TRADE 39 BUY ORDER VERSION: 102 SELL ORDER VERSION: 100 PRICE: 34.00 SIZE: 20'),
(101, '2020-08-27 09:48:26', 'ORDER 63: CP1 SELL GOOG CREATED.'),
(102, '2020-08-27 09:48:26', 'TRADE 40 BUY ORDER VERSION: 103 SELL ORDER VERSION: 104 PRICE: 35.00 SIZE: 250'),
(103, '2020-08-27 09:48:26', 'TRADE 41 BUY ORDER VERSION: 105 SELL ORDER VERSION: 106 PRICE: 35.00 SIZE: 40'),
(104, '2020-08-27 09:48:34', 'ORDER 64: CP1 BUY GOOG CREATED.'),
(105, '2020-08-27 09:48:42', 'ORDER 65: CP1 SELL GOOG CREATED.'),
(106, '2020-08-27 09:48:42', 'TRADE 42 BUY ORDER VERSION: 107 SELL ORDER VERSION: 109 PRICE: 35.00 SIZE: 170'),
(107, '2020-08-27 09:48:42', 'TRADE 43 BUY ORDER VERSION: 110 SELL ORDER VERSION: 111 PRICE: 35.00 SIZE: 50'),
(108, '2020-08-27 09:48:42', 'TRADE 44 BUY ORDER VERSION: 108 SELL ORDER VERSION: 112 PRICE: 30.00 SIZE: 70'),
(109, '2020-08-27 09:49:01', 'ORDER 66: CP1 BUY GOOG CREATED.'),
(110, '2020-08-27 09:49:20', 'ORDER 67: CP1 SELL GOOG CREATED.'),
(111, '2020-08-27 09:49:20', 'TRADE 45 BUY ORDER VERSION: 113 SELL ORDER VERSION: 115 PRICE: 30.00 SIZE: 220'),
(112, '2020-08-27 09:49:20', 'TRADE 46 BUY ORDER VERSION: 114 SELL ORDER VERSION: 116 PRICE: 30.00 SIZE: 220'),
(113, '2020-08-27 09:49:38', 'ORDER 68: CP1 SELL GOOG CREATED.'),
(114, '2020-08-27 09:49:46', 'ORDER 69: CP1 SELL GOOG CREATED.'),
(115, '2020-08-27 09:49:54', 'ORDER 70: CP1 SELL GOOG CREATED.'),
(116, '2020-08-27 09:50:07', 'ORDER 71: CP1 SELL GOOG CREATED.'),
(117, '2020-08-27 09:50:34', 'ORDER 72: CP1 SELL GOOG CREATED.'),
(118, '2020-08-27 09:50:45', 'ORDER 73: CP1 SELL GOOG CREATED.'),
(119, '2020-08-27 09:50:45', 'TRADE 47 BUY ORDER VERSION: 96 SELL ORDER VERSION: 122 PRICE: 29.00 SIZE: 31'),
(120, '2020-08-27 09:51:06', 'ORDER 74: CP1 BUY GOOG CREATED.'),
(121, '2020-08-27 09:51:06', 'TRADE 48 BUY ORDER VERSION: 124 SELL ORDER VERSION: 121 PRICE: 32.00 SIZE: 290'),
(122, '2020-08-27 09:51:14', 'ORDER 75: CP1 SELL GOOG CREATED.'),
(123, '2020-08-27 09:51:24', 'ORDER 76: CP1 SELL GOOG CREATED.'),
(124, '2020-08-27 09:51:33', 'ORDER 77: CP1 SELL GOOG CREATED.'),
(125, '2020-08-27 09:52:30', 'ORDER 78: CP2 SELL GOOG CREATED.'),
(126, '2020-08-27 10:02:38', 'ORDER 79: CP2 SELL GOOG CREATED.'),
(127, '2020-08-27 10:02:52', 'ORDER 80: CP3 SELL GOOG CREATED.'),
(128, '2020-08-27 10:02:52', 'TRADE 49 BUY ORDER VERSION: 123 SELL ORDER VERSION: 130 PRICE: 29.00 SIZE: 3'),
(129, '2020-08-27 10:02:52', 'TRADE 50 BUY ORDER VERSION: 95 SELL ORDER VERSION: 131 PRICE: 27.00 SIZE: 20'),
(130, '2020-08-27 10:02:52', 'TRADE 51 BUY ORDER VERSION: 132 SELL ORDER VERSION: 133 PRICE: 27.00 SIZE: 5'),
(131, '2020-08-27 10:04:16', 'ORDER 81: CP2 SELL GOOG CREATED.'),
(132, '2020-08-27 10:04:16', 'TRADE 52 BUY ORDER VERSION: 134 SELL ORDER VERSION: 135 PRICE: 27.00 SIZE: 10'),
(133, '2020-08-27 10:04:16', 'TRADE 53 BUY ORDER VERSION: 93 SELL ORDER VERSION: 136 PRICE: 26.00 SIZE: 30'),
(134, '2020-08-27 10:04:47', 'ORDER 82: CP1 BUY GOOG CREATED.');

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
(49, 'CP1', 'GOOG', 1),
(50, 'CP1', 'GOOG', 1),
(51, 'CP1', 'GOOG', 1),
(52, 'CP1', 'GOOG', 1),
(53, 'CP1', 'GOOG', 1),
(54, 'CP1', 'GOOG', 1),
(55, 'CP1', 'GOOG', 1),
(56, 'CP1', 'GOOG', 1),
(57, 'CP1', 'GOOG', 1),
(58, 'CP1', 'GOOG', 1),
(59, 'CP1', 'GOOG', 0),
(60, 'CP1', 'GOOG', 0),
(61, 'CP1', 'GOOG', 0),
(62, 'CP1', 'GOOG', 1),
(63, 'CP1', 'GOOG', 0),
(64, 'CP1', 'GOOG', 1),
(65, 'CP1', 'GOOG', 0),
(66, 'CP1', 'GOOG', 1),
(67, 'CP1', 'GOOG', 0),
(68, 'CP1', 'GOOG', 0),
(69, 'CP1', 'GOOG', 0),
(70, 'CP1', 'GOOG', 0),
(71, 'CP1', 'GOOG', 0),
(72, 'CP1', 'GOOG', 0),
(73, 'CP1', 'GOOG', 0),
(74, 'CP1', 'GOOG', 1),
(75, 'CP1', 'GOOG', 0),
(76, 'CP1', 'GOOG', 0),
(77, 'CP1', 'GOOG', 0),
(78, 'CP2', 'GOOG', 0),
(79, 'CP2', 'GOOG', 0),
(80, 'CP3', 'GOOG', 0),
(81, 'CP2', 'GOOG', 0),
(82, 'CP1', 'GOOG', 1);

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
(88, 49, '2020-08-27 09:45:09', 100, 1, '20.00'),
(89, 50, '2020-08-27 09:45:15', 100, 1, '22.00'),
(90, 51, '2020-08-27 09:45:33', 100, 0, '213.00'),
(91, 52, '2020-08-27 09:45:52', 130, 1, '24.00'),
(92, 53, '2020-08-27 09:45:59', 25, 1, '21.00'),
(93, 54, '2020-08-27 09:46:44', 30, 0, '26.00'),
(94, 55, '2020-08-27 09:46:54', 500, 1, '25.00'),
(95, 56, '2020-08-27 09:47:04', 20, 0, '27.00'),
(96, 57, '2020-08-27 09:47:19', 34, 0, '29.00'),
(97, 58, '2020-08-27 09:47:28', 20, 0, '30.00'),
(98, 59, '2020-08-27 09:47:38', 20, 0, '30.00'),
(99, 60, '2020-08-27 09:47:51', 20, 0, '30.00'),
(100, 61, '2020-08-27 09:47:58', 20, 0, '34.00'),
(101, 62, '2020-08-27 09:48:03', 290, 0, '35.00'),
(102, 62, '2020-08-27 09:48:03', 270, 0, '35.00'),
(103, 62, '2020-08-27 09:48:03', 250, 0, '35.00'),
(104, 63, '2020-08-27 09:48:26', 290, 0, '30.00'),
(105, 62, '2020-08-27 09:48:26', 210, 0, '35.00'),
(106, 63, '2020-08-27 09:48:26', 40, 0, '30.00'),
(107, 62, '2020-08-27 09:48:26', 170, 0, '35.00'),
(108, 64, '2020-08-27 09:48:34', 290, 0, '30.00'),
(109, 65, '2020-08-27 09:48:42', 290, 0, '30.00'),
(110, 62, '2020-08-27 09:48:42', 50, 0, '35.00'),
(111, 65, '2020-08-27 09:48:42', 120, 0, '30.00'),
(112, 65, '2020-08-27 09:48:42', 70, 0, '30.00'),
(113, 64, '2020-08-27 09:48:42', 220, 0, '30.00'),
(114, 66, '2020-08-27 09:49:01', 220, 0, '30.00'),
(115, 67, '2020-08-27 09:49:20', 440, 0, '30.00'),
(116, 67, '2020-08-27 09:49:20', 220, 0, '30.00'),
(117, 68, '2020-08-27 09:49:38', 200, 1, '40.00'),
(118, 69, '2020-08-27 09:49:46', 32, 1, '39.00'),
(119, 70, '2020-08-27 09:49:54', 36, 1, '37.00'),
(120, 71, '2020-08-27 09:50:07', 100, 1, '34.00'),
(121, 72, '2020-08-27 09:50:34', 290, 0, '32.00'),
(122, 73, '2020-08-27 09:50:45', 31, 0, '25.00'),
(123, 57, '2020-08-27 09:50:45', 3, 0, '29.00'),
(124, 74, '2020-08-27 09:51:06', 290, 0, '35.00'),
(125, 75, '2020-08-27 09:51:14', 290, 1, '35.00'),
(126, 76, '2020-08-27 09:51:24', 20, 1, '34.00'),
(127, 77, '2020-08-27 09:51:33', 20, 1, '31.00'),
(128, 78, '2020-08-27 09:52:30', 33, 1, '34.00'),
(129, 79, '2020-08-27 10:02:38', 290, 1, '34.00'),
(130, 80, '2020-08-27 10:02:52', 28, 0, '27.00'),
(131, 80, '2020-08-27 10:02:52', 25, 0, '27.00'),
(132, 56, '2020-08-27 10:02:52', 15, 0, '27.00'),
(133, 80, '2020-08-27 10:02:52', 5, 0, '27.00'),
(134, 56, '2020-08-27 10:02:52', 10, 0, '27.00'),
(135, 81, '2020-08-27 10:04:16', 40, 0, '26.00'),
(136, 81, '2020-08-27 10:04:16', 30, 0, '26.00'),
(137, 82, '2020-08-27 10:04:47', 35, 1, '29.00');

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
('CP1', 'Counter Party 1'),
('CP2', 'Counter Party 2'),
('CP3', 'Counter Party 3');

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
(37, 97, 98, '30.00', '2020-08-27 09:47:38', 20),
(38, 101, 99, '30.00', '2020-08-27 09:48:03', 20),
(39, 102, 100, '34.00', '2020-08-27 09:48:03', 20),
(40, 103, 104, '35.00', '2020-08-27 09:48:26', 250),
(41, 105, 106, '35.00', '2020-08-27 09:48:26', 40),
(42, 107, 109, '35.00', '2020-08-27 09:48:42', 170),
(43, 110, 111, '35.00', '2020-08-27 09:48:42', 50),
(44, 108, 112, '30.00', '2020-08-27 09:48:42', 70),
(45, 113, 115, '30.00', '2020-08-27 09:49:20', 220),
(46, 114, 116, '30.00', '2020-08-27 09:49:20', 220),
(47, 96, 122, '29.00', '2020-08-27 09:50:45', 31),
(48, 124, 121, '32.00', '2020-08-27 09:51:06', 290),
(49, 123, 130, '29.00', '2020-08-27 10:02:52', 3),
(50, 95, 131, '27.00', '2020-08-27 10:02:52', 20),
(51, 132, 133, '27.00', '2020-08-27 10:02:52', 5),
(52, 134, 135, '27.00', '2020-08-27 10:04:16', 10),
(53, 93, 136, '26.00', '2020-08-27 10:04:16', 30);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=135;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT for table `orderversion`
--
ALTER TABLE `orderversion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- AUTO_INCREMENT for table `trades`
--
ALTER TABLE `trades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

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
