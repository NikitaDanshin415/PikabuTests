package tools.pageobjects;

import tools.pageelements.AuthBlock;
import tools.pageelements.Header;
import tools.pageelements.RegisterBlock;

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
}