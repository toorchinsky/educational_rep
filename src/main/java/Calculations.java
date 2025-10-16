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

    public static int[] arithmeticOperations(int a, int b){
        if (a == 0 || b == 0){
            throw new IllegalArgumentException("Делеие и умножение на 0 невозможно");
        }
        int addition = a + b;
        int subtraction = a - b;
        int multiplication = a * b;
        int division = a / b;
        return new int[]{addition, subtraction, division, multiplication};
    }

    public static boolean comparison(int a, int b){
        return a == b;
    }
}
