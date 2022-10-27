package com.unvise.oop.task2.generator;

import com.unvise.oop.task2.model.Customer;
import com.unvise.oop.task2.model.Order;
import com.unvise.oop.task2.model.Product;
import com.unvise.oop.task2.util.RandomUtil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class OrderGenerator {
    private static final List<Customer> CUSTOMERS = CustomerGenerator.generateCustomers();
    private static final List<Product> PRODUCTS = ProductGenerator.generateProducts();
    private static final List<String> STATUSES = List.of(
            "В пути",
            "Прибыл в пукт получения",
            "Доставлен"
    );

    public static List<Order> generateOrders(Integer count) {
        return LongStream.range(1, count + 1)
                .mapToObj(OrderGenerator::createOrder)
                .toList();
    }

    public static Order createOrder(Long id) {
        Order order = new Order();
        order.setId(id);
        order.setCustomer(CUSTOMERS.get(RandomUtil.getRandomInt(0, CUSTOMERS.size() - 1)));
        order.setProducts(new HashSet<>());
        IntStream.range(0, RandomUtil.getRandomInt(1, PRODUCTS.size()))
                .forEach(productIndex -> order.getProducts().add(PRODUCTS.get(productIndex)));
        long minDay = LocalDate.of(2020, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2020, 6, 30).toEpochDay();
        LocalDate orderDate = RandomUtil.getRandomLocalDate(minDay, maxDay);
        order.setOrderDate(orderDate);
        LocalDate deliveryDate = RandomUtil.getRandomLocalDate(orderDate.toEpochDay(), maxDay);
        order.setDeliveryDate(deliveryDate);
        order.setStatus(STATUSES.get(RandomUtil.getRandomInt(0, STATUSES.size() - 1)));
        return order;
    }
}
