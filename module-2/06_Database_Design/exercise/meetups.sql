DROP TABLE IF EXISTS person_address;
        DROP TABLE IF EXISTS member_phone;
        DROP TABLE IF EXISTS member_list;
        DROP TABLE IF EXISTS email_address;
        DROP TABLE IF EXISTS phone;

        CREATE TABLE member_list (
                member_id serial primary key,
                first_name varchar(50),
                last_name varchar (50) not null,
                date_modified timestamp DEFAULT current_timestamp
);

        CREATE TABLE email_address (
                email_address_id serial primary key,
                email_contact varchar(255) not null,
                street_two varchar(255),
);

        CREATE TABLE member_email_address (
                member_id bigint,
                email_address_id bigint,
        );

        CREATE TABLE phone (
                phone_id serial PRIMARY KEY,
                phone_number varchar (32),
);

        CREATE TABLE member_phone (
                person_id bigint,
                phone_id bigint,
);



