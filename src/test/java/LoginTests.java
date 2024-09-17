import Utils.UtilityClass;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.pageObject.ForgotPasswordPage;
import ru.praktikum.pageObject.LoginPage;
import ru.praktikum.pageObject.MainPage;
import ru.praktikum.pageObject.RegistrationPage;
import webDriver.WebDriverCreator;

import static org.junit.Assert.assertTrue;

public class LoginTests {
    private WebDriver webDriver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ForgotPasswordPage forgotPasswordPage;

    private RegistrationPage registrationPage;

    @Before
    public void setUp(){
        webDriver = WebDriverCreator.createWebDriver();
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        webDriver.get(UtilityClass.MAIN_PAGE_URL);

    }

    @Test
    @Description("Тест логина по кнопке Войти в аккаунт с главной страницы")
    public void TestSuccessfulLoginFromMainPage(){
        mainPage.clickLoginButtonMainPage();
        UtilityClass.login(loginPage);
        assertTrue(mainPage.successLoginCheck());
    }
    @Test
    @Description("Тест логина по кнопке Войти в Личный кабинет")
    public void TestSuccessFulLoginThroughPersonalAccount(){
        mainPage.clickPersonalAccountButton();
        UtilityClass.login(loginPage);
        assertTrue(mainPage.successLoginCheck());
    }
    @Test
    @Description("Тест логина по кнопке Войти со страницы восстановления пароля")
    public void TestLoginFromForgotPasswordPage(){
        webDriver.get(UtilityClass.FORGOT_PASSWORD_PAGE_URL);
        forgotPasswordPage.clickEnterFromForgotPasswordPage();
        UtilityClass.login(loginPage);
        assertTrue(mainPage.successLoginCheck());
    }

    @Test
    @Description("Тест логина по кнопка Вход в форме Регистрации")
    public void TestLoginFromRegistrationPage(){
        webDriver.get(UtilityClass.REGISTRATION_PAGE_URL);
        registrationPage.clickEnterButtonFromRegistrationPage();
        UtilityClass.login(loginPage);
        assertTrue(mainPage.successLoginCheck());
    }



    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
