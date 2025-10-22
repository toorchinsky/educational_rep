import org.testng.annotations.Test;
import org.testng.Assert;

public class ProgramTest {

    @Test
    public void factorialPositive(){
        long actual = Calculations.factorial(10);
        Assert.assertEquals(actual, 3628800);
    }

    @Test
    public void factorialZero(){
        long actual = Calculations.factorial(0);
        Assert.assertEquals(actual, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void factorialNegative(){
        Calculations.factorial(-10);
    }

    @Test
    public void triangleAreaPositive(){
        int actual = Calculations.triangleArea(14, 14);
        Assert.assertEquals(actual, 98);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleAreaZero(){
        Calculations.triangleArea(0, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleAreaHalfZero(){
        Calculations.triangleArea(5, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleAreaNegative(){
        Calculations.triangleArea(-15, -15);
    }

    @Test
    public void testAdditionPositive() {
        Assert.assertEquals(Calculations.addition(5, 3), 8);
    }

    @Test
    public void testAdditionNegative() {
        Assert.assertEquals(Calculations.addition(-5, -3), -8);
    }

    @Test
    public void testSubtractionPositive() {
        Assert.assertEquals(Calculations.subtraction(5, 3), 2);
    }

    @Test
    public void testSubtractionNegative() {
        Assert.assertEquals(Calculations.subtraction(-5, 3), -8);
    }

    @Test
    public void testMultiplicationWithZero() {
        Assert.assertEquals(Calculations.multiplication(5, 0), 0);
        Assert.assertEquals(Calculations.multiplication(0, 5), 0);
        Assert.assertEquals(Calculations.multiplication(0, 0), 0);
    }

    @Test
    public void testMultiplicationPositive() {
        Assert.assertEquals(Calculations.multiplication(10, 10), 100);
    }

    @Test
    public void testMultiplicationNegative() {
        Assert.assertEquals(Calculations.multiplication(-10, -10), 100);
    }

    @Test
    public void testDivisionPositive() {
        Assert.assertEquals(Calculations.division(10, 5), 2.0);
    }

    @Test
    public void testDivisionNegative() {
        Assert.assertEquals(Calculations.division(-10, -5), 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionWithZero() {
        Calculations.division(5, 0);
    }

    @Test
    public void comparisonTrue(){
        Assert.assertTrue(Calculations.comparison(100, 100));
    }

    @Test
    public void comparisonFalse(){
        Assert.assertFalse(Calculations.comparison(-100, 100));
    }
}