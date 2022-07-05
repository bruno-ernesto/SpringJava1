create database ejercicio1_new;
use ejercicio1_new;
create table Employee
(id int unsigned not null auto_increment,
 surname varchar(30),
 firstname varchar(30),
 primary key(id) );
 select * from ejercicio1_new.Employee;  # ---1
 #INSERT INTO ciudades (ciudad) VALUES ('Tijuana');
 insert into Employee (id,surname,firstname) values (1,'Bruno','Zamorano');

create table Language
(id int unsigned not null auto_increment,
 code_l varchar(2),
 name_l varchar(30),
  foreign key (id) references Employee(id));
   
select * from ejercicio1_new.language; #--->2
insert into Language (id,code_l,name_l) values (1,'es','español (o castellano)');
create table Country
(id int unsigned not null auto_increment,
code_C varchar(3),
name_C varchar (30),
foreign key (id) references employee(id));
select * from ejercicio1_new.Country; #--->3	
insert into Country (id,code_C,name_C) values (1,'52','México');
create table Airport
(id int unsigned not null auto_increment,
name_A varchar(50),
foreign key(id) references Country(id));
select * from ejercicio1_new.Airport;#--->4
insert into Airport(id,name_A) values(1,'Aeropuerto Internacional Benito Juárez');
