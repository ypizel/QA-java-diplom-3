import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page_objects.IngredientTabs;
import static org.junit.Assert.assertTrue;

public class IngredientTabsWorkTest extends BaseChromeUITest{
    @Test
    @DisplayName("Переход на таб с соусами")
    public void clickSousesTabLeadsToSouses(){
        boolean isSousesTabSelected = new IngredientTabs(driver)
                .open()
                .clickSousesTabButton()
                .isSouseTabSelected();  
        assertTrue(isSousesTabSelected);
    }
    @Test
    @DisplayName("Переход на таб с начинкой")
    public void clickFillingTabLeadsToFillings(){
        boolean isFillingTabSelected = new IngredientTabs(driver)
                .open()
                .clickFillingTabButton()
                .isFillingTabSelected();
        assertTrue(isFillingTabSelected);
    }
    @Test
    @DisplayName("Переход на таб с булочками")
    public void clickBunTabLeadsToBun(){
        boolean isBunTabSelected = new IngredientTabs(driver)
                .open()
                .clickFillingTabButton()
                .clickBunTabLocator()
                .isBunTabSelected();
        assertTrue(isBunTabSelected);
    }
}