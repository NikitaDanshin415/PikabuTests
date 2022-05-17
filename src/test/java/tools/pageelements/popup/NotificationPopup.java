package tools.pageelements.popup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NotificationPopup {
    private final SelenideElement popup = $(".popup__wrapper");

    public NotificationPopup popupIsVisible(String text){
        popup
            .shouldBe(Condition.visible)
            .shouldHave(Condition.text(text));

        return this;
    };
}
