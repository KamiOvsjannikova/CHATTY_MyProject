import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class BlogUserTest extends BaseTest {
    private void login() {
        loginPage.enterEmail("testQA@gmail.com");
        loginPage.enterPassword("Test123456");
        loginPage.clickOnLoginButton();
    }
    Faker faker = new Faker();// dlja raddom pcreate post
    @Test
    public void successCreatePost() throws InterruptedException {
        //snachala login
        login();
        blogUserPage.clickOnCreateAPostButton();
        String postTitle = faker.lorem().sentence();
        blogUserPage.enterTitle(postTitle);
        String description = faker.lorem().paragraph();
        if (description.isEmpty()) {
            description = faker.lorem().characters(1); // Добавляем хотя бы один символ
        } else if (description.length() > 100) {
            description = description.substring(0, 100); // Обрезаем до 100 символов
        }
        blogUserPage.enterDescription(description);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        blogUserPage.clickOnDragNDrop(); //клинкуть на дроп
        sleep(5000);
        blogUserPage.uploadImage(); //картинка
        sleep(5000);
        blogUserPage.clickOnSubmitButton();// dlja sozdanija posta
        sleep(5000);
        homeBlogPage.checkPost(postTitle);
    }

    @Test
    public void successDraftPost() throws InterruptedException {
        //snachala login
        login();
        blogUserPage.clickOnCreateAPostButton();
        String postTitle = faker.lorem().sentence();
        blogUserPage.enterTitle(postTitle);
        String description = faker.lorem().paragraph();
        if (description.isEmpty()) {
            description = faker.lorem().characters(1); // Добавляем хотя бы один символ
        } else if (description.length() > 100) {
            description = description.substring(0, 100); // Обрезаем до 100 символов
        }
        blogUserPage.enterDescription(description);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        blogUserPage.clickOnDragNDrop(); //кликнуть на дроп
        blogUserPage.uploadImage(); //картинка
        blogUserPage.clickOnSaveInDraft(); // save draft
        blogUserPage.clickOnSubmitButton();// для создания поста
        sleep(5000);
        homeBlogPage.clickOnMyDraftTumbler();
        sleep(5000);
        //proverka
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
            description = faker.lorem().characters(1); // Добавляем хотя бы один символ
        } else if (description.length() > 100) {
            description = description.substring(0, 100); // Обрезаем до 100 символов
        }
        blogUserPage.enterDescription(description);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        sleep(5000);
        blogUserPage.clickOnDragNDrop(); //клинкуть на дроп
        sleep(5000);
        blogUserPage.uploadImage(); //картинка
        sleep(5000);
        blogUserPage.clickOnSubmitButton();// dlja sozdanija posta
        sleep(5000);
        homeBlogPage.clickOnMyPostsTumbler();
        String myPostTitle = homeBlogPage.getTitleOfLastPost();
        sleep(5000);
        homeBlogPage.deletePost(myPostTitle);
        sleep(10000);

        homeBlogPage.assertMyPostsTumblerDisabled();
        homeBlogPage.clickOnMyPostsTumbler();
    }

    @Test
    public void createPostWithEmptyTitle() throws InterruptedException {
        login();
        blogUserPage.clickOnCreateAPostButton();
        String description = faker.lorem().paragraph();
        if (description.isEmpty()) {
            description = faker.lorem().characters(1); // Добавляем хотя бы один символ
        } else if (description.length() > 100) {
            description = description.substring(0, 100); // Обрезаем до 100 символов
        }
        blogUserPage.enterDescription(description);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        blogUserPage.clickOnDragNDrop(); //клинкуть на дроп
        blogUserPage.uploadImage(); //картинка
        blogUserPage.clickOnSubmitButton();// dlja sozdanija posta
        blogUserPage.getErrorMassageTextTitle().shouldBe(Condition.visible).shouldHave(text("Impossible to create empty Title.")); // na sajte drugaja owibka
    }
    @Test
    public void createPostWithEmptyDescription() throws InterruptedException {
        login();
        blogUserPage.clickOnCreateAPostButton();
        String postTitle = faker.lorem().sentence();
        blogUserPage.enterTitle(postTitle);
        blogUserPage.enterContent(faker.lorem().paragraphs(1).toString());
        blogUserPage.clickOnDragNDrop(); //клинкуть на дроп
        blogUserPage.uploadImage(); //картинка
        blogUserPage.clickOnSubmitButton();// dlja sozdanija posta
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
            description = faker.lorem().characters(1); // Добавляем хотя бы один символ
        } else if (description.length() > 100) {
            description = description.substring(0, 100); // Обрезаем до 100 символов
        }
        blogUserPage.enterDescription(description);
        blogUserPage.clickOnDragNDrop(); //клинкуть на дроп
        blogUserPage.uploadImage(); //картинка
        blogUserPage.clickOnSubmitButton();// dlja sozdanija posta
        blogUserPage.getErrorMassageTextContent().shouldBe(Condition.visible).shouldHave(text("Impossible to create empty Description."));// na sajte drugaja owibka
    }

}
