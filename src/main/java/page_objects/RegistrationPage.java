package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class RegistrationPage extends BaseObjectPage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    protected static String URL = "https://stellarburgers.nomoreparties.site/register";
    private final By nameField = By.xpath("//label[contains(@class, 'input__placeholder text noselect text_type_main-default') and contains(text(),'Имя')]/parent::div/input");
    private final By emailField = By.xpath("//label[contains(@class, 'input__placeholder text noselect text_type_main-default') and contains(text(),'Email')]/parent::div/input");
    private final By passwordField = By.xpath("//input[contains(@class, 'text input__textfield text_type_main-default') and contains(@type, 'password')]");
    private final By confirmRegistrationButton = By.xpath(".//button[contains(@class, 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa') and contains(text(), 'Зарегистрироваться')]");
    private final By badPassword = By.xpath("//p[contains(@class, 'input__error text_type_main-default')]");

    private final By signInPage = By.xpath("//button[contains(@class, 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa')]");

    @Override
    public RegistrationPage open() {
        driver.get(URL);
        return this;
    }

    @Override
    public RegistrationPage open(String url) {
        driver.get(URL);
        return this;
    }
    public RegistrationPage pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public void waitElementToBeClickable(WebElement element) {
        WebDriverWait pause = new WebDriverWait(driver, 100);
        pause.until(ExpectedConditions.elementToBeClickable(element));
    }

    public RegistrationPage setName(String name) {
        WebElement element = driver.findElement(nameField);
        waitElementToBeClickable(element);
        element.sendKeys(name);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        WebElement element = driver.findElement(emailField);
        waitElementToBeClickable(element);
        element.sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(password);
        return this;
    }

    public String getShortPasswordError() {
        WebElement element = driver.findElement(badPassword);
        new WebDriverWait(driver, 6)
                .until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public RegistrationPage clickConfirmRegistrationButton() {
        WebElement element = driver.findElement(confirmRegistrationButton);
        element.click();
        return this;
    }

    public RegistrationPage registration(String name,String email, String password) {
        setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickConfirmRegistrationButton();
        return this;
    }

    public boolean isSignInPageOpened() {
        pause(6000);
        WebElement element = driver.findElement(signInPage);
        waitElementToBeClickable(element);
        return element.isDisplayed();
    }
}



