import org.example.AdminPanelUsersPage;
import org.junit.Test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class AdminPanelUserPageTest extends BaseTest {
    private void login() {
        loginPage.enterEmail("testQA311023@gmail.com");
        loginPage.enterPassword("Milla2103");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void successEditName() throws InterruptedException {
        //snachala login
        login();
        //searchBy email
        usersPage.enterSearchByEmail("testQA@gmail.com");
        usersPage.clickOnSearchButton();
//        usersPage.clickOnLoadMore();
//        usersPage.getSearchEmailTest();
//        sleep(5000);// pokazivaet nam 10 sekund
        usersPage.clickOnEditIcon();
//        sleep(5000);
        usersPage.clickOnEditButton();
//        sleep(5000);
        usersPage.enterName("Milla");
        usersPage.clickOnSaveButton();
        //proverka
        usersPage.getCheckChangeName().shouldHave(value("Milla"));
    }
    @Test
    public void successEditSurname() throws InterruptedException {
        //snachala login
        login();
        //searchBy email
        usersPage.enterSearchByEmail("testQA@gmail.com");
        usersPage.clickOnSearchButton();
//        usersPage.clickOnLoadMore();
//        usersPage.getSearchEmailTest();
//        sleep(5000);// pokazivaet nam 10 sekund
        usersPage.clickOnEditIcon();
//        sleep(5000);
        usersPage.clickOnEditButton();
        usersPage.enterSurname("Luntikova");
        usersPage.clickOnSaveButton();
        sleep(5000);
        //proverka
        usersPage.getCheckChangeSurname().shouldHave(value("Luntikova"));
        sleep(5000);
    }
    @Test
    public void successEditPhone() throws InterruptedException {
        // login
        login();
        //searchBy email
        usersPage.enterSearchByEmail("testQA@gmail.com");
        usersPage.clickOnSearchButton();
        usersPage.clickOnEditIcon();
//        sleep(5000);
        usersPage.clickOnEditButton();
        usersPage.enterPhone("+37128697892");
        usersPage.clickOnSaveButton();
        //proverka
        usersPage.getCheckChangePhone().shouldHave(value("+37128697892"));
    }

    @Test
    public void successDeleteAccount() throws InterruptedException {
        //snachala login
        login();
        //iwu nuznij email v search
        usersPage.enterSearchByEmail("ilona@gmail.com");
        usersPage.clickOnSearchButton();
        sleep(5000);
        usersPage.clickOnTrashIcon();
        //proverka
        usersPage.clearSearchByEmail();
        sleep(5000);
        usersPage.enterSearchByEmail("ilona@gmail.com");
        usersPage.clickOnSearchButton();
        usersPage.getEmailElement().shouldNotHave(text("ilona@gmail.com"));
        sleep(10000);
    }
}