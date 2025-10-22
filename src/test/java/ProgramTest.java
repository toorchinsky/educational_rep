import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {
    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void Start() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement closeCookie = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class = 'cookie__buttons']//button[@class = 'btn btn_gray cookie__cancel']")
        ));
        closeCookie.click();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void blockNameTest() {
        WebElement headText = driver.findElement(By.xpath("//div[@class = 'pay__wrapper']//h2"));
        String actual = headText.getText();
        assertEquals("Онлайн пополнение\n" +
                "без комиссии", actual);
    }

    @Test
    void payLogoTest(){
        WebElement visaLogo = driver.findElement(By.xpath("//div[@class = 'pay__partners']//img[@alt = 'Visa']"));
        assertTrue(visaLogo.isDisplayed());

        WebElement verifiedVisaLogo = driver.findElement(By.xpath("//div[@class = 'pay__partners']//img[@alt = 'Verified By Visa']"));
        assertTrue(verifiedVisaLogo.isDisplayed());

        WebElement masterCardLogo = driver.findElement(By.xpath("//div[@class = 'pay__partners']//img[@alt = 'MasterCard']"));
        assertTrue(masterCardLogo.isDisplayed());

        WebElement masterCardSecureLogo = driver.findElement(By.xpath("//div[@class = 'pay__partners']//img[@alt = 'MasterCard Secure Code']"));
        assertTrue(masterCardSecureLogo.isDisplayed());

        WebElement belacardLogo = driver.findElement(By.xpath("//div[@class = 'pay__partners']//img[@alt = 'Белкарт']"));
        assertTrue(belacardLogo.isDisplayed());
    }

    @Test
    void infoLinkTest(){
        WebElement infoLink = driver.findElement(By.xpath("//div[@class = 'pay__wrapper']//a"));
        infoLink.click();
        String actualLink = driver.getCurrentUrl();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", actualLink);
    }

    @Test
    void payButtonTest() {
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder = 'Номер телефона']"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.xpath("//form[@class = 'pay-form opened']//input[@class = 'total_rub']"));
        sumInput.click();
        sumInput.sendKeys("100");

        WebElement сontinueButton = driver.findElement(By.xpath("//form[@class = 'pay-form opened']//button"));
        сontinueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement payPopup = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                        ("//iframe[@class = 'bepaid-iframe']")));
        assertTrue(payPopup.isDisplayed());
    }

}


