-- Active: 1667580462650@@127.0.0.1@3306@inventorySystem
CREATE DATABASE IF NOT EXISTS inventorySystem;

USE inventorySystem;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS Supplier;
DROP TABLE IF EXISTS user;
SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE product (
 productName VARCHAR(50) NOT NULL,
 expiryDate DATE,
 quantity INTEGER,
 productValue DECIMAL,			
 PRIMARY KEY (productName)
) ENGINE = InnoDB;


CREATE TABLE supplier (
 supplierName VARCHAR(50) NOT NULL,
 supplierEmail VARCHAR(50),
 product VARCHAR(50),
 PRIMARY KEY (supplierName),
 CONSTRAINT FK_sup_prod FOREIGN KEY (product) REFERENCES product (productName) ON DELETE SET NULL) ENGINE = InnoDB;

 CREATE TABLE user(
    username varchar(50) NOT NULL,
    email varchar(50),
    userPassword VARCHAR(50)
 ) ENGINE = InnoDB;

  CREATE TABLE Transaction(
    product varchar(50),
    transDate DATE,
    transQuantity INT,
    CONSTRAINT FK_sup_prod FOREIGN KEY (product) REFERENCES product (productName) ON DELETE SET NULL) ENGINE = InnoDB;

