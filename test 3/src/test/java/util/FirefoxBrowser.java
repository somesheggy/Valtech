package util;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


class FirefoxBrowser extends FirefoxDriver {

    public static FirefoxBrowser buildFirefoxBrowser() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        FirefoxBrowser browser = new FirefoxBrowser(profile);
        return browser;
    }

    private FirefoxBrowser(FirefoxProfile desiredProfile) {
        super(desiredProfile);
    }
}