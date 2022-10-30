package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseObjectPage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public static String HOME_PAGE = "https://stellarburgers.nomoreparties.site/";
    private final By emailField = By.xpath("//label[contains(@class, 'input__placeholder text noselect text_type_main-default') and contains(text(),'Email')]/parent::div/input");
    private final By passwordField = By.xpath("//input[contains(@class, 'text input__textfield text_type_main-default') and contains(@type, 'password')]");
    private final By sighInButton = By.xpath("//button[contains(@class, 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa')]");
    public static final By MAIN_PAGE_SIGN_IN_BUTTON = By.xpath("//button[contains(@class, 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg') and contains(text(), 'Войти в аккаунт')]");
    public static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//p[contains(@class, 'AppHeader_header__linkText__3q_va ml-2') and text()='Личный Кабинет']");
    public static final By REGISTRATION_PAGE_SIGH_IN_BUTTON = By.xpath("//p[contains(@class, 'undefined text text_type_main-default text_color_inactive mb-4') and text()='Уже зарегистрированы?']/a");
    public static final By FORGOT_PASSWORD_SIGN_IN_BUTTON = By.xpath("//p[contains(@class, 'undefined text text_type_main-default text_color_inactive mb-4') and text()='Вспомнили пароль?']/a");
    private final By personalAccountButton = By.xpath("//p[contains(@class, 'AppHeader_header__linkText__3q_va ml-2') and text()='Личный Кабинет']");
    private final By profileButton = By.xpath("//a[contains(@class, 'Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9') and text()='Профиль']");
    private final By constructorButton = By.xpath("//p[contains(@class,'AppHeader_header__linkText__3q_va ml-2')and text()='Конструктор']/parent::a");
    private final By constructorPageTitle = By.xpath("//h1[contains(@class, 'text text_type_main-large mb-5 mt-10') and text()='Соберите бургер']");
    @Override
    public HomePage open(){
        driver.get(HOME_PAGE);
        return this;
    }

    @Override
    public HomePage open(String url){
        driver.get(url);
        return this;
    }

    public void waitElementToBeClickable(WebElement element){
        WebDriverWait pause = new WebDriverWait(driver, 6);
        pause.until(ExpectedConditions.elementToBeClickable(element));
    }

    public HomePage pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomePage setEmail(String email){
        WebElement element = driver.findElement(emailField);
        waitElementToBeClickable(element);
        element.sendKeys(email);
        return this;
    }

    public HomePage setPassword(String password){
        WebElement element = driver.findElement(passwordField);
        waitElementToBeClickable(element);
        element.sendKeys(password);
        return this;
    }

    public HomePage clickButtonThatLeadsToLoginPage(By buttonLocator){
        WebElement element = driver.findElement(buttonLocator);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public HomePage clickMainPageSignInButton(){
        WebElement element = driver.findElement(MAIN_PAGE_SIGN_IN_BUTTON);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public HomePage clickSignInButton(){
        WebElement element = driver.findElement(sighInButton);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public HomePage signIn(String email, String password){
        setEmail(email)
                .setPassword(password)
                .clickSignInButton()
                .pause();
        return this;
    }

    public HomePage clickPersonalAccountButton(){
        WebElement element = driver.findElement(personalAccountButton);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public boolean isPersonalAccountPageOpened(){
        pause();
        WebElement element = driver.findElement(profileButton);
        waitElementToBeClickable(element);
        return element.isDisplayed();
    }

    public HomePage setCookieInLocalStorage(String value){
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        local.setItem("accessToken", value);
        return this;
    }

    public HomePage clickConstructorButton(){
        WebElement element = driver.findElement(constructorButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

        public boolean isConstructorOpened(){
        WebElement element = driver.findElement(constructorPageTitle);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
}
