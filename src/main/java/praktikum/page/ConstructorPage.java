package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class ConstructorPage {
    private final WebDriver webDriver;

    //Локатор таба "Булки"
    private final By bunTab = By.xpath("//div[span[text()='Булки']]");
    //Локатор таба "Соусы"
    private final By sauceTab = By.xpath("//div[span[text()='Соусы']]");
    //Локатор таба "Начинки"
    private final By fillingTab = By.xpath("//div[span[text()='Начинки']]");

    public ConstructorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkBunTab(){
        return webDriver.findElement(bunTab).getAttribute("class").contains("current");
    }

    public boolean checkSauceTab(){
        return webDriver.findElement(sauceTab).getAttribute("class").contains("current");
    }

    public boolean checkFillingTab(){
        return webDriver.findElement(fillingTab).getAttribute("class").contains("current");
    }

    public void clickBunTab(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(bunTab));
    }

    public void clickSauceTab(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(sauceTab));
    }

    public void clickFillingTab(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(fillingTab));
    }
}
