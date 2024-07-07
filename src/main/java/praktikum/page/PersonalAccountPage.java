package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PersonalAccountPage {
    private final WebDriver webDriver;

    public static final String A = "https://stellarburgers.nomoreparties.site/account/profile";

    //Локатор кнопки "Выход"
    private final By signOutLink = By.xpath("//button[text()='Выход']");

    public PersonalAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickSignOutLink(){
        WebElement element = (new WebDriverWait(webDriver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(signOutLink));
        webDriver.findElement(signOutLink).click();
    }


    public boolean checkSignOutLink(){
        return webDriver.findElement(signOutLink).isDisplayed();
    }
}
