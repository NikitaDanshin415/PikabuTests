package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CommunitiesPage;
import pages.HomePage;

import static io.qameta.allure.Allure.step;

@DisplayName("Тесты вкладки 'Сообщества'")
@Tag("communities")
@Epic("Сообщества")
public class CommunityTests extends BaseTest {
    HomePage homePage = new HomePage();
    CommunitiesPage communitiesPage = new CommunitiesPage();
    String communityName = "Лига тестировщиков";

    @Test
    @DisplayName("Проверка поиска сообщества")
    @Tag("regress")
    @Feature("Поиск сообщества")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("123")
    void searchTest() {
        step("Переходим на страницу 'Сообщества'", () -> {
            homePage
                .header()
                .openCommunities();
        });

        step("Проверяем работу поиска сообщества", () -> {
            communitiesPage
                .search(communityName);
        });
    }
}