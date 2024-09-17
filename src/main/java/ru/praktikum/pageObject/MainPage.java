package ru.praktikum.pageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class MainPage {
    private final WebDriver webDriver;
    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private final By mainPageEnterAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By bunSectionLocator = By.xpath("//div[span[text()='Булки']]");
    private final By saucesSectionLocator = By.xpath("//div[span[text()='Соусы']]");
    private final By fillingsSectionLocator = By.xpath("//div[span[text()='Начинки']]");
    private final By buildBurgerLocator = By.xpath("//h1[text()='Соберите бургер']");
    private final By sectionSelectedLocator = By.xpath("//div[contains(@class, 'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private final By createOrderButtonLocator = By.xpath("//button[text()='Оформить заказ']");

    @Step("Нажимаем кнопку Войти на главной странице")
    public void clickLoginButtonMainPage(){
        webDriver.findElement(mainPageEnterAccountButton).click();
    }

    @Step
    @Description("Нажать на кнопку Личный Кабинет")
    public void clickPersonalAccountButton(){
        webDriver.findElement(personalAccountButton).click();
    }

    @Step
    @Description("Переход по клику в секции Булки")
    public void clickBunSection(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunSectionLocator)).click();
    }

    @Step
    @Description("Переход по клику в секции Соусы")
    public void clickSaucesSection(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(saucesSectionLocator)).click();
    }

    @Step
    @Description("Переход по клику в секции Начинки")
    public void clickFillingsSection(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsSectionLocator)).click();
    }

    @Step
    public boolean isBunSuccessful(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionSelectedLocator));
        Assert.assertEquals("Булки", element.getText());
        return element.isDisplayed();
    }

    @Step
    public boolean isSauceSuccessful(){
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionSelectedLocator));
        Assert.assertEquals("Соусы", element.getText());
        return element.isDisplayed();
    }

    @Step
    public boolean isFillingSuccessful(){
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionSelectedLocator));
        Assert.assertEquals("Начинки", element.getText());
        return element.isDisplayed();
    }

    @Step
    @Description("Шаг для проверки отображения текста Соберите Бургер после перехода по логотипу")
    public boolean checkIfBuildBurgerIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(buildBurgerLocator)).isDisplayed();
    }
    @Step
    public boolean successLoginCheck(){
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderButtonLocator)).isDisplayed();
    }
    @Step
    public By getSelectedSectionLocator() {
        return sectionSelectedLocator;
    }
    @Step
    public By getPersonalAccButton(){
        return personalAccountButton;
    }
}