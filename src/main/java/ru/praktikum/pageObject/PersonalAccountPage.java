package ru.praktikum.pageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class PersonalAccountPage {
    private final WebDriver webDriver;
    public PersonalAccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    //Локатор кнопки Профиль
    private final By profileButtonLocator = By.xpath("//a[@href='/account/profile' and text()='Профиль']");
    //Локатор кнопки Конструктор
    private final By constructorButtonLocator= By.xpath("//a[contains(@class, 'AppHeader_header__link__3D_hX') and descendant::p[text()='Конструктор']]");
    //Локатор логотипа
    private final By logoLocator = By.xpath("//div/a");
    //Локатор кнопки Выход
    private final By logoutButtonLocator = By.xpath("//button[@type='button' and contains(@class, 'Account_button__14Yp3') and text()='Выход']");

    @Step
    @Description("Шаг для проерки перехода в личный Кабинет Пользователя")
    public boolean checkIfProfileDisplayed(){
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileButtonLocator)).isDisplayed();
    }

    @Step
    @Description("Шаг для перехода из Профиля к Конструктору")
    public void clickConstructorFromProfile(){
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(constructorButtonLocator));
        webDriver.findElement(constructorButtonLocator).click();
    }

    @Step
    @Description("Шаг для проверки выхода из аккаунта")
    public void clickLogoutButton(){
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(10)); // Увеличиваем ожидание
        wait.until(ExpectedConditions.elementToBeClickable(logoutButtonLocator)).click();
    }

    @Step
    @Description("Шаг для перехода в Конструктор по клику на логотип")
    public void clickLogo(){
        webDriver.findElement(logoLocator).click();
    }
    @Step
    @Description("Шаг используется в тесте для явного ожидания видимости элемента логотипа Burger")

    public By getLogo() {
        return logoLocator;
    }



}
