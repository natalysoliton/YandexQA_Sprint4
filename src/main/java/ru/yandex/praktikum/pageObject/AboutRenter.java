package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Страница https://qa-scooter.praktikum-services.ru/order Для кого самокат и описание локаторов для каждого поля и кнопки с последующим заполнением тестовыми данными

public class AboutRenter {
    WebDriver driver;
    private final By orderHeader = By.className("Order_Header__BZXOb");
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By stateMetro = By.className("select-search__input");
    private final By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final String nameStateMetro = ".//button[@value='%s']";
    private final By yandexButton = By.xpath(".//*[@alt='Yandex']");
    private final By scooterButton = By.xpath(".//*[@alt='Scooter']");

    public AboutRenter(WebDriver driver) {

        this.driver = driver;
    }

    //метод ожидания загруки страницы заказа
    public AboutRenter waitForLoadOrderPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(orderHeader).getText() != null
                && !driver.findElement(orderHeader).getText().isEmpty()
        ));
        return this;
    }

    public AboutRenter inputName(String newName) {
        driver.findElement(name).sendKeys(newName);
        return this;
    }

    public AboutRenter inputSurname(String newSurname) {
        driver.findElement(surname).sendKeys(newSurname);
        return this;
    }

    public AboutRenter inputAddress(String newAddress) {
        driver.findElement(address).sendKeys(newAddress);
        return this;
    }

    public AboutRenter changeStateMetro(int stateNumber) {
        driver.findElement(stateMetro).click();
        By newStateMetro = By.xpath(String.format(nameStateMetro, stateNumber));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(newStateMetro));
        driver.findElement(newStateMetro).click();
        return this;
    }

    public AboutRenter inputTelephone(String newTelephone) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(telephone));
        driver.findElement(telephone).sendKeys(newTelephone);
        return this;
    }

    public void clickNextButton() {

        driver.findElement(buttonNext).click();
    }

    public void clickYandex() {

        driver.findElement(yandexButton).click();
    }
    public void clickScooter() {

        driver.findElement(scooterButton).click();
    }
}
