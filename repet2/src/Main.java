import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        for (int i=0; i< 100000; i++){
            numbers.add(i%5);
        }
        System.out.println(numbers.size());
//       long start = System.currentTimeMillis();
//
//        for (Integer number : numbers) {
//            number = number +1;
//        }
//        long finish = System.currentTimeMillis();
//        System.out.println(finish-start);
    }
}