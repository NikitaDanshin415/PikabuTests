package tools.pageelements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import tools.pageelements.popup.NotificationPopup;

public class InputField {

    protected final SelenideElement inputField;

    public InputField(SelenideElement field) {
        inputField = field;
    }

    public InputField fill(String text){
        inputField
            .setValue(text)
            .pressTab();

        return this;
    }

    public InputField fieldIsValid() {
        inputField
            .parent().parent()
            .shouldNotHave(Condition.cssClass("input_error"));

        return this;
    }

    public InputField fieldIsNotValid(String text) {
        inputField
            .parent().parent()
            .shouldHave(Condition.cssClass("input_error"));

        new NotificationPopup()
            .formIsVisible(text);

        return this;
    }
}
