package yandexbrowser;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgerspageobject.LoginPage;
import stellarburgerspageobject.MainPage;
import stellarburgerspageobject.RegistrationPage;
import userrestassured.User;
import userrestassured.UserClient;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;
import static stellarburgerspageobject.LoginPage.LOGIN_PAGE_URL;

public class RegistrationTest {
    private User user;
    private UserClient userClient;
    private MainPage mainPage;
    private String accessToken;

    @Before
    public void setUp() {
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
        userClient = new UserClient();
        user = User.getRandom();
        mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        try {
            userClient.deleteUser(accessToken);
        } catch(IllegalArgumentException error) {
                //client doesnt exist
            }
        closeWebDriver();
    }

    @Test
    @DisplayName("Регистрация")
    @Description("Успешная регистрация")
    @TmsLink("TMS-1.1.ya")
    @Issue("BUG-1.1.ya")
    public void positiveRegistration() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(user.name);
        registrationPage.setEmailField(user.email);
        registrationPage.setPasswordField(user.password);
        registrationPage.clickRegistrationButton();

        webdriver().shouldHave(url(LOGIN_PAGE_URL));
    }

    @Test
    @DisplayName("Регистрация")
    @Description("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    @TmsLink("TMS-1.2.ya")
    @Issue("BUG-1.2.ya")
    public void checkErrorForShortPasswordDuringRegistration() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(user.name);
        registrationPage.setEmailField(user.email);
        registrationPage.setPasswordField(RandomStringUtils.randomAlphabetic(3));
        registrationPage.clickRegistrationButton();

        assertTrue("Error password field not displayed", registrationPage.errorPasswordFieldIsDisplayed());
    }
}
