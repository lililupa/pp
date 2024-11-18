import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Bobik", 5);
        bobik.setAge(10);
        Dog sharik = new Dog();
        sharik.setAge(6);
        sharik.setName("Sharik");
//        System.out.println(bobik.toString());
//        System.out.println(sharik.toString());
//        System.out.println(bobik.say());
//        System.out.println(new Cat().say());
        Dog[] dogs = new Dog[5];
        dogs[0] = bobik;
        dogs[1] = sharik;
        dogs[2] = new Dog("Muhtar", 7);
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i]);
        }
        List<Dog> dogList = new ArrayList<>();
        dogList.add(bobik);
        dogList.add(sharik);
        dogList.add(new Dog("Muha", 3));
        for (Dog dog : dogList) {
            System.out.println(dog);
        }
        dogList.remove(sharik);
        for (Dog dog : dogList) {
            System.out.println(dog);
        }
    }
}