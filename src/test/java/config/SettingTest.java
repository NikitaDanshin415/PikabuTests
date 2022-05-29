package config;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.webdriver.MyWebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SettingTest {
    public void configure(){
        Configuration.browser = MyWebDriverProvider.config.getBrowser();
        Configuration.baseUrl = MyWebDriverProvider.config.getUrl();
        Configuration.browserSize = "1920x1080";

        SelenideLogger.addListener("allure", new AllureSelenide());

        if (MyWebDriverProvider.config.isRemote()) {
           configureSelenoid();
        }
    }

    private void configureSelenoid(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.remote = "https://"
            + MyWebDriverProvider.config.getRemoteLogin()
            + ":" + MyWebDriverProvider.config.getRemotePassword()
            + "@"
            + MyWebDriverProvider.config.getRemoteDriverUrl()
            + "/wd/hub";
    }
}