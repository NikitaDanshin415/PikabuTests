package config.webdriver;

import org.aeonbits.owner.ConfigFactory;

public class AppWebDriverProvider {
    public static AppWebDriverConfig config = ConfigFactory.create(AppWebDriverConfig.class, System.getProperties());
}
