import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.*;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
public class BaseTest {
    final String BASE_URL = "http://chatty.telran-edu.de:8089/login";

    @Before
    public void setUp() {
        Configuration.timeout = 10000;
        open(BASE_URL);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
        RegistrationPage registrationPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        AdminPanelUsersPage usersPage = new AdminPanelUsersPage();
        HomeBlogPage homeBlogPage = new HomeBlogPage();
        BlogUserPage blogUserPage = new BlogUserPage();
        DraftPage draftPage = new DraftPage();
    }
