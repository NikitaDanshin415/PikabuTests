package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tools.pageelements.popup.RegisterPopup;
import tools.pageobjects.HomePage;
import tools.pageobjects.StoryPage;

import static io.qameta.allure.Allure.step;

public class StoryTests extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка появления окна регистрации")
    @Tag("regress")
    void articleTest() {
        step("Открываем пост", () -> {
            homePage
                .openStory();

            Selenide.switchTo().window(1);
        });

        step("Нажимаем на кнопку повышения рейтинга", () -> {
            new StoryPage()
                .clickRatingUpBtn();
        });

        step("Проверяем, что появилось окно регистрации", () -> {
            new RegisterPopup()
                .popupIsVisible();
        });
    }
}
