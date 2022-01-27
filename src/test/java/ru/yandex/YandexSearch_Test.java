package ru.yandex;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class YandexSearch_Test {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    String text = "тест";

    /**
     * Проверка поиска в яндекс без Page Object
     */
    @Test
    public void yandex_search_test() {

        open("https://yandex.ru/");
        $(By.xpath("//*[@class='input__box']/input")).setValue("тест").pressEnter();
        $(By.xpath("//*[@id='search-result']")).shouldBe(visible);
        $$(".desktop-card").shouldHave(sizeGreaterThan(10));
        $(".desktop-card").shouldHave(text(text));
    }

    /**
     * Проверка поиска в яндекс с Page Object
     */
    @Test
    public void yandex_search_with_page_object_test() {

        mainPage.openPage().doSearchRequest(text);
        searchResultPage.searchResultsShouldBePresent();
        searchResultPage.searchResultsCountShouldBeMoreThan(10);
        searchResultPage.firstCardShouldHaveText(text);
    }
}
