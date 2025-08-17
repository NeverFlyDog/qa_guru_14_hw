package com.kinorium.ru.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import com.kinorium.ru.pages.components.auth.AuthWindow;
import com.kinorium.ru.pages.MainPage;

import java.util.List;

@DisplayName("Главная страница")
public class MainPageTests extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @DisplayName("При клике на опцию главного меню открывается корректная страница")
    @ParameterizedTest
    @MethodSource("com.kinorium.ru.pages.MainPage#mainMenuOptionsProvider")
    void mainMenuOptionShouldOpenPage(String menuOption, String path) {
        mainPage.open()
                .clickMainMenuOption(menuOption)
                .shouldOpenPage(path);
    }

    @DisplayName("При наведении на опцию главного меню отображается подменю с корректным списком")
    @ParameterizedTest
    @MethodSource("com.kinorium.ru.pages.MainPage#mainMenuHoverOptionsProvider")
    void shouldDisplayCorrectOptionsOnMainMenuOptionHoverTest(String mainMenuOption, List<String> submenuOptions) {
        mainPage.open()
                .hoverOverMainMenuOption(mainMenuOption)
                .mainMenuOptionShouldHaveSubmenu(mainMenuOption, submenuOptions);
    }

    @DisplayName("При нажатии на кнопку входа открывается окно авторизации")
    @Test
    void authButtonOpensAuthModalTest() {
        mainPage.open()
                .clickAuthButton();

        AuthWindow authWindow = new AuthWindow();
        authWindow.shouldBeVisible();
    }
}


