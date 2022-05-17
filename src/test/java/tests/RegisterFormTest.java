package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tools.pageobjects.HomePage;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты формы регистрации")
@Tag("register")
@Epic("Аутентификация")
public class RegisterFormTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка валидации формы регистрации")
    @Tag("regress")
    @Feature("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    void registerTest() {
        $(".button_main.button_success")
            .click();

        step("Открываем форму регистрации", () -> {
            homePage
                .getAuthBlock()
                .clickRegisterBtn();
        });

        step("Проверка поля Email", () -> {
            homePage
                .getRegisterBlock()
                .formIsVisible()
                .fillEmail("test")
                .emailIsNotValid("Неверный email")
                .fillEmail("test@qaGuru.ru")
                .emailIsValid();
        });

        step("Проверка поля NickName", () -> {
            homePage
                .getRegisterBlock()
                .formIsVisible()
                .fillNickName("test")
                .nickNameIsNotValid("Логин занят")
                .fillNickName("testwgrbotni")
                .nickNameIsValid();
        });

        step("Проверка поля Password", () -> {
            homePage
                .getRegisterBlock()
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
}
