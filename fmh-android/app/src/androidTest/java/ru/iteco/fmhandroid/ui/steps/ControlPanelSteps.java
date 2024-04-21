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
import static ru.iteco.fmhandroid.ui.elements.ControlPanelPage.newsRecyclerList;
import static ru.iteco.fmhandroid.ui.steps.CustomViewActions.clickChildViewWithId;

import androidx.test.espresso.contrib.RecyclerViewActions;

import android.view.View;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.ControlPanelPage;

public class ControlPanelSteps {
    @Step("Кликнуть на кнопку создать новость")
    public static void clickCreateNewsButton() {
        ControlPanelPage.ButtonCreateNews.check(matches(isDisplayed()));
        ControlPanelPage.ButtonCreateNews.perform(click());
    }


    @Step("Удалить новость")
    public static void clickDeleteNewsButton(String title) {
        newsRecyclerList
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(title)),
                        clickChildViewWithId(R.id.delete_news_item_image_view)));
        onView(ControlPanelPage.ButtonAgreement()).perform(click());
        //onView(allOf(withText(title), isDisplayed())).check(doesNotExist());????

    }

    @Step("Кликнуть на кнопку редактировать новость")
    public static void clickEditButton(String title) {
        newsRecyclerList
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(title)),
                        clickChildViewWithId(R.id.edit_news_item_image_view)));

    }

    @Step("Переключить свитч кнпоку активности у новости и сохранить ихменения")
    public static void clickSwitcherActive() {
        ControlPanelPage.switchAction.check(matches(isDisplayed()));
        ControlPanelPage.switchAction.perform(click());
        onView(ControlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonSave()).perform(click());
        ControlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }

    @Step("Заполнить поля новости")
    public static void fillFieldsNews(String description, String titleName) {
        onView(ControlPanelPage.ButtonChoseCategory()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonChoseCategory()).perform(click());
        onView(ControlPanelPage.categoryAnnouncement()).check(matches(isDisplayed()));
        onView(ControlPanelPage.categoryAnnouncement()).perform(click(), replaceText("Объявление"), closeSoftKeyboard());
        onView(ControlPanelPage.titleCreate()).check(matches(isDisplayed()));//
        onView(ControlPanelPage.titleCreate()).perform(click(), replaceText(titleName), closeSoftKeyboard());//
        onView(ControlPanelPage.ButtonPublishDate()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonPublishDate()).perform(click());
        onView(ControlPanelPage.ButtonAgreement()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonAgreement()).perform(click());
        onView(ControlPanelPage.ButtonChooseTime()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonChooseTime()).perform(click());
        onView(ControlPanelPage.ButtonAgreement()).perform(click());
        onView(ControlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(ControlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonSave()).perform(click());
    }

    @Step("Заполнить поля новости, роле Категория пустое")
    public static void fillFieldsNewsCategoryEmpty(String description, String titleName) {
        onView(ControlPanelPage.titleCreate()).check(matches(isDisplayed()));//
        onView(ControlPanelPage.titleCreate()).perform(click(), replaceText(titleName), closeSoftKeyboard());//
        onView(ControlPanelPage.ButtonPublishDate()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonPublishDate()).perform(click());
        onView(ControlPanelPage.ButtonAgreement()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonAgreement()).perform(click());
        onView(ControlPanelPage.ButtonChooseTime()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonChooseTime()).perform(click());
        onView(ControlPanelPage.ButtonAgreement()).perform(click());
        onView(ControlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(ControlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonSave()).perform(click());
    }

    @Step("Поле категория пустое")
    public static void checkInformationMessageEmptyCategoryField(String text, View decorView) {//реализовал через тоаст проверку высплывающего сообщения
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Step("Редактировать существующую новость")
    public static void editCreatedNews(String description) {
        onView(ControlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(ControlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(ControlPanelPage.ButtonSave()).perform(click());
        ControlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }
}
