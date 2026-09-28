package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Captures a screenshot both as a file on disk (for local debugging) and as a
 * raw byte array (for attaching directly to the Allure report).
 */
public final class ScreenshotUtils {

    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    private ScreenshotUtils() {
        // utility class
    }

    public static byte[] captureAsBytes(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Saves a PNG named {testName}_{timestamp}.png under the configured
     * screenshot directory and returns the file path.
     */
    public static String captureAndSave(WebDriver driver, String testName) {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path dir = Paths.get(ConfigReader.getScreenshotDir());
            Files.createDirectories(dir);

            String fileName = testName + "_" + LocalDateTime.now().format(TIMESTAMP_FORMAT) + ".png";
            Path destination = dir.resolve(fileName);
            Files.copy(source.toPath(), destination);

            return destination.toAbsolutePath().toString();
        } catch (IOException e) {
            System.err.println("Could not save screenshot for test [" + testName + "]: " + e.getMessage());
            return null;
        }
    }
}
