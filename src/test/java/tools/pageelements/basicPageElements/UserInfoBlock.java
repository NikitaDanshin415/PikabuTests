package tools.pageelements.basicPageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UserInfoBlock {
    private static final SelenideElement userNameTitle = $(".user__info-item .user__nick");

    @Step("Отображаемое имя пользователя должно быть {userName}")
    public UserInfoBlock userNameIs(String userName){
        userNameTitle
            .shouldHave(Condition.text(userName));

        return this;
    }
}
