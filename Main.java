import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для записи в файл -> ");
        String str1 = scanner.nextLine();

        System.out.println(str1);

        try {
            FileWriter writer = new FileWriter("file.txt");
            writer.write(str1);
            writer.close();
            System.out.println("Информация записана успешно!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
