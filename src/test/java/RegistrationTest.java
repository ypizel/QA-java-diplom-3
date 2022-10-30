import io.qameta.allure.junit4.DisplayName;
import page_objects.RegistrationPage;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationTest extends BaseChromeUITest {
    @Test
    @DisplayName("Регистрация с валидными данными")
    public void registrationWithValidData(){
       boolean isSignInPageOpened = new RegistrationPage(driver)
                .open()
                .registration(user.getName(), user.getEmail(), user.getPassword())
                        .isSignInPageOpened();
       assertTrue(isSignInPageOpened);
       deleteUser(user);

    }
    @Test
    @DisplayName("Регистрация с неверным паролем")
    public void registerWithWrongPassword(){
        String actualResult = new RegistrationPage(driver)
                .open()
                .registration(user.getName(), user.getEmail(), "qwert")
                .getShortPasswordError();
        assertEquals("Некорректный пароль", actualResult);
    }
}
