import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.Random;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1 ");
        Task_1();
        System.out.println("Task 2 ");
        Task_2();
        System.out.println("Task 3 ");
        Task_3();
        System.out.println("Task 4 ");
        Task_4();

    }
    static void Task_1(){
        Map<Integer, ArrayList<String>> phoneBook = new HashMap<Integer, ArrayList<String>>();
        Map<Integer, String> nameBook = new HashMap<Integer, String>();
        nameBook.put(0, "Иванов А.А.");
        nameBook.put(1, "Петров С.А.");
        nameBook.put(2, "Иванов А.Ю.");
        nameBook.put(3, "Сидоров А.К.");
        for (int i=0;i< nameBook.size();i++){
            if (phoneBook.get(i)==null){
                phoneBook.put(i, new ArrayList<String>());
                phoneBook.get(i).add("8-926-000-00-"+i+i+";"+"8-926-111-11-"+i+i);
            }
            System.out.println("Телефонные номера абонента"+" "+nameBook.get(i)+" :"+phoneBook.get(i));
        }
    }

    static void Task_2() {

        List<String> people = new ArrayList<>();
        people.add("Иван Иванов");
        people.add("Светлана Петрова");
        people.add("Кристина Белова");
        people.add("Анна Мусина");
        people.add("Анна Крутова");
        people.add("Иван Юрин");
        people.add("Петр Лыков");
        people.add("Павел Чернов");
        people.add("Петр Чернышов");
        people.add("Мария Федорова");
        people.add("Марина Светлова");
        people.add("Мария Савин");
        people.add("Мария Рыкова");
        people.add("Марина Лугова");
        people.add("Анна Владимирова");
        people.add("Иван Мечников");
        people.add("Петр Петин");
        people.add("Иван Ежов");

        Map<String, Integer> nameList = new HashMap<>();

        for (int i = 0; i < people.size(); i++) {
            String temp = people.get(i).replace(" ", "_");
            String[] arr = temp.split("_");
            if (nameList.containsKey(arr[0])) {
                nameList.put(arr[0], nameList.get(arr[0]) + 1);
            } else {
                nameList.put(arr[0], 1);
            }
        }
        System.out.print("Список поворяющихся имен: \n");
        nameList.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    static void Task_3()
    {
        int[] numbers = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            numbers[i] = rand.nextInt(10);
        }
        System.out.println(Arrays.toString(numbers));
        heapSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
        System.out.println(checkArray(numbers));
    }

    public static boolean checkArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) return false;
        }
        if (numbers[numbers.length - 2] > numbers[numbers.length - 1]) return false;
        return true;
    }

    public static void heapSort(int[] numbers, int minNumberIndex, int maxNumberIndex) {
        if (minNumberIndex >= maxNumberIndex) return;
        int pivotIndex = getPivotIndex(numbers, minNumberIndex, maxNumberIndex);
        heapSort(numbers, minNumberIndex, pivotIndex - 1);
        heapSort(numbers, pivotIndex + 1, maxNumberIndex);
    }

    public static int getPivotIndex(int[] numbers, int minNumberIndex, int maxNumberIndex) {
        int pivotIndex = minNumberIndex - 1;
        for (int i = minNumberIndex; i < maxNumberIndex; i++) {
            if (numbers[i] < numbers[maxNumberIndex]) {
                pivotIndex++;
                swap(numbers, i, pivotIndex);
            }
        }
        pivotIndex++;
        swap(numbers, pivotIndex, maxNumberIndex);
        return pivotIndex;
    }

    public static void swap(int[] numbers, int minNumberIndex, int maxNumberIndex) {
        int buffer = numbers[minNumberIndex];
        numbers[minNumberIndex] = numbers[maxNumberIndex];
        numbers[maxNumberIndex] = buffer;
    }


    static void Task_4() {

         int size = 8;
         int[][] array = new int[size][size];

        if (!putTheQueen(array, 0)){
            System.out.println("Решений нет!");
            return;
        }
        print(array);
        }
        public static void print(int[][] array){
            int arrayLength = array.length;
            for (int i = 0; i < arrayLength + 1; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

            for (int i = 0; i < arrayLength; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < arrayLength; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        public static boolean putTheQueen(int[][] array, int col) {
            if (col >= array.length){
                return true;
            }

            for (int i = 0; i < array.length; i++) {
                if (checkPosition(array, i, col)){
                    array[i][col] = 1;
                    if (putTheQueen(array, col+1)){
                        return true;
                    }
                    array[i][col] = 0;
                }
            }

            return false;
        }

        public static boolean checkPosition(int[][] array, int row, int col){
            for (int i = 0; i < col; i++) {
                if (array[row][i] > 0){
                    return false;
                }
            }

            for (int i = row - 1, j = col - 1; i>= 0 && j >= 0; i--, j--) {
                if (array[i][j] > 0){
                    return false;
                }
            }

            for (int i = row + 1, j = col - 1; i < array.length && j >= 0; i++, j--) {
                if (array[i][j] > 0){
                    return false;
                }
            }

            return true;
        }

}
