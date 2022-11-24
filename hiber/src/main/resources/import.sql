DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id INTEGER, title VARCHAR(255),DOUBLE price, PRIMARY KEY (id));
INSERT INTO products (title,price) VALUES ('Lager',10.2),('Dark Lager',12.3),('Whisky',50.22);