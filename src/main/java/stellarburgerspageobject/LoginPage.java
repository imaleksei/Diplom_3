package stellarburgerspageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    // локаторы
    // поле "Email"
    @FindBy(how = How.XPATH, using = ".//input[@name ='name']")
    private SelenideElement emailField;

    // поле "Пароль"
    @FindBy(how = How.XPATH, using = ".//input[@name ='Пароль']")
    private SelenideElement passwordField;

    // кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    // кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Зарегистрироваться')]")
    private SelenideElement registrationButton;

    // кнопка "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Восстановить пароль')]")
    private SelenideElement recoverPasswordButton;

    // методы
    @Step("Ввести email")
    public LoginPage setEmailField(String email){
        emailField.setValue(email);
        return this;
    }

    @Step("Ввести password")
    public LoginPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public MainPage clickEnterButton() {
        enterButton.click();
        return page(MainPage.class);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Клик по кнопке 'Восстановить пароль'")
    public RecoverPage clickRecoverPasswordButton() {
        recoverPasswordButton.click();
        return page(RecoverPage.class);
    }

}
