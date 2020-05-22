-- create table if not exists USER (
-- USE_ID int not null primary key auto_increment,
-- USE_NAME varchar(100),
-- USE_SEX varchar(1),
-- USE_AGE NUMBER(3),
-- USE_ID_NO VARCHAR(18),
-- USE_PHONE_NUM VARCHAR(11),
-- USE_EMAIL VARCHAR(100),
-- CREATE_TIME DATE,
-- MODIFY_TIME DATE,
-- USE_STATE VARCHAR(1));

/*学生表tb_stuGrade*/
create table if not exists tb_stuGrade (
id int not null primary key auto_increment,
stuID   varchar(20) not null unique,
stuName  varchar(10) not null ,
grade FLOAT
);

create table if not exists tb_stuInfo (
id int not null primary key auto_increment,
classID varchar(20),
className varchar(20),
stuID varchar(20),
stuName varchar(20),
sex varchar(2)
);

create table if not exists tb_user (
id int not null primary key auto_increment,
userID varchar(20),
userName varchar(10),
userPwd varchar(20)
);