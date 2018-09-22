package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    @FindBy(css=".bloglisting.bloglisting--purple-border")
    public WebElement recentBlog;
    private WebDriver driver;

    public HomePage(WebDriver driver) throws Exception
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.load();
    }

    private void load(){
        driver.get("http://www.valtech.co.uk/");
    }


}
