drop table if exists employee;
create table employee(
	id int auto_increment primary key,
	first_name varchar(100),
	last_name varchar(100),
	full_name varchar(255),
	email varchar(256),
	mobile varchar(12),
	address varchar(1024),
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1
); 

alter table employee add column desig varchar(256) after email;
alter table employee add column login varchar(256) after email;

insert into employee(first_name, last_name, full_name, email,login,desig, mobile, address) 
values ('Akshay', 'Dongare', 'Akshay Dongare','akshay.dongare@autumn.com','adongar','developer','1234567890','test address'), 
('Aniket', 'Jadhav', 'Aniket jadhav ','test@autumn.com','ajadhav','developer','1234567890','test address') ,
('Akash', 'Jadhav', 'Akash Jadhav','test@autumn.com','ajadhav1','developer','1234567890','test address') , 
('Mayur', 'Patil', 'Mayur Patil','test@autumn.com','mpatil','developer','1234567890','test address'), 
('Sameer', 'Kumbhar', 'Sameer Kumbhar','test@autumn.com','skumbhar','developer','1234567890','test address') ,
('Yogesh', 'More', 'Yogesh More','test@autumn.com','ymore','developer','1234567890','test address');

drop table if exists user_access;
create table user_access (
	id int auto_increment primary key,
	employee_id int,
	module varchar(256),
	access varchar(256),
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1,
	constraint foreign key (employee_id) references employee(id)
);

insert into user_access(employee_id, module, access) 
values (1, 'ADMNSC', 'SEARCH_EMP'), 
 (1, 'ADMNSC', 'BULK_UPLOAD'),
 (1, 'ADMNSC', 'SEARCH_REQ') ;

drop table if exists location_hierarchy;
create table location_hierarchy(
	id int auto_increment primary key,
	name varchar(256) not null,
	parent int not null,
	comments varchar(1024),
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1
);

insert into location_hierarchy(name,parent,comments) values 
('ORGANIZATION', 0,'initial config'),
('COUNTRY', 1,'initial config'),
('CITY', 2,'initial config'),
('BULDING', 3,'initial config'),
('FLOOR', 4,'initial config')
;

drop table if exists location_data;
create table location_data (
	id int auto_increment primary key,
	name varchar(256) not null,
	type int,
	parent int not null,
	comments varchar(512),
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1,
	constraint foreign key (type) references location_hierarchy(id)
);

insert into location_data(name, type, parent, comments) values 
('AUTUMN', 1, 0, 'initial config'), 
('INDIA', 2, 1, 'initial config'),
('PUNE', 3, 2, 'initial config'),
('CHITRA-I', 4, 3, 'Talawade building'),
('FLOOR-I', 5, 4, 'initial config'),
('FLOOR-II', 5, 4, 'initial config'),
('FLOOR-III', 5, 4, 'initial config'),

('CHITRA-II', 4, 3, 'Talawade building'),
('FLOOR-I', 5, 8, 'initial config'),
('FLOOR-II', 5, 8, 'initial config'),
('FLOOR-III', 5, 8, 'initial config')
;

drop table if exists space_type;
create table space_type(
 id int auto_increment primary key,
 type varchar(256) not null,
 created_date timestamp default current_timestamp,
 is_active bit(1) default 1
);

insert into space_type(type) values
('Single Seat'), 
('Bubble Seat'),
('Small Meeting Room'),
('Big Meeting Room');

drop table if exists space_data;
create table space_data(
	id int auto_increment primary key,
	name varchar(100),
	type int,
	location_id int,
	comments varchar(1024),
	created_date timestamp default current_timestamp,
	x_cord float,
	y_cord float,
	is_active bit(1) default 1,
	constraint foreign key (location_id) references location_data(id),
	constraint foreign key (type) references space_type(id)
); 

insert into space_data(name, type, location_id, comments, x_cord, y_cord) values 
('CHITRA-I/FLOOR-I/WS001', 1, 5,'space created by akshay dongare', 0, 0),
('CHITRA-I/FLOOR-I/WS002', 1, 5,'space created by akshay dongare', 0, 0),
('CHITRA-I/FLOOR-I/WS003', 1, 5,'space created by akshay dongare', 0, 0),
('CHITRA-I/FLOOR-I/SMR001', 3, 5,'space created by akshay dongare', 0, 0),

