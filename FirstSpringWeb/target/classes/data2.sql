create table province(
	pid int primary key auto_increment,
	pname varchar(50)
)
create table city(
	cid int primary key auto_increment,
	cname varchar(50),
	pid int 
)
select cid ,cname,pid,pname from city inner join 
drop table city
alter table  city
	add constraint fk_province_city
		foreign key(pid) references province(pid);
		
insert into province(pname) values('湖南');
insert into province(pname) values('湖北');
insert into province(pname) values('广东');
insert into city(cname,pid) values('衡阳' ,1);
insert into city(cname,pid) values('长沙' ,1);
insert into city(cname,pid) values('武汉' ,2);
insert into city(cname,pid) values('广州' ,3);
insert into city(cname,pid) values('深圳' ,3);
select * from province
select * from city
create database user1
show databases;
use database user1

create table student(
	sid int primary key auto_increment,
	sname varchar(50),
	sage int,
	ssex varchar(10),
	sbirthday timestamp,
	classname varchar(50)
)
drop table student
insert into student(sname,sage,ssex,sbirthday,classname) values('张三',20,'男','19930602000000','一班');
insert into student(sname,sage,ssex,sbirthday,classname) values('张三',25,'男','19950802000000','二班');
insert into student(sname,sage,ssex,sbirthday,classname) values('张三',15,'男','19940602000000','三班');
insert into student(sname,sage,ssex,sbirthday,classname) values('王三',10,'男','19951102000000','一班');
drop table student;
insert into student(sname,sage) values('张三','17');
insert into student(sname,sage) values('李四','19');
insert into student(sname,sage) values('王五','27');
insert into student(sname,sage) values('王六','37');
select * from student



-----------------影院售票系统
create table filminfo(
	filmid int primary key auto_increment, --影片id
	typeid int,--类型id
	filmname varchar(100),--影片名字
	actor varchar(100),-- 主演
	director varchar(100), --导演
	ticketprice numeric --票价格
);
select * from filminfo ,filmtype where filmtype.typeid=filminfo.typeid and filmtype.typeid=1
select * from filminfo ,filmtype where filmtype.typeid=filminfo.typeid
select * from filminfo where filmid=9 and ticketprice between 180 and 200
delete from filminfo
commit
create table filmtype(
	typeid int primary key auto_increment,
	typename varchar(100)
);

create table person(
	typeid int primary key auto_increment,
	typename varchar(100)
);

alter table  filminfo
	add constraint fk_filmtype_filminfo
		foreign key(typeid) references filmtype(typeid);
insert into person(typename) values('战争');
insert into person(typename) values('搞笑');
insert into person(typename) values('爱情');
insert into person(typename) values('生活');
insert into person(typename) values('战争1');
insert into person(typename) values('搞笑1');
insert into person(typename) values('爱情1');
insert into person(typename) values('生活1');
insert into person(typename) values('战争2');
insert into person(typename) values('搞笑2');
insert into person(typename) values('爱情2');
insert into person(typename) values('生活3');
commit

select * from filmtype