DROP DATABASE IF EXISTS orderBook;

CREATE DATABASE orderBook;

USE orderBook;



CREATE TABLE `stock` (
    `symbol` varChar(5)  NOT NULL ,
    `ordersToday` int  NOT NULL ,
    `volumeToday` int  NOT NULL ,
    `latestMatch` Decimal(10,2)  NOT NULL ,
    `tickSize` Decimal(3,2)  NOT NULL ,
    PRIMARY KEY (
        `symbol`
    )
);

CREATE TABLE `party` (
    `symbol` varChar(5)  NOT NULL ,
    `name` varchar(50)  NOT NULL ,
    PRIMARY KEY (
        `symbol`
    )
);

CREATE TABLE `order` (
    `id` int AUTO_INCREMENT NOT NULL ,
    `party` varChar(5)  NOT NULL ,
    `stock` varchar(5)  NOT NULL ,
    `buy` boolean  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `orderVersion` (
    `id` int AUTO_INCREMENT NOT NULL ,
    `order` int  NOT NULL ,
    `time` Datetime  NOT NULL ,
    `size` int  NOT NULL ,
    `active` boolean  NOT NULL ,
    `price` Decimal(10,2)  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `trades` (
    `id` int  AUTO_INCREMENT NOT NULL ,
    `buyOrderVersion` int  NOT NULL ,
    `sellOrderVersion` int  NOT NULL ,
    `price` Decimal(10,2)  NOT NULL ,
    `time` Datetime  NOT NULL ,
    `size` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `audit` (
    `id` int AUTO_INCREMENT  NOT NULL ,
    `time` DateTime  NOT NULL ,
    `message` Mediumtext  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

ALTER TABLE `order` ADD CONSTRAINT `fk_order_party` FOREIGN KEY(`party`)
REFERENCES `party` (`symbol`);