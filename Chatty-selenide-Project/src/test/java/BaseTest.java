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
        //vremja ozidanija
        Configuration.timeout = 10000;
//        Configuration.fastSetValue= true;
//        Configuration.clickViaJs= true; // mozet ponadobistja esli bannerom zakrito
//        Configuration.browser = "firefox";
//        Configuration.browserSize = "300x300";
//        Configuration.headless = true; //okno ne otkrivaetsja
//        open(REG_URL);
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open(BASE_URL); // argument - eto ssilka //open -eto dlja otkritija str
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());//sluwaet chto proisxodit i printscreen scrennshot

    }


    @After
    public void tearDown() {
        closeWebDriver();//zakritj browser
    }
        RegistrationPage registrationPage = new RegistrationPage();
        LoginPage loginPage = new LoginPage();
        AdminPanelUsersPage usersPage = new AdminPanelUsersPage();
        HomeBlogPage homeBlogPage = new HomeBlogPage();
        BlogUserPage blogUserPage = new BlogUserPage();
        DraftPage draftPage = new DraftPage();

    }




