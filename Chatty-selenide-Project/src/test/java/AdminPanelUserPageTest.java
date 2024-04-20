import org.junit.Test;
import static com.codeborne.selenide.Condition.*;
import static java.lang.Thread.sleep;


public class AdminPanelUserPageTest extends BaseTest {
    private void login() {
        loginPage.enterEmail("testQA311023@gmail.com");
        loginPage.enterPassword("Milla2103");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void successEditName() throws InterruptedException {
        login();
        usersPage.enterSearchByEmail("testQA@gmail.com");
        usersPage.clickOnSearchButton();
        usersPage.clickOnEditIcon();
        usersPage.clickOnEditButton();
        usersPage.enterName("Milla");
        usersPage.clickOnSaveButton();
        usersPage.getCheckChangeName().shouldHave(value("Milla"));
    }
    @Test
    public void successEditSurname() throws InterruptedException {
        login();
        usersPage.enterSearchByEmail("testQA@gmail.com");
        usersPage.clickOnSearchButton();
        usersPage.clickOnEditIcon();
        usersPage.clickOnEditButton();
        usersPage.enterSurname("Luntikova");
        usersPage.clickOnSaveButton();
        sleep(5000);
        usersPage.getCheckChangeSurname().shouldHave(value("Luntikova"));
        sleep(5000);
    }
    @Test
    public void successEditPhone() throws InterruptedException {
        login();
        usersPage.enterSearchByEmail("testQA@gmail.com");
        usersPage.clickOnSearchButton();
        usersPage.clickOnEditIcon();
        usersPage.clickOnEditButton();
        usersPage.enterPhone("+37128697892");
        usersPage.clickOnSaveButton();
        usersPage.getCheckChangePhone().shouldHave(value("+37128697892"));
    }
    @Test
    public void successDeleteAccount() throws InterruptedException {
        login();
        usersPage.enterSearchByEmail("ilona@gmail.com");
        usersPage.clickOnSearchButton();
        sleep(5000);
        usersPage.clickOnTrashIcon();
        usersPage.clearSearchByEmail();
        sleep(5000);
        usersPage.enterSearchByEmail("ilona@gmail.com");
        usersPage.clickOnSearchButton();
        usersPage.getEmailElement().shouldNotHave(text("ilona@gmail.com"));
        sleep(10000);
    }
}
