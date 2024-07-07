package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    private final WebDriver webDriver;

    //Локатор поля ввода "Имя"
    private final By nameInputField = By.xpath("//div[label[text()='Имя']]//input");
    //Локатор поля ввода "Email"
    private final By emailInputField = By.xpath("//div[label[text()='Email']]//input");
    //Локатор поля ввода "Пароль"
    private final By passwordInputField = By.xpath("//input[@name='Пароль']");
    //Локатор кнопки "Зарегистрироваться"
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    //Локатор текста ошибки "Некорректный пароль"
    private final By incorrectPasswordText = By.xpath("//p[text()='Некорректный пароль']");
    //Локатор кнопки "Войти"
    private final By signInLink = By.xpath("//a[@href='/account']");


    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickSignInLink(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(signInLink));
    }
    public void clickRegisterButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(registerButton));
    }

    public void setName(String name){
        WebElement registerName = webDriver.findElement(nameInputField);
        registerName.sendKeys(name);
    }

    public void setEmail(String email){
        WebElement registerEmail = webDriver.findElement(emailInputField);
        registerEmail.sendKeys(email);
    }

    public void setPassword(String password){
        WebElement registerPassword = webDriver.findElement(passwordInputField);
        registerPassword.sendKeys(password);
    }

    public void clickRegister(){
        webDriver.findElement(registerButton).click();
    }

    public boolean checkIncorrectPasswordText(){
        return webDriver.findElement(incorrectPasswordText).isDisplayed();
    }

}
