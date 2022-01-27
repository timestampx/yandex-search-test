package ru.yandex;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/**
 * Элементы главной страницы и методы работы с ней
 */
public class MainPage {

    private String url = "https://yandex.ru/";
    private final SelenideElement searchInput = $(By.xpath("//*[@class='input__box']/input"));

    /**
     * Открываем урл главной страницы
     * @return MainPage
     */
    public MainPage openPage() {
        open(this.url);
        return this;
    }

    /**
     * Выполнить поисковый запрос
     * @param value
     * @return
     */
    public void doSearchRequest(String value) {
        searchInput.setValue(value).pressEnter();
    }
}
