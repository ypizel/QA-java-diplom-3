import org.junit.Test;
import page_objects.IngredientTabs;
import static org.junit.Assert.assertTrue;

public class IngredientTabsWorkTest extends BaseChromeUITest{

    @Test
    public void clickSousesTabLeadsToSouses(){
        boolean isSousesTabSelected = new IngredientTabs(driver)
                .open()
                .clickSousesTabButton()
                .isSouseTabSelected();  
        assertTrue(isSousesTabSelected);
    }
    @Test
    public void clickFillingTabLeadsToFillings(){
        boolean isFillingTabSelected = new IngredientTabs(driver)
                .open()
                .clickFillingTabButton()
                .isFillingTabSelected();
        assertTrue(isFillingTabSelected);
    }
    @Test
    public void clickBunTabLeadsToBun(){
        boolean isBunTabSelected = new IngredientTabs(driver)
                .open()
                .clickFillingTabButton()
                .clickBunTabLocator()
                .isBunTabSelected();
        assertTrue(isBunTabSelected);
    }
}