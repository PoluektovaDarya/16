import java.util.Scanner;
interface Condition {
    boolean check(int x, int y);
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Condition less = (x, y) -> x < y;
    static Condition grow = (x, y) -> x > y;
    public static void get_change(int[] arr) {
        System.out.println("Укажите порядок сортировки");
        System.out.println("1 по возрастанию\n2 по убыванию");
        int change = scanner.nextInt();
        if (change == 1) {
            combSort(arr, grow);
        } else if (change == 2) {
            combSort(arr, less);
        } else {
            get_change(arr);
        }
    }
    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.print("Введите элементы массива: \n");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        get_change(arr);
        System.out.print("Отсортированный массив: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void combSort(int[] arr, Condition condition) {
        int n = arr.length;
        int step = n;
        double factor = 1.247;
        boolean sorted = false;

        while (!sorted) {
            step = (int) Math.floor(step / factor);
            if (step <= 1) {
                step = 1;
                sorted = true;
            }
            int i = 0;
            while (i + step < n) {
                if (condition.check(arr[i], arr[i + step])) {
                    int temp = arr[i];
                    arr[i] = arr[i + step];
                    arr[i + step] = temp;
                    sorted = false;
                }
                i++;
            }
        }
    }
}
