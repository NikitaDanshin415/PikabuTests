package config.authconfig;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:config/userConfig.properties"
})
public interface UserConfig extends Config {
    String login();

    String password();
}