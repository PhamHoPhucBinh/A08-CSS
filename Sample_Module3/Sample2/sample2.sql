create database sample2;
use sample2;
CREATE TABLE product (
  product_id INT PRIMARY KEY not null,
  product_name VARCHAR(255) not null,
  price Float not null
);
CREATE TABLE customer (
  customer_id INT PRIMARY KEY not null AUTO_INCREMENT,
  name VARCHAR(255) not null,
  birthday DATE not null,
  address VARCHAR(255) not null,
  phone VARCHAR(20) not null,
  product_id INT not null,
  FOREIGN KEY (product_id) REFERENCES product(product_id)
);


INSERT INTO product (product_id, product_name, price)
VALUES
  (1, 'Iphone 13 Pro Max', 35000000),
  (2, 'Samsung Galaxy S21 Ultra', 25000000),
  (3, 'Xiaomi 11T Pro', 15000000),
  (4, 'Oppo Find X3 Pro', 20000000),
  (5, 'OnePlus 10 Pro', 30000000),
  (6, 'MacBook Pro 2021', 50000000),
  (7, 'Dell XPS 13', 30000000),
  (8, 'Asus ROG Zephyrus G15', 35000000),
  (9, 'Lenovo ThinkPad X1 Carbon', 40000000),
  (10, 'HP Spectre x360', 45000000);

INSERT INTO customer (customer_id, name, birthday, address, phone, product_id)
VALUES 
  (1, 'Nguyen Van A', '1990-01-01', 'Hanoi, Vietnam', '0123456789', 1),
  (2, 'Tran Thi B', '1995-02-01', 'HCMC, Vietnam', '0987654321', 2),
  (3, 'Le Van C', '2000-03-01', 'Da Nang, Vietnam', '0912345678', 3),
  (4, 'Pham Thi D', '1985-04-01', 'Hue, Vietnam', '0911111111', 4),
  (5, 'Hoang Van E', '1998-05-01', 'Quang Ngai, Vietnam', '0888888888', 5);



select * from customer;
select * from product;

ALTER TABLE Customer
ADD COLUMN IsDelete BOOLEAN NOT NULL DEFAULT FALSE;
