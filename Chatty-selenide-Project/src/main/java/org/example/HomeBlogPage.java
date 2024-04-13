package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class HomeBlogPage {
    private SelenideElement headerUser = $(byClassName("header__user"));
    private SelenideElement logo = $x("//a[contains(@href,'/homeblog')]");  // naxozdenie logo
    private SelenideElement myDraftTumbler = $x("//span[normalize-space()='My drafts']");
    private ElementsCollection  postContent =  $$(byClassName("post-content__top"));//post-content__top
    private SelenideElement myPostsTumbler = $("label[for='myPostsId']");
    private ElementsCollection allMyPosts = $$ (byClassName("posts__section"));


    public void assertMyPostsTumblerDisabled() {
        // Проверяем, что тумблер myPosts отключен
        myPostsTumbler.shouldNotBe(checked);
    }

    public String getTitleOfLastPost() {
        return allMyPosts.last().find(By.className("post-content__top")).getText();
    }

    public void deletePost(String postTitle) {
        allMyPosts.filterBy(text(postTitle)).first().click(); // Предполагается, что заголовки уникальны
        // Ваш код для удаления поста
    }


    public void chooseMyPosts(String postTitle) {
        allMyPosts.filterBy(text(postTitle)).shouldHave(sizeGreaterThan(0));
    }
    public  void clickOnMyPostsTumbler(){
        myPostsTumbler.click();
    }
    public void checkPost(String postTitle) {
        postContent.filterBy(text(postTitle)).shouldHave(sizeGreaterThan(0));
    }


    public void clickOnMyDraftTumbler(){
        myDraftTumbler.click();
    }

    public SelenideElement getLogo() {
        return logo;
    }
    public SelenideElement getHeaderUser() {
        return headerUser;
    }
    public boolean headerUserIsDisplayed(){
        return headerUser.isDisplayed();
    }
}
