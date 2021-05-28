CREATE TABLE users(
    firstSurname VARCHAR(20) not null,
    secondSurname VARCHAR(20) not null,
    firstName VARCHAR(20) not null,
    otherName VARCHAR(50) not null,
    documentType VARCHAR(250) not null,
    documentNumber VARCHAR(250) not null,
    country VARCHAR(100) not null,
    area VARCHAR(100) not null,
    email VARCHAR(250) not null,
    registrationDate VARCHAR(20) not null,
    modificationDate VARCHAR(20) not null,
    active BOOL not null
);

alter table users
add constraint pk_users primary key(documentNumber);
drop table users;
insert into users
values(
        'Cepeda',
        'Alza',
        'Johann',
        'Alfonso',
        'Cédula de Ciudadanía',
        '1020831979',
        'Colombia',
        'Infraestructura',
        'johann.cepeda@cidenet.com',
        '2021-05-28T12:14',
        '2021-05-28T12:14',
        true
    );