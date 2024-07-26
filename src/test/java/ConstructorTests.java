import Utils.UtilityClass;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.pageObject.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static webDriver.WebDriverCreator.createWebDriver;

public class ConstructorTests {

    private MainPage mainPage;
    private WebDriver webDriver;
    @Before
    public void setUp() {
        webDriver = createWebDriver();
        webDriver.get(UtilityClass.MAIN_PAGE_URL);
        mainPage = new MainPage(webDriver);
    }

    @Test
    @Description("Тест перехода к разделу Булки. Сначала клик на соусы потому что раздел булки выбран сразу")
    public void followBunTest(){
        mainPage.clickSaucesSection();
        mainPage.clickBunSection();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(mainPage.getSelectedSectionLocator(), "Булки"));
        assertTrue(mainPage.isBunSuccessful());
    }
    @Test
    @Description("Тест перехода к разделу Соусы")
    public void followSaucesTest(){
        mainPage.clickSaucesSection();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(mainPage.getSelectedSectionLocator(), "Соусы"));
        assertTrue(mainPage.isSauceSuccessful());
    }
    @Test
    @Description("Тест перехода к разделу Начинки")
    public void followFillingsTest(){
        mainPage.clickFillingsSection();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(mainPage.getSelectedSectionLocator(), "Начинки"));
        assertTrue(mainPage.isFillingSuccessful());
    }
    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
