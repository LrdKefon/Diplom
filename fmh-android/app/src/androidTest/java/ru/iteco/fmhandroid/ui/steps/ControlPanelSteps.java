package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.contrib.RecyclerViewActions;

import android.view.View;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.ControlPanelPage;

public class ControlPanelSteps {
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    CustomViewActions customViewActions = new CustomViewActions();

    @Step("Кликнуть на кнопку создать новость")
    public void clickCreateNewsButton() {
        controlPanelPage.ButtonCreateNews.check(matches(isDisplayed()));
        controlPanelPage.ButtonCreateNews.perform(click());
    }


    @Step("Удалить новость")
    public void clickDeleteNewsButton(String title) {
        controlPanelPage.newsRecyclerList
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(title)),
                        customViewActions.clickChildViewWithId(R.id.delete_news_item_image_view)));
        onView(controlPanelPage.ButtonAgreement()).perform(click());

    }

    @Step("Кликнуть на кнопку редактировать новость")
    public void clickEditButton(String title) {
        controlPanelPage.newsRecyclerList
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(title)),
                        customViewActions.clickChildViewWithId(R.id.edit_news_item_image_view)));

    }

    @Step("Переключить свитч кнпоку активности у новости и сохранить ихменения")
    public void clickSwitcherActive() {
        controlPanelPage.switchAction.check(matches(isDisplayed()));
        controlPanelPage.switchAction.perform(click());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
        controlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }

    @Step("Заполнить поля новости")
    public void fillFieldsNews(String description, String titleName) {
        onView(controlPanelPage.ButtonChoseCategory()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChoseCategory()).perform(click());
        onView(controlPanelPage.categoryAnnouncement()).check(matches(isDisplayed()));
        onView(controlPanelPage.categoryAnnouncement()).perform(click(), replaceText("Объявление"), closeSoftKeyboard());
        onView(controlPanelPage.titleCreate()).check(matches(isDisplayed()));//
        onView(controlPanelPage.titleCreate()).perform(click(), replaceText(titleName), closeSoftKeyboard());//
        onView(controlPanelPage.ButtonPublishDate()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonPublishDate()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonChooseTime()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChooseTime()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
    }

    @Step("Заполнить поля новости, роле Категория пустое")
    public void fillFieldsNewsCategoryEmpty(String description, String titleName) {
        onView(controlPanelPage.titleCreate()).check(matches(isDisplayed()));//
        onView(controlPanelPage.titleCreate()).perform(click(), replaceText(titleName), closeSoftKeyboard());//
        onView(controlPanelPage.ButtonPublishDate()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonPublishDate()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonChooseTime()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChooseTime()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
    }

    @Step("Поле категория пустое")
    public void checkInformationMessageEmptyCategoryField(String text, View decorView) {//реализовал через тоаст проверку высплывающего сообщения
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Step("Редактировать существующую новость")
    public void editCreatedNews(String description) {
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
        controlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }
}
