package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegPage{
    public WebDriver driver;
    public RegPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameField;
    @FindBy(xpath = "//*[@id=\"userName-wrapper\"]/div[4]")
    private  WebElement lastNameField;
    @FindBy(xpath = "//*[@id=\"userEmail-wrapper\"]/div[2]")
    private  WebElement emailField;
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]")
    private  WebElement genderButtons;
    @FindBy(xpath = "//*[@id=\"userNumber\"]")
    private  WebElement mobileField;
    @FindBy(xpath = "//*[@id=\"dateOfBirthInput\"]")
    private  WebElement birthField;
    @FindBy(xpath = "//*[@id=\"subjectsContainer\"]")
    private WebElement subjectField;
    @FindBy(xpath = "//*[@id=\"uploadPicture\"]")
    private WebElement pictureField;
    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    private WebElement addressField;
    @FindBy(xpath = "//*[@id=\"stateCity-wrapper\"]")
    private  WebElement cityField;
    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submitBtn;

    public void inputFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }
    public void clickSubmitBtn() {
        submitBtn.click(); }
}
