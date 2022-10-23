package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IngredientTabs extends BaseObjectPage {
    public IngredientTabs(WebDriver driver) {
        super(driver);
    }
    protected static String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    private final By bunTabButton = By.xpath("//span[contains(@class, 'text text_type_main-default') and text()='Булки']");
    private final By sousesTabButton = By.xpath("//span[contains(@class, 'text text_type_main-default') and text()='Соусы']");
    private final By fillingsTabButton = By.xpath("//span[contains(@class, 'text text_type_main-default') and text()='Начинки']");
    private final By selectedSousesTab = By.xpath("//span[contains(@class, 'text text_type_main-default') and text()='Соусы']/parent::div[contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By selectedFillingTab = By.xpath("//span[contains(@class, 'text text_type_main-default') and text()='Начинки']/parent::div[contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By selectedBunTab = By.xpath("//span[contains(@class, 'text text_type_main-default') and text()='Булки']/parent::div[contains(@class, 'tab_tab_type_current__2BEPc')]");
    @Override
    public IngredientTabs open() {
        driver.get(MAIN_PAGE);
        return this;
    }

    @Override
    public IngredientTabs open(String url) {
        driver.get(url);
        return this;
    }

    public void waitElementToBeClickable(WebElement element) {
        WebDriverWait pause = new WebDriverWait(driver, 6);
        pause.until(ExpectedConditions.elementToBeClickable(element));
    }

    public IngredientTabs clickSousesTabButton() {
        WebElement element = driver.findElement(sousesTabButton);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }
    public IngredientTabs clickFillingTabButton(){
        WebElement element = driver.findElement(fillingsTabButton);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }
    public IngredientTabs clickBunTabLocator(){
        WebElement element = driver.findElement(bunTabButton);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }
    public boolean isSouseTabSelected(){
        WebElement element = driver.findElement(selectedSousesTab);
        return element.isEnabled();
    }
    public boolean isFillingTabSelected(){
        WebElement element = driver.findElement(selectedFillingTab);
        return element.isEnabled();
    }
    public boolean isBunTabSelected(){
        WebElement element = driver.findElement(selectedBunTab);
        return element.isEnabled();
    }
}
