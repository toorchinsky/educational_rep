import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayBlock {
    private WebDriver driver;
    private WebDriverWait wait;

    private By closeCookieButton = By.xpath("//div[@class = 'cookie__buttons']//button[@class = 'btn btn_gray cookie__cancel']");
    private By headerText = By.xpath("//div[@class = 'pay__wrapper']//h2");
    private By visaLogo = By.xpath("//div[@class = 'pay__partners']//img[@alt = 'Visa']");
    private By verifiedVisaLogo = By.xpath("//div[@class = 'pay__partners']//img[@alt = 'Verified By Visa']");
    private By masterCardLogo = By.xpath("//div[@class = 'pay__partners']//img[@alt = 'MasterCard']");
    private By masterCardSecureLogo = By.xpath("//div[@class = 'pay__partners']//img[@alt = 'MasterCard Secure Code']");
    private By belacardLogo = By.xpath("//div[@class = 'pay__partners']//img[@alt = 'Белкарт']");
    private By infoLink = By.xpath("//div[@class = 'pay__wrapper']//a");
    private By phoneInput = By.xpath("//input[@placeholder = 'Номер телефона']");
    private By subPhoneInput = By.xpath("//input[@placeholder = 'Номер абонента']");
    private By sumInput = By.xpath("//form[@class = 'pay-form opened']//input[@class = 'total_rub']");
    private By emailInput = By.xpath("//form[@class = 'pay-form opened']//input[@placeholder = 'E-mail для отправки чека']");
    private By continueButton = By.xpath("//form[@class = 'pay-form opened']//button");
    private By payPopup = By.xpath("//iframe[@class = 'bepaid-iframe']");
    private By servicesChoice = By.xpath("//button[@class = 'select__header']");
    private By servicesHomeInternet = By.xpath("//p[text()='Домашний интернет']");
    private By servicesInstallment = By.xpath("//p[text()='Рассрочка']");
    private By scoreIput = By.xpath("//input[@id = 'score-instalment']");
    private By arrearsInput = By.xpath("//input[@placeholder = 'Номер счета на 2073']");
    private By servicesArrears = By.xpath("//p[text()='Задолженность']");

    public PayBlock(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void closeCookieBanner() {
        wait.until(ExpectedConditions.elementToBeClickable(closeCookieButton)).click();
    }

    @Step("Получение текста из заголовка блока")
    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }

    @Step("Проверка отображения логотипа Visa")
    public boolean isVisaLogoDisplayed() {
        return driver.findElement(visaLogo).isDisplayed();
    }

    @Step("Проверка отображения логотипа Verified Visa")
    public boolean isVerifiedVisaLogoDisplayed() {
        return driver.findElement(verifiedVisaLogo).isDisplayed();
    }

    @Step("Проверка отображения логотипа MasterCard")
    public boolean isMasterCardLogoDisplayed() {
        return driver.findElement(masterCardLogo).isDisplayed();
    }

    @Step("Проверка отображения логотипа MasterCard Secure")
    public boolean isMasterCardSecureLogoDisplayed() {
        return driver.findElement(masterCardSecureLogo).isDisplayed();
    }

    @Step("Проверка отображения логотипа Belacard")
    public boolean isBelacardLogoDisplayed() {
        return driver.findElement(belacardLogo).isDisplayed();
    }

    @Step("Нажатие на ссылку «Подробнее о сервисе»")
    public void clickInfoLink() {
        driver.findElement(infoLink).click();
    }

    @Step("Получение текущего URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Заполнение поля «Номер телефона» и «Сумма»")
    public void fillPaymentForm(String phone, String sum) {
        driver.findElement(phoneInput).click();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(sumInput).click();
        driver.findElement(sumInput).sendKeys(sum);
    }

    @Step("Нажатие на кнопку «Продолжить»")
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    @Step("Проверка отображения попап")
    public boolean isPayPopupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup)).isDisplayed();
    }

    @Step("Получение текста из плэйсхолдера поля «»")
    public String emailPlaceholder() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }

    @Step("Получение текста из плэйсхолдера поля «Номер телефона»")
    public String phonePlaceholder() {
        return driver.findElement(phoneInput).getAttribute("placeholder");
    }

    @Step("Получение текста из плэйсхолдера поля «Сумма»")
    public String sumPlaceholder() {
        return driver.findElement(sumInput).getAttribute("placeholder");
    }

    @Step("Нажатие на кнопку выпадающего списка")
    public void clickServicesButton() {
        driver.findElement(servicesChoice).click();
    }

    @Step("Нажатие на пункт списа «Домашний интернет»")
    public void clickHomeInternet() {
        driver.findElement(servicesHomeInternet).click();
    }

    @Step("Получение текста из плэйсхолдера поля «Номер абонента»")
    public String subPhonePlaceholder() {
        return driver.findElement(subPhoneInput).getAttribute("placeholder");
    }

    @Step("Нажатие на пункт списа «Рассрочка»")
    public void clickInstallment() {
        driver.findElement(servicesInstallment).click();
    }

    @Step("Получение текста из плэйсхолдера поля «Номер счета на 44»")
    public String scorePlaceholder() {
        return driver.findElement(scoreIput).getAttribute("placeholder");
    }

    @Step("Нажатие на пункт списа «Задолженность»")
    public void clickArrears() {
        driver.findElement(servicesArrears).click();
    }

    @Step("Получение текста из плэйсхолдера поля «Номер счета на 2073»")
    public String arrearsPlaceholder() {
        return driver.findElement(arrearsInput).getAttribute("placeholder");
    }

    @Step("Получение отображаемой суммы для пополнения в открывшемся окне оплаты")
    public String getPopupSum() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            WebElement popupSum = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class = 'pay-description__cost ng-star-inserted']//span")));
            return popupSum.getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение отображаемой суммы в кнопке Оплатить в открывшемся окне оплаты")
    public String getPopupSumButton() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            WebElement popupSumbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class = 'card-page__card']//button")));
            return popupSumbutton.getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение отображаемого номера телефона в открывшемся окне оплаты")
    public String getPopupNumber() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            WebElement popupNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class = 'pay-description__text']//span")));
            return popupNumber.getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение текста плэйсхолдера из поля «Номер карты» в открывшемся окне оплаты")
    public String getPopupCardPlaceholder() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            WebElement cardLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@formcontrolname = 'creditCard']/following-sibling::label")));
            return cardLabel.getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение текста плэйсхолдера из поля «Срок действия» в открывшемся окне оплаты")
    public String getPopupCardTerm() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            WebElement cardTerm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@formcontrolname = 'expirationDate']/following-sibling::label")));
            return cardTerm.getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение текста плэйсхолдера из поля «CVC» в открывшемся окне оплаты")
    public String getPopupCardCvc() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            WebElement cardCvc = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@formcontrolname = 'cvc']/following-sibling::label")));
            return cardCvc.getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение текста плэйсхолдера из поля «Имя и фамилия на карте» в открывшемся окне оплаты")
    public String getPopupCardName() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            WebElement cardName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@formcontrolname = 'holder']/following-sibling::label")));
            return cardName.getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Проверка отображения логотипа Visa в открывшемся окне оплаты")
    public boolean isVisaLogoInPopup() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            return driver.findElement(By.xpath("//img[contains(@src, 'visa-system.svg')]")).isDisplayed();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Проверка отображения логотипа MasterCard в открывшемся окне оплаты")
    public boolean isMasterCardLogoInPopup() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            return driver.findElement(By.xpath("//img[contains(@src, 'mastercard-system.svg')]")).isDisplayed();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Проверка отображения логотипа Belkart в открывшемся окне оплаты")
    public boolean isBelkartLogoInPopup() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            return driver.findElement(By.xpath("//img[contains(@src, 'belkart-system.svg')]")).isDisplayed();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Проверка отображения одного из логотипов (Maestro или Mir) в открывшемся окне оплаты")
    public boolean isMaestroOrMirLogoInPopup() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            WebElement randomLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'cards-brands_random')]//img")));
            return randomLogo.isDisplayed();
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}