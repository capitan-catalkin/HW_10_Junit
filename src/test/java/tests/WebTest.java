package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.WikiPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverConditions.url;

public class WebTest extends TestBase{
    WikiPage wikiPage = new WikiPage();


    @CsvSource(value = {
            "Читать, https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0",
            "Просмотр кода, https://ru.wikipedia.org/w/index.php?title=%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0&action=edit",
            "История, https://ru.wikipedia.org/w/index.php?title=%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0&action=history"
    })
    @Tag("Tab")
    @ParameterizedTest(name = "При нажатии на вкладку {0} открывается страница {1}")
    void openLink( String tab, String urlPage){
        wikiPage.openPage();
        wikiPage.pressTab(tab);
        wikiPage.checkUrl(urlPage);
    }

    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest
    @Tag("Tab")
    void leftSidebar(String tab, String urlPage){
        wikiPage.openPage();
        wikiPage.checkLeftSidebar(tab);
        wikiPage.checkUrl(urlPage);
    }

    static Stream<Arguments> languageTabTest(){
        return Stream.of(
                Arguments.of(Language.Italiano, List.of("Leggi", "Visualizza sorgente", "Cronologia")),
                Arguments.of(Language.English, List.of("Read", "View source", "View history")),
                Arguments.of(Language.Українська, List.of("Читати", "Переглянути код", "Переглянути історію"))
        );
    }
    @MethodSource
    @ParameterizedTest
    void languageTabTest(Language language, List<String> expectedTab){
        wikiPage.openPage();
        wikiPage.checkLanguage(language.name());
        wikiPage.checkLanguageTab(expectedTab);


    }

}
