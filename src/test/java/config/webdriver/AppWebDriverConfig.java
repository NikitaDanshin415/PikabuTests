package config.webdriver;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:config/remoteWebDriverConfig.properties"
})
public interface AppWebDriverConfig extends Config {
    @DefaultValue("chrome")
    String browser();
    String appUrl();
    @DefaultValue("false")
    Boolean isRemote();
    String remoteLogin();
    String remotePassword();
    String remoteDriverUrl();
}