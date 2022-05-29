package tests;

import com.codeborne.selenide.Selenide;
import config.SettingTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tools.Attacher;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    @BeforeEach
    public void setUp() {
        open("");
    }

    @BeforeAll
    public static void setUpAll() {
        new SettingTest().configure();
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