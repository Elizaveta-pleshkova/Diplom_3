package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.page.Header;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;
import praktikum.page.RegistrationPage;


public class RegisterUserTest {
    private WebDriver webDriver;
    private static final String BROWSER = "yandex";
    private final String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
    private final String password = RandomStringUtils.randomAlphabetic(10);
    private final String incorrectPassword = RandomStringUtils.randomAlphabetic(5);
    private final String name = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setup(){
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        //webDriver = WebDriverFactory.getWebDriver();

        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Регистрация пользователя с корректными данными")
    public void registerUserSuccessfully() {
        Header header = new Header(webDriver);
        header.clickPersonalAccountLink();

        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.clickRegisterLink();


        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.clickRegister();



        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSignInButton();

        MainPage mainPage = new MainPage(webDriver);
        Assert.assertTrue(mainPage.checkIsCheckoutButtonEnable());
    }

    @Test
    @DisplayName("Регистрация пользователя паролем меньшим допустимой длины")
    public void registerUserUnsuccessfully() {
        Header header = new Header(webDriver);
        header.clickPersonalAccountLink();

        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.clickRegisterLink();

        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(incorrectPassword);
        registrationPage.clickRegister();

        Assert.assertTrue(registrationPage.checkIncorrectPasswordText());
    }


    @After
    public void tearDown(){
        APIRequest apiRequest = new APIRequest();
        String token = apiRequest.loginUser(email, password)
                .extract().body().path("accessToken");
        if (token != null){
            apiRequest.deleteUser(token);
        }
        webDriver.quit();
    }
}
