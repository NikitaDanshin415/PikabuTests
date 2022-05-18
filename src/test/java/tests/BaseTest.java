package tests;

import com.codeborne.selenide.Selenide;
import config.SettingTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import tools.Attacher;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeEach
    public void setUpAll() {
        new SettingTest().configure();
        open("");
    }


    @AfterEach
    public void afterEach() {
        Attacher.screenshotAs("Last screenshot");
        Attacher.pageSource();
        Attacher.browserConsoleLogs();
        Attacher.addVideo();

        Selenide.closeWebDriver();
    }
}