package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page object для https://pikabu.ru/
 */
public class HomePage extends BasePage {
    private final SelenideElement firstArticle = $("article.story .story__title");

    @Step("Открытие первого поста")
    public HomePage openFirstArticle() {
        firstArticle.click();

        return this;
    }
}