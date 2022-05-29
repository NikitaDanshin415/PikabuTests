package config.webdriver;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:config/remoteWebDriverConfig.properties"
})
public interface MyWebDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("appUrl")
    String getUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteLogin")
    String getRemoteLogin();

    @Key("remotePassword")
    String getRemotePassword();

    @Key("remoteDriverUrl")
    String getRemoteDriverUrl();
}