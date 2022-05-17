package tools.pageelements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegisterBlock {
    private final SelenideElement registerForm = $("[data-id='signup']");

    private final SelenideElement emailInput = registerForm.$("input[name='email']");
    private final SelenideElement nickNameInput = registerForm.$("input[name='username']");
    private final SelenideElement passwordInput = registerForm.$("input[name='password']");

    private final SelenideElement passwordRules = registerForm.$(".requirements-hint");


    public RegisterBlock formIsVisible(){
        registerForm
            .shouldBe(Condition.visible);

        return this;
    }

    public RegisterBlock fillEmail(String text) {
        emailInput
            .setValue(text);

        return this;
    }

    public RegisterBlock fillNickName(String text) {
        nickNameInput
            .setValue(text);

        return this;
    }

    public RegisterBlock fillPassword(String text) {
        passwordInput
            .setValue(text);

        return this;
    }
}
