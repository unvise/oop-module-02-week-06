package com.unvise.oop.task2.generator;

import com.unvise.oop.task2.model.Customer;
import com.unvise.oop.task2.util.RandomUtil;

import java.util.List;
import java.util.stream.LongStream;

public class CustomerGenerator {
    private static final List<String> CUSTOMER_NAMES = List.of(
            "Соколова Дарья Данииловна",
            "Соловьева Вероника Семёновна",
            "Кузнецов Дмитрий Евгеньевич",
            "Александрова Елена Ярославовна",
            "Овчинникова Амина Павловна",
            "Журавлев Тимофей Кириллович",
            "Романов Ярослав Матвеевич",
            "Игнатова Ангелина Ильинична",
            "Бондарев Роман Максимович",
            "Парамонова Анна Максимовна"
    );

    public static List<Customer> generateCustomers() {
        return LongStream.range(1, CUSTOMER_NAMES.size() + 1)
                .mapToObj(CustomerGenerator::createCustomer)
                .toList();
    }

    public static Customer createCustomer(Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(CUSTOMER_NAMES.get(Math.toIntExact(id) - 1));
        customer.setTier(RandomUtil.getRandomInt(1, 4));
        return customer;
    }
}
