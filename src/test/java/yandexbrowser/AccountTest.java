package yandexbrowser;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgerspageobject.LoginPage;
import stellarburgerspageobject.MainPage;
import stellarburgerspageobject.ProfilePage;
import userrestassured.User;
import userrestassured.UserClient;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static stellarburgerspageobject.LoginPage.LOGIN_PAGE_URL;
import static stellarburgerspageobject.MainPage.MAIN_PAGE_URL;
import static stellarburgerspageobject.ProfilePage.PROFILE_PAGE_URL;

public class AccountTest {

    private User user;
    private UserClient userClient;
    private String accessToken;
    private MainPage mainPage;

    @Before
    public void setUp() {
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
        userClient = new UserClient();
        user = User.getRandom();
        ValidatableResponse response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken");
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверь переход по клику на «Личный кабинет»")
    @TmsLink("TMS-3.1.ya")
    @Issue("BUG-3.1.ya")
    public void accountAccess() {
        mainPage.clickAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.email);
        loginPage.setPasswordField(user.password);
        loginPage.clickEnterButton();

        mainPage.clickAccountButton();

        webdriver().shouldHave(url(PROFILE_PAGE_URL));
        closeWebDriver();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверь переход по клику на «Конструктор»")
    @TmsLink("TMS-3.2.1.ya")
    @Issue("BUG-3.2.1.ya")
    public void constructorFromAccountAccess() {
        mainPage.clickAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.email);
        loginPage.setPasswordField(user.password);
        loginPage.clickEnterButton();

        mainPage.clickAccountButton();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickConstructorButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
        closeWebDriver();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверь переход по клику на логотип Stellar Burgers")
    @TmsLink("TMS-3.2.2.ya")
    @Issue("BUG-3.2.2.ya")
    public void constructorLogoPictureFromAccountAccess() {
        mainPage.clickAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.email);
        loginPage.setPasswordField(user.password);
        loginPage.clickEnterButton();

        mainPage.clickAccountButton();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickLogoPicture();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
        closeWebDriver();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете")
    @TmsLink("TMS-3.3.ya")
    @Issue("BUG-3.3.ya")
    public void exitFromAccount() {
        mainPage.clickAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.email);
        loginPage.setPasswordField(user.password);
        loginPage.clickEnterButton();

        mainPage.clickAccountButton();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();

        webdriver().shouldHave(url(LOGIN_PAGE_URL));
        closeWebDriver();
    }
}
