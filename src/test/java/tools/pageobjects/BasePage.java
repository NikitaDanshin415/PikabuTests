package tools.pageobjects;

import tools.pageelements.basicPageElements.AuthBlock;
import tools.pageelements.basicPageElements.HeaderBlock;
import tools.pageelements.basicPageElements.RegisterBlock;
import tools.pageelements.basicPageElements.UserInfoBlock;

public abstract class BasePage {
    public HeaderBlock getHeader() {
        return new HeaderBlock();
    }

    public RegisterBlock getRegisterBlock() {
        return new RegisterBlock();
    }

    public AuthBlock getAuthBlock() {
        return new AuthBlock();
    }

    public UserInfoBlock getUserInfoBlock() {
        return new UserInfoBlock();
    }
}