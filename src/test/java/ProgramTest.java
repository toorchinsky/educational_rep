import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {

    @Test
    @DisplayName("Тест вычисления факториала")
    void factorialPositive(){
        long actual = Calculations.factorial(10);
        assertEquals(3628800, actual);
    }

    @Test
    @DisplayName("Тест 0 факториала")
    void factorialZero(){
        long actual = Calculations.factorial(0);
        assertEquals(1, actual);
    }

    @Test
    @DisplayName("Тест отрицательного вычисления факториала")
    void factorialNegative(){
        assertThrows(IllegalArgumentException.class, () -> Calculations.factorial(-10));
    }

    @Test
    @DisplayName("Тест вычисления площади треугольника")
    void triangleAreaPositive(){
        int actual = Calculations.triangleArea(14, 14);
        assertEquals(98, actual);
    }

    @Test
    @DisplayName("Тест на 0 значения при вычислении площади треугольника")
    void triangleAreaZero(){
        assertThrows(IllegalArgumentException.class, () -> Calculations.triangleArea(0, 0));
    }

    @Test
    @DisplayName("Тест на частино 0 значения при вычислении площади треугольника")
    void triangleAreaHalfZero(){
        assertThrows(IllegalArgumentException.class, () -> Calculations.triangleArea(5, 0));
    }

    @Test
    @DisplayName("Тест на отрицательные значения при вычислении площади треугольника")
    void triangleAreaNegative(){
        assertThrows(IllegalArgumentException.class, () -> Calculations.triangleArea(-15, -15));
    }

    @Test
    @DisplayName("Тест сложения положительных чисел")
    void testAdditionPositive() {
        assertEquals(8, Calculations.addition(5, 3));
    }

    @Test
    @DisplayName("Тест сложения отрицательных чисел")
    void testAdditionNegative() {
        assertEquals(-8, Calculations.addition(-5, -3));
    }

    @Test
    @DisplayName("Тест вычитания")
    void testSubtractionPositive() {
        assertEquals(2, Calculations.subtraction(5, 3));
    }

    @Test
    @DisplayName("Тест вычитания отрицательных чисел")
    void testSubtractionNegative() {
        assertEquals(-8, Calculations.subtraction(-5, 3));
    }

    @Test
    @DisplayName("Тест умножения на ноль")
    void testMultiplicationWithZero() {
        assertEquals(0, Calculations.multiplication(5, 0));
        assertEquals(0, Calculations.multiplication(0, 5));
        assertEquals(0, Calculations.multiplication(0, 0));
    }

    @Test
    @DisplayName("Тест умножения положительных чисел")
    void testMultiplicationPositive() {
        assertEquals(100, Calculations.multiplication(10, 10));
    }

    @Test
    @DisplayName("Тест умножения отрицательных чисел")
    void testMultiplicationNegative() {
        assertEquals(100, Calculations.multiplication(-10, -10));
    }

    @Test
    @DisplayName("Тест деления положительных чисел")
    void testDivisionPositive() {
        assertEquals(2.0, Calculations.division(10, 5));
    }

    @Test
    @DisplayName("Тест деления отрицательных чисел")
    void testDivisionNegative() {
        assertEquals(2.0, Calculations.division(-10, -5));
    }

    @Test
    @DisplayName("Тест деления на ноль")
    void testDivisionWithZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> Calculations.division(5, 0));
        assertEquals("Деление на 0 невозможно", exception.getMessage());
    }

    @Test
    @DisplayName("Положительное сравнение чисел")
    void comparisonTrue(){
        assertTrue(Calculations.comparison(100, 100));
    }

    @Test
    @DisplayName("Отрицательное сравнение чисел")
    void comparisonFalse(){
        assertFalse(Calculations.comparison(-100, 100));
    }
}
