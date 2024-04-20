import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.lang.String;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static java.lang.Thread.sleep;

public class BlogUserTest extends BaseTest {
    private void login() {
        loginPage.enterEmail("testQA@gmail.com");
        loginPage.enterPassword("Test123456");
        loginPage.clickOnLoginButton();
    }

    Faker faker = new Faker();

    @Test
    public void successCreatePost() throws InterruptedException {
        login();
        blogUserPage.clickOnCreateAPostButton();
        String postTitle = faker.lorem().sentence();
        blogUserPage.enterTitle(postTitle);
        String description = faker.lorem().paragraph();
        if (description.isEmpty()) {
            description = faker.lorem().characters(1);
        } else if (description.length() > 100) {
            description = description.substring(0, 100);
        }
        blogUserPage.enterDescription(description);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        blogUserPage.clickOnDragNDrop();
        sleep(5000);
        blogUserPage.uploadImage();
        sleep(5000);
        blogUserPage.clickOnSubmitButton();
        sleep(5000);
        homeBlogPage.checkPost(postTitle);
    }

    @Test
    public void successDraftPost() throws InterruptedException {
        login();
        blogUserPage.clickOnCreateAPostButton();
        String postTitle = faker.lorem().sentence();
        blogUserPage.enterTitle(postTitle);
        String description = faker.lorem().paragraph();
        if (description.isEmpty()) {
            description = faker.lorem().characters(1);
        } else if (description.length() > 100) {
            description = description.substring(0, 100);
        }
        blogUserPage.enterDescription(description);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        blogUserPage.clickOnDragNDrop();
        blogUserPage.uploadImage();
        sleep(5000);
        blogUserPage.clickOnSaveInDraft(); // save draft
        blogUserPage.clickOnSubmitButton();
        homeBlogPage.clickOnMyDraftTumbler();
        sleep(5000);
        draftPage.checkDraftPostWithTitleExists(postTitle);
    }

    @Test
    public void successDeletePost() throws InterruptedException {
        login();
        blogUserPage.clickOnCreateAPostButton();
        String postTitle = faker.lorem().sentence();
        blogUserPage.enterTitle(postTitle);
        String description = faker.lorem().paragraph();
        if (description.isEmpty()) {
            description = faker.lorem().characters(1);
        } else if (description.length() > 100) {
            description = description.substring(0, 100);
        }
        blogUserPage.enterDescription(description);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        sleep(5000);
        blogUserPage.clickOnDragNDrop(); //kliknutj na drop
        sleep(5000);
        blogUserPage.uploadImage(); //kartinka
        sleep(5000);
        blogUserPage.clickOnSubmitButton();// dlja sozdanija posta
        sleep(5000);
        homeBlogPage.clickOnMyPostsTumbler();
        String myPostTitle = homeBlogPage.getTitleOfLastPost();
        sleep(5000);
        homeBlogPage.deletePost(myPostTitle);
        WebDriverRunner.getWebDriver().navigate().refresh();
        homeBlogPage.clickOnMyPostsTumbler();
        boolean isPostPresent = false;
        for (SelenideElement post : homeBlogPage.getAllPosts()) {
            postTitle = post.find(By.className("post-content__top")).getText();
            if (postTitle.equals(myPostTitle)) {
                isPostPresent = true;
                break;
            }
        }
    }

    @Test
    public void createPostWithEmptyTitle() throws InterruptedException {
        login();
        blogUserPage.clickOnCreateAPostButton();
        String description = faker.lorem().paragraph();
        if (description.isEmpty()) {
            description = faker.lorem().characters(1);
            description = description.substring(0, 100);
        }
        blogUserPage.enterDescription(description);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        blogUserPage.clickOnDragNDrop();
        blogUserPage.uploadImage();
        blogUserPage.clickOnSubmitButton();
        blogUserPage.getErrorMassageTextTitle().shouldBe(Condition.visible).shouldHave(text("Impossible to create empty Title.")); // na sajte drugaja owibka
    }

    @Test
    public void createPostWithEmptyDescription() throws InterruptedException {
        login();
        blogUserPage.clickOnCreateAPostButton();
        String postTitle = faker.lorem().sentence();
        blogUserPage.enterTitle(postTitle);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        blogUserPage.clickOnDragNDrop();
        blogUserPage.uploadImage();
        blogUserPage.clickOnSubmitButton();
        blogUserPage.getErrorMassageTextDescription().shouldBe(Condition.visible).shouldHave(text("Impossible to create empty Description."));// na sajte drugaja owibka
    }

    @Test
    public void createPostWithEmptyContent() throws InterruptedException {
        login();
        blogUserPage.clickOnCreateAPostButton();
        String postTitle = faker.lorem().sentence();
        blogUserPage.enterTitle(postTitle);
        String description = faker.lorem().paragraph();
        if (description.isEmpty()) {
            description = faker.lorem().characters(1);
        } else if (description.length() > 100) {
            description = description.substring(0, 100);
        }
        blogUserPage.enterDescription(description);
        blogUserPage.clickOnDragNDrop();
        blogUserPage.uploadImage();
        blogUserPage.clickOnSubmitButton();
        blogUserPage.getErrorMassageTextContent().shouldBe(Condition.visible).shouldHave(text("Impossible to create empty Description."));// na sajte drugaja owibka
    }
}
