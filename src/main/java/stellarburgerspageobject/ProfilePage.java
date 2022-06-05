package stellarburgerspageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // локаторы
    // поле "Имя"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Имя')]")
    private SelenideElement nameField;

    // поле "Логин"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Логин')]")
    private SelenideElement loginField;

    // поле "Пароль"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Пароль')]")
    private SelenideElement passwordField;

    // кнопка "Профиль"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Профиль')]")
    private SelenideElement profileButton;

    // кнопка "История заказов"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'История заказов')]")
    private SelenideElement orderHistoryButton;

    // кнопка "Выход"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Выход')]")
    private SelenideElement exitButton;

    // кнопка "Сохранить"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Сохранить')]")
    private SelenideElement saveButton;

    // кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Конструктор')]")
    private SelenideElement constructorButton;

    // логотип сайта "Stellar Burgers"
    @FindBy(how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoPicture;

    // методы
    @Step("Ввести name")
    public ProfilePage setNameField(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Ввести login")
    public ProfilePage setLoginField(String login) {
        loginField.setValue(login);
        return this;
    }

    @Step("Ввести password")
    public ProfilePage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Клик по кнопке 'Профиль'")
    public ProfilePage clickProfileButton() {
        profileButton.click();
        return this;
    }

    @Step("Клик по кнопке 'История заказов'")
    public OrderHistoryPage clickOrderHistoryButton() {
        orderHistoryButton.click();
        return page(OrderHistoryPage.class);
    }

    @Step("Клик по кнопке 'Выход'")
    public LoginPage clickExitButton() {
        exitButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке 'Сохранить'")
    public ProfilePage clickSaveButton() {
        profileButton.click();
        return this;
    }

    @Step("Клик по кнопке 'Конструктор'")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step("Клик по лого сайти")
    public MainPage clickLogoPicture() {
        logoPicture.click();
        return page(MainPage.class);
    }
}
