package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {

    @FindBy(css="h1")
    public WebElement services;
    private WebDriver driver;

    public ServicesPage(WebDriver driver) throws Exception
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.load();
    }

    public String check(){
        return services.getText();
    }

    public void load(){
        driver.get("http://www.valtech.co.uk/services/");
    }
}
