package com.kinorium.ru.pages.components.auth;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HelloDialog {
    private final SelenideElement formRoot = $("form.hello.dialog");
    private final SelenideElement vkAuthButton = $("button.vkAuth");
    private final SelenideElement fbAuthButton = $("button.fbAuth");
    private final SelenideElement gAuthButton = $("button.gAuth");
    private final SelenideElement aAuthButton = $("button.aAuth");
    private final SelenideElement tgAuthIFrame = $("iframe#telegram-login-KinoriumRuBot");

    @Step("Проверяем, что форма входа отображается")
    public HelloDialog shouldBeVisible() {
        formRoot.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка регистрации отображается")
    public HelloDialog shouldHaveRegistrationButton() {
        getRegisterButton().shouldBe(visible);
        return this;
    }

    @Step("Нажимаем на кнопку регистрации")
    public HelloDialog clickRegisterButton() {
        getRegisterButton().click();
        return this;
    }

    @Step("Нажимаем на кнопку авторизации через аккаунт")
    public HelloDialog clickLoginLink() {
        getLoginLink().click();
        return this;
    }

    @Step("Проверяем, что кнопка авторизации через VK отображается")
    public HelloDialog shouldHaveVkAuthButton() {
        vkAuthButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка авторизации через FB отображается")
    public HelloDialog shouldHaveFbAuthButton() {
        fbAuthButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка авторизации через Google отображается")
    public HelloDialog shouldHaveGoogleAuthButton() {
        gAuthButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка авторизации через Apple отображается")
    public HelloDialog shouldHaveAppleAuthButton() {
        aAuthButton.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что блок авторизации через Telegram отображается")
    public HelloDialog shouldHaveTgAuthIFrame() {
        tgAuthIFrame.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка авторизации с помощью аккаунта отображается")
    public HelloDialog shouldHaveLoginlink() {
        getLoginLink().shouldBe(visible);
        return this;
    }

    private SelenideElement getRegisterButton() {
        return formRoot.$$("button").findBy(text("Регистрация"));
    }

    private SelenideElement getLoginLink() {
        return formRoot.$$("a").findBy(text("У меня уже есть аккаунт"));
    }
}
