package com.kinorium.ru.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.kinorium.ru.pages.MainPage;
import com.kinorium.ru.pages.components.auth.AuthWindow;

@DisplayName("Окно авторизации")
public class AuthWindowTests extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @DisplayName("Проверка формы входа с доступными вариантами авторизации")
    @Test
    void authFormShouldHaveButtonsTest() {
        mainPage.open()
                .clickAuthButton();

        AuthWindow authWindow = new AuthWindow();
        authWindow.shouldBeVisible()
                .shouldHaveCloseButton();

        authWindow.getHelloDialog()
                .shouldBeVisible()
                .shouldHaveRegistrationButton()
                .shouldHaveVkAuthButton()
                .shouldHaveFbAuthButton()
                .shouldHaveGoogleAuthButton()
                .shouldHaveAppleAuthButton()
                .shouldHaveTgAuthIFrame()
                .shouldHaveLoginlink();
    }

    @DisplayName("Проверка формы входа через аккаунт")
    @Test
    void authFormShouldOpenLoginFormTest() {
        mainPage.open()
                .clickAuthButton();

        AuthWindow authWindow = new AuthWindow();
        authWindow.shouldBeVisible()
                .shouldHaveCloseButton();

        authWindow.getHelloDialog()
                .clickLoginLink();

        authWindow.getLoginDialog()
                .shouldBeVisible()
                .shouldHaveEmailInput()
                .shouldHavePasswordInput()
                .shouldHaveSubmitButton()
                .shouldHavePasswordRecoveryLink();

        authWindow.shouldHaveBackButton();
    }

    @DisplayName("Проверка формы регистрации")
    @Test
    void authFormShouldOpenRegistrationFormTest() {
        mainPage.open()
                .clickAuthButton();

        AuthWindow authWindow = new AuthWindow();
        authWindow.shouldBeVisible()
                .shouldHaveCloseButton();

        authWindow.getHelloDialog()
                .clickRegisterButton();

        authWindow.getRegistrationDialog()
                .shouldBeVisible()
                .shouldHaveFirstNameInput()
                .shouldHaveLastNameInput()
                .shouldHaveEmailInput()
                .shouldHavePasswordInput()
                .shouldHaveConfirmPasswordInput()
                .shouldHaveAgreementLink();

        authWindow.shouldHaveBackButton();
    }
}
