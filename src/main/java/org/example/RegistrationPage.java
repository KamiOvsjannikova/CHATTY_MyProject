package org.example;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
public class RegistrationPage {
    private SelenideElement emailInputField = $("[placeholder='Email']");
    private SelenideElement nameInputField = $("[placeholder='Name']"); // net v TZ
    private SelenideElement surnameInputField = $("[placeholder='Surname']");// net v TZ
    private SelenideElement phoneInputField = $("[name='phone']");// net v TZ
    private SelenideElement birthday = $("label[for='birthday']");// net v TZ
    private SelenideElement gender = $("label[for='gender']");// net v TZ
    private SelenideElement pictureUploadField = $x("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[4]/input");// net v TZ
    String filePath = "C:\\Users\\kamil\\Downloads\\1710166875272.jpg"; // путь к картинке
    private SelenideElement passwordInputField = $("[placeholder='Password']");
    private SelenideElement confirmPassword =  $("[placeholder='Confirm password']");
    private SelenideElement registrationButton = $("[type='submit']"); //submit knopka registration
    private SelenideElement textErrorEmailEmpty = $("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(4)");
    private SelenideElement textErrorPasswordEmpty = $("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(5)");
    private  SelenideElement textErrorIncorrectEmailFormat = $("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(4)");

    //piwu metodi
    public SelenideElement getTextErrorIncorrectEmailFormat(){
        return textErrorIncorrectEmailFormat;
    }
    public SelenideElement getErrorTextPasswordEmpty() {
        return textErrorPasswordEmpty;
    }

    public SelenideElement getErrorTextEmailEmpty() {
        return textErrorEmailEmpty;
    }
    public void clickOnRegistrationButton() {
        registrationButton.click();
    }
    public void uploadImage(){
        pictureUploadField.uploadFile(new File(filePath));
    }
    public  void clickOnGender(){
        gender.click();
    }
    public  void clickOnBirthday(){
        birthday.click();
    }

    public void enterPhone(String phoneValue) {
        phoneInputField.shouldHave(visible, Duration.ofSeconds(10));
        phoneInputField.setValue(phoneValue);
    }
    public void enterSurname(String surnameValue) {
        surnameInputField.shouldHave(visible, Duration.ofSeconds(10));
        surnameInputField.setValue(surnameValue);
    }
    public void enterName(String nameValue) {
        nameInputField.shouldHave(visible, Duration.ofSeconds(10));
        nameInputField.setValue(nameValue);
    }


    public void enterEmail(String emailValue) {
        //dozdatsja, chto element otobrazaetsja uvelich vremja
        emailInputField.shouldHave(visible, Duration.ofSeconds(10));
        emailInputField.setValue(emailValue);
    }
    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }
    public void enterConfirmPassword(String confirmPasswordValue) {
        confirmPassword.setValue(confirmPasswordValue);
    }

}
