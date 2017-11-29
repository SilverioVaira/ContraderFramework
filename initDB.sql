drop database if exists contrader;
create database contrader;

Use contrader;

drop table if exists contrader.users;
create table contrader.users (
	idUser int(20) not null auto_increment,
	username varchar(50), 
	password varchar(50),
	firstName varchar(50),
    lastName varchar(50),
    fiscalCode varchar(50),
    DateOfBirth varchar(50),
    businessName varchar(50),
    vat varchar(50),
    town varchar(50),
    postCode varchar(50),
    city varchar(50),
    address varchar(50),
    telephone varchar(50),
    role varchar(50),
    primary key (idUser)
);

drop table if exists contrader.gomme;
create table contrader.gomme (
	idGomme int(20) not null auto_increment,
	model varchar(50), 
    manufacturer varchar(50), 
    price float,
    width float,
    height float,
    diameter float,
    weight float,
    speed varchar(3),
    season varchar(50),
    vehicle varchar(50),
    primary key (idGomme)
);


drop table if exists vehicle;
create table vehicle (
	idVehicle int(20) not null auto_increment,
    brand varchar(50),
    fuel varchar(50),
    version varchar(50),
    capacity varchar(50),
    primary key (idVehicle)
);

drop table if exists compatibility;
create table compatibility(
	idGomme int(20) not null,
    idVehicle int(20) not null,
    primary key (idGomme, idVehicle),
    foreign key (idGomme) references contrader.gomme (idGomme),
    foreign key (idVehicle) references vehicle (idVehicle)
);



