package com.kinorium.ru.pages.components.auth;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthWindow {
    private final SelenideElement root = $("#modalAuthWindow");
    private HelloDialog helloDialog;
    private LoginDialog loginDialog;
    private RegistrationDialog registrationDialog;

    @Step("Проверяем, что окно авторизации отображается")
    public AuthWindow shouldBeVisible() {
        root.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка 'Назад' отображается")
    public AuthWindow shouldHaveBackButton() {
        getBackButton().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка 'Закрыть' отображается")
    public AuthWindow shouldHaveCloseButton() {
        getCloseButton().shouldBe(visible);
        return this;
    }

    private SelenideElement getBackButton() {
        return root.$("button.back");
    }

    private SelenideElement getCloseButton() {
        return root.$("button.close");
    }

    public HelloDialog getHelloDialog() {
        if (helloDialog == null) {
            helloDialog = new HelloDialog();
        }
        return helloDialog;
    }

    public LoginDialog getLoginDialog() {
        if (loginDialog == null) {
            loginDialog = new LoginDialog();
        }
        return loginDialog;
    }

    public RegistrationDialog getRegistrationDialog() {
        if (registrationDialog == null) {
            registrationDialog = new RegistrationDialog();
        }
        return registrationDialog;
    }
}
