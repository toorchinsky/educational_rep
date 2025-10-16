import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgramTest {

    @Test
    public void factorialPositive() {
        long actual = Calculations.factorial(10);
        Assert.assertEquals(actual, 3628800);
    }

    @Test
    public void factorialZero() {
        long actual = Calculations.factorial(0);
        Assert.assertEquals(actual, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void factorialNegative() {
        Calculations.factorial(-10);
    }

    @Test
    public void triangleAreaPositive() {
        int actual = Calculations.triangleArea(14, 14);
        Assert.assertEquals(actual, 98);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleAreaZero() {
        Calculations.triangleArea(0, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleAreaHalfZero() {
        Calculations.triangleArea(5, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void triangleAreaNegative() {
        Calculations.triangleArea(-15, -15);
    }

    @Test
    public void arrayPositive() {
        int[] actual = Calculations.arithmeticOperations(50, 50);
        Assert.assertEquals(actual, new int[]{100, 0, 1, 2500});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void arrayZero() {
        Calculations.arithmeticOperations(0, 1);
    }

    @Test
    public void arrayNegative() {
        int[] actual = Calculations.arithmeticOperations(-50, -50);
        Assert.assertEquals(actual, new int[]{-100, 0, 1, 2500});
    }

    @Test
    public void comparisonTrue() {
        Assert.assertTrue(Calculations.comparison(100, 100));
    }

    @Test
    public void comparisonFalse() {
        Assert.assertFalse(Calculations.comparison(-100, 100));
    }
}