package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverFactory {
    public static WebDriver getWebDriver(String browserType){
        if (browserType.equalsIgnoreCase("firefox")){
            return WebDriverManager.firefoxdriver().create();
        } else if (browserType.equalsIgnoreCase("yandex")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
           return new ChromeDriver();}
        else{
            return WebDriverManager.chromedriver().create();
        }
    }
}
