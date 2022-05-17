package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tools.pageobjects.BasePage;
import tools.pageobjects.HomePage;

public class HeaderTests extends BasePage {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка шапки сайта")
    @Tag("regress")
    void headerElementsTest() {
        homePage
            .getHeader()
            .checkHeaderElementsSize()
            .headerHaveHotItem()
            .headerHaveBestItem()
            .headerHaveNewItem()
            .headerHaveSubsItem()
            .headerHaveCommunitiesItem()
            .headerHaveCompaniesItem();
    }
}
