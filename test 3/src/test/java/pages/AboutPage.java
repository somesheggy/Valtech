package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {

    @FindBy(css="h1")
    public WebElement about;
    //@FindBy(css="a[href='/about/']")
    //public WebElement aboutLink;
    private WebDriver driver;

    public AboutPage(WebDriver driver) throws Exception
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        load();
    }

    public String check(){
       // aboutLink.click();
       return about.getText();
    }
    private void load(){
        driver.get("http://www.valtech.co.uk/about");
    }
}
