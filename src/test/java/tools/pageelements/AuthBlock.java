package tools.pageelements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AuthBlock {
    private final SelenideElement registerBtn = $("#signin-form .auth__action");
    private final SelenideElement signinBtn = $("#signin-form button[type='submit']");

    private final SelenideElement errorSpan = $("#signin-form span.auth__error");

    private final SelenideElement loginInput = $("#signin-form input[placeholder='Логин']");
    private final SelenideElement passwordInput = $("#signin-form input[placeholder='Пароль']");

    @Step("Нажать на кнопку 'Регистрация' в блоке авторизации")
    public void clickRegisterBtn(){
        registerBtn
            .click();
    }

    @Step("Нажать на кнопку 'Войти' в блоке авторизации")
    public AuthBlock clickSignIn(){
        signinBtn
            .click();

        return this;
    }

    @Step("Ввести значение {login} в поле 'Логин'")
    public AuthBlock fillLogin(String login){
        loginInput
            .setValue(login);

        return this;
    }

    @Step("Ввести пароль в поле 'Пароль'")
    public AuthBlock fillPassword(String pass){
        passwordInput
            .setValue(pass);

        return this;
    }

    @Step("В блоке авторизации должна отображаться ошибка с текстом {errorText}")
    public AuthBlock checkErrorText(String errorText){
        errorSpan
            .shouldHave(Condition.text(errorText));

        return this;
    }
}
