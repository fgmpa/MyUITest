package org.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    public static RegPage regPage;
    public static WebDriver myDriver;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        myDriver = new ChromeDriver();
        myDriver.manage().window().fullscreen();
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.get(ConfProperties.getProperty("loginpage"));
        regPage = new RegPage(myDriver);
    }
    @Test
    public void registrationTest() {
        regPage.inputFirstName("Zhenya");
        regPage.clickSubmitBtn();
    }
}
