package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ContactPage {
    @FindAll(@FindBy(how = How.CSS, using = "article"))
    public List<WebElement> offices;

    private WebDriver driver;

    public ContactPage(WebDriver driver) throws Exception
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.load();
    }


    private void load(){
        driver.get("https://www.valtech.co.uk/about/contact-us");
    }
}
