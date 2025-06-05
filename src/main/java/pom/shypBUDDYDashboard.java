package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shypBUDDYDashboard {
	private WebDriver driver;

    // Logo and Header Elements
    @FindBy(xpath = "//img[contains(@alt, 'ShypBUDDY Logo')]")
    private WebElement shypBuddyLogo;

    @FindBy(xpath = "//h2[contains(text(), 'Welcome')]/span[contains(text(), 'shital Jadhav')]")
    private WebElement welcomeMessage;

    // Navigation Elements
    @FindBy(xpath = "//button[contains(text(), 'Create Order')]")
    private WebElement createOrderButton;

    @FindBy(xpath = "//button[contains(text(), 'Create Bulk Orders')]")
    private WebElement createBulkOrdersButton;

    @FindBy(xpath = "//button[contains(text(), 'Rate Calculator')]")
    private WebElement rateCalculatorButton;

    @FindBy(xpath = "//button[contains(text(), 'Recharge')]")
    private WebElement rechargeButton;

    // Dashboard Statistics
    @FindBy(xpath = "//div[contains(text(), 'Total Shipments')]/following-sibling::div")
    private WebElement totalShipments;

    @FindBy(xpath = "//div[contains(text(), 'Pickup Pending')]/following-sibling::div")
    private WebElement pickupPending;

    @FindBy(xpath = "//div[contains(text(), 'In-Transit')]/following-sibling::div")
    private WebElement inTransit;

    @FindBy(xpath = "//div[contains(text(), 'Out For Delivery')]/following-sibling::div")
    private WebElement outForDelivery;

    @FindBy(xpath = "//div[contains(text(), 'Delivered')]/following-sibling::div")
    private WebElement delivered;

    @FindBy(xpath = "//div[contains(text(), 'NDR')]/following-sibling::div")
    private WebElement ndr;

    // Zone Distribution
    @FindBy(xpath = "//div[text()='WithinCity']/following-sibling::div")
    private WebElement withinCityCount;

    @FindBy(xpath = "//div[text()='WithinZone']/following-sibling::div")
    private WebElement withinZoneCount;

    @FindBy(xpath = "//div[text()='MetrotoMetro']/following-sibling::div")
    private WebElement metroToMetroCount;

    @FindBy(xpath = "//div[text()='RestofIndia']/following-sibling::div")
    private WebElement restOfIndiaCount;

    // NSAT Elements
    @FindBy(xpath = "//div[contains(text(), 'Average Rating')]")
    private WebElement averageRating;

    public shypBUDDYDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with dashboard elements
    public boolean isLogoDisplayed() {
        return shypBuddyLogo.isDisplayed();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public void clickCreateOrder() {
        createOrderButton.click();
    }

    public void clickCreateBulkOrders() {
        createBulkOrdersButton.click();
    }

    public String getTotalShipments() {
        return totalShipments.getText();
    }

    public String getDeliveredCount() {
        return delivered.getText();
    }

    public String getZoneDistributionCount(String zone) {
        switch (zone) {
            case "WithinCity":
                return withinCityCount.getText();
            case "WithinZone":
                return withinZoneCount.getText();
            case "MetrotoMetro":
                return metroToMetroCount.getText();
            case "RestofIndia":
                return restOfIndiaCount.getText();
            default:
                return "Zone not found";
        }
    }

    public String getAverageRating() {
        return averageRating.getText();
    }
}



