import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import page_objects.User;

import static io.restassured.RestAssured.*;
public class BaseChromeUITest {

    protected WebDriver driver;
    public static String POST_CREATE_USER = "/api/auth/register";
    public static String POST_LOGIN_USER = "/api/auth/login";
    public static String DELETE_USER = "/api/auth/user";
    protected User user = new User("web@yandex.ru", "qwerty12", "Yo");

    @Before
    @Step("Инициализация драйвера")
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        setUp();
    }

    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    @After
    @Step("Очищение тестовых данных")
    public void tearDown() {
        driver.quit();
    }

    @Step("Создание пользователя")
    public Response createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(POST_CREATE_USER);
    }

    @Step("Аторизация пользователя")
    public Response loginUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(POST_LOGIN_USER);
    }

    @Step("Уделаение пользователя")
    public void deleteUser(User user) {
        String token = getAccessToken(user);
        given()
                .auth().oauth2(token)
                .header("Content-type", "application/json")
                .body(user)
                .delete(DELETE_USER);
    }

    public String getAccessToken(User user) {
        String accessToken = loginUser(user).then().extract().body().path("accessToken");
        return accessToken;
    }
}