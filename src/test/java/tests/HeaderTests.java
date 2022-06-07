package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.HomePage;

@DisplayName("Тесты шапки сайта")
@Tags(value = {@Tag("header"), @Tag("smoke")})
@Epic("Базовый функционал")
public class HeaderTests extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка шапки сайта")
    @Tag("regress")
    @Feature("Проверка наличия всех элементов боковой панели")
    void headerElementsTest() {
        homePage
            .header()
            .checkHeaderElementsSize()
            .headerHaveHotItem()
            .headerHaveBestItem()
            .headerHaveNewItem()
            .headerHaveSubsItem()
            .headerHaveCommunitiesItem()
            .headerHaveCompaniesItem();
    }
}
