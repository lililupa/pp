import models.Category;
import services.CategoryService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public void startMenu() {
        Scanner sc = new Scanner(System.in);
        int menu = -1;
        new MenuProgram().list();
        do {
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println(" Cоздание категории товара ");
                    System.out.println(" Введите категорию товара ");
                    String name = sc.next();
                    CategoryService service = new CategoryService();
                    List<Category> categories = service.addCategory(name);
                    for (Category category : categories) {
                        System.out.println(category);

                    }

                    break;
                case 2:
                    System.out.println(" Вы ввели 2 ");
                    break;
                case 3:
                    System.out.println(" Вы ввели 3 ");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + menu);
            }
            new MenuProgram().list();
        }

        while (menu != 0);

    }
}
