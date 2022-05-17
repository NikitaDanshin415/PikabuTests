package tools.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page object для https://pikabu.ru/story/...
 */
public class StoryPage {
    private final SelenideElement ratingUpBtn = $(".story__left.story__left_no-padding .story__rating-up");

    public StoryPage clickRatingUpBtn(){
        ratingUpBtn
            .click();

        return this;
    }
}
