import com.codeborne.selenide.Condition;
import org.junit.Test;
import static com.codeborne.selenide.Condition.*;

public class LoginTest extends BaseTest {

    @Test
    public void successRegistration(){
        loginPage.clickOnSignUp();
    }

    @Test
    public void successAdminLogin() {
        loginPage.enterEmail("testQA311023@gmail.com");
        loginPage.enterPassword("Milla2103");
        loginPage.clickOnLoginButton();

        usersPage.getHeaderUser().shouldBe(visible).shouldHave(text("Hello,Kamilla!"));
        usersPage.getLogo().shouldBe(visible);
    }

    @Test
    public void successUserLogin() {
        loginPage.enterEmail("testQA@gmail.com");
        loginPage.enterPassword("Test123456");
        loginPage.clickOnLoginButton();

        usersPage.getHeaderUser().shouldBe(visible).shouldHave(text("Hello,test!"));
        usersPage.getLogo().shouldBe(visible);
    }
    @Test
    public void emailWithSpace(){
        loginPage.enterEmail("testQA311023 @gmail.com");
        loginPage.enterPassword("Milla2103");

        loginPage.getErrorMassageText().shouldBe(Condition.visible).shouldHave(text("You have entered incorrect username or password. Please try again.")); 
    }
    @Test
    public void invalidPassword() {
        loginPage.enterEmail("testQA311023@gmail.com");
        loginPage.enterPassword("Milla");

        loginPage.getErrorMassageText().shouldBe(Condition.visible).shouldHave(text("You have entered incorrect username or password. Please try again.")); 
    }


    @Test
    public void notRegisteredUsername() {
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("Milla2103");

        loginPage.getErrorMassageText().shouldBe(Condition.visible).shouldHave(text("You have entered incorrect username or password. Please try again."));
    }
}
