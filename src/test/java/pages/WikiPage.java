package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class WikiPage {
    SelenideElement tabNavigation = $("#p-views"),
    headLine = $(".main-top-header"),
    leftSidebar = $("#p-participation .vector-menu-content"),

    language = $("#mw-panel"),
    languageTab = $("#p-views");


    public WikiPage openPage() {
        open("");
        headLine.shouldHave(text("Добро пожаловать в Википедию"));
        return this;
    }

    public WikiPage pressTab(String value) {
       tabNavigation.$(byText(value)).click();
       return  this;
   }

   public WikiPage checkUrl (String value){
       webdriver().shouldHave(url(value));
       return  this;
   }
   public WikiPage checkLeftSidebar(String value){
        leftSidebar.$(byText(value)).click();
        return this;
   }
   public WikiPage checkLanguage(String value){
        language.find(byText(value)).click();
       return this;
   }
    public WikiPage checkLanguageTab(List<String> value){
        languageTab.shouldHave(CollectionCondition.texts(value));
        return this;
    }


}
