-- 1. Чтение данных: Получить список всех продуктов с их ценами и количеством на складе
SELECT description, price, quantity
FROM Product;

-- 2. Чтение данных: Получить информацию о заказах для покупателя с id 1 (включая описание товара, количество и дату заказа)
SELECT o.order_date, p.description, o.quantity
FROM "Order" o
         JOIN Product p ON o.product_id = p.id
WHERE o.customer_id = 1;

-- 3. Изменение данных: Обновить цену продукта с id 5 на 5.99
UPDATE Product
SET price = 5.99
WHERE id = 5;

-- 4. Изменение данных: Увеличить количество всех товаров на складе на 10 единиц
UPDATE Product
SET quantity = quantity + 10;

-- 5. Удаление данных: Удалить заказ с id 10
DELETE FROM "Order"
       WHERE id = 10;

-- 6. Чтение данных: Получить список покупателей и количество сделанных ими заказов
SELECT c.name, COUNT(o.id) AS orders_count
FROM Customer c
         LEFT JOIN "Order" o ON c.id = o.customer_id
GROUP BY c.id;

-- 7. Изменение данных: Изменить имя покупателя с id 3 на "Michael Johnson"
UPDATE Customer SET name = 'Michael Johnson' WHERE id = 3;

-- 8. Чтение данных: Получить список товаров, которые были заказаны более чем одним покупателем
SELECT p.description
FROM Product p
         JOIN "Order" o ON p.id = o.product_id
GROUP BY p.id
HAVING COUNT(DISTINCT o.customer_id) > 1;

-- 9. Удаление данных: Удалить всех покупателей, которые не сделали ни одного заказа
DELETE FROM Customer
WHERE id NOT IN (SELECT DISTINCT customer_id FROM "Order");

-- 10. Изменение данных: Добавить к описанию каждого товара фразу " - Excellent Choice!"
UPDATE Product SET description = description || ' - Excellent Choice!';