('CHITRA-I/FLOOR-II/WS001', 1, 6,'space created by akshay dongare', 0, 0),
('CHITRA-I/FLOOR-II/WS002', 1, 6,'space created by akshay dongare', 0, 0),
('CHITRA-I/FLOOR-II/WS003', 1, 6,'space created by akshay dongare', 0, 0),
('CHITRA-I/FLOOR-II/SMR001', 3, 6,'space created by akshay dongare', 0, 0),

('CHITRA-II/FLOOR-I/WS001', 1, 9,'space created by akshay dongare', 0, 0),
('CHITRA-II/FLOOR-I/WS002', 1, 9,'space created by akshay dongare', 0, 0),
('CHITRA-II/FLOOR-I/WS003', 1, 9,'space created by akshay dongare', 0, 0),
('CHITRA-II/FLOOR-I/SMR001', 3, 9,'space created by akshay dongare', 0, 0)
;

drop table if exists org_hierarchy;
create table org_hierarchy (
	id int auto_increment primary key,
	name varchar(256) not null,
	parent int not null,
	comments varchar(1024),
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1
);

insert into org_hierarchy(name, parent, comments) values
('ORGANIZATION', 0, 'created by Akshay Dongare'),
('BU', 1, 'created by Akshay Dongare'),
('PROJECT', 2, 'created by Akshay Dongare')
;

drop table if exists org_data;
create table org_data (
	id int auto_increment primary key,
	name varchar(256) not null,
	type int,
	parent int not null,
	comments varchar(512),
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1,
	constraint foreign key (type) references org_hierarchy(id)
);

insert into org_data (name, type, parent, comments) values 
('AUTUMN', 1, 0, 'created by Akshay'),
('EUROPE INSURANCE', 2, 1, 'Europe insurance web apps developement projects bu'),
('SDK JAVA APPS', 3, 2, 'SDK Bank java projects'),
('INDIA BANKING', 2, 1, 'India banking projects bu'),
('RBI LEGACY MAIN', 3, 4, 'RBI legacy apps maintance'),
('India Banking Talent Pool', 3, 4, 'bench')
;

drop table if exists request_type;
create table request_type (
	id int auto_increment primary key,
	type varchar(256) not null,
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1
);

insert into request_type(type) values 
('SEAT REQUEST'),
('SPACE REQUEST'),
('SEAT EXTENSION'),
('SPACE EXTENSION'),
('SEAT RELEASE'),
('SPACE RELEASE')
;

drop table if exists request_status_master;
create table request_status_master(
	id int auto_increment primary key,
	name varchar(256),
	next int not null,
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1
);

insert into request_status_master(name, next) values 
('NEW', 2),
('PENDING FOR APPROVAL', 3),
('APPROVED', 4),
('FULLFILED', 0),

('REJECTD', 0),
('CANCELLED', 0)
;

drop table if exists request_data;
create table request_data (
	id int auto_increment primary key,
	type int,
	employee_id int,
	space_id int not null,
	project_id int not null,
	raised_by int not null,
	status int default 1,
	created_date timestamp default current_timestamp,
	constraint foreign key (type) references request_type(id),
	constraint foreign key (space_id) references space_data(id),
	constraint foreign key (status) references request_status_master(id)
);

insert into request_data(type,employee_id,space_id,project_id,raised_by,status) values
(1,2,1,3,1,2),

(1,3,2,5,1,3),
(1,4,3,3,1,4),
(1,5,5,5,1,4)
;

drop table if exists allocations;
create table allocations(
	id int auto_increment primary key,
	space_id int,
	employee_id int,
	project_id int,
	type varchar(50),
	request_id int,
	created_date timestamp default current_timestamp,
	is_active bit(1) default 1,
	constraint foreign key (request_id) references request_data(id)
);

insert into allocations(space_id, employee_id, project_id, type, request_id) values
(3, 4, 3, 'SEAT', 3),
(5, 5, 5, 'SEAT', 4)
;

