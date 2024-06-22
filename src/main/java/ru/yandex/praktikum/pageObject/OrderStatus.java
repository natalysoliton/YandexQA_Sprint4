package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Страница https://qa-scooter.praktikum-services.ru/order Статус заваза
public class OrderStatus {
    WebDriver driver;
    private final By yandexButton = By.xpath(".//*[@alt='Yandex']");
    private final By scooterButton = By.xpath(".//*[@alt='Scooter']");
    private final By notFound = By.xpath(".//*[@alt='Not found']");

    public OrderStatus(WebDriver driver) {

        this.driver = driver;
    }

    public OrderStatus waitLoadOrderStatusPade() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(notFound));
        return this;
    }

    public void clickYandex() {

        driver.findElement(yandexButton).click();
    }

    public void clickScooter() {

        driver.findElement(scooterButton).click();
    }
}
