BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_categories;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE product_categories (
	id serial NOT NULL PRIMARY KEY,
	category VARCHAR(32) NOT NULL UNIQUE
);

CREATE TABLE products (
   	id            serial  NOT NULL PRIMARY KEY,
  	category      int NOT NULL,
  	name          VARCHAR(64) NOT NULL,
  	image_name    VARCHAR(255) NOT NULL,
  	rating        INTEGER DEFAULT 0,
  	is_top_seller BOOLEAN DEFAULT false,
  	quantity      INTEGER  DEFAULT 0,
  	price         NUMERIC(10,2) NOT NULL,
	
	CONSTRAINT fk_product_category FOREIGN KEY (category) REFERENCES product_categories(id)
);

COMMIT TRANSACTION;
