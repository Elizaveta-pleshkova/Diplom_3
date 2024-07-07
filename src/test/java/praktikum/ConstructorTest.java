package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.page.ConstructorPage;

public class ConstructorTest {
    private WebDriver webDriver;
    private static final String BROWSER = "yandex";

    @Before
    public void setup(){
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        //webDriver = WebDriverFactory.getWebDriver();

        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void bunTabWorking() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickBunTab();
        Assert.assertTrue(constructorPage.checkBunTab());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void sauceTabWorking() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSauceTab();
        Assert.assertTrue(constructorPage.checkSauceTab());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void fillingTabWorking() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickFillingTab();
        Assert.assertTrue(constructorPage.checkFillingTab());
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
