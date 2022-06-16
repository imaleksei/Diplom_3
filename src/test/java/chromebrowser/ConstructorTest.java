package chromebrowser;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgerspageobject.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static stellarburgerspageobject.MainPage.MAIN_PAGE_URL;

public class ConstructorTest {

    private MainPage mainPage;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам: «Булки»")
    @TmsLink("TMS-4.1")
    @Issue("BUG-4.1")
    public void checkSpanBunsConstructorIsAvailable() {
        mainPage.scrollToMeats();
        mainPage.clickBunsSpan();

        assertTrue(mainPage.isDisplayedBuns());
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам: «Соусы»")
    @TmsLink("TMS-4.2")
    @Issue("BUG-4.2")
    public void checkSpanSaucesConstructorIsAvailable() {
        mainPage.clickSaucesSpan();

        assertTrue(mainPage.isDisplayedSauces());
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам: «Начинки»")
    @TmsLink("TMS-4.3")
    @Issue("BUG-4.3")
    public void checkSpanMeatsConstructorIsAvailable() {
        mainPage.clickMeatsSpan();

        assertTrue(mainPage.isDisplayedMeats());
    }
}
