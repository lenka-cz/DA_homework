package cz.czechitas;

import java.net.*;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverHelper {

    private static String downloadsPath = "";
    private static String baseUrl = "http://czechitas-shopizer.azurewebsites.net/admin/logon.html";

    public DriverHelper() {
    }

    public static WebDriver openFirefox() {
        setDriver("gecko");
        FirefoxOptions options = (new FirefoxOptions()).addArguments("-private").addPreference("browser.download.dir", getPath(downloadsPath)).addPreference("browser.download.folderList", 2);
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
    public static void setDriver(String driver) {
        String os = System.getProperty("os.name").toLowerCase();
        String driverPath = "";
        if (os.contains("win")) {
            driverPath = "drivers/" + driver + "driver.exe";
        } else {
            driverPath = "drivers/" + driver + "driver";
        }

        System.setProperty("webdriver." + driver + ".driver", getPath(driverPath));
    }
    private static String getPath(String path) {
        try {
            return ((URL)Objects.requireNonNull(DriverHelper.class.getClassLoader().getResource(path))).toURI().getPath();
        } catch (URISyntaxException var2) {
            var2.printStackTrace();
            throw new RuntimeException("Path " + path + " is invalid.");
        }
    }
}
