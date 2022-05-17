package tools.pageelements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class PasswordField extends InputField {
    public PasswordField(SelenideElement field) {
        super(field);
    }

    private final ElementsCollection rulesList = inputField.closest(".auth__field").$$(".requirements-hint__rule");

    private final SelenideElement moreThat6chars = rulesList.get(0);
    private final SelenideElement minimumOneLetter = rulesList.get(1);
    private final SelenideElement minimumOneDigit = rulesList.get(2);

    public PasswordField allRulesClear() {
        rulesList
            .asDynamicIterable()
            .forEach(e -> {
                e.$(".requirements-hint__rule__icon")
                    .shouldBe(Condition.empty);
            });

        return this;
    }

    public PasswordField allRulesValid() {
        rulesList
            .asFixedIterable()
            .forEach(e -> {
                e.$("svg")
                    .shouldHave(Condition.cssClass("icon--auth__success"));
            });

        return this;
    }

    public PasswordField sixCharsRuleValid() {
        ruleValid(moreThat6chars);

        return this;
    }

    public PasswordField oneLetterRuleValid() {
        ruleValid(minimumOneLetter);

        return this;
    }

    public PasswordField oneDigitRuleValid() {
        ruleValid(minimumOneDigit);

        return this;
    }

    private void ruleValid(SelenideElement el) {
        el
            .$("svg")
            .shouldHave(Condition.cssClass("icon--auth__success"));
    }


}
