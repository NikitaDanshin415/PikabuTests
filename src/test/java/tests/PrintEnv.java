package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Properties;

public class PrintEnv {
    @Test
    @Tag("env")
    public void test(){
        Properties prop = System.getProperties();
        printProperties(prop);

        System.out.println("------------------------ ENV");

        Map<String, String> env = System.getenv();
        env.forEach((k, v) -> System.out.println(k + ":" + v));

    }

    public static void printProperties(Properties prop) {
        prop.keySet().stream()
            .map(key -> key + ": " + prop.getProperty(key.toString()))
            .forEach(System.out::println);
    }
}
