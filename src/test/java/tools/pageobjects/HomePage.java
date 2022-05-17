package tools.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BasePage {
    private final ElementsCollection articleList = $$("article.story");

    @Step("Открытие первого поста")
    public HomePage openArticle(){
        articleList
            .get(0)
            .$(".story__title")
            .click();

        return this;
    };
}