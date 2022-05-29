package tools.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page object для https://pikabu.ru/story/...
 */
public class StoryPage {
    private final SelenideElement ratingUpBtn = $(".story__left.story__left_no-padding .story__rating-up");

    @Step("Нажать на кнопку повышения рейтинга")
    public StoryPage clickRatingUpBtn(){
        ratingUpBtn
            .click();

        return this;
    }
}
