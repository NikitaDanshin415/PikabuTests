package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tools.pageelements.popup.NotificationPopup;
import tools.pageelements.popup.RegisterPopup;
import tools.pageobjects.CommunitiesPage;
import tools.pageobjects.HomePage;
import tools.pageobjects.StoryPage;

import static io.qameta.allure.Allure.step;

public class PikabuTests extends BaseTest {
    HomePage homePage = new HomePage();
    CommunitiesPage communitiesPage = new CommunitiesPage();
    NotificationPopup notificationPopup = new NotificationPopup();
    String communityName = "Лига тестировщиков";


    @Test
    @DisplayName("Проверка шапки сайта")
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

    @Test
    @DisplayName("Проверка поиска сообщества")
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

    @Test
    @DisplayName("Проверка появления окна регистрации")
    void articleTest() {
        step("Открываем пост", () -> {
            homePage
                .openArticle();
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

    @Test
    @DisplayName("Проверка формы регистрации")
    void registerTest() {

        step("Открываем форму регистрации", () -> {
            homePage
                .getAuthBlock()
                .clickRegisterBtn();
        });

        step("Проверка поля Email", () -> {
            homePage
                .getRegisterBlock()
                .formIsVisible()
                .fillEmail("test");

            notificationPopup
                .popupIsVisible("Неверный email");
        });

        step("Проверка поля NickName", () -> {
            homePage
                .getRegisterBlock()
                .formIsVisible()
                .fillNickName("test");

            notificationPopup
                .popupIsVisible("Логин занят");
        });

        step("Проверка поля Password", () -> {
            homePage
                .getRegisterBlock()
                .formIsVisible()
                .fillPassword("test");
        });


    }
}