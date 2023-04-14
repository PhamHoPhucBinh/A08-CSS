create database thim3;
use thim3;

CREATE TABLE product (
  productId INT AUTO_INCREMENT NOT NULL,
  productName nVARCHAR(255) NOT NULL,
  productPrice double NOT NULL,
  quantity INT NOT NULL,
  color VARCHAR(50) NOT NULL,
  categoryId INT NOT NULL,
  isDelete boolean NOT NULL,
  PRIMARY KEY (productId),
  FOREIGN KEY (categoryId) REFERENCES category(categoryId)
);

CREATE TABLE category (
  categoryId INT AUTO_INCREMENT NOT NULL,
  manufacturer VARCHAR(255) NOT NULL,
  PRIMARY KEY (categoryId)
);
INSERT INTO product (productName, productPrice, quantity, color, categoryId, isDelete) VALUES
('Product A', 10.99, 100, 'Red', 1, 0),
('Product B', 19.99, 50, 'Blue', 1, 0),
('Product C', 5.99, 200, 'Green', 2, 0),
('Product D', 7.99, 150, 'Yellow', 2, 1),
('Product E', 14.99, 75, 'Black', 3, 0);

INSERT INTO category (manufacturer) VALUES
('Iphone'),
('Samsung'),
('LG'),
('Xiaomi'),
('Huawei');


