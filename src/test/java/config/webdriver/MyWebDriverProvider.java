package config.webdriver;

import org.aeonbits.owner.ConfigFactory;

public class MyWebDriverProvider {
    public static MyWebDriverConfig config = ConfigFactory.create(MyWebDriverConfig.class, System.getProperties());
}
