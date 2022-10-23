import page_objects.RegistrationPage;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseChromeUITest {

    @Test
    public void registrationWithValidData(){
       boolean isSignInPageOpened = new RegistrationPage(driver)
                .open()
                .registration(user.getName(), user.getEmail(), user.getPassword())
                        .isSignInPageOpened();
       assertTrue(isSignInPageOpened);
       deleteUser(user);

    }

    @Test
    public void registerWithWrongPassword(){
        String actualResult = new RegistrationPage(driver)
                .open()
                .registration(user.getName(), user.getEmail(), "qwert")
                .getShortPasswordError();
        assertEquals("Некорректный пароль", actualResult);
    }
}
