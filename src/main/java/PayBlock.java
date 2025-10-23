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

    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }

    public boolean isVisaLogoDisplayed() {
        return driver.findElement(visaLogo).isDisplayed();
    }

    public boolean isVerifiedVisaLogoDisplayed() {
        return driver.findElement(verifiedVisaLogo).isDisplayed();
    }

    public boolean isMasterCardLogoDisplayed() {
        return driver.findElement(masterCardLogo).isDisplayed();
    }

    public boolean isMasterCardSecureLogoDisplayed() {
        return driver.findElement(masterCardSecureLogo).isDisplayed();
    }

    public boolean isBelacardLogoDisplayed() {
        return driver.findElement(belacardLogo).isDisplayed();
    }

    public void clickInfoLink() {
        driver.findElement(infoLink).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void fillPaymentForm(String phone, String sum) {
        driver.findElement(phoneInput).click();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(sumInput).click();
        driver.findElement(sumInput).sendKeys(sum);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public boolean isPayPopupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup)).isDisplayed();
    }

    public String emailPlaceholder() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }

    public String phonePlaceholder() {
        return driver.findElement(phoneInput).getAttribute("placeholder");
    }

    public String sumPlaceholder() {
        return driver.findElement(sumInput).getAttribute("placeholder");
    }

    public void clickServicesButton() {
        driver.findElement(servicesChoice).click();
    }

    public void clickHomeInternet() {
        driver.findElement(servicesHomeInternet).click();
    }

    public String subPhonePlaceholder() {
        return driver.findElement(subPhoneInput).getAttribute("placeholder");
    }

    public void clickInstallment() {
        driver.findElement(servicesInstallment).click();
    }

    public String scorePlaceholder() {
        return driver.findElement(scoreIput).getAttribute("placeholder");
    }

    public void clickArrears() {
        driver.findElement(servicesArrears).click();
    }

    public String arrearsPlaceholder() {
        return driver.findElement(arrearsInput).getAttribute("placeholder");
    }

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

    public boolean isVisaLogoInPopup() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            return driver.findElement(By.xpath("//img[contains(@src, 'visa-system.svg')]")).isDisplayed();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public boolean isMasterCardLogoInPopup() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            return driver.findElement(By.xpath("//img[contains(@src, 'mastercard-system.svg')]")).isDisplayed();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public boolean isBelkartLogoInPopup() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(payPopup));
        driver.switchTo().frame(iframe);
        try {
            return driver.findElement(By.xpath("//img[contains(@src, 'belkart-system.svg')]")).isDisplayed();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

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