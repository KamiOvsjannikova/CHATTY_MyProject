import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
public class LoginTest extends BaseTest {
//dlja registracii
    @Test
    public void successRegistration(){
        loginPage.clickOnSignUp();
    }


    @Test
    public void successAdminLogin() {
        loginPage.enterEmail("testQA311023@gmail.com");
        loginPage.enterPassword("Milla2103");
        loginPage.clickOnLoginButton();
        //proverka chto zaloginilisj
        usersPage.getHeaderUser().shouldBe(visible).shouldHave(text("Hello,Kamilla!")); // proxodit
        usersPage.getLogo().shouldBe(visible);// proxodit
    }

    @Test
    public void successUserLogin() {
        loginPage.enterEmail("testQA@gmail.com");
        loginPage.enterPassword("Test123456");
        loginPage.clickOnLoginButton();
        //proverka chto zaloginilisj
        usersPage.getHeaderUser().shouldBe(visible).shouldHave(text("Hello,test!"));
        usersPage.getLogo().shouldBe(visible);// proxodit
    }
    @Test
    public void emailWithSpace(){
        loginPage.enterEmail("testQA311023 @gmail.com");
        loginPage.enterPassword("Milla2103");
        //loginPage.clickOnLoginButton(); //zavalivaetsja na etom momente
        //Invalid  text s owibkoj
        loginPage.getErrorMassageText().shouldBe(Condition.visible).shouldHave(text("You have entered incorrect username or password. Please try again.")); //owibka na sajte  Incorrect email
    }
    @Test
    public void invalidPassword() {
        loginPage.enterEmail("testQA311023@gmail.com");
        loginPage.enterPassword("Milla");
        //loginPage.clickOnLoginButton(); //zavalivaetsja na etom momente
        //Invalid  text s owibkoj
        loginPage.getErrorMassageText().shouldBe(Condition.visible).shouldHave(text("You have entered incorrect username or password. Please try again.")); //owibka ns sajte Password must be 8-100 characters and include at least one letter and one digit
    }


    @Test
    public void notRegisteredUsername() {
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("Milla2103");
        //loginPage.clickOnLoginButton(); //zavalivaetsja na etom momente
        //Invalid  text s owibkoj
        loginPage.getErrorMassageText().shouldBe(Condition.visible).shouldHave(text("You have entered incorrect username or password. Please try again.")); //owibka na sajte ne imeetsja
    }

}
