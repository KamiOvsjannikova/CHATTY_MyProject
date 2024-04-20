package org.example;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
public class LoginPage {
    private SelenideElement signUp = $x("//a[contains(@href,'/registration')]"); //<a href="/registration">Sign up</a>
    private SelenideElement emailInputField = $("[name='email']");
    private SelenideElement passwordInputField = $("[placeholder='Password']"); // webelement password
    private SelenideElement loginButton = $("[type='submit']");//knopka Login
    private SelenideElement textError = $x("//div[@class='text-error']"); // dlja error message


    public void enterEmail(String emailValue) {
        //dozdatsja, chto element otobrazaetsja uvelich vremja
        emailInputField.shouldHave(visible, Duration.ofSeconds(10));
        emailInputField.setValue(emailValue);
    }
    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }
    public void clickOnSignUp(){
        signUp.click();
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }
    public SelenideElement getErrorMassageText() {
        return textError;
    }
}
