package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tools.pageobjects.HomePage;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class RegisterFormTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка формы регистрации")
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
                .isVisible()
                .fillEmail("test")
                .emailIsNotValid("Неверный email")
                .fillEmail("test@qaGuru.ru")
                .emailIsValid();
        });

        step("Проверка поля NickName", () -> {
            homePage
                .getRegisterBlock()
                .isVisible()
                .fillNickName("test")
                .nickNameIsNotValid("Логин занят")
                .fillNickName("testwgrbotni")
                .nickNameIsValid();
        });

        step("Проверка поля Password", () -> {
            homePage
                .getRegisterBlock()
                .isVisible()
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
