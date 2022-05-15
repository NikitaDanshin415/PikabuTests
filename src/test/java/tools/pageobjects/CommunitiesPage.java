package tools.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CommunitiesPage extends BasePage {

    private final SelenideElement inputSearch = $(".communities-feed [name='q']");
    private final ElementsCollection communitiesList = $$(".communities-feed__container");

    @Step("Ищем сообщество {text}")
    public CommunitiesPage search(String text){
        inputSearch
            .setValue(text)
            .pressEnter();

        communitiesList
            .findBy(Condition.text(text))
            .shouldBe(Condition.visible.because("Найденное сообщество должно отображаться на странице"));

        return this;
    };

}