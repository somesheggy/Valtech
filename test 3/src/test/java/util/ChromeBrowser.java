package util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeBrowser extends ChromeDriver {
    public static WebDriver buildChromeBrowser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
        ChromeBrowser browser = new ChromeBrowser();
        return browser;
    }

    private ChromeBrowser() {
        super();
    }
}