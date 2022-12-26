import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page_objects.HomePage;
import static org.junit.Assert.assertTrue;

public class OpenConstructorTest extends BaseChromeUITest{
    @Test
    @DisplayName("Переход на страницу конструктора со станицы пользователя")
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
