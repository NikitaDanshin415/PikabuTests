package tools.pageelements.popup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPopup {
    private final SelenideElement popup = $(".popup__wrapper");

    @Step("Модальное окно регистрации отображается")
    public RegisterPopup popupIsVisible(){
        popup
            .shouldBe(Condition.visible);

        return this;
    };
}
