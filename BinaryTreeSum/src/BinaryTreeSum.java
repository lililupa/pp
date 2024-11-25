import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BinaryTreeSum {
    public static void main(String[] args) {
        // Инициализируем множество для хранения уникальных ключей
        Set<Long> uniqueKeys = new HashSet<>();
        long sum = 0;

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            // Считываем ключи из файла и добавляем в множество для автоматического удаления дубликатов
            while (scanner.hasNextLong()) {
                long key = scanner.nextLong();
                uniqueKeys.add(key);
            }

            // Суммируем уникальные ключи
            for (long key : uniqueKeys) {
                sum += key;
            }

            // Записываем результат в файл output.txt
            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(Long.toString(sum));
            }

            System.out.println("Сумма уникальных ключей успешно записана в output.txt");

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}