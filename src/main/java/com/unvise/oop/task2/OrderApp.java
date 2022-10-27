package com.unvise.oop.task2;

import com.unvise.oop.task2.generator.OrderGenerator;
import com.unvise.oop.task2.model.Product;

import java.time.Month;

public class OrderApp {
    public static void main(String[] args) {
        double ordersSumInFebruary = OrderGenerator.generateOrders(10)
                .stream()
                .filter(order -> order.getOrderDate().getMonth().equals(Month.FEBRUARY))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println(ordersSumInFebruary);
    }
}
