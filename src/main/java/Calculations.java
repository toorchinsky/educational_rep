public class Calculations {

    public static long factorial(int o){
        if (o < 0){
            throw new IllegalArgumentException("Факториал определяется только для неотрицательных целых чисел");
        }
        long result = 1;
        for(int i = 1; i <= o; i++){
            result = result * i;
        }
        return result;
    }

    public static int triangleArea(int a, int h){
        if (a <= 0 || h <= 0){
            throw new IllegalArgumentException("Сторона не может быть равна 0");
        }
        return (a * h) / 2;
    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на 0 невозможно");
        }
        return (double) a / b;
    }

    public static boolean comparison(int a, int b){
        return a == b;
    }
}