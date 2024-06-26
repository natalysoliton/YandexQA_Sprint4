package ru.yandex.praktikum.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderStatusTest {
    WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";
    private final String numberOrder = "10203";
    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(site);
    }

    @After
    public void teardown() {

        driver.quit();
    }

    @Test
    public void orderStatusWithoutNumber() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickOrderState()
                .inputOrderNumber(numberOrder)
                .clickGo();
        new OrderStatus(driver)
                .waitLoadOrderStatusPade();
    }
}
