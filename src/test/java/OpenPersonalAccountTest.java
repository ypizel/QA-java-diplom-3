import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import page_objects.HomePage;

public class OpenPersonalAccountTest extends BaseChromeUITest {
    @Test
    @DisplayName("Переход на страницу личного кабинета ")
    public void openPersonalAccountTest() {
        createUser(user);
        String accessToken = getAccessToken(user);
        new HomePage(driver)
                .open()
                .setCookieInLocalStorage(accessToken)
                .clickPersonalAccountButton()
                .isPersonalAccountPageOpened();
        deleteUser(user);
    }
}
