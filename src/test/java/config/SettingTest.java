package config;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.webdriver.WebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SettingTest {
    public void configure(){
        Configuration.browser = WebDriverProvider.config.getBrowser();
        Configuration.baseUrl = "https://pikabu.ru/";
        Configuration.browserSize = "1920x1080";

        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (WebDriverProvider.config.isRemote()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.remote = "https://"
                + WebDriverProvider.config.getRemoteLogin()
                + ":" + WebDriverProvider.config.getRemotePassword()
                + "@"
                + WebDriverProvider.config.getRemoteDriverUrl()
                + "/wd/hub";
        }

        Configuration.browserCapabilities = capabilities;
    }
}