package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class LoginPage {
    // str.registration
    private SelenideElement signUp = $x("//a[contains(@href,'/registration')]"); //<a href="/registration">Sign up</a>



    //nuzno zavesti WebElement Email
    private SelenideElement emailInputField = $("[name='email']");
    private SelenideElement passwordInputField = $("[placeholder='Password']"); // webelement password
    private SelenideElement loginButton = $("[type='submit']");//knopka Login
    private SelenideElement textError = $x("//div[@class='text-error']"); // dlja error message


    //piwu metodi
    public void enterEmail(String emailValue) {
        //dozdatsja, chto element otobrazaetsja uvelich vremja
        emailInputField.shouldHave(visible, Duration.ofSeconds(10));
        emailInputField.setValue(emailValue);
    }
    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }

    //click on SignUp
    public void clickOnSignUp(){
        signUp.click();
    }


    //click on Login button
    public void clickOnLoginButton() {
        loginButton.click();
    }
    //getter dlja massage error text
    public SelenideElement getErrorMassageText() {
        return textError;
    }





}
