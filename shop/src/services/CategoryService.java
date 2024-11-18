package services;

import models.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryService {
    File file = new File("resources/categories.txt");

    public List<Category> addCategory(String name) {
        List<Category> categories = new ArrayList<>();
        //TODO реализовать логику добавлеия категорий и хранения их в файле
        // прочитать как информация хранится в текстовых файлах и записывается
        //алгоритмы линейного поиска и сортировки пузырьком
        // теория отношений (SQL)


        try {
            List<Category> categories1 = getCategories();
            int maxID = 0;
            for (int i = 0; i < categories1.size(); i++) {

                if (maxID < categories1.get(i).getId()) {
                    maxID = categories1.get(i).getId();
                }
            }
            FileWriter writer = new FileWriter(file, true);
            writer.write(maxID + 1 + ":" + name);
            writer.write("\n");
            writer.flush();

        } catch (IOException e) {
            System.out.println("File not found");
        }
        return categories;

    }

    public List<Category> getCategories() {
        List<Category> result = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String read = sc.nextLine();
                String[] split = read.split(":");
//                System.out.println(split[0]);
//                System.out.println(split[1]);
                Category category = new Category(Integer.parseInt(split[0]), split[1]);
                result.add(category);


            }
        } catch (FileNotFoundException e) {
            System.out.println("File not read");
        }

        return result;
    }
}
