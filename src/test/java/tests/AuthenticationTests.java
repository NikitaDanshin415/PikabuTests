package tests;

import config.authconfig.UserConfigProvider;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты формы аутентификации")
@Tag("auth")
@Epic("Аутентификация")
public class AuthenticationTests extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка валидации формы регистрации")
    @Tag("regress")
    @Feature("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    void registerTest() {

        step("Открываем форму регистрации", () -> {
            homePage
                .authBlock()
                .clickRegisterBtn();
        });

        step("Проверка поля Email", () -> {
            homePage
                .registerBlock()
                .formIsVisible()
                .fillEmail("test")
                .emailIsNotValid("Неверный email")
                .fillEmail("test@qaGuru.ru")
                .emailIsValid();
        });

        step("Проверка поля NickName", () -> {
            homePage
                .registerBlock()
                .formIsVisible()
                .fillNickName("test")
                .nickNameIsNotValid("Логин занят")
                .fillNickName("testwgrbotni123")
                .nickNameIsValid();
        });

        step("Проверка поля Password", () -> {
            homePage
                .registerBlock()
                .formIsVisible()
                .checkClearRules()
                .fillPassword("test")
                .oneLetterRuleIsValid()
                .fillPassword("test2")
                .oneDigitRuleIsValid()
                .fillPassword("test12")
                .sixCharsRuleValid()
                .allRulesIsValid();
        });
    }

    @Test
    @DisplayName("Проверка авторизации в системе")
    @Tag("regress")
    @Feature("Авторизация")
    @Severity(SeverityLevel.BLOCKER)
    void authTest() {
        step("Авторизация с несуществующей учетной записью", () -> {
            homePage
                .authBlock()
                .fillLogin("dfthertherth")
                .fillPassword("erthertyherth")
                .clickSignIn()
                .checkErrorText("Ошибка. Вы ввели неверные данные авторизации");
        });

        step("Авторизация с существующей учетной записью", () -> {
            refresh();
            homePage
                .authBlock()
                .fillLogin(UserConfigProvider.userConfig.login())
                .fillPassword(UserConfigProvider.userConfig.password())
                .clickSignIn();

            homePage
                .userInfoBlock()
                .userNameIs(UserConfigProvider.userConfig.login());
        });
    }
}