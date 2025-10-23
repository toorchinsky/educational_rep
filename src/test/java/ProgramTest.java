import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {
    WebDriver driver;
    PayBlock payBlock;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void Start() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        payBlock = new PayBlock(driver);
        payBlock.closeCookieBanner();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void blockNameTest() {
        String actual = payBlock.getHeaderText();
        assertEquals("Онлайн пополнение\nбез комиссии", actual);
    }

    @Test
    void payLogoTest() {
        assertTrue(payBlock.isVisaLogoDisplayed());
        assertTrue(payBlock.isVerifiedVisaLogoDisplayed());
        assertTrue(payBlock.isMasterCardLogoDisplayed());
        assertTrue(payBlock.isMasterCardSecureLogoDisplayed());
        assertTrue(payBlock.isBelacardLogoDisplayed());
    }

    @Test
    void infoLinkTest() {
        payBlock.clickInfoLink();
        String actualLink = payBlock.getCurrentUrl();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", actualLink);
    }

    @Test
    void payButtonTest() {
        payBlock.fillPaymentForm("297777777", "100");
        payBlock.clickContinueButton();
        assertTrue(payBlock.isPayPopupDisplayed());
    }

    @Test
    void placeholderConnectionTest() {
        assertEquals("Номер телефона", payBlock.phonePlaceholder());
        assertEquals("Сумма", payBlock.sumPlaceholder());
        assertEquals("E-mail для отправки чека", payBlock.emailPlaceholder());
    }

    @Test
    void placeholderInternetTest() {
        payBlock.clickServicesButton();
        payBlock.clickHomeInternet();
        assertEquals("Номер абонента", payBlock.subPhonePlaceholder());
        assertEquals("Сумма", payBlock.sumPlaceholder());
        assertEquals("E-mail для отправки чека", payBlock.emailPlaceholder());
    }

    @Test
    void placeholderInstallmentTest() {
        payBlock.clickServicesButton();
        payBlock.clickInstallment();
        assertEquals("Номер счета на 44", payBlock.scorePlaceholder());
        assertEquals("Сумма", payBlock.sumPlaceholder());
        assertEquals("E-mail для отправки чека", payBlock.emailPlaceholder());
    }

    @Test
    void placeholderArrearsTest() {
        payBlock.clickServicesButton();
        payBlock.clickArrears();
        assertEquals("Номер счета на 2073", payBlock.arrearsPlaceholder());
        assertEquals("Сумма", payBlock.sumPlaceholder());
        assertEquals("E-mail для отправки чека", payBlock.emailPlaceholder());
    }

    @Test
    void popupTest(){
        payBlock.fillPaymentForm("297777777", "50");
        payBlock.clickContinueButton();
        assertEquals("50.00 BYN", payBlock.getPopupSum());
        assertEquals("Оплатить 50.00 BYN", payBlock.getPopupSumButton());
        assertEquals("Оплата: Услуги связи Номер:375297777777", payBlock.getPopupNumber());
        assertEquals("Номер карты", payBlock.getPopupCardPlaceholder());
        assertEquals("Срок действия", payBlock.getPopupCardTerm());
        assertEquals("CVC", payBlock.getPopupCardCvc());
        assertEquals("Имя и фамилия на карте", payBlock.getPopupCardName());
        assertTrue(payBlock.isVisaLogoInPopup());
        assertTrue(payBlock.isMasterCardLogoInPopup());
        assertTrue(payBlock.isBelkartLogoInPopup());
        assertTrue(payBlock.isMaestroOrMirLogoInPopup());
    }
}