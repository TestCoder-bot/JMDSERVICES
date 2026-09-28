package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads src/test/resources/config.properties once and exposes typed getters.
 * Kept as a simple static utility so every layer (base, pages, tests) can read
 * config without passing objects around.
 */
public final class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream =
                     ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("config.properties not found on classpath (src/test/resources)");
            }
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private ConfigReader() {
        // utility class
    }

    public static String get(String key) {
        String value = System.getProperty(key, PROPERTIES.getProperty(key));
        if (value == null) {
            throw new RuntimeException("Missing config key: " + key);
        }
        return value.trim();
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getTrainingUrl() {
        return get("training.url");
    }

    public static String getBlogUrl() {
        return get("blog.url");
    }

    public static String getAboutUrl() {
        return get("about.url");
    }

    public static String getContactUrl() {
        return get("contact.url");
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static int getImplicitWait() {
        return Integer.parseInt(get("implicit.wait.seconds"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(get("explicit.wait.seconds"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(get("page.load.timeout.seconds"));
    }

    public static String getScreenshotDir() {
        return get("screenshot.dir");
    }
}
