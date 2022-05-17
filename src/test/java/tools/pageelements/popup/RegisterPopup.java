package tools.pageelements.popup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPopup {
    private final SelenideElement popup = $("popup__wrapper");

    public RegisterPopup popupIsVisible(){
        popup
            .shouldBe(Condition.visible);

        return this;
    };
}
