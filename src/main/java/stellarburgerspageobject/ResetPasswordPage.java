package stellarburgerspageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ResetPasswordPage {
    public static final String RESET_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/reset-password";

    // поле "Пароль"
    @FindBy(how = How.XPATH, using = ".//input[@name ='Введите новый пароль']")
    private SelenideElement passwordField;

    // поле "Введите код из письма"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Введите код из письма')]")
    private SelenideElement newPasswordField;

    // кнопка "Сохранить"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Сохранить')]")
    private SelenideElement saveButton;

    // кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//*[@class='Auth_link__1fOlj']")
    private SelenideElement enterButton;

    // методы
    @Step("Ввести password")
    public ResetPasswordPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Ввести новый password")
    public ResetPasswordPage setNewPassword(String newPassword) {
        newPasswordField.setValue(newPassword);
        return this;
    }

    @Step("Клик по кнопке 'Сохранить'")
    public ResetPasswordPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public LoginPage clickEnterButton() {
        enterButton.click();
        return page(LoginPage.class);
    }
}
