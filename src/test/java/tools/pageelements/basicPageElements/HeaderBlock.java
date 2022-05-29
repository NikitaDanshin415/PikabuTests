package tools.pageelements.basicPageElements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderBlock {
    private final ElementsCollection headerMenuItems = $$(".header-menu .header-menu__item");
    private final SelenideElement hotItem = $("[data-feed-key='hot']");
    private final SelenideElement bestItem = $("[data-feed-key='best']");
    private final SelenideElement newItem = $("[data-feed-key='new']");
    private final SelenideElement subsItem = $("#menu-subs");
    private final SelenideElement communitiesItem = $("[data-feed-key='communities']");
    private final SelenideElement companiesItem = $("[data-feed-key='companies']");

    @Step("Проверка количества кнопок в заголовке")
    public HeaderBlock checkHeaderElementsSize() {
        headerMenuItems
            .shouldHave(CollectionCondition.size(6));

        return this;
    }

    @Step("Проверка отображения элемента 'Горячее'")
    public HeaderBlock headerHaveHotItem() {
        elementShouldBeOnPage(hotItem, "Горячее");

        return this;
    }

    @Step("Проверка отображения элемента 'Лучшее'")
    public HeaderBlock headerHaveBestItem() {
        elementShouldBeOnPage(bestItem, "Лучшее");

        return this;
    }

    @Step("Проверка отображения элемента 'Свежее'")
    public HeaderBlock headerHaveNewItem() {
        elementShouldBeOnPage(newItem, "Свежее");

        return this;
    }

    @Step("Проверка отображения элемента 'Подписки'")
    public HeaderBlock headerHaveSubsItem() {
        elementShouldBeOnPage(subsItem, "Подписки");

        return this;
    }

    @Step("Проверка отображения элемента 'Сообщества'")
    public HeaderBlock headerHaveCommunitiesItem() {
        elementShouldBeOnPage(communitiesItem, "Сообщества");

        return this;
    }

    @Step("Проверка отображения элемента 'Компании'")
    public HeaderBlock headerHaveCompaniesItem() {
        elementShouldBeOnPage(companiesItem, "Компании");

        return this;
    }

    @Step("Открытие вкладки 'Сообщества'")
    public void openCommunities() {
        communitiesItem
            .click();

        communitiesItem
            .shouldHave(Condition.cssClass("header-menu__item_current")
                .because("Выбранная вкладка должна иметь CSS класс header-menu__item_current"));
    }


    private void elementShouldBeOnPage(SelenideElement el, String name) {
        el
            .shouldBe(Condition.visible
                .because("Элемент '" + name + "' должен отображаться на странице"));
    }
}