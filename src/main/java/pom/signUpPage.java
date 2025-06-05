package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signUpPage {
	private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(linkText = "Sign Up") private WebElement signUpLink;
    @FindBy(xpath = "//input[@placeholder='First name']") private WebElement firstNameField;
    
    @FindBy(xpath = "//input[@placeholder='Last name']") private WebElement lastNameField;
    
    @FindBy(xpath = "//input[@placeholder='Enter your email address']") private WebElement emailAddressField;
    
    @FindBy(xpath = "//span[text()='+91']") private WebElement countryCodeField;
    
    @FindBy(xpath = "//input[@placeholder='Enter your phone number']") private WebElement phoneNumberField;
    
    @FindBy(xpath = "//input[@placeholder='Enter your password']") private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']") private WebElement continueButtonField;
    
    public signUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void fillSignUpForm(String firstName, String lastName, String email, String phoneNumber, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailAddress(email);
        selectCountryCode();
        enterPhoneNumber(phoneNumber);
        enterPassword(password);
    }
    
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    
    public void enterEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailAddressField));
        emailAddressField.clear();
        emailAddressField.sendKeys(email);
    }
    
    public void selectCountryCode() {
        wait.until(ExpectedConditions.elementToBeClickable(countryCodeField));
        countryCodeField.click();
    }
    
    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
    }
    
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButtonField));
        continueButtonField.click();
    }
}
