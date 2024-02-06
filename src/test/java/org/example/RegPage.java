package org.example;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class RegPage{
    public WebDriver driver;
    public RegPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameField;
    @FindBy(css = "#lastName")          //css selector
    private  WebElement lastNameField;
    @FindBy(id = "userEmail")
    private  WebElement emailField;
    @FindBy(xpath = "//*[@id=\"userNumber\"]")
    private  WebElement mobileField;
    @FindBy(css = "#dateOfBirthInput")
    private WebElement birthField;
    @FindBy(css = ".react-datepicker__day--010")
    private  WebElement birthDatePicker;
    @FindBy(css = "#subjectsInput")
    private WebElement subjectField;
    @FindBy(css ="#react-select-2-option-0")
    private WebElement englishSubject;
    @FindBy(xpath = "//*[@id=\"uploadPicture\"]") //TODO
    private WebElement pictureField;
    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    private WebElement addressField;
    @FindBy(xpath = "//button[@type='submit']")  //xpath selector
    private WebElement submitBtn;
    @FindBy(xpath = "//label[@for=\"gender-radio-1\"]")
    private  WebElement radioMaleGender;
    @FindBy(xpath = "//label[@for=\"gender-radio-2\"]")
    private WebElement radioFemaleGender;
    @FindBy(xpath = "//label[@for=\"gender-radio-3\"]")
    private WebElement radioOtherGender;
    @FindBy(css = "#uploadPicture")
    private WebElement imageBtn;
    @FindBy (css = "#react-select-3-option-0")
    private WebElement stateElement;
    @FindBy (css = "#react-select-4-option-0")
    private WebElement cityElement;
    @FindBy (css = "#state")
    private WebElement stateSelect;
    @FindBy (css = "#city")
    private  WebElement citySelect;
    @FindBy (css = "#example-modal-sizes-title-lg")
    private WebElement congratsText;
    @FindBy (xpath = "//tr[1]/td[2]")
    private  WebElement tdName;
    @FindBy (xpath= "//tr[2]/td[2]")
    private  WebElement tdEmail;
    @FindBy (xpath = "//tr[3]/td[2]")
    private  WebElement tdGender;
    @FindBy (xpath = "//tr[4]/td[2]")
    private  WebElement tdNumber;
    @FindBy (xpath = "//tr[5]/td[2]")
    private  WebElement tdBirth;
    @FindBy (xpath = "//tr[6]/td[2]")
    private  WebElement tdSubjects;
    @FindBy (xpath = "//tr[8]/td[2]")
    private  WebElement tdImage;
    @FindBy (xpath = "//tr[9]/td[2]")
    private  WebElement tdAddress;
    @FindBy (xpath = "//tr[10]/td[2]")
    private  WebElement tdStateAndCity;

    public void inputFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }
    public void inputEmail(String email){
        emailField.sendKeys(email);
    }
    public void inputImage(String way){
        try {
            // Задержка на 2 секунды (2000 миллисекунд)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // imageBtn.click();
        imageBtn.sendKeys(way);
    }
    public void inputSubjects(String letter){
        subjectField.sendKeys(letter);
    }
    public void inputAddress(String address){
        addressField.sendKeys(address);
    }
    public void inputMobileNumber(String number){
        mobileField.sendKeys(number);
    }
    public void clickBirthDateField(){
        birthField.click();
    }
    public String chooseDate(){
        birthDatePicker.click();
        String atr = birthField.getAttribute("value");
        return atr;
    }

    public String clickSubject(){
        String subject = englishSubject.getText();
        englishSubject.click();
        return subject;
    }

    public void clickSubmitBtn() {
        submitBtn.click(); }
    public String setState(){
        stateSelect.click();
        String state = stateElement.getText();
        stateElement.click();
        return state;
    }
    public String setCity() {
        citySelect.click();
        String city = cityElement.getText();
        cityElement.click();
        return city;
    }
    public String chooseGender() {
        Random r = new Random();
        int randomGender = r.nextInt(3)+1;
        if(randomGender == 1){
            radioMaleGender.click();
            return radioMaleGender.getText();
        }
        else if (randomGender == 2) {
            radioFemaleGender.click();
            return radioFemaleGender.getText();}
        else {
            radioOtherGender.click();
            return radioOtherGender.getText();
        }
    }
    public void checkCongratsText(){
        Assert.assertEquals("Thanks for submitting the form",congratsText.getText());
    }

    public void assertNames(String expectName) {
        Assert.assertEquals(expectName,tdName.getText());
    }
    public void assertEmail(String exceptEmail) {
        Assert.assertEquals(exceptEmail,tdEmail.getText());
    }
    public void assertGender(String exceptGender){
        Assert.assertEquals(exceptGender,tdGender.getText());
    }
    public void assertMobile(String exceptMobile){
        Assert.assertEquals(exceptMobile,tdNumber.getText());
    }
    public void assertBirth(String exceptBirth){
        SimpleDateFormat formatterOne = new SimpleDateFormat("dd MMMM,yyyy", Locale.US);
        SimpleDateFormat formatterTwo = new SimpleDateFormat("dd MMM yyyy",Locale.US);
        try {
            Date date = formatterOne.parse(tdBirth.getText());
            Date exceptDate = formatterTwo.parse(exceptBirth);
            Assert.assertEquals(date,exceptDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void assertSubjects (String exceptSubjects){
        Assert.assertEquals(exceptSubjects,tdSubjects.getText());
    }
    public void assertPicture(String exceptImage){
        assertTrue(exceptImage.contains(tdImage.getText()));
    }
    public void asserAddress(String exceptAddress){
        Assert.assertEquals(exceptAddress,tdAddress.getText());
    }

    public void assertStateAndCity(String exceptStateAndCity){
        assertTrue(exceptStateAndCity.contains(tdStateAndCity.getText()));
    }
}
