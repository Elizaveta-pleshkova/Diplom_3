package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver webDriver;

    //Локатор кнопки "Войти"
    private final By signInLink = By.xpath("//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickSignInButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(signInLink));
    }

}
