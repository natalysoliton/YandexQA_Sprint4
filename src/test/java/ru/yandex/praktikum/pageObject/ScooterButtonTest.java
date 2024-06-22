package ru.yandex.praktikum.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ScooterButtonTest {
    WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";

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
    public void clickScooterFromAboutRenterPage() {
        HomePage homePage = new HomePage(driver);
        AboutRenter aboutRenter = new AboutRenter(driver);

        homePage.waitForLoadHomePage()
                .clickUpOrderButton();

        aboutRenter.waitForLoadOrderPage()
                .clickScooter();

        new WebDriverWait(driver, Duration.ofSeconds(5));

        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromAboutScooterPage() {
        HomePage homePage = new HomePage(driver);
        AboutRenter aboutRenter = new AboutRenter(driver);
        AboutScooter aboutScooter = new AboutScooter(driver);

        homePage.waitForLoadHomePage()
                .clickUpOrderButton();

        aboutRenter.waitForLoadOrderPage()
                .inputName("Иван")
                .inputSurname("Иванов")
                .inputAddress("ул Тестовая 1")
                .changeStateMetro(77)
                .inputTelephone("+79999999999")
                .clickNextButton();

        aboutScooter.waitAboutRentHeader()
                .clickScooter();

        new WebDriverWait(driver, Duration.ofSeconds(5));

        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromOrderStatusPage() {
        HomePage homePage = new HomePage(driver);
        OrderStatus orderStatus = new OrderStatus(driver);

        homePage.waitForLoadHomePage()
                .clickOrderState()
                .inputOrderNumber("45106")
                .clickGo();

        orderStatus.waitLoadOrderStatusPade()
                .clickScooter();

        new WebDriverWait(driver, Duration.ofSeconds(5));

        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

}
