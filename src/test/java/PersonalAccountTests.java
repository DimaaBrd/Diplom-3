import Utils.UtilityClass;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.pageObject.LoginPage;
import ru.praktikum.pageObject.MainPage;
import ru.praktikum.pageObject.PersonalAccountPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static webDriver.WebDriverCreator.createWebDriver;

public class PersonalAccountTests {

    private WebDriver webDriver;
    private PersonalAccountPage personalAccountPage;
    private LoginPage loginPage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        webDriver = createWebDriver();
        personalAccountPage = new PersonalAccountPage(webDriver);
        webDriver.get(UtilityClass.MAIN_PAGE_URL);
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
    }

    @Test
    @Description("В тесте залогинились существующим пользователем и проверили переход в личный кабинет")
    public void GoToPersonalAccountTest() {
        mainPage.clickLoginButtonMainPage();
        UtilityClass.login(loginPage);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getPersonalAccButton()));
        mainPage.clickPersonalAccountButton();
        assertTrue(personalAccountPage.checkIfProfileDisplayed());
    }

    @Test
    @Description("Тест проверяющий переход из личного кабинета в Конструктор")
    public void GoToConstructorTest() {
        mainPage.clickLoginButtonMainPage();
        UtilityClass.login(loginPage);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickConstructorFromProfile();
        assertTrue(mainPage.checkIfBuildBurgerIsDisplayed());
    }

    @Test
    @Description("Тест на переход из личного кабинета в конструктор по логотипу")
    public void GoToConstructorByLogo() {
        mainPage.clickLoginButtonMainPage();
        UtilityClass.login(loginPage);
        mainPage.clickPersonalAccountButton();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountPage.getLogo()));
        personalAccountPage.clickLogo();
        assertTrue(mainPage.checkIfBuildBurgerIsDisplayed());
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}


