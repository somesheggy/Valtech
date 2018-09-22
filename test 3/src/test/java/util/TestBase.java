package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties Config;
    public static FileInputStream cf;
    public static boolean Initialize;

    public static WebDriver getChromeDriver() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/com/flyvictor/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public TestBase() throws IOException {
        if(!Initialize)
        {
            Config = new Properties();
            cf = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/flyvictor/utils/Config.properties" );
            Config.load(cf);

        }
    }

    public void Initialized() throws IOException {


    }

    public void navigate(String url)
    {
        driver.get(Config.getProperty(url));
    }

    public void openBrowser(String browser) {

        if (Config.getProperty(browser).equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } else if (Config.getProperty(browser).equals("ie")) {
            System.setProperty("webdriver.ie.driver", "path");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } else if (Config.getProperty(browser).equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/com/flyvictor/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }



    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement elementWait = wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void autoLookUpSelecion(WebElement locator, List<WebElement> elementList, String getText, String getAirportName) {
        locator.sendKeys(getText);
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(getAirportName)) {
                element.click();
                break;
            }
        }
    }

    public void autoLookUpSelecion(List<WebElement> elementList, String getAirportName) {
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(getAirportName)) {
                element.click();
                break;
            }
        }
    }

    public void setCount(WebElement individual, String individualCount) {
        Actions actionList = new Actions(driver);
        actionList.doubleClick(individual).sendKeys(individualCount).
                release().build().perform();
    }

    public void jseClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", element);
    }

    public void jseScrollview(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void assertEquals(WebElement element, String expected) throws InterruptedException {
        String Actual = element.getText();
        if (Actual.equals(Config.getProperty(expected))) {
            System.out.println("The Expected and Actual Results are Matched " + Config.getProperty(expected) + "=" + Actual);
        } else {
            System.err.println("The Expected and Actual Results are not Matched ");
        }


    }
}
