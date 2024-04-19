package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AboutPage;

public class AboutPageSteps {
    @Step("Переход по ссылке Политика конфиденциальности")
    public static void goToTheLinkPrivacyPolicy() {
        AboutPage.linkPrivacyPolicyLink.check(matches(isDisplayed()));
        AboutPage.linkPrivacyPolicyLink.perform(click());
        AboutPage.policyInformation.check(matches(isDisplayed()));
    }

    @Step("Переход по ссылке Пользовательское соглашение")
    public static void goToTheLinkTermsOfUse() {
        AboutPage.linkTermsOfUseLink.check(matches(isDisplayed()));
        AboutPage.linkTermsOfUseLink.perform(click());
        AboutPage.termsInformation.check(matches(isDisplayed()));
    }


}