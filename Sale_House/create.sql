drop table users;
drop table district;
drop table STREET;
drop table HOUSETYPE;
drop table HOUSE;
create database salehousedb;
use salehousedb;
select * from users;
select * from house;
--用户表
create table users
(
  id        int  primary key,        				/*用户*/
  name      VARCHAR(50),           					/*登录名*/
  password  VARCHAR(50),          					 /*用户密码*/
  telephone VARCHAR(15),           					/*电话*/
  username  VARCHAR(50),          					/*真实名*/
  isadmin   VARCHAR(5)            					 /*是否管理员*/
);

insert into users (name ,password,telephone,username,isadmin) values ('admin','a','1233456789','张三','是');

--地区表
create table district
(
  id   int primary key,              /*地区id*/
  name VARCHAR(50) not null         /*地区名*/
);
--街道表
create table street
(
  id          int primary key,      /*街道id*/
  name        VARCHAR(50),         /*街道名*/
  district_id int                /*地区id*/
);
--房屋类型表
create table housetype
(
  id   int primary key,              /*类型id*/
  name VARCHAR(10) not null         /*类型名*/
);
--房屋信息表
create table HOUSE
(
  id         int primary key auto_increment,                 /*信息id*/
  title       VARCHAR(50),          /*信息标题*/
  description VARCHAR(2000),        /*描述*/
  price       double,                 /*价格*/
  pubdate     DATE,                   /*发布日期*/
  floorage    double,                 /*面积*/
  contact     VARCHAR(100),          /*联系方式*/
  user_id     int,                 /*发信息人id*/
  type_id     int,                 /*房屋类型id*/
  street_id   int                  /*街道id*/
);
insert  into house(title,description,price,pubdate,floorage,contact,user_id,type_id,street_id) values ('出租','good',200.0,now(),200.0,'123456789',1,1001,1002);
insert  into house(title,description,price,pubdate,floorage,contact,user_id,type_id,street_id) values ('出租','good',2200.0,now(),200.0,'123456789',1,1002,1006);
insert  into house(title,description,price,pubdate,floorage,contact,user_id,type_id,street_id) values ('出租','good',4600.0,now(),600.0,'123456789',1,1006,1004);

select * from house;




