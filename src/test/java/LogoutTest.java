import Utils.UtilityClass;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.pageObject.LoginPage;
import ru.praktikum.pageObject.MainPage;
import ru.praktikum.pageObject.PersonalAccountPage;

import static org.junit.Assert.assertTrue;
import static webDriver.WebDriverCreator.createWebDriver;

public class LogoutTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver webDriver;
    private PersonalAccountPage personalAccountPage;

    @Before
    public void setUp(){
        webDriver = createWebDriver();
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        personalAccountPage = new PersonalAccountPage(webDriver);
        webDriver.get(UtilityClass.MAIN_PAGE_URL);
    }

    @Test
    @Description("Тест логаута из Аккаунта по кнопке в личном кабинете")
    public void LogoutTest(){
        mainPage.clickLoginButtonMainPage();
        UtilityClass.login(loginPage);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickLogoutButton();
        assertTrue(loginPage.isEnterButtonDisplayed());
    }
    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
