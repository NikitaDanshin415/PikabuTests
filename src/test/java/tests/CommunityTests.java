package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tools.pageobjects.CommunitiesPage;
import tools.pageobjects.HomePage;

import static io.qameta.allure.Allure.step;

@DisplayName("Тесты вкладки 'Communities'")
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
