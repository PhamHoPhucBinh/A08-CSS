CREATE DATABASE s12;
USE s12;

create table products (
 id  int(3) NOT NULL auto_increment,
 name varchar(120) NOT NULL,
 price float NOT NULL,
 detail varchar(120),
 manufacturer varchar(120),
 PRIMARY KEY (id)
);
insert into products(name, price, detail,manufacturer) values('shirt','250000','for summer','nike');
insert into products(name, price, detail,manufacturer) values('pants','350000','short','adidas');
select * from products;