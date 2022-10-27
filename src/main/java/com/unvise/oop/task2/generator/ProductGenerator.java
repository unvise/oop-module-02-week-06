package com.unvise.oop.task2.generator;

import com.unvise.oop.task2.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

public class ProductGenerator {
    private static final Map<String, String> PRODUCTS = Map.of(
            "Стол кухонный овальный Delinia Тулуза 75х120", "Кухонная утварь",
            "Кружка Arabia Finland", "Кухонная утварь",
            "Мы | Замятин Евгений Иванович", "Книги",
            "Микки-7 | Эдвард Эштон", "Книги",
            "Ультрабук HUAWEI MateBook D 15 BoM-WFQ9 серебристый", "Ноутбуки",
            "Ноутбук Lenovo ThinkPad E14 черный", "Ноутбуки"
    );

    private static final Map<String, Double> PRODUCT_PRICES = Map.of(
            "Стол кухонный овальный Delinia Тулуза 75х120", 19_968d,
            "Кружка Arabia Finland", 1_990d,
            "Мы | Замятин Евгений Иванович", 560d,
            "Микки-7 | Эдвард Эштон", 1_080d,
            "Ультрабук HUAWEI MateBook D 15 BoM-WFQ9 серебристый", 63_990d,
            "Ноутбук Lenovo ThinkPad E14 черный", 149_990d
    );

    public static List<Product> generateProducts() {
        return LongStream.range(1, PRODUCTS.size() + 1)
                .mapToObj(ProductGenerator::createProduct)
                .toList();
    }

    public static Product createProduct(Long id) {
        Product product = new Product();
        product.setId(id);
        var productName = new ArrayList<>(PRODUCTS.keySet()).get(Math.toIntExact(id) - 1);
        var productCategory = PRODUCTS.get(productName);
        product.setName(productName);
        product.setCategory(productCategory);
        product.setPrice(PRODUCT_PRICES.get(productName));
        return product;
    }
}
