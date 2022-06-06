package pageelements.basicPageElements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageelements.formElements.InputField;
import pageelements.formElements.PasswordField;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegisterBlock {
    private final SelenideElement registerForm = $("[data-id='signup']");

    private final SelenideElement emailInput = registerForm.$("input[name='email']");
    private final SelenideElement nickNameInput = registerForm.$("input[name='username']");
    private final SelenideElement passwordInput = registerForm.$("input[name='password']");

    /**
     * Проверка видимости формы.
     */
    @Step("Форма отображается")
    public RegisterBlock formIsVisible() {
        registerForm
            .shouldBe(visible);

        return this;
    }

    /**
     * Заполнение поля Email.
     *
     * @param text - текст который будет введен в поле.
     */
    @Step("Вводим значение {text} в поле Email")
    public RegisterBlock fillEmail(String text) {
        new InputField(emailInput)
            .fill(text);

        return this;
    }

    /**
     * Проверка того, что поле Email заполнено корректно (не подчеркивается красным).
     */
    @Step("Поле Email прошло валидацию")
    public RegisterBlock emailIsValid() {
        new InputField(emailInput)
            .fieldIsValid();

        return this;
    }

    /**
     * Проверка того, что поле Email заполнено некорректно (подчеркивается красным).
     */
    @Step("Поле Email не прошло валидацию")
    public RegisterBlock emailIsNotValid(String text) {
        new InputField(emailInput)
            .fieldIsNotValid(text);

        return this;
    }

    /**
     * Заполнение поля Nickname.
     *
     * @param text - текст, который будет введен в поле Nickname.
     */
    @Step("Вводим значение {text} в поле Nickname")
    public RegisterBlock fillNickName(String text) {
        new InputField(nickNameInput)
            .fill(text);

        return this;
    }

    /**
     * Проверка того, что поле Email заполнено корректно (не подчеркивается красным).
     */
    @Step("Поле Nickname прошло валидацию")
    public RegisterBlock nickNameIsValid() {
        new InputField(nickNameInput)
            .fieldIsValid();

        return this;
    }

    /**
     * Заполнение поля Nickname.
     *
     * @param text - текст, который будет введен в поле Nickname.
     */
    @Step("Поле Nickname не прошло валидацию")
    public RegisterBlock nickNameIsNotValid(String text) {
        new InputField(nickNameInput)
            .fieldIsNotValid(text);

        return this;
    }

    /**
     * Заполнение поля Password.
     *
     * @param text - текст, который будет введен в поле Password.
     */
    @Step("Заполнение поля Password")
    public RegisterBlock fillPassword(String text) {
        new PasswordField(passwordInput)
            .fill(text);

        return this;
    }

    /**
     * Проверка того, что все правила пароля не активны.
     */
    @Step("Все правила заполнения пароля не активны")
    public RegisterBlock checkClearRules() {
        new PasswordField(passwordInput)
            .allRulesClear();

        return this;
    }

    /**
     * Проверка того, что все правила пароля не активны.
     */
    @Step("Правило 'Как минимум 1 буква' прошло валидацию")
    public RegisterBlock oneLetterRuleIsValid() {
        new PasswordField(passwordInput)
            .oneLetterRuleValid();

        return this;
    }

    /**
     * Проверка того, что все правила пароля не активны.
     */
    @Step("Правило 'Как минимум 1 цифра' прошло валидацию")
    public RegisterBlock oneDigitRuleIsValid() {
        new PasswordField(passwordInput)
            .oneDigitRuleValid();

        return this;
    }

    /**
     * Проверка того, что все правила пароля не активны.
     */
    @Step("Правило 'Не менее 6 символов' прошло валидацию")
    public RegisterBlock sixCharsRuleValid() {
        new PasswordField(passwordInput)
            .sixCharsRuleValid();

        return this;
    }

    /**
     * Проверка того, что все правила пароля валидны.
     */
    @Step("Все правила заполнения пароля прошли валидацию")
    public RegisterBlock allRulesIsValid() {
        new PasswordField(passwordInput)
            .allRulesValid();

        return this;
    }
}
