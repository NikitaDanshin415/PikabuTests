package tests;

import com.codeborne.selenide.Selenide;
import config.Configure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tools.AllureAttach;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    @BeforeEach
    public void setUp() {
        open("");
    }

    @BeforeAll
    public static void setUpAll() {
        new Configure().configure();
    }

    @AfterEach
    public void afterEach() {
        AllureAttach.screenshotAs("Last screenshot");
        AllureAttach.pageSource();
        AllureAttach.browserConsoleLogs();
        AllureAttach.addVideo();

        Selenide.closeWebDriver();
    }
}