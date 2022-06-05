package yandexbrowser;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgerspageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;
import static stellarburgerspageobject.MainPage.MAIN_PAGE_URL;

public class ConstructorTest {

    private MainPage mainPage;

    @Before
    public void setUp() {
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам: «Булки»")
    @TmsLink("TMS-4.1.ya")
    @Issue("BUG-4.1.ya")
    public void checkSpanBunsConstructorIsAvailable() {
        mainPage.scrollToMeats();
        mainPage.clickBunsSpan();

        assertTrue(mainPage.isDisplayedBuns());
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам: «Соусы»")
    @TmsLink("TMS-4.2.ya")
    @Issue("BUG-4.2.ya")
    public void checkSpanSaucesConstructorIsAvailable() {
        mainPage.clickSaucesSpan();

        assertTrue(mainPage.isDisplayedSauces());
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам: «Начинки»")
    @TmsLink("TMS-4.3.ya")
    @Issue("BUG-4.3.ya")
    public void checkSpanMeatsConstructorIsAvailable() {
        mainPage.clickMeatsSpan();

        assertTrue(mainPage.isDisplayedMeats());
    }
}
