package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Header {
    private final WebDriver webDriver;

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    //Локатор кнопки "Зарегистрироваться"
    private final By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    //Локатор поля ввода "email"
    private final By emailInputField = By.xpath("//input[@name='name']");
    //Локатор поля ввода "Пароль"
    private final By passwordInputField = By.xpath("//input[@name='Пароль']");
    //Локатор кнопки "Войти"
    private final By signInButton = By.xpath("//button[text()='Войти']");
    //Локатор ссылки "Восстановить пароль"
    private final By passwordRecoveryLink = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public void clickRegisterLink(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(registerLink));
    }

    public void setEmail(String email){
        (new WebDriverWait(webDriver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        WebElement loginEmail = webDriver.findElement(emailInputField);
        loginEmail.sendKeys(email);
    }

    public void setPassword(String password){
        (new WebDriverWait(webDriver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        WebElement loginEmail = webDriver.findElement(passwordInputField);
        loginEmail.sendKeys(password);
    }


    public void clickSignInButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(signInButton));
    }

    public void clickRecovery(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(passwordRecoveryLink));
    }

    public boolean checkSignInLink(){
        (new WebDriverWait(webDriver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        return webDriver.findElement(signInButton).isDisplayed();
    }

}
