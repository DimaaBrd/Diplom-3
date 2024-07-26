package ru.praktikum.pageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver webDriver;
    private final By enterFromForgotPasswordPage = By.xpath("//a[text()='Войти' and @href='/login']");

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step
    @Description("Нажимаем на кнопку Войти со страницы восстановления пароля")
    public void clickEnterFromForgotPasswordPage(){
        webDriver.findElement(enterFromForgotPasswordPage).click();
    }
}
