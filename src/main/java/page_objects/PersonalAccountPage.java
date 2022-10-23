package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage extends BaseObjectPage{

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }
    public static String PERSONAL_ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";


    @Override
    public PersonalAccountPage open(){
        driver.get(PERSONAL_ACCOUNT_PAGE);
        return this;
    }
    @Override
    public PersonalAccountPage open(String url){
        driver.get(url);
        return this;
    }

    private final By constructorButton = By.xpath("//p[contain(@class, 'AppHeader_header__linkText__3q_va ml-2') and text()='Конструктор']");

    public PersonalAccountPage pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public PersonalAccountPage setCookieInLocalStorage(String value){
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        local.setItem("accessToken", value);
        driver.navigate().to("https://stellarburgers.nomoreparties.site/account/profile");
        return this;
    }
    public PersonalAccountPage clickConstructorButton(){
        pause(6);
        WebElement element = driver.findElement(constructorButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }
//    public boolean isConstructorOpened(){
//        WebElement element driver.findElement();
//        new WebDriverWait(driver, 3)
//                .until(ExpectedConditions.elementToBeClickable(element));
//    }
}
