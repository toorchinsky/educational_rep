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
    @DisplayName("Тест на положительные значения массива")
    void arrayPositive(){
        int[] actual = Calculations.arithmeticOperations(50, 50);
        assertArrayEquals(new int[]{100, 0, 1, 2500}, actual);
    }

    @Test
    @DisplayName("Тест на операции с 0")
    void arrayZero(){
        assertThrows(IllegalArgumentException.class, () -> Calculations.arithmeticOperations(0, 1));
    }

    @Test
    @DisplayName("Тест на отрицательные значения массива")
    void arrayNegative(){
        int[] actual = Calculations.arithmeticOperations(-50, -50);
        assertArrayEquals(new int[]{-100, 0, 1, 2500}, actual);
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
