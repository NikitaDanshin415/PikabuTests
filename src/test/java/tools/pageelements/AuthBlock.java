package tools.pageelements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AuthBlock {
    private final SelenideElement registerBtn = $("#signin-form .auth__action");

    @Step("Нажать на кнпоку 'Регистрация'")
    public void clickRegisterBtn(){
        registerBtn
            .click();
    }
}
