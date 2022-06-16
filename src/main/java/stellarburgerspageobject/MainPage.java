package stellarburgerspageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //локаторы
    // кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    // кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Личный Кабинет')]")
    private SelenideElement accountButton;

    // кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Конструктор')]")
    private SelenideElement constructorButton;

    // кнопка "Лента заказов"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Лента Заказов')]")
    private SelenideElement feedButton;

    // поле "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsSpan;

    // поле "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesSpan;

    // поле "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement meatsSpan;

    // элемент "Булок" - Флюоресцентная булка R2-D3
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/bun-01.png']")
    private SelenideElement elementBuns;

    // элемент "Соусов" - Соус Spicy-X
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/sauce-02.png']")
    private SelenideElement elementSauces;

    // элемент "Начинок" - Мясо бессмертных моллюсков Protostomia
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/meat-02.png']")
    private SelenideElement elementMeats;

    // методы
    @Step("Клик по кнопке 'Войти в аккаунт'")
    public LoginPage clickEnterAccountButton() {
        enterAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public LoginPage clickAccountButton () {
        accountButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке 'Конструктор'")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return this;
    }

    @Step("Выбор 'Булки'")
    public MainPage clickBunsSpan() {
        bunsSpan.click();
        return this;
    }

    @Step("Выбор 'Соусы'")
    public MainPage clickSaucesSpan() {
        saucesSpan.click();
        return this;
    }

    @Step("Выбор 'Начинки'")
    public MainPage clickMeatsSpan() {
        meatsSpan.click();
        return this;
    }

    @Step("Виды/элементы булок отображены")
    public boolean isDisplayedBuns() {
        return elementBuns.isDisplayed();
    }

    @Step("Виды/элементы соусов отображены")
    public boolean isDisplayedSauces() {
        return elementSauces.isDisplayed();
    }

    @Step("Виды/элементы начинок отображены")
    public boolean isDisplayedMeats() {
        return elementMeats.isDisplayed();
    }

    @Step("Скролл до начинки")
    public MainPage scrollToMeats() {
        elementMeats.scrollIntoView(true);
        return this;
    }
}
