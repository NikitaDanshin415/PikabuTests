package config.authconfig;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:config/userConfig.properties"
})
public interface UserConfig extends Config{
    @Config.Key("login")
    String getLogin();

    @Config.Key("password")
    String getPassword();
}
