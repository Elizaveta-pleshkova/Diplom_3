package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Header {
    private final WebDriver webDriver;

    //Локатор ссылки "Конструктор"
    private final By constructorLink = By.xpath("//a[@class='AppHeader_header__link__3D_hX' and @href='/']");
    //Локатор логотипа-ссылки
    private final By logoLink = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']//a[@href='/']");
    //Локатор ссылки "Личный кабинет"
    private final By personalAccountLink = By.xpath("//a[@href='/account']");


    public Header(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickConstructorLink(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(constructorLink));
    }
    public void clickLogoLink(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(logoLink));
    }
    public void clickPersonalAccountLink(){
        WebElement element = (new WebDriverWait(webDriver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(personalAccountLink));
        webDriver.findElement(personalAccountLink).click();
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        js.executeScript("arguments[0].click();", webDriver.findElement(personalAccountLink));
    }
}
