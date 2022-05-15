package tools.pageobjects;

import tools.pageelements.Header;

public abstract class BasePage {
    Header header = new Header();

    public Header getHeader() {
        return header;
    }
}