--CREATE DATABASE contacts;
--DROP DATABASE contacts;
DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS person_phone;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS phone;

CREATE TABLE person (
	person_id serial primary key,
	first_name varchar(50),
	last_name varchar (50) not null,
	date_modified timestamp DEFAULT current_timestamp
);

CREATE TABLE address (
	address_id serial primary key,
	street_one varchar(255) not null,
	street_two varchar(255),
	city varchar(50),
	state varchar(50) not null,
	postal_code varchar(20) not null,
	address_type varchar (20),
	other_type_description varchar (255),
	
	constraint chk_address_type CHECK (type IN ('HOME', 'WORK', 'SHIPPING', 'BILLING', 'OTHER') ),
	constraint chk_address_type_other CHECK ( ( address_type = 'OTHER' AND other_type_description IS NOT NULL ) OR
											(address_type != 'OTHER' AND other_type_description IS NULL) )
);

CREATE TABLE person_address (
	person_id bigint,
	address_id bigint,
	
	constraint pk_person_address PRIMARY KEY (person_id, address_id),
	constraint fk_person_address_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	constraint fk_person_address_person_id FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE phone (
	phone_id serial PRIMARY KEY,
	phone_number varchar (32),
	phone_type varchar (10),
	other_type_description varchar(255),
	
	constraint chk_phone_type CHECK (phone_type IN ('HOME', 'WORK', 'MOBILE', 'OTHER')),
	constraint chk_phone_type_description CHECK ((phone_type = 'OTHER' AND other_type_description IS NOT NULL)
												OR (phone_type !='OTHER' AND other_type_description IS NULL))
);

CREATE TABLE person_phone (
	person_id bigint,
	phone_id bigint,
	
	constraint pk_person_phone PRIMARY KEY (person_id, phone_id),
	constraint fk_person_phone_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	constraint fk_person_phone_phone_id FOREIGN KEY (phone_id) REFERENCES phone(phone_id)
);

-- testname1 is always 1, testname2 is always 2
INSERT INTO person (first_name, last_name) VALUES 
	('testfirstname2', 'testlastname2'),
	('testfirstname2', 'testlastname2');
	
-- first phone will always be 1
INSERT INTO phone (phone_number, phone_type) VALUES ('555-555-555', 'WORK');

INSERT INTO person_phone VALUES (1, 1);