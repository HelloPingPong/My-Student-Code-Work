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
	last_name varchar(50) not null,
	date_modified timestamp DEFAULT current_timestamp
);

CREATE TABLE address (
	address_id serial primary key,
	line_one varchar(255) not null,
	line_two varchar(255),
	city varchar(50), 
	district varchar(50) not null,
	postal_code varchar(20) not null,
	address_type varchar(10),
	other_type_description varchar(255),
	
	constraint chk_address_type CHECK ( address_type IN ('HOME', 'WORK', 'SHIPPING', 'BILLING', 'OTHER' ) ),
	constraint chk_address_type_other CHECK ( (address_type = 'OTHER' AND other_type_description IS NOT NULL) OR 
											 (address_type != 'OTHER' AND other_type_description IS NULL) )
);


CREATE table person_address (
	person_id bigint,
	address_id bigint,
	
	constraint pk_person_address PRIMARY KEY (person_id, address_id),
	constraint fk_person_address_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	constraint fk_person_address_address_id FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE table phone (
	phone_id serial primary key,
	phone_number varchar(32),
	phone_type varchar(10),
	other_type_description varchar(255),
	
	constraint chk_phone_type CHECK ( phone_type IN ('HOME', 'WORK', 'MOBILE', 'OTHER') ),
	constraint chk_phone_type_description CHECK ( (phone_type = 'OTHER' AND other_type_description IS NOT NULL) 
												 OR (phone_type != 'OTHER' AND other_type_description IS NULL) )
);

CREATE table person_phone (
	person_id bigint,
	phone_id bigint,
	
	constraint pk_person_phone PRIMARY KEY (person_id, phone_id),
	constraint fk_person_phone_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	constraint fk_person_phone_phone_id FOREIGN KEY (phone_id) REFERENCES phone(phone_id) 
);

-- Laura 1, Rachelle 2, John 3
INSERT INTO person (first_name, last_name) VALUES 
	('Laura', 'Martinez'),
	('Rachelle', 'Rauh'),
	('John', 'Fulton');
	
-- first phone will always 1
-- Laura's Phone
INSERT INTO phone (phone_number, phone_type) VALUES ('555-555-5555', 'WORK');
INSERT INTO person_phone VALUES (1, 1);

-- Rachelle's Phone
INSERT INTO phone (phone_number, phone_type) VALUES ('777-777-7777', 'HOME');
INSERT INTO person_phone VALUES (2, 2);

-- John's Phones
INSERT INTO phone (phone_number, phone_type) VALUES ('888-888-8888', 'HOME');
INSERT INTO person_phone VALUES (3, 3);
INSERT INTO phone (phone_number, phone_type) VALUES ('999-999-9999', 'MOBILE');
INSERT INTO person_phone VALUES (3, 4);

-- Laura's Address
INSERT INTO address (line_one, line_two, city, district, postal_code, address_type)
VALUES ('123 Twilight Ave',null, 'Witchville', 'OH', '55555', 'HOME');
INSERT INTO person_address (person_id, address_id) VALUES (1, 1);

-- Rachelle's Address
INSERT INTO address (line_one, line_two, city, district, postal_code, address_type)
VALUES ('3 Somestreet',null, 'Acity', 'OH', '77777', 'HOME');
INSERT INTO person_address (person_id, address_id) VALUES (2, 2);

-- John's Address
INSERT INTO address (line_one, line_two, city, district, postal_code, address_type)
VALUES ('456 Other Steet','Door 2', 'Bexley', 'OH', '88888', 'HOME');
INSERT INTO person_address (person_id, address_id) VALUES (3, 3);
INSERT INTO address (line_one, line_two, city, district, postal_code, address_type, other_type_description)
VALUES ('1 Redacted',null, 'Redacted', 'OH', '99999', 'OTHER', 'Summer lab');
INSERT INTO person_address (person_id, address_id) VALUES (3, 4);
-- 