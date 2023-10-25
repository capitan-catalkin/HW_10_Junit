package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class WikiPage {
    SelenideElement tabNavigation = $("#p-views"),
    leftSidebar = $("#p-participation .vector-menu-content"),

    language = $("#mw-panel");


    public WikiPage openPage() {
        open("");
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
        $$("#p-views span").filter(visible).shouldHave(CollectionCondition.texts(value));
        return this;
    }


}
