package org.example;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class BlogUserPage {

    private SelenideElement createAPostButton = $x("//span[@data-test='post-header__plus']");////span[@data-test='post-header__plus']//$("[span[data-test='post-header__plus']]");
    private SelenideElement titleInputField = $("[name='title']");
    private SelenideElement descriptionInputField =  $x("//input[@placeholder='Description']");//$("[name='description']");//description
    private SelenideElement contentInputField = $("[name='content']");//content
    private SelenideElement dragNDrop = $(byClassName("post_uploaded_image__7qSWV")); //кнопка по которой загрузить картинку upload file  .post_uploaded_image__7qSWV
    String filePath = "C:\\Users\\kamil\\Downloads\\1710435210941.jpg"; // путь к картинке
    private SelenideElement pictureUploadField = $x("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[4]/input"); // куда клинкуть для загрузки картинки
    private SelenideElement submitButton = $("[type='submit']");
    private SelenideElement myPost = $("div:nth-child(5) div:nth-child(2) div:nth-child(2) h3:nth-child(1)");//$x("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > h3:nth-child(1)");//najti moj opublikovannij post sredi vsex
    private SelenideElement draftTumbler = $("label[for='draftCheckbox']"); // tumbler draft
    private SelenideElement textErrorEmptyTitle = $("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > p:nth-child(2)"); // dlja error message
    private SelenideElement textErrorEmptyDescription = $("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > form:nth-child(1) > div:nth-child(2) > p:nth-child(2)");
    private SelenideElement textErrorEmptyContent = $("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > form:nth-child(1) > div:nth-child(3) > p:nth-child(2)");
    public SelenideElement getErrorMassageTextContent() {
        return textErrorEmptyContent;
    }
    public SelenideElement getErrorMassageTextDescription() {
        return textErrorEmptyDescription;
    }
    public SelenideElement getErrorMassageTextTitle() {
        return textErrorEmptyTitle;
    }


    public  void clickOnSaveInDraft(){
        draftTumbler.click();
    }

    public SelenideElement getMyPostElement() {
        return myPost;
    }
    public void  clickOnSubmitButton(){
        submitButton.click();
    }
    public  void clickOnCreateAPostButton(){
        createAPostButton.click();
    }
    public void uploadImage(){
        pictureUploadField.uploadFile(new File(filePath));
    }
    public void clickOnDragNDrop(){
        dragNDrop.click();
    }

    public void enterContent(String contentValue) {
        contentInputField.shouldHave(visible, Duration.ofSeconds(10));
        contentInputField.setValue(contentValue);
    }

    public void enterDescription(String descriptionValue) {
        descriptionInputField.shouldHave(visible, Duration.ofSeconds(10));
        descriptionInputField.setValue(descriptionValue);
    }

    public void enterTitle(String titleValue) {
        titleInputField.shouldHave(visible, Duration.ofSeconds(10));
        titleInputField.setValue(titleValue);
    }
}
