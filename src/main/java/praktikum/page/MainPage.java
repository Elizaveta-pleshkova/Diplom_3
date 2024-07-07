package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends Header {
    private final WebDriver webDriver;

    public static final  String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //Локатор кнопки "Войти в аккаунт"
    private final By signInButtonLocator = By.xpath("//button[text()='Войти в аккаунт']");

    //Локатор кнопки "Оформить заказ"
    private final By checkoutButton = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public void clickSignInButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(signInButtonLocator));
    }

    public boolean checkIsCheckoutButtonEnable(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkoutButton));
        return webDriver.findElement(checkoutButton).isDisplayed();
    }

    public boolean checkIsSignButtonEnable(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(signInButtonLocator));
        return webDriver.findElement(signInButtonLocator).isDisplayed();
    }
}
