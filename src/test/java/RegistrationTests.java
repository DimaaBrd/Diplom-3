import Utils.UtilityClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.praktikum.pageObject.LoginPage;
import ru.praktikum.pageObject.MainPage;
import ru.praktikum.pageObject.RegistrationPage;


import static org.junit.Assert.assertTrue;
import static webDriver.WebDriverCreator.createWebDriver;

public class RegistrationTests {
    private WebDriver webDriver;
    private String userEmail;
    private MainPage mainPage;
    private LoginPage loginPage;
    private String userToken;
    private RegistrationPage registrationPage;
    private static final Logger logger = LoggerFactory.getLogger(RegistrationTests.class);


    @Before
    public void setup(){
        webDriver = createWebDriver();
        webDriver.get(UtilityClass.REGISTRATION_PAGE_URL);
        registrationPage = new RegistrationPage(webDriver);
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
    }

    @Test
    public void successfulRegistrationTest() {
        userEmail = UtilityClass.generateEmail();
        registrationPage.enterName(UtilityClass.TEST_NAME);
        registrationPage.enterEmail(userEmail);
        registrationPage.enterPassword(UtilityClass.TEST_PASSWORD);
        registrationPage.clickRegistrationButton();
        assertTrue(loginPage.isEnterButtonDisplayed());
        loginPage.loginEmailInput(userEmail);
        loginPage.loginPasswordInput(UtilityClass.TEST_PASSWORD);
        loginPage.clickEnterButton();
        assertTrue(mainPage.successLoginCheck());
        userToken = registrationPage.getToken();
    }

    @Test
    public void shortPasswordValidation(){
        userEmail = UtilityClass.generateEmail();
        registrationPage.enterName(UtilityClass.TEST_NAME);
        registrationPage.enterEmail(userEmail);
        registrationPage.enterPassword("12345");
        registrationPage.clickRegistrationButton();
        registrationPage.validationShouldBeDisplayed();
    }
    @After
    public void tearDown() {
        if (userToken != null) {
            UtilityClass.deleteUser(userToken);
        }
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

