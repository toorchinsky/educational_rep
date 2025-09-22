import java.util.Arrays;

public class Program{
    public static void main(String[] args){
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(numberRange(4, 2));
        сheckingTheNumber(-51);
        System.out.println(сheckingTheNumberBoolean(0));
        printingLines("Привет!", 4);
        System.out.println(determiningYear(16));
        binaryChanger();
        fillingArray();
        arrayMultiplication();
        diagonalFilling();
        returnArray(12, 5);
    }

    //Задача 1
    public static void printThreeWords(){
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }
    
    //Задача 2
    public static void checkSumSign(){
        int a = 10;
        int b = 15;
        int c = a + b;
        if (c > 0) {
            System.out.println("Сумма положительна");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //Задача 3
    public static void printColor(){
        int value = 0;
        if (value <= 0) {
           System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    //Задача 4
    public static void compareNumbers(){
        int a = 2, b = 5;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //Задача 5
    public static boolean numberRange(int a, int b){
        int c = a + b;
        return c >= 10 && c <= 20;
    }


    //Задача 6
    public static void сheckingTheNumber(int a){
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //Задача 7
    public static boolean сheckingTheNumberBoolean(int a){
        return a < 0;
    }


    //Задача 8
    public static void printingLines(String a, int b){
        for (int i = b; i >= 1; i--) {
            System.out.println(a);
        }
    }
    
    //Задача 9
    public static boolean determiningYear(int y){
    if (y % 400 == 0) {
        return true;
    } else if (y % 100 == 0) {
        return false;
    } else if (y % 4 == 0) {
        return true;
    } else {
        return false;
    }
    }   
    
    //Задача 10
    public static void binaryChanger(){
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int element = 0;
        for (int a : arr) {
            if (a == 1) {
                arr[element] = 0;
            } else {
                arr[element] = 1;
            }
            element++;
        }
        System.out.println(Arrays.toString(arr));
    }
    
    //Задача 11
    public static void fillingArray(){
        int[] arr = new int [100];
        int element = 0;
        int b = 1;
        for (int a : arr) {
            arr[element] = b;
            element++;
            b++;
        }
        System.out.println(Arrays.toString(arr));
    }
    
    //Задача 12
    public static void arrayMultiplication(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int element = 0;
        for (int a : arr) {
            if (a < 6) {
                arr[element] = arr[element] * 2;
            }
            element++;
        }
        System.out.println(Arrays.toString(arr));
    }
    
    //Задача 13
    public static void diagonalFilling(){
        int[][] table = new int [5][5];
        for (int a = 0; a < 5; a++) {
            table[a][a] = 1;
        }
        System.out.println(Arrays.deepToString(table));
    }
    
    //Задача 14
    public static void returnArray(int len, int initialValue){
        int[] arr = new int[len];
        int element = 0;
        for (int a : arr){
            arr[element] = initialValue;
            element++;
        }
        System.out.println(Arrays.toString(arr));
    }
}   