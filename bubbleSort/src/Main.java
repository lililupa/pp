//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 30, 5, 23, 7};
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = flag;
                }
            }
            System.out.println(arr[i]);
        }
    }
}