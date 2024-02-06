package org.example;

import org.junit.Assert;
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
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.get(ConfProperties.getProperty("regpage"));
        regPage = new RegPage(myDriver);
    }
    @Test
    public void registrationTest() {
        String name = "Zhenya";
        String lastName = "Scherbakov";
        String email = "myTestEmail@gmail.com";
        String number = "8800353535";
        String imageWay = "C:\\Users\\Eugene\\IdeaProjects\\MyUITest\\src\\test\\resources\\earth.jpg";
        String address = "Pushkina №4";
        regPage.inputFirstName(name);
        regPage.inputLastName(lastName);
        regPage.inputEmail(email);
        String gender = regPage.chooseGender();
        regPage.inputMobileNumber(number);
        regPage.clickBirthDateField();
        String birthText = regPage.chooseDate();
        regPage.inputSubjects("E");
        String subject = regPage.clickSubject();
        regPage.inputImage(imageWay);
        regPage.inputAddress(address);
        String state = regPage.setState();
        String city = regPage.setCity();
        regPage.clickSubmitBtn();
        try {
            // Задержка на 2 секунды (2000 миллисекунд)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        regPage.checkCongratsText();
        regPage.assertNames(name + " " + lastName);
        regPage.assertEmail(email);
        regPage.assertGender(gender);
        regPage.assertMobile(number);
        regPage.assertBirth(birthText);
        regPage.assertSubjects(subject);
        regPage.assertPicture(imageWay);
        regPage.asserAddress(address);
        regPage.assertStateAndCity(state + " " + city);
    }
}
