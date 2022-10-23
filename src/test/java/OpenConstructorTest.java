import org.junit.Test;
import page_objects.HomePage;
import static org.junit.Assert.assertTrue;

public class OpenConstructorTest extends BaseChromeUITest{
    @Test
    public void openConstructorTest(){
        createUser(user);
        String accessToken = getAccessToken(user);
        boolean isConstructorTitleDisplayed = new HomePage(driver)
                .open()
                .setCookieInLocalStorage(accessToken)
                .clickPersonalAccountButton()
                .clickConstructorButton()
                .isConstructorOpened();
        assertTrue(isConstructorTitleDisplayed);

    }
}
