package chromebrowser;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgerspageobject.LoginPage;
import stellarburgerspageobject.MainPage;
import stellarburgerspageobject.RecoverPage;
import stellarburgerspageobject.RegistrationPage;
import userrestassured.User;
import userrestassured.UserClient;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static stellarburgerspageobject.MainPage.MAIN_PAGE_URL;

public class LoginTest {
    private User user;
    private UserClient userClient;
    private String accessToken;
    private MainPage mainPage;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        userClient = new UserClient();
        user = User.getRandom();
        ValidatableResponse response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken");
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        userClient.deleteUser(accessToken);
        closeWebDriver();
    }

    @Test
    @DisplayName("Вход")
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    @TmsLink("TMS-2.1")
    @Issue("BUG-2.1")
    public void enterButtonOnMainPageLogin() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.email);
        loginPage.setPasswordField(user.password);
        loginPage.clickEnterButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Вход")
    @Description("Вход через кнопку «Личный кабинет»")
    @TmsLink("TMS-2.2")
    @Issue("BUG-2.2")
    public void accountButtonOnMainPageLogin() {
        mainPage.clickAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.email);
        loginPage.setPasswordField(user.password);
        loginPage.clickEnterButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Вход")
    @Description("Вход через кнопку в форме регистрации")
    @TmsLink("TMS-2.3")
    @Issue("BUG-2.3")
    public void enterButtonOnRegistrationPageLogin() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickEnterButton();

        loginPage.setEmailField(user.email);
        loginPage.setPasswordField(user.password);
        loginPage.clickEnterButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Вход")
    @Description("Вход через кнопку в форме восстановления пароля")
    @TmsLink("TMS-2.4")
    @Issue("BUG-2.4")
    public void enterButtonOnRecoverPageLogin() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRecoverPasswordButton();

        RecoverPage recoverPage = page(RecoverPage.class);
        recoverPage.clickEnterButton();

        loginPage.setEmailField(user.email);
        loginPage.setPasswordField(user.password);
        loginPage.clickEnterButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }
}

