package util;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

class BrowserFactory {

    public static WebDriver getBrowser(String url) throws Throwable {
        Properties Config = new Properties();

        Config.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/util/Config.properties" ));
        String desiredBrowserName =  Config.getProperty(url).toString();

        WebDriver desiredBrowser = null;

        if (desiredBrowserName.equals("chrome")) {
            desiredBrowser = ChromeBrowser.buildChromeBrowser();

        } else if (desiredBrowserName.equals("firefox")) {
            desiredBrowser = FirefoxBrowser.buildFirefoxBrowser();

        } else if (desiredBrowserName.equals("ie")) {
            desiredBrowser = ChromeBrowser.buildChromeBrowser();

        } else {//work out what to do when a browser isn't needed

        }
        return desiredBrowser;
    }
}