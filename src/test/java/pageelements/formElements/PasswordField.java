package pageelements.formElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.empty;

public class PasswordField extends InputField {
    public PasswordField(SelenideElement field) {
        super(field);
    }

    private final ElementsCollection rulesList = inputField.closest(".auth__field").$$(".requirements-hint__rule");

    private final SelenideElement moreThat6chars = rulesList.get(0);
    private final SelenideElement minimumOneLetter = rulesList.get(1);
    private final SelenideElement minimumOneDigit = rulesList.get(2);

    public void allRulesClear() {
        rulesList
            .asDynamicIterable()
            .forEach(e -> {
                e.$(".requirements-hint__rule__icon")
                    .shouldBe(empty);
            });
    }

    public void allRulesValid() {
        rulesList
            .asFixedIterable()
            .forEach(e -> {
                e.$("svg")
                    .shouldHave(cssClass("icon--auth__success"));
            });
    }

    public void sixCharsRuleValid() {
        ruleValid(moreThat6chars);
    }

    public void oneLetterRuleValid() {
        ruleValid(minimumOneLetter);
    }

    public void oneDigitRuleValid() {
        ruleValid(minimumOneDigit);
    }

    private void ruleValid(SelenideElement el) {
        el
            .$("svg")
            .shouldHave(cssClass("icon--auth__success"));
    }
}
