DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (
    id INTEGER,
    title VARCHAR(255),
    DOUBLE price,
    PRIMARY KEY (id)
    );
INSERT INTO products (title,price) VALUES
('Lager',10.2),('Dark Lager',12.3),('Whisky',50.22);

DROP TABLE customer IF EXISTS;
CREATE TABLE IF NOT EXISTS customer(
    id INTEGER,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    product_id INTEGER,
    PRIMARY KEY (id)
);

INSERT INTO customer (firstname,lastname) VALUES
('John Lennon',2),('Angus Yang',1)