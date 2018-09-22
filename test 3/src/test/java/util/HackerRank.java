package util;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;


public class HackerRank {

    private SharedDriver driver;

    @Before
    public void setUp() {
         driver = new SharedDriver();
    }

    @Test
    public void recentBlog() throws Exception {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.recentBlog.isDisplayed());
    }

    @Test
    public void about() throws Exception {

        AboutPage about = new AboutPage(driver);
        Assert.assertEquals("About",about.check());

    }
    @Test
    public void services() throws Exception {
        ServicesPage services = new ServicesPage(driver);
        Assert.assertEquals("Services",services.check());
    }

    @Test
    public void work() throws Exception {
        WorkPage work = new WorkPage(driver);
        Assert.assertEquals("Work",work.check());
    }

    @Test
    public void contact() throws Exception {
        int expected = 37;
        ContactPage contact = new ContactPage(driver);
        System.out.println(contact.offices.size());
        Assert.assertEquals(expected, contact.offices.size());
    }
}
