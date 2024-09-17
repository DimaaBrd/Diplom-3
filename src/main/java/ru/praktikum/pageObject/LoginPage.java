package ru.praktikum.pageObject;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class LoginPage {
    private final WebDriver webDriver;
    private final By emailFieldLocator = By.xpath("//input[@name='name']");
    private final By passwordFieldLocator = By.xpath("//input[@name='Пароль']");
    private final By enterButtonLocator = By.xpath("//button[text()='Войти']");




    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step
    @Description("Проверка отображения кнопки Войти")
    public boolean isEnterButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(enterButtonLocator)).isDisplayed();
    }
    @Step
    @Description("Ввод почты при логине")
    public void loginEmailInput(String email){
        webDriver.findElement(emailFieldLocator).sendKeys(email);
    }
    @Step
    @Description("Ввод пароля при логине")
    public void loginPasswordInput(String password){
        webDriver.findElement(passwordFieldLocator).sendKeys(password);
    }
    @Step
    @Description("Клик по кнопке входа")
    public void clickEnterButton(){
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enterButtonLocator));
        webDriver.findElement(enterButtonLocator).click();
    }


}


