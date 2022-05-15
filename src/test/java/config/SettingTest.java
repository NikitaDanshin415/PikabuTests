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
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

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

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}