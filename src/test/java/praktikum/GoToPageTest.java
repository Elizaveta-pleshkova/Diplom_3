package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;

public class GoToPageTest {
    private WebDriver webDriver;
    private static final String BROWSER = "yandex";

    @Before
    public void setup(){
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        //webDriver = WebDriverFactory.getWebDriver();

        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void goToPersonalAccount() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccountLink();

        Assert.assertEquals(webDriver.getCurrentUrl(), LoginPage.LOGIN_PAGE_URL);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор при нажатии на 'Конструктор'")
    public void goToConstructorFromPersonalAccount() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccountLink();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickConstructorLink();

        Assert.assertEquals(webDriver.getCurrentUrl(), MainPage.MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор при нажатии на логотип")
    public void goToConstructorFromPersonalAccountByLogo() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccountLink();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickLogoLink();

        Assert.assertEquals(webDriver.getCurrentUrl(), MainPage.MAIN_PAGE_URL);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
