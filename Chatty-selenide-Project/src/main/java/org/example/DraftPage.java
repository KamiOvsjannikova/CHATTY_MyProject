package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class DraftPage {
    private SelenideElement messageTextDraftSaveSuccessfully = $x("//div[@class='text-draftsaved']");//pridumalaama v TZ net
    private ElementsCollection post = $$(byClassName("post-content__top"));//naxozu kollekciju post // .post .post-content

    public void checkDraftPostWithTitleExists(String postTitle) {
        post.filterBy(text(postTitle)).shouldHave(sizeGreaterThan(0));
    }
}





//    public SelenideElement getMessageTextDraftSaveSuccessfully() {
//        return messageTextDraftSaveSuccessfully;
//    }
//    public ElementsCollection getPost() {
//        return post;
//    }
//    public void inputSearchRequest(String Hallo){
//
//        post.texts();
//    }
//
//    public void messageTextIsDisplayed() {
//        getMessageTextDraftSaveSuccessfully().shouldHave(text("Draft save successfully"));
//    }

