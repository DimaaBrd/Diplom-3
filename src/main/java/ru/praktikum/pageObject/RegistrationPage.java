package ru.praktikum.pageObject;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RegistrationPage {
    private final WebDriver webDriver;
    //локатор поля Имя
    private final By nameFieldLocator = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    //локатор поля email
    private final By emailFieldLocator = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    //локатор поля Пароль
    private final By passwordFieldLocator = By.xpath("//input[@type='password']");
    //Локатор кнопки Зарегистрироваться
    private final By registrationButtonLocator = By.xpath("//button[text()='Зарегистрироваться']");
    //Локатор валидационного сообщения на пароль
    private final By validatePasswordError = By.xpath("//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    //Локатор кнопки Войти
    private final By loginButtonRegistrationPage = By.xpath("//a[text()='Войти' and @href='/login']");
    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step
    @Description("Ввод имени для регистрации")
    public void enterName(String name) {
        WebElement nameInput = webDriver.findElement(nameFieldLocator);
        nameInput.sendKeys(name);
    }
    @Step
    @Description("Ввод почты для регистрации")
    public void enterEmail(String email) {
        WebElement emailInput = webDriver.findElement(emailFieldLocator);
        emailInput.sendKeys(email);
    }
    @Step
    @Description("Ввод пароля для регистраци")
    public void enterPassword(String password) {
        WebElement passwordInput = webDriver.findElement(passwordFieldLocator);
        passwordInput.sendKeys(password);
    }
    @Step
    @Description("Клик по кнопке регистрации")
    public void clickRegistrationButton(){
        WebElement registrationButton = webDriver.findElement(registrationButtonLocator);
        registrationButton.click();
    }

    @Step
    @Description("Проверка срабатывания валидации на невалидный пароль")
    public void validationShouldBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(validatePasswordError)).isDisplayed();
    }
    @Step
    @Description("Клик по кнопке Войти на странице регистрации")
    public void clickEnterButtonFromRegistrationPage(){
        webDriver.findElement(loginButtonRegistrationPage).click();
    }
    @Step
    @Description("Шаг для получения токена")
    public String getToken() {
        return (String) ((JavascriptExecutor) webDriver).executeScript("return localStorage.getItem('accessToken');");
    }
}



