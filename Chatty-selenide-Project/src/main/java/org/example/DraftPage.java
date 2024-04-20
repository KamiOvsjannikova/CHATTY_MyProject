package org.example;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class DraftPage {
    private SelenideElement messageTextDraftSaveSuccessfully = $x("//div[@class='text-draftsaved']");//pridumalaama v TZ net
    private ElementsCollection post = $$(byClassName("post-content__top"));//naxozu kollekciju post // .post .post-content

    public void checkDraftPostWithTitleExists(String postTitle) {
        post.filterBy(text(postTitle)).shouldHave(sizeGreaterThan(0));
    }
}
