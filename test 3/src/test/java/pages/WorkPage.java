package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkPage {

    @FindBy(css="h1")
    public WebElement work;
    private WebDriver driver;

    public WorkPage(WebDriver driver) throws Exception
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.load();
    }

    public String check(){
        return work.getText();
    }
    public void load(){
        driver.get("https://www.valtech.co.uk/work");
    }
}
