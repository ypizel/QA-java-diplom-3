import io.qameta.allure.junit4.DisplayName;
import page_objects.HomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;
import static page_objects.HomePage.*;

@RunWith(Parameterized.class)
public class LoginTest extends BaseChromeUITest{

    private final String url;
    private final By locatorButton;
    private final String email = "web@yandex.ru";
    private final String password = "qwerty12";

    public LoginTest(String url, By locatorButton) {
        this.url = url;
        this.locatorButton = locatorButton;
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][]{
                {HOME_PAGE, MAIN_PAGE_SIGN_IN_BUTTON},
                {HOME_PAGE, PERSONAL_ACCOUNT_BUTTON},
                {HOME_PAGE + "register", REGISTRATION_PAGE_SIGH_IN_BUTTON},
                {HOME_PAGE+ "forgot-password", FORGOT_PASSWORD_SIGN_IN_BUTTON}

        };
    }
    @Test
    @DisplayName("Авторизация с разными входными данными")
    public void loginTest(){
        createUser(user);
        boolean isSignedIn = new HomePage(driver)
                .open(url)
                .clickButtonThatLeadsToLoginPage(locatorButton)
                .signIn(user.getEmail(), user.getPassword())
                .clickPersonalAccountButton()
                .isPersonalAccountPageOpened();
        assertTrue(isSignedIn);
        deleteUser(user);
    }
}
