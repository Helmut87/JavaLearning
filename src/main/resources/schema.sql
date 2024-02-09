-- Создание таблицы "Товар"
CREATE TABLE
    IF NOT EXISTS Product
(
    id          SERIAL PRIMARY KEY,
    description TEXT           NOT NULL,
    price       NUMERIC(10, 2) NOT NULL,
    quantity    INTEGER        NOT NULL
);
COMMENT ON TABLE Product IS 'Table for storing information about products.';

COMMENT ON COLUMN Product.id IS 'Unique identifier for the product.';
COMMENT ON COLUMN Product.description IS 'Description of the product.';
COMMENT ON COLUMN Product.price IS 'Price of the product.';
COMMENT ON COLUMN Product.quantity IS 'Quantity of the product in stock.';

-- Добавление записей в таблицу  "Товар"
INSERT INTO Product (description, price, quantity)
VALUES ('Product 1', 10.00, 100),
       ('Product 2', 15.50, 200),
       ('Product 3', 7.25, 150),
       ('Product 4', 12.75, 100),
       ('Product 5', 5.00, 300),
       ('Product 6', 22.50, 200),
       ('Product 7', 17.00, 250),
       ('Product 8', 3.99, 500),
       ('Product 9', 29.99, 100),
       ('Product 10', 19.99, 150);

-- Создание таблицы "Покупатель"
CREATE TABLE IF NOT EXISTS Customer
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
COMMENT ON TABLE Customer IS 'Table for storing customer information.';

COMMENT ON COLUMN Customer.id IS 'Unique identifier for the customer.';
COMMENT ON COLUMN Customer.name IS 'Name of the customer.';

-- Добавление записей в таблицу "Покупатель"
INSERT INTO Customer (name)
VALUES ('John Doe'),
       ('Jane Doe'),
       ('Michael Smith'),
       ('Emily Jones'),
       ('William Johnson'),
       ('Olivia Brown'),
       ('Noah Davis'),
       ('Isabella Wilson'),
       ('James Taylor'),
       ('Sophia Anderson');

-- Создание таблицы "Заказ"
CREATE TABLE
    IF NOT EXISTS "Order"
(
    id          SERIAL PRIMARY KEY,
    product_id  INTEGER NOT NULL,
    customer_id INTEGER NOT NULL,
    order_date  DATE    NOT NULL,
    quantity    INTEGER NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Product (id),
    FOREIGN KEY (customer_id) REFERENCES Customer (id)
);
COMMENT ON TABLE "Order" IS 'Table for storing order information.';

COMMENT ON COLUMN "Order".id IS 'Unique identifier for the order.';
COMMENT ON COLUMN "Order".product_id IS 'Identifier of the product that is ordered.';
COMMENT ON COLUMN "Order".customer_id IS 'Identifier of the customer who placed the order.';
COMMENT ON COLUMN "Order".order_date IS 'Date the order was placed.';
COMMENT ON COLUMN "Order".quantity IS 'Quantity of the products in the order.';

-- Добавление записей в таблицу "Заказ"
INSERT INTO "Order" (product_id, customer_id, order_date, quantity)
VALUES (1, 1, '2024-01-01', 2),
       (2, 2, '2024-01-02', 1),
       (3, 3, '2024-01-03', 3),
       (4, 4, '2024-01-04', 1),
       (5, 5, '2024-01-05', 5),
       (6, 1, '2024-01-06', 2),
       (7, 2, '2024-01-07', 3),
       (8, 3, '2024-01-08', 4),
       (9, 4, '2024-01-09', 1),
       (10, 5, '2024-01-10', 2);
