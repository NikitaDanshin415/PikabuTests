package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.SettingTest;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import tools.Attacher;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeEach
    public void setUpAll() {
        new SettingTest().configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
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