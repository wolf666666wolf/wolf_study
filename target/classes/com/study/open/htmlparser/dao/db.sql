net stop mysql
net start mysql;

show create table district;
alter table district modify name varchar(50) character set UTF8;

create database homelink;
create table DISTRICT( name varchar(50), pname varchar(200), url varchar(200), num integer(10));
insert into DISTRICT values('望京','朝阳','www.baidu.com',1000);

create table Community( name varchar(50), pname varchar(200), url varchar(200), price integer(10) , num integer(10));
create table House( name varchar(50), pname varchar(200), url varchar(200), price integer(10) , value integer(10), area varchar(50), rooms varchar(50), indate date);

create table BlackName(url varchar(200), areatype varchar(50),opertype varchar(50));

select h.url, h.name,(c.price-h.price)/c.price as relPrice from District d, Community c, House h
where d.url = c.pname
  and c.url = h.pname
  and (c.price-h.price)/c.price > 0.1
  and c.url not in (select url from blackname where type='C')
  and c.url not in (select url from blackname where type='H')
  and h.value>60
  and h.value<100
 order by relPrice desc  
 limit 0,10
  
  
select c.url, c.price, a.avgprice
from
(select pname, avg(price)as avgprice from house group by pname) as a,
community c
where c.url=a.pname
limit 0,10

update community c
set c.price=(select avg(price)as avgprice from house h where h.pname=c.url)   

