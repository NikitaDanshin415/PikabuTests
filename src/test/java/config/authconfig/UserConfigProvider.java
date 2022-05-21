package config.authconfig;

import org.aeonbits.owner.ConfigFactory;

public class UserConfigProvider {
    public static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());
}
