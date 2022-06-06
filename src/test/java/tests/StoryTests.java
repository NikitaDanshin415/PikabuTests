package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageelements.popup.NotificationPopup;
import pages.HomePage;
import pages.StoryPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Тесты для историй")
@Tag("story")
@Epic("Истории")
public class StoryTests extends BaseTest {
    HomePage homePage = new HomePage();
    StoryPage storyPage = new StoryPage();
    NotificationPopup notificationPopup = new NotificationPopup();

    @Test
    @DisplayName("Повысить рейтинг без авторизации")
    @Tag("regress")
    @Feature("Повышение рейтинга истории")
    void articleTest() {
        step("Открываем пост", () -> {
            homePage
                .openFirstArticle();

            Selenide.switchTo().window(1);
        });

        step("Нажимаем на кнопку повышения рейтинга", () -> {
            storyPage
                .clickRatingUpBtn();
        });

        step("Проверяем, что появилось окно регистрации", () -> {
            notificationPopup
                .formIsVisible("Регистрация");
        });
    }
}