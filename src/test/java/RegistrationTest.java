import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    Faker faker = new Faker();// dlja random email/phone i t.d.

    @Test
    public void successUserRegistration() {
        String userEmail = faker.internet().emailAddress();
        String firstName = faker.name().name();
        String lastName = faker.name().lastName();
        String gender = "male";
        String phone = "+849765455322";
        String password = faker.internet().password();
        String confirmPassword = password;

        loginPage.clickOnSignUp();
        registrationPage.enterEmail(userEmail);
        registrationPage.enterName(firstName);
        registrationPage.enterSurname(lastName);
        registrationPage.enterPhone(phone);
        registrationPage.clickOnBirthday();
        registrationPage.clickOnGender();
        registrationPage.uploadImage();
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);
        registrationPage.clickOnRegistrationButton();
        homeBlogPage.getHeaderUser().shouldBe(visible).shouldHave(text("Hello"));
        homeBlogPage.getLogo().shouldBe(visible);//logo
    }

    @Test
    public void successRegistration() {
        String userEmail = faker.internet().emailAddress();
        String password = faker.internet().password();
        String confirmPassword = password;

        loginPage.clickOnSignUp();
        registrationPage.enterEmail(userEmail);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);
        registrationPage.clickOnRegistrationButton();
        homeBlogPage.getHeaderUser().shouldBe(visible).shouldHave(text("Hello"));
        homeBlogPage.getLogo().shouldBe(visible);//logo
    }
    @Test
    public void registrationWithEmptyEmail(){
        String password = faker.internet().password();
        String confirmPassword = password;

        loginPage.clickOnSignUp();
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);
        registrationPage.getErrorTextEmailEmpty().shouldBe(Condition.visible).shouldHave(text("Email cannot be empty"));
    }
    @Test
    public void registrationWithoutSymbolAtEmail(){ // zavalivaetsja
        String userEmail = faker.internet().safeEmailAddress();
        String password = faker.internet().password();
        String confirmPassword = password;

        loginPage.clickOnSignUp();
        registrationPage.enterEmail(userEmail);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);
        registrationPage.getTextErrorIncorrectEmailFormat().shouldBe(Condition.visible).shouldHave(text("Incorrect email format"));
    }


    @Test
    public void registrationWithPasswordEmpty(){
        String userEmail = faker.internet().emailAddress();
        String password = faker.internet().password();
        String confirmPassword = password;

        loginPage.clickOnSignUp();
        registrationPage.enterEmail(userEmail);
        registrationPage.enterConfirmPassword(confirmPassword);
        registrationPage.getErrorTextPasswordEmpty().shouldBe(Condition.visible).shouldHave(text("Password cannot be empty"));
    }
}