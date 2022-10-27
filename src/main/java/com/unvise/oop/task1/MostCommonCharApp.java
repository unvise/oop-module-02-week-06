package com.unvise.oop.task1;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostCommonCharApp {
    public static void main(String[] args) {
        try (Scanner stringScanner = new Scanner(System.in)) {
            String inputString = stringScanner.nextLine().replaceAll("'", "").trim();
            var commonCharEntry = mostCommonCharEntry(inputString);
            System.out.printf("['%s', %d]", commonCharEntry.getKey(), commonCharEntry.getValue());
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректные данные");
        }
    }

    public static Map.Entry<Character, Long> mostCommonCharEntry(String s) {
        var commonChar = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow(IllegalArgumentException::new);
        return new AbstractMap.SimpleEntry<>(commonChar.getKey(), commonChar.getValue());
    }
}
