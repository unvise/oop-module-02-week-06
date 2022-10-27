package com.unvise.oop.task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FileFinderApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Поиск по названию файла 1) по содержимому файла 2): ");
            Integer option = Integer.parseInt(scanner.nextLine());
            if (option != 1 && option != 2) {
                System.out.println("Некорректный выбор");
                return;
            }
            System.out.print("Введите абсолютный путь до директории: ");
            String directoryStringPath = scanner.nextLine().trim();
            Path directoryPath = Path.of(directoryStringPath);
            if (option.equals(1)) {
                byNameOption(directoryPath, scanner);
                return;
            }
            byContentOption(directoryPath, scanner);
        } catch (NumberFormatException e) {
            System.out.println("Введите число");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами");
        }
    }

    private static void byNameOption(Path directoryPath, Scanner scanner) throws IOException {
        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine().trim();
        Optional<File> file = TxtFileFinder.byName(directoryPath, fileName);
        if (file.isEmpty()) {
            System.out.println("Файл не найден");
            return;
        }
        System.out.println(file.get());
    }

    private static void byContentOption(Path directoryPath, Scanner scanner) throws IOException {
        System.out.print("Введите содержимое файла: ");
        String content = scanner.nextLine().trim();
        List<File> files = TxtFileFinder.byContent(directoryPath, content);
        files.forEach(System.out::println);
    }
}
