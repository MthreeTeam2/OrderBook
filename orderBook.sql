DROP DATABASE `orderbook`;
CREATE DATABASE IF NOT EXISTS `orderbook`;
USE `orderbook`;

CREATE TABLE IF NOT EXISTS `audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `message` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `party` varchar(5) NOT NULL,
  `stock` varchar(5) NOT NULL,
  `buy` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)  
);



CREATE TABLE IF NOT EXISTS `orderversion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `size` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `party` (
  `symbol` varchar(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`symbol`)
);



CREATE TABLE IF NOT EXISTS `stock` (
  `symbol` varchar(5) NOT NULL,
  `ordersToday` int(11) NOT NULL,
  `volumeToday` int(11) NOT NULL,
  `latestMatch` decimal(10,2) NOT NULL,
  `tickSize` decimal(3,2) NOT NULL,
  PRIMARY KEY (`symbol`)
);

CREATE TABLE IF NOT EXISTS `trades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyOrderVersion` int(11) NOT NULL,
  `sellOrderVersion` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `time` datetime NOT NULL,
  `size` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `orderversion`
  ADD CONSTRAINT `fk_orderversion_order` FOREIGN KEY (`orders`) REFERENCES `orders` (`id`);

ALTER TABLE `orders`
	ADD CONSTRAINT `fk_orders_party` FOREIGN KEY (`party`) REFERENCES `party` (`symbol`),
 	ADD CONSTRAINT `fk_orders_stock` FOREIGN KEY (`stock`) REFERENCES `stock` (`symbol`);

ALTER TABLE `trades`
  ADD CONSTRAINT `fk_trades_buyOrderVersion` FOREIGN KEY (`buyOrderVersion`) REFERENCES `orderversion` (`id`),
  ADD CONSTRAINT `fk_trades_sellOrderVersion` FOREIGN KEY (`sellOrderVersion`) REFERENCES `orderversion` (`id`);






DROP DATABASE `orderbooktest`;
CREATE DATABASE IF NOT EXISTS `orderbooktest`;
USE `orderbooktest`;

CREATE TABLE IF NOT EXISTS `audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `message` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `party` varchar(5) NOT NULL,
  `stock` varchar(5) NOT NULL,
  `buy` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)  
);



CREATE TABLE IF NOT EXISTS `orderversion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `size` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `party` (
  `symbol` varchar(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`symbol`)
);



CREATE TABLE IF NOT EXISTS `stock` (
  `symbol` varchar(5) NOT NULL,
  `ordersToday` int(11) NOT NULL,
  `volumeToday` int(11) NOT NULL,
  `latestMatch` decimal(10,2) NOT NULL,
  `tickSize` decimal(3,2) NOT NULL,
  PRIMARY KEY (`symbol`)
);

CREATE TABLE IF NOT EXISTS `trades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyOrderVersion` int(11) NOT NULL,
  `sellOrderVersion` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `time` datetime NOT NULL,
  `size` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `orderversion`
  ADD CONSTRAINT `fk_orderversion_order` FOREIGN KEY (`orders`) REFERENCES `orders` (`id`);

ALTER TABLE `orders`
	ADD CONSTRAINT `fk_orders_party` FOREIGN KEY (`party`) REFERENCES `party` (`symbol`),
 	ADD CONSTRAINT `fk_orders_stock` FOREIGN KEY (`stock`) REFERENCES `stock` (`symbol`);

ALTER TABLE `trades`
  ADD CONSTRAINT `fk_trades_buyOrderVersion` FOREIGN KEY (`buyOrderVersion`) REFERENCES `orderversion` (`id`),
  ADD CONSTRAINT `fk_trades_sellOrderVersion` FOREIGN KEY (`sellOrderVersion`) REFERENCES `orderversion` (`id`);
