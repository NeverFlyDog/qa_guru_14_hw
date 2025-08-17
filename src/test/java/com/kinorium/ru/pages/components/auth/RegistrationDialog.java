package com.kinorium.ru.pages.components.auth;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationDialog extends BaseAuthDialog<RegistrationDialog> {

    protected RegistrationDialog() {
        super($("form.intReg.dialog"));
    }

    @Override
    @Step("Проверяем, что форма регистрации отображается")
    public RegistrationDialog shouldBeVisible() {
        return super.shouldBeVisible();
    }

    @Step("Проверяем, что поле ввода имени отображается")
    public RegistrationDialog shouldHaveFirstNameInput() {
        getFirstNameInput().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что поле ввода фамилии отображается")
    public RegistrationDialog shouldHaveLastNameInput() {
        getLastNameInput().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что поле ввода e-mail отображается")
    public RegistrationDialog shouldHaveEmailInput() {
        getEmailInput().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что поле ввода пароля отображается")
    public RegistrationDialog shouldHavePasswordInput() {
        getPasswordInput().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что поле ввода пароля для подтверждения отображается")
    public RegistrationDialog shouldHaveConfirmPasswordInput() {
        getConfirmPasswordInput().shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что ссылка на условия пользования сервисом отображается")
    public RegistrationDialog shouldHaveAgreementLink() {
        getAgreementLink().shouldBe(visible);
        return this;
    }

    private SelenideElement getFirstNameInput() {
        return formRoot.$("label[name='name'] input");
    }

    private SelenideElement getLastNameInput() {
        return formRoot.$("label[name='surname'] input");
    }

    private SelenideElement getEmailInput() {
        return formRoot.$("input[type='email']");
    }

    private SelenideElement getPasswordInput() {
        return formRoot.$("input[type='email']");
    }

    private SelenideElement getConfirmPasswordInput() {
        return formRoot.$("label[name='pass_validate'] input");
    }

    private SelenideElement getAgreementLink() {
        return formRoot.$("a[href='/agreement/']");
    }
}
