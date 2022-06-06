package pages;

import pageelements.basicPageElements.AuthBlock;
import pageelements.basicPageElements.HeaderBlock;
import pageelements.basicPageElements.RegisterBlock;
import pageelements.basicPageElements.UserInfoBlock;

public abstract class BasePage {
    public HeaderBlock header() {
        return new HeaderBlock();
    }

    public RegisterBlock registerBlock() {
        return new RegisterBlock();
    }

    public AuthBlock authBlock() {
        return new AuthBlock();
    }

    public UserInfoBlock userInfoBlock() {
        return new UserInfoBlock();
    }
}