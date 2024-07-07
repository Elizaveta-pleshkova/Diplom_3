package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.page.*;


public class AuthorizationTest {
    private WebDriver webDriver;
    private static final String BROWSER = "yandex";
    private final String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
    private final String password = RandomStringUtils.randomAlphabetic(10);
    private final String name = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setup(){
        webDriver = WebDriverFactory.getWebDriver(BROWSER);

        webDriver.get("https://stellarburgers.nomoreparties.site/");

        APIRequest apiRequest = new APIRequest();
        apiRequest.createUser(name, email, password);

    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной странице")
    public void signInBySignButtonOnMainPage() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkIsCheckoutButtonEnable());
    }

    @Test
    @DisplayName("Вход по кнопке 'Личный кабинет' в шапке")
    public void signInBySignButtonOnHeader() {
        Header header = new Header(webDriver);
        header.clickPersonalAccountLink();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(webDriver);
        Assert.assertTrue(mainPage.checkIsCheckoutButtonEnable());
    }

    @Test
   @DisplayName("Вход по кнопке на странице регистрации")
    public void signInBySignButtonOnRegisterPage() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRegisterLink();
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.clickSignInLink();

        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkIsCheckoutButtonEnable());
    }

    @Test
    @DisplayName("Вход по кнопке на странице восстановления пароля")
    public void signInBySignButtonOnPasswordRecoveryPage() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRecovery();

        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(webDriver);
        passwordRecoveryPage.clickSignInButton();

        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSignInButton();

        Assert.assertTrue(mainPage.checkIsCheckoutButtonEnable());
    }

    @Test
   @DisplayName("Выход из аккаунта")
    public void signOut() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSignInButton();

        Header header = new Header(webDriver);
        header.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);

        personalAccountPage.clickSignOutLink();

        Assert.assertTrue(loginPage.checkSignInLink());
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
