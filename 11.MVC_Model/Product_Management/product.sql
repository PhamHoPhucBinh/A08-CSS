create database product;
use product;
create table product(
id int not null auto_increment,
name varchar(120) not null,
price float not null,
detail varchar(256),
manufacturer varchar(120),
primary key (id)
);
insert into product(name,price,detail,manufacturer) values('shirt',120000,'summer suit','nike');
insert into product(name,price,detail,manufacturer) values('pants',240000,'short pants','adidas');

select * from product;