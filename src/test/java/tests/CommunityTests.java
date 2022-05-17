package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tools.pageobjects.BasePage;
import tools.pageobjects.CommunitiesPage;
import tools.pageobjects.HomePage;

import static io.qameta.allure.Allure.step;

public class CommunityTests extends BasePage {
    HomePage homePage = new HomePage();
    CommunitiesPage communitiesPage = new CommunitiesPage();
    String communityName = "Лига тестировщиков";


    @Test
    @DisplayName("Проверка поиска сообщества")
    @Tag("regress")
    void searchTest() {
        step("Переходим на страницу 'Сообщества'", () -> {
            homePage
                .getHeader()
                .openCommunities();
        });

        step("Проверяем работу поиска сообщества", () -> {
            communitiesPage
                .search(communityName);
        });
    }
}
