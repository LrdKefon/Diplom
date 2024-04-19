package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.steps.CustomViewActions.elementWaiting;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AboutPage;
import ru.iteco.fmhandroid.ui.elements.MainPaige;
import ru.iteco.fmhandroid.ui.elements.NewsPage;
import ru.iteco.fmhandroid.ui.elements.QuotationPage;

public class MainSteps {


    @Step("Переход в блок News")
    public static void goToTheNews() {
        MainPaige.iconBurgerButton.check(matches(isDisplayed()));
        MainPaige.iconBurgerButton.perform(click());
        MainPaige.newsOfBurger.check(matches(isDisplayed()));
        MainPaige.newsOfBurger.perform(click());
        NewsPage.pageOfNews.check(matches(isDisplayed()));
    }

    @Step("Переход в блок About")
    public static void goToTheAbout() {
        MainPaige.iconBurgerButton.check(matches(isDisplayed()));
        MainPaige.iconBurgerButton.perform(click());
        MainPaige.newsOfBurger.check(matches(isDisplayed()));
        MainPaige.aboutOfBurger.perform(click());
        AboutPage.versionAboutPage.check(matches(isDisplayed()));
    }


    @Step("Переход в блок Тематические цитаты")
    public static void goToTheQuotation() {
        MainPaige.iconQuotation.check(matches(isDisplayed()));
        MainPaige.iconQuotation.perform(click());
        QuotationPage.pageOfQuotation.check(matches(isDisplayed()));
    }


}
