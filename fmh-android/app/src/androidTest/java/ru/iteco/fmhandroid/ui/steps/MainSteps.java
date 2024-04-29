package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;


import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AboutPage;
import ru.iteco.fmhandroid.ui.elements.MainPaige;
import ru.iteco.fmhandroid.ui.elements.NewsPage;
import ru.iteco.fmhandroid.ui.elements.QuotationPage;

public class MainSteps {
    MainPaige mainPaige = new MainPaige();
    NewsPage newsPage = new NewsPage();
    AboutPage aboutPage = new AboutPage();
    QuotationPage quotationPage = new QuotationPage();


    @Step("Переход в блок News")
    public void goToTheNews() {
        mainPaige.iconBurgerButton.check(matches(isDisplayed()));
        mainPaige.iconBurgerButton.perform(click());
        mainPaige.newsOfBurger.check(matches(isDisplayed()));
        mainPaige.newsOfBurger.perform(click());
        newsPage.pageOfNews.check(matches(isDisplayed()));
    }

    @Step("Переход в блок About")
    public void goToTheAbout() {
        mainPaige.iconBurgerButton.check(matches(isDisplayed()));
        mainPaige.iconBurgerButton.perform(click());
        mainPaige.newsOfBurger.check(matches(isDisplayed()));
        mainPaige.aboutOfBurger.perform(click());
        aboutPage.versionAboutPage.check(matches(isDisplayed()));
    }


    @Step("Переход в блок Тематические цитаты")
    public void goToTheQuotation() {
        mainPaige.iconQuotation.check(matches(isDisplayed()));
        mainPaige.iconQuotation.perform(click());
        quotationPage.pageOfQuotation.check(matches(isDisplayed()));
    }


}
