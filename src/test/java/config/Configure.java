package config;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.webdriver.AppWebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class Configure {
    public void configure() {
        Configuration.browser = AppWebDriverProvider.config.browser();
        Configuration.baseUrl = AppWebDriverProvider.config.appUrl();
        Configuration.browserSize = "1920x1080";

        SelenideLogger.addListener("allure", new AllureSelenide());

        if (AppWebDriverProvider.config.isRemote()) {
            configureSelenoid();
        }
    }

    private void configureSelenoid() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.remote = format("https://%s:%s@%s/wd/hub",
                AppWebDriverProvider.config.remoteLogin(),
                AppWebDriverProvider.config.remotePassword(),
                AppWebDriverProvider.config.remoteDriverUrl()
        );
    }
}