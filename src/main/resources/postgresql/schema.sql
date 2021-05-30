drop table if no exists users;

CREATE TABLE users(
	document_number VARCHAR(50) not null,
	active BOOL not null,
	area VARCHAR(100) not null,
	country VARCHAR(100) not null,
	document_type VARCHAR(250) not null,
	email VARCHAR(300) not null,
	enter_date VARCHAR(50) not null,
	first_name VARCHAR(20) not null,
	first_surname VARCHAR(20) not null,
	modification_date VARCHAR(50) not null,
	other_name VARCHAR(50),
	registration_date VARCHAR(50) not null,
	second_surname VARCHAR(20) not null
);

alter table users add constraint pk_users primary key(documentNumber);
