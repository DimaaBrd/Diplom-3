package Utils;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import ru.praktikum.pageObject.LoginPage;

public class UtilityClass {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";


    public static final String TEST_EMAIL = "bardahcievdmitrij+1@gmail.com";
    public static final String TEST_PASSWORD = "445500";
    public static final String TEST_NAME = "Random_Name";

    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static void login(LoginPage loginPage){
        loginPage.loginEmailInput(TEST_EMAIL);
        loginPage.loginPasswordInput(TEST_PASSWORD);
        loginPage.clickEnterButton();
    }
    public static void deleteUser(String token) {
        RestAssured.given()
                .header("Authorization", token)
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user");

    }
}








