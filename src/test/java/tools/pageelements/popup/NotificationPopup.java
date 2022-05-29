package tools.pageelements.popup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class NotificationPopup {
    private final SelenideElement popup = $(".popup__wrapper");

    @Step("Модальное окно c текстом {text} отображается")
    public void formIsVisible(String text){
        popup
            .shouldBe(Condition.visible)
            .shouldHave(Condition.text(text));
    }
}
