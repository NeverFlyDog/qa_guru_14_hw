package com.kinorium.ru.pages.components.auth;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginDialog {
    private final SelenideElement formRoot = $("form.intAuth.dialog");

    @Step("Проверяем, что форма логина отображается")
    public LoginDialog shouldBeVisible() {
        formRoot.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что поле 'email' отображается")
    public LoginDialog shouldHaveEmailInput() {
        getEmailInput().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что поле 'password' отображается")
    public LoginDialog shouldHavePasswordInput() {
        getPasswordInput().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка входа отображается")
    public LoginDialog shouldHaveSubmitButton() {
        getSubmitButton().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что отображается кнопка восстановления пароля")
    public LoginDialog shouldHavePasswordRecoveryLink() {
        getPasswordRecoveryLink().shouldBe(visible);
        return this;
    }

    private SelenideElement getEmailInput() {
        return formRoot.$("input[name='email']");
    }

    private SelenideElement getPasswordInput() {
        return formRoot.$("input[name='password']");
    }

    private SelenideElement getSubmitButton() {
        return formRoot.$("button.enter-button");
    }

    private SelenideElement getPasswordRecoveryLink() {
        return formRoot.$("a.lostPass");
    }
}
