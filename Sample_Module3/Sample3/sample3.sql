CREATE DATABASE IF NOT EXISTS sample3;

USE sample3;

CREATE TABLE IF NOT EXISTS product (
  productId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  productName nVARCHAR(255) NOT NULL,
  productDescription nVARCHAR(255) NOT NULL,
  productPrice DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS `order` (
  orderId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  orderDate DATE NOT NULL,
  productId INT NOT NULL,
  quantity INT NOT NULL,
  FOREIGN KEY (productId) REFERENCES product(productId)
);
INSERT INTO `order` (orderDate, productId, quantity) VALUES
  ('2022-01-01', 1, 5),
  ('2022-01-02', 3, 3),
  ('2022-01-03', 2, 2);
INSERT INTO product (productName, productDescription, productPrice) VALUES
  ('Product 1', 'Description of product 1', 10.99),
  ('Product 2', 'Description of product 2', 9.99),
  ('Product 3', 'Description of product 3', 12.99),
  ('Product 4', 'Description of product 4', 7.99),
  ('Product 5', 'Description of product 5', 15.99);
  ALTER TABLE `order` ADD COLUMN isDelete BOOLEAN NOT NULL DEFAULT false;
INSERT INTO `order`( orderDate, productId, quantity) VALUES ( '1996-01-01', 4, 4);
  select * from product;
  select * from `order`;
update `order` set orderDate = '1996-04-04',productId = 4, quantity =4 where orderId = 4;