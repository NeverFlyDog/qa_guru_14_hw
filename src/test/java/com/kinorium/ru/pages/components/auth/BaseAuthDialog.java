package com.kinorium.ru.pages.components.auth;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public abstract class BaseAuthDialog<T extends BaseAuthDialog<T>> {
    protected final SelenideElement formRoot;

    protected BaseAuthDialog(SelenideElement root) {
        this.formRoot = root;
    }

    @SuppressWarnings("unchecked")
    protected T shouldBeVisible() {
        formRoot.shouldBe(visible);
        return (T) this;
    }
}
