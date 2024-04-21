package org.example;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdminPanelUsersPage {
    private SelenideElement headerUser = $(byClassName("header__user"));//$x("//div[@class='header__user']");
    private SelenideElement logo = $x("//a[contains(@href,'/homeblog')]");  
    private SelenideElement searchByEmail = $("[type='text']");
    private SelenideElement searchButton = $(byClassName("email-btn"));//knopka search
    private SelenideElement editIcon = $x("//span[@data-test='editUserButton']"); // //span[@data-test='editUserButton'] 
    private SelenideElement editButton = $x("//span[@data-test='post-header__plus']");
    private SelenideElement editName = $("[placeholder='Name']"); 
    private SelenideElement editSurname = $("[placeholder='Surname']"); 
    private SelenideElement editPhone = $("[name='phone']");
    private SelenideElement saveButton =$x("//button[@type='submit']");
    private SelenideElement trashIcon = $x("//span[@data-test='deleteUserButton']//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]");
    private SelenideElement tabulaEmail = $x("//*[@id=\"root\"]/div[2]/div/div/table");//$("td:nth-child(3)");
    private SelenideElement checkChangeName = $(byValue("Milla"));
    private SelenideElement checkChangeSurname = $(byValue("Luntikova"));
    private SelenideElement checkChangePhone = $(byValue("+37128697892"));

//metodi
    public SelenideElement getCheckChangePhone(){
    return checkChangePhone;
}
    public SelenideElement getCheckChangeSurname(){
    return checkChangeSurname;
}
    public SelenideElement getCheckChangeName(){
        return checkChangeName;
    }

    public SelenideElement getEmailElement() {
        return tabulaEmail;
    }

    public void clickOnTrashIcon() { 
    trashIcon.click();
    }
    public void clickOnSaveButton(){
        saveButton.click();
    }
    public void enterName(String nameValue){
        editName.setValue(nameValue);
    }
    public void enterSurname(String surnameValue){
        editSurname.setValue(surnameValue);
    }
    public void enterPhone(String phoneValue) {
        editPhone.setValue(phoneValue);
    }
    public  void clickOnEditButton(){
        editButton.click();
    }

    public void clickOnEditIcon() { 
        editIcon.click();
    }
    public void clickOnSearchButton(){
        searchButton.click();
    }
    public void enterSearchByEmail(String searchByEmailValue) {
        //dozdatsja, chto element otobrazaetsja uvelich vremja
        searchByEmail.shouldHave(visible, Duration.ofSeconds(10));
        searchByEmail.setValue(searchByEmailValue);
    }

    public void clearSearchByEmail(){
        searchByEmail.clear();
    }
    
    public SelenideElement getLogo() {
        return logo;
    }

    public SelenideElement getHeaderUser() {
        return headerUser;
    }
}
