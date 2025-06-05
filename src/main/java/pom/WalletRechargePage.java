package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WalletRechargePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Recharge')]")
    private WebElement rechargeButton;

    @FindBy(xpath = "//div[contains(text(), 'Current Wallet Amount')]/following-sibling::div")
    private WebElement currentWalletAmount;

    @FindBy(xpath = "//button[contains(text(), '₹20')]")
    private WebElement amount20Button;

    @FindBy(xpath = "//button[contains(text(), '₹500')]")
    private WebElement amount500Button;

    @FindBy(xpath = "//button[contains(text(), '₹2000')]")
    private WebElement amount2000Button;

    @FindBy(xpath = "//button[contains(text(), '₹2500')]")
    private WebElement amount2500Button;

    @FindBy(xpath = "//button[contains(text(), '₹5000')]")
    private WebElement amount5000Button;

    @FindBy(xpath = "//button[contains(text(), '₹10000')]")
    private WebElement amount10000Button;

    @FindBy(xpath = "//input[@placeholder='Enter Amount You Want To Recharge']")
    private WebElement customAmountField;

    @FindBy(xpath = "//input[@placeholder='Enter Coupon Code']")
    private WebElement couponCodeField;

    @FindBy(xpath = "//button[contains(text(), 'Continue to Payment')]")
    private WebElement continueToPaymentButton;

    public WalletRechargePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public String getCurrentWalletAmount() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(currentWalletAmount));
        return element.getText();
    }

    public void selectPredefinedAmount(int amount) {
        WebElement buttonToClick;
        switch (amount) {
            case 20:
                buttonToClick = amount20Button;
                break;
            case 500:
                buttonToClick = amount500Button;
                break;
            case 2000:
                buttonToClick = amount2000Button;
                break;
            case 2500:
                buttonToClick = amount2500Button;
                break;
            case 5000:
                buttonToClick = amount5000Button;
                break;
            case 10000:
                buttonToClick = amount10000Button;
                break;
            default:
                throw new IllegalArgumentException("Unsupported predefined amount: " + amount);
        }
        wait.until(ExpectedConditions.elementToBeClickable(buttonToClick)).click();
        // Wait for any page updates after clicking
        wait.until(ExpectedConditions.visibilityOf(continueToPaymentButton));
    }

    public void enterCustomAmount(String amount) {
        WebElement field = wait.until(ExpectedConditions.visibilityOf(customAmountField));
        field.clear();
        field.sendKeys(amount);
        try {
            wait.until(ExpectedConditions.attributeToBe(field, "value", amount));
        } catch (Exception e) {
            System.out.println("sendKeys failed, using JavaScript: " + e.getMessage());
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", field, amount);
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('input'));", field);
        }
    }

    public void enterCouponCode(String couponCode) {
        WebElement field = wait.until(ExpectedConditions.visibilityOf(couponCodeField));
        field.clear();
        field.sendKeys(couponCode);
        try {
            wait.until(ExpectedConditions.attributeToBe(field, "value", couponCode));
        } catch (Exception e) {
            System.out.println("sendKeys failed for coupon, using JavaScript: " + e.getMessage());
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", field, couponCode);
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('input'));", field);
        }
    }

    public void clickContinueToPayment() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueToPaymentButton));
        if (!button.isEnabled()) {
            System.out.println("Continue to Payment button is disabled!");
        }
        button.click();
    }

    // Full recharge flow
    public void performRecharge(String amount, String couponCode) {
        System.out.println("Selecting custom amount: " + amount);
        enterCustomAmount(amount);
        if (couponCode != null && !couponCode.isEmpty()) {
            System.out.println("Applying coupon code: " + couponCode);
            enterCouponCode(couponCode);
        }
        System.out.println("Clicking Continue to Payment...");
        clickContinueToPayment();
    }
}