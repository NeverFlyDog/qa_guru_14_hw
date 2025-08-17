package com.kinorium.ru.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.params.provider.Arguments;

import java.net.URI;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage {
    private final SelenideElement welcomeSlider = $(".welcomeSlider");
    private final SelenideElement searchBox = $(".topMenu__Search");
    private final ElementsCollection subMenuOpener = $$(".submenu-opener");
    private final SelenideElement authButton = $(".auth_button");

    public static Stream<Arguments> mainMenuOptionsProvider() {
        return Stream.of(
                Arguments.of("Премьеры", "/movies/"),
                Arguments.of("Все фильмы", "/R2D2/"),
                Arguments.of("Сериалы", "/shows/"),
                Arguments.of("Лента", "/feed/"),
                Arguments.of("Видео", "/videos/")
        );
    }

    public static Stream<Arguments> mainMenuHoverOptionsProvider() {
        return Stream.of(
                Arguments.of(
                        "Премьеры",
                        List.of("В кино", "Онлайн", "Скоро")
                ),
                Arguments.of(
                        "Все фильмы",
                        List.of("Поиск фильмов", "Коллекции", "Премии и награды", "Рекомендации", "Поиск по именам")
                ),
                Arguments.of(
                        "Сериалы",
                        List.of("Популярные", "Мои сериалы", "Мой календарь")
                ),
                Arguments.of(
                        "Лента",
                        List.of("Лента друзей", "Избранные отзывы", "Блоги пользователей", "Новости кино")
                ),
                Arguments.of(
                        "Видео",
                        List.of("Трейлеры", "Обзоры премьер")
                )
        );
    }

    @Step("Открываем главную страницу")
    public MainPage open() {
        Selenide.open("/");

        welcomeSlider.shouldBe(visible);
        return this;
    }

    @Step("Нажимаем на кнопку входа")
    public MainPage clickAuthButton() {
        authButton.click();
        return this;
    }

    public MainPage clickMainMenuOption(String optionName) {
        findMainMenuOption(optionName).click();
        return this;
    }

    @Step("Проверяем путь открывшейся страницы")
    public void shouldOpenPage(String expectedPath) {
        URI currentUri = URI.create(WebDriverRunner.url());
        assertTrue(
                currentUri.getPath().startsWith(expectedPath),
                "Expected path that starts with " + expectedPath
        );
    }

    @Step("Наводим курсор на опцию главного меню")
    public MainPage hoverOverMainMenuOption(String optionName) {
        findMainMenuOption(optionName).hover();
        return this;
    }

    @Step("Проверяем, что при наведении на опцию главного меню отображается корректное подменю")
    public void mainMenuOptionShouldHaveSubmenu(String optionName, List<String> submenuOptions) {
        SelenideElement submenu = findMainMenuOption(optionName)
                .parent()
                .$("ul.submenu")
                .shouldBe(visible);

        ElementsCollection options = submenu.$$("li");
        for (int i = 0; i < submenuOptions.size() - 1; i++) {
            options.get(i)
                    .$(".title")
                    .shouldHave(exactText(submenuOptions.get(i)));
        }
    }

    private SelenideElement findMainMenuOption(String optionName) {
        return subMenuOpener.findBy(exactText(optionName));
    }
}
