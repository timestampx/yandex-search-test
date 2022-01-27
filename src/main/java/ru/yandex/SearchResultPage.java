package ru.yandex;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Элементы страницы результатов поиска и методы работы с ними
 */
public class SearchResultPage {

    private String url = "https://yandex.ru/search/?";
    private final SelenideElement searchResult = $(By.xpath("//*[@id='search-result']"));
    private final ElementsCollection searchResultCards = $$(".desktop-card");
    private final SelenideElement firstCard = $(".desktop-card");

    /**
     * Открываем урл страницы поиска
     * @return MainPage
     */
    public SearchResultPage openPage() {
        open(this.url);
        return this;
    }

    /**
     * Результаты поиска должны отображаться
     */
    public void searchResultsShouldBePresent() {
        searchResult.shouldBe(visible);
    }

    /**
     * Кол-во результатов поиска должно быть больше чем ...
     * @param count
     */
    public void searchResultsCountShouldBeMoreThan(Integer count) {
        searchResultCards.shouldHave(sizeGreaterThan(count));
    }

    /**
     * Первый результат поиска должен содержать текст
     * @param text
     */
    public void firstCardShouldHaveText(String text) {
        firstCard.shouldHave(text(text));
    }
}
