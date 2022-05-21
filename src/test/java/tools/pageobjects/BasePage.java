package tools.pageobjects;

import tools.pageelements.AuthBlock;
import tools.pageelements.Header;
import tools.pageelements.RegisterBlock;
import tools.pageelements.UserInfoBlock;

public abstract class BasePage {
    public Header getHeader() {
        return new Header();
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